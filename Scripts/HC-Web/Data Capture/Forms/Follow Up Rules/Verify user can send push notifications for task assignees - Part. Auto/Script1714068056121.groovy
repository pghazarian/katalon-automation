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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '', ('ForceLogin') : false], FailureHandling.STOP_ON_FAILURE)

'Navigate to Data Capture - Connection Forms'
WebUI.click(findTestObject('Ministry App/HC-Web/Data Capture/Data Capture - Connection Forms'))

'Enter "Paren Anaheim Worship 1" in Search field '
WebUI.setText(findTestObject('Ministry App/HC-Web/Data Capture/Search field'), 'Paren Anaheim Worship 1')

'Hit the Enter Key on Keyboard '
WebUI.sendKeys(findTestObject('Ministry App/HC-Web/Data Capture/Search field'), Keys.chord(Keys.ENTER))

'Click to open "Paren Anaheim Worship 1" Connection Form '
WebUI.click(findTestObject('Object Repository/Ministry App/HC-Web/Data Capture/Paren Anaheim Worship 1'))

'Navigate to Follow Up tab \r\n\t\t\t\t'
WebUI.click(findTestObject('Object Repository/Ministry App/HC-Web/Data Capture/Follow Ups tab'))

'To open "Follow Up Rules" drawer'
WebUI.click(findTestObject('Object Repository/Ministry App/HC-Web/Data Capture/Template Rules chevron button'))

'To open "PAW1" follow up rule '
WebUI.click(findTestObject('Object Repository/Ministry App/HC-Web/Data Capture/PAW1 Rule'))

'To navigate to "PAW1" task\'s Rule Builder section'
WebUI.click(findTestObject('Object Repository/Ministry App/HC-Web/Data Capture/PAW1 Task'))

