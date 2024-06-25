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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : "/events-central/event/$EventId/occurrence-schedule"], 
    FailureHandling.STOP_ON_FAILURE)

'If person record is already listed in occurrence schedule, remove them'
if (WebUI.waitForElementPresent(CustomKeywords.'TestObjectHelper.getTestObjectWithXpath'("//div[normalize-space(.)='$SearchName']"), 
    10)) {
    WebUI.click(CustomKeywords.'TestObjectHelper.getTestObjectWithXpath'("//div[normalize-space(.)='$SearchName']/ancestor::tr/descendant::div[contains(@class,'icon-check')]"))

    WebUI.click(findTestObject('HC-Web/Event/Occurrence Schedule/Actions Dropdown'))

    WebUI.click(findTestObject('HC-Web/Event/Occurrence Schedule/Remove from this Occurrence Option'))

    WebUI.click(findTestObject('HC-Web/Event/Occurrence Schedule/Remove from this Occurrence Confirmation Yes Button'))

    'Click "yes" to confirm selection'
    WebUI.waitForElementNotPresent(findTestObject('HC-Web/Event/Occurrence Schedule/AttendeeName', [('AttendeeName') : SearchName]), 
        0)
}

'Click button to add a person record to the occurrence schedule'
WebUI.click(findTestObject('HC-Web/Event/Occurrence Schedule/Add to Roster Button'))

'Add person record to this occurrence only'
WebUI.click(findTestObject('HC-Web/Event/Occurrence Schedule/For This Occurrence Option'))

'Search for person record'
WebUI.waitForElementVisible(findTestObject('HC-Web/Event/PersonDrawer/Person Search Drawer Search Bar Input'), 2)

'Search for person record'
WebUI.setText(findTestObject('HC-Web/Event/PersonDrawer/Person Search Drawer Search Bar Input'), SearchName + Keys.ENTER)

'Select person record from search results'
WebUI.click(findTestObject('HC-Web/Event/PersonDrawer/Person Search Drawer Search Results'))

'Click button to select opened record'
WebUI.click(findTestObject('HC-Web/Event/PersonDrawer/Select Person Search Result Button'))

'Scroll confirmation button into view'
WebUI.scrollToElement(findTestObject('HC-Web/Event/PersonDrawer/Personal Info Header'), 2)

WebUI.waitForElementVisible(findTestObject('HC-Web/Event/PersonDrawer/Select Person Search Result Confirmation Yes Button'), 
    2)

'Click "yes" to confirm selection'
WebUI.click(findTestObject('HC-Web/Event/PersonDrawer/Select Person Search Result Confirmation Yes Button'))

'Wait for attendee name in list'
WebUI.waitForElementPresent(findTestObject('HC-Web/Event/Occurrence Schedule/AttendeeName', [('AttendeeName') : SearchName]), 
    5)

'Verify attendee name in list'
WebUI.verifyElementPresent(findTestObject('HC-Web/Event/Occurrence Schedule/AttendeeName', [('AttendeeName') : SearchName]), 
    0)

'Click checkbox for recently added person record'
WebUI.click(CustomKeywords.'TestObjectHelper.getTestObjectWithXpath'("//div[normalize-space(.)='$SearchName']/ancestor::tr/descendant::div[contains(@class,'icon-check')]"))

'Open actions dropdown'
WebUI.click(findTestObject('HC-Web/Event/Occurrence Schedule/Actions Dropdown'))

'Select remove from this occurrence'
WebUI.click(findTestObject('HC-Web/Event/Occurrence Schedule/Remove from this Occurrence Option'))

'Confirm removal from this occurrence'
WebUI.click(findTestObject('HC-Web/Event/Occurrence Schedule/Remove from this Occurrence Confirmation Yes Button'))

'Wait for attendee name to be removed'
WebUI.waitForElementNotPresent(findTestObject('HC-Web/Event/Occurrence Schedule/AttendeeName', [('AttendeeName') : SearchName]), 
    5)

'Verify attendee name was removed'
WebUI.verifyElementNotPresent(findTestObject('HC-Web/Event/Occurrence Schedule/AttendeeName', [('AttendeeName') : SearchName]), 
    0)

WebUI.closeBrowser()

