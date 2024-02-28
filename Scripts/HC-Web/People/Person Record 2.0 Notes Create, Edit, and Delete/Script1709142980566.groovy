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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : "/people/search-or-add/record/$PersonId"], FailureHandling.STOP_ON_FAILURE)

def NoteText = 'QA Automation Note Created By Katalon Automation' + UUID.randomUUID()

def SubjectText = 'QA Automation Note ' + UUID.randomUUID()

WebUI.click(findTestObject('HC-Web/Person/Notes/Open Notes Button'))

WebUI.click(findTestObject('HC-Web/Person/Notes/New Note Button'))

CustomKeywords.'customUtility.TestObjectHelper.setDropDownValue'('person_notes_drawer_note_form--category_select', 'General')

WebUI.setText(findTestObject('HC-Web/Person/Notes/Subject Text Field'), SubjectText)

WebUI.setText(findTestObject('HC-Web/Person/Notes/Note Text Field'), NoteText)

WebUI.click(findTestObject('HC-Web/Person/Notes/Save Button'))

WebUI.verifyTextPresent(SubjectText, false)

WebUI.click(CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'("//div[text()='$SubjectText']/following-sibling::div[@class='person_notes_drawer--note_footer']/descendant::button[@id='person_notes_drawer--note--edit_person_note']"))

NoteText = (NoteText + ' - EDITED')

SubjectText = (SubjectText + ' - EDITED')

WebUI.setText(findTestObject('HC-Web/Person/Notes/Subject Text Field'), ' - EDITED')

WebUI.setText(findTestObject('HC-Web/Person/Notes/Note Text Field'), ' - EDITED')

WebUI.click(findTestObject('HC-Web/Person/Notes/Save Button'))

WebUI.verifyTextPresent(SubjectText, false)

WebUI.click(CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'("//div[text()='$SubjectText']/following-sibling::div[@class='person_notes_drawer--note_footer']/descendant::div[@id='person_notes_drawer--note--remove_person_note']"))

WebUI.click(findTestObject('HC-Web/Person/Notes/Delete Note Confirmation Yes Button'))

WebUI.delay(2)

WebUI.verifyTextNotPresent(NoteText, false)

WebUI.closeBrowser()

