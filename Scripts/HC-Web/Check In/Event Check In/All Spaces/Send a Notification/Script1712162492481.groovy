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

WebUI.waitForElementClickable(findTestObject('Object Repository/HC-Web/Event/Check In/Attendee Search Bar'), 2)

WebUI.setText(findTestObject('Object Repository/HC-Web/Event/Check In/Attendee Search Bar'), AttendeeName)

WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Event/Check In/Attendee Search Bar'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('HC-Web/Event/Check In/Attendee Search Results', [('AttendeeName') : AttendeeName]))

WebUI.verifyElementText(findTestObject('HC-Web/Event/Check In/Attendee Names', [('AttendeeName') : AttendeeName]), AttendeeName)

WebUI.click(findTestObject('HC-Web/Event/Check In/Back to All Spaces Button'))

WebUI.click(findTestObject('HC-Web/Event/Check In/All Rooms Checkbox'))

WebUI.click(findTestObject('HC-Web/Event/Check In/Send Notification Button'))

WebUI.click(findTestObject('HC-Web/Event/Check In/Send Notification To Attendees Option'))

CustomKeywords.'TestObjectHelper.setDropDownValueWithClick'('check_in_page--send_notification_drawer--message_type_dropdown', 
    'Custom Message')

WebUI.setText(findTestObject('HC-Web/Event/Check In/Notification Message Text Area'), 'Test Notification')

WebUI.click(findTestObject('HC-Web/Event/Check In/Notification Drawer Send Button'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Event/Check In/SMS Sent Banner'), 5)

WebUI.verifyElementText(findTestObject('HC-Web/Event/Check In/SMS Sent Banner'), 'SMS sent successfully')

WebUI.click(findTestObject('HC-Web/Event/Check In/Room In List', [('RoomName') : RoomName]))

WebUI.click(findTestObject('HC-Web/Event/Check In/Attendee Checkboxes', [('AttendeeName') : AttendeeName]))

WebUI.click(findTestObject('HC-Web/Event/Check In/Checkout Button'))

WebUI.click(findTestObject('HC-Web/Event/Check In/Checkout Confirmation Yes Button'))

WebUI.verifyElementNotPresent(findTestObject('HC-Web/Event/Check In/Attendee Names', [('AttendeeName') : AttendeeName]), 
    3)

'Close space'
WebUI.waitForElementVisible(findTestObject('HC-Web/Event/Check In/Close Space Button'), 3)

'Close space'
WebUI.waitForElementClickable(findTestObject('HC-Web/Event/Check In/Close Space Button'), 3)

WebUI.click(findTestObject('HC-Web/Event/Check In/Close Space Button'))

WebUI.click(findTestObject('HC-Web/Event/Check In/Close Space Confirmation Yes Button'))

def flag = false

def i = 0

'Wait until room status icon indicates that the room has been closed'
while (!(flag) && (i < 5)) {
    flag = WebUI.getAttribute(findTestObject('HC-Web/Event/Check In/Room Status Icon', [('RoomName') : RoomName]), 'class').contains(
        'icon-minus-circle')

    WebUI.delay(1)

    i++
}

'If room status icon does not indicate room has been closed, fail test'
if (!(flag)) {
    throw new Exception('Room status icon did not indicate the room was closed.')
}

WebUI.closeBrowser()

