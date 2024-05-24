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

'Login HC Admin'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '', ('ForceLogin') : false], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/p_Data Capture'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/input_Log Out_connection_forms_list_page--p_046c7d'), 
    'Paren Anaheim')

WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/input_Log Out_connection_forms_list_page--p_046c7d'), 
    Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/div_Paren Anaheim Worship 1'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/span_Follow Ups'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/button_chevron-wl-right'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/div_RN'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/p_test paren'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/p_Task 1'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/div_Notifications'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/span_Daily Batch'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/span_Detailed Follow Up Push Notification'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/div_Important Follow Up Push Notification'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/span_Done'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/span_Save'))

