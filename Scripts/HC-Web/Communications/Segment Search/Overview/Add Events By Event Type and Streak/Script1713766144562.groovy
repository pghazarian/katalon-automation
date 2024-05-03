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

WebUI.callTestCase(findTestCase('HC-Web/Communications/Segment Search/Shared/Create Segment'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on the Edit button next to Events'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Events/Events Edit Button'))

'Scroll to Events header'
WebUI.scrollToElement(findTestObject('HC-Web/Communications/Segment Search/Overview/Events/Events Header'), 0)

'Click button to select Event'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Events/Add Event/Event Type Radio Button', [('index') : 2]))

'Select event from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@name=\'event-selector\']/descendant::div[@class=\'Select-control\']', 
    'Baptism')

'Select event attendance from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByName'('event-first-attendance-selector', 'Attended')

'Select attendance count from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByName'('event-first-attendance-count-selector', '1')

'Select event attendance from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByName'('event-second-attendance-selector', 'Unattended')

'Select attendance count from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByName'('event-second-attendance-count-selector', '1')

'Click button to save'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Events/Add Event/Event Save Button'))

'Verify Event label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Events/Event Label', [('Event') : 'Event Type']), 
    'Event Type')

'Verify Event Category is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Events/Event Value', [('EventName') : 'Baptism']), 
    'Baptism')

'Verify Streak or Count is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Events/Streak or Count Label', [('StreakOrCount') : 'Streak']), 
    'Streak')

'Verify Attendance Status and Count are displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Events/Streak Attendance Status And Count', 
        [('index') : 1]), 'Attended 1')

'Verify Attendance Status and Count are displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Events/Streak Attendance Status And Count', 
        [('index') : 2]), '[AND] Unattended 1')

WebUI.closeBrowser()

