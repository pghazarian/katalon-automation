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

'Login HC Admin'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/data-capture/connection-forms', ('ForceLogin') : false], 
    FailureHandling.STOP_ON_FAILURE)

'Click in the Connection Forms Search Field '
WebUI.click(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Notifications/Search Field'))

'Type Paren Anaheim Worship 1'
WebUI.setText(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Notifications/Search Field'), 'Paren Anaheim Worship 1')

WebUI.sendKeys(findTestObject('HC-Web/Data Capture/Connection Forms/Notifications/Search Field'), Keys.chord(Keys.ENTER))

'Select Paren Anaheim Worship 1 Connection Form '
WebUI.click(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Notifications/Connection Form row'))

WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Entries/Entries Tab Button'))

WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Entries/New Entry Button'))

WebUI.delay(1)

WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Entries/Date Icon'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Entries/Add Entry Drawer/3rd of the month'))

CustomKeywords.'FormHelper.setDropDownValue'('Service Time', 'PDT')

WebUI.maximizeWindow()

WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Entries/Add Entry Drawer/Apply Button'))

WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Entries/Connection Form Person Entry Type Modal/Next Button'))

WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Entries/Add Entry Drawer/Person Search First Name Text Entry'))

WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Entries/Add Entry Drawer/Person Search LastName Text Entry'))

