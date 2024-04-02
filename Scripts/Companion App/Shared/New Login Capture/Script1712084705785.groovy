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

Mobile.startApplication('/Users/crisfrancisco/Documents/GitHub/katalon-automation/App Files/Companion App/iOS/ios-stage-build.ipa', 
    true)

Mobile.tap(findTestObject('Companion App/iOS/XCUIElementTypeOther - ui-button--intro-screen-login'), 0)

Mobile.tap(findTestObject('Object Repository/Companion App/iOS/Buttons/blahblah'), 0)

Mobile.setText(findTestObject('Object Repository/Companion App/iOS/Login/Email Address Text Field'), 'crisf@saddleback.com', 
    0)

Mobile.setText(findTestObject('Object Repository/Companion App/iOS/Login/Password Text Field'), 'Saddleback123!', 0)

Mobile.tap(findTestObject('Object Repository/Companion App/iOS/XCUIElementTypeOther'), 0)

Mobile.tap(findTestObject('Object Repository/Companion App/iOS/Login/Sign In Button'), 0)

Mobile.switchToNative()

Mobile.tap(findTestObject('Object Repository/Companion App/iOS/XCUIElementTypeButton - Journey, tab, 2 of 6'), 0)

Mobile.closeApplication()

