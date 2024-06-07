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
        'Recurring SO at Saddleback location created by a QA automation test. Can be deleted.')

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

    'Select recurring SO radio option'
    WebUI.click(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Recurring SO Yes Radio Pill Option'))

    'Save recurrence pattern'
    WebUI.click(findTestObject('HC-Web/Serving Opps/Create Serving Opps Drawer/Save Recurrence Pattern Button'))

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

    'Enter volunteer capacity'
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

        'Add a new question'
        WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/New Question Button'))

        'Select checkbox question type'
        WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Checkbox Type Option'))

        'Name the custom question'
        WebUI.setText(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Question Title Text Field'), 
            'Test Question')

        'Add a label to the checkbox'
        WebUI.setText(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Question Label Text Field'), 
            'Check This Box')

        'Make question required'
        WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Required Checkbox'))

        'Finish editing question'
        WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Done Button'))
    }
    catch (Exception ex) {
        'If custom question creation fails, back out of question editor and reset SO fields'
        WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Custom Questions/Cancel Button'))

        WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Create Serving Opps Drawer/Serving Opp Creation Cross Button'))

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

'Add volunteer to SO'
WebUI.waitForElementNotHasAttribute(findTestObject('Object Repository/HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Button'), 
    'disabled', 0)

'Add volunteer to SO'
WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Button'))

'Add to this occurrence'
WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Serving Schedule Page/To This Occurrence Option'))

'Switch to person search'
WebUI.waitForElementVisible(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Person Search Tab'), 
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

'Confirm selection'
WebUI.waitForElementVisible(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Select Person Button'), 
    2)

'Confirm selection'
WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Select Person Button'))

WebUI.click(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Select Person Confirmation Yes Button'))

if(WebUI.waitForElementVisible(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Missing Requirements Modal Yes Button'), 3)) {
	WebUI.click(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Missing Requirements Modal Yes Button'))
}

'Click required custom question checkbox'
WebUI.waitForElementVisible(findTestObject('Object Repository/HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Custom Question Checkbox'), 
    2)

'Click required custom question checkbox'
WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Custom Question Checkbox'))

'Save custom question responses'
WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Save Custom Question Responses Button'))

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

