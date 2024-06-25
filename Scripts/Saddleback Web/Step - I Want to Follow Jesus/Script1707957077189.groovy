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

def date = new Date()

def CurrentDateTime = CustomKeywords.'StringHelper.getIsoFormatDate'(date)

def Note = "This is my story: $CurrentDateTime"

def FirstName = "First $CurrentDateTime"

def LastName = "Last $CurrentDateTime"

def Email = "cfrancisco@gmail.com"

def Phone = "+1 949 525 8002"

def Campus = "Lake Forest"

'Load the Welcome home page'
WebUI.openBrowser(GlobalVariable.Saddleback_Welcome_URL)

WebUI.click(findTestObject('Saddleback Web/Home/Actions/span_I want to follow Jesus'))

WebUI.click(findTestObject('Object Repository/Saddleback Web/Follow Jesus Page/a_Ive Decided to Follow Jesus'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Saddleback Web/Follow Jesus Page/h2_Welcome to the Family'), 
    0)

WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Follow Jesus Page/h2_Welcome to the Family'), 
    'WELCOME TO THE FAMILY!')

WebUI.setText(findTestObject('Object Repository/Saddleback Web/Follow Jesus Page/Form/FirstName Text Field'), FirstName)

WebUI.setText(findTestObject('Object Repository/Saddleback Web/Follow Jesus Page/Form/Last Name Text Field'), LastName)

'Select the drop down value'
CustomKeywords.'FormHelper.setDropDownValue'('Campus', Campus)

WebUI.setText(findTestObject('Object Repository/Saddleback Web/Follow Jesus Page/Form/Email Text Field'), Email)

WebUI.setText(findTestObject('Object Repository/Saddleback Web/Follow Jesus Page/Form/Phone Text Field'), Phone)

WebUI.click(findTestObject('Object Repository/Saddleback Web/Follow Jesus Page/Form/label_Mobile'))

WebUI.setText(findTestObject('Object Repository/Saddleback Web/Follow Jesus Page/Form/Story Text Area'), 
    Note)

'Select the drop down value'
CustomKeywords.'FormHelper.setDropDownValue'('Campus you normally attend:', Campus)

WebUI.click(findTestObject('Object Repository/Saddleback Web/Follow Jesus Page/Form/span_Submit'))

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
		, ('Password') : GlobalVariable.Admin_Password, ('ForceLogin') : true], FailureHandling.STOP_ON_FAILURE)

'Go to the Connection Form Admin screen'
CustomKeywords.'NavigationHelper.goToHCUrl'(GlobalVariable.ConnectionForm_FollowJesus)

'Click on the Entries menu'
WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Entries/Entries'))

//TODO: update this to search for the entry by name
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

'Verify dropdown selection'
WebUI.verifyEqual(CustomKeywords.'FormHelper.getDropDownSelectionByLabel'('Campus'), Campus)

'Verify dropdown selection'
WebUI.verifyEqual(CustomKeywords.'FormHelper.getDropDownSelectionByLabel'('Campus you normally attend:'), Campus)

'Verify paragraph text'
CustomKeywords.'TestObjectHelper.verifyTextAreaValueEqual'(CustomKeywords.'FormHelper.getTextAreaByLabel'('Tell us a little about your story.'), Note)

'Verify the phone'
CustomKeywords.'TestObjectHelper.verifyTextFieldValueEqual'(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Entries/Add Entry Drawer/PhoneTextField'),
	Phone)

'Delete the form entry'
WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Entries/Actions/ActionsButton'))

WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Entries/Actions/DeleteEntry'))

WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Entries/Confirmation/Yes'))

WebUI.delay(3)

WebUI.waitForElementPresent(findTestObject('HC-Web/Data Capture/Connection Forms/Entries/Entries Header'), 3)



