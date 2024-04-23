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

WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '', ('ForceLogin') : false], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Ministry App/HC-Web/DC - Connection Form/Page_Healthy Church/p_Data Capture'))

WebUI.setText(findTestObject('Object Repository/Ministry App/HC-Web/DC - Connection Form/Page_Healthy Church/input_Log Out_connection_forms_list_page--p_046c7d'), 
    'Paren')

WebUI.sendKeys(findTestObject('Object Repository/Ministry App/HC-Web/DC - Connection Form/Page_Healthy Church/input_Log Out_connection_forms_list_page--p_046c7d'), 
    Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/Ministry App/HC-Web/DC - Connection Form/Page_Healthy Church/div_Paren Anaheim Worship 1'))

WebUI.click(findTestObject('Object Repository/Ministry App/HC-Web/DC - Connection Form/Page_Healthy Church/span_Follow Ups'))

WebUI.click(findTestObject('Object Repository/Ministry App/HC-Web/DC - Connection Form/Page_Healthy Church/span_Template Rules_button-inner-container jss246'))

WebUI.click(findTestObject('Object Repository/Ministry App/HC-Web/DC - Connection Form/Page_Healthy Church/span_New Rule'))

