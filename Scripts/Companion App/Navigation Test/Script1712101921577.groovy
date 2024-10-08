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

def timeout = 3

'Open existing app by the app bundle id'
WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.delay(3)

'Navigate to Resources'
Button.tap('Nav/Resources Navigation Button', timeout)

Mobile.delay(3)

Mobile.verifyElementText(Finder.findLabel('Resources Heading'), "Resources")

Mobile.delay(3)

'Tap on Profile navigation button'
if (Mobile.verifyElementVisible(Finder.findButton('Nav/Profile Avatar Navigation Button'), timeout, FailureHandling.OPTIONAL)) {
	'Tap on the profile avatar in the navigation'
	Button.tap('Nav/Profile Avatar Navigation Button')
}
else { 	// if no avatar then different nav button
	'Tap on the generic profile avatar in the navigation'
	Button.tap('Nav/Profile No Avatar Navigation Button')
}

Mobile.verifyElementExist(Finder.findButton('Profile/Translation'), timeout)   

Mobile.delay(3)

'Navigate to Journey'
Button.tap('Nav/Journey Navigation Button', timeout)

Mobile.verifyElementText(Finder.findLabel('Journey Heading'), "Journey")

'Navigate to Discover'
Button.tap('Nav/Discover Navigation Button', timeout)

Mobile.verifyElementText(Finder.findLabel('Discover Heading'), "Discover")

'Navigate to Settings'
if (Mobile.verifyElementVisible(Finder.findButton('Nav/Profile Avatar Navigation Button'), timeout, FailureHandling.OPTIONAL)) {
	'Tap on the profile avatar in the navigation'
	Button.tap('Nav/Profile Avatar Navigation Button')
}
else { 	// if no avatar then different nav button
	'Tap on the generic profile avatar in the navigation'
	Button.tap('Nav/Profile No Avatar Navigation Button')
}

Button.tap('Profile/Settings Gear', timeout)

Mobile.verifyElementText(Finder.findLabel('Settings Heading'), "Settings", FailureHandling.CONTINUE_ON_FAILURE)

'Navigate to Home'
Button.tap('Nav/Home Navigation Button', timeout)

Mobile.verifyElementText(Finder.findLabel('Home Heading'), "SADDLEBACK CHURCH")

// add test for that
'Log out'
if (Mobile.verifyElementVisible(Finder.findButton('Nav/Profile Avatar Navigation Button'), timeout, FailureHandling.OPTIONAL)) {
	'Tap on the profile avatar in the navigation'
	Button.tap('Nav/Profile Avatar Navigation Button')
}
else { 	// if no avatar then different nav button
	'Tap on the generic profile avatar in the navigation'
	Button.tap('Nav/Profile No Avatar Navigation Button')
}
		
'tap on the settings Account & Notifications tile button'
Mobile.waitForElementPresent(Finder.findButton("Profile/Settings/Account Notifications"), 5)
Button.tap('Profile/Settings/Account Notifications')
	
'tap on the logout button'
Mobile.waitForElementPresent(Finder.findButton("Profile/Settings/Account Notifications Page/Logout"), 7)
Button.tap('Profile/Settings/Account Notifications Page/Logout')

Mobile.delay(3)

'Verify that the Splash Screen loads'
Mobile.verifyElementVisible(Finder.findLabel('Splash/Description'), timeout)
Mobile.verifyElementVisible(Finder.findLabel('Splash/Welcome Heading'), timeout)

'Close the app'
Mobile.closeApplication()



