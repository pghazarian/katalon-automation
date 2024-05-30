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
		, ('Password') : GlobalVariable.Admin_Password], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'customUtility.NavigationHelper.clickTopMenuAndValidateHeader'('Data Capture', 'Connection Forms')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Data Capture', 'Connection Forms', 'Connection Forms')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Data Capture', 'Connection Cards', 'Connection Cards')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Data Capture', 'Connection Questions', 'Connection Questions')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Data Capture', 'Weekend Metrics Capture', 'Weekend Metrics Capture')

/*
 *  This code is for logging into a web application and performing various navigation actions.
 *
 *  1. The code calls a test case named 'Login' with the parameters 'HostUrl', 'UserName', and 'Password' to log into the application.
 *  2. The code then calls a custom keyword named 'clickTopMenuAndValidateHeader' with the parameters 'Data Capture' and 'Connection Forms' to navigate to a specific page and validate the header.
 *  3. The code continues to call the 'clickSubmenuAndValidateHeader' custom keyword multiple times with different parameters to navigate to different pages and validate the headers.
 *  4. Finally, the code closes the browser.
 *
 */