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
import com.detroitlabs.katalonmobileutil.device.App as App
import com.detroitlabs.katalonmobileutil.device.Device as Device
import com.detroitlabs.katalonmobileutil.testobject.Finder as Finder
import com.detroitlabs.katalonmobileutil.testobject.Button as Button
import com.detroitlabs.katalonmobileutil.testobject.TextField as TextField
import com.detroitlabs.katalonmobileutil.touch.Swipe as Swipe
import com.detroitlabs.katalonmobileutil.touch.Swipe.SwipeDirection as SwipeDirection

def timeout = 3

'Open existing app by the app bundle id'
WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [('UserName') : GlobalVariable.Admin2_UserName, ('Password') : GlobalVariable.Admin2_Password], 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to Journey'
Button.tap('Nav/Journey Navigation Button', timeout)

'Verify that the Header is present'
Mobile.verifyElementVisible(Finder.findLabel('Journey Heading'), timeout)

'Click Link for the Journey Walkthrough'
Button.tap(Finder.findLink('What is a Journey Link'), timeout)

'Do the walkthrough of the Journey'

'Verify text on page 1'
Mobile.verifyElementVisible(Finder.findLabel('Walkthough Page 1 Heading'), timeout)

'Swipe'
Swipe.swipe(SwipeDirection.RIGHT_TO_LEFT)

'Verify text on page 2'
Mobile.verifyElementVisible(Finder.findLabel('Walkthough Page 2 Heading'), timeout)

'Swipe'
Swipe.swipe(SwipeDirection.RIGHT_TO_LEFT)

'Verify text on page 3'
Mobile.verifyElementVisible(Finder.findLabel('Walkthough Page 3 Heading'), timeout)

Button.tap('Journey/Browse Journeys')

