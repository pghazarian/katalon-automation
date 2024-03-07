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

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/journeys'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/div_JourneyJourney(beta)'))

'Click button to create a new journey'
WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/span_JourneyCreate Journey'))

JourneyName = ('QA Automation Journey ' + UUID.randomUUID())

'Enter unique journey name'
WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/Name Input Field'), JourneyName)

'Enter unique public journey name'
WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/Public Name Input Field'), JourneyName)

'Enter journey subtitle'
WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/Subtitle Field'), JourneyName)

'Enter journey description'
WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/Description Field'), Description)

'Select campus from dropdown'
CustomKeywords.'customUtility.TestObjectHelper.setDropDownValue'('journeys_list_page--field_campus', Campus)

'Select category from dropdown'
CustomKeywords.'customUtility.TestObjectHelper.setDropDownValue'('journeys_list_page--field_category', Type)

'Continue to journey builder'
WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/span_Continue'))

'Verify journey name'
WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/JourneyName_Breadcrumb'), JourneyName)

'Navigate to journey builder'
WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/span_Builder'))

'Add a new section'
WebUI.click(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Add New Section Button'))

'Give section a name and subtitle'
WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Step Title'), 'Section 1')

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Step Subtitle'), 'Section 1')

'Select accent color for section from dropdown'
CustomKeywords.'customUtility.TestObjectHelper.setDropDownValue'('journeys_list_page--field_accent_color', 'Sky')

'Select symbol for section from dropdown'
CustomKeywords.'customUtility.TestObjectHelper.setDropDownValue'('journeys_list_page--field_section_symbol', 'Action')

'Click done to save section'
WebUI.click(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Done Button'))

'Add a connection form step to section'
WebUI.click(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Step Type Fill Out a Form'))

'Give connection form step a name'
WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Step Title'), 'Test 1')

'Click button to add a connection form'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Button'))

'Search for a connection form to attach'
WebUI.setText(findTestObject('HC-Web/Journey/BuilderPage/Connection Form Search Bar'), 'Response Card' + Keys.ENTER)

'Select a connection form from search results'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Drawer Search Results'))

'Click button to save connection form selection'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Drawer Select Button'))

'Save connection form step'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Done Button'))

'Add a video step to section'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Step Type Watch a Video'))

'Give video step a name'
WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Step Title'), 'Test 2')

'Click button to add a video'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Button'))

'Select a video to attach'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/First Video Search Result'))

'Click button to save video selection'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Drawer Select Button'))

'Save video step'
WebUI.click(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Done Button'))

'Add an audio step to section'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Step Type Listen to Audio'))

'Give audio step a name'
WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Step Title'), 'Test 3')

'Click button to add audio'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Button'))

'Select an audio to add'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Drawer Search Results'))

'Click button to save audio attachment'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Drawer Select Button'))

'Save audio step'
WebUI.click(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Done Button'))

'Add a new section'
WebUI.click(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Add New Section Button'))

'Give section a name and subtitle'
WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Step Title'), 'Section 2')

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Step Subtitle'), 'Section 2')

'Select accent color for section from dropdown'
CustomKeywords.'customUtility.TestObjectHelper.setDropDownValue'('journeys_list_page--field_accent_color', 'Sky')

'Select symbol for section from dropdown'
CustomKeywords.'customUtility.TestObjectHelper.setDropDownValue'('journeys_list_page--field_section_symbol', 'Action')

'Click done to save section'
WebUI.click(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Done Button'))

'Add a text step to section'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Step Type Read Text'))

'Give text step a title'
WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Step Title'), 'Test 1')

'Click button to add a piece of text'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Button'))

'Select a text document to attach'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Drawer Search Results'))

'Click button to save text selection'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Drawer Select Button'))

'Save text step'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Done Button'))

'Add a step that links out from ME'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Step Type Link Out From ME'))

'Give link out step a name'
WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Step Title'), 'Test 2')

'Enter a url into link out url field'
WebUI.setText(findTestObject('HC-Web/Journey/BuilderPage/Link Out URL Field'), GlobalVariable.HC_HostUrl)

'Save link out step'
WebUI.click(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Done Button'))

'Add a quiz step to section'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Step Type Take a Quiz'))

'Give quiz step a name'
WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Step Title'), 'Test 3')

'Click button to add a quiz'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Button'))

'Select a quiz to attach'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Drawer Search Results'))

'Click button to save quiz selection'
WebUI.click(findTestObject('HC-Web/Journey/BuilderPage/Add Attachment Drawer Select Button'))

'Save quiz step'
WebUI.click(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Done Button'))

'Save journey builder edits'
WebUI.click(findTestObject('Object Repository/HC-Web/Journey/BuilderPage/Save Button'))

'Verify that icon for each step type is displayed in journey builder after saving'
WebUI.verifyElementVisible(findTestObject('HC-Web/Journey/BuilderPage/Connection Card Step Icon'))

WebUI.verifyElementVisible(findTestObject('HC-Web/Journey/BuilderPage/Video Step Icon'))

WebUI.verifyElementVisible(findTestObject('HC-Web/Journey/BuilderPage/Audio Step Icon'))

WebUI.verifyElementVisible(findTestObject('HC-Web/Journey/BuilderPage/Read Text Step Icon'))

WebUI.verifyElementVisible(findTestObject('HC-Web/Journey/BuilderPage/Link Out Step Icon'))

WebUI.verifyElementVisible(findTestObject('HC-Web/Journey/BuilderPage/Quiz Step Icon'))

'Navigate to journey overview'
WebUI.click(findTestObject('Object Repository/HC-Web/Journey/Overview/Overview Tab'))

'Return to all journeys page'
WebUI.click(findTestObject('HC-Web/Journey/Overview/Back to All Journeys Button'))

'Search for unique journey name and verify that it appears in result list'
WebUI.setText(findTestObject('HC-Web/Journey/AllJourneysPage/SearchBar'), JourneyName + Keys.ENTER)

CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpathTextMatch'('//tbody/tr/td/div/div[2]', JourneyName, 
    1)

WebUI.closeBrowser()

