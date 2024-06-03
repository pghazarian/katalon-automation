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

def LastName = UUID.randomUUID().toString()

def ParentName = "$ParentFirstName $LastName"

def ChildName = "$ChildFirstName $LastName"

def Birthdate = new Date().minus(2195).format('MMddyyyy').toString()

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : "/events-central/event/$EventId/overview"], FailureHandling.STOP_ON_FAILURE)

'Navigate to occurrence schedule'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Occurrence Schedule/Occurrence Schedule Tab'))

'Open check in'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Occurrence Schedule/Check In Button'))

'Select first room designated for children in list'
WebUI.click(findTestObject('HC-Web/Event/Check In/Room In List', [('RoomName') : RoomName]))

'If event has not started, open room early'
if (WebUI.waitForElementPresent(findTestObject('HC-Web/Event/Check In/Open Room Early Yes Button'), 2)) {
    WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/Open Room Early Yes Button'))
}

'If room has not been opened, open a child room and add volunteers'
if (WebUI.waitForElementPresent(findTestObject('Object Repository/HC-Web/Event/Check In/Child Room Button'), 2)) {
    'Select child room'
    WebUI.click(findTestObject('HC-Web/Event/Check In/Child Room Button'))

    'Open volunteer page'
    WebUI.click(findTestObject('HC-Web/Event/Check In/Find Volunteers Button'))

    'Switch to person search'
    CustomKeywords.'FormHelper.setMultipleChoiceControlValueByXPath'('//div[contains(@class,\'radio-pill\')]', 'Person Search')

    'Search for volunteers'
    WebUI.setText(findTestObject('HC-Web/Event/Check In/Volunteer Person Search Bar'), VolunteerSearchName + Keys.chord(
            Keys.ENTER))

    'Add volunteer from search results'
    WebUI.click(findTestObject('HC-Web/Event/Check In/Add and Check In Button'), FailureHandling.STOP_ON_FAILURE)

    'If volunteer is not signed up for event, add them anyway'
    if (WebUI.waitForElementPresent(findTestObject('Object Repository/HC-Web/Event/Check In/Add and Proceed Button'), 2)) {
        WebUI.click(findTestObject('HC-Web/Event/Check In/Add and Proceed Button'))
    }
    
    'If volunteer is signed up for another event, add them anyway'
    if (WebUI.waitForElementPresent(findTestObject('Object Repository/HC-Web/Event/Check In/Transfer Button'), 2)) {
        WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/Transfer Button'))
    }
    
    'Add a second volunteer from search results'
    WebUI.click(findTestObject('HC-Web/Event/Check In/Add and Check In Button'), FailureHandling.STOP_ON_FAILURE)

    'If volunteer is not signed up for event, add them anyway'
    if (WebUI.waitForElementPresent(findTestObject('Object Repository/HC-Web/Event/Check In/Add and Proceed Button'), 2)) {
        WebUI.click(findTestObject('HC-Web/Event/Check In/Add and Proceed Button'))
    }
    
    'If volunteer is signed up for another event, add them anyway'
    if (WebUI.waitForElementPresent(findTestObject('Object Repository/HC-Web/Event/Check In/Transfer Button'), 2)) {
        WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/Transfer Button'))
    }
    
    'Finish adding volunteers and return to check in'
    WebUI.click(findTestObject('HC-Web/Event/Check In/Volunteer Page Done Button'))

    'Open space with selected volunteers'
    WebUI.click(findTestObject('HC-Web/Event/Check In/Volunteer Page Open Space Button'))
}

'Open drawer to search for attendees'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/Search or Add Button'))

'Open drawer to search for attendees'
WebUI.waitForElementVisible(findTestObject('HC-Web/Event/Check In/Add Attendee Drawer/New Person Tab'), 0)

'Open drawer to search for attendees'
WebUI.click(findTestObject('HC-Web/Event/Check In/Add Attendee Drawer/New Person Tab'))

'Open drawer to search for attendees'
WebUI.setText(findTestObject('HC-Web/Event/Check In/Add Attendee Drawer/New Person Drawer/Parent First Name Text Field'), 
    ParentFirstName)

'Open drawer to search for attendees'
WebUI.setText(findTestObject('HC-Web/Event/Check In/Add Attendee Drawer/New Person Drawer/Parent Last Name Text Field'), 
    LastName)

'Open drawer to search for attendees'
WebUI.setText(findTestObject('HC-Web/Event/Check In/Add Attendee Drawer/New Person Drawer/Parent Phone Text Field'), PhoneNumber)

'Open drawer to search for attendees'
WebUI.setText(findTestObject('HC-Web/Event/Check In/Add Attendee Drawer/New Person Drawer/Child First Name Text Field'), 
    ChildFirstName)

'Open drawer to search for attendees'
WebUI.setText(findTestObject('HC-Web/Event/Check In/Add Attendee Drawer/New Person Drawer/Child Birthdate Text Field'), 
    Birthdate)

CustomKeywords.'TestObjectHelper.setDropDownValue'('new_attendee_with_child--child_gender', 'Female')

CustomKeywords.'TestObjectHelper.setDropDownValue'('new_attendee_with_child--child_grade', 'Grade 1')

'Open drawer to search for attendees'
WebUI.click(findTestObject('HC-Web/Event/Check In/Add Attendee Drawer/New Person Drawer/Save New Person Button'), FailureHandling.STOP_ON_FAILURE)

'Click button to check in and print labels'
WebUI.click(findTestObject('HC-Web/Event/Check In/Check In and Print Labels Button'))

WebUI.click(findTestObject('HC-Web/Event/Check In/Confirm Check In Button'))

'If the child is out of the age range for the room, click button to check them in anyway'
if (WebUI.waitForElementPresent(findTestObject('Object Repository/HC-Web/Event/Check In/Check In Child Anyway Button'), 
    5)) {
    WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/Check In Child Anyway Button'))
}

'Verify that the child was added to the attendee list'
WebUI.verifyElementText(findTestObject('HC-Web/Event/Check In/Attendee Names', [('AttendeeName') : ChildName]), ChildName)

'Select all attendee checkboxes'
WebUI.click(findTestObject('HC-Web/Event/Check In/Attendee Checkboxes', [('AttendeeName') : ChildName]))

'Check out all attendees'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/Checkout Button'))

'Confirm check out'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/Checkout Confirmation Yes Button'))

'Verify attendees were removed from the list'
WebUI.verifyElementNotPresent(findTestObject('HC-Web/Event/Check In/Attendee Names', [('AttendeeName') : ChildName]), 3)

WebUI.waitForElementVisible(findTestObject('HC-Web/Event/Check In/Close Space Button'), 3)

WebUI.waitForElementClickable(findTestObject('HC-Web/Event/Check In/Close Space Button'), 3)

'Close space'
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

