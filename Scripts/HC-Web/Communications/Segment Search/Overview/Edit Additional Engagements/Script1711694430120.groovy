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

'Click on the Edit button next to Additional Engagements'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/Additional Engagements Edit Button'))

'Click on Any under In Ministry'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/In Ministry Any Radio Button'))

'Click on Any under In Small Group'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/In Small Group Any Radio Button'))

'Click Member under Member Status'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/Member Status Member Checkbox'))

'Click button to save additional engagements'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/Additional Engagements Save Button'))

'Verify additional engagements updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements Updated Toast'), 
    FailureHandling.OPTIONAL)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements Updated Toast Text'), 
    'Additional Engagements updated successfully', FailureHandling.OPTIONAL)

'Verify the updated In Ministry value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/In Ministry Value'), 
    'N/A')

'Verify the updated In Small Group value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/In Small Group Value'), 
    'N/A')

'Verify the updated Member Status value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/Member Status Value'), 
    'Member')

'Click on the Edit button next to Additional Engagements'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/Additional Engagements Edit Button'))

'Click on Yes under In Ministry'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/In Ministry Yes Radio Button'))

'Click on Yes under In Small Group'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/In Small Group Yes Radio Button'))

'Click Member under Member Status to deselect'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/Member Status Member Checkbox'))

'Click All under Member Status'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/Member Status All Checkbox'))

'Click button to save additional engagements'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/Additional Engagements Save Button'))

'Verify additional engagements updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements Updated Toast'), 
    FailureHandling.OPTIONAL)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements Updated Toast Text'), 
    'Additional Engagements updated successfully', FailureHandling.OPTIONAL)

'Verify the updated In Ministry value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/In Ministry Value'), 
    'Yes')

'Verify the updated In Small Group value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/In Small Group Value'), 
    'Yes')

'Verify the updated Member Status value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/Member Status Value'), 
    'Disengaged Member, Member, Membership Review, Non-Member, Pending')

'Click on the Edit button next to Additional Engagements'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/Additional Engagements Edit Button'))

'Click on No under In Ministry'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/In Ministry No Radio Button'))

'Click on No under In Small Group'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/In Small Group No Radio Button'))

'Click All under Member Status to deselect'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/Member Status All Checkbox'))

'Click Membership Review under Member Status'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/Member Status Membership Review Checkbox'))

'Click button to save additional engagements'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Additional Engagements/Add Additional Engagements/Additional Engagements Save Button'))

'Verify additional engagements updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements Updated Toast'), 
    FailureHandling.OPTIONAL)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements Updated Toast Text'), 
    'Additional Engagements updated successfully', FailureHandling.OPTIONAL)

'Verify the updated In Ministry value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/In Ministry Value'), 
    'No')

'Verify the updated In Small Group value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/In Small Group Value'), 
    'No')

'Verify the updated Member Status value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Additional Engagements/Member Status Value'), 
    'Membership Review')

WebUI.closeBrowser()

