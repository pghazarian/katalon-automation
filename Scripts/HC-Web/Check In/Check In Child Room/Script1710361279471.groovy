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

'Navigate to occurrence schedule'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Occurrence Schedule/Occurrence Schedule Tab'))

'Open check in'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Occurrence Schedule/Check In Button'))

'Select first room designated for children in list'
WebUI.click(findTestObject('HC-Web/Event/Check In/Second Room'))

'If event has not started, open room early'
if (!(WebUI.findWebElements(findTestObject('Object Repository/HC-Web/Event/Check In/Open Room Early Yes Button'), 5, FailureHandling.CONTINUE_ON_FAILURE).isEmpty())) {
    WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/Open Room Early Yes Button'))
}

'If room has not been opened, open a child room and add volunteers'
if (!(WebUI.findWebElements(findTestObject('Object Repository/HC-Web/Event/Check In/General Room Button'), 5, FailureHandling.CONTINUE_ON_FAILURE).isEmpty())) {
    'Select child room'
    WebUI.click(findTestObject('HC-Web/Event/Check In/Child Room Button'))

    'Open volunteer page'
    WebUI.click(findTestObject('HC-Web/Event/Check In/Find Volunteers Button'))

    'Switch to person search'
    CustomKeywords.'customUtility.FormHelper.setMultipleChoiceControlValueByXPath'('//div[contains(@class,\'radio-pill\')]', 
        'Person Search')

    'Search for volunteers'
    WebUI.setText(findTestObject('HC-Web/Event/Check In/Volunteer Person Search Bar'), VolunteerSearchName + Keys.chord(
            Keys.ENTER))

    'Add volunteer from search results'
    WebUI.click(findTestObject('HC-Web/Event/Check In/Add and Check In Button'), FailureHandling.STOP_ON_FAILURE)

    'If volunteer is not signed up for event, add them anyway'
    if (!(WebUI.findWebElements(findTestObject('Object Repository/HC-Web/Event/Check In/Add and Proceed Button'), 5, FailureHandling.CONTINUE_ON_FAILURE).isEmpty())) {
        WebUI.click(findTestObject('HC-Web/Event/Check In/Add and Proceed Button'))
    }
    
    'Add a second volunteer from search results'
    WebUI.click(findTestObject('HC-Web/Event/Check In/Add and Check In Button'), FailureHandling.STOP_ON_FAILURE)

    'If volunteer is not signed up for event, add them anyway'
    if (!(WebUI.findWebElements(findTestObject('Object Repository/HC-Web/Event/Check In/Add and Proceed Button'), 5, FailureHandling.CONTINUE_ON_FAILURE).isEmpty())) {
        WebUI.click(findTestObject('HC-Web/Event/Check In/Add and Proceed Button'))
    }
    
    'Finish adding volunteers and return to check in'
    WebUI.click(findTestObject('HC-Web/Event/Check In/Volunteer Page Done Button'))

    'Open space with selected volunteers'
    WebUI.click(findTestObject('HC-Web/Event/Check In/Volunteer Page Open Space Button'))
}

'Open drawer to search for attendees'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/Search or Add Button'))

'Search for parent of attendee'
WebUI.setText(findTestObject('Object Repository/HC-Web/Event/Check In/Attendee Search Bar'), ParentName)

WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Event/Check In/Attendee Search Bar'), Keys.chord(Keys.ENTER))

'Select parent of attendee from list'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/Attendee Search Results'))

'Select a child to attend'
WebUI.click(findTestObject('HC-Web/Event/Check In/Related Child Card'))

'Click button to check in and print labels'
WebUI.click(findTestObject('HC-Web/Event/Check In/Check In and Print Labels Button'))

WebUI.click(findTestObject('HC-Web/Event/Check In/Confirm Check In Button'))

'If the child is out of the age range for the room, click button to check them in anyway'
if (!(WebUI.findWebElements(findTestObject('Object Repository/HC-Web/Event/Check In/Check In Child Anyway Button'), 5, FailureHandling.CONTINUE_ON_FAILURE).isEmpty())) {
    WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/Check In Child Anyway Button'))
}

'Verify that the child was added to the attendee list'
WebUI.verifyElementText(findTestObject('HC-Web/Event/Check In/Child Room Attendee Names'), ChildName)

'Select all attendee checkboxes'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/Attendee Checkboxes'))

'Check out all attendees'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/Checkout Button'))

'Confirm check out'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/Checkout Confirmation Yes Button'))

'Verify attendees were removed from the list'
WebUI.verifyElementNotPresent(findTestObject('HC-Web/Event/Check In/Attendee Names'), 5)

'Close space'
WebUI.click(findTestObject('HC-Web/Event/Check In/Close Space Button'))

WebUI.click(findTestObject('HC-Web/Event/Check In/Close Space Confirmation Yes Button'))

WebUI.closeBrowser()

