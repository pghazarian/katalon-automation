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

WebUI.openBrowser('https://hc-stage.saddleback.com')

WebUI.setText(findTestObject('Object Repository/HC-Web/Page_Saddleback Identity Server/input_Username'), 'crisf@saddleback.com')

WebUI.setEncryptedText(findTestObject('Object Repository/HC-Web/Page_Saddleback Identity Server/input_Password'), 
    'Z8nazMpc16177aX9xH8qZQ==')

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Saddleback Identity Server/button_Sign In'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/p_Ministries Central'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/input_text'), 'accounting')

WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Page_Healthy Church/input_text'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Accounting2Accounting2Accounting2Accounting2'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/h2_Accounting2Accounting2Accounting2Accounting2'), 
    'Accounting2Accounting2Accounting2Accounting2')

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/td_Lake Forest'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/td_Lake Forest'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/h2_Accounting2Accounting2Accounting2Account_8aa1dd'), 
    'Accounting2Accounting2Accounting2Accounting2 / Lake Forest')

WebUI.click(findTestObject('HC-Web/Page_Healthy Church/button_MinistryLocation_ViewDashboard'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/p_Accounting2Accounting2Accounting2Accounting2'), 
    'Accounting2Accounting2Accounting2Accounting2')

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Bella (Bella) Alsop'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church People - Person Record _615a46/div_Bella (Bella) Alsop'), 
    'Bella (Bella) Alsop')

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church People - Person Record _615a46/svg_times'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Interested'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Nikhilesh  Walwatkar'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church People - Person Record _99d737/svg_times'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Serving Opps'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Communications'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/h3_Email Statistics'), 'Email Statistics')

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Settings'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/h2_Description'), 'Description')

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Ministry Settings'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/h2_Status'), 'Status')

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Membership Settings'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/h2_Accepting New Members'), 
    'Accepting New Members')

