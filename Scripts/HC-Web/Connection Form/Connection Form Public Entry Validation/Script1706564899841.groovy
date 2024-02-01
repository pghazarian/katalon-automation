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

WebUI.callTestCase(findTestCase('HC-Web/Shared/Validate Safe Environment'), [(null) : null], FailureHandling.STOP_ON_FAILURE)

def date = new Date()

def sdf = new SimpleDateFormat('yyyy-MM-dd HH:mm:ss')

def CurrentDateTime = sdf.format(date)

CurrentDateTime = '2024-01-31 13:15:10'

def FormPath = GlobalVariable.HC_HostUrl + PublicConnectionFormPath

def AdminFormPath = GlobalVariable.HC_HostUrl + ConnectionFormManagementPath

def SingleTextValue = "Single Text - $CurrentDateTime"

def ParagraphTextValue = "Paragraph Text - $CurrentDateTime"

def FirstName = 'Cris'

def LastName = 'Francisco'

def Email = 'crisf@saddleback.com'

def DateSelected = CustomKeywords.'customUtility.StringHelper.getUSFormatDateForControl'(new Date().plus(2))

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password], FailureHandling.STOP_ON_FAILURE)

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
InputTextFieldLabel = "Can you enter a sentence?"
CustomKeywords.'customUtility.TestObjectHelper.verifyTextFieldValueEqual'(CustomKeywords.'customUtility.FormHelper.getTextInputByLabel'('Can you enter a sentence?'),
	SingleTextValue)

'Verify paragraph text'
TextAreaFieldLabel = "Can you enter a paragraph?"
CustomKeywords.'customUtility.TestObjectHelper.verifyTextAreaValueEqual'(CustomKeywords.'customUtility.FormHelper.getTextAreaByLabel'(TextAreaFieldLabel),
	ParagraphTextValue)

'Verify date text'
DateFieldLabel = "Please choose a Date"
CustomKeywords.'customUtility.TestObjectHelper.verifyTextFieldValueEqual'(CustomKeywords.'customUtility.FormHelper.getTextInputByLabel'(DateFieldLabel),
	DateSelected)
//
'Verify radio selection'
RadioFieldLabel = "Multiple Choice"
WebUI.verifyEqual(CustomKeywords.'customUtility.FormHelper.getRadioInputSelectionByLabel'(RadioFieldLabel), 'Option 3')

'Verify Single checkbox selection'
SingleCheckboxFieldLabel = "Check Single - Label"
WebUI.verifyEqual(CustomKeywords.'customUtility.FormHelper.getCheckBoxSelectionByLabel'(SingleCheckboxFieldLabel), 'Check Single')

'Verify multiple checkbox selection'
MultipleCheckboxFieldLabel = 'Check Group'

WebUI.verifyEqual(CustomKeywords.'customUtility.FormHelper.getCheckBoxSelectionByLabel'(MultipleCheckboxFieldLabel), 
    'Option 1,Option 3')

