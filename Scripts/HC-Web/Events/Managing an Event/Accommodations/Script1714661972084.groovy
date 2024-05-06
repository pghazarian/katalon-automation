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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/events-central/accommodation-settings'], FailureHandling.STOP_ON_FAILURE)

'If accommodation to be added already exists, remove it'
if (WebUI.waitForElementPresent(findTestObject('Object Repository/HC-Web/Event/Settings and Preferences/Accommodations/Added Accommodation', 
        [('AccommodationTitle') : 'QA Automation Test Accommodation']), 5)) {
    WebUI.click(findTestObject('Object Repository/HC-Web/Event/Settings and Preferences/Accommodations/Remove Accommodation Button', [('AccommodationTitle') : 'QA Automation Test Accommodation']), 
        FailureHandling.STOP_ON_FAILURE)
}

'Enter a name for a new accommodation'
WebUI.setText(findTestObject('HC-Web/Event/Settings and Preferences/Accommodations/Add Accommodation Text Field'), 'QA Automation Test Accommodation')

'Click button to add accommodation'
WebUI.click(findTestObject('HC-Web/Event/Settings and Preferences/Accommodations/Add Accommodation Button'), FailureHandling.STOP_ON_FAILURE)

'Verify that the added accommodation appears in the list'
WebUI.waitForElementPresent(findTestObject('HC-Web/Event/Settings and Preferences/Accommodations/Added Accommodation', [
            ('AccommodationTitle') : 'QA Automation Test Accommodation']), 0)

'Enter the same name for the added accommodation'
WebUI.setText(findTestObject('HC-Web/Event/Settings and Preferences/Accommodations/Add Accommodation Text Field'), 'QA Automation Test Accommodation')

'Click the button to add an accommodation that already exists'
WebUI.click(findTestObject('HC-Web/Event/Settings and Preferences/Accommodations/Add Accommodation Button'), FailureHandling.STOP_ON_FAILURE)

'Verify that duplicate accommodations cannot be added'
WebUI.verifyElementText(findTestObject('HC-Web/Event/Settings and Preferences/Accommodations/Accommodation Already Exists Banner'), 
    'Accommodation "QA Automation Test Accommodation" already exists')

'Click button to remove previously added accommodation'
WebUI.click(findTestObject('HC-Web/Event/Settings and Preferences/Accommodations/Remove Accommodation Button', [('AccommodationTitle') : 'QA Automation Test Accommodation']), 
    FailureHandling.STOP_ON_FAILURE)

'Verify that the accommodation was removed from the list'
WebUI.waitForElementNotPresent(findTestObject('HC-Web/Event/Settings and Preferences/Accommodations/Added Accommodation', 
        [('AccommodationTitle') : 'QA Automation Test Accommodation']), 0)

WebUI.closeBrowser()

