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

randText = ('Dig Prog ' + randText)

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/content-management/digital-program'], FailureHandling.STOP_ON_FAILURE)

'Open Browser'
not_run: WebUI.openBrowser('')

not_run: WebUI.navigateToUrl(GlobalVariable.HC_HostUrl)

'Login'
not_run: WebUI.setText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Saddleback Identity Server/input_Email Address_Username'), 
    UserName)

not_run: WebUI.setEncryptedText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Saddleback Identity Server/input_Password_Password'), 
    UserPwd)

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Page_Saddleback Identity Server/button_Sign In'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/p_Mobile Engagement'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/div_Digital Programs(beta)'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Programs Header Text'), 
    'Digital Programs')

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/New Digital Program Button'), 
    'New Digital Program')

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/New Digital Program Button'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Create New Program Header Text'), 
    'Create New Program')

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Program Details sub Header Text'), 
    'Program Details')

WebUI.setText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Title Input'), 
    randText)

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Save New Digital Program Button'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Created Successful Message'), 
    'Successful')

WebUI.verifyElementText(findTestObject('HC-Web/Mobile Engagement/Digital Program/Create Digital Program/DIgital Program Title in Builder'), 
    randText)

WebUI.verifyElementText(findTestObject('HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program TItle in Top NAV'), 
    randText)

WebUI.verifyElementPresent(findTestObject('HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Builder Template dropdown'), 
    0)

WebUI.verifyElementPresent(findTestObject('HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Builder Header Text'), 
    0)

WebUI.verifyElementPresent(findTestObject('HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Builder Add a Button Header Text'), 
    0)

WebUI.verifyElementPresent(findTestObject('HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Edit Details Button'), 
    0)

