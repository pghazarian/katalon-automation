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

Mobile.startApplication('/Users/hagopanush/Downloads/hc-android-release.apk', true)

Mobile.switchToNative()

Mobile.tap(findTestObject('Object Repository/ME App Android/Android Login Stuff/ME Log In or Create an Account (LP Page)'), 0)

Mobile.switchToNative()

Mobile.tap(findTestObject('Object Repository/Companion App/Android/Text Fields/Login/Email Address Text Field'), 0)

Mobile.setText(findTestObject('Object Repository/Companion App/Android/Text Fields/Login/Email Address Text Field'), 'hagopgsb@gmail.com', 
    0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/Companion App/Android/Password Edit Text'), 0)

Mobile.setText(findTestObject('Object Repository/Ministry App/Login/Password Text Field'), 'Password@1', 0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Object Repository/ME App Android/Android Login Stuff/Android Sign In Button'), 0)

Mobile.tap(findTestObject('Object Repository/ME App Android/Digital Program/Digital Program Tile (ME)'), 0)

Mobile.switchToNative()

Mobile.tap(findTestObject('Object Repository/ME App Android/Digital Program/DP NEW START Button'), 0)

Mobile.switchToNative()

Mobile.getText(findTestObject('Object Repository/ME App Android/Digital Program/DP New Start Heading Text'), 
    0)

Mobile.pressBack()

Mobile.switchToNative()

Mobile.tap(findTestObject('ME App Android/Digital Program/DP BAPTISM Button'), 0)

Mobile.switchToNative()

Mobile.getText(findTestObject('Object Repository/ME App Android/Digital Program/DP Batism Heading Text'), 0)

Mobile.pressBack()

Mobile.switchToNative()

Mobile.closeApplication()

