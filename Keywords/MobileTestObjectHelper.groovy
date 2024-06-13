import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import com.kms.katalon.core.testobject.MobileTestObject.MobileLocatorStrategy
import com.kms.katalon.core.testobject.MobileTestObject
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement

class MobileTestObjectHelper {

	@Keyword
	static String getXPath(TestObject to) {
		MobileTestObject mto = (MobileTestObject)to

		if ("XPATH".equals(mto.getMobileLocatorStrategy().getLocatorStrategy())) {
			def locator = mto.getMobileLocator()

			KeywordUtil.logInfo("$to.objectId XPATH: $locator")
			return locator
		}

		return null
	}
	
	@Keyword
	static List<MobileElement> getElementList(TestObject to, AppiumDriver<MobileElement> driver) {
		MobileTestObject mto = (MobileTestObject)to

		def locator  = mto.getMobileLocator()
		def strategy = mto.getMobileLocatorStrategy().getLocatorStrategy()
		KeywordUtil.logInfo("$to.objectId XPATH: $locator")
		KeywordUtil.logInfo(strategy)
									
		switch (strategy)
		{
			case "XPATH":
				return driver.findElementsByXPath(locator)
				
			case "Accessibility ID":
				return driver.findElementsByAccessibilityId(locator)
		}

		return null
	}

}