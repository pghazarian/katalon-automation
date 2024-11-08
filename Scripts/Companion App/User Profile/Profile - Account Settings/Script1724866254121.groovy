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
Open Companion App
Login
Go to Profile Photo
Go to Account Settings
Verify Text Present - Login Credentials
Verify Text Present - Notification Preferences
Verify Text Present - About
Under About section
Verify Text Present - App Name
Verify Text Present - Version
Verify Text Present - Build Number
Verify Text Present - Environment
Under Notification Preferences
Toggle off - Allow Notification
Go to Home
Go to Profile Photo
Go to Account Settings
Verify Allow Notification is off
Toggle on - Allow Notification
Toggle off - Verse of the Day
Toggle off - Daily Devotional
Toggle off - Mobile Announcement
Save
Go to Home
Go to Profile Photo
Go to Account Settings
Verify Verse of the Day, Daily Devotional and Mobile Announcement toggles are all off
Toggle on - Verse of the Day
Toggle on - Daily Devotional
Toggle on - Mobile Announcement
Save
Go to Home
Go to Profile Photo
Go to Account Settings
Verify Verse of the Day, Daily Devotional and Mobile Announcement toggles are all on again
*/

// Open Companion App
//String androidFile = GlobalVariable.AppFileLocation_Android //'App Files/Companion App/Android/android-stage-build.apk'
//String androidAppId = GlobalVariable.CompanionApp_BundleId //"com.healthychurch.companion.stage"
Mobile.startExistingApplication('com.healthychurch.companion.stage')

// Login Button
Mobile.tap(findTestObject('Object Repository/Hagop_Testing/Login/Login Button'), 0)

// Enter Credentials and Submit
Mobile.verifyElementText(findTestObject('Object Repository/Hagop_Testing/Login/Sign in Header'), 'Sign In')
Mobile.setText(findTestObject('Object Repository/Hagop_Testing/Login/Email Address Text Field'), 'hagopgsb@gmail.com', 0)
Mobile.setEncryptedText(findTestObject('Object Repository/Hagop_Testing/Login/Password Text Field'), 'p4y+y39Ir5OTdtOb306gDg==', 0)
Mobile.hideKeyboard()
Mobile.tap(findTestObject('Object Repository/Hagop_Testing/Login/Sign in Button'), 0)

// Go to Profile Settings
Mobile.tap(findTestObject('Object Repository/Hagop_Testing/Login/Profile Button'),0)
Mobile.tap(findTestObject('Object Repository/Hagop_Testing/Login/My Profile Image Button'),0)

// Go to Account & Notifications Tile
Mobile.tap(findTestObject('Object Repository/Hagop_Testing/Account and Notifications/Account and Notifications Tile'),0)

// Verify Text Present - Login Credentials
Mobile.verifyElementText(findTestObject('Object Repository/Hagop_Testing/Account and Notifications/Account Settings Header'), 'Login Credentials')

// Verify Log Out Button Present
Mobile.verifyElementExist(findTestObject('Object Repository/Hagop_Testing/Login/Log Out Button'), 0)

// Verify Text Present - Notification Preferences
Mobile.verifyElementText(findTestObject('Object Repository/Hagop_Testing/Account and Notifications/Account Settings Notification Header'), 'Notification Preferences')


// Under Notification Preferences
// Verify Toggle on - Allow Notification
Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Hagop_Testing/Account and Notifications/Allow Notifications toggle'), 'checked', 'true', 0)
Mobile.tap(findTestObject('Object Repository/Hagop_Testing/Account and Notifications/Allow Notifications toggle'), 0)

// Verify Allow Notification is off
Mobile.tap(findTestObject('Object Repository/Hagop_Testing/Login/Account Settings Back button'), 0)
Mobile.tap(findTestObject('Object Repository/Hagop_Testing/Account and Notifications/Account and Notifications Tile'),0)
Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Hagop_Testing/Account and Notifications/Allow Notifications toggle'), 'checked', 'false', 0)

// Toggle on - Allow Notification
Mobile.tap(findTestObject('Object Repository/Hagop_Testing/Account and Notifications/Allow Notifications toggle'), 0)
Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Hagop_Testing/Account and Notifications/Allow Notifications toggle'), 'checked', 'true', 0)

// Toggle off - Verse of the Day
//Mobile.tap(findTestObject('Object Repository/Hagop_Testing/Account and Notifications/Verse of the Day Toggle'), 0)

// Toggle off - Daily Devotional
Mobile.tap(findTestObject('Object Repository/Hagop_Testing/Account and Notifications/Daily Devotional Toggle'), 0)

// Toggle off - Mobile Announcement
Mobile.tap(findTestObject('Object Repository/Hagop_Testing/Account and Notifications/Mobile Announcement Toggle'), 0)

// Verify Verse of the Day, Daily Devotional and Mobile Announcement toggles are all off
Mobile.tap(findTestObject('Object Repository/Hagop_Testing/Login/Account Settings Back button'), 0)
Mobile.tap(findTestObject('Object Repository/Hagop_Testing/Account and Notifications/Account and Notifications Tile'),0)
//Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Hagop_Testing/Account and Notifications/Verse of the Day Toggle'), 'checked', 'false', 0)
Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Hagop_Testing/Account and Notifications/Daily Devotional Toggle'), 'checked', 'false', 0)
Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Hagop_Testing/Account and Notifications/Mobile Announcement Toggle'), 'checked', 'false', 0)

// Toggle on - Verse of the Day
//Mobile.tap(findTestObject('Object Repository/Hagop_Testing/Account and Notifications/Verse of the Day Toggle'), 0)

// Toggle on - Daily Devotional
Mobile.tap(findTestObject('Object Repository/Hagop_Testing/Account and Notifications/Daily Devotional Toggle'), 0)

// Toggle on - Mobile Announcement
Mobile.tap(findTestObject('Object Repository/Hagop_Testing/Account and Notifications/Mobile Announcement Toggle'), 0)

// Verify Verse of the Day, Daily Devotional and Mobile Announcement toggles are all on again
//Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Hagop_Testing/Account and Notifications/Verse of the Day Toggle'), 'checked', 'true', 0)
Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Hagop_Testing/Account and Notifications/Daily Devotional Toggle'), 'checked', 'true', 0)
Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Hagop_Testing/Account and Notifications/Mobile Announcement Toggle'), 'checked', 'true', 0)
