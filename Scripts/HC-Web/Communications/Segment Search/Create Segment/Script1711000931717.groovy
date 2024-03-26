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

def CurrentDateTime = CustomKeywords.'customUtility.StringHelper.getIsoFormatDate'(date)

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
CustomKeywords.'customUtility.TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'segment_create--church_campus\']/descendant::div[@class=\'Select-control\']', 
    'Anaheim')

'Click button to save a new segment'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Segment Create Button'))

'Verify segment record added toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Segment Record Toast'), FailureHandling.STOP_ON_FAILURE)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Segment Record Added Toast Header'), 
    'Segment record added')

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Segment Record Added Toast Text'), 
    'You’ve successfully created and linked a new record')

'Verify Demographic Info label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Demographic Info Label'), 
    'Demographic info')

'Verify Edit button next to Demographic Info is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Demographic Info Edit Button'), 
    FailureHandling.STOP_ON_FAILURE)

'Verify Target Campus label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Target Campus Label'), 
    'Target Campus')

'Verify default value of Target Campus is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Target Campus Value'), 
    'N/A')

'Verify Gender label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Gender Label'), 'Gender')

'Verify default value of Gender is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Gender Value'), 'N/A')

'Verify Age label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Age Label'), 'Age')

'Verify default value of Age is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Age Value'), 'N/A')

'Verify Marital Status label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Marital Status Label'), 
    'Marital Status')

'Verify default value of Marital Status is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Marital Status Value'), 
    'N/A')

'Verify Children label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Children Label'), 
    'Children')

'Verify default value of Children is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Children Value'), 
    'N/A')

WebUI.closeBrowser()

