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

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : "/my-ministry/serving-opportunities/$MinistryId/$CampusId"], 
    FailureHandling.STOP_ON_FAILURE)

'Click button to create new SO'
WebUI.click(findTestObject('Object Repository/HC-Web/Ministry/Serving Opps Page/New Opportunity Button'))

try {
    'View ministry dashboard'
    WebUI.waitForElementVisible(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/What and Why Option'), 2)

    'Open What and Why Section'
    WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/What and Why Option'))

    'Name SO'
    WebUI.waitForElementVisible(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Name Text Field'), 
        2)

    'Name SO'
    WebUI.setText(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Name Text Field'), ServingOppName)

    'Give SO a short description'
    WebUI.setText(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Short Description Text Field'), 
        'QA automation SO created by Katalon test')

    'Give SO a long description'
    WebUI.setText(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Long Description Text Field'), 
        'One-time SO at Saddleback location created by a QA automation test. Can be deleted.')

    'Click button to add a contact'
    WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Add Contact Button'))

    'Select first contact'
    WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/First Contact Opton'))

    try {
        'Confirm contact selection'
        WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Select Contact Button'))
    }
    catch (Exception ex) {
        'If contact selection fails, back out of drawers and reset SO fields'
        WebUI.click(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Serving Opp Creation People Search Drawer Cross Button'))

        WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Serving Opp Creation Cross Button'))

        WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Start Over Button'))

        WebUI.click(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Start Over Confirmation Yes Button'))

        WebUI.closeBrowser()

        throw new com.kms.katalon.core.exception.StepFailedException('Failed to add opportunity contact')
    } 
    
    'Move to next section'
    WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/What and Why Next Section Chevron Button'))

    WebUI.delay(2)

    def expanded = WebUI.getAttribute(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Expand Venue List Button'), 
        'aria-expanded')

    'Verify venue list is expanded'
    if (expanded == 'false') {
        'Expand venue list if not already expanded'
        WebUI.click(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Expand Venue List Button'))
    }
    
    'Select first venue'
    WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/First Venue Checkbox'))

    'Move to next section'
    WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/When and Where Next Section Chevron Button'))

    WebUI.waitForElementPresent(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Volunteer Capacity Text Field'), 
        5)

    WebUI.waitForElementVisible(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Volunteer Capacity Text Field'), 
        5)

    'Enter volunteer capacity'
    WebUI.setText(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Volunteer Capacity Text Field'), 
        '10')

    'Open custom question editor drawer'
    WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Edit Custom Questions Button'))

    try {
        'Add a new question'
        WebUI.waitForElementVisible(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/New Question Button'), 
            2)

        'Finish editing question'
        WebUI.click(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/New Question Button'))

        'Select checkbox question type'
        WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Question Type Checkbox'))

        'Select grouped checkbox option'
        WebUI.click(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Grouped Checkbox Radio Option'))

        'Name the custom question'
        WebUI.setText(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Question Title Text Field'), 
            'Test Question 1')

        'Add a label to the first checkbox'
        WebUI.setText(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Option 1 Text Field'), 
            'Check This Box')

        'Add a label to the second checkbox'
        WebUI.setText(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Option 2 Text Field'), 
            'Or This Box')

        'Finish editing question'
        WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Done Button'))

        'Add new question'
        WebUI.click(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/New Question Button'))

        'Select checkbox question type'
        WebUI.click(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Question Type Checkbox'))

        'Name the custom question'
        WebUI.setText(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Question Title Text Field'), 
            'Test Question 2')

        'Add a label to the checkbox'
        WebUI.setText(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Placeholder Text Field'), 
            'Check This Box')

        'Make question required'
        WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Required Checkbox'))

        'Make question sensitive'
        WebUI.click(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Sensitive Checkbox'))

        'Finish editing question'
        WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Done Button'))

        'Add new question'
        WebUI.click(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/New Question Button'))

        'Select single line question type'
        WebUI.click(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Question Type Single Line Text'))

        'Name the custom question'
        WebUI.setText(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Question Title Text Field'), 
            'Test Question 3')

        'Add a placeholder'
        WebUI.setText(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Placeholder Text Field'), 
            'Answer this question')

        'Finish editing question'
        WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Done Button'))

        'Add new question'
        WebUI.click(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/New Question Button'))

        'Select paragraph question type'
        WebUI.click(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Question Type Paragraph Text'))

        'Name the custom question'
        WebUI.setText(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Question Title Text Field'), 
            'Test Question 4')

        'Add a placeholder'
        WebUI.setText(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Placeholder Text Field'), 
            'Answer this question')

        'Finish editing question'
        WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Done Button'))

        'Add new question'
        WebUI.click(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/New Question Button'))

        'Select multiple choice question type'
        WebUI.click(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Question Type Multiple Choice'))

        'Name the custom question'
        WebUI.setText(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Question Title Text Field'), 
            'Test Question 5')

        'Add a label to the first option'
        WebUI.setText(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Option 1 Text Field'), 
            'Check This Box')

        'Add a label to the second option'
        WebUI.setText(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Option 2 Text Field'), 
            'Or This Box')

        'Finish editing question'
        WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Done Button'))

        'Add new question'
        WebUI.click(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/New Question Button'))

        'Select dropdown question type'
        WebUI.click(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Question Type Dropdown'))

        'Name the custom question'
        WebUI.setText(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Question Title Text Field'), 
            'Test Question 6')

        'Add a placeholder'
        WebUI.setText(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Placeholder Text Field'), 
            'Placeholder Text')

        'Add a label to the first option'
        WebUI.setText(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Option 1 Text Field'), 
            'Option 1')

        'Add a label to the second option'
        WebUI.setText(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Option 2 Text Field'), 
            'Option 2')

        'Finish editing question'
        WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Done Button'))

        'Add new question'
        WebUI.click(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/New Question Button'))

        'Select date question type'
        WebUI.click(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Question Type Date'))

        'Name the custom question'
        WebUI.setText(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Question Title Text Field'), 
            'Test Question 7')

        'Finish editing question'
        WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Done Button'))
    }
    catch (Exception ex) {
        'If custom question creation fails, back out of question editor and reset SO fields'
        WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Cancel Button'))

        WebUI.waitForElementVisible(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Serving Opp Creation Cross Button'), 
            0)

        WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Serving Opp Creation Cross Button'))

        WebUI.waitForElementVisible(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Start Over Button'), 
            0)

        WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Start Over Button'))

        WebUI.click(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Start Over Confirmation Yes Button'))

        WebUI.closeBrowser()

        throw new com.kms.katalon.core.exception.StepFailedException('Failed to add custom questions')
    } 
    
    'Save custom questions'
    WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Save Button'))
}
catch (Exception e) {
    'If SO creation fails, reset SO fields'
    WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Serving Opp Creation Cross Button'))

    WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Start Over Button'))

    WebUI.click(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Start Over Confirmation Yes Button'))

    WebUI.closeBrowser()

    throw new com.kms.katalon.core.exception.StepFailedException('Failed to create Serving Opportunity')
} 

'Finish final section of SO creation'
WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Done Button'))

'Save SO'
WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Save Button'))

'If banner appears asking if SO should be published, click no'
if (WebUI.waitForElementVisible(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Publish Opportunity No Button'), 
    3)) {
    WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Publish Opportunity No Button'))
}

'Navigate to SO tab'
WebUI.click(findTestObject('Object Repository/HC-Web/Ministry/Serving Opps Page/Serving Opps Tab'))

'View SO\'s in list view'
WebUI.click(findTestObject('Object Repository/HC-Web/Ministry/Serving Opps Page/List View Serving Ops'))

'Select upcoming SO\'s'
WebUI.click(findTestObject('Object Repository/HC-Web/Ministry/Serving Opps Page/Upcoming Radio Option Serving Opps'))

'Select first SO in list'
WebUI.click(findTestObject('HC-Web/Ministry/Serving Opps Page/Table Row Serving Opp', [('ServingOppName') : ServingOppName]))

WebUI.waitForElementPresent(findTestObject('HC-Web/Shared Component/Activity Indicator'), 3, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementNotPresent(findTestObject('HC-Web/Shared Component/Activity Indicator'), 3, FailureHandling.STOP_ON_FAILURE)

'Add volunteer to SO'
WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Button'))

'Add to this occurrence'
WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Serving Schedule Page/To This Occurrence Option'))

'Switch to person search'
WebUI.waitForElementVisible(findTestObject('Object Repository/HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Person Search Tab'), 
    2)

'Switch to person search'
WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Person Search Tab'))

'Search for a volunteer'
WebUI.setText(findTestObject('Object Repository/HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Person Search Bar'), 
    VolunteerName)

WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Person Search Bar'), 
    Keys.chord(Keys.ENTER))

WebUI.waitForElementClickable(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Person Search Results'), 
    3)

'Select searched volunteer'
WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Person Search Results'))

WebUI.waitForElementVisible(findTestObject('Object Repository/HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Select Person Button'), 
    2)

'Click button to select person'
WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Select Person Button'))

'Scroll confirmation button into view'
WebUI.scrollToElement(findTestObject('Object Repository/HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Personal Info Header'), 
    2)

'Confirm selection'
WebUI.waitForElementVisible(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Select Person Confirmation Yes Button'), 
    2)

'Confirm selection'
WebUI.click(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Select Person Confirmation Yes Button'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Custom Questions Drawer/Required Question Asterisk'), 
    2)

'Verify required question asterisk is present'
WebUI.verifyElementText(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Custom Questions Drawer/Required Question Asterisk'), 
    '*')

'Click grouped checkbox response'
WebUI.click(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Custom Questions Drawer/First Grouped Checkbox Response'))

'Click single checkbox response'
WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Custom Questions Drawer/Single Checkbox Response'))

'Answer single line question'
WebUI.setText(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Custom Questions Drawer/Single Line Answer Text Area'), 
    'Answer 3')

'Answer paragraph question'
WebUI.setText(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Custom Questions Drawer/Paragraph Answer Text Area'), 
    'Answer 4')

'Click multiple choice option'
WebUI.click(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Custom Questions Drawer/First Multiple Choice Response'))

'Answer dropdown question'
CustomKeywords.'TestObjectHelper.setDropDownValueWithClick'('edit_response--question_dropdown-', 'Option 1')

'Answer date question'
WebUI.setText(findTestObject('HC-Web/Event/Registration Roster/Custom Questions Drawer/Date Response Text Field'), date + 
    Keys.ENTER)

'Save custom question responses'
WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Custom Questions Drawer/Save Responses Button'))

'Select added volunteer'
WebUI.waitForElementVisible(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Added Volunteer Checkbox'), 5)

'Verify volunteer appears in list'
WebUI.verifyTextPresent(VolunteerName, false)

'Select added volunteer'
WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Serving Schedule Page/Added Volunteer Checkbox'))

'Open actions for selected volunteer'
WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Serving Schedule Page/Actions Dropdown'))

'Remove volunteer from occurrence'
WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Serving Schedule Page/Remove From This Occurrence Option'))

'Confirm volunteer removal'
WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Serving Schedule Page/Remove From This Occurence Confirmation Yes Button'))

'Navigate to SO settings'
WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Settings Page/Settings Tab'))

'Open SO actions dropdown'
WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Settings Page/Actions Dropdown Settings'))

'Select option to close SO'
WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Settings Page/Close Opportunity Dropdown Option'))

'Confirm selection'
WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Settings Page/Close Opportunity Confirmation Yes Button'))

WebUI.closeBrowser()

