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
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Segment Name Input Field'), SegmentName)

'Enter Segment description'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Segment Description Text Area'), "$SegmentName Description")

'Select campus from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'segment_create--church_campus\']/descendant::div[@class=\'Select-control\']', 
    'Anaheim')

'Click button to save a new segment'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Segment Create Button'))

'Click on the Edit button next to Milestones'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestones Edit Button'))

'Select milestone from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'milestone-selector\']/descendant::div[@class=\'Select-control\']', 
    'Accepted Christ')

'Click on Complete under Select Milestone Status'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Complete Radio Button'))

'Click button to save milestone'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Save Button'))

'Verify milestones updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones Updated Toast'), FailureHandling.STOP_ON_FAILURE)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones Updated Toast Text'), 'Milestones updated successfully')

'Verify Milestone/Status label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone New Value'), 
    'Accepted Christ')

'Verify default value of Milestone/Status is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Status Complete'), 
    'Complete')

'Click on the Edit button next to Milestones'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestones Edit Button'))

'Select milestone from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'milestone-selector\']/descendant::div[@class=\'Select-control\']', 
    'Baptism')

'Click on Incomplete under Select Milestone Status'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Incomplete Radio Button'))

'Click button to save milestone'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Save Button'))

'Verify milestones updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones Updated Toast'), FailureHandling.STOP_ON_FAILURE)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones Updated Toast Text'), 'Milestones updated successfully')

'Verify Milestone/Status label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Updated Value'), 
    'Baptism')

'Verify default value of Milestone/Status is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Status Incomplete'), 
    'Incomplete')

'Click on the Edit button next to Milestones'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestones Edit Button'))

'Click button to remove milestone'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Remove Button'))

'Click button to save milestone'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Save Button'))

'Verify milestones updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones Updated Toast'), FailureHandling.STOP_ON_FAILURE)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones Updated Toast Text'), 'Milestones updated successfully')

'Verify Milestone/Status label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Status Label'), 
    'Milestone/Status')

'Verify default value of Milestone/Status is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Status Default Value'), 
    'N/A')

WebUI.closeBrowser()

