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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : "/my-ministry/serving-opportunity/$ServingOppId/$CampusId/roster"], 
    FailureHandling.STOP_ON_FAILURE)

'Select all members on the roster to receive text'
WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/All Members Checkbox'))

'Click button to send a text to all selected members'
WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/Send SMS Button'))

'Enter a text message'
WebUI.setText(findTestObject('HC-Web/Serving Opps/Roster Page/New SMS Drawer/SMS Text Area'), TextMessage)

'Click button to send text'
WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/New SMS Drawer/Send Button'))

'Confirm selection'
WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/New SMS Drawer/Send Text Confirmation Yes Button'))

'Verify banner appears saying text has been sent'
WebUI.verifyElementText(findTestObject('HC-Web/Serving Opps/Roster Page/SMS Sent Banner'), 'Text Message has been scheduled for delivery')

WebUI.closeBrowser()

