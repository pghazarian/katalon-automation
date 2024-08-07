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
/*
- Launch CA App
- Tap on Discover Navigation button
- Enter name of QA Automation single/recurring event in search text entry and tap enter key
- Tap on first located event in the list
- Tap on Register button
- If logged in skip next three steps
- Enter First Name
- Enter Last Name
- Enter email address
- Tap on submit button
- If logged in the register button is changed 
- if logged out attempt steps to above to register for event again
- Verify that a message is displayed indicating logged out user is already registered
- cancel out of already registered modal
- if logged out, skip to the end of test
- tap on cancel registration of single/recurring event
- log out
- close app
*/

def timeout = 10

String UniqueEventName = GlobalVariable.EventSearch_SearchTerm


boolean CurrentlyLoggedIn

if (LoggedIn.toBoolean()) {
	CurrentlyLoggedIn = true
}
else {
	CurrentlyLoggedIn = false
}

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


// need driver to get lists and close app
AppiumDriver<MobileElement> driver = MobileDriverFactory.getDriver()

//Mobile.delay(3)

Mobile.waitForElementPresent(Finder.findButton('Nav/Discover Navigation Button'), timeout)
	
'Navigate to Discover'
Button.tap('Nav/Discover Navigation Button', timeout)

'Wait for Events landing page to display'
Mobile.waitForElementPresent(Finder.findTextField('Discover/Events/Search'), timeout)

'search for specific event'
TextField.typeText(Finder.findTextField('Discover/Events/Search'), UniqueEventName + Keys.ENTER, timeout)

'tap on first entry located'
Mobile.tap(Finder.findLabel('Discover/Events/Searched List Entry'), timeout)





Mobile.delay(5)

'Navigate to Home'
Button.tap('Nav/Home Navigation Button', timeout)

'Log out'
Button.tap('Logout Button', timeout)

if (deviceIsiOS) {
	Mobile.closeApplication()
}
else {
	driver.closeApp()
}


