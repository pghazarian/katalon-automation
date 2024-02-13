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
        , ('Password') : GlobalVariable.Admin_Password], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/AllJourneysPage/CreateEdit/div_JourneyJourney(beta)'))

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/AllJourneysPage/CreateEdit/span_JourneyCreate Journey'))

JourneyName = ('QA Automation Test Open Nav Journey ' + UUID.randomUUID())

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/AllJourneysPage/CreateEdit/inputjourneys_list_page--template_name'), 
    JourneyName)

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/AllJourneysPage/CreateEdit/inputjourneys_list_page--template_public_name'), 
    JourneyName)

CustomKeywords.'customUtility.TestObjectHelper.setDropDownValue'('journeys_list_page--field_campus', 'Lake Forest')

CustomKeywords.'customUtility.TestObjectHelper.setDropDownValue'('journeys_list_page--field_category', 'Worship')

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/AllJourneysPage/CreateEdit/Open Navigation Journey Pill Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/AllJourneysPage/CreateEdit/span_Continue'))

WebUI.delay(2)

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/div_Katalon Test Journey'), JourneyName)

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/span_Builder'))

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/span_Add an OptionNew Section'))

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/div_New SectionNew Section Subtitle0 Steps Total'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/inputjourneys_list_page--step_form_title'), 'Test')

WebUI.setText(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/inputjourneys_list_page--step_form_subtitle'), 
    'Test')

CustomKeywords.'customUtility.TestObjectHelper.setDropDownValue'('journeys_list_page--field_accent_color', 'Sky')

CustomKeywords.'customUtility.TestObjectHelper.setDropDownValue'('journeys_list_page--field_section_symbol', 'Action')

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/button_Done'))

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/button_Save'))

WebUI.click(findTestObject('Object Repository/HC-Web/Journey/CreateEdit/span_Overview'))

WebUI.click(findTestObject('HC-Web/Journey/CreateEdit/BackToAllJourneys'))

WebUI.setText(findTestObject('HC-Web/Journey/AllJourneysPage/SearchBar'), JourneyName + Keys.ENTER)

CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpathTextMatch'('//tbody/tr/td/div/div[2]', JourneyName, 
    1)

WebUI.closeBrowser()

