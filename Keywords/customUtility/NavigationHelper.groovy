package customUtility

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class NavigationHelper {
	def clickTopMenu(String menuLabel) {
		def to = new TestObjectHelper()

		WebUI.click(to.getTestObjectWithXpathTextMatch('//ul/li/div//p', menuLabel))
	}

	def clickSubMenu(String menuLabel, String submenuLabel) {
		def to = new TestObjectHelper()

		WebUI.click(to.getTestObjectWithXpathTextMatch("//ul/li/div//p[text()='$menuLabel' or . = '$menuLabel']/parent::div/following-sibling::div/descendant::ul/li/div", submenuLabel))
	}

	@Keyword
	def Boolean clickTopMenuAndValidateHeader(String menuLabel, String headerLabel) {
		clickTopMenu(menuLabel)
		return validatePageHeader(headerLabel)
	}

	@Keyword
	def Boolean clickSubmenuAndValidateHeader(String menuLabel, String submenuLabel, String headerLabel) {
		return clickSubmenuAndValidateHeader(menuLabel, submenuLabel, headerLabel, false)
	}

	@Keyword
	def Boolean clickSubmenuAndValidateHeader(String menuLabel, String submenuLabel, String headerLabel, Boolean openTopMenuFirst) {
		if (openTopMenuFirst) {
			clickTopMenu(menuLabel)
		}

		clickSubMenu(menuLabel, submenuLabel)
		return validatePageHeader(headerLabel)
	}

	def Boolean validatePageHeader(String headerLabel) {

		def to = new TestObjectHelper()

		return WebUI.verifyElementText(to.getTestObjectWithXpath("//div[contains(@class, 'app-header-desktop')]/descendant::h4"), headerLabel)
	}

	@Keyword
	def getHCUrl(String relativePath) {
		// Return the current profile HC HostUrl and Relative Path for the initial target URL
		return "$GlobalVariable.HC_HostUrl$relativePath"
	}

	@Keyword
	def goToHCUrl(String relativePath) {
		// Navigate to the full path'
		WebUI.navigateToUrl(getHCUrl(relativePath))
	}
}


