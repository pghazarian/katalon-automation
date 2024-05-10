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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/my-dashboard/my-events'], FailureHandling.STOP_ON_FAILURE)

'Search for event by name'
WebUI.setText(findTestObject('HC-Web/Event/Search/SearchTextField'), SearchTerm)

WebUI.sendKeys(findTestObject('HC-Web/Event/Search/SearchTextField'), Keys.chord(Keys.ENTER))

'Click on search result containing event name'
WebUI.click(findTestObject('HC-Web/Event/Search/Search Result Event Title', [('SearchTerm') : SearchTerm]), FailureHandling.STOP_ON_FAILURE)

'Verify breadcrumb text shows event name'
WebUI.verifyElementText(findTestObject('HC-Web/Event/Overview/BreadcrumbText2'), SearchTerm)

'Go to the Event Details screen'
WebUI.click(findTestObject('HC-Web/Event/Details/Subnav_EventDetails'))

'Verify event name'
WebUI.verifyElementAttributeValue(findTestObject('HC-Web/Event/Details/Event Name'), 'value', SearchTerm, 0)

'Verify event category'
WebUI.verifyElementText(findTestObject('HC-Web/Event/Details/Category Dropdown Text Area'), EventCategory)

'Verify event campus'
WebUI.verifyElementText(findTestObject('HC-Web/Event/Details/Campus Dropdown Text Area'), EventCampus)

'Navigate to event details'
WebUI.click(findTestObject('HC-Web/Event/Details/Details Subnav'), FailureHandling.STOP_ON_FAILURE)

'Verify event description'
WebUI.verifyElementText(findTestObject('HC-Web/Event/Details/Event Description Text Area'), EventDescription)

WebUI.closeBrowser()

