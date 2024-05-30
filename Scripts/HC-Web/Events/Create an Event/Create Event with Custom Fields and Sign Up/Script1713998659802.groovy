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

def date = new Date().format('MMddyyyy').toString()

def startDate = new Date().plus(1).format('MMddyyyy').toString()

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/events-central/overview'], FailureHandling.STOP_ON_FAILURE)

'Click button to create new event'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/New Event Dropdown Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/Create New Event Button'))

'Select campus'
CustomKeywords.'TestObjectHelper.setDropDownValue'('event_details_event_type--host_campus', campus)

'Switch to campus event'
CustomKeywords.'FormHelper.setMultipleChoiceControlValueByXPath'('//div[@class=\'event_details_event_type\']/descendant::div[@class=\'radio-item\']', 
    'Campus Event')

'Name event'
WebUI.setText(findTestObject('Object Repository/HC-Web/Event/Event Creation/Event Name Text Field'), 'QA Automation Test Event with Custom Fields ' + 
    UUID.randomUUID())

'Select category'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@id=\'event_details_basic_info--event_category\']/descendant::div[@class=\'Select-control\']', 
    category)

'Give event a description'
WebUI.setText(findTestObject('Object Repository/HC-Web/Event/Event Creation/Event Description Textbox'), 'Event created by QA Automation test')

'Open venue dropdown'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/Venue Dropdown'))

'Select first listed venue'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Event Creation/First Venue Dropdown Option'))

'Save event'
WebUI.click(findTestObject('HC-Web/Event/Event Creation/Location Label'))

'Set start date to the next day'
WebUI.setText(findTestObject('HC-Web/Event/Event Creation/Start Date Text Field'), Keys.chord(Keys.CONTROL + 'a') + startDate)

WebUI.click(findTestObject('HC-Web/Event/Event Creation/Create Button'))

'Navigate to registration page'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration Subnav'))

'Click button to require registration'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Registration Required Yes Radio Option Button'))

'Open custom questions drawer'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Add Custom Question Button'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/New Question Button'), 
    2)

'Click button to create a new question'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/New Question Button'))

'Select single line text question type'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Question Type Single Line Text'))

'Give question a title'
WebUI.setText(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Question Title Text Field'), 'Test Question 1')

'Enter placeholder text'
WebUI.setText(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Placeholder Text Field'), 'Placeholder text')

'Select required checkbox'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Required Checkbox'))

'Select sentitive checkbox'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Sensitive Checkbox'))

'Click done button'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Done Button'))

'Click button to create a new question'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/New Question Button'))

'Select paragraph text question type'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Question Type Paragraph Text'))

'Give question a title'
WebUI.setText(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Question Title Text Field'), 'Test Question 2')

'Enter placeholder text'
WebUI.setText(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Placeholder Text Field'), 'Placeholder text')

'Click done button'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Done Button'))

'Click button to create a new question'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/New Question Button'))

'Select checkbox question type'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Question Type Checkbox'))

'Give question a title'
WebUI.setText(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Question Title Text Field'), 'Test Question 3')

'Enter placeholder text'
WebUI.setText(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Placeholder Text Field'), 'Placeholder text')

'Click done button'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Done Button'))

'Click button to create a new question'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/New Question Button'))

'Select checkbox question type'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Question Type Checkbox'))

'Select grouped checkbox'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Grouped Checkbox Radio Option'))

'Give question a title'
WebUI.setText(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Question Title Text Field'), 'Test Question 4')

'Enter placeholder text for checkbox options'
WebUI.setText(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Option 1 Text Field'), 'Placeholder text 1')

WebUI.setText(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Option 2 Text Field'), 'Placeholder text 2')

'Click done button'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Done Button'))

'Click button to create a new question'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/New Question Button'))

'Select checkbox question type'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Question Type Multiple Choice'))

'Give question a title'
WebUI.setText(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Question Title Text Field'), 'Test Question 5')

'Enter placeholder text for checkbox options'
WebUI.setText(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Option 1 Text Field'), 'Placeholder text 1')

WebUI.setText(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Option 2 Text Field'), 'Placeholder text 2')

'Click done button'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Done Button'))

'Click button to create a new question'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/New Question Button'))

'Select checkbox question type'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Question Type Dropdown'))

'Give question a title'
WebUI.setText(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Question Title Text Field'), 'Test Question 6')

'Enter placeholder text'
WebUI.setText(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Placeholder Text Field'), 'Placeholder text')

'Enter placeholder text for checkbox options'
WebUI.setText(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Option 1 Text Field'), 'Placeholder text 1')

WebUI.setText(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Option 2 Text Field'), 'Placeholder text 2')

'Click done button'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Done Button'))

'Click button to create a new question'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/New Question Button'))

'Select checkbox question type'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Question Type Date'))

'Give question a title'
WebUI.setText(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Question Title Text Field'), 'Test Question 7')

'Click done button'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Done Button'))

'Verify first question is required'
WebUI.verifyElementPresent(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Required Question Asterisk'), 
    0)

'Save custom questions'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Save Button'))

'Verify all 7 questions have been added'
WebUI.verifyElementText(findTestObject('HC-Web/Event/Details/Registration/Custom Question Drawer/Number of Questions Added Text Area'), 
    '7')

'Save edits'
WebUI.click(findTestObject('HC-Web/Event/Details/Save Edits Button'))

'Navigate to registration roster'
WebUI.click(findTestObject('HC-Web/Event/Details/Subnav_RegistrationRoster'))

'Select button to leave edit page'
WebUI.click(findTestObject('HC-Web/Event/Details/Leave This Page Button'))

WebUI.click(findTestObject('HC-Web/Event/Registration Roster/Add to Roster Button'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Event/PersonDrawer/Person Search Drawer Search Bar Input'), 2)

WebUI.setText(findTestObject('HC-Web/Event/PersonDrawer/Person Search Drawer Search Bar Input'), attendee + Keys.ENTER)

WebUI.click(findTestObject('HC-Web/Event/PersonDrawer/Person Search Drawer Search Results'))

WebUI.click(findTestObject('HC-Web/Event/PersonDrawer/Select Person Search Result Button'))

WebUI.click(findTestObject('HC-Web/Event/PersonDrawer/Select Person Search Result Confirmation Yes Button'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Event/Registration Roster/Custom Questions Drawer/Requred Question Asterisk'), 
    2)

WebUI.verifyElementText(findTestObject('HC-Web/Event/Registration Roster/Custom Questions Drawer/Requred Question Asterisk'), 
    '*')

WebUI.setText(findTestObject('HC-Web/Event/Registration Roster/Custom Questions Drawer/Single Line Answer Text Area'), 'Answer 1')

WebUI.setText(findTestObject('HC-Web/Event/Registration Roster/Custom Questions Drawer/Paragraph Answer Text Area'), 'Answer 2')

WebUI.click(findTestObject('HC-Web/Event/Registration Roster/Custom Questions Drawer/First Single Checkbox Response'))

WebUI.click(findTestObject('HC-Web/Event/Registration Roster/Custom Questions Drawer/First Grouped Checkbox Response'))

WebUI.click(findTestObject('HC-Web/Event/Registration Roster/Custom Questions Drawer/First Multiple Choice Response'))

CustomKeywords.'TestObjectHelper.setDropDownValueWithClick'('edit_response--question_dropdown-', 'Placeholder text 1')

WebUI.setText(findTestObject('HC-Web/Event/Registration Roster/Custom Questions Drawer/Date Response Text Field'), date + 
    Keys.ENTER)

WebUI.click(findTestObject('HC-Web/Event/Registration Roster/Custom Questions Drawer/Save Responses Button'))

WebUI.waitForElementPresent(findTestObject('Object Repository/HC-Web/Event/Registration Roster/Person Rows'), 5)

'Verify person record appears in registration roster'
WebUI.verifyTextPresent(attendee, false)

'Click checkbox for recently added person record'
WebUI.click(CustomKeywords.'TestObjectHelper.getTestObjectWithXpath'("//div[normalize-space(.)='$attendee']/ancestor::tr/descendant::div[contains(@class,'icon-check')]"))

'Open actions dropdown'
WebUI.click(findTestObject('HC-Web/Event/Registration Roster/Actions Dropdown'))

'Select option to remove person record from registration roster'
WebUI.click(findTestObject('HC-Web/Event/Registration Roster/Remove from Event Dropdown Option'))

WebUI.waitForElementNotPresent(findTestObject('Object Repository/HC-Web/Event/Registration Roster/Person Rows'), 5)

'Verify person record was removed from registration roster'
WebUI.verifyTextNotPresent(attendee, false)

WebUI.click(findTestObject('HC-Web/Event/Details/Subnav_Overview'))

WebUI.click(findTestObject('HC-Web/Event/Overview/Actions Dropdown'))

WebUI.click(findTestObject('HC-Web/Event/Overview/Cancel Event Button'))

WebUI.click(findTestObject('HC-Web/Event/Overview/Cancel Event Confirmation Yes Button'))

WebUI.verifyElementPresent(findTestObject('HC-Web/Event/Overview/Successfully Cancelled Banner'), 0)

WebUI.waitForElementVisible(findTestObject('HC-Web/Event/Details/Close Email Drawer Button'), 2)

WebUI.click(findTestObject('HC-Web/Event/Details/Close Email Drawer Button'))

WebUI.closeBrowser()

