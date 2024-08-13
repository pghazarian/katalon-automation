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
import org.openqa.selenium.WebElement as WebElement
import io.appium.java_client.ios.IOSDriver as IOSDriver
import java.lang.String as String

/*
Launch CA app
Tap on the Profile navigation button
Tap on the translation button in upper left corner
Change to a different language that English (e.g. Spanish)
Tap on Apply button
Tap on Home navigation button
Verify the For You Ribbon Title is translated
Verify the For You Ribbon See All link/button is translated
Verify the Events Ribbon Title is translated
Verify the Events Ribbon See All link/button is translated
Verify the Messages Ribbon Title is translated
Verify the Messages Live Message, Live button is translated
*/

def timeout = 10

// Launch the CA app
boolean CurrentlyLoggedIn 

if (LoggedIn.toBoolean()) {
	CurrentlyLoggedIn = true 
}
else {
	CurrentlyLoggedIn = false 
}

if (CurrentlyLoggedIn) {
    'Open existing app by logging into the app bundle id'
    WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [:], FailureHandling.STOP_ON_FAILURE)
} else {
	return
    'Open existing app while logged out by the app bundle id'
    WebUI.callTestCase(findTestCase('Companion App/Shared/Guest Startup'), [:], FailureHandling.STOP_ON_FAILURE)
}

Boolean deviceIsiOS = false

if (Device.isIOS()) {
    deviceIsiOS = true
}

// need driver to get lists and close app
AppiumDriver<MobileElement> driver = MobileDriverFactory.getDriver()

// Tap on the Profile navigation button
if (Mobile.verifyElementVisible(Finder.findButton('Nav/Profile Avatar Navigation Button'), timeout, FailureHandling.OPTIONAL)) {
	'Tap on the profile avatar in the navigation'
	Button.tap('Nav/Profile Avatar Navigation Button')
}
else {
	'Tap on the profile avatar in the navigation'
	Button.tap('Nav/Profile No Avatar Navigation Button')
}

// Tap on the translation button in the upper left corner
Button.tap('Profile/Translation', timeout)

// Change to a different language than English (e.g. Spanish)
Button.tap('Profile/App Translation/Spanish', timeout)

// Tap on Apply button
Button.tap('Profile/App Translation/Apply', timeout)

// Tap on Home navigation button
Button.tap('Nav/Home Navigation Button', timeout)

// Verify the For You Ribbon Title is translated
Mobile.verifyElementText(Finder.findLabel('Home/For You Ribbon Title'), 'Para Ti')

// Verify the Events Ribbon Title is translated
Mobile.verifyElementText(Finder.findLabel('Home/Events Ribbon Title'), 'Eventos')

// Verify the Events Ribbon See All link/button is translated
Mobile.verifyElementText(Finder.findButton('Home/Home Page/Events See All'), 'Ver todo')

/*
// Verify the Messages Ribbon Title is translated
Mobile.verifyElementText(findTestObject('your_messages_ribbon_title'), 'Expected Translated Text')

// Verify the Messages Live Message, Live button is translated
Mobile.verifyElementText(findTestObject('your_messages_live_button'), 'Expected Translated Text')
*/

// Tap on the Profile navigation button
if (Mobile.verifyElementVisible(Finder.findButton('Nav/Profile Avatar Navigation Button'), timeout, FailureHandling.OPTIONAL)) {
	'Tap on the profile avatar in the navigation'
	Button.tap('Nav/Profile Avatar Navigation Button')
}
else {
	'Tap on the profile avatar in the navigation'
	Button.tap('Nav/Profile No Avatar Navigation Button')
}

// Tap on the translation button in the upper left corner
Button.tap('Profile/Translation', timeout)

// Change back to English translation
Button.tap('Profile/App Translation/English', timeout)

// Tap on Apply button
Button.tap('Profile/App Translation/Apply', timeout)

// Tap on Home navigation button
Button.tap('Nav/Home Navigation Button', timeout)

'Log out'
WebUI.callTestCase(findTestCase('Companion App/Shared/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

if (deviceIsiOS) {
	Mobile.closeApplication()
}
else {
	driver.closeApp()
}
