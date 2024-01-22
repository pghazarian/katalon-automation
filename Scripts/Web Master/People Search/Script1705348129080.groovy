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

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/p_People'))

not_run: WebUI.setText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/inputperson_search--action_bar--search_input'), 
    'Mark Hamilton')

not_run: WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Page_Healthy Church/inputperson_search--action_bar--search_input'), 
    Keys.chord(Keys.ENTER))

not_run: WebUI.delay(2)

WebUI.clearText(findTestObject('HC-Web/Page_Healthy Church/inputperson_search--action_bar--search_input'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/inputperson_search--action_bar--search_input'), 
    'email:markh@saddleback.com')

WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Page_Healthy Church/inputperson_search--action_bar--search_input'), 
    Keys.chord(Keys.ENTER))

WebUI.verifyElementPresent(findTestObject('HC-Web/Page_Healthy Church/div_Mark  Hamilton'), 0)

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Mark  Hamilton'), 'Mark Hamilton')

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/div_Mark  Hamilton'))

WebUI.closeBrowser()

