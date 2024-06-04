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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/data-capture/connection-forms', ('ForceLogin') : false], 
    FailureHandling.STOP_ON_FAILURE)

'Click in the Connection Forms Search Field '
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/Notifications/Search Field'))

'Type Paren Anaheim Worship 1'
WebUI.setText(findTestObject('Object Repository/HC-Web/Connection Form/Entries/Notifications/Search Field'), 'Paren Anaheim Worship 1')

WebUI.sendKeys(findTestObject('HC-Web/Connection Form/Entries/Notifications/Search Field'), Keys.chord(Keys.ENTER))

'Select Paren Anaheim Worship 1 Connection Form '
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/Notifications/Connection Form row'))

WebUI.click(findTestObject('HC-Web/Connection Form/Entries/Entries Tab Button'))

WebUI.click(findTestObject('HC-Web/Connection Form/Entries/New Entry - button'))

WebUI.delay(1)

WebUI.click(findTestObject('HC-Web/Connection Form/Entries/New Service Worship Entry - Exiting person/input_text'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/New Service Worship Entry - Exiting person/span_3'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/New Service Worship Entry - Exiting person/div__Select-placeholder'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/New Service Worship Entry - Exiting person/div_06032024 500 AM PDT'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/New Service Worship Entry - Exiting person/span_Apply'))

not_run: WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Connection Form/Entries/New Service Worship Entry - Exiting person/input_First Name_person_search_form--firstn_2cb3ba'), 
    Keys.chord(Keys.ENTER))

not_run: WebUI.setText(findTestObject('Object Repository/HC-Web/Connection Form/Entries/New Service Worship Entry - Exiting person/input_First Name_person_search_form--firstn_2cb3ba'), 
    'test')

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/New Service Worship Entry - Exiting person/div_T1 test  123 Female  Single  CentralId 7778092'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/New Service Worship Entry - Exiting person/span_Select'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/New Service Worship Entry - Exiting person/div_Yes'))

not_run: WebUI.setText(findTestObject('Object Repository/HC-Web/Connection Form/Entries/New Service Worship Entry - Exiting person/input__form_entry_editor--question_22944'), 
    'yes')

not_run: WebUI.setText(findTestObject('Object Repository/HC-Web/Connection Form/Entries/New Service Worship Entry - Exiting person/input__form_entry_editor--question_22945'), 
    'YES')

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/New Service Worship Entry - Exiting person/span_CTA Single Check Box'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/New Service Worship Entry - Exiting person/span_Add Entry'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/New Service Worship Entry - Exiting person/span_Im Done'))

