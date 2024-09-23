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

WebUI.navigateToUrl('https://HC-Dev.Saddleback.com')

WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Communications/Email/input_Email Address_Username'), 
    'Pareng@saddleback.com')

WebUI.setEncryptedText(findTestObject('Object Repository/HC-Web/Communications/Communications/Email/input_Password_Password'), 
    'bGzvpoZCcaztWWDnaA3/tA==')

WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Communications/Email/button_Sign In'))

WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Communications/Email/p_Communications(beta)'))

WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Communications/Email/div_Communications'))

WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Communications/Email/h4_Triston Test Template 2'))

WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Communications/Email/span_Edit'))

WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Communications/Email/span_Cancel'))

WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Communications/Email/span_Send'))

WebUI.closeBrowser()

