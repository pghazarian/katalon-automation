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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : "/people/search-or-add/record/$PersonId/edit"], 
    FailureHandling.STOP_ON_FAILURE)

'Create unique note text'
def NoteText = 'QA Automation Note Created By Katalon Automation' + UUID.randomUUID()

'Open person record\'s notes'
WebUI.click(findTestObject('HC-Web/Person/Edit/Notes/Open Notes Button'))

'Click button to create a new note'
WebUI.click(findTestObject('HC-Web/Person/Edit/Notes/New Note Button'))

'Enter note text'
WebUI.setText(findTestObject('HC-Web/Person/Edit/Notes/Text Field'), NoteText)

'Save note'
WebUI.click(findTestObject('HC-Web/Person/Edit/Notes/Save Button'))

'Verify note appears in list'
WebUI.verifyTextPresent(NoteText, false)

'Click button to edit previously created note'
WebUI.click(CustomKeywords.'TestObjectHelper.getTestObjectWithXpath'("//div[text()='$NoteText']/ancestor::div[contains(@class,'note-details')]/descendant::a[@id='ui-legacy_button_circle--desktop_edit_note']"))

'Create edited note text'
NoteText = (NoteText + ' - EDITED')

'Enter newly created edited note text'
WebUI.setText(findTestObject('HC-Web/Person/Edit/Notes/Text Field'), ' - EDITED')

'Save edited note'
WebUI.click(findTestObject('HC-Web/Person/Edit/Notes/Save Button'))

'Verify edited note appears in list'
WebUI.verifyTextPresent(NoteText, false)

'Click button to edit previously edited note'
WebUI.click(CustomKeywords.'TestObjectHelper.getTestObjectWithXpath'("//div[text()='$NoteText']/ancestor::div[contains(@class,'note-details')]/descendant::a[@id='ui-legacy_button_circle--desktop_edit_note']"))

'Click delete button'
WebUI.click(findTestObject('HC-Web/Person/Edit/Notes/Delete Button'))

'Confirm deletion'
WebUI.click(findTestObject('HC-Web/Person/Edit/Notes/Delete Note Confirmation Yes Button'))

WebUI.delay(2)

'Verify deleted note does not appear in list'
WebUI.verifyTextNotPresent(NoteText, false)

WebUI.closeBrowser()

