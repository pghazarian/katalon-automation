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

def date = new Date().plus(1).format('MMddyyyy').toString()

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : "/events-central/event/$EventId/overview"], FailureHandling.STOP_ON_FAILURE)

'Open actions dropdown for event to be duplicated'
WebUI.click(findTestObject('HC-Web/Event/Overview/Actions Dropdown'))

'Select duplicate option from actions dropdown'
WebUI.click(findTestObject('HC-Web/Event/Overview/Duplicate Option'))

'Update start time to a future date'
WebUI.setText(findTestObject('HC-Web/Event/Event Creation/Start Date Text Field'), Keys.chord(Keys.CONTROL + 'a') + date)

'Click button to create event'
WebUI.click(findTestObject('HC-Web/Event/Event Creation/Create Button'))

'Verify event name'
WebUI.verifyElementAttributeValue(findTestObject('HC-Web/Event/Details/Event Name'), 'value', EventName, 0)

'Verify free event'
WebUI.verifyElementChecked(findTestObject('HC-Web/Event/Details/Free Event Radio Option'), 0)

'Verify event category'
WebUI.verifyElementText(findTestObject('HC-Web/Event/Details/Selected Category Text Area'), EventCategory)

'Verify event campus'
WebUI.verifyElementText(findTestObject('HC-Web/Event/Details/Selected Campus Text Area'), EventCampus)

'Navigate to details page'
WebUI.click(findTestObject('HC-Web/Event/Details/Details Subnav'))

'Verify event description'
WebUI.verifyElementText(findTestObject('HC-Web/Event/Details/Event Description Text Area'), EventDescription)

WebUI.closeBrowser()

