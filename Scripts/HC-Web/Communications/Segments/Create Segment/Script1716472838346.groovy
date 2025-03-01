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

def SegmentName = "ST Segment - $CurrentDateTime"

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/communications-central/segment-search'], FailureHandling.STOP_ON_FAILURE)

'Click button to create a new segment'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Create Segment Button'))

'Enter Segment name'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segments/Create Segment Record/Segment Name Input Field'), 
    SegmentName)

'Enter Segment description'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segments/Create Segment Record/Segment Description Text Area'), 
    "$SegmentName Description")

'Select campus from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'segment_create--church_campus\']/descendant::div[@class=\'Select-control\']', 
    Campus)

'Click button to save a new segment'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Create Segment Record/Create Button'))

'Verify segment record added toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segments/Overview/Segment Record Toast'), FailureHandling.STOP_ON_FAILURE)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Segment Record Added Toast Header'), 'Segment record added')

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Segment Record Added Toast Text'), 'You’ve successfully created and linked a new record')

'Verify segment name is visible in the Overview page'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Segment Name', [('SegmentName') : SegmentName]), 
    SegmentName)

'Verify segment description is visible in the Overview page'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Segment Description', [('SegmentDescription') : "$SegmentName Description"]), 
    "$SegmentName Description")

'Verify segment campus is visible in the Overview page'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Segment Campus', [('SegmentCampus') : 'Anaheim']), 
    Campus)

'Verify default status of segment is visible in the Overview page'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Segment Status', [('SegmentStatus') : 'Inactive']), 
    'Inactive')

'Verify Demographic Info label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Demographic Info Header'), 
    'Demographic info\nResult:0')

'Verify Demographic Info record result count'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Segment Criteria Result Count Button', [
            ('index') : 1]), 'Result:0')

'Verify Edit button next to Demographic Info is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Demographic Info Edit Button'), 
    FailureHandling.STOP_ON_FAILURE)

'Verify Target Campus label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Target Campus Label'), 
    'Target Campus')

'Verify default value of Target Campus is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Target Campus Value', [
            ('TargetCampus') : 'N/A']), 'N/A')

'Verify Gender label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Gender Label'), 'Gender')

'Verify default value of Gender is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Gender Value', [('Gender') : 'N/A']), 
    'N/A')

'Verify Student label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Student Label'), 'Student')

'Verify default value of Student is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Student Value', [('Student') : 'N/A']), 
    'N/A')

'Verify Grade label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Grade Label'), 'Grade')

'Verify default value of Grade is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Student Grade Value', [
            ('StudentGrade') : 'N/A']), 'N/A')

'Verify Age label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Age Label'), 'Age')

'Verify default value of Age is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Age Value', [('Age') : 'N/A']), 
    'N/A')

'Verify Marital Status label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Marital Status Label'), 
    'Marital Status')

'Verify default value of Marital Status is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Marital Status Value', 
        [('MaritalStatus') : 'N/A']), 'N/A')

'Verify Children label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Children Label'), 'Children')

'Verify default value of Children is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Children Value', [('Children') : 'N/A']), 
    'N/A')

'Verify Events label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Events/Events Header'), 'Events\nResult:0')

'Verify Events record result count'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Segment Criteria Result Count Button', [
            ('index') : 2]), 'Result:0')

'Verify Edit button next to Events is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segments/Overview/Events/Events Edit Button'), FailureHandling.STOP_ON_FAILURE)

'Verify Event label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Events/Event Label', [('Event') : 'Event']), 
    'Event')

'Verify default value of Event is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Events/Event Value', [('EventName') : 'N/A']), 
    'N/A')

'Verify Milestones label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Milestones/Milestones Header'), 'Milestones\nResult:0')

'Verify Milestones record result count'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Segment Criteria Result Count Button', [
            ('index') : 3]), 'Result:0')

'Verify Edit button next to Milestones is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segments/Overview/Milestones/Milestones Edit Button'), 
    FailureHandling.STOP_ON_FAILURE)

'Verify Milestone/Status label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Milestones/Milestone Label', [('Milestone') : 'Milestone/Status']), 
    'Milestone/Status')

'Verify default value of Milestone/Status is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Milestones/Milestone Status', [('MilestoneStatus') : 'N/A']), 
    'N/A')

'Verify Additional Engagements label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/Additional Engagements Header'), 
    'Additional Engagements\nResult:0')

'Verify Additional Engagements record result count'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Segment Criteria Result Count Button', [
            ('index') : 4]), 'Result:0')

'Verify Edit button next to Additional Engagements is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/Additional Engagements Edit Button'), 
    FailureHandling.STOP_ON_FAILURE)

'Verify In Ministry label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/In Ministry Label'), 
    'In Ministry')

'Verify default value of In Ministry is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/In Ministry Value', 
        [('InMinistry') : 'N/A']), 'N/A')

'Verify In Small Group label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/In Small Group Label'), 
    'In Small Group')

'Verify default value of In Small Group is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/In Small Group Value', 
        [('InSmallGroup') : 'N/A']), 'N/A')

'Verify Member Status label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/Member Status Label'), 
    'Member Status')

'Verify default value of Member Status is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/Member Status Value', 
        [('MemberStatus') : 'N/A']), 'N/A')

WebUI.closeBrowser()

