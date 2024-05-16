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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : "/my-ministry/serving-opportunity/$ServingOppId/10/schedule/"], 
    FailureHandling.STOP_ON_FAILURE)

'Click button to add volunteer to SO'
WebUI.click(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Button'))

'Add to this occurrence only'
WebUI.click(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/To This Occurrence Option'))

'Go to ministry members tab to add volunteer'
WebUI.click(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Ministry Members Tab'))

'Select volunteer to be added'
WebUI.click(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Volunteer Checkbox', [('volunteerName') : MemberName]))

'Click button to add selected volunteer'
WebUI.click(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Add Volunteer Drawer/Add Volunteer Button'))

'Verify volunteer was added to serving schedule'
WebUI.waitForElementVisible(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Volunteer In List', [('volunteerName') : MemberName]), 
    0)

'Select added volunteer'
WebUI.click(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Volunteer Checkbox', [('volunteerName') : MemberName]))

'Open actions menu'
WebUI.click(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Actions Button'))

'Select option to remove volunteer from this occurrence'
WebUI.click(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Remove From This Ocurrence Option'))

'Confirm removal from serving schedule'
WebUI.click(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Remove From Occurrence Prompt Yes Button'))

'Verify volunteer removed from serving schedule'
WebUI.waitForElementNotVisible(findTestObject('HC-Web/Serving Opps/Serving Schedule Page/Volunteer In List'), 0)

'Navigate to roster'
WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Tab'))

'Click on added volunteer to open member drawer'
WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/Member In List', [('memberName') : MemberName]))

'Open actions menu'
WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/Member Drawer/Actions Button'))

'Select option to remove member from roster'
WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/Member Drawer/Remove From Opportunity'))

'Confirm removal from roster'
WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/Member Drawer/Remove From Opportunity Confirmation Yes Button'))

'Verify member removed from roster'
WebUI.waitForElementNotVisible(findTestObject('HC-Web/Serving Opps/Roster Page/Member In List', [('memberName') : MemberName]), 
    0)

WebUI.closeBrowser()

