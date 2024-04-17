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

def StartDate = new Date().minus(365).format('MMddyyyy')

def EndDate = new Date().format('MMddyyyy')

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/system/connection-form-export'], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'TestObjectHelper.setDropDownValue'('connection_forms_data_export_parameters--campus_select', Campus)

CustomKeywords.'TestObjectHelper.setDropDownValue'('connection_forms_data_export_parameters--form_template_select', Campus)

WebUI.setText(findTestObject('HC-Web/System/Migration Settings/Export Forms/Start Date Text Field'), StartDate)

WebUI.setText(findTestObject('HC-Web/System/Migration Settings/Export Forms/End Date Text Field'), EndDate)

WebUI.click(findTestObject('HC-Web/System/Migration Settings/Export Forms/Export Data Button'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('HC-Web/System/Migration Settings/Export Forms/Export Data Rows'))

WebUI.click(findTestObject('HC-Web/System/Migration Settings/Export Forms/CSV Button'))

WebUI.click(findTestObject('HC-Web/System/Migration Settings/Download Link'))

CustomKeywords.'FormHelper.isFileDownloaded'(DownloadPath, 'ConnectionFormDataExtract')

WebUI.closeBrowser()

