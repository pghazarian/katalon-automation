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
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Create Segment Button'))

'Enter Segment name'
WebUI.setText(findTestObject('HC-Web/Communications/Segment Search/Create Segment Record/Segment Name Input Field'), SegmentName)

'Enter Segment description'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Create Segment Record/Segment Description Text Area'), "$SegmentName Description")

'Select campus from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'segment_create--church_campus\']/descendant::div[@class=\'Select-control\']', 
    'Anaheim')

'Click button to save a new segment'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Create Segment Record/Create Button'))

'Verify segment record added toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Segment Record Toast'), FailureHandling.STOP_ON_FAILURE)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Segment Record Added Toast Header'), 
    'Segment record added')

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Segment Record Added Toast Text'), 
    'You’ve successfully created and linked a new record')

'Click on the Edit button next to Demographic Info'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Demographic Info Edit Button'))

'Scroll to top of the Demographic Info section'
WebUI.scrollToPosition(0, 0)

'Select campus from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'campus-selector\']/descendant::div[@class=\'Select-control\']', 
    'Anaheim')

'Click button to save demographic info'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Demographic Info/Add Demographic Info/Demographic Info Save Button'))

'Click on the Edit button next to Milestones'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestones Edit Button'))

'Scroll to remove button'
WebUI.scrollToElement(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestones Label'), 
    0)

'Select milestone from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'milestone-selector\']/descendant::div[@class=\'Select-control\']', 
    'Accepted Christ')

'Click on Complete under Select Milestone Status'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Status Radio Button'))

'Click button to save milestone'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Save Button'))

'Click on the Edit button next to Additional Engagements'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/Additional Egagements Edit Button'))

'Click on Yes under In Ministry'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/In Ministry Radio Button', 
        [('index') : 2]))

'Click on Yes under In Small Group'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/In Small Group Radio Button', 
        [('index') : 2]))

'Click Member under Member Status'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/Member Status Checkbox', 
        [('index') : 3]))

'Click button to save additional engagements'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/Additional Engagements Save Button'))

'Scroll to top of the Demographic Info section'
WebUI.scrollToPosition(0, 0)

'Click button to duplicate the segment record'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Duplicate Button'))

'Click button to duplicate a segment record'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Create Record Button'))

'Click on Yes in the confirmation modal'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Create Duplicate Record Yes Button'))

'Verify segment name is visible in the Overview page'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Segment Name', [('SegmentName') : "Copy of $SegmentName"]), 
    "Copy of $SegmentName")

'Verify segment description is visible in the Overview page'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Segment Description', [('SegmentDescription') : "$SegmentName Description"]), 
    "$SegmentName Description")

'Verify segment campus is visible in the Overview page'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Segment Campus', [('SegmentCampus') : 'Anaheim']), 
    'Anaheim')

'Verify default status of segment is visible in the Overview page'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Segment Status', [('SegmentStatus') : 'Inactive']), 
    'Inactive')

'Verify the updated Target Campus value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Target Campus Value', 
        [('TargetCampus') : 'Anaheim']), 'Anaheim')

'Verify Milestone/Status label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Label', [('Milestone') : 'Accepted Christ']), 
    'Accepted Christ')

'Verify default value of Milestone/Status is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Status', [('MilestoneStatus') : 'Complete']), 
    'Complete')

'Verify the updated In Ministry value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/In Ministry Value', 
        [('InMinistry') : 'Yes']), 'Yes')

'Verify the updated In Small Group value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/In Small Group Value', 
        [('InSmallGroup') : 'Yes']), 'Yes')

'Verify the updated Member Status value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/Member Status Value', 
        [('MemberStatus') : 'Member']), 'Member')

WebUI.closeBrowser()

