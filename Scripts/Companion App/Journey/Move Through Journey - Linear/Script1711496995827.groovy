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

/*
Prerequiste:  Make sure a linear Journey is setup with multiple sections and at least one of each type of step.  
Make some steps required and some not.
1. Launch the Companion App
2. Log into the Companion App
3. Tap on the Browse Journey tab
4. Select a Journey that has not been started and fulfills the above prerequisites
5. Start the Journey
6. Verify that the status in the journey details displays In-progress tag
7. Tap on the back arrow to return back to the Browse Journeys page
8. Tap on the Today tab
9. Verify that Next Steps page is displayed and the newly started journey first step is listed
10. Tap on the journey next steps
11. Now perform the CTA for each step in each section
12. Verify that when you attempt to skip a required step, the user is returned back to the pathway view on same step
13. Verify that when you attempt to skip a non-required step, the user can skip via the Got it button
14. Verify for Video steps that you can scrub forward and backward and pause it.
15. Verify for Audio steps that you can scrub forward and backward and pause it.  When completed no up next mode does 
		not automatically displays until user manually closes.
16. Verify Quiz steps display results stats page at end.
17. Verify that when a step is completed that the up next mode moving automatically to the next step.
18. Verify that when you complete a section that a confirmation page is displayed.
19. Verify that the footsteps advanced to the next step or section.
20. Repeat steps 11 - 19 till all steps and sections are completed
21. Verify that a journey completion confirmation page is displayed.
22. Verify that when user is returned back to the journey details page reflects completed status tag
23. Tap on the back arrow to return back to the Browse Journeys page
24. Verify that when user is returned back to the journey list page the journey reflects completed status tag 
 */


def timeout = 3
def UniqueJourneyName = 'QA Automation Journey - Linear - All Step Types'

'Open existing app by the app bundle id'
WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), ['UserName':'markh@saddleback.com', 'Password':(CryptoUtil.encode(CryptoUtil.getDefault('P@$$w0rd!')))], FailureHandling.STOP_ON_FAILURE)
//WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate to Journey'
Button.tap('Nav/Journey Navigation Button', timeout)

Mobile.delay(3)
'Wait for Journey landing page to display'
Mobile.waitForElementPresent(Finder.findButton("Journey/Browse Tab"), timeout)

'Tap on the Browse Journeys tab'
Button.tap('Journey/Browse Tab', timeout)

'Verify that journey entries exist'
Mobile.waitForElementPresent(Finder.findLabel("Journey/Browse/List Entry"), timeout)

'Search for a unique journey name'
TextField.typeText(Finder.findTextField('Journey/Browse/Search'), UniqueJourneyName + Keys.ENTER, timeout)

'tap on the found journey to show details page'
Mobile.tap(Finder.findLabel('Journey/Browse/List Entry'), timeout)

'wait for details page to fully displayed'
Mobile.waitForElementPresent(Finder.findLabel("Journey/Details/Heading"), timeout)

'Verify Journey Details header'
Mobile.verifyElementExist(Finder.findLabel('Journey/Details/Heading'), timeout)

if (Device.isIOS()) {
	Swipe.swipe(SwipeDirection.BOTTOM_TO_TOP)
}
else {
	if (Mobile.verifyElementVisible(Finder.findButton("Journey/Details/Stop Journey"), 3, FailureHandling.OPTIONAL)) {
		Mobile.scrollToText('Stop Journey', FailureHandling.STOP_ON_FAILURE)
	}
	else {
		Mobile.scrollToText('Start Journey', FailureHandling.STOP_ON_FAILURE)
	}
}

'stop the journey if previously started'
if(Mobile.verifyElementVisible(Finder.findButton("Journey/Details/Stop Journey"), 3, FailureHandling.OPTIONAL)) {
	'wait for details page to fully displayed'
	Mobile.waitForElementPresent(Finder.findButton("Journey/Details/Stop Journey"), timeout)
		
	'tap on Stop Journey button'
	Button.tap("Journey/Details/Stop Journey", timeout)
	
	'tap on Stop Journey Yes confirmation button'
	Button.tap("Journey/Details/Prompt Stop Journey Yes", timeout)
	
	Mobile.delay(3)
	'tap on Journey Opted Out confirmation close button'
	Button.tap("Journey/Details/Successfully Opted Out Close", timeout)
}
	
'tap Start button'
Button.tap("Journey/Details/Start Journey", timeout)

Mobile.waitForElementPresent(Finder.findLabel("Journey/Pathway View/Pathway Header"), timeout)

'tap on first section'
Mobile.tap(Finder.findLabel("Journey/Pathway View/First Section"), timeout)

'tap on first step'
Mobile.waitForElementPresent(Finder.findLabel("Journey/Pathway View/First Step - Audio"), timeout)
Mobile.tap(Finder.findLabel("Journey/Pathway View/First Step - Audio"), timeout)

Mobile.delay(5)

Button.tap("Journey/Pathway View/Audio Player/Pause", timeout)

Mobile.delay(5)

Button.tap("Journey/Pathway View/Audio Player/Play", timeout)

Mobile.delay(6)

Button.tap("Journey/Pathway View/Audio Player/Backup 10 Seconds", timeout)

//Mobile.delay(3)

for (int i = 0; i < 12; i++) {
	Button.tap("Journey/Pathway View/Audio Player/Forwards 10 Seconds", timeout)
	
	Mobile.delay(1)
}

Button.tap("Journey/Pathway View/Audio Player/Speed Picker", timeout)

Button.tap("Journey/Pathway View/Audio Player/Close", timeout)

'tap on back to journey button'
if(Mobile.verifyElementVisible(Finder.findButton('Journey/Pathway View/Up Next Mode/Back to Journey'), 3, FailureHandling.OPTIONAL)) {
	Button.tap('Journey/Pathway View/Up Next Mode/Back to Journey', timeout)
}

'reset the journey'
Button.tap("Journey/Pathway View/Reset", timeout)
Button.tap("Journey/Pathway View/Reset Confirmation", timeout)

'tap on the back button from pathway view page'
Button.tap("Journey/Pathway View/Back", timeout)

'wait for details page to fully displayed'
Mobile.waitForElementPresent(Finder.findLabel("Journey/Details/Heading"), timeout)

'swipe up to make stop journey button visible and accessible'
if (Device.isIOS()) {
	Swipe.swipe(SwipeDirection.BOTTOM_TO_TOP)
}
else {
	Mobile.scrollToText('Stop Journey', FailureHandling.STOP_ON_FAILURE)
}

'wait for details page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Journey/Details/Stop Journey"), timeout)
	
'tap on Stop Journey button'
Button.tap("Journey/Details/Stop Journey", timeout)

'tap on Stop Journey Yes confirmation button'
Button.tap("Journey/Details/Prompt Stop Journey Yes", timeout)

'tap on Journey Opted Out confirmation close button'
Mobile.waitForElementPresent(Finder.findButton("Journey/Details/Successfully Opted Out Close"), timeout)
Button.tap("Journey/Details/Successfully Opted Out Close", timeout)

'Tap on Back button to get back to the Journey List'
Button.tap("Journey/Details/Back", timeout)

'Wait for Browse page to display'
Mobile.waitForElementPresent(Finder.findLabel("Journey/Browse/List Entry"), timeout)

'Navigate to Home'
Button.tap('Nav/Home Navigation Button', timeout)

'Log out'
Button.tap('Logout Button', timeout)

Mobile.closeApplication()
