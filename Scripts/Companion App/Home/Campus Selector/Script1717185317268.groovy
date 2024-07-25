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
import com.kms.katalon.util.CryptoUtil as CryptoUtil

import com.detroitlabs.katalonmobileutil.device.App
import com.detroitlabs.katalonmobileutil.device.Device
import com.detroitlabs.katalonmobileutil.testobject.Finder
import com.detroitlabs.katalonmobileutil.testobject.Button
import com.detroitlabs.katalonmobileutil.testobject.TextField
import com.detroitlabs.katalonmobileutil.touch.Swipe as Swipe
import com.detroitlabs.katalonmobileutil.touch.Swipe.SwipeDirection as SwipeDirection
import com.detroitlabs.katalonmobileutil.touch.Scroll
import com.detroitlabs.katalonmobileutil.touch.Scroll.ScrollFactor

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement
import com.kms.katalon.core.testobject.TestObjectXpath


def timeout = 10
def UniqueEventName = 'QA Automation Event Recurring Daily Does Not End'

'Open existing app by the app bundle id'
WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [:], FailureHandling.STOP_ON_FAILURE)

Boolean deviceIsiOS = false

if (Device.isIOS()) {
	deviceIsiOS = true
}

'need driver to get lists and close app'
AppiumDriver<MobileElement> driver = MobileDriverFactory.getDriver()
AppiumDriver<?> driverAndroid = MobileDriverFactory.getDriver()

'tap on the campus selector'
Mobile.tap(Finder.findLabel("Home/Campus"), timeout)

'close the campus selector'
Button.tap("Home/Campus Selector/Close")

'tap on the campus selector again'
Mobile.tap(Finder.findLabel("Home/Campus"), timeout)

'tap on a different campus'
Mobile.tap(Finder.findLabel("Home/Campus Selector/Anaheim"), timeout)

'tap on the cancel button'
Button.tap("Home/Campus Selector/Cancel", timeout)

'tap on the campus selector again'
Mobile.tap(Finder.findLabel("Home/Campus"), timeout)

'tap on a different campus'
Mobile.tap(Finder.findLabel("Home/Campus Selector/Anaheim"), timeout)

'tap on the Apply button'
Button.tap("Home/Campus Selector/Apply", timeout)

Mobile.verifyElementText(Finder.findLabel("Home/Campus Text"), "Anaheim")

'tap on the campus selector again'
Mobile.tap(Finder.findLabel("Home/Campus"), timeout)

/*
if (Device.isIOS()) {
	Swipe.swipe(SwipeDirection.BOTTOM_TO_TOP)
}
else {
	'tap on a different campus'
	Mobile.tap(Finder.findLabel("Home/Campus Selector/Anaheim"), timeout)
	
	//Mobile.scrollToText("Lake Forest")
	Scroll.scrollListToElementWithText('item', 'Lake Forest', timeout)
	//Mobile.swipe(500, 1940, 500, 761)
}
*/

'tap on a different campus'
Mobile.tap(Finder.findLabel("Home/Campus Selector/Corona"), timeout)

'tap on the Apply button'
Button.tap("Home/Campus Selector/Apply", timeout)

if (deviceIsiOS) {
	Mobile.closeApplication()
}
else {
	driver.closeApp()
}

