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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/content-management/service-companion'], FailureHandling.STOP_ON_FAILURE)

ServiceCompanionName = ('QA Automation Test Service Companion ' + UUID.randomUUID())

'Click button to create new service companion'
WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/New Service Companion Button'))

'Give service companion a unique name'
WebUI.setText(findTestObject('HC-Web/Mobile Engagement/Service Companion/Name Text Field'), ServiceCompanionName)

'Enter description'
WebUI.setText(findTestObject('HC-Web/Mobile Engagement/Service Companion/Description Text Field'), 'Service Companion Created by Katalon Test')

'Select a speaker from the dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValue'('react-select-3--value', Speaker)

'Select a series from the dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValue'('react-select-4--value', Series)

'Click button to attach a service outline'
WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/Add Service Outline Button'))

'Select a service outline from the dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValue'('ui-dropdown--edit_sermon_outline_category', '')

'Add a description to the service outline'
WebUI.setText(findTestObject('HC-Web/Mobile Engagement/Service Companion/Edit Service Outline Body'), 'Test Description')

'Save the service outline attachment'
WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/Save Service Outline Button'))

'Click button to attach a connection form'
WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/Add Connection Form Button'))

'Search for a connection form to attach'
WebUI.setText(findTestObject('HC-Web/Mobile Engagement/Service Companion/Add Connection Form Search Bar'), ConnectionForm)

WebUI.sendKeys(findTestObject('HC-Web/Mobile Engagement/Service Companion/Add Connection Form Search Bar'), Keys.chord(Keys.ENTER))

'Select a connection form from search result'
WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/First Connection Form Search Result'))

'Confirm connection form attachment selection'
WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/Add Selected Connection Form'))

'Click button to attach an announcement'
WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/Add Announcement Button'))

'Search for an announcement to attach'
WebUI.setText(findTestObject('HC-Web/Mobile Engagement/Service Companion/Add Announcement Search Bar'), Announcement)

'Select announcement from search results'
WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/First Announcement Search Result'))

'Confirm announcement attachment selection'
WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/Add Selected Announcement Button'))

'Click remove button'
WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Service Companion/Remove button'))

'Remove prompt yes button'
WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Service Companion/Remove Prompt Yes button'))

'Click the button to add a song as an attachment'
WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/Add Song Button'))

'Select a song to attach'
WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/Add Song Search Result'))

'Confirm song attachment selection'
WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/Song Search Add Button'))

'Click remove button'
WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Service Companion/Remove button'))

'Remove prompt yes button'
WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Service Companion/Remove Prompt Yes button'))

'Click the button to add a service'
WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/Add Service Association Button'))

'Select a campus for the service attachment'
WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/Add Service Campus Checkboxes'))

'Confirm service attachment selection'
WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/Add Service Drawer Save Button'))

'Save service companion'
WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/Save Service Companion Button'))

WebUI.waitForElementNotPresent(findTestObject('HC-Web/Mobile Engagement/Service Companion/New Service Companion Drawer Container'), 
    10)

'Return to service companion page and search for created service companion'
WebUI.setText(findTestObject('HC-Web/Mobile Engagement/Service Companion/Search Bar'), ServiceCompanionName)

WebUI.sendKeys(findTestObject('HC-Web/Mobile Engagement/Service Companion/Search Bar'), Keys.chord(Keys.ENTER))

CustomKeywords.'TestObjectHelper.getTestObjectWithXpathTextMatch'('//td[@id=\'data_grid--table_page_cell_base-2_0\']', ServiceCompanionName, 
    1)

WebUI.closeBrowser()

