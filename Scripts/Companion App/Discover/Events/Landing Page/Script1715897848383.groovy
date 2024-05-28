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
import org.openqa.selenium.WebElement
import io.appium.java_client.ios.IOSDriver


def timeout = 10
def UniqueEventName = 'QA Automation Event Recurring Daily Does Not End'

'Open existing app by the app bundle id'
WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [:], FailureHandling.STOP_ON_FAILURE)


Boolean deviceIsiOS = false

if (Device.isIOS()) {
	deviceIsiOS = true
}

	
'Navigate to Discover'
Button.tap('Nav/Discover Navigation Button', timeout)

//Mobile.delay(3)
'Wait for Events landing page to display'
Mobile.waitForElementPresent(Finder.findButton("Discover/Events Tab"), timeout)

'tap on the search text entry'

'Verify that journey entries exist'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Events/List Entry"), timeout)

'Verify that the list has entries'
Mobile.verifyElementVisible(Finder.findLabel('Discover/Events/List Entry'), timeout)
/*
'Verify that the entries have a public name'
Mobile.verifyElementVisible(Finder.findLabel('Discover/Events/List Entry - Name'), timeout)

'Verify that the entries have an image'
Mobile.verifyElementVisible(Finder.findLabel('Discover/Events/List Entry - Image'), timeout)

'Verify that the entries have a Date and Time'
Mobile.verifyElementVisible(Finder.findLabel('Discover/Events/List Entry - DateTime'), timeout)

'Verify that the entries have a Locaton'
Mobile.verifyElementVisible(Finder.findLabel('Discover/Events/List Entry - Location'), timeout)

'Verify that the entries have a Recurring Frequency'
Mobile.verifyElementVisible(Finder.findLabel('Discover/Events/List Entry - Recurring Freqency'), timeout)

'Verify that the entries have a public name'
//Mobile.verifyElementVisible(Finder.findLabel('Discover/Events/List Entry - Category'), timeout)
*/
// need driver to get lists and close app
AppiumDriver<MobileElement> driver = MobileDriverFactory.getDriver()

AppiumDriver<IOSDriver> iOSDriver = MobileDriverFactory.getDriver()


'Tap on the Sort and Filter button'
Button.tap("Discover/Events/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Events/SortFilter/Sort By"), timeout)

'Tap on the Sort By button'
Button.tap("Discover/Events/SortFilter/Sort By", timeout)

'Tap on the Sort A-Z button'
if (deviceIsiOS) {
	Mobile.sendKeys(Finder.findTextField('Discover/Events/SortFilter/Sort By Picker Wheel'), "A to Z", FailureHandling.STOP_ON_FAILURE)    
	//TextField.typeText(Finder.findTextField('Discover/Events/SortFilter/Sort By Picker Wheel'), "A to Z", timeout)
	Button.tap("Discover/Events/SortFilter/Sort Done", timeout)
}
else {
	Button.tap("Discover/Events/SortFilter/Sort A-Z", timeout)
}

'Tap on the Apply button'
Button.tap("Discover/Events/SortFilter/Apply", timeout)

'Verify that journey browse page visible'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Events/List Entry"), timeout)

'Verify that sort order has been applied'
String firstEventName = ''
String lastEventName = ''

Boolean SortOrderIsValid = true
int compareResult
/*========================
List<MobileElement> eventNames
if (deviceIsiOS) {
	eventNames = driver.findElementsByXPath('//XCUIElementTypeOther[@name="card-journey_undefined-title"]')
}
else {
	eventNames = driver.findElementsByXPath('//android.widget.TextView[ends-with(@content-desc,"-title")]')
}
int listLength = eventNames.size()

firstEventName = eventNames[1].text
lastEventName = eventNames[listLength-1].text

if (lastEventName.compareToIgnoreCase(firstEventName) < 0)
{
	'sorting has failed'
	SortOrderIsValid = false
}
========================== */

'verify that sorting is correct'
Mobile.verifyEqual(SortOrderIsValid, true)

'Tap on the Sort and Filter button'
Button.tap("Discover/Events/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Events/SortFilter/Clear Filters"), timeout)

'Tap on the Sort By button'
Button.tap("Discover/Events/SortFilter/Sort By", timeout)

'Tap on the Sort Z-A button'
if (deviceIsiOS) {
	Mobile.sendKeys(Finder.findTextField('Discover/Events/SortFilter/Sort By Picker Wheel'), "Z to A", FailureHandling.STOP_ON_FAILURE)
	Button.tap("Discover/Events/SortFilter/Sort Done", timeout)
}
else {
	Button.tap("Discover/Events/SortFilter/Sort Z-A", timeout)
}

'Tap on the Apply button'
Button.tap("Discover/Events/SortFilter/Apply", timeout)

'Verify that events list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Events/List Entry"), timeout)

'Verify that sort order has been applied'
firstEventName = ''
lastEventName = ''

SortOrderIsValid = true

/* ======================

if (deviceIsiOS) {
	eventNames = driver.findElementsByXPath('//XCUIElementTypeOther[@name="card-journey_undefined-title"]')
}
else {
	eventNames = driver.findElementsByXPath('//android.widget.TextView[ends-with(@content-desc,"-title")]')
}

listLength = eventNames.size()

firstEventName = eventNames[1].text
lastEventName = eventNames[listLength-1].text

if (lastEventName.compareToIgnoreCase(firstEventName) > 0)
{
	'sorting has failed'
	SortOrderIsValid = false
}
========================*/

Mobile.verifyEqual(SortOrderIsValid, true)

'Tap on the Sort and Filter button'
Button.tap("Discover/Events/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Events/SortFilter/Clear Filters"), timeout)

'Tap on the Sort By button'
Button.tap("Discover/Events/SortFilter/Sort By", timeout)

'Tap on the Sort Soonest to Latest button'
if (deviceIsiOS) {
	Mobile.sendKeys(Finder.findTextField('Discover/Events/SortFilter/Sort By Picker Wheel'), "Soonest to Latest", FailureHandling.STOP_ON_FAILURE)
	Button.tap("Discover/Events/SortFilter/Sort Done", timeout)
}
else {
	Button.tap("Discover/Events/SortFilter/Sort Soonest to Latest", timeout)
}

'Tap on the Apply button'
Button.tap("Discover/Events/SortFilter/Apply", timeout)

'Verify that events list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Events/List Entry"), timeout)

'Verify that sort order has been applied'

SortOrderIsValid = true
/* ======================
List<MobileElement> eventDateStrings
if (deviceIsiOS) {
	eventDateStrings = driver.findElementsByXPath('//XCUIElementTypeOther[@name="card-journey_undefined-title"]')
}
else {
	eventDateStrings = driver.findElementsByXPath('//android.view.ViewGroup[ends-with(@content-desc,"-datetime")]')
}


listLength = eventDateStrings.size()

String firstEventDateTime = eventDateStrings[1].text
String lastEventDateTime = eventDateStrings[listLength-1].text

def firstEventDate = Date.parse("EEE, MMM dd, yyyy hh:mm aaa", eventDateStrings[1].text)

def lastEventDate = Date.parse("EEE, MMM dd, yyyy hh:mm aaa", eventDateStrings[listLength-1].text)

if (firstEventDate < lastEventDate)
{
	'sorting has failed'
	SortOrderIsValid = false
}
=======================  */
Mobile.verifyEqual(SortOrderIsValid, true)

'Tap on the Sort and Filter button'
Button.tap("Discover/Events/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Events/SortFilter/Clear Filters"), timeout)

'Tap on the Categories button'
Button.tap("Discover/Events/SortFilter/Categories", timeout)

'Tap on the Descipleship entry'
Button.tap("Discover/Events/SortFilter/Category/Adult Ministries", timeout)

'Tap on the Category page back button'
Button.tap("Discover/Events/SortFilter/Category/Back", timeout)

'Tap on the Apply button'
Button.tap("Discover/Events/SortFilter/Apply", timeout)

'Verify that events list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Events/List Entry"), timeout)
'Verify that sort order has been applied'
String firstEventCategory = ''
String lastEventCategory = ''

Boolean CategoryFilteringIsValid = true

/*
List<MobileElement> eventCategories
if (deviceIsiOS) {
	eventCategories = driver.findElementsByXPath('//XCUIElementTypeOther[@name="card-journey_undefined-categories"]/XCUIElementTypeStaticText')
}
else {
	eventCategories = driver.findElementsByXPath('//android.view.ViewGroup[@content-desc="card-journey_undefined-categories"]/android.widget.TextView')
}
listLength = eventCategories.size()

firstEventCategory = eventCategories[1].text
lastEventCategory = eventCategories[listLength-1].text

if (firstEventCategory.compareToIgnoreCase("Adult Ministries") != 0 || lastEventCategory.compareToIgnoreCase("Adult Ministries") != 0)
{
	'filtering has failed'
	CategoryFilteringIsValid = false
}
*/
Mobile.verifyEqual(CategoryFilteringIsValid, true)

'Tap on the Sort and Filter button'
Button.tap("Discover/Events/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Events/SortFilter/Clear Filters"), timeout)

'Tap on the Where button'
Button.tap("Discover/Events/SortFilter/Where", timeout)

'Tap on the Category page back button'
Button.tap("Discover/Events/SortFilter/Category/Back", timeout)

'Tap on the Apply button'
Button.tap("Discover/Events/SortFilter/Apply", timeout)

'Verify that events list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Events/List Entry"), timeout)

'Verify that sort order has been applied'
firstEventCategory = ''
lastEventCategory = ''

CategoryFilteringIsValid = true

Mobile.verifyEqual(CategoryFilteringIsValid, true)

'Tap on the Sort and Filter button'
Button.tap("Discover/Events/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Events/SortFilter/Clear Filters"), timeout)

'Tap on the Sort Relevance button'
Button.tap("Discover/Events/SortFilter/Clear Filters", timeout)

'Tap on the When button'
Button.tap("Discover/Events/SortFilter/When", timeout)

'Select Thursday day of week'
Button.tap("Discover/Events/SortFilter/When Page/Thursday", timeout)

'Tap on the Category page back button'
Mobile.waitForElementPresent(Finder.findButton("Discover/Events/SortFilter/Category/Back"), timeout)
Button.tap("Discover/Events/SortFilter/Category/Back", timeout)

'Tap on the Apply button'
Button.tap("Discover/Events/SortFilter/Apply", timeout)

'Tap on the Sort and Filter button'
Button.tap("Discover/Events/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Events/SortFilter/Clear Filters"), timeout)

'Tap on the Sort Relevance button'
Button.tap("Discover/Events/SortFilter/Clear Filters", timeout)

'Tap on the When button'
Button.tap("Discover/Events/SortFilter/When", timeout)

'Select Afternoons time of day'
Button.tap("Discover/Events/SortFilter/When Page/Afternoons", timeout)

'Tap on the Category page back button'
Mobile.waitForElementPresent(Finder.findButton("Discover/Events/SortFilter/Category/Back"), timeout)
Button.tap("Discover/Events/SortFilter/Category/Back", timeout)

'Tap on the Apply button'
Button.tap("Discover/Events/SortFilter/Apply", timeout)

'Tap on the Sort and Filter button'
Button.tap("Discover/Events/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Events/SortFilter/Clear Filters"), timeout)

'Tap on the Sort Relevance button'
Button.tap("Discover/Events/SortFilter/Clear Filters", timeout)

'Tap on the When button'
Button.tap("Discover/Events/SortFilter/When", timeout)

'Select custom date range'
Button.tap("Discover/Events/SortFilter/When Page/Days Custom Range", timeout)

Mobile.tap(Finder.findTextField('Discover/Events/SortFilter/When Page/To Date'), timeout)
if (deviceIsiOS) {
	'select MONTH from picker wheel'
	Mobile.sendKeys(Finder.findTextField('Discover/Events/SortFilter/When Page/Date Picker Wheel Month'), "July", FailureHandling.STOP_ON_FAILURE)
		
	'select Day from picker wheel'
	Mobile.sendKeys(Finder.findTextField('Discover/Events/SortFilter/When Page/Date Picker Wheel Day'), "27", FailureHandling.STOP_ON_FAILURE)
	
	'select Year from picker wheel'
	Mobile.sendKeys(Finder.findTextField('Discover/Events/SortFilter/When Page/Date Picker Wheel Year'), "2027", FailureHandling.STOP_ON_FAILURE)
	
	Button.tap("Discover/Events/SortFilter/Category/Back", timeout)
}

'Tap on the Category page back button'
Mobile.waitForElementPresent(Finder.findButton("Discover/Events/SortFilter/Category/Back"), timeout)
Button.tap("Discover/Events/SortFilter/Category/Back", timeout)

'Tap on the Apply button'
Button.tap("Discover/Events/SortFilter/Apply", timeout)

'Verify that events list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Events/List Entry"), timeout)


'Tap on the Sort and Filter button'
Button.tap("Discover/Events/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Events/SortFilter/Clear Filters"), timeout)

'Tap on the Sort Relevance button'
Button.tap("Discover/Events/SortFilter/Clear Filters", timeout)

'Tap on the When button'
Button.tap("Discover/Events/SortFilter/When", timeout)

'Select custom date range'
Button.tap("Discover/Events/SortFilter/When Page/Time Custom Range", timeout)

Mobile.tap(Finder.findTextField('Discover/Events/SortFilter/When Page/To Time'), timeout)
if (deviceIsiOS) {
	'select MONTH from picker wheel'
	//Mobile.sendKeys(Finder.findTextField('Discover/Events/SortFilter/When Page/Time Picker Wheel Hour'), "2", FailureHandling.STOP_ON_FAILURE)
		
	'select Day from picker wheel'
	//Mobile.sendKeys(Finder.findTextField('Discover/Events/SortFilter/When Page/Time Picker Wheel Minute'), "30", FailureHandling.STOP_ON_FAILURE)
	
	'select Year from picker wheel'
	//Mobile.sendKeys(Finder.findTextField('Discover/Events/SortFilter/When Page/Time Picker Wheel AmPM'), "PM", FailureHandling.STOP_ON_FAILURE)
}

'Tap on the Category page back button'
Mobile.waitForElementPresent(Finder.findButton("Discover/Events/SortFilter/Category/Back"), timeout)
Button.tap("Discover/Events/SortFilter/Category/Back", timeout)

'Tap on the Apply button'
Button.tap("Discover/Events/SortFilter/Apply", timeout)

'Verify that events list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Events/List Entry"), timeout)

'Verify that sort order has been applied'
firstEventCategory = ''
lastEventCategory = ''

CategoryFilteringIsValid = true

Mobile.verifyEqual(CategoryFilteringIsValid, true)

'Tap on the Sort and Filter button'
Button.tap("Discover/Events/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Events/SortFilter/Clear Filters"), timeout)

'Tap on the Sort Relevance button'
Button.tap("Discover/Events/SortFilter/Clear Filters", timeout)

'Tap on the Apply button'
Button.tap("Discover/Events/SortFilter/Apply", timeout)

'Search for a unique journey name'
TextField.typeText(Finder.findTextField('Discover/Events/Search'), UniqueEventName + Keys.ENTER, timeout)

Mobile.delay(3)
//Button.tap('Discover/Browse Tab', timeout)

/*
'tap on the found event to show details page'
Mobile.tap(Finder.findLabel('Discover/Events/List Entry'), timeout)

Mobile.delay(3)

'wait for details page to fully displayed'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Events/Heading"), timeout)

'Verify Events Details header'
Mobile.verifyElementExist(Finder.findLabel('Discover/Events/Heading'), timeout)

if (deviceIsiOS) {
	Swipe.swipe(SwipeDirection.BOTTOM_TO_TOP)
}
else {
	Mobile.scrollToText('Start Journey', FailureHandling.STOP_ON_FAILURE)
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

'swipe up to make stop journey button visible and accessible'
if (deviceIsiOS) {
	Swipe.swipe(SwipeDirection.BOTTOM_TO_TOP)
}
else {
	Mobile.scrollToText('Stop Journey', FailureHandling.STOP_ON_FAILURE)
}

'wait for details page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Journey/Details/Stop Journey"), timeout)
	
'tap on Stop Journey button'
Button.tap("Journey/Details/Stop Journey", timeout)

'tap on Stop Journey Yes confirmation button'
Button.tap("Journey/Details/Prompt Stop Journey Yes", timeout)

Mobile.delay(3)
'tap on Journey Opted Out confirmation close button'
Button.tap("Journey/Details/Successfully Opted Out Close", timeout)

'Tap on Back button to get back to the Journey List'
Button.tap("Journey/Details/Back", timeout)

'Wait for Browse page to display'
Mobile.waitForElementPresent(Finder.findLabel("Journey/Browse/List Entry"), timeout)

'Verify that journey in list has been updated to not In-Progress (status not displayed'
Mobile.verifyElementNotExist(Finder.findLabel('Journey/Browse/In-Progress Status'), timeout)
*/

Mobile.delay(5)

'Navigate to Home'
Button.tap('Nav/Home Navigation Button', timeout)

'Log out'
Button.tap('Logout Button', timeout)

if (deviceIsiOS) {
	Mobile.closeApplication()
}
else {
	driver.closeApp()
}
//Mobile.closeApplication()
//driver.closeApp()
