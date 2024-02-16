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

'Load the Welcome home page'
WebUI.openBrowser(GlobalVariable.Saddleback_Welcome_URL)

WebUI.click(findTestObject('Saddleback Web/Home/Language/Language Selector'))

WebUI.click(findTestObject('Saddleback Web/Home/Language/Spanish Option'))

WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Actions/span_New to Saddleback'), 'Nuevo en Saddleback?')

WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Actions/span_I want to follow Jesus'), 'Quiero seguir a Jesus.')

WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Actions/span_I want to get baptized'), 'Quiero ser bautizado.')

WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Actions/span_I want to find community'), 'Quiero encontrar una comunidad')

WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Actions/span_I want to start volunteering'), 'Quiero ser voluntario.')

WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Latest Message Heading'), 'ÚLTIMO MENSAJE')

WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Watch Now Button'), 'Watch Now')

WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Nav/Location Header Link'), 'Locations')

WebUI.click(findTestObject('Saddleback Web/Home/Language/Language Selector'))

WebUI.closeBrowser()

