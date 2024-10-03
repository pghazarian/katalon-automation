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

def CommunicationName = "ST Communication - $CurrentDateTime"

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/communications-central/communication'], FailureHandling.STOP_ON_FAILURE)

'Click button to create new communication'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Communications/Create Communication Button'))

'Enter Communication name'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Communications/Create New Communication/Communication Name Input Field'), 
    CommunicationName)

'Enter Communication description'
WebUI.setText(findTestObject('HC-Web/Communications/Communications/Create New Communication/Communication Description Text Area'), 
    "$CommunicationName Description")

'Select campus from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'communication_create--select_campus\']/descendant::div[@class=\'Select-control\']', 
    Campus)

'Click button to save a new communication'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Communications/Create New Communication/Save Button'))

'Verify communication record added toast is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Overview/Communication Record Toast'), '')

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Overview/Communication Record Added Toast Header'), 
    'Communication record added')

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Overview/Communication Record Added Toast Text'), 
    'You’ve successfully created and linked a new communication')

'Verify communication name is visible in the Overview page'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Overview/Communication Name', [('CommunicationName') : CommunicationName]), 
    CommunicationName)

'Verify communication description is visible in the Overview page'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Overview/Communication Description', [('CommunicationDescription') : "$CommunicationName Description"]), 
    "$CommunicationName Description")

'Verify communication scoped campus is visible in the Overview page'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Overview/Communication Scoped Campus', [('CommunicationScopedCampus') : Campus]), 
    Campus)

'Verify default status of communication is visible in the Overview page'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Overview/Communication Status', [('CommunicationStatus') : 'Inactive']), 
    'Inactive')

'Verify Communication Details label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Overview/Communication Details/Communication Details Label'), 
    'Communication Details')

'Verify From Email label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Overview/Communication Details/From Email Label'), 
    'From Email')

'Verify default value of From Email is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Overview/Communication Details/From Email Value', 
        [('FromEmail') : 'N/A']), 'N/A')

'Verify Recipients label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Overview/Communication Details/Recipients Label'), 
    'Recipients')

'Verify default value of Recipients is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Overview/Communication Details/Recipients Value', 
        [('Recipients') : 'N/A']), 'N/A')

'Verify Reply To is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Overview/Communication Details/Reply To Label'), 
    'Reply To')

'Verify default value of Reply To is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Overview/Communication Details/Reply To Value', 
        [('ReplyTo') : 'N/A']), 'N/A')

'Verify Email Subject label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Overview/Communication Details/Email Subject Label'), 
    'Email Subject')

'Verify default value of Email Subject is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Overview/Communication Details/Email Subject Value', 
        [('EmailSubject') : CommunicationName]), CommunicationName)

WebUI.closeBrowser()

