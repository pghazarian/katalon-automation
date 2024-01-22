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

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/p_Events Central'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/inputui-input--events_search'), 'HC Test Private Event')

WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Page_Healthy Church/inputui-input--events_search'), Keys.chord(
        Keys.ENTER))

WebUI.click(findTestObject('HC-Web/Page_Healthy Church/div_EventTItle'))

WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Page_Healthy Church/p_EventTitle'), 0)

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/p_EventTitle'), 'HC Test Private Event')

WebUI.closeBrowser()

