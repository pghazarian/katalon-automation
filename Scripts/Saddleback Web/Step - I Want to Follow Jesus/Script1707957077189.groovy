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

WebUI.click(findTestObject('Saddleback Web/Home/Actions/span_I want to follow Jesus'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Saddleback Web/Follow Jesus Page/h1_FOLLOWING JESUS'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Saddleback Web/Follow Jesus Page/button_Ive Made a Decision to Follow Jesus'), 
    0)

WebUI.click(findTestObject('Object Repository/Saddleback Web/Follow Jesus Page/button_Ive Made a Decision to Follow Jesus'))

// TODO: Perform the actual form completion and submit if it's a lower environment

