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

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/communications-central/segment-search'], FailureHandling.STOP_ON_FAILURE)

SearchTerm = 'ST Segment - 2024-04-05 15:29:23'

'Maximize current window'
WebUI.maximizeWindow()

'Type Search term'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Search Text Field'), SearchTerm)

'Initiate Search'
WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Search Text Field'), Keys.chord(Keys.ENTER))

'Open the segment record from the search results'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Table Row', [('SegmentName') : SearchTerm]))

'Click on the Edit button next to Milestones'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestones Edit Button'))

'Select milestone from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@id=\'layout\']/div[2]/div/main/div/div[3]/section/div/section/div/div/div', 
    'Accepted Christ')

WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Add Milestone Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/AND Operator'))

'Select milestone from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@id=\'layout\']/div[2]/div/main/div/div[3]/section/div/section/div[2]/div/div', 
    'Baptism')

'Click on Complete under Select Milestone Status'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Complete Radio Button', 
        [('index') : 2]))

WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Save Button'))

'Verify milestones updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones Updated Toast'), FailureHandling.OPTIONAL)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones Updated Toast Text'), 'Milestones updated successfully', 
    FailureHandling.OPTIONAL)

'Verify selected Milestone is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone New Value', [
            ('index') : 1]), 'Accepted Christ')

'Verify status of selected Milestone is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Status New Value', 
        [('index') : 1]), 'Incomplete')

'Verify selected Milestone is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone New Value', [
            ('index') : 2]), 'Baptism')

'Verify status of selected Milestone is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Status New Value', 
        [('index') : 2]), '[AND] Complete')

'Click on the Edit button next to Milestones'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestones Edit Button'))

'Click button to remove milestone'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Remove Button'))

'Click button to remove milestone'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Remove Button'))

'Click button to save milestone'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Save Button'))

'Verify milestones updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones Updated Toast'), FailureHandling.OPTIONAL)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones Updated Toast Text'), 'Milestones updated successfully', 
    FailureHandling.OPTIONAL)

'Verify Milestone/Status label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Status Label'), 
    'Milestone/Status')

'Verify default value of Milestone/Status is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Status Default Value'), 
    'N/A')

WebUI.closeBrowser()

