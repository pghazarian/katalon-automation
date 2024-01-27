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

WebUI.navigateToUrl('https://hc-stage.saddleback.com/public/connection-form/72/cris-test-connection-form')

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form Public/Page_Healthy Church/label_1check'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form Public/Page_Healthy Church/label_2check'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form Public/Page_Healthy Church/svg_check'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form Public/Page_Healthy Church/label_4check'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form Public/Page_Healthy Church/label_1'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form Public/Page_Healthy Church/label_2'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form Public/Page_Healthy Church/label_3'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form Public/Page_Healthy Church/label_4'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form Public/Page_Healthy Church/div_Pick one'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form Public/Page_Healthy Church/div_1'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form Public/Page_Healthy Church/div_1'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form Public/Page_Healthy Church/div_2'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form Public/Page_Healthy Church/div_2'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form Public/Page_Healthy Church/div_3'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form Public/Page_Healthy Church/div_3'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Connection Form Public/Page_Healthy Church/input'), '4')

WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Connection Form Public/Page_Healthy Church/input'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form Public/Page_Healthy Church/div_3'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Connection Form Public/Page_Healthy Church/input'), '4 ')

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form Public/Page_Healthy Church/div_4'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Connection Form Public/Page_Healthy Church/input_text'), '01/28/2024')

