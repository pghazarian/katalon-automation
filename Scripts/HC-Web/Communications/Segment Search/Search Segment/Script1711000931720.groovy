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

SearchTerm = 'ST Record 2'

SearchDescription = 'ST Record 2 Description'

'Type Search term'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Search Text Field'), SearchTerm)

'Initiate Search'
WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Search Text Field'), Keys.chord(Keys.ENTER))

'Verify a row contains the expected name'
WebUI.verifyElementPresent(findTestObject('HC-Web/Communications/Segment Search/Table Row', [('SegmentName') : SearchTerm]), 
    0)

'Verify the Name column is visible'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/TableColumn_Name'), FailureHandling.STOP_ON_FAILURE)

'Verify the Campus column is visible'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/TableColumn_Campus'), FailureHandling.STOP_ON_FAILURE)

'Verify the Created On column is visible'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/TableColumn_CreatedOn'), FailureHandling.STOP_ON_FAILURE)

'Verify the Last Modified column is visible'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/TableColumn_LastModified'), FailureHandling.STOP_ON_FAILURE)

'Verify the Email Template column is visible'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/TableColumn_EmailTemplate'), FailureHandling.STOP_ON_FAILURE)

'Open the segment record from the search results'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Table Row', [('SegmentName') : SearchTerm]))

'Verify segment name is visible in the Overview page'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Segment Name', [('SegmentName') : SearchTerm]), 
    SearchTerm)

'Verify segment description is visible in the Overview page'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Segment Description', [('SegmentDescription') : SearchDescription]), 
    SearchDescription)

WebUI.closeBrowser()

