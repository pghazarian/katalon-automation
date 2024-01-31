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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.text.SimpleDateFormat as SimpleDateFormat

/* Environment Test Connection Form URLs
 * https://hc.saddleback.com/data-capture/connection-forms/674/overview
https://hc-stage.saddleback.com/data-capture/connection-forms/3830/overview
https://hc-stage2.saddleback.com/data-capture/connection-forms/181/overview
https://hc-qa.saddleback.com/data-capture/connection-forms/36/overview
https://hc-dev.saddleback.com/data-capture/connection-forms/226/overview
 */

WebUI.callTestCase(findTestCase('HC-Web/Shared/Validate Safe Environment'), [(null) : null], FailureHandling.STOP_ON_FAILURE)

def date = new Date()

def sdf = new SimpleDateFormat('yyyy-MM-dd HH:mm:ss')

def CurrentDateTime = sdf.format(date)

def FormPath = GlobalVariable.HC_HostUrl + PublicConnectionFormPath

def AdminFormPath = GlobalVariable.HC_HostUrl + ConnectionFormManagementPath

def SingleTextValue = "Single Text - $CurrentDateTime"

def ParagraphTextValue = "Paragraph Text - $CurrentDateTime"

'Login'
not_run: WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password], FailureHandling.STOP_ON_FAILURE)

WebUI.openBrowser(FormPath)

'Go to the Connection Form Admin screen'
not_run: WebUI.navigateToUrl(AdminFormPath)

'Check that the form is unpublished'
not_run: WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Publish'), 'Publish')

'Publish the connection form (to make it publicly available)'
not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Publish'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Yes'))

not_run: WebUI.navigateToUrl(FormPath)

not_run: inputValue = WebUI.getAttribute(findTestObject('HC-Web/Connection Form Public/FirstNameField'), 'value')

'Verify the first name field value is not blank'
not_run: WebUI.verifyNotEqual(inputValue, '')

not_run: inputValue = WebUI.getAttribute(findTestObject('HC-Web/Connection Form Public/LastNameField'), 'value')

'Verify the last name field value is not blank'
not_run: WebUI.verifyNotEqual(inputValue, '')

not_run: inputValue = WebUI.getAttribute(findTestObject('HC-Web/Connection Form Public/EmailField'), 'value')

'Verify the email field value is not blank'
not_run: WebUI.verifyNotEqual(inputValue, '')

'Update the Single Line Text field'
CustomKeywords.'customUtility.FormHelper.setTextfieldValue'("Can you enter a sentence?", SingleTextValue)

'Update the Paragraph Text field'
CustomKeywords.'customUtility.FormHelper.setTextAreaValue'("Can you enter a paragraph?", ParagraphTextValue)

'Set the date control value'
date = new Date().plus(3)

CustomKeywords.'customUtility.FormHelper.setDateFieldValue'('Please choose a Date', date)

'Check item(s) in the single checkbox list'
CustomKeywords.'customUtility.FormHelper.setGroupCheckboxValue'('Check Single - Label', 'Check Single')

'Check item(s) in the group checkbox list'
CustomKeywords.'customUtility.FormHelper.setGroupCheckboxValue'('Check Group', 'Option 1,Option 3')

'Select the multiple choice (radio button) value'
CustomKeywords.'customUtility.FormHelper.setMultipleChoiceControlValue'('Multiple Choice', 'Option 3')

'Select the drop down value'
CustomKeywords.'customUtility.FormHelper.setDropDownValue'('Please Select from the Drop-down', 'Option 1')

assert true

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Submit'))

not_run: WebUI.delay(2)

not_run: WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Success'), 'Success')

not_run: WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Your form has been received'), 
    0)

not_run: WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Your form has been received'), 
    'Your form has been received')

'Go to the Connection Form Admin screen'
not_run: WebUI.navigateToUrl(AdminFormPath)

'Check that the form is published'
not_run: WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Unpublish'), 'Unpublish')

'Unpublish the form'
not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Unpublish'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Yes'))

not_run: WebUI.waitForElementPresent(findTestObject('HC-Web/Connection Form/Overview/Unpublished'), 2)

'Verify that the form is not published'
not_run: WebUI.verifyElementText(findTestObject('HC-Web/Connection Form/Overview/Unpublished'), 'Unpublished')

not_run: WebUI.closeBrowser()

