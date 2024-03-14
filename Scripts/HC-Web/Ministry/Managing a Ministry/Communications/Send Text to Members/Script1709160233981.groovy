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
import com.kms.katalon.core.configuration.RunConfiguration
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : "/my-ministry/volunteers/members/$MinistryId/$CampusId"], 
    FailureHandling.STOP_ON_FAILURE)

def Environment = RunConfiguration.getExecutionProfile()

CustomKeywords.'customUtility.TestCaseHelper.isCurrentTestCaseEnvironmentValid'()

'Select all members to send a text to'
WebUI.click(findTestObject('HC-Web/Ministry/Members/Select All Members Checkbox'))

'Click button to open text drawer'
WebUI.click(findTestObject('HC-Web/Ministry/Members/Send Text Button'))

'Enter a message into the body of the text'
WebUI.setText(findTestObject('HC-Web/Ministry/Members/Message to Members Drawer/SMS Message Text Field'), "QA Automation Test Text Sent By $Environment")

'Send text'
WebUI.click(findTestObject('HC-Web/Ministry/Members/Message to Members Drawer/Send Message Button'))

'Click button to confirm sending text'
WebUI.click(findTestObject('HC-Web/Ministry/Members/Message to Members Drawer/Send Text Confirmation Yes Button'))

'Verify banner appears stating that the email sent successfully'
WebUI.verifyElementPresent(findTestObject('HC-Web/Ministry/Members/Message to Members Drawer/SMS Sent Success Banner'), 
    5)

WebUI.closeBrowser()

