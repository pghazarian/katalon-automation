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

def timeout = 7

boolean CurrentlyLoggedIn = LoggedIn.toBoolean()

if (CurrentlyLoggedIn) {
	'Open existing app by logging into the app bundle id'
	WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [:], FailureHandling.STOP_ON_FAILURE)
} else {
	'Open existing app while logged out by the app bundle id'
	WebUI.callTestCase(findTestCase('Companion App/Shared/Guest Startup'), [:], FailureHandling.STOP_ON_FAILURE)
}

'Open existing app by the app bundle id'
WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.waitForElementPresent(Finder.findButton('Home/Engagement Pathway/Badges/Decision'), timeout)

Mobile.scrollToText('Series')

'tap on the left most Series tile'
Button.tap('Home/Home Page/First Series Item')

'Verify that the series details has image'
Mobile.verifyElementVisible(Finder.findLabel('Resources/Messages/Series Details Page/Series Detail Image'), timeout)

'Verify that the series details has title'
Mobile.verifyElementVisible(Finder.findLabel('Resources/Messages/Series Details Page/Series Detail Title'), timeout)

'Verify that the entries have an description'
Mobile.verifyElementVisible(Finder.findLabel('Resources/Messages/Series Details Page/Series Detail Description'), timeout)

'tap on the first message in the series'
Mobile.tap(Finder.findLabel('Resources/Messages/Series Details Page/Series Detail First Message'), timeout)

'tap on the back button from message details page'
Button.tap('Resources/Messages/Message Details/Back')

'tap on the back button from For You details page' 
Mobile.waitForElementPresent(Finder.findButton('Resources/Messages/Series Details Page/Back'), timeout)
Button.tap('Resources/Messages/Series Details Page/Back')

//Mobile.delay(5)

'Log out of the app'
if (CurrentlyLoggedIn) {
	WebUI.callTestCase(findTestCase('Companion App/Shared/Logout'), [:], FailureHandling.STOP_ON_FAILURE)
}

'Close the app'
Mobile.closeApplication()


