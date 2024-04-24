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

'Type Search term'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Search Text Field'), SearchTerm)

'Initiate Search'
WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Search Text Field'), Keys.chord(Keys.ENTER))

'Open the segment record from the search results'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Table Row', [('SegmentName') : SearchTerm]))

'Click on the Edit button next to Milestones'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestones Edit Button'))

'Select milestone from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@id=\'layout\']/div[2]/div/main/div/div[3]/section/div/section/div/div/div', 
    'Accepted Christ')

'Click button to add milestone'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Add Milestone Button'))

'Click on the AND operator'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Operator', [('index') : 1
            , ('index1') : 1]))

'Select milestone from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@id=\'layout\']/div[2]/div/main/div/div[3]/section/div/section/div[2]/div/div', 
    'Baptism')

'Click on Complete under Select Milestone Status'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Status Radio Button', 
        [('index') : 2, ('index1') : 1]))

'Click button to add milestone'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Add Milestone Button'))

'Click on the AND operator'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Operator', [('index') : 2
            , ('index1') : 1]))

'Select milestone from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@id=\'layout\']/div[2]/div/main/div/div[3]/section/div/section/div[3]/div/div', 
    'Signed Membership Agreement')

'Click on Complete under Select Milestone Status'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Status Radio Button', 
        [('index') : 3, ('index1') : 1]))

'Click button to save milestone'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Save Button'))

'Verify milestones updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones Updated Toast'), FailureHandling.OPTIONAL)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones Updated Toast Text'), 'Milestones updated successfully', 
    FailureHandling.OPTIONAL)

'Verify selected Milestone is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Label', [('Milestone') : 'Accepted Christ']), 
    'Accepted Christ')

'Verify status of selected Milestone is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Status', [('MilestoneStatus') : 'Incomplete']), 
    'Incomplete')

'Verify selected Milestone is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Label', [('Milestone') : 'Baptism']), 
    'Baptism')

'Verify status of selected Milestone is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Status New Value', 
        [('index') : 2]), '[AND] Complete')

'Verify selected Milestone is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Label', [('Milestone') : 'Signed Membership Agreement']), 
    'Signed Membership Agreement')

'Verify status of selected Milestone is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Status New Value', 
        [('index') : 3]), '[AND] Complete')

'Click on the Edit button next to Milestones'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestones Edit Button'))

'Scroll to Milestones header'
WebUI.scrollToElement(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestones Label'), 
    0)

'Click on the AND operator'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Operator', [('index') : 1
            , ('index1') : 2]))

'Click button to save milestone'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Save Button'))

'Verify milestones updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones Updated Toast'), FailureHandling.OPTIONAL)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones Updated Toast Text'), 'Milestones updated successfully', 
    FailureHandling.OPTIONAL)

'Verify selected Milestone is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Label', [('Milestone') : 'Accepted Christ']), 
    'Accepted Christ')

'Verify status of selected Milestone is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Status', [('MilestoneStatus') : 'Incomplete']), 
    'Incomplete')

'Verify selected Milestone is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Label', [('Milestone') : 'Baptism']), 
    'Baptism')

'Verify status of selected Milestone is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Status New Value', 
        [('index') : 2]), '[OR] Complete')

'Verify selected Milestone is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Label', [('Milestone') : 'Signed Membership Agreement']), 
    'Signed Membership Agreement')

'Verify status of selected Milestone is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Status New Value', 
        [('index') : 3]), '[OR] Complete')

'Click on the Edit button next to Milestones'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestones Edit Button'))

'Scroll to remove button'
WebUI.scrollToElement(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestones Label'), 
    0)

'Click button to remove milestone'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Add Milestone/Milestone Remove Button'))

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
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Label', [('Milestone') : 'Milestone/Status']), 
    'Milestone/Status')

'Verify default value of Milestone/Status is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Milestones/Milestone Status', [('MilestoneStatus') : 'N/A']), 
    'N/A')

WebUI.closeBrowser()

