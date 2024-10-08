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
def UniqueEventName = GlobalVariable.EventSearch_EventName

boolean CurrentlyLoggedIn = LoggedIn.toBoolean()

if (CurrentlyLoggedIn) {
	'Open existing app by logging into the app bundle id'
	WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [:], FailureHandling.STOP_ON_FAILURE)
} else {
	'Open existing app while logged out by the app bundle id'
	WebUI.callTestCase(findTestCase('Companion App/Shared/Guest Startup'), [:], FailureHandling.STOP_ON_FAILURE)
}

Boolean deviceIsiOS = false

if (Device.isIOS()) {
	deviceIsiOS = true
}

Mobile.delay(3)
Mobile.waitForElementPresent(Finder.findButton('Nav/Discover Navigation Button'), timeout)
	
'Navigate to Discover'
Button.tap('Nav/Discover Navigation Button', timeout)

'Verify that journey entries exist'
Mobile.waitForElementPresent(Finder.findLabel('Discover/Events/List Entry'), timeout)

'Verify that the list has entries'
Mobile.verifyElementVisible(Finder.findLabel('Discover/Events/List Entry'), timeout)
///*
'Verify that the entries have a public name'
Mobile.verifyElementVisible(Finder.findLabel('Discover/Events/List Entry - Name'), timeout)

'Verify that the entries have an image'
Mobile.verifyElementVisible(Finder.findLabel('Discover/Events/List Entry - Image'), timeout)

'Verify that the entries have a Date and Time'
Mobile.verifyElementVisible(Finder.findLabel('Discover/Events/List Entry - Date'), timeout)

'Verify that the entries have a Locaton'
//Mobile.verifyElementVisible(Finder.findLabel('Discover/Events/List Entry - Location'), timeout)

' need driver to get lists and close app'
AppiumDriver<MobileElement> driver = MobileDriverFactory.getDriver()

'Tap on the Sort and Filter button'
Button.tap("Discover/Events/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Events/SortFilter/Sort By"), timeout)

'Tap on the Sort By button'
Button.tap("Discover/Events/SortFilter/Sort By", timeout)

'Tap on the Sort A-Z button'
if (deviceIsiOS) {
	Mobile.sendKeys(Finder.findTextField('Discover/Events/SortFilter/Sort By Picker Wheel'), "A to Z", FailureHandling.STOP_ON_FAILURE)    
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

List<MobileElement> eventNames = MobileTestObjectHelper.getElementList(Finder.findLabel("Discover/Events/List Entry - Name"), driver)

int listLength = eventNames.size()

firstEventName = eventNames[1].text
lastEventName = eventNames[listLength-1].text

if (lastEventName.compareToIgnoreCase(firstEventName) < 0)
{
	'sorting has failed'
	SortOrderIsValid = false
}

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

eventNames = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Discover/Events/List Entry - Name")))
 
listLength = eventNames.size()

firstEventName = eventNames[1].text
lastEventName = eventNames[listLength-1].text

if (lastEventName.compareToIgnoreCase(firstEventName) > 0)
{
	'sorting has failed'
	SortOrderIsValid = false
}

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

List<MobileElement> eventDateStrings
List<MobileElement> eventTimeStrings

eventDateStrings = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Discover/Events/List Entry - Date")))
eventTimeStrings = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Discover/Events/List Entry - Time")))

listLength = eventDateStrings.size()

String tmpTimeString = eventTimeStrings[1].text

def (firstTimeValue1, firstTimeValue2) = tmpTimeString.tokenize('-')

tmpTimeString = eventTimeStrings[listLength-1].text

def (lastTimeValue1, lastTimeValue2) = tmpTimeString.tokenize('-')

String firstEventDateTime = eventDateStrings[1].text + " " + firstTimeValue1    //eventTimeStrings[1].text
String lastEventDateTime = eventDateStrings[listLength-1].text + " " + lastTimeValue1 //eventTimeStrings[listLength-1].text

def firstEventDate = Date.parse("MMM d, yyyy h:mma", firstEventDateTime)

def lastEventDate = Date.parse("MMM d, yyyy h:mma", lastEventDateTime)

if (firstEventDate.after(lastEventDate))
{
	'sorting has failed'
	SortOrderIsValid = false
}

Mobile.verifyEqual(SortOrderIsValid, true)

'Tap on the Sort and Filter button'
Button.tap("Discover/Events/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Events/SortFilter/Clear Filters"), timeout)
Button.tap("Discover/Events/SortFilter/Clear Filters", timeout)

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

List<MobileElement> eventCategories

eventCategories = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Discover/Events/List Entry - Catagory")))

int arrayOfDatesSize = eventCategories.size()

firstEventCategory = eventCategories[3].text

if (firstEventCategory.compareToIgnoreCase(GlobalVariable.EventCategory_Edited) != 0 )
{
	'filtering has failed'
	CategoryFilteringIsValid = false
}

Mobile.verifyEqual(CategoryFilteringIsValid, true)

'Tap on the Sort and Filter button'
Button.tap("Discover/Events/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Events/SortFilter/Clear Filters"), timeout)
Button.tap("Discover/Events/SortFilter/Clear Filters", timeout)

'Tap on the Where button'
Button.tap("Discover/Events/SortFilter/Where", timeout)

' Tap on the Anaheim campus'
Button.tap("Discover/Events/SortFilter/Where Page/Anaheim", timeout)

'Tap on the Category page back button'
Button.tap("Discover/Events/SortFilter/Category/Back", timeout)

'Tap on the Apply button'
Button.tap("Discover/Events/SortFilter/Apply", timeout)

'Verify that events list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Events/List Entry"), timeout)

'go through all the events in the list to make sure they are for selected campus'
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

Mobile.waitForElementPresent(Finder.findLabel("Discover/Events/List Entry - Name"), timeout)

List<MobileElement> eventDaysOfWeek

eventDates = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Discover/Events/List Entry - Date")))

listLength = eventDates.size()

def currentDate

SortOrderIsValid = true

for(int i = 1;i<listLength;i++) {
	currentDateString = eventDates[i].text
	currentDate = Date.parse("MMM d, yyyy", currentDateString)
	
	if (currentDate[Calendar.DAY_OF_WEEK] != Calendar.THURSDAY)
	{
		'sorting has failed'
		SortOrderIsValid = false
	}
}

Mobile.verifyEqual(SortOrderIsValid, true)

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

'Look at all items in the list'
List<MobileElement> eventTimeRanges

eventTimeRanges = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Discover/Events/List Entry - Time")))

listLength = eventTimeRanges.size()

Date currentStartTime
def startTimeRange = Date.parse("hh:mmaa", "12:00pm")
def endTimeRange = Date.parse("hh:mmaa", "04:00pm")
String startTimeValue, endTimeValue, currentTimeRange

SortOrderIsValid = true

for(int i = 0;i<listLength;i++) {
	currentTimeRange = eventTimeRanges[i].text
	(startTimeValue, endTimeValue) = currentTimeRange.tokenize('-')
		 
	currentStartTime = CustomKeywords.'StringHelper.getTimeFromString'(startTimeValue, "h:mmaa")
	
	if ((currentStartTime.before(startTimeRange)) ||  (currentStartTime.after(endTimeRange))) {
		'sorting has failed'
		SortOrderIsValid = false
	}

}

Mobile.verifyEqual(SortOrderIsValid, true)

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

'Tap on the Category page back button'
Mobile.waitForElementPresent(Finder.findButton("Discover/Events/SortFilter/Category/Back"), timeout)
Button.tap("Discover/Events/SortFilter/Category/Back", timeout)

'Tap on the Apply button'
Button.tap("Discover/Events/SortFilter/Apply", timeout)

'Verify that events list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Events/List Entry"), timeout)

SortOrderIsValid = true

eventDateStrings = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Discover/Events/List Entry - Date")))

listLength = eventDateStrings.size()

Date currentCompareDate = new Date()

for(int i = 0;i<listLength;i++) {
	tmpDateString = eventDateStrings[i].text
	 
	currentEventDate = CustomKeywords.'StringHelper.getTimeFromString'(tmpDateString, "MMM d, yyyy")
	
	if (!currentEventDate.compareTo(currentCompareDate))
	{
		'sorting has failed'
		SortOrderIsValid = false
	}
}

Mobile.verifyEqual(SortOrderIsValid, true)

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

'tap on the from time'
Button.tap("Discover/Events/SortFilter/When Page/From Time", timeout)

'tap on the keyboard entry icon button'
Button.tap("Discover/Events/SortFilter/When Page/Time Keyboard Entry", timeout)

'Enter 3 into hour entry'
TextField.typeText(Finder.findTextField('Discover/Events/SortFilter/When Page/Custom Time Hour'), "3" + Keys.ENTER, timeout)

'Enter 3 into hour entry'
TextField.typeText(Finder.findTextField('Discover/Events/SortFilter/When Page/Custom Time Minute'), "00" + Keys.ENTER, timeout)

'Set AM/PM to PM'
Button.tap("Discover/Events/SortFilter/When Page/Custom Time AM_PM", timeout)
Button.tap("Discover/Events/SortFilter/When Page/Custom Time PM Selector", timeout)

'tap on OK button'
Button.tap("Discover/Events/SortFilter/When Page/Custom Time Entry OK", timeout)

'tap on the To time'
Button.tap("Discover/Events/SortFilter/When Page/To Time", timeout)

'tap on the keyboard entry icon button'
Button.tap("Discover/Events/SortFilter/When Page/Time Keyboard Entry", timeout)

'Enter 3 into hour entry'
TextField.typeText(Finder.findTextField('Discover/Events/SortFilter/When Page/Custom Time Hour'), "7" + Keys.ENTER, timeout)

'Enter 3 into hour entry'
TextField.typeText(Finder.findTextField('Discover/Events/SortFilter/When Page/Custom Time Minute'), "00" + Keys.ENTER, timeout)

'Set AM/PM to PM'
Button.tap("Discover/Events/SortFilter/When Page/Custom Time AM_PM", timeout)
Button.tap("Discover/Events/SortFilter/When Page/Custom Time PM Selector", timeout)

'tap on OK button'
Button.tap("Discover/Events/SortFilter/When Page/Custom Time Entry OK", timeout)

'Tap on the Category page back button'
Mobile.waitForElementPresent(Finder.findButton("Discover/Events/SortFilter/Category/Back"), timeout)
Button.tap("Discover/Events/SortFilter/Category/Back", timeout)

'Tap on the Apply button'
Button.tap("Discover/Events/SortFilter/Apply", timeout)

'Verify that events list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Events/List Entry"), timeout)

eventTimeRanges = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Discover/Events/List Entry - Time")))

listLength = eventTimeRanges.size()

startTimeRange = Date.parse("hh:mmaa", "03:00pm")
endTimeRange = Date.parse("hh:mmaa", "07:00pm")

SortOrderIsValid = true

for(int i = 0;i<listLength;i++) {
	currentTimeRange = eventTimeRanges[i].text
	(startTimeValue, endTimeValue) = currentTimeRange.tokenize('-')
		 
	currentStartTime = CustomKeywords.'StringHelper.getTimeFromString'(startTimeValue, "h:mmaa")
	
	if ((currentStartTime.before(startTimeRange)) ||  (currentStartTime.after(endTimeRange))) {
		'sorting has failed'
		SortOrderIsValid = false
	}
}

Mobile.verifyEqual(SortOrderIsValid, true)

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

Mobile.waitForElementPresent(Finder.findLabel('Discover/Events/List Entry - Name'), timeout)

'Search for a unique journey name'
Mobile.waitForElementPresent(Finder.findTextField('Discover/Events/Search'), timeout)
TextField.typeText(Finder.findTextField('Discover/Events/Search'), UniqueEventName + Keys.ENTER, timeout)

Mobile.waitForElementPresent(Finder.findLabel('Discover/Events/List Entry - Name'), timeout)

//Mobile.verifyElementText(Finder.findLabel('Discover/Events/List Entry - Name'), UniqueEventName)
'Verify that sort order has been applied'
SortOrderIsValid = true

eventNames = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Discover/Events/List Entry - Name")))
 
listLength = eventNames.size()

for(int i = 0;i<listLength;i++) {
	currentEventName = eventNames[i].text
	
	if (!currentEventName.contains(UniqueEventName))  {
		'sorting has failed'
		SortOrderIsValid = false
	}
}

Mobile.verifyEqual(SortOrderIsValid, true)

'Navigate to Home'
Button.tap('Nav/Home Navigation Button', timeout)

'Log out'
Button.tap('Logout Button', timeout)

if (deviceIsiOS) {
	Mobile.closeApplication()
}
else {
	driver.terminateApp('com.healthychurch.companion.stage')
}

