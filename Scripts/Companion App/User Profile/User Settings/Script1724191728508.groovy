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
def UniqueServingOppName = GlobalVariable.ServingSearch_SearchTerm

'Open existing app by logging into the app bundle id'
WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [:], FailureHandling.STOP_ON_FAILURE)

Boolean deviceIsiOS = false

if (Device.isIOS()) {
	deviceIsiOS = true
}

' need driver to get lists and close app'
AppiumDriver<MobileElement> driver = MobileDriverFactory.getDriver()

Mobile.delay(5)

'Tap on the Profile navigation button'
if (Mobile.verifyElementVisible(Finder.findButton('Nav/Profile Avatar Navigation Button'), timeout, FailureHandling.OPTIONAL)) {
	'Tap on the profile avatar in the navigation'
	Button.tap('Nav/Profile Avatar Navigation Button')
}
else {
	'Tap on the profile avatar in the navigation'
	Button.tap('Nav/Profile No Avatar Navigation Button')
}

'Tap on the settings gear button'
Button.tap('Profile/Settings Gear')

'Tap on the user image to edit button'
Button.tap('Profile/Settings/User Image')

'Tap on the user image cancel button'
Button.tap('Profile/Settings/Cancel Image Edit')

'Log out of the app'
WebUI.callTestCase(findTestCase('Companion App/Shared/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

'close the application'
if (deviceIsiOS) {
	Mobile.closeApplication()
}
else {
	driver.terminateApp('com.healthychurch.companion.stage')
}
