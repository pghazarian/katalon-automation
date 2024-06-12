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

def PastDate = new Date().minus(30)

def StartDate = CustomKeywords.'StringHelper.getUSFormatDateForControl'(PastDate)

def CurrentDate = new Date()

def EndDate = CustomKeywords.'StringHelper.getUSFormatDateForControl'(CurrentDate)

WebUI.callTestCase(findTestCase('HC-Web/Communications/Segments/Shared/Create Segment'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on the Edit button next to Events'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Events/Events Edit Button'))

'Scroll to Events header'
WebUI.scrollToElement(findTestObject('HC-Web/Communications/Segments/Overview/Events/Events Header'), 0)

'Click button to select Event'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Events/Add Event/Event Type Radio Button', [('index') : 1]))

'Select event from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@name=\'event-selector\']/descendant::div[@class=\'Select-control\']', 
    'ST Event 1')

'Select count from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByName'('event-type-selector', 'Count')

'Select status from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByName'('event-occurrence-attendance-selector', 'Attended')

'Select attendance count from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByName'('event-occurence-count-selector', '1')

'Select start date from date picker'
WebUI.setText(findTestObject('HC-Web/Communications/Segments/Overview/Events/Add Event/Data Picker', [('index') : 3]), 
    StartDate)

'Select end date from date picker'
WebUI.setText(findTestObject('HC-Web/Communications/Segments/Overview/Events/Add Event/Data Picker', [('index') : 4]), 
    EndDate)

'Click button to save'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Events/Add Event/Event Save Button'))

'Verify Event label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Events/Event Label', [('Event') : 'Event Name']), 
    'Event Name')

'Verify Event Name is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Events/Event Value', [('EventName') : 'ST Event 1']), 
    'ST Event 1')

'Verify Streak or Count is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Events/Streak or Count Label', [('StreakOrCount') : 'Count']), 
    'Count')

'Verify Attendance Status and Count are displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Events/Count Attendance Status And Count'), 
    'Attended 1')

'Verify Date Range Label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Events/Data Range Label'), 'Date Range')

'Verify Date Range is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Events/Data Range Value'), "$StartDate - $EndDate")

WebUI.closeBrowser()

