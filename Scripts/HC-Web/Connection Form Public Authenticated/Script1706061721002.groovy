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

WebUI.openBrowser(HostUrl)

WebUI.setText(findTestObject('Object Repository/HC-Web/Page_Saddleback Identity Server/input_Username'), UserName)

WebUI.setEncryptedText(findTestObject('Object Repository/HC-Web/Page_Saddleback Identity Server/input_Password'), Password)

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Saddleback Identity Server/button_Sign In'))

WebUI.navigateToUrl('https://hc-stage.saddleback.com/public/connection-form/72/cris-test-connection-form')

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/inputconnection_form_public--personal_form__2f23c0'), 
    '')

WebUI.verifyElementText(findTestObject('HC-Web/Connection Form Public/FirstNameField'), '')

inputValue = WebUI.getAttribute(findTestObject('HC-Web/Connection Form Public/FirstNameField'), 'value')

'Verify the first name field value is not blank'
WebUI.verifyNotEqual(inputValue, '')

WebUI.verifyElementText(findTestObject('HC-Web/Connection Form Public/LastNameField'), '')

inputValue = WebUI.getAttribute(findTestObject('HC-Web/Connection Form Public/LastNameField'), 'value')

'Verify the last name field value is not blank'
WebUI.verifyNotEqual(inputValue, '')

inputValue = WebUI.getAttribute(findTestObject('HC-Web/Connection Form Public/EmailField'), 'value')

'Verify the email field value is not blank'
WebUI.verifyNotEqual(inputValue, '')

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/label_Did you complete Class 101check'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/inputconnection_form_public--question_field_21225'), 
    'Romans 8:28')

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Submit'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Success'), 'Success')

WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Your form has been received'), 
    0)

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Your form has been received'), 
    'Your form has been received')

WebUI.closeBrowser()

