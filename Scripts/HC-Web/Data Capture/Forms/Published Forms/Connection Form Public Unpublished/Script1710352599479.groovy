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

WebUI.callTestCase(findTestCase('HC-Web/Shared/Validate Safe Environment'), [(null) : null], FailureHandling.STOP_ON_FAILURE)

def FormPath = GlobalVariable.HC_HostUrl + GlobalVariable.ConnectionForm_PublicFormPath

WebUI.openBrowser(FormPath)

WebUI.verifyElementText(findTestObject('HC-Web/Connection Form Public/FormClosed_Title'), 'Form Closed')

DescriptionObject = CustomKeywords.'TestObjectHelper.getTestObjectWithXpath'("//div[text() = 'This form has been closed and is no longer accepting submissions. If you think it has been closed in error, please contact the form’s owner.']")

WebUI.verifyElementPresent(DescriptionObject, 0)

WebUI.closeBrowser()

