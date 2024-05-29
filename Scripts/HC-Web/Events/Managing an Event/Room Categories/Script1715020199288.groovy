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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/events-central/room-settings'], FailureHandling.STOP_ON_FAILURE)

'If category to be added already exists, remove it'
if (WebUI.waitForElementPresent(findTestObject('HC-Web/Event/Settings and Preferences/Room Categories/Added Category', 
        [('CategoryTitle') : 'QA Automation Test Category']), 5)) {
    WebUI.click(findTestObject('HC-Web/Event/Settings and Preferences/Room Categories/Remove Category Button', [('CategoryTitle') : 'QA Automation Test Category']), 
        FailureHandling.STOP_ON_FAILURE)
}

'Enter a name for a new category'
WebUI.setText(findTestObject('HC-Web/Event/Settings and Preferences/Room Categories/Add Category Text Field'), 'QA Automation Test Category')

'Click button to add category'
WebUI.click(findTestObject('HC-Web/Event/Settings and Preferences/Room Categories/Add Category Button'), FailureHandling.STOP_ON_FAILURE)

'Verify that the added category appears in the list'
WebUI.waitForElementPresent(findTestObject('HC-Web/Event/Settings and Preferences/Room Categories/Added Category', [('CategoryTitle') : 'QA Automation Test Category']), 
    0)

'Enter the same name for the added category'
WebUI.setText(findTestObject('HC-Web/Event/Settings and Preferences/Room Categories/Add Category Text Field'), 'QA Automation Test Category')

'Click button to add category'
WebUI.click(findTestObject('HC-Web/Event/Settings and Preferences/Room Categories/Add Category Button'), FailureHandling.STOP_ON_FAILURE)

'Verify that duplicate categories cannot be added'
WebUI.verifyElementText(findTestObject('HC-Web/Event/Settings and Preferences/Room Categories/Category Already Exists Banner'), 
    'Room Category "QA Automation Test Category" already exists')

'Click button to remove previously added category'
WebUI.click(findTestObject('HC-Web/Event/Settings and Preferences/Room Categories/Remove Category Button', [('CategoryTitle') : 'QA Automation Test Category']), 
    FailureHandling.STOP_ON_FAILURE)

'Verify that the category was removed from the list'
WebUI.waitForElementNotPresent(findTestObject('HC-Web/Event/Settings and Preferences/Room Categories/Added Category', [('CategoryTitle') : 'QA Automation Test Category']), 
    0)

WebUI.closeBrowser()

