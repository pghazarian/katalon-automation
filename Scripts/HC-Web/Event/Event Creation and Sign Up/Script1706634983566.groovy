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
/*
 *  This code performs a series of actions to create and manage an event in a web application.
 *
 *  1. The code calls a test case named 'Login' with specific parameters.
 *  2. The code clicks on a specific test object to navigate to the event creation page.
 *  3. The code clicks on another test object to create a new event.
 *  4. The code sets the value of a dropdown field using a custom keyword.
 *  5. The code clicks on a test object to select a specific option.
 *  6. The code sets the value of a text field.
 *  7. The code clicks on a test object to add a venue to the event.
 *  8. The code clicks on a test object to select a specific venue.
 *  9. The code clicks on a test object to create the event.
 *  10. The code clicks on a test object to save the event.
 *  11. The code clicks on a test object to navigate to the occurrence schedule page.
 *  12. The code clicks on a test object to add attendees to the event.
 *  13. The code clicks on a test object to select the option for the current occurrence.
 *  14. The code sets the value of a text field to search for an attendee.
 *  15. The code sends a key press event to the search field.
 *  16. The code waits for a specific test object to become clickable.
 *  17. The code clicks on a test object to select the first person record result.
 *  18. The code clicks on a test object to select the attendee.
 *  19. The code clicks on a test object to confirm the selection of the attendee.
 *  20. The code verifies the text of a test object to ensure the correct attendee is selected.
 *  21. The code clicks on a test object to select the first attendee checkbox.
 *  22. The code clicks on a test object to open the occurrence schedule actions dropdown.
 *  23. The code clicks on a test object to mark the attendee as attended.
 *  24. The code verifies the text of a test object to ensure the attendee is marked as attended.
 *  25. The code clicks on a test object to select the first attendee checkbox.
 *  26. The code clicks on a test object to open the occurrence schedule actions dropdown.
 *  27. The code clicks on a test object to remove the attendee from the occurrence.
 *  28. The code clicks on a test object to confirm the removal of the attendee.
 *  29. The code clicks on a test object to navigate to the overview page.
 *  30. The code clicks on a test object to open the overview actions dropdown.
 *  31. The code clicks on a test object to cancel the event.
 *  32. The code clicks on a test object to confirm the cancellation of the event.
 *  33. The code verifies the text of a test object to ensure the event is successfully canceled.
 *  34. The code clicks on a test object to close the email drawer.
 *  35. The code closes the browser.
 *
 */

