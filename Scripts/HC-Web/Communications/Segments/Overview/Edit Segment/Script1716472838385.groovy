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

EditSegmentName = (SearchTerm + ' Edited')

EditSegmentDescription = (SearchTerm + ' Description Edited')

'Type Search term'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segments/Search Text Field'), SearchTerm)

'Initiate Search'
WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Communications/Segments/Search Text Field'), Keys.chord(Keys.ENTER))

'Open the segment record from the search results'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Table Row', [('SegmentName') : SearchTerm]))

'Click button to edit segment info'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Segment Edit Button'))

'Select the text'
WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Edit Segment Info/Edit Segment Name Input Field'), 
    CustomKeywords.'StringHelper.selectAllText'())

'Clear the text'
WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Edit Segment Info/Edit Segment Name Input Field'), 
    Keys.chord(Keys.BACK_SPACE))

'Update segment name'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Edit Segment Info/Edit Segment Name Input Field'), 
    EditSegmentName)

'Select the text'
WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Edit Segment Info/Edit Segment Description Text Area'), 
    CustomKeywords.'StringHelper.selectAllText'())

'Clear the text'
WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Edit Segment Info/Edit Segment Description Text Area'), 
    Keys.chord(Keys.BACK_SPACE))

'Update segment description'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Edit Segment Info/Edit Segment Description Text Area'), 
    EditSegmentDescription)

'Select campus from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'segment_primary_details_edit--church_campus\']/descendant::div[@class=\'Select-control\']', 
    CampusAfterUpdate)

'Click button to save segment info'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Edit Segment Info/Edit Segment Save Button'))

'Verify segment record updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segments/Overview/Segment Record Toast'), FailureHandling.STOP_ON_FAILURE)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Segment Record Updated Toast Text'), 'Segment data updated successfully')

'Verify the updated segment name is visible in the Overview page'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Segment Name', [('SegmentName') : EditSegmentName]), 
    EditSegmentName)

'Verify the updated segment description is visible in the Overview page'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Segment Description', [('SegmentDescription') : EditSegmentDescription]), 
    EditSegmentDescription)

'Verify the updated segment campus is visible in the Overview page'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Segment Campus', [('SegmentCampus') : 'Lake Forest']), 
    CampusAfterUpdate)

'Return to segment search'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Return To Segment Search Button'))

'Clear the search field'
WebUI.sendKeys(findTestObject('HC-Web/Communications/Segments/Search Text Field'), CustomKeywords.'StringHelper.selectAllText'())

WebUI.sendKeys(findTestObject('HC-Web/Communications/Segments/Search Text Field'), Keys.chord(Keys.BACK_SPACE))

'Search for edited segment name'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segments/Search Text Field'), EditSegmentName)

'Initiate Search'
WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Communications/Segments/Search Text Field'), Keys.chord(Keys.ENTER))

'Open the segment record from the search results'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Table Row', [('SegmentName') : EditSegmentName]))

'Click button to edit segment info'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Segment Edit Button'))

'Select the text'
WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Edit Segment Info/Edit Segment Name Input Field'), 
    CustomKeywords.'StringHelper.selectAllText'())

'Clear the text'
WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Edit Segment Info/Edit Segment Name Input Field'), 
    Keys.chord(Keys.BACK_SPACE))

'Reset segment name to original name'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Edit Segment Info/Edit Segment Name Input Field'), 
    SearchTerm)

'Select the text'
WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Edit Segment Info/Edit Segment Description Text Area'), 
    CustomKeywords.'StringHelper.selectAllText'())

'Clear the text'
WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Edit Segment Info/Edit Segment Description Text Area'), 
    Keys.chord(Keys.BACK_SPACE))

'Reset segment description to original description'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Edit Segment Info/Edit Segment Description Text Area'), 
    "$SearchTerm Description")

'Select original campus from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'segment_primary_details_edit--church_campus\']/descendant::div[@class=\'Select-control\']', 
    CampusBeforeUpdate)

'Click button to save segment info'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Overview/Edit Segment Info/Edit Segment Save Button'))

'Verify segment record updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segments/Overview/Segment Record Toast'), FailureHandling.STOP_ON_FAILURE)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Segment Record Updated Toast Text'), 'Segment data updated successfully')

WebUI.closeBrowser()

