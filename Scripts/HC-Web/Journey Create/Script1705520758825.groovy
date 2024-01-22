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

WebUI.setEncryptedText(findTestObject('Object Repository/HC-Web/Page_Saddleback Identity Server/input_Password'), 'Z8nazMpc16177aX9xH8qZQ==')

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Saddleback Identity Server/button_Sign In'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/p_Journey(beta)'))

not_run: WebUI.setText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/inputjourneys_list_page--page_action_bar_search'), 
    'katalon test')

not_run: WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Page_Healthy Church/inputjourneys_list_page--page_action_bar_search'), 
    Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Create Journey'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/inputjourneys_list_page--template_name'), 'Katalon Test Journey 1')

WebUI.setText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/inputjourneys_list_page--template_public_name'), 
    'Katalon Test Journey 1')

not_run: WebUI.setText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/inputjourneys_list_page--template_subtitle'), 
    'Katalon Test Subtitle')

WebUI.setText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/textarea_Katalon Test Description'), 'Katalon Test Description')

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_ui image image-avatar image-avatar-person'))

WebUI.click(findTestObject('HC-Web/Page_Healthy Church/Journey/CreateEdit/CampusDropDown'))

WebUI.sendKeys(findTestObject('HC-Web/Page_Healthy Church/Journey/CreateEdit/CampusDropDown'), 'Anaheim')

WebUI.sendKeys(findTestObject('HC-Web/Page_Healthy Church/Journey/CreateEdit/CampusDropDown'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Anaheim'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Anaheim'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/svg_Select'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_20s30s'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/use_icon-use-path'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Class'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Continue'))

