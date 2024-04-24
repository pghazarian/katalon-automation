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

not_run: WebUI.callTestCase(findTestCase('HC-Web/Communications/Segment Search/Shared/Create Segment'), [:], FailureHandling.STOP_ON_FAILURE)

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/communications-central/segment-search'], FailureHandling.STOP_ON_FAILURE)

SearchTerm = 'ST Segment For Event Test 4'

'Type Search term'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Search Text Field'), SearchTerm)

'Initiate Search'
WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Search Text Field'), Keys.chord(Keys.ENTER))

'Open the segment record from the search results'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Table Row', [('SegmentName') : SearchTerm]))

'Click on the Edit button next to Events'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Events/Events Edit Button'))

'Scroll to Events header'
WebUI.scrollToElement(findTestObject('HC-Web/Communications/Segment Search/Overview/Events/Events Header'), 0)

'Click button to select Event'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Events/Add Event/Event Type Radio Button', [('index') : 1]))

'Select event from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@name=\'event-selector\']/descendant::div[@class=\'Select-control\']', 
    'ST Event 1')

'Select count from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByName'('event-type-selector', 'Count')

'Select status from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByName'('event-occurrence-attendance-selector', 'Attended')

'Select attendance count from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByName'('event-occurence-count-selector', '1')

'Click on the date picker'
WebUI.setText(findTestObject('HC-Web/Communications/Segment Search/Overview/Events/Add Event/Data Picker', [('index') : 3]), 
    '04/01/2024')

'Click on the date picker'
WebUI.setText(findTestObject('HC-Web/Communications/Segment Search/Overview/Events/Add Event/Data Picker', [('index') : 4]), 
    '04/22/2024')

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Events/Add Event/Event Save Button'))

not_run: WebUI.closeBrowser()

