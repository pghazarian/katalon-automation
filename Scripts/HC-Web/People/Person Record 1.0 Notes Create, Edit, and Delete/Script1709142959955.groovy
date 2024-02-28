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

def NoteText = 'QA Automation Note Created By Katalon Automation' + UUID.randomUUID()

WebUI.click(findTestObject('HC-Web/Person/Edit/Notes/Open Notes Button'))

WebUI.click(findTestObject('HC-Web/Person/Record 1.0 Notes/NewNoteButton'))

WebUI.setText(findTestObject('HC-Web/Person/Record 1.0 Notes/TextField'), NoteText)

WebUI.click(findTestObject('HC-Web/Person/Record 1.0 Notes/SaveButton'))

WebUI.verifyTextPresent(NoteText, false)

WebUI.click(CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'("//div[text()='$NoteText']/ancestor::div[contains(@class,'note-details')]/descendant::a[@id='ui-legacy_button_circle--desktop_edit_note']"))

NoteText = (NoteText + ' - EDITED')

WebUI.setText(findTestObject('HC-Web/Person/Record 1.0 Notes/TextField'), ' - EDITED')

WebUI.click(findTestObject('HC-Web/Person/Record 1.0 Notes/SaveButton'))

WebUI.verifyTextPresent(NoteText, false)

WebUI.click(CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'("//div[text()='$NoteText']/ancestor::div[contains(@class,'note-details')]/descendant::a[@id='ui-legacy_button_circle--desktop_edit_note']"))

WebUI.click(findTestObject('HC-Web/Person/Record 1.0 Notes/DeleteButton'))

WebUI.click(findTestObject('HC-Web/Person/Record 1.0 Notes/DeleteNoteConfirmationYesButton'))

WebUI.delay(2)

WebUI.verifyTextNotPresent(NoteText, false)

WebUI.closeBrowser()

