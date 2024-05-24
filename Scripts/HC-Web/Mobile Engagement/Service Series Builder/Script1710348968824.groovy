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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/content-management/service-series-builder'], 
    FailureHandling.STOP_ON_FAILURE)

ServiceSeriesName = ('QA Automation Service Series ' + UUID.randomUUID())

WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Series Builder/New Service Series Button'))

WebUI.setText(findTestObject('HC-Web/Mobile Engagement/Service Series Builder/Name Text Field'), ServiceSeriesName)

WebUI.setText(findTestObject('HC-Web/Mobile Engagement/Service Series Builder/Description Text Field'), 'Service Series created by QA Automation')

WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Series Builder/Save Button'))

WebUI.setText(findTestObject('HC-Web/Mobile Engagement/Service Companion/Search Bar'), ServiceSeriesName + Keys.ENTER)

WebUI.verifyTextPresent(ServiceSeriesName, false)

WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Series Builder/Search Result Row'))

WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Series Builder/Inactive Radio Option'))

WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Series Builder/Save Button'))

WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Series Builder/Deactivate Confirmation Yes Button'))

WebUI.verifyElementText(findTestObject('HC-Web/Mobile Engagement/Service Series Builder/Search Result Active Field'), 'False')

WebUI.closeBrowser()

