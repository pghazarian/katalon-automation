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
import com.detroitlabs.katalonmobileutil.device.App as App
import com.detroitlabs.katalonmobileutil.device.Device as Device
import com.detroitlabs.katalonmobileutil.testobject.Finder as Finder
import com.detroitlabs.katalonmobileutil.testobject.Button as Button
import com.detroitlabs.katalonmobileutil.testobject.TextField as TextField
import com.detroitlabs.katalonmobileutil.touch.Swipe as Swipe
import com.detroitlabs.katalonmobileutil.touch.Swipe.SwipeDirection as SwipeDirection

def timeout = 3

def journeyId = 508

def allowJourneyWalkthrough = false

'Open existing app by the app bundle id'
Mobile.callTestCase(findTestCase('Companion App/Shared/Login'), [('UserName') : GlobalVariable.Admin2_UserName, ('Password') : GlobalVariable.Admin2_Password], 
    FailureHandling.STOP_ON_FAILURE)

'Navigate to Journey'
Button.tap('Nav/Journey Navigation Button', timeout)

'Verify that the Header is present'
Mobile.verifyElementVisible(Finder.findLabel('Journey Heading'), timeout)

if (allowJourneyWalkthrough) {
    'Click Link for the Journey Walkthrough'
    Button.tap(Finder.findLink('What is a Journey Link'), timeout)

    'Do the walkthrough of the Journey'

    'Verify text on page 1'
    Mobile.verifyElementVisible(Finder.findLabel('Walkthough Page 1 Heading'), timeout)

    'Swipe'
    Swipe.swipe(SwipeDirection.RIGHT_TO_LEFT)

    'Verify text on page 2'
    Mobile.verifyElementVisible(Finder.findLabel('Walkthough Page 2 Heading'), timeout)

    'Swipe'
    Swipe.swipe(SwipeDirection.RIGHT_TO_LEFT)

    'Verify text on page 3'
    Mobile.verifyElementVisible(Finder.findLabel('Walkthough Page 3 Heading'), timeout)

    'Click Browse Journeys Button'
    Button.tap('Journey/Browse Journeys')
}

'Verify that there are search results'

Button.tap('Journey/Date Go Back', timeout)

Button.tap('Journey/Date Go Back', timeout)

Button.tap('Journey/Date Go Back', timeout)

Button.tap('Journey/Date Go Forward', timeout)

Button.tap('Journey/Go to Today View', timeout)

//'Click on the Journey record that we are finding'
//Mobile.tap(findTestObject('Companion App/Journey Entry By Id Match', [('id') : journeyId]), timeout)
//
//Mobile.verifyElementVisible(Finder.findLabel('Journey/Details/Description'), timeout)
//
//Mobile.verifyElementVisible(Finder.findLabel('Journey/Details/Heading'), timeout)
//
//Mobile.verifyElementVisible(Finder.findLabel('Journey/Details/Subtitle'), timeout)
//
//'Swipe'
//Swipe.swipe(SwipeDirection.BOTTOM_TO_TOP)
//
//'Start Journey'
//Mobile.verifyElementVisible(Finder.findButton('Journey/Details/Start Journey'), timeout)
//
//Mobile.tap(Finder.findButton('Journey/Details/Start Journey'), timeout)
//
//Mobile.verifyElementVisible(Finder.findLabel('Journey/Details/Journey In Progress Status'), timeout)
//
//Mobile.verifyElementVisible(Finder.findButton('Journey/Details/See Journey Pathway'), timeout)
//
//Mobile.verifyElementVisible(Finder.findButton('Journey/Details/Stop Pathway'), timeout)
//
//'Stop Journey with No Prompt'
//Mobile.tap(Finder.findButton('Journey/Details/Stop Journey'), timeout)
//
//Mobile.tap(Finder.findButton('Journey/Details/Prompt Stop Journey No'), timeout)
//
//Mobile.verifyElementVisible(Finder.findLabel('Journey/Details/Journey In Progress Status'), timeout)
//
//'Stop Journey with Yes Prompt'
//Mobile.tap(Finder.findButton('Journey/Details/Stop Journey'), timeout)
//
//Mobile.tap(Finder.findButton('Journey/Details/Prompt Stop Journey Yes'), timeout)
//
//'See the Popup'
//Mobile.verifyElementVisible(Finder.findLabel('Popup/Body'), timeout)
//
//Mobile.verifyElementVisible(Finder.findLabel('Popup/Title'), timeout)
//
//'Close the Popup'
//Mobile.tap(Finder.findButton('Popup/Close'), timeout)
//
//'Verify the Journey is not in progress'
//Mobile.verifyElementNotVisible(Finder.findLabel('Journey/Details/Journey In Progress Status'), timeout)
//
//'Close the Journey'
//Mobile.tap(Finder.findButton('Journey/Details/Journey Close Top'), timeout)

