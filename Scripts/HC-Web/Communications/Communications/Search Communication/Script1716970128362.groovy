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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/communications-central/communication'], FailureHandling.STOP_ON_FAILURE)

'Type Search term'
WebUI.setText(findTestObject('HC-Web/Communications/Communications/Search Text Field'), SearchTerm)

'Initiate Search'
WebUI.sendKeys(findTestObject('HC-Web/Communications/Communications/Search Text Field'), Keys.chord(Keys.ENTER))

'Verify the Title column is visible'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Communications/Table Column Title'), FailureHandling.STOP_ON_FAILURE)

'Verify the Segment Record column is visible'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Communications/Table Column Segment Record'), FailureHandling.STOP_ON_FAILURE)

'Verify the Created On column is visible'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Communications/Table Column Created On'), FailureHandling.STOP_ON_FAILURE)

'Verify the Modified On column is visible'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Communications/Table Column Modified On'), FailureHandling.STOP_ON_FAILURE)

'Verify the Status column is visible'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Push Notifications/Table Column Status'), FailureHandling.STOP_ON_FAILURE)

'Open the communication record from the search results'
WebUI.click(findTestObject('HC-Web/Communications/Communications/Table Row', [('CommunicationName') : SearchTerm]))

'Verify communication name is visible in the Overview page'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Overview/Communication Name', [('CommunicationName') : SearchTerm]), 
    SearchTerm)

WebUI.closeBrowser()

