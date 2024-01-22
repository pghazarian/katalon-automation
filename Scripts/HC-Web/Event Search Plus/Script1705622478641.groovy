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

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/p_Events Central'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_All Events'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/inputui-input--events_search'), 'Bryant\'s Demo Event')

WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Page_Healthy Church/inputui-input--events_search'), Keys.chord(Keys.ENTER))

WebUI.verifyElementText(findTestObject('HC-Web/Event/Search/SearchResultsFirstRowTitle'), 'Bryant\'s Demo Event')

WebUI.click(findTestObject('HC-Web/Event/Search/SearchResultsFirstRowTitle'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/p_Bryants Demo Event'), 'Bryant\'s Demo Event')

WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Page_Healthy Church/p_This is a demo event for Bryant Stone'), 
    0)

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_This is a demo event for Bryant StoneHo_6b4ac0'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Event Details'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/inputevent_details_basic_info--event_name'), 
    '')

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Occurrence Schedule'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Whitney  Kelmp'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church People - Person Record _91ca73/div_Whitney  Kelmp'), 
    'Whitney Kelmp')

WebUI.click(findTestObject('HC-Web/Page_Healthy Church People - Person Record _91ca73/CloseButton'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Registration Roster'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Bryant  Stone'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church People - Person Record _845e2e/div_Bryant  Stone'), 
    'Bryant Stone')

WebUI.click(findTestObject('HC-Web/Page_Healthy Church People - Person Record _845e2e/CloseButton'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Serving Opps'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/h4_Bryants Demo Serving Opp'))

WebUI.verifyElementText(findTestObject('HC-Web/Event/ServingOpp/BreadCrumb2'), 'Bryant\'s Demo Event')

WebUI.verifyElementText(findTestObject('HC-Web/Event/ServingOpp/BreadCrumb3'), 'Bryant\'s Demo Serving Opp')

'Go back to the Event via the Breadcrumb'
WebUI.click(findTestObject('HC-Web/Event/ServingOpp/BreadCrumb2'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Communications'))

WebUI.closeBrowser()

