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

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/Notitifcations/1 None - radio button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/Notitifcations/Expand_Important Follow Up Push Notification'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/Notitifcations/Expand_Simple Follow Up Push Notification'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/Notitifcations/label_None'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/Notitifcations/Cancel - button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/Notitifcations/No - button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/Notitifcations/Yes - button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/Notitifcations/Close - button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/Notitifcations/Entries tab'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture/Notitifcations/New Entry - button'))

