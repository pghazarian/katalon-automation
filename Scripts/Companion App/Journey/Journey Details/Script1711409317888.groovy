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

/*
 1. Launch Companion App
 2. Log into Companion App
 3. Tap on Journey Navigation button
 4. Tap on the Browse Journeys tab 
 5. Verify a list of all published journeys is listed and item content is correct
 6. Type the name of a specific journey into the search text entry
 7. Verify that the search journey shows up as the only item in the list
 8. Sort the list of journeys by each available type
 9. Verify the list is displaying by sort type
 10.Filter the list of journeys by each filtering criteria
 11. Verify the list is displaying all journeys that match filtering criteria 
 12. Verify that the owner or co-owner can view unpublished journeys
 12. close the app
 */

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


/*
Prerequisite:  Use login credentials for a person who is NOT in progress on any journey  (New User)
	There should be some journey
 
1. Launch CA App
2. Log into CA App
3. Tap on Journey Navigation button
4. Verify Today page is displaying all suggested journeys and journeys either completed or finished
*/
/*
 *  Perform the steps to verify the Today page in the CA App
 *
 *  @param username The username of the user to log in
 *  @param password The password of the user to log in
 */

def timeout = 3

'Open existing app by the app bundle id'
WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate to Journey'
Button.tap('Nav/Journey Navigation Button', timeout)

Mobile.verifyElementExist(Finder.findLabel('Journey/Your Day Heading'), timeout)

Mobile.verifyElementExist(Finder.findLabel('Journey/Suggested Journey Tiles'), timeout)

Mobile.tap(Finder.findLabel('Journey/Suggested Journey Tiles'), timeout)

'Verify Journey Details header'
Mobile.verifyElementExist(Finder.findLabel('Journey/Details/Heading'), timeout)

'Verify Journey Name header'
Mobile.verifyElementExist(Finder.findLabel('Journey/Details/Name'), timeout)

'Verify Journey Subtitle'
Mobile.verifyElementExist(Finder.findLabel('Journey/Details/Subtitle'), timeout)

'Verify Journey Category'

'Verify Journey Description'
Mobile.verifyElementExist(Finder.findLabel('Journey/Details/Description'), timeout)

Button.tap("Journey/Details/Share", timeout)
Button.tap("Journey/Details/Close Share", timeout)

'tap Start button'
Button.tap("Journey/Details/Start Journey", timeout)

Mobile.waitForElementPresent(Finder.findButton("Journey/Pathway View/Browse Journeys"), timeout)

'tap on the back button from pathway view page'
Button.tap("Journey/Pathway View/Back", timeout)

'Verify Journey In-progress status'
Mobile.verifyElementExist(Finder.findLabel('Journey/Details/Journey In Progress Status'), timeout)

'tap on See Journey Pathway'
Button.tap("Journey/Details/See Journey Pathway", timeout)

'tap on the back button from pathway view page'
Button.tap("Journey/Pathway View/Back", timeout)

'swipe up to make stop journey button visible and accessible'
Swipe.swipe(SwipeDirection.BOTTOM_TO_TOP)

'tap on Stop Journey button'
Button.tap("Journey/Details/Stop Journey", timeout)

'tap on Stop Journey Yes confirmation button'
Button.tap("Journey/Details/Prompt Stop Journey Yes", timeout)

'tap on Journey Opted Out confirmation close button'
Button.tap("Journey/Details/Successfully Opted Out Close", timeout)

'Navigate to Home'
Button.tap('Nav/Home Navigation Button', timeout)

'Log out'
Mobile.waitForElementPresent(Finder.findButton("Logout Button"), timeout)
Button.tap('Logout Button', timeout)

Mobile.closeApplication()
