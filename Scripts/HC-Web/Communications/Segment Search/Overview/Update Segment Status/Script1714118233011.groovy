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

SearchTerm = 'ST Segment 1'

'Type Search term'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Search Text Field'), SearchTerm)

'Initiate Search'
WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Search Text Field'), Keys.chord(Keys.ENTER))

'Open the segment record from the search results'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Table Row', [('SegmentName') : SearchTerm]))

TargetCampus = WebUI.getText(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Segmen Target Campus Value'), 
    FailureHandling.STOP_ON_FAILURE)

if (TargetCampus != 'N/A') {
    'Click button to edit segment info'
    WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Segment Edit Button'))

    'Click button to select Status'
    WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Edit Segment Info/Edit Segment Status Radio Button', 
            [('Status') : 'Active']))

    'Click button to save segment info'
    WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Edit Segment Info/Edit Segment Save Button'))

    'Verify segment record updated toast is displayed'
    WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Segment Record Toast'), FailureHandling.OPTIONAL)

    'Verify the text in the toast message'
    WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Segment Record Updated Toast Text'), 
        'Segment data updated successfully', FailureHandling.OPTIONAL)

    'Verify the updated status of segment is visible in the Overview page'
    WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Segment Status', [('SegmentStatus') : 'Active']), 
        'Active')

    'Click button to edit segment info'
    WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Segment Edit Button'))

    'Click button to select Status'
    WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Edit Segment Info/Edit Segment Status Radio Button', 
            [('Status') : 'Inactive']))

    'Click button to save segment info'
    WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Edit Segment Info/Edit Segment Save Button'))

    'Verify segment record updated toast is displayed'
    WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Segment Record Toast'), FailureHandling.OPTIONAL)

    'Verify the text in the toast message'
    WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Segment Record Updated Toast Text'), 
        'Segment data updated successfully', FailureHandling.OPTIONAL)
} else {
    'Click on the Edit button next to Demographic Info'
    WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Demographic Info Edit Button'))

    'Scroll to top of the Demographic Info section'
    WebUI.scrollToPosition(0, 0)

    'Select campus from dropdown'
    CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'campus-selector\']/descendant::div[@class=\'Select-control\']', 
        'Anaheim')

    'Click button to save demographic info'
    WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Demographic Info/Add Demographic Info/Demographic Info Save Button'))

    'Verify demographic info updated toast is displayed'
    WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info Updated Toast'), 
        FailureHandling.OPTIONAL)

    'Verify the text in the toast message'
    WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info Updated Toast Text'), 
        'Demographic info updated successfully', FailureHandling.OPTIONAL)

    'Scroll to top of the Demographic Info section'
    WebUI.scrollToPosition(0, 0)

    'Click button to edit segment info'
    WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Segment Edit Button'))

    'Click button to select Status'
    WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Edit Segment Info/Edit Segment Status Radio Button', 
            [('Status') : 'Active']))

    'Click button to save segment info'
    WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Edit Segment Info/Edit Segment Save Button'))

    'Verify segment record updated toast is displayed'
    WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Segment Record Toast'), FailureHandling.OPTIONAL)

    'Verify the text in the toast message'
    WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Segment Record Updated Toast Text'), 
        'Segment data updated successfully', FailureHandling.OPTIONAL)

    'Verify the updated status of segment is visible in the Overview page'
    WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Segment Status', [('SegmentStatus') : 'Active']), 
        'Active')

    'Click button to edit segment info'
    WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Segment Edit Button'))

    'Click button to select Status'
    WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Edit Segment Info/Edit Segment Status Radio Button', 
            [('Status') : 'Inactive']))

    'Click button to save segment info'
    WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Edit Segment Info/Edit Segment Save Button'))

    'Verify segment record updated toast is displayed'
    WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Segment Record Toast'), FailureHandling.OPTIONAL)

    'Verify the text in the toast message'
    WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Segment Record Updated Toast Text'), 
        'Segment data updated successfully', FailureHandling.OPTIONAL)
}

WebUI.closeBrowser()

