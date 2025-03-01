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
import java.util.UUID as UUID

def date = new Date()

def CurrentDateTime = CustomKeywords.'StringHelper.getIsoFormatDate'(date)

def JourneyName = "QA Automation Test Open Nav Journey - $CurrentDateTime"

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/journeys'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/AllJourneysPage/CreateEdit/span_JourneyCreate Journey'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/AllJourneysPage/CreateEdit/inputjourneys_list_page--template_name'), 
    JourneyName)

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/AllJourneysPage/CreateEdit/inputjourneys_list_page--template_public_name'), 
    JourneyName)

CustomKeywords.'TestObjectHelper.setDropDownValue'('journeys_list_page--field_campus', 'Lake Forest')

CustomKeywords.'TestObjectHelper.setDropDownValue'('journeys_list_page--field_category', 'Worship')

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/AllJourneysPage/CreateEdit/Open Navigation Journey Pill Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/AllJourneysPage/CreateEdit/span_Continue'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Journey/CreateEdit/JourneyName_Breadcrumb', [('JourneyName') : JourneyName]), 
    30)

WebUI.verifyElementText(findTestObject('HC-Web/Journey/CreateEdit/JourneyName_Breadcrumb', [('JourneyName') : JourneyName]), 
    JourneyName)

WebUI.waitForElementPresent(findTestObject('HC-Web/Shared Component/Activity Indicator'), 3)

WebUI.waitForElementNotPresent(findTestObject('HC-Web/Shared Component/Activity Indicator'), 3)

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/Builder Tab'))

WebUI.waitForElementPresent(findTestObject('HC-Web/Shared Component/Activity Indicator'), 30)

WebUI.waitForElementNotPresent(findTestObject('HC-Web/Shared Component/Activity Indicator'), 3)

'Add first section to support each step type addition'
WebUI.click(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Add New Section Button'))

'Add a new section'
WebUI.delay(2, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Step Title'), 'Section 1')

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Step Subtitle'), 'Section 1')

CustomKeywords.'TestObjectHelper.setDropDownValue'('journeys_list_page--field_accent_color', 'Sky')

CustomKeywords.'TestObjectHelper.setDropDownValue'('journeys_list_page--field_section_symbol', 'Action')

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Done Button'))

'Add a form entry step type'
WebUI.click(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Step Type Fill Out a Form'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Step Title'), 'Test 1')

WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Button'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Journey/BuilderPage/Connection Form Search Bar'), 2)

WebUI.setText(findTestObject('HC-Web/Journey/BuilderPage/Connection Form Search Bar'), 'Response Card' + Keys.ENTER)

WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Drawer Search Results'))

WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Drawer Select Button'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Journey/BuilderPage/Done Button'), 2)

WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Done Button'))

'Add a watch video step type'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Step Type Watch a Video'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Step Title'), 'Test 2')

WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Button'))

WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/First Video Search Result'))

WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Drawer Select Button'))

'Add a audio step type'
WebUI.click(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Done Button'))

WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Step Type Listen to Audio'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Step Title'), 'Test 3')

WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Button'))

WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Drawer Search Results'))

WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Drawer Select Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Done Button'))

'Add second section to support remaining step type addition'
WebUI.click(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Add New Section Button'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Step Title'), 'Section 2')

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Step Subtitle'), 'Section 2')

CustomKeywords.'TestObjectHelper.setDropDownValue'('journeys_list_page--field_accent_color', 'Sky')

CustomKeywords.'TestObjectHelper.setDropDownValue'('journeys_list_page--field_section_symbol', 'Action')

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Done Button'))

'Add a read text step type'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Step Type Read Text'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Step Title'), 'Test 1')

WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Button'))

WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Drawer Search Results'))

WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Drawer Select Button'))

WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Done Button'))

'Add a link out step type'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Step Type Link Out From ME'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Step Title'), 'Test 2')

WebUI.setText(findTestObject('HC-Web/Journey/BuilderPage/Link Out URL Field'), GlobalVariable.HC_HostUrl)

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Done Button'))

'Add a quiz/review step type'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Step Type Take a Quiz'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Step Title'), 'Test 3')

WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Button'))

WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Drawer Search Results'))

WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Drawer Select Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Done Button'))

'Save the journey'
WebUI.click(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Save Button'))

WebUI.verifyElementVisible(findTestObject('HC-Web/Journey/BuilderPage/Connection Card Step Icon'))

WebUI.verifyElementVisible(findTestObject('HC-Web/Journey/BuilderPage/Video Step Icon'))

WebUI.verifyElementVisible(findTestObject('HC-Web/Journey/BuilderPage/Audio Step Icon'))

WebUI.verifyElementVisible(findTestObject('HC-Web/Journey/BuilderPage/Read Text Step Icon'))

WebUI.verifyElementVisible(findTestObject('HC-Web/Journey/BuilderPage/Link Out Step Icon'))

WebUI.verifyElementVisible(findTestObject('HC-Web/Journey/BuilderPage/Quiz Step Icon'))

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/Overview/Overview Tab'))

'Now make the newly created open navigation journey private'
not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Journey/Overview/Edit Details Button'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Journey/Overview/Edit Details Drawer/Private Option'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Journey/Overview/Edit Details Drawer/Continue Button'))

'Now make the newly created open navigation journey public'
not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Journey/Overview/Edit Details Button'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Journey/Overview/Edit Details Drawer/Public Option'))

not_run: WebUI.click(findTestObject('Object Repository/HC-Web/Journey/Overview/Edit Details Drawer/Continue Button'))

WebUI.click(findTestObject('HC-Web/Journey/Overview/Back to All Journeys Button'))

WebUI.setText(findTestObject('HC-Web/Journey/AllJourneysPage/SearchBar'), JourneyName + Keys.ENTER)

'this is attempting to match the journey name in the first row of the search results'
CustomKeywords.'TestObjectHelper.getTestObjectWithXpathTextMatch'('//tbody/tr/td/div/div[2]', JourneyName, 1)

WebUI.closeBrowser()

