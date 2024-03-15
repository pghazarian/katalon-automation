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

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.HC_HostUrl)

WebUI.setText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Saddleback Identity Server/input_Email Address_Username'), 
    UserName)

WebUI.setEncryptedText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Saddleback Identity Server/input_Password_Password'), 
    UserPwd)

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Saddleback Identity Server/button_Sign In'))

WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/img_Collapse Menu_navigation--logo-image'), 
    0)

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/img_Collapse Menu_navigation--logo-image'), 
    '')

WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/Avatar Icon'), 
    0)

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/Avatar Icon'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/div_Preview Feature'), 
    'Preview Feature')

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/div_Preview Feature'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/h3_Preview Feature'), 
    'Preview Feature')

WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/span_Preview Feature_button-inner-container jss240'), 
    0)

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/div_Digital Program Management'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/div_Digital Program Management'), 
    'Digital Program Management')

WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/label_OnOffcheck'), 
    0)

not_run: WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/label_OnOffcheck'), 
    'OnOffcheck')

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/span_Preview Feature_button-inner-container jss240'))

WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/p_Mobile Engagement'), 
    0)

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/p_Mobile Engagement'))

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/Avatar Icon'))

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/div_Preview Feature'))

WebUI.click(findTestObject('HC-Web/Mobile Engagement/Digital Program/Digital Program Toggle'))

not_run: WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/label_OnOffcheck'), 
    'OnOffcheck')

not_run: WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/span_On'), 
    'On')

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/span_Preview Feature_button-inner-container jss240_1'))

not_run: WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/div_Digital Programs(beta)'), 
    0)

not_run: WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/div_Digital Programs(beta)'), 
    'Digital Programs(beta)')

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/div_Digital Programs(beta)'))

not_run: WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/h4_Digital Programs'), 
    'Digital Programs')

not_run: WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/span_New Digital Program'), 
    0)

not_run: WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/span_New Digital Program'), 
    'New Digital Program')

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/Avatar Icon'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/div_Preview Feature'))

not_run: WebUI.click(findTestObject('HC-Web/Mobile Engagement/Digital Program/Digital Program Toggle'))

not_run: WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/span_Off'), 
    'Off')

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/span_Preview Feature_button-inner-container jss240_1_2'))

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/Avatar Icon'))

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Healthy Church/div_Log Out'))

WebUI.closeBrowser()

