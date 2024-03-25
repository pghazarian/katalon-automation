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

'Open the App'
Mobile.startApplication(GlobalVariable.Ministry_App_Path, true)

'Tap Login button '
Mobile.tap(findTestObject('Ministry App/Login button'), 0)

Mobile.setText(findTestObject('Object Repository/Ministry App/Email Address text field'), UserName, 5)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Ministry App/Password Text Field'), 0)

Mobile.setEncryptedText(findTestObject('Ministry App/Password Text Field'), Password, 0)

Mobile.tap(findTestObject('Object Repository/Ministry App/Sign In Button'), 0)

Mobile.tap(findTestObject('Object Repository/Ministry App/Continue Button'), 0)

Mobile.tap(findTestObject('Object Repository/Ministry App/Got It Button'), 0)

