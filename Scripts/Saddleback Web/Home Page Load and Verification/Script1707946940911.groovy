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
import graphql.Assert as Assert
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Load the Welcome home page'
WebUI.openBrowser(GlobalVariable.Saddleback_Welcome_URL)

'Wait for the Saddleback Logo to be rendered before we verify page content'
WebUI.waitForElementPresent(findTestObject('Saddleback Web/Home/Saddleback Logo image'), 0)

'Take screenshot of the browser to see what the page looks like'
WebUI.takeScreenshotAsCheckpoint('Saddleback-Welcome-HomePage')

'Verify the Saddleback Logo is present'
WebUI.verifyElementPresent(findTestObject('Saddleback Web/Home/Saddleback Logo image'), 0)

'Verify the Navigation rendering'
WebUI.callTestCase(findTestCase('Saddleback Web/Helper/Validate Nav Menu'), [null:null], FailureHandling.STOP_ON_FAILURE)

'Verify the text for Actions links'
WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Actions/span_New to Saddleback'), 'New to Saddleback?')

WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Actions/span_I want to follow Jesus'), 'I want to follow Jesus.')

WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Actions/span_I want to get baptized'), 'I want to get baptized.')

WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Actions/span_I want to find community'), 'I want to find community.')

WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Actions/span_I want to start volunteering'), 
    'I want to start volunteering.')

'Verify the Watch Now button is present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Saddleback Web/Home/Watch Now Button'), 0)

'Verify the text for Watch Now button'
WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Watch Now Button'), 'Watch Now')

'Verify the text for Latest Message heading is present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Saddleback Web/Home/Latest Message Heading'), 0)

'Verify the text for Latest Message is present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Saddleback Web/Home/Latest Message Title'), 0)

'Verify the text for Latest Message is not blank'
def messageTitle = WebUI.findWebElement(findTestObject('Object Repository/Saddleback Web/Home/Latest Message Title'), 0)

WebUI.verifyNotEqual(messageTitle.text, '')

//WebUI.verifyEqual(messageTitle.text, "Anchored in Peace")
//TO DO: Verify the footer elements
WebUI.closeBrowser()

