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

def originalName = 'QA Automation Connection Form for Editing'

def editedName = "$originalName - Edited"

def originalDescription = 'Connection Form to be edited by QA Automation test. Do not delete.'

def editedDescription = "$originalDescription - Edited"

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : "/data-capture/connection-forms/$FormId/overview"], 
    FailureHandling.STOP_ON_FAILURE)

'Click button to open actions menu'
WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Overview/Actions Button'))

'Click button to open edit details drawer'
WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Overview/Edit Details Option'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Data Capture/Connection Forms/Create Form Drawer/Name Text Field'), 0)

'Edit form name'
WebUI.setText(findTestObject('HC-Web/Data Capture/Connection Forms/Create Form Drawer/Name Text Field'), (Keys.chord(Keys.CONTROL + 
        'a') + Keys.BACK_SPACE) + editedName)

'Edit form public name'
WebUI.setText(findTestObject('HC-Web/Data Capture/Connection Forms/Create Form Drawer/Public Name Text Field'), (Keys.chord(
        Keys.CONTROL + 'a') + Keys.BACK_SPACE) + editedName)

'Edit form description'
WebUI.sendKeys(findTestObject('HC-Web/Data Capture/Connection Forms/Create Form Drawer/Public Description Text Field'), 
    (Keys.chord(Keys.CONTROL + 'a') + Keys.BACK_SPACE) + editedDescription)

'If save button is disabled, then the form already had the edited names and description at the beginning of the test. In this case, cancel initial edits. Otherwise save edits.'
if (WebUI.waitForElementPresent(findTestObject('HC-Web/Data Capture/Connection Forms/Create Form Drawer/Save Button'), 1)) {
    'Save edits'
    WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Create Form Drawer/Save Button'))

    'Wait for success banner to appear and disappear'
    WebUI.waitForElementPresent(findTestObject('HC-Web/Data Capture/Connection Forms/Overview/Save Form Success Banner Message'), 
        0)

    WebUI.waitForElementNotPresent(findTestObject('HC-Web/Data Capture/Connection Forms/Overview/Save Form Success Banner Message'), 
        0)
} else {
    'Cancel edits'
    WebUI.click(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Create Form Drawer/Cancel Button'))
}

'Verify edited name'
WebUI.verifyElementText(findTestObject('HC-Web/Data Capture/Connection Forms/Overview/Form Name'), editedName)

'Get link to fill out form'
def link = WebUI.getAttribute(findTestObject('HC-Web/Data Capture/Connection Forms/Overview/View Page Link'), 'href')

'Navigate to page to fill out form'
WebUI.navigateToUrl(link)

WebUI.waitForElementVisible(findTestObject('HC-Web/Data Capture/Connection Forms/New Entry Page/Description Text Area'), 
    0)

'Verify edited description'
WebUI.verifyElementText(findTestObject('HC-Web/Data Capture/Connection Forms/New Entry Page/Description Text Area'), editedDescription)

'Verify edited public name'
WebUI.verifyElementText(findTestObject('HC-Web/Data Capture/Connection Forms/New Entry Page/Public Name Text Area'), editedName)

'Navigate back to form overview page'
WebUI.navigateToUrl("$GlobalVariable.HC_HostUrl/data-capture/connection-forms/$FormId/overview")

'Click button to open actions menu'
WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Overview/Actions Button'))

'Click button to open edit details drawer'
WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Overview/Edit Details Option'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Data Capture/Connection Forms/Create Form Drawer/Name Text Field'), 0)

'Edit form name back to original'
WebUI.setText(findTestObject('HC-Web/Data Capture/Connection Forms/Create Form Drawer/Name Text Field'), (Keys.chord(Keys.CONTROL + 
        'a') + Keys.BACK_SPACE) + originalName)

'Edit form public name back to original'
WebUI.setText(findTestObject('HC-Web/Data Capture/Connection Forms/Create Form Drawer/Public Name Text Field'), (Keys.chord(
        Keys.CONTROL + 'a') + Keys.BACK_SPACE) + originalName)

'Edit form description back to original'
WebUI.sendKeys(findTestObject('HC-Web/Data Capture/Connection Forms/Create Form Drawer/Public Description Text Field'), 
    (Keys.chord(Keys.CONTROL + 'a') + Keys.BACK_SPACE) + originalDescription)

'Save edits'
WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Create Form Drawer/Save Button'))

'Wait for success banner to appear and disappear'
WebUI.waitForElementPresent(findTestObject('HC-Web/Data Capture/Connection Forms/Overview/Save Form Success Banner Message'), 
    0)

WebUI.waitForElementNotPresent(findTestObject('HC-Web/Data Capture/Connection Forms/Overview/Save Form Success Banner Message'), 
    0)

'Verify name edited back to original'
WebUI.verifyElementText(findTestObject('HC-Web/Data Capture/Connection Forms/Overview/Form Name'), originalName)

'Get link to fill out form'
link = WebUI.getAttribute(findTestObject('HC-Web/Data Capture/Connection Forms/Overview/View Page Link'), 'href')

'Navigate to page to fill out form'
WebUI.navigateToUrl(link)

WebUI.waitForElementVisible(findTestObject('HC-Web/Data Capture/Connection Forms/New Entry Page/Description Text Area'), 
    0)

'Verify description edited back to original'
WebUI.verifyElementText(findTestObject('HC-Web/Data Capture/Connection Forms/New Entry Page/Description Text Area'), originalDescription)

'Verify public name edited back to original'
WebUI.verifyElementText(findTestObject('HC-Web/Data Capture/Connection Forms/New Entry Page/Public Name Text Area'), originalName)

WebUI.closeBrowser()

