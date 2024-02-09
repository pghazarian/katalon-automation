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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/events-central/overview'], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('HC-Web/Event/Search/SearchTextField'), SearchTerm)

WebUI.sendKeys(findTestObject('HC-Web/Event/Search/SearchTextField'), Keys.chord(Keys.ENTER))

try {
	'Try to click the record in the table'
	FoundSearchRecord = CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpathTextMatch'('//div[contains(@class, \'event-card-title\')]',
		EventName)
	
	WebUI.verifyElementText(FoundSearchRecord, EventName)

	WebUI.click(FoundSearchRecord)
} catch(Exception ex) {
	println("Could not click on the record")
	
	'if the record could not be clicked, try to click the event Details Popover'
	EventDetailsPopover = CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'("//div[contains(@class, 'event-details-popover')]")
	
	WebUI.click(EventDetailsPopover)
}


WebUI.verifyElementText(findTestObject('HC-Web/Event/Overview/BreadcrumbText2'), EventName)

WebUI.verifyElementPresent(findTestObject('HC-Web/Event/Overview/EventDescription'), 1)

'Go to the Event Details screen'
WebUI.click(findTestObject('HC-Web/Event/Details/Subnav_EventDetails'))

WebUI.delay(2)

'Go to the Occurrence Schedule screen'
try {
	WebUI.verifyElementVisible(findTestObject('HC-Web/Event/Details/Subnav_OccurrenceSchedule'), 10)
	WebUI.click(findTestObject('HC-Web/Event/Details/Subnav_OccurrenceSchedule'))
}
catch (Exception ex) {
	WebUI.click(findTestObject('HC-Web/Event/Details/Subnav_MoreEllipsis'))
	WebUI.click(CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'("//div[contains(@class, 'navigation_sectional_tabs--panel')]/button[contains(@class, 'button_dropdown')]/descendant::div[text() = 'Occurrence Schedule']"))
}

'Click on name in the table to open the record in a drawer'
WebUI.click(CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpathTextMatch'('//main/descendant::tbody/descendant::div', 
        ScheduledName))

PersonTableCellObject = CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpathTextMatch'('//div[@class=\'drawer-container-inner\']/descendant::div[@class=\'person_record--details_window_person_info_full_name\']', 
    ScheduledName, 1)

PersonName = WebUI.getAttribute(PersonTableCellObject, 'innerText')

'Verify the schedule person\'s name in the table'
WebUI.verifyEqual(ScheduledName, PersonName)

WebUI.click(findTestObject('HC-Web/Event/PersonDrawer/CloseButton'))

'Go to the Registration Roster screen'
try {
	WebUI.verifyElementVisible(findTestObject('HC-Web/Event/Details/Subnav_RegistrationRoster'), 10)
	WebUI.click(findTestObject('HC-Web/Event/Details/Subnav_RegistrationRoster'))
}
catch (Exception ex) {
	WebUI.click(findTestObject('HC-Web/Event/Details/Subnav_MoreEllipsis'))
	WebUI.click(CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'("//div[contains(@class, 'navigation_sectional_tabs--panel')]/button[contains(@class, 'button_dropdown')]/descendant::div[text() = 'Registration Roster']"))
}

'Click on name in the table to open the record in a drawer'
WebUI.click(CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpathTextMatch'('//main/descendant::tbody/descendant::div', 
        RegistrantName))

PersonTableCellObject = CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpathTextMatch'('//div[@class=\'drawer-container-inner\']/descendant::div[@class=\'person_record--details_window_person_info_full_name\']', 
    RegistrantName)

PersonName = WebUI.getAttribute(PersonTableCellObject, 'innerText')

'Verify the schedule person\'s name in the table'
WebUI.verifyEqual(RegistrantName, PersonName)

WebUI.click(findTestObject('HC-Web/Event/PersonDrawer/CloseButton'))

'Go to the Communications screen'
try {
	WebUI.verifyElementVisible(findTestObject('HC-Web/Event/Details/Subnav_Communications'), 10)
	WebUI.click(findTestObject('HC-Web/Event/Details/Subnav_Communications'))
}
catch (Exception ex) {
	WebUI.click(findTestObject('Object Repository/HC-Web/Event/Details/Subnav_MoreEllipsis'))
	WebUI.click(CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'("//div[contains(@class, 'navigation_sectional_tabs--panel')]/button[contains(@class, 'button_dropdown')]/descendant::div[text() = 'Communications']"))
}

WebUI.verifyElementPresent(findTestObject('HC-Web/Event/Communications/RegistrationEmailHeader'), 1)

'Go to the Serving Opps screen'
try {
	WebUI.verifyElementVisible(findTestObject('HC-Web/Event/Details/Subnav_Serving Opps'), 10)
	WebUI.click(findTestObject('HC-Web/Event/Details/Subnav_Serving Opps'))
}
catch (Exception ex) {
	WebUI.click(findTestObject('Object Repository/HC-Web/Event/Details/Subnav_MoreEllipsis'))
	WebUI.click(CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'("//div[contains(@class, 'navigation_sectional_tabs--panel')]/button[contains(@class, 'button_dropdown')]/descendant::div[text() = 'Serving Opps']"))
}

'Click on the serving opp entry'
ServingOppDiv = CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpathTextMatch'('//div[contains(@class, \'page--data_cards\')]/descendant::h4', 
    ServingOppName)

WebUI.click(ServingOppDiv)

WebUI.verifyElementText(findTestObject('HC-Web/Event/ServingOpp/BreadCrumb3'), ServingOppName)

WebUI.verifyElementText(findTestObject('HC-Web/Event/ServingOpp/BreadCrumb2'), EventName)

'Go back to the Event via the Breadcrumb'
WebUI.click(findTestObject('HC-Web/Event/ServingOpp/BreadCrumb2'))

WebUI.closeBrowser()

