import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.SelectorMethod as SelectorMethod
import com.thoughtworks.selenium.Selenium as Selenium
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import org.openqa.selenium.WebDriver as WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium as WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern as Pattern
import static org.apache.commons.lang3.StringUtils.join
import org.testng.asserts.SoftAssert as SoftAssert
import com.kms.katalon.core.testdata.CSVData as CSVData
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

WebUI.openBrowser('https://hc-stage.saddleback.com')

WebUI.setText(findTestObject('Object Repository/HC-Web/Page_Saddleback Identity Server/input_Username'), 'crisf@saddleback.com')

WebUI.setEncryptedText(findTestObject('Object Repository/HC-Web/Page_Saddleback Identity Server/input_Password'), 
    'Z8nazMpc16177aX9xH8qZQ==')

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Saddleback Identity Server/button_Sign In'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/p_Data Capture'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/inputconnection_forms_list_page--page_actio_b4b303'), 
    'Cris Test Connection Form')

WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Page_Healthy Church/inputconnection_forms_list_page--page_actio_b4b303'), 
    Keys.chord(Keys.ENTER))

not_run: WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Cris Test Connection Form'), 
    'Cris Test Connection Form')

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Cris Test Connection Form'))

not_run: WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Cris Test Connection Form'), 
    'Cris Test Connection Form')

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/button_Follow Ups'))

not_run: WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Cris Test Connection Form'), 
    'Cris Test Connection Form')

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Auto-Reply Email'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Form Builder'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/h3_Form Builder'), 'Form Builder')

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Entries'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/inputconnection_form_entries_list_page--sea_fd95a7'), 
    'Jonah Francisco')

WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Page_Healthy Church/inputconnection_form_entries_list_page--sea_fd95a7'), 
    Keys.chord(Keys.ENTER))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_1'), '1')

