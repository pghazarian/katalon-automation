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

'Go to Data Capture > Connection Forms'
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/p_Data Capture'))

'Click in the Connection Forms Search Field '
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/input_Log Out_connection_forms_list_page--p_046c7d'))

'Type Paren Anaheim Worship 1'
WebUI.setText(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/input_Log Out_connection_forms_list_page--p_046c7d'), 
    'Paren Anaheim Worship 1')

WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/input_Log Out_connection_forms_list_page--p_046c7d'), 
    Keys.chord(Keys.ENTER))

'Select Paren Anaheim Worship 1 Connection Form '
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/td_Paren Anaheim Worship 1_data_grid--table_25920f'))

'Click on Follow Ups tab '
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/span_Follow Ups'))

'Click on the Chevron next to a CTA check box, under the Field Rules section of Follow Ups page \r\n'
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/span_chevron-wl-right'))

'Select RN Rule '
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/div_RN'))

'Select Test Paren Task  '
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/p_Test Paren'))

'Go to Notifictions section of the Rule Builder '
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/div_Notifications'))

'Select Daily Batch '
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/span_Daily Batch'))

'Select Immediate '
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/span_Immediate'))

'Click open the drop down menu, under the Select Notification (Template) section '
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/svg_Select'))

'Select Basic Template'
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/div_Basic Follow Up Push Notification'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/svg_Select'))

'Select Detailed Template'
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/div_Detailed Follow Up Push Notification'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/svg_Select'))

'Select Important Template'
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/div_Important Follow Up Push Notification'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/svg_Select'))

'Select Simple Template'
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/div_Simple Follow Up Push Notification'))

'Click on Done button in Rule Builder drawer '
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/span_Done'))

'Click on Save button of Rule '
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/span_Save'))

