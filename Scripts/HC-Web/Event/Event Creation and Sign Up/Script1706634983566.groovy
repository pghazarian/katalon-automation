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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/events-central/overview'], FailureHandling.STOP_ON_FAILURE)

'Click button to create new event'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/New Event Dropdown Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/Create New Event Button'))

'Select campus'
CustomKeywords.'customUtility.TestObjectHelper.setDropDownValue'('event_details_event_type--host_campus', campus)

'Switch to campus event'
CustomKeywords.'customUtility.FormHelper.setMultipleChoiceControlValueByXPath'('//div[@class=\'event_details_event_type\']/descendant::div[@class=\'radio-item\']', 
    'Campus Event')

'Name event'
WebUI.setText(findTestObject('Object Repository/HC-Web/Event/Event Creation/Event Name Text Field'), 'QA Automation Test Event')

'Select category'
CustomKeywords.'customUtility.TestObjectHelper.setDropDownValueByXPath'('//div[@id=\'event_details_basic_info--event_category\']/descendant::div[@class=\'Select-control\']', 
    category)

'Give event a description'
WebUI.setText(findTestObject('Object Repository/HC-Web/Event/Event Creation/Event Description Textbox'), 'Event created by QA Automation test')

'Open venue dropdown'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/Venue Dropdown'))

'Select first listed venue'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/First Venue Dropdown Option'))

'Save event'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/Create Button'))

'Navigate to occurrence schedule'
WebUI.click(findTestObject('HC-Web/Event/Occurrence Schedule/Occurrence Schedule Tab'))

'Click button to add attendee'
WebUI.click(findTestObject('HC-Web/Event/Occurrence Schedule/Add to Roster Button'))

'Add attendee for this occurrence only'
WebUI.click(findTestObject('HC-Web/Event/Occurrence Schedule/For This Occurrence Option'))

'Search for an attendee'
WebUI.setText(findTestObject('HC-Web/Event/PersonDrawer/Person Search Drawer Search Bar Input'), attendee)

WebUI.sendKeys(findTestObject('HC-Web/Event/PersonDrawer/Person Search Drawer Search Bar Input'), Keys.chord(Keys.ENTER))

WebUI.waitForElementClickable(findTestObject('HC-Web/Event/Event Creation/First Person Record Result'), 0)

'Open first search result'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/First Person Record Result'))

'Select attendee'
WebUI.click(findTestObject('HC-Web/Event/PersonDrawer/Select Person Search Result Button'))

WebUI.click(findTestObject('HC-Web/Event/PersonDrawer/Select Person Search Result Confirmation Yes Button'))

'Verify attendee appears in list'
WebUI.verifyElementText(findTestObject('HC-Web/Event/Check In/Attendee Names'), attendee)

'Select previously added attendee'
WebUI.click(findTestObject('HC-Web/Event/Check In/Attendee Checkboxes'))

'Open actions for selected attendee'
WebUI.click(findTestObject('HC-Web/Event/Occurrence Schedule/Actions Dropdown'))

'Mark attendee as attended'
WebUI.click(findTestObject('HC-Web/Event/Occurrence Schedule/Mark Attended Option'))

'Verify attendee is listed as attended'
WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Event/Occurrence Schedule/Attendance Field'), 'Attended')

'Select attendee again'
WebUI.click(findTestObject('HC-Web/Event/Check In/Attendee Checkboxes'))

'Open actions for selected attendee'
WebUI.click(findTestObject('HC-Web/Event/Occurrence Schedule/Actions Dropdown'))

'Remove attendee from this occurrence'
WebUI.click(findTestObject('HC-Web/Event/Occurrence Schedule/Remove from this Occurrence Option'))

WebUI.click(findTestObject('HC-Web/Event/Occurrence Schedule/Remove from this Occurrence Confirmation Yes Button'))

'Navigate to event overview'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Overview/Overview Tab'))

'Open event actions'
WebUI.click(findTestObject('HC-Web/Event/Overview/Actions Dropdown'))

'Cancel event'
WebUI.click(findTestObject('HC-Web/Event/Overview/Cancel Event Button'))

WebUI.click(findTestObject('HC-Web/Event/Overview/Cancel Event Confirmation Yes Button'))

'Verify banner appears for event cancellation'
WebUI.verifyElementVisible(findTestObject('Object Repository/HC-Web/Event/Overview/Successfully Cancelled Banner'), FailureHandling.STOP_ON_FAILURE)

'Close email to attendees drawer'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/Close Email Drawer Chevron Button'))

WebUI.closeBrowser()

