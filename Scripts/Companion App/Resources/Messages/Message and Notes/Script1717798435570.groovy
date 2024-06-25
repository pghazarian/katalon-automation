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
import org.openqa.selenium.WebElement
import io.appium.java_client.ios.IOSDriver

def timeout = 10

String UniqueMessageName = GlobalVariable.MessageSearch_Details

'Open existing app by the app bundle id'
WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [:], FailureHandling.STOP_ON_FAILURE)

Boolean deviceIsiOS = false

if (Device.isIOS()) {
	deviceIsiOS = true
}
	
'Navigate to Resource'
Button.tap('Nav/Resources Navigation Button', timeout)

'Wait for Messages landing page to display'
Button.tap('Resources/Messages Tab', timeout)

'need driver to get lists and close app' 
AppiumDriver<MobileElement> driver = MobileDriverFactory.getDriver()

'Search for a unique message name'
TextField.typeText(Finder.findTextField('Resources/Messages/Search'), UniqueMessageName + Keys.ENTER, timeout)
Mobile.delay(1)

Mobile.waitForElementPresent(Finder.findLabel("Resources/Messages/Messages List Page/Message Item Image"), timeout)

'Tap on the first message in the list'
Mobile.tap(Finder.findLabel("Resources/Messages/Messages List Page/Message Item Title"), timeout)

'Start the video playback'
Mobile.waitForElementPresent(Finder.findButton("Resources/Messages/Message Details/Video Start Play"), timeout)
Button.tap('Resources/Messages/Message Details/Video Start Play', timeout)

Mobile.delay(15)

'process the video only for the Android'
if (!deviceIsiOS) {
	'Stop the video playback'
	Button.tap('Resources/Messages/Message Details/Video Show Controls', timeout)
	Mobile.waitForElementPresent(Finder.findButton("Resources/Messages/Message Details/Video Stop Play"), timeout)
	Button.tap('Resources/Messages/Message Details/Video Stop Play', timeout)
	
	Mobile.delay(5)
	
	'Start the video playback'
	Mobile.waitForElementPresent(Finder.findButton("Resources/Messages/Message Details/Video Start Play"), timeout)
	Button.tap('Resources/Messages/Message Details/Video Start Play', timeout)
	
	Mobile.delay(15)
	
	'Pause the video playback'
	Button.tap('Resources/Messages/Message Details/Video Show Controls', timeout)
	Button.tap('Resources/Messages/Message Details/Video Pause and Restart', timeout)
	
	Mobile.delay(10)
	
	'restart video playback'
	Button.tap('Resources/Messages/Message Details/Video Show Controls', timeout)
	Button.tap('Resources/Messages/Message Details/Video Pause and Restart', timeout)
	
	Mobile.delay(10)

	'move video forward'
	Button.tap('Resources/Messages/Message Details/Video Show Controls', timeout)
	Button.tap('Resources/Messages/Message Details/Video Go Forward', timeout)
	
	Mobile.delay(10)
	
	'move video back'
	Button.tap('Resources/Messages/Message Details/Video Show Controls', timeout)
	Button.tap('Resources/Messages/Message Details/Video Go Back', timeout)
	
	Mobile.delay(10)


	'Stop the video playback'
	Button.tap('Resources/Messages/Message Details/Video Show Controls', timeout)
	Mobile.waitForElementPresent(Finder.findButton("Resources/Messages/Message Details/Video Stop Play"), timeout)
	Button.tap('Resources/Messages/Message Details/Video Stop Play', timeout)
	
	Mobile.delay(5)
}

'download the message notes'
Button.tap("Resources/Messages/Message Details/Download", timeout)

Mobile.waitForElementPresent(Finder.findButton("Resources/Messages/Message Details/Download Original Notes"), timeout)
Button.tap("Resources/Messages/Message Details/Download Original Notes", timeout)

Mobile.waitForElementPresent(Finder.findButton("Resources/Messages/Message Details/Download Close"), timeout)
Button.tap("Resources/Messages/Message Details/Download Close", timeout)

Mobile.delay(5)

'Share the message notes'
Button.tap("Resources/Messages/Message Details/Share", timeout)

Button.tap("Resources/Messages/Message Details/Share Copy", timeout)

Mobile.delay(5)

'return back to the recent message list'
Button.tap("Resources/Messages/Message Details/Back", timeout)

'Navigate to Home'
Button.tap('Nav/Home Navigation Button', timeout)

'Log out'
if (Device.isIOS()) {
	Swipe.swipe(SwipeDirection.BOTTOM_TO_TOP)
}
else {
	Mobile.scrollToText('LOGOUT!', FailureHandling.STOP_ON_FAILURE)
}
Button.tap('Logout Button', timeout)

if (deviceIsiOS) {
	Mobile.closeApplication()
}
else {
	driver.closeApp()
}


