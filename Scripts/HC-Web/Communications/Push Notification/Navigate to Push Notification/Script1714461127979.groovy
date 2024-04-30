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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/communications-central/push-notification'], FailureHandling.STOP_ON_FAILURE)

/*
 * Log in as user that does not have permission to "Manage Push Notification"
 * Click on "Communications" in the Navigation pane
 * Verify "Push Notificaiton" sub-menu does not appear under "Communications"
 * Log out
 * Log in as Admin
 * Click on "System > User & Teams"
 * Type the name of the user you want to give the "Manage Push Notification" permission to and hit the Enter key
 * Click on the user
 * Click on the "Edit" button
 * Expand the "Scoped Roles"
 * Select "Manage Push Notification" from the dropdown under "Extra Permissions"
 * Click on the "Save" button
 * Log out
 * Log in as user you just gave the "Manage Push Notification" permission to
 * Click on "Communications" in the Navigation pane
 * Verify "Push Notification" sub-menu appears under "Communications" and click on it
 */
