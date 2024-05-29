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

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/communications-central/communication'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Communications/Filters/Filter Icon'))

'Select campus from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueWithClick'('communication--select_campus', 'Anaheim')

'Click on Active under Status'
WebUI.click(findTestObject('HC-Web/Communications/Communications/Filters/Status Radio Button', [('index') : 1]))

'Click button to apply filters'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Communications/Filters/Apply Filters Button'))

'Verify communications are filtered per given filter criteria'
WebUI.verifyElementPresent(findTestObject('HC-Web/Communications/Communications/Filtered Communication'), 0)

'Verify only active communications are displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Table Column Status Value'), 'Active')

'Click button to clear filters'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Communications/Filters/Clear All Button'))

'Select campus from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueWithClick'('communication--select_campus', 'Anaheim')

'Click on Inactive under Status'
WebUI.click(findTestObject('HC-Web/Communications/Communications/Filters/Status Radio Button', [('index') : 2]))

'Click button to apply filters'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Communications/Filters/Apply Filters Button'))

'Verify communications are filtered per given filter criteria'
WebUI.verifyElementPresent(findTestObject('HC-Web/Communications/Communications/Filtered Communication'), 0)

'Verify only inactive communications are displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Table Column Status Value'), 'Inactive')

WebUI.closeBrowser()

