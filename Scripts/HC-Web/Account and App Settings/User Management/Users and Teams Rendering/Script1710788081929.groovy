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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/system/users'], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('HC-Web/System/Users and Teams/Search Bar'), SearchUser + Keys.ENTER)

WebUI.click(findTestObject('HC-Web/System/Users and Teams/Search Result Rows'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('HC-Web/System/Users and Teams/Audit Log Button'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('HC-Web/System/Users and Teams/Edit Button'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('HC-Web/System/Users and Teams/Back Button'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('HC-Web/System/Users and Teams/Scoped Roles'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HC-Web/System/Users and Teams/Scoped Roles'))

WebUI.verifyTextPresent('Roles', false)

WebUI.verifyTextPresent('Scope of Role(s)', false)

WebUI.verifyTextPresent('Ministries', false)

WebUI.verifyTextPresent(SearchUser, false)

WebUI.click(findTestObject('HC-Web/System/Users and Teams/Teams Tab'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'("//div[@class='church-line' and text()='$Campus']"))

WebUI.verifyElementVisible(findTestObject('HC-Web/System/Users and Teams/New Team Button'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('HC-Web/System/Users and Teams/Manage Team Buttons'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('HC-Web/System/Users and Teams/Team Rows'), FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

