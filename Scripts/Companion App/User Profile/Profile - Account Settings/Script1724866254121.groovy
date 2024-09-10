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
// Open Companion App
Mobile.startApplication('companion.app.package')

// Login
Mobile.tap(findTestObject('login_button'))

// Go to Profile Photo
Mobile.tap(findTestObject('profile_photo_button'))

// Go to Account Settings
Mobile.tap(findTestObject('account_settings_button'))

// Verify Text Present - Login Credentials
Mobile.verifyElementText(findTestObject('login_credentials_text'), 'Login Credentials')

// Verify Text Present - Notification Preferences
Mobile.verifyElementText(findTestObject('notification_preferences_text'), 'Notification Preferences')

// Verify Text Present - About
Mobile.verifyElementText(findTestObject('about_text'), 'About')

// Under About section
// Verify Text Present - App Name
Mobile.verifyElementText(findTestObject('app_name_text'), 'App Name')

// Verify Text Present - Version
Mobile.verifyElementText(findTestObject('version_text'), 'Version')

// Verify Text Present - Build Number
Mobile.verifyElementText(findTestObject('build_number_text'), 'Build Number')

// Verify Text Present - Environment
Mobile.verifyElementText(findTestObject('environment_text'), 'Environment')

// Under Notification Preferences
// Toggle off - Allow Notification
Mobile.tap(findTestObject('allow_notification_toggle'))
Mobile.tap(findTestObject('save_button'))

// Go to Home
Mobile.tap(findTestObject('home_button'))

// Go to Profile Photo
Mobile.tap(findTestObject('profile_photo_button'))

// Go to Account Settings
Mobile.tap(findTestObject('account_settings_button'))

// Verify Allow Notification is off
Mobile.verifyElementAttributeValue(findTestObject('allow_notification_toggle'), 'checked', 'false')

// Toggle on - Allow Notification
Mobile.tap(findTestObject('allow_notification_toggle'))

// Toggle off - Verse of the Day
Mobile.tap(findTestObject('verse_of_the_day_toggle'))

// Toggle off - Daily Devotional
Mobile.tap(findTestObject('daily_devotional_toggle'))

// Toggle off - Mobile Announcement
Mobile.tap(findTestObject('mobile_announcement_toggle'))

// Save
Mobile.tap(findTestObject('save_button'))

// Go to Home
Mobile.tap(findTestObject('home_button'))

// Go to Profile Photo
Mobile.tap(findTestObject('profile_photo_button'))

// Go to Account Settings
Mobile.tap(findTestObject('account_settings_button'))

// Verify Verse of the Day, Daily Devotional and Mobile Announcement toggles are all off
Mobile.verifyElementAttributeValue(findTestObject('verse_of_the_day_toggle'), 'checked', 'false')
Mobile.verifyElementAttributeValue(findTestObject('daily_devotional_toggle'), 'checked', 'false')
Mobile.verifyElementAttributeValue(findTestObject('mobile_announcement_toggle'), 'checked', 'false')

// Toggle on - Verse of the Day
Mobile.tap(findTestObject('verse_of_the_day_toggle'))

// Toggle on - Daily Devotional
Mobile.tap(findTestObject('daily_devotional_toggle'))

// Toggle on - Mobile Announcement
Mobile.tap(findTestObject('mobile_announcement_toggle'))

// Save
Mobile.tap(findTestObject('save_button'))

// Go to Home
Mobile.tap(findTestObject('home_button'))

// Go to Profile Photo
Mobile.tap(findTestObject('profile_photo_button'))

// Go to Account Settings
Mobile.tap(findTestObject('account_settings_button'))

// Verify Verse of the Day, Daily Devotional and Mobile Announcement toggles are all on again
Mobile.verifyElementAttributeValue(findTestObject('verse_of_the_day_toggle'), 'checked', 'true')
Mobile.verifyElementAttributeValue(findTestObject('daily_devotional_toggle'), 'checked', 'true')
Mobile.verifyElementAttributeValue(findTestObject('mobile_announcement_toggle'), 'checked', 'true')
*/