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
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segments/Create Segment Record/Segment Name Input Field'), SegmentName)

'Enter Segment description'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segments/Create Segment Record/Segment Description Text Area'), "$SegmentName Description")

'Select campus from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'segment_create--church_campus\']/descendant::div[@class=\'Select-control\']', 
    'Anaheim')

'Click button to save a new segment'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Create Segment Record/Create Button'))

'Verify segment record added toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segments/Overview/Segment Record Toast'), FailureHandling.STOP_ON_FAILURE)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Segment Record Added Toast Header'), 
    'Segment record added')

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Segment Record Added Toast Text'), 
    'You’ve successfully created and linked a new record')

'Click button to duplicate the segment record'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Duplicate Button'))

'Click button to duplicate a segment record'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Create Record Button'))

'Click on Yes in the confirmation modal'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Create Duplicate Record Yes Button'))

'Verify segment name is visible in the Overview page'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Segment Name', [('SegmentName') : "Copy of $SegmentName"]), 
    "Copy of $SegmentName")

'Verify segment description is visible in the Overview page'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Segment Description', [('SegmentDescription') : "$SegmentName Description"]), 
    "$SegmentName Description")

'Verify segment campus is visible in the Overview page'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Segment Campus', [('SegmentCampus') : 'Anaheim']), 
    'Anaheim')

'Verify default status of segment is visible in the Overview page'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Segment Status', [('SegmentStatus') : 'Inactive']), 
    'Inactive')

'Verify default value of Target Campus is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Target Campus Value', 
        [('TargetCampus') : 'N/A']), 'N/A')

'Verify default value of Gender is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Gender Value', [('Gender') : 'N/A']), 
    'N/A')

'Verify default value of Age is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Age Value', [('Age') : 'N/A']), 
    'N/A')

'Verify default value of Marital Status is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Marital Status Value', 
        [('MaritalStatus') : 'N/A']), 'N/A')

'Verify default value of Children is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Children Value', 
        [('Children') : 'N/A']), 'N/A')

'Verify default value of Event is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Events/Event Value', [('EventName') : 'N/A']), 
    'N/A')

'Verify default value of Milestone/Status is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Milestones/Milestone Status', [('MilestoneStatus') : 'N/A']), 
    'N/A')

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

