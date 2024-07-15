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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/communications-central/segment-search'], FailureHandling.STOP_ON_FAILURE)

'Type Search term'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segments/Search Text Field'), SearchTerm)

'Initiate Search'
WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Communications/Segments/Search Text Field'), Keys.chord(Keys.ENTER))

'Open the segment record from the search results'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Table Row', [('SegmentName') : SearchTerm]))

'Click on the Edit button next to Demographic Info'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Demographic Info Edit Button'))

'Scroll to top of the Demographic Info section'
WebUI.scrollToPosition(0, 0)

'Select campus from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'campus-selector\']/descendant::div[@class=\'Select-control\']', 
    Campus)

'Select Male using the checkbox'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Add Demographic Info/Gender Checkbox', 
        [('index') : 1]))

'Select Female using the checkbox'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Add Demographic Info/Gender Checkbox', 
        [('index') : 2]))

'Click on Include Students under Student?'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Add Demographic Info/Student Radio Button', 
        [('index') : 2]))

'Select student grade from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'student-grade-selector\']/descendant::div[@class=\'Select-control\']', 
    StudentGrade)

'Enter minimum age'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Demographic Info/Add Demographic Info/Minimum Age Input Field'), 
    '13')

'Enter maximum age'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Demographic Info/Add Demographic Info/Maximum Age Input Field'), 
    '99')

'Click All under Marital Status'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Add Demographic Info/Marital Status Checkbox', 
        [('index') : 1]))

'Click on Yes under Has Children'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Add Demographic Info/Has Children Radio Button', 
        [('index') : 2]))

'Select grade from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'grade-selector\']/descendant::div[@class=\'Select-control\']', 
    ChildGrade)

'Click button to save demographic info'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Demographic Info/Add Demographic Info/Demographic Info Save Button'))

'Verify demographic info updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info Updated Toast'), FailureHandling.OPTIONAL)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info Updated Toast Text'), 'Demographic info updated successfully', 
    FailureHandling.OPTIONAL)

'Scroll to top of the Demographic Info section'
WebUI.scrollToPosition(0, 0)

'Verify the updated Target Campus value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Target Campus Value', [
            ('TargetCampus') : Campus]), Campus)

'Verify the updated Gender value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Gender Value', [('Gender') : 'Male, Female']), 
    'Male, Female')

'Verify the updated Student? value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Student Value', [('Student') : 'Include Students']), 
    'Include Students')

'Verify the updated Student Grade value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Student Grade Value', [
            ('StudentGrade') : StudentGradeValue]), StudentGradeValue)

'Verify the updated Age value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Age Value', [('Age') : '13 - 99']), 
    '13 - 99')

'Verify the updated Marital Status value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Marital Status Value', 
        [('MaritalStatus') : 'Divorced, Married, Single, Widowed']), 'Divorced, Married, Single, Widowed')

'Verify the updated Children value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Children Value', [('Children') : ChildGradeValue]), 
    ChildGradeValue)

'Click on the Edit button next to Demographic Info'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Demographic Info Edit Button'))

'Scroll to top of the Demographic Info section'
WebUI.scrollToPosition(0, 0)

'Click on the Reset button to clear data'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Demographic Info Reset Button'))

'Click button to save demographic info'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Demographic Info/Add Demographic Info/Demographic Info Save Button'))

'Verify demographic info updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info Updated Toast'), FailureHandling.OPTIONAL)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info Updated Toast Text'), 'Demographic info updated successfully', 
    FailureHandling.OPTIONAL)

'Scroll to top of the Demographic Info section'
WebUI.scrollToPosition(0, 0)

'Verify default value of Target Campus is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Target Campus Value', [
            ('TargetCampus') : 'N/A']), 'N/A')

'Verify default value of Gender is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Gender Value', [('Gender') : 'N/A']), 
    'N/A')

'Verify default value of Student is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Student Value', [('Student') : 'N/A']), 
    'N/A')

'Verify default value of Grade is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Student Grade Value', [
            ('StudentGrade') : 'N/A']), 'N/A')

'Verify default value of Age is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Age Value', [('Age') : 'N/A']), 
    'N/A')

'Verify default value of Marital Status is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Marital Status Value', 
        [('MaritalStatus') : 'N/A']), 'N/A')

'Verify default value of Children is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Children Value', [('Children') : 'N/A']), 
    'N/A')

'Click on the Edit button next to Events'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Events/Events Edit Button'))

'Scroll to Events header'
WebUI.scrollToElement(findTestObject('HC-Web/Communications/Segments/Overview/Events/Events Header'), 0)

'Click button to select Event'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Events/Add Event/Event Type Radio Button', [('index') : 2]))

'Select event from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@name=\'event-selector\']/descendant::div[@class=\'Select-control\']', 
    'Baptism')

'Select event attendance from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByName'('event-first-attendance-selector', 'Attended')

'Select attendance count from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByName'('event-first-attendance-count-selector', '1')

'Select event attendance from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByName'('event-second-attendance-selector', 'Unattended')

'Select attendance count from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByName'('event-second-attendance-count-selector', '1')

'Click on the Include Parent-Child Contact Information checkbox'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Events/Add Event/Ìnclude Parent Child Contact Information Checkbox'))

'Click button to save'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Events/Add Event/Event Save Button'))

'Verify events updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segments/Overview/Events Updated Toast'), FailureHandling.OPTIONAL)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Events Updated Toast Text'), 'Events updated successfully', 
    FailureHandling.OPTIONAL)

'Verify Event label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Events/Event Label', [('Event') : 'Event Type']), 
    'Event Type')

'Verify Event Category is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Events/Event Value', [('EventName') : 'Baptism']), 
    'Baptism')

'Verify Streak or Count is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Events/Streak or Count Label', [('StreakOrCount') : 'Streak']), 
    'Streak')

'Verify Attendance Status and Count are displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Events/Streak Attendance Status And Count', 
        [('index') : 1]), 'Attended 1')

'Verify Attendance Status and Count are displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Events/Streak Attendance Status And Count', 
        [('index') : 2]), '[AND] Unattended 1')

'Verify Include Parent-Child Contact Information Label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Events/Include Parent Child Contact Information Label', 
        [('IncludeParentContactInformation') : 'Include Parent-Child Contact Information']), 'Include Parent-Child Contact Information')

'Verify the value of Include Parent-Child Contact Information is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Events/Include Parent Child Contact Information Value', 
        [('index') : 5]), 'Yes')

'Scroll to top of the Demographic Info section'
WebUI.scrollToPosition(0, 0)

'Click on the Edit button next to Events'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Events/Events Edit Button'))

'Scroll to top of the Demographic Info section'
WebUI.scrollToPosition(0, 0)

'Click on the Reset button to clear data'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Events/Events Reset Button'))

'Click button to save'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Events/Add Event/Event Save Button'))

'Verify events updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segments/Overview/Events Updated Toast'), FailureHandling.OPTIONAL)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Events Updated Toast Text'), 'Events updated successfully', 
    FailureHandling.OPTIONAL)

'Scroll to Events Edit button'
WebUI.scrollToElement(findTestObject('HC-Web/Communications/Segments/Overview/Events/Events Edit Button'), 0)

'Verify default value of Event is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Events/Event Value', [('EventName') : 'N/A']), 
    'N/A')

'Click on the Edit button next to Milestones'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Milestones/Milestones Edit Button'))

'Select milestone from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'milestone-selector\']/descendant::div[@class=\'Select-control\']', 
    FirstMilestone)

'Click on Complete under Select Milestone Status'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Milestones/Add Milestone/Milestone Status Radio Button', 
        [('index') : 1, ('index1') : 1]))

'Click button to save milestone'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Milestones/Add Milestone/Milestone Save Button'))

'Verify milestones updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segments/Overview/Milestones Updated Toast'), FailureHandling.OPTIONAL)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Milestones Updated Toast Text'), 'Milestones updated successfully', 
    FailureHandling.OPTIONAL)

'Verify Milestone/Status label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Milestones/Milestone Label', [('Milestone') : 'Accepted Christ']), 
    FirstMilestone)

'Verify default value of Milestone/Status is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Milestones/Milestone Status', [('MilestoneStatus') : 'Complete']), 
    'Complete')

'Click on the Edit button next to Milestones'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Milestones/Milestones Edit Button'))

'Click on the Reset button to clear data'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Milestones/Milestones Reset Button'))

'Click button to save milestone'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Milestones/Add Milestone/Milestone Save Button'))

'Verify milestones updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segments/Overview/Milestones Updated Toast'), FailureHandling.OPTIONAL)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Milestones Updated Toast Text'), 'Milestones updated successfully', 
    FailureHandling.OPTIONAL)

'Verify Milestone/Status label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Milestones/Milestone Label', [('Milestone') : 'Milestone/Status']), 
    'Milestone/Status')

'Verify default value of Milestone/Status is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Milestones/Milestone Status', [('MilestoneStatus') : 'N/A']), 
    'N/A')

'Click on the Edit button next to Additional Engagements'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/Additional Engagements Edit Button'))

'Click on Any under In Ministry'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/Add Additional Engagements/In Ministry Radio Button', 
        [('index') : 1]))

'Click on Any under In Small Group'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/Add Additional Engagements/In Small Group Radio Button', 
        [('index') : 1]))

'Click Member under Member Status'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/Add Additional Engagements/Member Status Checkbox', 
        [('index') : 3]))

'Click button to save additional engagements'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Additional Engagements/Add Additional Engagements/Additional Engagements Save Button'))

'Verify additional engagements updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements Updated Toast'), 
    FailureHandling.OPTIONAL)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements Updated Toast Text'), 
    'Additional Engagements updated successfully', FailureHandling.OPTIONAL)

'Verify the updated In Ministry value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/In Ministry Value', 
        [('InMinistry') : 'N/A']), 'N/A')

'Verify the updated In Small Group value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/In Small Group Value', 
        [('InSmallGroup') : 'N/A']), 'N/A')

'Verify the updated Member Status value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/Member Status Value', 
        [('MemberStatus') : 'Member']), 'Member')

'Click on the Edit button next to Additional Engagements'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/Additional Engagements Edit Button'))

'Click on the Reset button to clear data'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/Additional Engagements Reset Button'))

'Click button to save additional engagements'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Additional Engagements/Add Additional Engagements/Additional Engagements Save Button'))

'Verify additional engagements updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements Updated Toast'), 
    FailureHandling.OPTIONAL)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements Updated Toast Text'), 
    'Additional Engagements updated successfully', FailureHandling.OPTIONAL)

'Verify default value of In Ministry is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/In Ministry Value', 
        [('InMinistry') : 'N/A']), 'N/A')

'Verify default value of In Small Group is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/In Small Group Value', 
        [('InSmallGroup') : 'N/A']), 'N/A')

'Verify default value of Member Status is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/Member Status Value', 
        [('MemberStatus') : 'N/A']), 'N/A')

WebUI.closeBrowser()

