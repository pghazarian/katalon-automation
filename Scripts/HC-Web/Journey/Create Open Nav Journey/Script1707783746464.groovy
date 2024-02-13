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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://identity-dev.saddleback.com/account/login?returnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3Dcm%26redirect_uri%3Dhttps%253A%252F%252Fhc-stage.saddleback.com%252F%26response_type%3Did_token%2520token%26scope%3Dopenid%2520profile%2520cm-api.default%2520mysb-api.default%2520vision-2.access-token%2520facebook.access-token%26state%3D4bf358e1d50a42fabe91eb5c601e8f0b%26nonce%3D8f2fd5fccccf4012a57055f89066772d')

WebUI.closeBrowser()

WebUI.openBrowser('')

WebUI.navigateToUrl('https://identity-dev.saddleback.com/account/login?returnUrl=%2Fconnect%2Fauthorize%2Fcallback%3Fclient_id%3Dcm%26redirect_uri%3Dhttps%253A%252F%252Fhc-stage.saddleback.com%252F%26response_type%3Did_token%2520token%26scope%3Dopenid%2520profile%2520cm-api.default%2520mysb-api.default%2520vision-2.access-token%2520facebook.access-token%26state%3Dd3e216bfc3854ff3b89b961ec229d778%26nonce%3D27b30be3d2464da382dc7ffa1030b7a2')

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/AllJourneysPage/Page_Saddleback Identity Server/input_Username'), 
    'markh@saddleback.com')

WebUI.setEncryptedText(findTestObject('Object Repository/HC-Web/Journey/AllJourneysPage/Page_Saddleback Identity Server/input_Password'), 
    'T62yYySZkYyh6V728arnFg==')

WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Journey/AllJourneysPage/Page_Saddleback Identity Server/input_Password'), 
    Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/AllJourneysPage/Page_Healthy Church/p_Journey(beta)'))

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/AllJourneysPage/Page_Healthy Church/span_Create Journey'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/AllJourneysPage/Page_Healthy Church/inputjourneys_list_page--template_name'), 
    'QA Automation Test Open Navigation 3')

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/AllJourneysPage/Page_Healthy Church/section_templateWeb HeaderimageUploadphone-_5caeb1'))

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/AllJourneysPage/Page_Healthy Church/div_Open Navigation Journey'))

