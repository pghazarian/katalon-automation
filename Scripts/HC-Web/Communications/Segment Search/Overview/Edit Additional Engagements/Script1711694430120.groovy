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

'Click on the Edit button next to Additional Engagements'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/Additional Engagements Edit Button'))

'Click on Any under In Ministry'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/In Ministry Any Radio Button'))

'Click on Any under In Small Group'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/In Small Group Any Radio Button'))

'Click All under Member Status'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/Member Status All Checkbox'))

'Click button to save additional engagements'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/Additional Engagements Save Button'))

'Verify additional engagements updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements Updated Toast'), 
    FailureHandling.STOP_ON_FAILURE)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements Updated Toast Text'), 
    'Additional Engagements updated successfully')

'Verify the updated In Ministry value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/In Ministry Value'), 
    'N/A')

'Verify the updated In Small Group value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/In Small Group Value'), 
    'N/A')

'Verify the updated Marital Status value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/Member Status New Value'), 
    'Disengaged Member, Member, Membership Review, Non-Member, Pending')

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/svg_check'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/Additional Engagements Edit Button'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/label_Yes'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/label_Yes'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/Member Status All Checkbox'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/Additional Engagements Save Button'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/Additional Engagements Edit Button'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/label_No'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/label_No'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/Additional Engagements Save Button'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/Additional Engagements Edit Button'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/In Ministry Any Radio Button'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/span_Any'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/label_Yes'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/span_Yes'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/label_No'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/span_No'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/In Ministry Any Radio Button'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/span_Any'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/label_Yes'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/span_Yes'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/label_No'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/span_No'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/Additional Engagements Save Button'))

not_run: WebUI.closeBrowser()

