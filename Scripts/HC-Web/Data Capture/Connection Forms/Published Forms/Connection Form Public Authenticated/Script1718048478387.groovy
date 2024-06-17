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

def CurrentDateTime = CustomKeywords.'StringHelper.getIsoFormatDate'(date)

'Define values to use in the controls to enter and then verify'
def DateSelected = new Date().plus(3)

def SingleTextValue = "Single Text - $CurrentDateTime"

def ParagraphTextValue = "Paragraph Text - $CurrentDateTime"

def SingleCheckBoxSelection = 'Check Single'

def GroupCheckBoxSelection = 'Option 1,Option 3'

def RadioButtonSelection = 'Option 2'

def DropDownSelection = 'Option 1'

'Define Labels that we will search controls with'
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
CustomKeywords.'NavigationHelper.goToHCUrl'(ConnectionFormManagementPath)

def PublishButton = findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Overview/PublishLinkButton')

if (CustomKeywords.'TestObjectHelper.isElementPresent'(PublishButton, 0)) {
    'Check that the form is unpublished'
    WebUI.verifyElementText(PublishButton, 'Publish')

    'Publish the connection form (to make it publicly available)'
    WebUI.click(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Overview/span_Publish'))

    WebUI.click(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Overview/div_Yes'))
}

WebUI.waitForElementVisible(findTestObject("Object Repository/HC-Web/Data Capture/Connection Forms/Overview/UnpublishLinkButton"), 10)

CustomKeywords.'NavigationHelper.goToHCUrl'(PublicConnectionFormPath)

WebUI.waitForElementPresent(findTestObject('HC-Web/Data Capture/Connection Forms/Overview/Connection Form Public/FirstNameField'), 2)

FirstName = WebUI.getAttribute(findTestObject('HC-Web/Data Capture/Connection Forms/Overview/Connection Form Public/FirstNameField'), 'value')

'Verify the first name field value is not blank'
WebUI.verifyNotEqual(FirstName, '')

LastName = WebUI.getAttribute(findTestObject('HC-Web/Data Capture/Connection Forms/Overview/Connection Form Public/LastNameField'), 'value')

'Verify the last name field value is not blank'
WebUI.verifyNotEqual(LastName, '')

Email = WebUI.getAttribute(findTestObject('HC-Web/Data Capture/Connection Forms/Overview/Connection Form Public/EmailField'), 'value')

'Verify the email field value is not blank'
WebUI.verifyNotEqual(Email, '')

'Update the Single Line Text field'
CustomKeywords.'FormHelper.setTextfieldValue'(LabelValueSingleLineText, SingleTextValue)

'Update the Paragraph Text field'
CustomKeywords.'FormHelper.setTextAreaValue'(LabelValueParagraphText, ParagraphTextValue)

'Check item(s) in the single checkbox list'
CustomKeywords.'FormHelper.setGroupCheckboxValue'(LabelValueSingleCheckbox, SingleCheckBoxSelection)

'Check item(s) in the group checkbox list'
CustomKeywords.'FormHelper.setGroupCheckboxValue'(LabelValueGroupCheckbox, GroupCheckBoxSelection)

'Select the multiple choice (radio button) value'
CustomKeywords.'FormHelper.setMultipleChoiceControlValue'(LabelValueRadioButton, RadioButtonSelection)

'Select the drop down value'
CustomKeywords.'FormHelper.setDropDownValue'(LabelValueDropDown, DropDownSelection)

'Set the date control value'
CustomKeywords.'FormHelper.setDateFieldValue'(LabelValueDate, DateSelected)

WebUI.click(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Overview/Connection Form Public/span_Submit'))

WebUI.delay(2)

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Overview/Connection Form Public/div_Success'), 'Success')

WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Overview/Connection Form Public/div_Your form has been received'), 
    0)

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Overview/Connection Form Public/div_Your form has been received'), 
    'Your form has been received')

'Go to the Connection Form Admin screen'
CustomKeywords.'NavigationHelper.goToHCUrl'(ConnectionFormManagementPath)

'Click on the Entries menu'
WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Entries/Entries'))

'Open an entry'
WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Entries/FirstRow'))

'Verify the first name field value'
CustomKeywords.'TestObjectHelper.verifyTextFieldValueEqual'(findTestObject('HC-Web/Data Capture/Connection Forms/Entries/Add Entry Drawer/FirstNameTextField'),
	FirstName)

'Verify the last name'
CustomKeywords.'TestObjectHelper.verifyTextFieldValueEqual'(findTestObject('HC-Web/Data Capture/Connection Forms/Entries/Add Entry Drawer/LastNameTextField'), 
    LastName)

'Verify the email'
CustomKeywords.'TestObjectHelper.verifyTextFieldValueEqual'(findTestObject('HC-Web/Data Capture/Connection Forms/Entries/Add Entry Drawer/Email Text Field'), 
    Email)

'Verify single line text'
CustomKeywords.'TestObjectHelper.verifyTextFieldValueEqual'(CustomKeywords.'FormHelper.getTextInputByLabel'(
        LabelValueSingleLineText), SingleTextValue)

'Verify paragraph text'
CustomKeywords.'TestObjectHelper.verifyTextAreaValueEqual'(CustomKeywords.'FormHelper.getTextAreaByLabel'(
        LabelValueParagraphText), ParagraphTextValue)

'Verify date text'
CustomKeywords.'TestObjectHelper.verifyTextFieldValueEqual'(CustomKeywords.'FormHelper.getTextInputByLabel'(
        LabelValueDate), CustomKeywords.'StringHelper.getUSFormatDateForControl'(DateSelected))

'Verify radio selection'
WebUI.verifyEqual(CustomKeywords.'FormHelper.getRadioInputSelectionByLabel'(LabelValueRadioButton), RadioButtonSelection)

'Verify Single checkbox selection'
WebUI.verifyEqual(CustomKeywords.'FormHelper.getCheckBoxSelectionByLabel'(LabelValueSingleCheckbox), SingleCheckBoxSelection)

'Verify multiple checkbox selection'
WebUI.verifyEqual(CustomKeywords.'FormHelper.getCheckBoxSelectionByLabel'(LabelValueGroupCheckbox), GroupCheckBoxSelection)

'Verify dropdown selection'
WebUI.verifyEqual(CustomKeywords.'FormHelper.getDropDownSelectionByLabel'(LabelValueDropDown), DropDownSelection)

'Delete the form entry'
WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Entries/Actions/ActionsButton'))

WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Entries/Actions/DeleteEntry'))

WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Entries/Confirmation/Yes'))

WebUI.delay(3)

WebUI.waitForElementPresent(findTestObject('HC-Web/Data Capture/Connection Forms/Entries/Entries Header'), 3)

'Go to the Connection Form Admin screen'
CustomKeywords.'NavigationHelper.goToHCUrl'(ConnectionFormManagementPath)

WebUI.waitForElementPresent(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Overview/Form Details Header'), 2)

'Unpublish the form'
WebUI.waitForElementPresent(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Overview/span_Unpublish'), 2)

'Check that the form is published'
WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Overview/span_Unpublish'), 'Unpublish')

WebUI.click(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Overview/span_Unpublish'))

WebUI.waitForElementPresent(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Overview/div_Yes'), 2)

WebUI.click(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Overview/div_Yes'))

WebUI.waitForElementPresent(findTestObject('HC-Web/Data Capture/Connection Forms/Overview/PublishLinkButton'), 2)

'Verify that the form is not published'
WebUI.verifyElementText(findTestObject('HC-Web/Data Capture/Connection Forms/Overview/PublishLinkButton'), 'Publish')

WebUI.closeBrowser()

