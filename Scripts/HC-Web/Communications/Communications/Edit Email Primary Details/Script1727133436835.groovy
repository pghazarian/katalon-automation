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

WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Communications/Email/Communication Record'))

WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Communications/Edit Primary Details/Edit Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Communications/Edit Primary Details/Communication Name'))

WebUI.setText(findTestObject('HC-Web/Communications/Communications/Edit Primary Details/Communication Name'), 'Testing 1')

WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Communications/Edit Primary Details/Description'), 
    'Testing 1 Description ')

WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Communications/Edit Primary Details/Inactive'))

WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Communications/Edit Primary Details/Save'))

WebUI.closeBrowser()

