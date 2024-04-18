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

SearchTerm = 'ST Segment Record 1'

'Type Search term'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Search Text Field'), SearchTerm)

'Initiate Search'
WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Search Text Field'), Keys.chord(Keys.ENTER))

'Open the segment record from the search results'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Table Row', [('SegmentName') : SearchTerm]))

'Click button to open export preview'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Export/Export Button'))

if (WebUI.waitForElementPresent(findTestObject('HC-Web/Communications/Segment Search/Overview/Export/Export No Person Found Message'), 
    10) == false) {
    
	'Click button to download record result in CSV format'
    WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Export/CSV Download Button'))

    'Verify file being ready for download notification is displayed'
    WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Ready For Download Snackbar'), 
        FailureHandling.OPTIONAL)

    'Verify the text in the file being ready for download notification'
    WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Ready For Download Snackbar Text'), 
        'Your file is being prepared for download', FailureHandling.OPTIONAL)

    'Verify ready for download toast is displayed'
    WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Ready For Download Toast'), 
        FailureHandling.OPTIONAL)

    'Verify the text in the toast message'
    WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Ready For Download Toast Text'), 
        'Your file is ready for download')

    'Click the link to download'
    WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Export/CSV Download Link'))

    'Click button to open export preview'
    WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Export/Export Button'))

    'Click button to download record result in XLSX format'
    WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Export/XLSX Download Button'))

    'Verify file being ready for download notification is displayed'
    WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Ready For Download Snackbar'), 
        FailureHandling.OPTIONAL)

    'Verify the text in the file being ready for download notification'
    WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Ready For Download Snackbar Text'), 
        'Your file is being prepared for download', FailureHandling.OPTIONAL)

    'Verify ready for download toast is displayed'
    WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Ready For Download Toast'), 
        FailureHandling.OPTIONAL)

    'Verify the text in the toast message'
    WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Ready For Download Toast Text'), 
        'Your file is ready for download')

    'Click the link to download'
    WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Export/XLSX Download Link'))

    WebUI.closeBrowser()
	
} else {
	
    'Click button to close Export Preview modal'
    WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Export/Export Preview Close Button'))

    WebUI.closeBrowser()
}

