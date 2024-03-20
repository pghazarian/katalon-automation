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

def SegmentName= "ST Segment - $CurrentDateTime"

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/communications-central/segment-search'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Page_Healthy Church/span_plusCreate Segment'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Page_Healthy Church/input__segment_create--segment_name'), 
    SegmentName)

not_run: WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Page_Healthy Church/textarea_ST Segment Test 3192024'), 
    'ST Segment Test 3192024')

WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Page_Healthy Church/textarea_ST Segment Test 3192024 Description'), 
    "$SegmentName Description")

//CustomKeywords.'customUtility.TestObjectHelper.setDropDownValue'('react-select-7--value', 'Anaheim')
'Select campus from dropdown'
CustomKeywords.'customUtility.TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'segment_create--church_campus\']/descendant::div[@class=\'Select-control\']', 
    'Anaheim')

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Campus Dropdown'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Page_Healthy Church/div_Anaheim'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Page_Healthy Church/span_Create'))

WebUI.closeBrowser()

