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

def date = new Date()

def sdf = new SimpleDateFormat('yyyy-MM-dd HH:mm:ss')

def CurrentDateTime = sdf.format(date)

def FormPath = GlobalVariable.HC_HostUrl + PublicConnectionFormPath

def AdminFormPath = GlobalVariable.HC_HostUrl + ConnectionFormManagementPath

def MessageText = "Romans 8:28 - $CurrentDateTime"

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

'Update the Input field'
not_run: TargetTestObject = CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'(FormInputFieldXPath)

not_run: WebUI.setText(TargetTestObject, MessageText)

not_run: CustomFormInputFieldXPath = 'connection_form_public--question_field_21247'

'Update the Single Line Text field'
not_run: TargetTestObject = CustomKeywords.'customUtility.TestObjectHelper.getInputById'(CustomFormInputFieldXPath)

not_run: WebUI.setText(TargetTestObject, SingleTextValue)

not_run: CustomFormParagraphFieldXPath = 'connection_form_public--question_field_21248'

'Update the Paragraph Text field'
not_run: TargetTestObject = CustomKeywords.'customUtility.TestObjectHelper.getTextAreaById'(CustomFormParagraphFieldXPath)

not_run: WebUI.setText(TargetTestObject, ParagraphTextValue)

not_run: GroupCheckboxLabel = 'Group checkbox'

not_run: GroupCheckboxValue = 3

'Check item(s) in the group checkbox list'
not_run: CustomFormGroupCheckboxFieldXPath = "//h3[text()='$GroupCheckboxLabel']/following-sibling::div/div/div/div/label/span[text() = '$GroupCheckboxValue']/parent::label"

not_run: TargetTestObject = CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'(CustomFormGroupCheckboxFieldXPath)

not_run: WebUI.click(TargetTestObject)

not_run: GroupCheckboxValue = 4

'Check item(s) in the group checkbox list'
not_run: CustomFormGroupCheckboxFieldXPath = "//h3[text()='$GroupCheckboxLabel']/following-sibling::div/div/div/div/label/span[text() = '$GroupCheckboxValue']/parent::label"

not_run: TargetTestObject = CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'(CustomFormGroupCheckboxFieldXPath)

not_run: WebUI.click(TargetTestObject)

not_run: MultipleChoiceLabel = 'Multiple Choice'

not_run: MultipleChoiceValue = 3

'Check item(s) in the Multiple Choice list'
not_run: CustomFormMultipleChoiceFieldXPath = "//h3[text()='$MultipleChoiceLabel']/following-sibling::div/div/div/label/span[text() = '$MultipleChoiceValue']/parent::label"

not_run: TargetTestObject = CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'(CustomFormMultipleChoiceFieldXPath)

not_run: WebUI.click(TargetTestObject)

'Select value in a Drop Down List'
CustomFormDropDownFieldXPath = '//div[@id=\'connection_form_public--question_field_21254\']/div/div[@class=\'Select-control\']/div/div'

CustomFormDropDownFieldXPath = '//div[@id=\'connection_form_public--question_field_21254\']/div/div[@class=\'Select-control\']/div'

//CustomFormDropDownFieldXPath = "//div[@id='connection_form_public--question_field_21254']/div/div[@class='Select-control']"
//CustomFormDropDownFieldXPath = "//div[@id='connection_form_public--question_field_21254']/div"
//CustomFormDropDownFieldXPath = "//div[@id='connection_form_public--question_field_21254']"
DropDownValue = '3'

TargetTestObject = CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'(CustomFormDropDownFieldXPath)

WebUI.click(TargetTestObject)

CustomFormDropDownFieldInputXPath = "//div[@id='connection_form_public--question_field_21254']/div/div[@class='Select-control']/div/div/input"
//CustomFormDropDownFieldInputXPath = "div[@id='connection_form_public--question_field_21254']/div/div[@class='Select-control']/div/descendant::input"

TargetTestObject = CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'(CustomFormDropDownFieldInputXPath)

'Type Dropdown value'
WebUI.sendKeys(TargetTestObject, DropDownValue)

'Select the value'
WebUI.sendKeys(TargetTestObject, Keys.chord(Keys.ENTER))

CustomDateFieldXpath = '//div[@id=\'connection_form_public--question_field_21255\']/div/div/input'

DateToSelect = '01/31/2024'

TargetTestObject = CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'(CustomDateFieldXpath)

WebUI.setText(TargetTestObject, DateToSelect)

'Select the date'
WebUI.sendKeys(TargetTestObject, Keys.chord(Keys.ENTER))

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

