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

CurrentDateTime = '2024-01-29 15:02:27'

def FormPath = GlobalVariable.HC_HostUrl + PublicConnectionFormPath

def AdminFormPath = GlobalVariable.HC_HostUrl + '/data-capture/connection-forms/72/entries'

def MessageText = "Romans 8:28 - $CurrentDateTime"

def SingleTextValue = "Single Text - $CurrentDateTime"

def ParagraphTextValue = "Paragraph Text - $CurrentDateTime"

def FirstName = 'Cris'

def LastName = 'Francisco'

def Email = 'crisf@saddleback.com'

def DateSelected = CustomKeywords.'customUtility.TestObjectHelper.getFormattedDateForControl'(new Date().plus(3))

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

'Verify custom single line text'
CustomSingleLineTextFieldLabel = "Extra Questions"
CustomKeywords.'customUtility.TestObjectHelper.verifyTextFieldValueEqual'(CustomKeywords.'customUtility.TestObjectHelper.getTextInputByLabel'(CustomSingleLineTextFieldLabel),
	MessageText)

'Verify single line text'
InputTextFieldLabel = "Single Text"
CustomKeywords.'customUtility.TestObjectHelper.verifyTextFieldValueEqual'(CustomKeywords.'customUtility.TestObjectHelper.getTextInputByLabel'(InputTextFieldLabel),
	SingleTextValue)

'Verify paragraph text'
TextAreaFieldLabel = "Paragraph Text"
CustomKeywords.'customUtility.TestObjectHelper.verifyTextAreaValueEqual'(CustomKeywords.'customUtility.TestObjectHelper.getTextAreaByLabel'(TextAreaFieldLabel),
	ParagraphTextValue)

'Verify date text'
DateFieldLabel = "Select a Date"
CustomKeywords.'customUtility.TestObjectHelper.verifyTextAreaValueEqual'(CustomKeywords.'customUtility.TestObjectHelper.getTextAreaByLabel'(TextAreaFieldLabel),
	DateSelected)

'Verify radio selection'
RadioFieldLabel = "Multiple Choice"
WebUI.verifyEqual(CustomKeywords.'customUtility.TestObjectHelper.getRadioInputSelectionByLabel'(RadioFieldLabel), '1')

'Verify checkbox selection'
RadioFieldLabel = "Group checkbox"
WebUI.verifyEqual(CustomKeywords.'customUtility.TestObjectHelper.getRadioInputSelectionByLabel'(RadioFieldLabel), '1')




