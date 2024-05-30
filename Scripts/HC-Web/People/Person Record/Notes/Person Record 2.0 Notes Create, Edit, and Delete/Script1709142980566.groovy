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

'Create unique subject and note'
def NoteText = 'QA Automation Note Created By Katalon Automation' + UUID.randomUUID()

def SubjectText = 'QA Automation Note ' + UUID.randomUUID()

'Open person record\'s notes'
WebUI.click(findTestObject('HC-Web/Person/Notes/Open Notes Button'))

'Click button to create a new note'
WebUI.waitForElementVisible(findTestObject('HC-Web/Person/Notes/New Note Button'), 2)

'Click button to create a new note'
WebUI.click(findTestObject('HC-Web/Person/Notes/New Note Button'))

'Select a note category'
CustomKeywords.'TestObjectHelper.setDropDownValue'('person_notes_drawer_note_form--category_select', 'General')

'Enter subject'
WebUI.setText(findTestObject('HC-Web/Person/Notes/Subject Text Field'), SubjectText)

'Enter note text'
WebUI.setText(findTestObject('HC-Web/Person/Notes/Note Text Field'), NoteText)

'Save note'
WebUI.click(findTestObject('HC-Web/Person/Notes/Save Button'))

'Verify that note appears in the list'
WebUI.waitForElementVisible(findTestObject('HC-Web/Person/Notes/Created Note', [('SubjectText') : SubjectText]), 3)

'Click button to edit previously created note'
WebUI.click(findTestObject('HC-Web/Person/Notes/Created Note Edit Button', [('SubjectText') : SubjectText]))

'Edit note text'
NoteText = (NoteText + ' - EDITED')

'Edit subject'
SubjectText = (SubjectText + ' - EDITED')

'Enter edited note text'
WebUI.setText(findTestObject('HC-Web/Person/Notes/Subject Text Field'), ' - EDITED')

'Enter edited subject'
WebUI.setText(findTestObject('HC-Web/Person/Notes/Note Text Field'), ' - EDITED')

'Save note edits'
WebUI.click(findTestObject('HC-Web/Person/Notes/Save Button'))

'Verify that note with new subject appears in the list'
WebUI.waitForElementVisible(findTestObject('HC-Web/Person/Notes/Created Note', [('SubjectText') : SubjectText]), 3)

'Click button to delete edited note'
WebUI.click(findTestObject('HC-Web/Person/Notes/Created Note Delete Button', [('SubjectText') : SubjectText]))

'Verify deletion'
WebUI.click(findTestObject('HC-Web/Person/Notes/Delete Note Confirmation Yes Button'))

'Verify that note appears in the list'
WebUI.waitForElementNotPresent(findTestObject('HC-Web/Person/Notes/Created Note', [('SubjectText') : SubjectText]), 3)

WebUI.closeBrowser()

