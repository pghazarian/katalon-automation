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
Prerequiste:  Make sure a Journey is setup with multiple sections and at least one video step type
1. Launch the Companion App
2. Log into the Companion App
3. Tap on the Browse Journey tab
4. Select a Journey that has not been started and fulfills the above prerequisites
5. Start the Journey
6. Select the Video step
7. Verify that video start playing automatically
8. Tap on the pause button.
9. Tap on the play button.
10. Scrub the video backward 
11. Scrub the video forward
12. Use the 15 second forward button.
13. Use the 15 second backward button.
14. Minimize the CA app
15. Verify that video stops playing
16. Bring the CA app back to the foreground 
17. Restart the Video playback.
18. Let video playback fully to the end.
19. 
*/

def timeout = 3
def UniqueJourneyName = 'QA Automation Journey - Video'

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
Mobile.waitForElementPresent(Finder.findLabel("Journey/Pathway View/First Step - Video"), timeout)
Mobile.tap(Finder.findLabel("Journey/Pathway View/First Step - Video"), timeout)

Mobile.delay(3)

Button.tap("Journey/Pathway View/Video Player/Play", timeout)

Mobile.delay(3)

Button.tap('Journey/Pathway View/Video Player/Show Controls', timeout)
Mobile.delay(2)
Button.tap("Journey/Pathway View/Video Player/Pause", timeout)

Mobile.delay(5)

Button.tap('Journey/Pathway View/Video Player/Show Controls', timeout)
Mobile.delay(2)
Button.tap("Journey/Pathway View/Video Player/Play", timeout)

Mobile.delay(6)

Button.tap('Journey/Pathway View/Video Player/Show Controls', timeout)
Mobile.delay(2)
Button.tap("Journey/Pathway View/Video Player/Backup 15 Seconds", timeout)


Button.tap('Journey/Pathway View/Video Player/Show Controls', timeout)
Mobile.delay(2)
Button.tap("Journey/Pathway View/Video Player/Play", timeout)


Button.tap('Journey/Pathway View/Video Player/Show Controls', timeout)
Mobile.delay(2)
for (int i = 0; i < 12; i++) {
	Button.tap("Journey/Pathway View/Video Player/Forwards 15 Seconds", timeout)
	
	Mobile.delay(1)
	
	Button.tap('Journey/Pathway View/Video Player/Show Controls', timeout)
	Mobile.delay(2)
	Button.tap("Journey/Pathway View/Video Player/Play", timeout)
	
}

Button.tap("Journey/Pathway View/Audio Player/Close", timeout)

Mobile.delay(3)

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

Mobile.delay(3)
'tap on Journey Opted Out confirmation close button'
Button.tap("Journey/Details/Successfully Opted Out Close", timeout)

'Tap on Back button to get back to the Journey List'
Button.tap("Journey/Details/Back", timeout)

'Wait for Browse page to display'
Mobile.waitForElementPresent(Finder.findLabel("Journey/Browse/List Entry"), timeout)
//*/

'Navigate to Home'
Button.tap('Nav/Home Navigation Button', timeout)

'Log out'
Button.tap('Logout Button', timeout)

Mobile.closeApplication()