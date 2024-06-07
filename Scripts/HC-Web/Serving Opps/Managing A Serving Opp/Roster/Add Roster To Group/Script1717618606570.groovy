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

WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/Member Checkbox', [('memberName') : MemberName]))

WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/Actions Button'))

WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/Add To Group Option'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Serving Opps/Roster Page/Apply Action Drawer/Apply Button'), 2)

CustomKeywords.'TestObjectHelper.setDropDownValue'('ui-dropdown--bulk_move_to_member_groups', GroupName)

WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/Apply Action Drawer/Apply Button'))

WebUI.click(findTestObject('HC-Web/Serving Opps/Roster Page/Apply Action Drawer/Apply Confirmation Yes Button'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Serving Opps/Roster Page/Success Banner Text Area'), 5)

WebUI.verifyElementText(findTestObject('HC-Web/Serving Opps/Roster Page/Success Banner Text Area'), 'Successfully added selected volunteers to the selected groups')

WebUI.navigateToUrl(GlobalVariable.HC_HostUrl + "/my-ministry/settings/membership-settings/$MinistryId/$CampusId/")

WebUI.click(findTestObject('HC-Web/Ministry/Settings Page/Group Actions Ellipsis Button', [('groupName') : GroupName]))

WebUI.click(findTestObject('HC-Web/Ministry/Settings Page/Manage Group Option'))

WebUI.click(findTestObject('HC-Web/Ministry/Settings Page/Group Settings Drawer/Member Checkbox', [('memberName') : MemberFirstName]))

WebUI.click(findTestObject('HC-Web/Ministry/Settings Page/Group Settings Drawer/Remove Button'))

WebUI.click(findTestObject('HC-Web/Ministry/Settings Page/Group Settings Drawer/Remove Confirmation Yes Button'))

WebUI.waitForElementNotPresent(findTestObject('HC-Web/Ministry/Settings Page/Group Settings Drawer/Member Checkbox', [('memberName') : MemberName]), 
    10)

WebUI.verifyElementNotPresent(findTestObject('HC-Web/Ministry/Settings Page/Group Settings Drawer/Member Checkbox', [('memberName') : MemberName]), 
    10)

WebUI.closeBrowser()

