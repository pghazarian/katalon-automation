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

/*
Prerequisite:  Use login credentials for a person who is in progress on any journey
 
1. Launch CA App
2. Log into CA App
3. Tap on Journey Navigation button
4. Verify Today page is displaying all next steps for all in progress journeys
5. Move through the past days
6. Verify that days have completed steps of journeys performed on that past day
7. Verify that days have proper text when no journey steps where completed.
*/

def timeout = 3

'Open existing app by the app bundle id'
WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), ['UserName':'markh@saddleback.com', 'Password':(CryptoUtil.encode(CryptoUtil.getDefault('P@$$w0rd!')))], FailureHandling.STOP_ON_FAILURE)

'Navigate to Journey'
Button.tap('Nav/Journey Navigation Button', timeout)

Mobile.verifyElementExist(Finder.findLabel('Journey/Next Steps Heading'), timeout)

Mobile.verifyElementExist(Finder.findLabel('Journey/Suggested Journey Tiles'), timeout)

Button.tap('Journey/Date Go Back', timeout)

Button.tap('Journey/Date Go Forward', timeout)

'Navigate to Home'
Button.tap('Nav/Home Navigation Button', timeout)

Mobile.verifyElementText(Finder.findLabel('Home Heading'), "Home")

// add test for that
'Log out'
Button.tap('Logout Button', timeout)

Mobile.closeApplication()
