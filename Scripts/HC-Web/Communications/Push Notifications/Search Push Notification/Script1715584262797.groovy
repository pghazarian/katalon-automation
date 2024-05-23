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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/communications-central/push-notification'], FailureHandling.STOP_ON_FAILURE)

SearchTerm = 'ST Push Notification'

SearchDescription = "$SearchTerm Description"

'Type Search term'
WebUI.setText(findTestObject('HC-Web/Communications/Push Notifications/Search Text Field'), SearchTerm)

'Initiate Search'
WebUI.sendKeys(findTestObject('HC-Web/Communications/Push Notifications/Search Text Field'), Keys.chord(Keys.ENTER))

'Verify the Notification column is visible'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Push Notifications/Table Column Notification'), FailureHandling.STOP_ON_FAILURE)

'Verify the Created By column is visible'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Push Notifications/Table Column Created By'), FailureHandling.STOP_ON_FAILURE)

'Verify the Recipients column is visible'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Push Notifications/Table Column Recipients'), FailureHandling.STOP_ON_FAILURE)

'Verify the Send Date column is visible'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Push Notifications/Table Column Send Date'), FailureHandling.STOP_ON_FAILURE)

'Verify the Status column is visible'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Push Notifications/Table Column Status'), FailureHandling.STOP_ON_FAILURE)

'Verify the Application column is visible'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Push Notifications/Table Column Application'), FailureHandling.STOP_ON_FAILURE)

'Open the segment record from the search results'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Table Row', [('PushNotificationName') : SearchTerm]))

WebUI.closeBrowser()

