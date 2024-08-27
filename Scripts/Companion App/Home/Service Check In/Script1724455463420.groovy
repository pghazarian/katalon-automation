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
import com.detroitlabs.katalonmobileutil.device.App as App
import com.detroitlabs.katalonmobileutil.device.Device as Device
import com.detroitlabs.katalonmobileutil.testobject.Finder as Finder
import com.detroitlabs.katalonmobileutil.testobject.Button as Button
import com.detroitlabs.katalonmobileutil.testobject.TextField as TextField
import com.detroitlabs.katalonmobileutil.touch.Swipe as Swipe
import com.detroitlabs.katalonmobileutil.touch.Swipe.SwipeDirection as SwipeDirection
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement
import com.kms.katalon.core.testobject.TestObjectXpath as TestObjectXpath
import org.openqa.selenium.WebElement as WebElement
import io.appium.java_client.ios.IOSDriver as IOSDriver
import java.lang.String as String

def timeout = 10

// Launch the CA app
boolean LoggedInIteration = LoggedIn.toBoolean()


if (LoggedInIteration) {
	'Open existing app by logging into the app bundle id'
	WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [:], FailureHandling.STOP_ON_FAILURE)
} else {
	'Open existing app while logged out by the app bundle id'
	WebUI.callTestCase(findTestCase('Companion App/Shared/Guest Startup'), [:], FailureHandling.STOP_ON_FAILURE)
}

Boolean deviceIsiOS = false

if (Device.isIOS()) {
	deviceIsiOS = true
}

Mobile.delay(5)

'verify that service check-in modal is displayed'
Mobile.verifyElementVisible(Finder.findButton('Home/Service Check-In/In Person'), timeout)

'tap on the In-Person button'
Button.tap('Home/Service Check-In/In Person', timeout)

'wait for the confirmation modal to display'
Mobile.waitForElementPresent(Finder.findButton('Home/Service Check-In/Service Check In OK'), timeout)

'tap on the confirmation OK button'
Mobile.verifyElementExist(Finder.findLabel('Home/Service Check In/Check In Success'), timeout)  
Button.tap('Home/Service Check-In/Service Check In OK', timeout)

'need driver to get lists and close app'
AppiumDriver<MobileElement> driver = MobileDriverFactory.getDriver()

'Log out'
if (LoggedInIteration) {
	WebUI.callTestCase(findTestCase('Companion App/Shared/Logout'), [:], FailureHandling.STOP_ON_FAILURE)
}

if (deviceIsiOS) {
	Mobile.closeApplication()
}
else {
	driver.closeApp()
}
