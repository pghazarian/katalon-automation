import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword as MobileAbstractKeyword
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

/*
 * Documentation for the DetroitLabs library: https://github.com/detroit-labs/katalon-mobile-util?tab=readme-ov-file#textfield
 */

if (!UserName?.trim()) {
 	UserName = GlobalVariable.Admin_UserName
}

if (!Password?.trim()) {
	Password = GlobalVariable.Admin_Password
}

int timeout = 7

Button.initialize(timeout, FailureHandling.OPTIONAL)

// OS checks
if (Device.isIOS()) {
    println('This is an iOS device.')
}

if (Device.isAndroid()) {
    println('This is an Android device.')
}

println(Device.getDeviceOS())

// setup configuration for the apps
// Android
String androidFile = GlobalVariable.AppFileLocation_Android

String androidAppId = GlobalVariable.CompanionApp_BundleId 

App androidApp = new App(androidFile, androidAppId)

// iOS
String iosFile = 'App Files/Companion App/ios/ios-stage-build.ipa'

String iosAppId = GlobalVariable.CompanionApp_BundleId

App iosApp = new App(iosFile, iosAppId)

// Setup the Object Repository base paths for each OS
Finder.setIOSRepository('Object Repository/Companion App/iOS')

Finder.setAndroidRepository('Object Repository/Companion App/Android')

// Start App based on 
boolean removeAppBeforeTest = false // change this to false to keep the app state between tests

Device.startApp([iosApp, androidApp], removeAppBeforeTest)

Mobile.delay(timeout)
Mobile.waitForElementPresent(Finder.findButton("Nav/Home Navigation Button"), 5)

'if there is a user already logged in we will skip the splash screen and need to log them out'
if (Mobile.verifyElementVisible(Finder.findButton('Nav/Home Navigation Button'), timeout, FailureHandling.OPTIONAL)) {
	
	if (Mobile.verifyElementVisible(Finder.findButton('Nav/Profile Avatar Navigation Button'), timeout, FailureHandling.OPTIONAL)) {
		'Tap on the profile avatar in the navigation'
		Button.tap('Nav/Profile Avatar Navigation Button')
	}
	else {
		'Tap on the profile avatar in the navigation'
		Button.tap('Nav/Profile No Avatar Navigation Button')
	}
	
	Mobile.waitForElementPresent(Finder.findButton("Profile/Settings Gear"), 5)
		
	'Tap on the settings gear button'
	Button.tap('Profile/Settings Gear')
	
//	'Tap on the Account & Notifications button'
//	Button.tap('Profile/Settings/Account Notifications')
	
	'tap on the settings Account & Notifications tile button'
	Mobile.waitForElementPresent(Finder.findButton("Profile/Settings/Account Notifications"), 5)
	Button.tap('Profile/Settings/Account Notifications')
		
	'tap on the logout button'
	Mobile.waitForElementPresent(Finder.findButton("Profile/Settings/Account Notifications Page/Logout"), 7)
	Button.tap('Profile/Settings/Account Notifications Page/Logout')
}

'Click Continue as Guest Button'
Button.tap('Continue as Guest')

Mobile.scrollToText('Lake Forest')

'set the default campus to Anaheim'
//Mobile.tap(Finder.findLabel("Home/Campus Selector/Anaheim"), timeout)
Mobile.tap(Finder.findLabel("Home/Campus Selector/Lake Forest"), timeout)


'tap on the Apply button'
Button.tap("Home/Campus Selector/Apply", timeout)



