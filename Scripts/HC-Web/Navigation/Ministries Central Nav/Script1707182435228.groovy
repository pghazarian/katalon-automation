import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password], FailureHandling.STOP_ON_FAILURE)

'Verify Ministries Central Top Menu Navigation'
CustomKeywords.'customUtility.NavigationHelper.clickTopMenuAndValidateHeader'('Ministries Central', 'All Ministries')

'Verify Ministries Central | All Ministries Navigation'
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Ministries Central', 'All Ministries', 'All Ministries')

'Verify Ministries Central | Quick-view Insights Navigation'
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Ministries Central', 'Quick-view Insights', 
    'Quick-view Insights')

'Verify Ministries Central | Serving Opps Catalogs Navigation'
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Ministries Central', 'Serving Opps Catalogs', 
    'Serving Opps Catalogs')

'Verify Ministries Central | Settings & Preferences Navigation'
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Ministries Central', 'Settings & Preferences',
	'Settings & Preferences')

'Verify Categories Sub Nav'
WebUI.click(CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'("//div[contains(@class, 'navigation_sectional_tabs--container')]//button[.='Categories']"))
'Verify Section Header is present'
WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Ministry/Settings and Preferences/Categories/Section Header'), 0)

'Verify Tags Sub Nav'
WebUI.click(CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'("//div[contains(@class, 'navigation_sectional_tabs--container')]//button[.='Tags']"))
'Verify Section Header is present'
WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Ministry/Settings and Preferences/Tags/Section Header'), 0)

'Verify Featured Ministries Sub Nav'
WebUI.click(CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'("//div[contains(@class, 'navigation_sectional_tabs--container')]//button[.='Featured Ministries']"))
'Verify Section Header is present'
WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Ministry/Settings and Preferences/Featured Ministries/Section Header'), 0)