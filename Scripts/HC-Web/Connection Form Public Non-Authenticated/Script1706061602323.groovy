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

WebUI.openBrowser('https://hc-stage.saddleback.com/public/connection-form/72/cris-test-connection-form')

WebUI.verifyElementText(findTestObject('HC-Web/Connection Form Public/FirstNameField'), '')

inputValue = WebUI.getAttribute(findTestObject('HC-Web/Connection Form Public/FirstNameField'), 'value')

'Verify the first name field value is blank'
WebUI.verifyEqual(inputValue, '')

WebUI.verifyElementText(findTestObject('HC-Web/Connection Form Public/LastNameField'), '')

inputValue = WebUI.getAttribute(findTestObject('HC-Web/Connection Form Public/LastNameField'), 'value')

'Verify the last name field value is blank'
WebUI.verifyEqual(inputValue, '')

inputValue = WebUI.getAttribute(findTestObject('HC-Web/Connection Form Public/EmailField'), 'value')

'Verify the email field value is blank'
WebUI.verifyEqual(inputValue, '')

WebUI.closeBrowser()

