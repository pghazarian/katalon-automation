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

def randText = String.format('%tF %<tH:%<tM', java.time.LocalDateTime.now())
randText="Dig Prog "+ randText;

'Open Browser'
WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.HC_HostUrl)

'Login'
WebUI.setText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Saddleback Identity Server/input_Email Address_Username'), 
    UserName)

WebUI.setEncryptedText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Saddleback Identity Server/input_Password_Password'), 
    UserPwd)

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Saddleback Identity Server/button_Sign In'))

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/p_Mobile Engagement'))

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/div_Digital Programs(beta)'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/h4_Digital Programs'), 
    'Digital Programs')

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/span_New Digital Program'), 
    'New Digital Program')

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/span_New Digital Program'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/h2_Create New Program'), 
    'Create New Program')

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/h3_Program Details'), 
    'Program Details')

WebUI.setText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/input__digital_programs_add_drawer--title'), 
    randText)

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/span_Save'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/div_Successful'), 
    'Successful')

