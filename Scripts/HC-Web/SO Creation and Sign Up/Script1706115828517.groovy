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
WebUI.callTestCase(findTestCase('HC-Web/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/div_Ministries CentralMinistries Central'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Serving Opps/input'), 'Event SO Test')

WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Serving Opps/input'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/td_Event SO Test Ministry'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/td_Anaheim'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/button_View Dashboard'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/button_Serving Opps'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/button_plusNew Opportunity'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/td_What  Why'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Serving Opps/inputui-input--so_name'), 'Katalon Test SO')

WebUI.setText(findTestObject('Object Repository/HC-Web/Serving Opps/inputui-input--so_short_description'), 'Katalon Test SO')

WebUI.setText(findTestObject('Object Repository/HC-Web/Serving Opps/textarea_SO Created for Katalon Testing'), 'SO Created for Katalon Testing')

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/button_Add Contactplus'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/div_QAQA Automation  AdminMale  Lake Forest_34d8fc'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/button_Select'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/button_Nextchevron-wl-right'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/use_icon-use-path_1'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/button_Nextchevron-wh-right'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Serving Opps/inputschedule_capacity_drawer--input'), '10')

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/button_pencilEdit Custom Questions'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/button_New Question'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/h5_CheckboxCheckbox'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Serving Opps/inputcustom_question--props_title_input--1'), 'Test Question')

WebUI.setText(findTestObject('Object Repository/HC-Web/Serving Opps/inputcustom_question--props_placeholder_input--1'), 
    'Check This Box')

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/use_icon-use-path_1_2'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/button_Done'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/button_Save'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/button_Done_1'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/button_Save_1'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/button_Members'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/button_Serving Opps'))

WebUI.click(findTestObject('HC-Web/Serving Opps/List View Serving Ops'))

WebUI.click(findTestObject('HC-Web/Serving Opps/Upcoming Radio Option Serving Opps'))

WebUI.click(findTestObject('HC-Web/Serving Opps/Table Row Serving Opp'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/button_plusAdd VolunteerTo This OccurrenceT_6a52af'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/div_To This Occurrence'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/span_Person Search'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Serving Opps/inputperson_search_form--search_input'), 'Garrett Clover')

WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Serving Opps/inputperson_search_form--search_input'), Keys.chord(
        Keys.ENTER))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/div_GC Garrett  Clover Male  Lake ForestId 7801492'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/button_Select_1'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/div_Yes'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/use_icon-use-path_1_2_3'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/button_Save_1_2'))

WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Serving Opps/p_Garrett Clover'), 0)

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/svg_check'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/button_chevron-downActionsSend EmailSend Te_00ee2d'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/div_Remove From This Occurrence'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/div_Yes'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/span_Settings'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/span_Actions'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/span_Close OpportunityClose Opportunity'))

WebUI.click(findTestObject('Object Repository/HC-Web/Serving Opps/span_Yes'))

