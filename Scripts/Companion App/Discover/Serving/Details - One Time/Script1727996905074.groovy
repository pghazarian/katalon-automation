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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement
import com.kms.katalon.core.testobject.TestObjectXpath
import org.openqa.selenium.WebElement
import io.appium.java_client.ios.IOSDriver

def timeout = 10

String UniqueServingOppName = GlobalVariable.ServingSearch_OneTime_SearchTerm

boolean CurrentlyLoggedIn = LoggedIn.toBoolean()

if (CurrentlyLoggedIn) {
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

'need driver to get lists and close app'
AppiumDriver<MobileElement> driver = MobileDriverFactory.getDriver()

Mobile.waitForElementPresent(Finder.findButton('Nav/Discover Navigation Button'), timeout)
	
'Navigate to Discover'
Button.tap('Nav/Discover Navigation Button', timeout)
Mobile.delay(3)

'Tap on Serving tab'
Mobile.waitForElementPresent(Finder.findButton('Discover/Serving Tab'), timeout)
Button.tap('Discover/Serving Tab', timeout)

'Wait for Serving landing page to display'
Mobile.delay(5)
Mobile.waitForElementPresent(Finder.findTextField('Discover/Serving/Search'), timeout)

'search for specific serving opp'
TextField.typeText(Finder.findTextField('Discover/Serving/Search'), UniqueServingOppName + Keys.ENTER, timeout)

'tap on first entry located'
Mobile.waitForElementPresent(Finder.findLabel('Discover/Serving/List Entry - One Time'), timeout)
Mobile.tap(Finder.findLabel('Discover/Serving/List Entry - One Time'), timeout)

'tap on Im interested button'
Mobile.delay(15)
Mobile.waitForElementPresent(Finder.findButton('Discover/Serving/Serving Details/Im Interested'), timeout)
Button.tap('Discover/Serving/Serving Details/Im Interested', timeout)

'if not logged in'
if (CurrentlyLoggedIn == false)
{
	'enter first name'
	TextField.typeText(Finder.findTextField('Discover/Serving/Im Interested in Serving/First Name'), GlobalVariable.ServingSignUp_FirstName + Keys.ENTER, timeout)
		
	'enter last name'
	TextField.typeText(Finder.findTextField('Discover/Serving/Im Interested in Serving/Last Name'), GlobalVariable.ServingSignUp_LastName + Keys.ENTER, timeout)
	
	'enter email address'
	TextField.typeText(Finder.findTextField('Discover/Serving/Im Interested in Serving/Email Address'), GlobalVariable.ServingSignUp_EmailAddress + Keys.ENTER, timeout)
}

'tap on the Submit button'
Mobile.scrollToText('Submit')
Mobile.waitForElementPresent(Finder.findButton('Discover/Serving/Serving Details/Sign Up For Serving Opp/Submit'), timeout)
Mobile.delay(3)
Button.tap('Discover/Serving/Serving Details/Sign Up For Serving Opp/Submit', timeout)

'tap on Done button'
Mobile.waitForElementPresent(Finder.findButton('Discover/Serving/Serving Details/Sign Up For Serving Opp/Done'), timeout)
Button.tap('Discover/Serving/Serving Details/Sign Up For Serving Opp/Done', timeout)

'Navigate to Home'
Button.tap('Nav/Home Navigation Button', timeout)

'Log out'
if (CurrentlyLoggedIn)
{
	WebUI.callTestCase(findTestCase('Companion App/Shared/Logout'), [:], FailureHandling.STOP_ON_FAILURE)
}

if (deviceIsiOS) {
	Mobile.closeApplication()
}
else {
	driver.closeApp()
}


