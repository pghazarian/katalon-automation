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
def date = new Date()

def CurrentDateTime = CustomKeywords.'customUtility.StringHelper.getIsoFormatDate'(date)

def FormPath = GlobalVariable.HC_HostUrl + PublicConnectionFormPath

def AdminFormPath = GlobalVariable.HC_HostUrl + ConnectionFormManagementPath

def DateSelected = new Date().plus(3)

def SingleTextValue = "Single Text - $CurrentDateTime"

def ParagraphTextValue = "Paragraph Text - $CurrentDateTime"

def SingleCheckBoxSelection = 'Check Single'

def GroupCheckBoxSelection = 'Option 1,Option 3'

def RadioButtonSelection = 'Option 2'

def DropDownSelection = 'Option 1'

def LabelValueDate = 'Please choose a Date'

def LabelValueSingleLineText = 'Can you enter a sentence?'

def LabelValueParagraphText = 'Can you enter a paragraph?'

def LabelValueSingleCheckbox = 'Check Single - Label'

def LabelValueGroupCheckbox = 'Check Group'

def LabelValueRadioButton = 'Multiple Choice'

def LabelValueDropDown = 'Please Select from the Drop-down'

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password], FailureHandling.STOP_ON_FAILURE)

'Go to the Connection Form Admin screen'
WebUI.navigateToUrl(AdminFormPath)

def PublishButton = findTestObject('Object Repository/HC-Web/Connection Form/Overview/PublishLinkButton')

if (CustomKeywords.'customUtility.TestObjectHelper.isElementPresent'(PublishButton, 0)) {
    'Check that the form is unpublished'
    WebUI.verifyElementText(PublishButton, 'Publish')

    'Publish the connection form (to make it publicly available)'
    WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Overview/span_Publish'))

    WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Overview/div_Yes'))
}

WebUI.navigateToUrl(FormPath)

WebUI.waitForElementPresent(findTestObject('HC-Web/Connection Form Public/FirstNameField'), 2)

FirstName = WebUI.getAttribute(findTestObject('HC-Web/Connection Form Public/FirstNameField'), 'value')

'Verify the first name field value is not blank'
WebUI.verifyNotEqual(FirstName, '')

LastName = WebUI.getAttribute(findTestObject('HC-Web/Connection Form Public/LastNameField'), 'value')

'Verify the last name field value is not blank'
WebUI.verifyNotEqual(LastName, '')

Email = WebUI.getAttribute(findTestObject('HC-Web/Connection Form Public/EmailField'), 'value')

'Verify the email field value is not blank'
WebUI.verifyNotEqual(Email, '')

'Update the Single Line Text field'
CustomKeywords.'customUtility.FormHelper.setTextfieldValue'(LabelValueSingleLineText, SingleTextValue)

'Update the Paragraph Text field'
CustomKeywords.'customUtility.FormHelper.setTextAreaValue'(LabelValueParagraphText, ParagraphTextValue)

'Check item(s) in the single checkbox list'
CustomKeywords.'customUtility.FormHelper.setGroupCheckboxValue'(LabelValueSingleCheckbox, SingleCheckBoxSelection)

'Check item(s) in the group checkbox list'
CustomKeywords.'customUtility.FormHelper.setGroupCheckboxValue'(LabelValueGroupCheckbox, GroupCheckBoxSelection)

'Select the multiple choice (radio button) value'
CustomKeywords.'customUtility.FormHelper.setMultipleChoiceControlValue'(LabelValueRadioButton, RadioButtonSelection)

'Select the drop down value'
CustomKeywords.'customUtility.FormHelper.setDropDownValue'(LabelValueDropDown, DropDownSelection)

'Set the date control value'
CustomKeywords.'customUtility.FormHelper.setDateFieldValue'(LabelValueDate, DateSelected)

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form Public/span_Submit'))

WebUI.delay(2)

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Connection Form Public/div_Success'), 'Success')

WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Connection Form Public/div_Your form has been received'), 
    0)

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Connection Form Public/div_Your form has been received'), 
    'Your form has been received')

'Go to the Connection Form Admin screen'
WebUI.navigateToUrl(AdminFormPath)

'Click on the Entries menu'
WebUI.click(findTestObject('HC-Web/Connection Form/SubNav/Entries'))

'Open an entry'
WebUI.click(findTestObject('HC-Web/Connection Form/Entries/FirstRow'))

'Verify the first name field value'
CustomKeywords.'customUtility.TestObjectHelper.verifyTextFieldValueEqual'(findTestObject('HC-Web/Connection Form/Entry/FirstNameTextField'),
	FirstName)

'Verify the last name'
CustomKeywords.'customUtility.TestObjectHelper.verifyTextFieldValueEqual'(findTestObject('HC-Web/Connection Form/Entry/LastNameTextField'), 
    LastName)

'Verify the email'
CustomKeywords.'customUtility.TestObjectHelper.verifyTextFieldValueEqual'(findTestObject('HC-Web/Connection Form/Entry/EmailTextField'), 
    Email)

'Verify single line text'
CustomKeywords.'customUtility.TestObjectHelper.verifyTextFieldValueEqual'(CustomKeywords.'customUtility.FormHelper.getTextInputByLabel'(
        LabelValueSingleLineText), SingleTextValue)

'Verify paragraph text'
CustomKeywords.'customUtility.TestObjectHelper.verifyTextAreaValueEqual'(CustomKeywords.'customUtility.FormHelper.getTextAreaByLabel'(
        LabelValueParagraphText), ParagraphTextValue)

'Verify date text'
CustomKeywords.'customUtility.TestObjectHelper.verifyTextFieldValueEqual'(CustomKeywords.'customUtility.FormHelper.getTextInputByLabel'(
        LabelValueDate), CustomKeywords.'customUtility.StringHelper.getUSFormatDateForControl'(DateSelected))

'Verify radio selection'
WebUI.verifyEqual(CustomKeywords.'customUtility.FormHelper.getRadioInputSelectionByLabel'(LabelValueRadioButton), RadioButtonSelection)

'Verify Single checkbox selection'
WebUI.verifyEqual(CustomKeywords.'customUtility.FormHelper.getCheckBoxSelectionByLabel'(LabelValueSingleCheckbox), SingleCheckBoxSelection)

'Verify multiple checkbox selection'
WebUI.verifyEqual(CustomKeywords.'customUtility.FormHelper.getCheckBoxSelectionByLabel'(LabelValueGroupCheckbox), GroupCheckBoxSelection)

'Verify dropdown selection'
WebUI.verifyEqual(CustomKeywords.'customUtility.FormHelper.getDropDownSelectionByLabel'(LabelValueDropDown), DropDownSelection)

'Delete the form entry'
WebUI.click(findTestObject('HC-Web/Connection Form/Entry/Actions/ActionsButton'))

WebUI.click(findTestObject('HC-Web/Connection Form/Entry/Actions/DeleteEntry'))

WebUI.click(findTestObject('HC-Web/Connection Form/Entry/Actions/Confirmation/Yes'))

WebUI.delay(3)

WebUI.waitForElementPresent(findTestObject('HC-Web/Connection Form/Entries/EntriesHeader'), 3)

//WebUI.click(findTestObject('HC-Web/Connection Form/SubNav/Overview'))

WebUI.navigateToUrl(AdminFormPath)

WebUI.waitForElementPresent(findTestObject('Object Repository/HC-Web/Connection Form/Overview/Form Details Header'), 2)

'Unpublish the form'
WebUI.waitForElementPresent(findTestObject('Object Repository/HC-Web/Connection Form/Overview/span_Unpublish'), 2)

'Check that the form is published'
WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Connection Form/Overview/span_Unpublish'), 'Unpublish')

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Overview/span_Unpublish'))

//WebUI.delay(1)

WebUI.waitForElementPresent(findTestObject('Object Repository/HC-Web/Connection Form/Overview/div_Yes'), 2)

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Overview/div_Yes'))

WebUI.waitForElementPresent(findTestObject('HC-Web/Connection Form/Overview/PublishLinkButton'), 2)

'Verify that the form is not published'
WebUI.verifyElementText(findTestObject('HC-Web/Connection Form/Overview/PublishLinkButton'), 'Publish')

WebUI.closeBrowser()

