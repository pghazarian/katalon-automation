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
not_run: WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
		, ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/communications-central/communication'], FailureHandling.STOP_ON_FAILURE)

/*
 * Log in as a non-admin user that does not have permission to "Manage Promotional Email Communication Job"
 * Click on "Communications" in the Navigation pane
 * Verify "Communications" sub-menu does not appear under "Communications"
 * Log out
 * Log in as Admin
 * Click on "System > User & Teams"
 * Type the name of the non-admin user you want to give the "Manage Promotional Email Communication Job" permission to and hit the Enter key
 * Click on the user
 * Click on the "Edit" button
 * Expand the "Scoped Roles"
 * Select "Manage Promotional Email Communication Job" from the dropdown under "Extra Permissions"
 * Click on the "Save" button
 * Log out
 * Log in as the non-admin user you gave the "Manage Promotional Email Communication Job" permission to
 * Click on "Communications" in the Navigation pane
 * Verify "Communications" sub-menu appears under "Communications"
 * Click on "Communications"
 * Verify user is navigated to the "Communications" page
 * Log out
 * Log in as Admin
 * Click on "System > User & Teams"
 * Type the name of the non-admin user you gave the "Manage Promotional Email Communication Job" permission to and hit the Enter key
 * Click on the user
 * Click on the "Edit" button
 * Expand the "Scoped Roles"
 * Click on the [ x ] icon next to "Manage Promotional Email Communication Job" to remove it from "Extra Permissions"
 * Click on the "Save" button
 * Log out
 */