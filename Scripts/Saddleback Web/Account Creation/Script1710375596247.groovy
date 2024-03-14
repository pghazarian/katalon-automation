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

WebUI.openBrowser('https://dev.saddleback.com/account/userprofile')

not_run: WebUI.navigateToUrl('https://dev.saddleback.com/LoginVerification?returnurl=https%3a%2f%2fdev.saddleback.com%2faccount%2fuserprofile')

not_run: WebUI.openBrowser('')

not_run: WebUI.closeBrowser()

not_run: WebUI.openBrowser('')

not_run: WebUI.navigateToUrl('https://dev.saddleback.com/LoginVerification?returnurl=https%3a%2f%2fdev.saddleback.com%2faccount%2fuserprofile')

WebUI.click(findTestObject('Object Repository/Saddleback Web/Account/Page_Saddleback Church - Login Verification/input_Username'))

WebUI.click(findTestObject('Object Repository/Saddleback Web/Account/Page_Saddleback Church - Login Verification/a_Create Account'))

WebUI.setText(findTestObject('Object Repository/Saddleback Web/Account/Page_Saddleback Identity Server/input_FirstName'), 
    'QA Automation')

WebUI.setText(findTestObject('Object Repository/Saddleback Web/Account/Page_Saddleback Identity Server/input_LastName'), 
    'New User')

WebUI.setText(findTestObject('Object Repository/Saddleback Web/Account/Page_Saddleback Identity Server/input_Email'), 'sbchcqa+hccreate1@gmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Saddleback Web/Account/Page_Saddleback Identity Server/input_Password'), 
    'p4y+y39Ir5O++RH4jAhtiA==')

WebUI.setEncryptedText(findTestObject('Object Repository/Saddleback Web/Account/Page_Saddleback Identity Server/input_ConfirmedPassword'), 
    'p4y+y39Ir5O++RH4jAhtiA==')

WebUI.click(findTestObject('Object Repository/Saddleback Web/Account/Page_Saddleback Identity Server/input_SMSConsent'))

WebUI.click(findTestObject('Object Repository/Saddleback Web/Account/Page_Saddleback Identity Server/button_Next'))

WebUI.navigateToUrl('https://gmail.com')

