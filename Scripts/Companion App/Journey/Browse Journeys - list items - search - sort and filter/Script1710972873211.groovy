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
import com.kms.katalon.util.CryptoUtil as CryptoUtil

import com.detroitlabs.katalonmobileutil.device.App
import com.detroitlabs.katalonmobileutil.device.Device
import com.detroitlabs.katalonmobileutil.testobject.Finder
import com.detroitlabs.katalonmobileutil.testobject.Button
import com.detroitlabs.katalonmobileutil.testobject.TextField
import com.detroitlabs.katalonmobileutil.touch.Swipe as Swipe
import com.detroitlabs.katalonmobileutil.touch.Swipe.SwipeDirection as SwipeDirection
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement
import com.kms.katalon.core.testobject.TestObjectXpath

/*
 1. Launch Companion App
 2. Log into Companion App with a user who has journeys not started, in progress and completed statuses 
 		and authored some unpublished journeys under HC Back Office.
 3. Tap on Journey Navigation button
 4. Tap on the Browse Journeys tab 
 5. Verify a list of all published journeys is listed and item content is correct
 6. Tap on Journey that has not been started
 7. Verify that the Journey Details are as defined and Start Journey button is displayed
 8. Tap on Back button to get back to the Journey List
 9. Tap on a Journey that is in progress
 10. Verify that the Journey Details are as defined with In Progress status text and View Pathway and Stop Journey Buttons are displayed.
 11. Tap on Back button to get back to the Journey List
 12. Tap on a Journey that has been completed
 13. Verify that the Journey Details are as defined with Completed status text and only View Pathway Button is displayed
 14. Tap on Back button to get back to the Journey List
 15. Verify that there are unpublished journeys that the logged in user has authored
 16. Tap on one of the unpublished journeys.
 17. Verify that the Journey Details are as defined proper content.
 14. close the app
 */


def timeout = 3
def UniqueJourneyName = GlobalVariable.JourneySearch_SearchTerm  //'21 DAYS OF PRAYER & FASTING'

'Open existing app by the app bundle id'
//WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), ['UserName':'markh@saddleback.com', 'Password':(CryptoUtil.encode(CryptoUtil.getDefault('P@$$w0rd!')))], FailureHandling.STOP_ON_FAILURE)
WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate to Journey'
Button.tap('Nav/Journey Navigation Button', timeout)

Mobile.delay(3)
'Wait for Journey landing page to display'
Mobile.waitForElementPresent(Finder.findButton("Journey/Browse Tab"), timeout)

'Tap on the Browse Journeys tab'
Button.tap('Journey/Browse Tab', timeout)

'Verify that journey entries exist'
Mobile.waitForElementPresent(Finder.findLabel("Journey/Browse/List Entry"), timeout)
//*
'Verify that the list has entries'
Mobile.verifyElementVisible(Finder.findLabel('Journey/Browse/List Entry'), timeout)

'Verify that the entries have a public name' 
Mobile.verifyElementVisible(Finder.findLabel('Journey/Browse/List Entry - Public Name'), timeout)

'Verify that the entries have an image'
Mobile.verifyElementVisible(Finder.findLabel('Journey/Browse/List Entry - Image'), timeout)

'Verify that the entries have a subtitle'
Mobile.verifyElementVisible(Finder.findLabel('Journey/Browse/List Entry - Subtitle'), timeout)

'Verify that the entries have a public name'
Mobile.verifyElementVisible(Finder.findLabel('Journey/Browse/List Entry - Category'), timeout)

'Tap on the Sort and Filter button'
Button.tap("Journey/Browse/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Journey/Browse/SortFilter/Sort By"), timeout)

'Tap on the Sort By button'
Button.tap("Journey/Browse/SortFilter/Sort By", timeout)

Mobile.waitForElementPresent(Finder.findButton("Journey/Browse/SortFilter/Sort Relevance"), timeout)

'Tap on the Sort A-Z button'
if (Device.isIOS()) {
	TextField.typeText(Finder.findTextField('Journey/Browse/SortFilter/Sort By Picker Wheel'), "Journey Name (A - Z)", timeout)
	Button.tap("Journey/Browse/SortFilter/Sort Done", timeout)
}
else {
	Button.tap("Journey/Browse/SortFilter/Sort A-Z", timeout)
}

'Tap on the Apply button'
Button.tap("Journey/Browse/SortFilter/Apply", timeout)

'Verify that journey browse page visible'
Mobile.waitForElementPresent(Finder.findLabel("Journey/Browse/List Entry"), timeout)

'Verify that sort order has been applied'
AppiumDriver<MobileElement> driver = MobileDriverFactory.getDriver()

String firstJourneyName = ''
String lastJourneyName = ''

Boolean SortOrderIsValid = true
int compareResult

List<MobileElement> journeyPublicNames
if (Device.isIOS()) {
	journeyPublicNames = driver.findElementsByXPath('//XCUIElementTypeOther[@name="card-journey_undefined-title"]')
}
else {
	journeyPublicNames = driver.findElementsByXPath('//android.view.ViewGroup[@content-desc="card-journey_undefined-title"]/android.widget.TextView')
}      
int listLength = journeyPublicNames.size()

firstJourneyName = journeyPublicNames[1].text
lastJourneyName = journeyPublicNames[listLength-1].text

if (lastJourneyName.compareToIgnoreCase(firstJourneyName) < 0)
{
	'sorting has failed'
	SortOrderIsValid = false
}

'verify that sorting is correct'
Mobile.verifyEqual(SortOrderIsValid, true)

'Tap on the Sort and Filter button'
Button.tap("Journey/Browse/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Journey/Browse/SortFilter/Clear Filters"), timeout)

'Tap on the Sort By button'
Button.tap("Journey/Browse/SortFilter/Sort By", timeout)

Mobile.waitForElementPresent(Finder.findButton("Journey/Browse/SortFilter/Sort Relevance"), timeout)

'Tap on the Sort Z-A button'
if (Device.isIOS()) {
	TextField.typeText(Finder.findTextField('Journey/Browse/SortFilter/Sort By Picker Wheel'), "Journey Name ( Z - A )", timeout)
	Button.tap("Journey/Browse/SortFilter/Sort Done", timeout)
}
else {
	Button.tap("Journey/Browse/SortFilter/Sort Z-A", timeout)
}

'Tap on the Apply button'
Button.tap("Journey/Browse/SortFilter/Apply", timeout)

'Verify that journey browse page visible'
Mobile.waitForElementPresent(Finder.findLabel("Journey/Browse/List Entry"), timeout)

'Verify that sort order has been applied'
firstJourneyName = ''
lastJourneyName = ''

SortOrderIsValid = true

if (Device.isIOS()) {
	journeyPublicNames = driver.findElementsByXPath('//XCUIElementTypeOther[@name="card-journey_undefined-title"]')
}
else {
	journeyPublicNames = driver.findElementsByXPath('//android.view.ViewGroup[@content-desc="card-journey_undefined-title"]/android.widget.TextView')
} 
listLength = journeyPublicNames.size()

firstJourneyName = journeyPublicNames[1].text
lastJourneyName = journeyPublicNames[listLength-1].text

if (lastJourneyName.compareToIgnoreCase(firstJourneyName) > 0)
{
	'sorting has failed'
	SortOrderIsValid = false
}

Mobile.verifyEqual(SortOrderIsValid, true)

'Tap on the Sort and Filter button'
Button.tap("Journey/Browse/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Journey/Browse/SortFilter/Clear Filters"), timeout)
Button.tap("Journey/Browse/SortFilter/Clear Filters", timeout)

'Tap on the Categories button'
Button.tap("Journey/Browse/SortFilter/Categories", timeout)

'Tap on the Descipleship entry'
Button.tap("Journey/Browse/SortFilter/Category/Discipleship", timeout)

'Tap on the Category page back button'
Button.tap("Journey/Browse/SortFilter/Category/Back", timeout)

'Tap on the Apply button'
Button.tap("Journey/Browse/SortFilter/Apply", timeout)

'Verify that journey browse page visible'
Mobile.waitForElementPresent(Finder.findLabel("Journey/Browse/List Entry"), timeout)

'Verify that sort order has been applied'
String firstJourneyCategory = ''
String lastJourneyCategory = ''

Boolean CategoryFilteringIsValid = true

List<MobileElement> journeyCategories
if (Device.isIOS()) {
	journeyCategories = driver.findElementsByXPath('//XCUIElementTypeOther[@name="card-journey_undefined-categories"]/XCUIElementTypeStaticText')      
}
else {
	journeyCategories = driver.findElementsByXPath('//android.view.ViewGroup[@content-desc="card-journey_undefined-categories"]/android.widget.TextView')      
}
listLength = journeyCategories.size()

firstJourneyCategory = journeyCategories[1].text
lastJourneyCategory = journeyCategories[listLength-1].text

if (firstJourneyCategory.compareToIgnoreCase("Discipleship") != 0 || lastJourneyCategory.compareToIgnoreCase("Discipleship") != 0)
{
	'filtering has failed'
	CategoryFilteringIsValid = false
}

Mobile.verifyEqual(CategoryFilteringIsValid, true)

'Tap on the Sort and Filter button'
Button.tap("Journey/Browse/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Journey/Browse/SortFilter/Clear Filters"), timeout)

'Tap on the Sort Relevance button'
Button.tap("Journey/Browse/SortFilter/Clear Filters", timeout)

'Tap on the Apply button'
Button.tap("Journey/Browse/SortFilter/Apply", timeout)

'Search for a unique journey name' 
TextField.typeText(Finder.findTextField('Journey/Browse/Search'), UniqueJourneyName + Keys.ENTER, timeout)

'tap on the found journey to show details page'
Mobile.tap(Finder.findLabel('Journey/Browse/List Entry'), timeout)

'wait for details page to fully displayed'
Mobile.waitForElementPresent(Finder.findLabel("Journey/Details/Heading"), timeout)

'Verify Journey Details header'
Mobile.verifyElementExist(Finder.findLabel('Journey/Details/Heading'), timeout)

'wait for details page to fully displayed'
if (Mobile.verifyElementVisible(Finder.findButton("Journey/Details/Stop Journey"), timeout, FailureHandling.OPTIONAL)) {
	'tap on Stop Journey button'
	Button.tap("Journey/Details/Stop Journey", timeout)
	
	'tap on Stop Journey Yes confirmation button'
	Mobile.waitForElementPresent(Finder.findButton("Journey/Details/Prompt Stop Journey Yes"), timeout)
	Button.tap("Journey/Details/Prompt Stop Journey Yes", timeout)

	'tap on Journey Opted Out confirmation close button'
	Mobile.waitForElementPresent(Finder.findButton("Journey/Details/Successfully Opted Out Close"), timeout)
	Button.tap("Journey/Details/Successfully Opted Out Close", timeout)
	
	'Tap on Back button to get back to the Journey List'
	Button.tap("Journey/Details/Back", timeout)
		
	'tap on the found journey to show details page'
	Mobile.tap(Finder.findLabel('Journey/Browse/List Entry'), timeout)
}

'tap Start button'
Button.tap("Journey/Details/Start Journey", timeout)

Mobile.waitForElementPresent(Finder.findLabel("Journey/Pathway View/Pathway Header"), timeout)

'tap on the back button from pathway view page'
Button.tap("Journey/Pathway View/Back", timeout)

'wait for details page to fully displayed'
Mobile.waitForElementPresent(Finder.findLabel("Journey/Details/Heading"), timeout)

'Verify that the Journey Browse are as defined with In Progress status text and View Pathway and Stop Journey Buttons are displayed.'
Mobile.verifyElementExist(Finder.findLabel('Journey/Details/Journey In Progress Status'), timeout)

'Tap on Back button to get back to the Journey List'
Button.tap("Journey/Details/Back", timeout)

'Wait for Browse page to display'
Mobile.waitForElementPresent(Finder.findLabel("Journey/Browse/List Entry"), timeout)

'Verify that journey in list has been updated to In-Progress'
Mobile.verifyElementExist(Finder.findLabel('Journey/Browse/In-Progress Status'), timeout)

'tap on the started journey to show details page'
Mobile.tap(Finder.findLabel('Journey/Browse/List Entry'), timeout)

'wait for details page to fully displayed'
Mobile.waitForElementPresent(Finder.findLabel("Journey/Details/Heading"), timeout)

'wait for details page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Journey/Details/Stop Journey"), timeout)
	
'tap on Stop Journey button'
Button.tap("Journey/Details/Stop Journey", timeout)

'tap on Stop Journey Yes confirmation button'
Mobile.waitForElementPresent(Finder.findButton("Journey/Details/Prompt Stop Journey Yes"), timeout)
Button.tap("Journey/Details/Prompt Stop Journey Yes", timeout)

'tap on Journey Opted Out confirmation close button'
Mobile.waitForElementPresent(Finder.findButton("Journey/Details/Successfully Opted Out Close"), timeout)
Button.tap("Journey/Details/Successfully Opted Out Close", timeout)

'Tap on Back button to get back to the Journey List'
Button.tap("Journey/Details/Back", timeout)

'Wait for Browse page to display'
Mobile.waitForElementPresent(Finder.findLabel("Journey/Browse/List Entry"), timeout)

'Verify that journey in list has been updated to not In-Progress (status not displayed'
Mobile.verifyElementNotExist(Finder.findLabel('Journey/Browse/In-Progress Status'), timeout)

'Navigate to Home'
Button.tap('Nav/Home Navigation Button', timeout)

'Log out'
Button.tap('Logout Button', timeout)

Mobile.closeApplication()



