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
import java.text.SimpleDateFormat as SimpleDateFormat

def date = new Date()

def sdf = new SimpleDateFormat('MM/dd/yyyy HH:mm:ss')

def CurrentDateTime = sdf.format(date)

def FormPath = HostUrl + PublicConnectionFormPath

def AdminFormPath = HostUrl + ConnectionFormManagementPath

def MessageText = 'Romans 8:28' + ' - ' + CurrentDateTime

WebUI.openBrowser(HostUrl)

WebUI.setText(findTestObject('Object Repository/HC-Web/Page_Saddleback Identity Server/input_Username'), UserName)

WebUI.setEncryptedText(findTestObject('Object Repository/HC-Web/Page_Saddleback Identity Server/input_Password'), Password)

'Login'
WebUI.click(findTestObject('Object Repository/HC-Web/Page_Saddleback Identity Server/button_Sign In'))

'Go to the Connection Form Admin screen'
WebUI.navigateToUrl(AdminFormPath)

'Check that the form is unpublished'
WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Publish'), 'Publish')

'Publish the connection form (to make it publicly available)'
WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Publish'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Yes'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/a_View Page'))

not_run: WebUI.switchToWindowTitle('Healthy Church')

WebUI.navigateToUrl(FormPath)

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

//WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/label_Did you complete Class 101check'))

TextFieldObject = CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'(FormInputFieldXPath)

WebUI.setText(TextFieldObject, MessageText)

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Submit'))

WebUI.delay(2)

not_run: WebUI.waitForElementPresent(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Success'), 0)

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Success'), 'Success')

WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Your form has been received'), 
    0)

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Your form has been received'), 
    'Your form has been received')

'Go to the Connection Form Admin screen'
WebUI.navigateToUrl(AdminFormPath)

'Check that the form is published'
WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Unpublish'), 'Unpublish')

'Unpublish the form'
WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Unpublish'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Yes'))

WebUI.waitForElementPresent(findTestObject('HC-Web/Connection Form/Overview/Unpublished'), 2)

'Verify that the form is not published'
WebUI.verifyElementText(findTestObject('HC-Web/Connection Form/Overview/Unpublished'), 'Unpublished')

WebUI.closeBrowser()

