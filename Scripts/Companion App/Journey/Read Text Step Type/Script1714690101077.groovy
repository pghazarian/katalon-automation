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
Prerequisite:  *Create a Journey in the HC Back Office that contains a required Readable Text step with multiple pages*.  
Make sure every type of formatting and content is implemented in the test step.


1. Log into CA App
2. Navigate to Journey Browse page
3. Select a Journey that contains a Readable Text Step matching prerequisite
4. Select Start Journey at the bottom of the screen
5. Select Got It at the bottom of the modal to clear it.  Select the first section from the Journey pathway.
6. Complete the required steps to reach the Readable Text step in the section.
7. Tap on the Readable Text step in the pathway view
8. Verify that all the formatting of the text on the page is proper
9. Move the second page of text via buttons and swiping.
10. Verify that all the formatting of the text on the page is proper
11. Exit out of the readable text step
12. return back to the readable text step
13. Exit out of the Journey
14. Return back the same journey and tap on the readable text step
15. Complete the required steps to reach the Readable Text step in the section.
16. Click Finished button
17. Exit the application
*/


def timeout = 3
def UniqueJourneyName = 'QA Automation Journey - Read Text'

'Open existing app by the app bundle id'
//WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), ['UserName':'markh@saddleback.com', 'Password':(CryptoUtil.encode(CryptoUtil.getDefault('P@$$w0rd!')))], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [:], FailureHandling.STOP_ON_FAILURE)

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

/*
if (Device.isIOS()) {
	Swipe.swipe(SwipeDirection.BOTTOM_TO_TOP)
}
else {
	Mobile.scrollToText('Start Journey', FailureHandling.STOP_ON_FAILURE)
}
*/

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
Mobile.waitForElementPresent(Finder.findLabel("Journey/Pathway View/First Step - Read Text"), timeout)
Mobile.tap(Finder.findLabel("Journey/Pathway View/First Step - Read Text"), timeout)

Button.tap("Journey/Pathway View/Read Text/Next Page", timeout)

Button.tap("Journey/Pathway View/Read Text/Previous Page", timeout)

Button.tap("Journey/Pathway View/Read Text/Next Page", timeout)

Button.tap("Journey/Pathway View/Read Text/Next Page", timeout)

Button.tap("Journey/Pathway View/Read Text/Finish", timeout)

//Mobile.delay(5)

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
