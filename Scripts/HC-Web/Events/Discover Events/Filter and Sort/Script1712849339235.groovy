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

def todaysDateMonthAbbreviated = new Date().format('MMM').toString()

def todaysDateDay = new Date().format('d').toString()

def todaysDateAbbreviated = "$todaysDateMonthAbbreviated $todaysDateDay"

def currentYear = new Date().format('yyyy')

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/events-central/overview'], FailureHandling.STOP_ON_FAILURE)

'Click cancelled filter'
WebUI.click(findTestObject('HC-Web/Event/Search/Filters and Sorting/Cancelled Filter'))

'Verify first event in list was cancelled'
WebUI.verifyElementAttributeValue(findTestObject('HC-Web/Event/Search/SearchResultsFirstRowTitle'), 'class', 'event-card-title canceled-event', 
    0)

'Click past filter'
WebUI.click(findTestObject('HC-Web/Event/Search/Filters and Sorting/Past Filter'))

'Wait for list to load'
WebUI.delay(10)

'Open first event in list'
WebUI.click(findTestObject('HC-Web/Event/Search/SearchResultsFirstRowTitle'))

'Navigate to event details'
WebUI.click(findTestObject('HC-Web/Event/Details/Subnav_EventDetails'))

def endYear = WebUI.getAttribute(findTestObject('HC-Web/Event/Details/End Date Text Field'), 'value').substring(6)

'Verify that event ended last year. With default date range and ascending date order, first event should be a year prior.'
WebUI.verifyGreaterThan(currentYear, endYear)

'Return to event search'
WebUI.click(findTestObject('HC-Web/Event/Overview/BreadcrumbText1'))

'Click upcoming filter'
WebUI.click(findTestObject('HC-Web/Event/Search/Filters and Sorting/Upcoming Filter'))

'Verify event not cancelled'
WebUI.verifyEqual(false, WebUI.getAttribute(findTestObject('HC-Web/Event/Search/SearchResultsFirstRowTitle'), 'class').contains(
        'canceled-event'))

'Sort by descending date'
CustomKeywords.'TestObjectHelper.setDropDownValue'('events_overview--filter_panel-sort_dropdown', 'Event Date (Descending)')

WebUI.delay(2)

'Verify first event is not today'
WebUI.verifyEqual(false, WebUI.getText(findTestObject('HC-Web/Event/Search/Search Results First Event Date')).contains(todaysDateAbbreviated))

'Sort by ascending date'
CustomKeywords.'TestObjectHelper.setDropDownValue'('events_overview--filter_panel-sort_dropdown', 'Event Date (Ascending)')

'Verify first event is today'
WebUI.verifyEqual(true, WebUI.getText(findTestObject('HC-Web/Event/Search/Search Results First Event Date')).contains(todaysDateAbbreviated))

'Click paid filter'
WebUI.click(findTestObject('HC-Web/Event/Search/Filters and Sorting/Paid Filter'))

'Open first event in list'
WebUI.click(findTestObject('HC-Web/Event/Search/SearchResultsFirstRowTitle'), FailureHandling.STOP_ON_FAILURE)

'Navigate to event details'
WebUI.click(findTestObject('HC-Web/Event/Details/Subnav_EventDetails'))

'Verify event is paid'
WebUI.verifyElementChecked(findTestObject('HC-Web/Event/Details/Paid Event Radio Option'), 0)

'Return to event search'
WebUI.click(findTestObject('HC-Web/Event/Overview/BreadcrumbText1'))

'Click free filter'
WebUI.click(findTestObject('HC-Web/Event/Search/Filters and Sorting/Free Filter'))

'Open first event in list'
WebUI.click(findTestObject('HC-Web/Event/Search/SearchResultsFirstRowTitle'), FailureHandling.STOP_ON_FAILURE)

'Navigate to event details'
WebUI.click(findTestObject('HC-Web/Event/Details/Subnav_EventDetails'))

'Verify event is free'
WebUI.verifyElementChecked(findTestObject('HC-Web/Event/Details/Free Event Radio Option'), 0)

'Return to event search'
WebUI.click(findTestObject('HC-Web/Event/Overview/BreadcrumbText1'))

'Click required registration filter'
WebUI.click(findTestObject('HC-Web/Event/Search/Filters and Sorting/Registration Required Filter'))

'Open first event in list'
WebUI.click(findTestObject('HC-Web/Event/Search/SearchResultsFirstRowTitle'), FailureHandling.STOP_ON_FAILURE)

'Navigate to event details'
WebUI.click(findTestObject('HC-Web/Event/Details/Subnav_EventDetails'))

'Navigate to registration area'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration Subnav'))

'Verify registration required'
WebUI.verifyElementChecked(findTestObject('HC-Web/Event/Details/Registration/Registration Required Yes Radio Option Label'), 
    0)

'Return to event search'
WebUI.click(findTestObject('HC-Web/Event/Overview/BreadcrumbText1'))

'Click registration not required filter'
WebUI.click(findTestObject('HC-Web/Event/Search/Filters and Sorting/Registration Not Required Filter'))

'Open first event in list'
WebUI.click(findTestObject('HC-Web/Event/Search/SearchResultsFirstRowTitle'), FailureHandling.STOP_ON_FAILURE)

'Navigate to event details'
WebUI.click(findTestObject('HC-Web/Event/Details/Subnav_EventDetails'))

'Navigate to registration area'
WebUI.click(findTestObject('HC-Web/Event/Details/Registration Subnav'))

'Verify registration not required'
WebUI.verifyElementChecked(findTestObject('HC-Web/Event/Details/Registration/Registration Required No Radio Option Label'), 
    0)

'Return to event search'
WebUI.click(findTestObject('HC-Web/Event/Overview/BreadcrumbText1'))

'Click published filter'
WebUI.click(findTestObject('HC-Web/Event/Search/Filters and Sorting/Published Filter'))

'Open first event in list'
WebUI.click(findTestObject('HC-Web/Event/Search/SearchResultsFirstRowTitle'), FailureHandling.STOP_ON_FAILURE)

'Verify event is published'
WebUI.verifyEqual(true, WebUI.getText(findTestObject('HC-Web/Event/Overview/Publish Status Text Area'), FailureHandling.STOP_ON_FAILURE).contains(
        'Published'))

'Return to event search'
WebUI.click(findTestObject('HC-Web/Event/Overview/BreadcrumbText1'))

'Click unpublished filter'
WebUI.click(findTestObject('HC-Web/Event/Search/Filters and Sorting/Unpublished Filter'))

'Open first event in list'
WebUI.click(findTestObject('HC-Web/Event/Search/SearchResultsFirstRowTitle'), FailureHandling.STOP_ON_FAILURE)

'Verify event is unpublished'
WebUI.verifyEqual(true, WebUI.getText(findTestObject('HC-Web/Event/Overview/Publish Status Text Area'), FailureHandling.STOP_ON_FAILURE).contains(
        'Unpublished'))

'Return to event search'
WebUI.click(findTestObject('HC-Web/Event/Overview/BreadcrumbText1'))

WebUI.closeBrowser()

