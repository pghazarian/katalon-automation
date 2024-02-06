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

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/p_Events Central'))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/span_New Event'))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/div_Create New Event'))

CustomKeywords.'customUtility.TestObjectHelper.setDropDownValue'('event_details_event_type--host_campus', campus)

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/label_Campus Event'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Event/Event Creation/inputevent_details_basic_info--event_name'), 
    'Katalon Test Event')

CustomKeywords.'customUtility.TestObjectHelper.setDropDownValueByXPath'('//div[@id=\'event_details_basic_info--event_category\']/descendant::div[@class=\'Select-control\']', 
    category)

WebUI.setText(findTestObject('Object Repository/HC-Web/Event/Event Creation/Event Description Textbox'), 'Test Event for Katalon Automation')

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/div_Add Venue(s) from this Campus'))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/FirstVenueDropdownOption_div'))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/span_Create'))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/span_Save'))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/span_Occurrence Schedule'))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/span_Add to Roster'))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/span_For This Occurrence'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Event/Event Creation/inputperson_search_form--search_input'), attendee)

WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Event/Event Creation/inputperson_search_form--search_input'), Keys.chord(
        Keys.ENTER))

WebUI.waitForElementClickable(findTestObject('HC-Web/Event/Event Creation/First Person Record Result'), 0)

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/First Person Record Result'))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/button_Select'))

WebUI.click(findTestObject('HC-Web/Event/Event Creation/Select Attendee Confirmation'))

WebUI.verifyElementText(findTestObject('HC-Web/Event/Event Creation/AttendeeNames_div'), attendee)

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/First Attendee Checkbox'))

WebUI.click(findTestObject('HC-Web/Event/Event Creation/OccurrenceScheduleActionsDropdown_div'))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/span_Mark Attended'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Event/Event Creation/span_Attended'), 'Attended')

WebUI.click(findTestObject('HC-Web/Event/Event Creation/First Attendee Checkbox'))

WebUI.click(findTestObject('HC-Web/Event/Event Creation/OccurrenceScheduleActionsDropdown_div'))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/span_Remove From This Occurrence'))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/div_Yes'))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/span_Overview'))

WebUI.click(findTestObject('HC-Web/Event/Event Creation/OverviewActionsDropdown_div'))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/span_Cancel'))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/div_Yes'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Event/Event Creation/div_Successfully Canceled'), 'Successfully Canceled')

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/Close Email Drawer Chevron Button'))

WebUI.closeBrowser()

