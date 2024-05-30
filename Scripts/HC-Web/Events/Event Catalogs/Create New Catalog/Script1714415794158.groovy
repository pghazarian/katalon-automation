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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def startDate = new Date().format('MMddyyyy').toString()

def startDateFormatted = new Date().format('MM/dd/yyyy').toString()

def endDate = new Date().plus(2).format('MMddyyyy').toString()

def endDateFormatted = new Date().plus(2).format('MM/dd/yyyy').toString()

def projectDirectory = RunConfiguration.getProjectDir()

def imagePath = projectDirectory + GlobalVariable.Stock_Image_Path

def catalogName = 'QA Automation Event Catalog ' + UUID.randomUUID()

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/events-central/event-catalogs'], FailureHandling.STOP_ON_FAILURE)

'Click button to create a new catalog'
WebUI.click(findTestObject('HC-Web/Event/Catalogs/New Catalog Button'))

'Upload a picture for the web header, CA app header, and thumbnail'
WebUI.uploadFile(findTestObject('HC-Web/Event/Catalogs/Create Catalog Drawer/Upload for All Button'), projectDirectory + 
    GlobalVariable.Stock_Image_Path)

'Click next button to accept image cropping for web header'
WebUI.click(findTestObject('HC-Web/Event/Catalogs/Create Catalog Drawer/Upload Image Next Button'))

'Click next button to accept image cropping for CA app header'
WebUI.click(findTestObject('HC-Web/Event/Catalogs/Create Catalog Drawer/Upload Image Next Button'))

'Click next button for thumbnail'
WebUI.click(findTestObject('HC-Web/Event/Catalogs/Create Catalog Drawer/Upload Image Next Button'))

'Enter catalog name'
WebUI.setText(findTestObject('HC-Web/Event/Catalogs/Create Catalog Drawer/Title Text Field'), catalogName)

'Enter catalog description'
WebUI.setText(findTestObject('HC-Web/Event/Catalogs/Create Catalog Drawer/Description Text Field'), 'Event catalog created by QA Automation Test - can be deleted')

'Set a tag for the catalogue'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@id=\'event_catalogs--manage_filtering_field_set\']/descendant::div[@class=\'Select-multi-value-wrapper\']', 
    Tag)

'Enter a start date'
WebUI.setText(findTestObject('HC-Web/Event/Catalogs/Create Catalog Drawer/Start Date Text Field'), startDate)

'Enter a start time'
CustomKeywords.'TestObjectHelper.setDropDownValue'('event_catalogs--manage_publishingStartTime', '12:00 AM')

'Enter an end date'
WebUI.setText(findTestObject('HC-Web/Event/Catalogs/Create Catalog Drawer/End Date Text Field'), endDate)

'Enter an end time'
CustomKeywords.'TestObjectHelper.setDropDownValue'('event_catalogs--manage_publishingEndTime', '11:30 PM')

'Save catalog'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Catalogs/Create Catalog Drawer/Save Catalog Button'))

'Search for catalog in list'
WebUI.setText(findTestObject('HC-Web/Event/Catalogs/Search Bar'), catalogName + Keys.ENTER)

WebUI.waitForElementPresent(findTestObject('HC-Web/Event/Catalogs/Loading Indicator'), 5)

WebUI.waitForElementNotPresent(findTestObject('HC-Web/Event/Catalogs/Loading Indicator'), 5)

'Verify catalog appears in search results'
WebUI.verifyTextPresent(catalogName, false)

'Open catalog'
WebUI.click(findTestObject('HC-Web/Event/Catalogs/First Catalog Row'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Event/Catalogs/Create Catalog Drawer/Title Text Field'), 5)

'Verify catalog name'
WebUI.verifyElementAttributeValue(findTestObject('HC-Web/Event/Catalogs/Create Catalog Drawer/Title Text Field'), 'value', 
    catalogName, 0)

'Verify catalog description'
WebUI.verifyElementText(findTestObject('HC-Web/Event/Catalogs/Create Catalog Drawer/Description Text Field'), 'Event catalog created by QA Automation Test - can be deleted')

'Verify catalog tag'
WebUI.verifyTextPresent(Tag, false)

'Verify start date'
WebUI.verifyElementAttributeValue(findTestObject('HC-Web/Event/Catalogs/Create Catalog Drawer/Start Date Text Field'), 'value', 
    startDateFormatted, 0)

'Verify end date'
WebUI.verifyElementAttributeValue(findTestObject('HC-Web/Event/Catalogs/Create Catalog Drawer/End Date Text Field'), 'value', 
    endDateFormatted, 0)

WebUI.closeBrowser()

