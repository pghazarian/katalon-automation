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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : "/events-central/event/$EventId/registration-roster"], 
    FailureHandling.STOP_ON_FAILURE)

'If person record is already listed in registration roster, remove them'
if (CustomKeywords.'TestObjectHelper.isElementPresent'(CustomKeywords.'TestObjectHelper.getTestObjectWithXpath'(
        "//div[normalize-space(.)='$SearchName']"), 5)) {
    WebUI.click(CustomKeywords.'TestObjectHelper.getTestObjectWithXpath'("//div[normalize-space(.)='$SearchName']/ancestor::tr/descendant::div[contains(@class,'icon-check')]"))

    WebUI.click(findTestObject('HC-Web/Event/Registration Roster/Actions Dropdown'))

    WebUI.click(findTestObject('HC-Web/Event/Registration Roster/Remove from Event Dropdown Option'))

    WebUI.verifyTextNotPresent(SearchName, false)
}

'Click button to add a person record to the registration roster'
WebUI.click(findTestObject('HC-Web/Event/Registration Roster/Add to Roster Button'))

'Search for desired person record to add'
WebUI.setText(findTestObject('HC-Web/Event/PersonDrawer/Person Search Drawer Search Bar Input'), SearchName + Keys.ENTER)

'Select a person record from search results'
WebUI.click(findTestObject('HC-Web/Event/PersonDrawer/Person Search Drawer Search Results'))

'Click button to select opened person record'
WebUI.click(findTestObject('HC-Web/Event/PersonDrawer/Select Person Search Result Button'))

'Confirm person record selection'
WebUI.click(findTestObject('HC-Web/Event/PersonDrawer/Select Person Search Result Confirmation Yes Button'))

'Verify person record appears in registration roster'
WebUI.verifyTextPresent(SearchName, false)

'Click checkbox for recently added person record'
WebUI.click(CustomKeywords.'TestObjectHelper.getTestObjectWithXpath'("//div[normalize-space(.)='$SearchName']/ancestor::tr/descendant::div[contains(@class,'icon-check')]"))

'Open actions dropdown'
WebUI.click(findTestObject('HC-Web/Event/Registration Roster/Actions Dropdown'))

'Select option to remove person record from registration roster'
WebUI.click(findTestObject('HC-Web/Event/Registration Roster/Remove from Event Dropdown Option'))

'Verify person record was removed from registration roster'
WebUI.verifyTextNotPresent(SearchName, false)

WebUI.closeBrowser()

