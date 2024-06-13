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
import com.kms.katalon.core.configuration.RunConfiguration

def profile = RunConfiguration.getExecutionProfile()

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : "/my-ministry/serving-opportunity/$ServingOppId/$CampusId/roster"], 
    FailureHandling.STOP_ON_FAILURE)

'Select all members to receive email'
WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/All Members Checkbox'))

'Click button to send an email to selected members'
WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/Send Email Button'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Serving Opps/Roster Page/New Email Drawer/Subject Text Field'), 2)

'Enter an email subject'
WebUI.setText(findTestObject('HC-Web/Serving Opps/Roster Page/New Email Drawer/Subject Text Field'), 'QA Automation Test Email')

'Enter an email message'
WebUI.setText(findTestObject('HC-Web/Serving Opps/Roster Page/New Email Drawer/Main Body Text Field'), "Email created by QA Automation test Serving Opps/Communications/Schedule Email Notification from $profile")

'Click button to send email'
WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/New Email Drawer/Send Button'))

'Confirm sending email'
WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/New Email Drawer/Send Email Confirmation Yes Button'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Serving Opps/Roster Page/Email Sent Banner'), 5)

'Verify banner is displayed stating email was scheduled for delivery'
WebUI.verifyElementVisible(findTestObject('HC-Web/Serving Opps/Roster Page/Email Sent Banner'), FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

