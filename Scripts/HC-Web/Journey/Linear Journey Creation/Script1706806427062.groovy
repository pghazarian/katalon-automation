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

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/span_JourneyCreate Journey'))

JourneyName = ('QA Automation Journey ' + UUID.randomUUID())

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/inputjourneys_list_page--template_name'), JourneyName)

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/inputjourneys_list_page--template_public_name'), 
    JourneyName)

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/Subtitle Field'), JourneyName)

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/Description Field'), Description)

CustomKeywords.'customUtility.TestObjectHelper.setDropDownValue'('journeys_list_page--field_campus', Campus)

CustomKeywords.'customUtility.TestObjectHelper.setDropDownValue'('journeys_list_page--field_category', Type)

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/span_Continue'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/JourneyName_Breadcrumb'), JourneyName)

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/span_Builder'))

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/span_Add an OptionNew Section'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/inputjourneys_list_page--step_form_title'), 'Section 1')

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/inputjourneys_list_page--step_form_subtitle'), 
    'Section 1')

CustomKeywords.'customUtility.TestObjectHelper.setDropDownValue'('journeys_list_page--field_accent_color', 'Sky')

CustomKeywords.'customUtility.TestObjectHelper.setDropDownValue'('journeys_list_page--field_section_symbol', 'Action')

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/button_Done'))

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/Step Type Fill Out a Form'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/inputjourneys_list_page--step_form_title'), 'Test 1')

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/Add Attachment Button'))

WebUI.setText(findTestObject('HC-Web/Journey/CreateEdit/Connection Form Search Bar'), 'Response Card' + Keys.ENTER)

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/Add Attachment Drawer Search Results'))

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/Add Attachment Drawer Select Button'))

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/button_Done'))

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/Step Type Watch a Video'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/inputjourneys_list_page--step_form_title'), 'Test 2')

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/Add Attachment Button'))

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/First Video Search Result'))

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/Add Attachment Drawer Select Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/button_Done'))

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/Step Type Listen to Audio'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/inputjourneys_list_page--step_form_title'), 'Test 3')

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/Add Attachment Button'))

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/Add Attachment Drawer Search Results'))

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/Add Attachment Drawer Select Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/button_Done'))

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/span_Add an OptionNew Section'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/inputjourneys_list_page--step_form_title'), 'Section 2')

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/inputjourneys_list_page--step_form_subtitle'), 
    'Section 2')

CustomKeywords.'customUtility.TestObjectHelper.setDropDownValue'('journeys_list_page--field_accent_color', 'Sky')

CustomKeywords.'customUtility.TestObjectHelper.setDropDownValue'('journeys_list_page--field_section_symbol', 'Action')

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/button_Done'))

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/Step Type Read Text'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/inputjourneys_list_page--step_form_title'), 'Test 1')

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/Add Attachment Button'))

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/Add Attachment Drawer Search Results'))

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/Add Attachment Drawer Select Button'))

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/button_Done'))

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/Step Type Link Out From ME'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/inputjourneys_list_page--step_form_title'), 'Test 2')

WebUI.setText(findTestObject('HC-Web/Journey/CreateEdit/Link Out URL Field'), GlobalVariable.HC_HostUrl)

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/button_Done'))

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/Step Type Take a Quiz'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/inputjourneys_list_page--step_form_title'), 'Test 3')

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/Add Attachment Button'))

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/Add Attachment Drawer Search Results'))

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/Add Attachment Drawer Select Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/button_Done'))

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/button_Save'))

WebUI.verifyElementVisible(findTestObject('HC-Web/Journey/CreateEdit/Connection Card Step Icon'))

WebUI.verifyElementVisible(findTestObject('HC-Web/Journey/CreateEdit/Video Step Icon'))

WebUI.verifyElementVisible(findTestObject('HC-Web/Journey/CreateEdit/Audio Step Icon'))

WebUI.verifyElementVisible(findTestObject('HC-Web/Journey/CreateEdit/Read Text Step Icon'))

WebUI.verifyElementVisible(findTestObject('HC-Web/Journey/CreateEdit/Link Out Step Icon'))

WebUI.verifyElementVisible(findTestObject('HC-Web/Journey/CreateEdit/Quiz Step Icon'))

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/span_Overview'))

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/BackToAllJourneys'))

WebUI.setText(findTestObject('HC-Web/Journey/AllJourneysPage/SearchBar'), JourneyName + Keys.ENTER)

CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpathTextMatch'('//tbody/tr/td/div/div[2]', JourneyName, 
    1)

WebUI.closeBrowser()

