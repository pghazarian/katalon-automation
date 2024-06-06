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

'Set Local Date and Time to the variable'
def randText = String.format('%tF', java.time.LocalDateTime.now())

'Set the Digital Program Title variable with the Date time values in it'
randText = ('Dig Prog ' + randText)

'Login and Navigate to Digital Programs Page'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/content-management/digital-program'], FailureHandling.STOP_ON_FAILURE)

'Verify the Digital Programs Page title is set to Digital Programs'
WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Programs Header Text'), 
    'Digital Programs')

'Click on the Digital Programs list page Search bar'
WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Programs list page Search Bar'))

'Enter search text into the search bar'
WebUI.setText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Programs list page Search Bar'), 
    randText)

'Hit Enter after entering search criteria'
WebUI.sendKeys(findTestObject('HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Programs list page Search Bar'), 
    Keys.chord(Keys.ENTER))

'Pick a Digital Program to Edit its Details'
WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Search Result'))

'Click on Actions dropdown button to populate the Actions underneath'
WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Actions Dropdown Clickable Span'))

'Click on Edit Details button under Actions dropdown in Details page'
WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Details page Edit Details button'))

'Click Upload for All button to upload the Image'
not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Upload for all button'))

'Click Next button on Image Upload for all modal (Web Header)'
not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Image Upload Next button'))

'Click Next button on Image Upload for all modal (Companion App Header)'
not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Image Upload Next button'))

'Click Save button on Image Upload for all modal (Thumbnail)'
not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Image Upload Save Button'))

'Click on Speaker Dropdown'
not_run: WebUI.click(findTestObject('HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Speaker Dropdown button'))

'Select a speaker from the dropdown'
CustomKeywords.'TestObjectHelper.setDPDropDownValueByClick'('digital_programs_add_drawer--speaker', 'Rick Warren')

'Set Speaker(s) as needed'
not_run: WebUI.click(findTestObject('HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Select Speaker'))

'Click on Save button to Save the Updated details onto the Digital Program'
not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Edit Details page Save Button'))

'Getting today\'s date into a variable for comparison '
not_run: def lastUpdate = new Date().format('MM/dd/yyyy')

'Verify Today\'s Date is populated in Last Update field'
not_run: WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Details Last Update Date'), 
    lastUpdate)

WebUI.verifyElementText(findTestObject('HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Details Info', 
        [('Label') : 'Last Update']), lastUpdate)

'Verify Speaker name is updated as what user set'
not_run: WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Select Speaker'), 
    'Andy Wood')

not_run: WebUI.closeBrowser()

