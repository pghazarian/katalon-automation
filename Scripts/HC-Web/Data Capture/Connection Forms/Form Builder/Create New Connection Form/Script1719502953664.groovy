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

def formName = 'QA Automation Test Form ' + UUID.randomUUID()

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/data-capture/connection-forms'], FailureHandling.STOP_ON_FAILURE)

'Click button to create new connection form'
WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/List/Create New Form Button'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Data Capture/Connection Forms/Create Form Drawer/Name Text Field'), 0)

WebUI.setText(findTestObject('HC-Web/Data Capture/Connection Forms/Create Form Drawer/Name Text Field'), formName)

WebUI.sendKeys(findTestObject('HC-Web/Data Capture/Connection Forms/Create Form Drawer/Public Description Text Field'), 
    'Connection Form created by QA Automation Test. Can be deleted.')

CustomKeywords.'TestObjectHelper.setDropDownValue'('connection_forms--connection_form_drawer-campus', Campus)

CustomKeywords.'TestObjectHelper.setDropDownValue'('connection_forms--connection_form_drawer-event_type', 'Regular')

WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Create Form Drawer/Add Contributor Button'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Data Capture/Connection Forms/Create Form Drawer/Add Contributor Drawer/Search Bar'), 
    0)

WebUI.setText(findTestObject('HC-Web/Data Capture/Connection Forms/Create Form Drawer/Add Contributor Drawer/Search Bar'), 
    Contributor + Keys.ENTER)

WebUI.delay(1, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Create Form Drawer/Add Contributor Drawer/Search Result Row', 
        [('searchName') : Contributor]), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Create Form Drawer/Add Contributor Drawer/Add Button'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('HC-Web/Data Capture/Connection Forms/Create Form Drawer/Save Button'), 0)

WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Create Form Drawer/Save Button'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('HC-Web/Data Capture/Connection Forms/Overview/Form Name'), 0)

WebUI.verifyElementText(findTestObject('HC-Web/Data Capture/Connection Forms/Overview/Form Name'), formName)

WebUI.closeBrowser()

