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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : "/events-central/event/$EventId/overview"], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Occurrence Schedule/Occurrence Schedule Tab'))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Occurrence Schedule/Check In Button'))

WebUI.click(findTestObject('HC-Web/Event/Check In/Room In List', [('RoomName') : RoomName]))

if (WebUI.waitForElementPresent(findTestObject('Object Repository/HC-Web/Event/Check In/Open Room Early Yes Button'), 5)) {
    WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/Open Room Early Yes Button'))
}

if (WebUI.waitForElementPresent(findTestObject('Object Repository/HC-Web/Event/Check In/General Room Button'), 5)) {
    WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/General Room Button'))
}

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/Search or Add Button'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Event/Check In/Add Attendee Drawer/Occurrence Schedule Tab'), 2)

WebUI.click(findTestObject('HC-Web/Event/Check In/Add Attendee Drawer/Occurrence Schedule Tab'))

WebUI.click(findTestObject('HC-Web/Event/Check In/Add Attendee Drawer/First Listed Person'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Event/Check In/Add Attendee Drawer/Edit Person Record Button'), 2)

WebUI.click(findTestObject('HC-Web/Event/Check In/Add Attendee Drawer/Edit Person Record Button'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Person/Edit/Personal Details Panel'), 2)

WebUI.verifyElementVisible(findTestObject('HC-Web/Person/Edit/Personal Details Panel'))

WebUI.closeBrowser()

