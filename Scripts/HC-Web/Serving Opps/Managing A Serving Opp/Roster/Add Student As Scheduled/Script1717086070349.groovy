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

if (WebUI.waitForElementVisible(findTestObject('HC-Web/Serving Opps/Roster Page/Member In List', [('memberName') : VolunteerName]), 
    5)) {
    WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/Member In List', [('memberName') : MemberName]))

    WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/Member Drawer/Actions Button'))

    WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/Member Drawer/Remove From Opportunity'))

    WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/Member Drawer/Remove From Opportunity Confirmation Yes Button'))

    WebUI.waitForElementVisible(findTestObject('HC-Web/Shared Component/Activity Indicator'), 10)

    WebUI.waitForElementNotPresent(findTestObject('HC-Web/Shared Component/Activity Indicator'), 10)

    WebUI.verifyElementNotPresent(findTestObject('HC-Web/Serving Opps/Roster Page/Member In List', [('memberName') : MemberName]), 
        10)
}

WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/Add Volunteer Button'))

WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/Add Volunteer As Scheduled Option'))

WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/Add Volunteer Drawer/Person In List Checkbox', [('PersonName') : VolunteerName]))

WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/Add Volunteer Drawer/Add Button'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Serving Opps/Roster Page/Member In List', [('memberName') : MemberName]), 
    10)

WebUI.verifyElementText(findTestObject('HC-Web/Serving Opps/Roster Page/Member In List Scheduled Area', [('memberName') : MemberName]), 
    'Scheduled')

WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/Member In List', [('memberName') : MemberName]))

WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/Member Drawer/Actions Button'))

WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/Member Drawer/Remove From Opportunity'))

WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/Member Drawer/Remove From Opportunity Confirmation Yes Button'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Shared Component/Activity Indicator'), 10)

WebUI.waitForElementNotPresent(findTestObject('HC-Web/Shared Component/Activity Indicator'), 10)

WebUI.verifyElementNotPresent(findTestObject('HC-Web/Serving Opps/Roster Page/Member In List', [('memberName') : MemberName]), 
    10)

WebUI.closeBrowser()

