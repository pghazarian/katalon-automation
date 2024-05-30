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

def date = new Date().plus(1).format('MMddyyyy').toString()

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : "/events-central/event/$EventId/edit"], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('HC-Web/Event/Details/Event Name'), ' - Edited')

CustomKeywords.'TestObjectHelper.setDropDownValue'('event_details_basic_info--event_category', EventCategory_Edited)

WebUI.setText(findTestObject('HC-Web/Event/Details/Date Text Field'), Keys.chord(Keys.CONTROL + 'a') + date)

CustomKeywords.'TestObjectHelper.setDropDownValue'('event_details_event_date_time--start_time', '07:00 PM')

CustomKeywords.'TestObjectHelper.setDropDownValue'('event_location_on_campus-where_campus', 'Lake Forest')

def hasVenue = !(WebUI.findWebElements(findTestObject('Object Repository/HC-Web/Event/Details/Selected Venues'), 5, FailureHandling.CONTINUE_ON_FAILURE).isEmpty())

if (hasVenue) {
    WebUI.click(findTestObject('HC-Web/Event/Details/Change Campus Prompt Yes Button'))
}

WebUI.click(findTestObject('HC-Web/Event/Details/Venue Dropdown'))

WebUI.click(findTestObject('HC-Web/Event/Details/Venue Dropdown First Venue'))

WebUI.click(findTestObject('HC-Web/Event/Details/Details Subnav'))

WebUI.setText(findTestObject('HC-Web/Event/Details/Event Description Text Area'), ' - Edited')

WebUI.click(findTestObject('HC-Web/Event/Details/Save Edits Button'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Event/Details/Close Email Drawer Button'), 2)

WebUI.click(findTestObject('HC-Web/Event/Details/Close Email Drawer Button'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Event/Details/Event Description Text Area'), 2)

WebUI.verifyElementText(findTestObject('HC-Web/Event/Details/Event Description Text Area'), 'Event created by qa automation for edit event test - Edited')

WebUI.click(findTestObject('HC-Web/Event/Details/Basic Info Subnav'))

WebUI.verifyElementAttributeValue(findTestObject('HC-Web/Event/Details/Event Name'), 'value', 'QA Automation Event to be Edited - Edited', 
    0)

WebUI.verifyElementText(findTestObject('HC-Web/Event/Details/Category Dropdown Text Area'), EventCategory_Edited)

WebUI.verifyElementText(findTestObject('HC-Web/Event/Details/Start Time Dropdown Text Area'), '07:00 PM')

WebUI.verifyElementText(findTestObject('HC-Web/Event/Details/Campus Dropdown Text Area'), 'Lake Forest')

WebUI.setText(findTestObject('HC-Web/Event/Details/Event Name'), (Keys.chord(Keys.CONTROL + 'a') + Keys.BACK_SPACE) + 'QA Automation Event to be Edited')

CustomKeywords.'TestObjectHelper.setDropDownValue'('event_details_basic_info--event_category', EventCategory)

CustomKeywords.'TestObjectHelper.setDropDownValue'('event_details_event_date_time--start_time', '05:00 PM')

hasVenue = !(WebUI.findWebElements(findTestObject('Object Repository/HC-Web/Event/Details/Selected Venues'), 5, FailureHandling.CONTINUE_ON_FAILURE).isEmpty())

CustomKeywords.'TestObjectHelper.setDropDownValue'('event_location_on_campus-where_campus', 'Anaheim')

if (hasVenue) {
    WebUI.click(findTestObject('HC-Web/Event/Details/Change Campus Prompt Yes Button'))
}

WebUI.click(findTestObject('HC-Web/Event/Details/Venue Dropdown'))

WebUI.click(findTestObject('HC-Web/Event/Details/Venue Dropdown First Venue'))

WebUI.click(findTestObject('HC-Web/Event/Details/Details Subnav'))

WebUI.setText(findTestObject('HC-Web/Event/Details/Event Description Text Area'), (Keys.chord(Keys.CONTROL + 'a') + Keys.BACK_SPACE) + 
    'Event created by qa automation for edit event test')

WebUI.click(findTestObject('HC-Web/Event/Details/Save Edits Button'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Event/Details/Close Email Drawer Button'), 2)

WebUI.click(findTestObject('HC-Web/Event/Details/Close Email Drawer Button'))

WebUI.closeBrowser()

