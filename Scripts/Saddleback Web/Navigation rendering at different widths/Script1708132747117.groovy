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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.Dimension as Dimension
import org.openqa.selenium.WebDriver as WebDriver

WebUI.openBrowser(GlobalVariable.Saddleback_Welcome_URL)

def width = 1024

width += 50

'verify the navigation at the 1024 width breakpoint'
WebUI.setViewPortSize(width, 768)

WebUI.waitForPageLoad(10)

WebUI.callTestCase(findTestCase('Saddleback Web/Helper/Validate Nav Menu'), [('null') : null], FailureHandling.STOP_ON_FAILURE)

'verify the navigation at the max width of the screen'
WebUI.maximizeWindow()

WebUI.waitForPageLoad(10)

WebUI.callTestCase(findTestCase('Saddleback Web/Helper/Validate Nav Menu'), [('null') : null], FailureHandling.STOP_ON_FAILURE)

'verify the navigation under the 1024 width breakpoint'
WebUI.setViewPortSize(1023, 768)

WebUI.waitForPageLoad(10)

WebUI.callTestCase(findTestCase('Saddleback Web/Helper/Validate Nav Menu'), [('null') : null], FailureHandling.STOP_ON_FAILURE)

'verify the navigation at the mobile width breakpoint'
WebUI.setViewPortSize(744, 768)

WebUI.waitForPageLoad(10)

WebUI.callTestCase(findTestCase('Saddleback Web/Helper/Validate Nav Menu'), [('null') : null], FailureHandling.STOP_ON_FAILURE)

'verify the navigation at the mobile width breakpoint'
WebUI.setViewPortSize(375, 768)

WebUI.waitForPageLoad(10)

WebUI.callTestCase(findTestCase('Saddleback Web/Helper/Validate Nav Menu'), [('null') : null], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()