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

'Click on the Edit button next to Milestones'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestones Edit Button'))

'Select milestone from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'milestone-selector\']/descendant::div[@class=\'Select-control\']', 
    'Accepted Christ')

'Click on Complete under Select Milestone Status'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Complete Radio Button', 
        [('index') : 1]))

'Click button to save milestone'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Save Button'))

'Verify milestones updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones Updated Toast'), FailureHandling.OPTIONAL)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones Updated Toast Text'), 'Milestones updated successfully', 
    FailureHandling.OPTIONAL)

'Verify Milestone/Status label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone New Value', [
            ('index') : 1]), 'Accepted Christ')

'Verify default value of Milestone/Status is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Status New Value', 
        [('index') : 1]), 'Complete')

'Click on the Edit button next to Milestones'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestones Edit Button'))

'Select milestone from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'milestone-selector\']/descendant::div[@class=\'Select-control\']', 
    'Baptism')

'Click on Incomplete under Select Milestone Status'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Incomplete Radio Button', 
        [('index') : 1]))

'Click button to save milestone'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Save Button'))

'Verify milestones updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones Updated Toast'), FailureHandling.OPTIONAL)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones Updated Toast Text'), 'Milestones updated successfully', 
    FailureHandling.OPTIONAL)

'Verify Milestone/Status label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone New Value', [
            ('index') : 1]), 'Baptism')

'Verify default value of Milestone/Status is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Status New Value', 
        [('index') : 1]), 'Incomplete')

'Click on the Edit button next to Milestones'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestones Edit Button'))

'Click button to remove milestone'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Remove Button'))

'Click button to save milestone'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Save Button'))

'Verify milestones updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones Updated Toast'), FailureHandling.STOP_ON_FAILURE)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones Updated Toast Text'), 'Milestones updated successfully', 
    FailureHandling.CONTINUE_ON_FAILURE)

'Verify Milestone/Status label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Status Label', 
        [('index') : 1]), 'Milestone/Status')

'Verify default value of Milestone/Status is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Status Default Value', 
        [('index') : 1]), 'N/A')

WebUI.closeBrowser()

