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

Mobile.startExistingApplication('com.healthychurch.companion.development')

not_run: Mobile.tap(findTestObject('Object Repository/Companion App/iOS/Navigation Menu/Home Tab'), 0)

not_run: Mobile.tap(findTestObject('Object Repository/Companion App/iOS/Navigation Menu/Journey Tab'), 
    0)

not_run: Mobile.tap(findTestObject('Object Repository/Companion App/iOS/Navigation Menu/Profile Tab'), 
    0)

not_run: Mobile.tap(findTestObject('Object Repository/Companion App/iOS/Navigation Menu/Groups Tab'), 0)

not_run: Mobile.tap(findTestObject('Object Repository/Companion App/iOS/Navigation Menu/Discover Tab'), 
    0)

not_run: Mobile.tap(findTestObject('Object Repository/Companion App/iOS/Navigation Menu/Setting Tab'), 
    0)

not_run: Mobile.verifyElementText(findTestObject('Object Repository/Companion App/iOS/XCUIElementTypeStaticText - SettingsRoot'), 
    'SettingsRoot')

not_run: Mobile.tap(findTestObject('Object Repository/Companion App/iOS/Navigation Menu/Ministries Tab'), 
    0)

not_run: Mobile.tap(findTestObject('Object Repository/Companion App/iOS/Navigation Menu/Events Tab'), 0)

Mobile.tap(findTestObject('Object Repository/Companion App/iOS/Navigation Menu/Journey Tab'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Companion App/iOS/XCUIElementTypeStaticText - text (3)'), 'Thursday, March 28')

Mobile.verifyElementExist(findTestObject('Object Repository/Companion App/iOS/XCUIElementTypeOther - Journey 6 Start Journey'), 
    0)

not_run: Mobile.verifyElementExist(findTestObject('Object Repository/Companion App/iOS/XCUIElementTypeStaticText - text'), 
    0)

not_run: Mobile.verifyElementExist(findTestObject('Companion App/iOS/Journey/Your Day Heading'), 0)

Mobile.tap(findTestObject('Companion App/iOS/Journey/What is a Journey Link Button'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Companion App/iOS/XCUIElementTypeStaticText - text'), 'What Is a Journey, Anyway?')

Mobile.swipe(300, 250, 80, 250)

Mobile.verifyElementExist(findTestObject('Companion App/iOS/Journey/A Helpful Guide Header'), 0)

Mobile.swipe(300, 250, 80, 250)

Mobile.verifyElementExist(findTestObject('Companion App/iOS/Journey/Explore and Discover Header'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/Companion App/iOS/XCUIElementTypeStaticText - text'), 'What Is a Journey, Anyway?')

Mobile.tap(findTestObject('Object Repository/Companion App/iOS/XCUIElementTypeOther - Browse Journeys'), 0)

Mobile.closeApplication()

