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
import com.detroitlabs.katalonmobileutil.device.App as App
import com.detroitlabs.katalonmobileutil.device.Device as Device
import com.detroitlabs.katalonmobileutil.testobject.Finder as Finder
import com.detroitlabs.katalonmobileutil.testobject.Button as Button
import com.detroitlabs.katalonmobileutil.testobject.TextField as TextField
import com.detroitlabs.katalonmobileutil.touch.Swipe as Swipe
import com.detroitlabs.katalonmobileutil.touch.Swipe.SwipeDirection as SwipeDirection
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement
import com.kms.katalon.core.testobject.TestObjectXpath as TestObjectXpath

/*
-	Test Home Page
	o	 Campus Selector, check context of campus
			Change campus from the default home campus selection
			Default when a new user does not select a home campus
			Change campus and make it a new home campus
	o	Engagement Ribbon
			Turn on and off each engagement item (Faith in Christ, Baptism, small group membership, etc.)
			Make sure that item is lit up
			Tap on each item to show defining pane.
	o	Messages Ribbon
			Shows current and past messages.
			Should be in chronological order.
			Should be able to move from left to right (swiping)
			Tap on See All link button.
	o	For You Ribbon
			What defines what shows up in this ribbon
			What defines the order the items show up in this ribbon
	o	What’s Happening Ribbon
			This will display published announcements by campus
	o	Questions:
*/
def timeout = 3

def UniqueJourneyName = 'QA Automation Journey - Read Text'

'Open existing app by the app bundle id'
WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.delay(5)

'tap on the left most For You tile'
Button.tap('Home/Home Page/First For You Item')

Mobile.delay(5)

'tap on the CTA button'
Button.tap('Home/Home Page/For You Detail/CTA')

'tap on the back button from For You details page' 
Button.tap('Home/Home Page/For You Detail/Back')

Mobile.delay(5)

'Log out of the app'
WebUI.callTestCase(findTestCase('Companion App/Shared/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

'Close the app'
Mobile.closeApplication()


