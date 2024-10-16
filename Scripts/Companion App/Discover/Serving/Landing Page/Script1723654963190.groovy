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
import java.text.SimpleDateFormat

def timeout = 10
def UniqueServingOppName = GlobalVariable.ServingSearch_SearchTerm

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

Mobile.waitForElementPresent(Finder.findButton('Nav/Discover Navigation Button'), timeout)
	
'Navigate to Discover'
Button.tap('Nav/Discover Navigation Button', timeout)

'tap on the Serving tab'
Mobile.delay(3)
Button.tap('Discover/Serving Tab', timeout)

//Mobile.delay(3)

'Verify that Serving entries exist'
Mobile.waitForElementPresent(Finder.findLabel('Discover/Serving/List Entry - Name'), timeout)

'Verify that the entries have a public name'
Mobile.verifyElementVisible(Finder.findLabel('Discover/Serving/List Entry - Name'), timeout)

'Verify that the entries have a category'
Mobile.verifyElementVisible(Finder.findLabel('Discover/Serving/List Entry - Category'), timeout)

'Verify that the entries have an image'
Mobile.verifyElementVisible(Finder.findLabel('Discover/Serving/List Entry - Image'), timeout)

'Verify that the entries have a Date and Time'
Mobile.verifyElementVisible(Finder.findLabel('Discover/Serving/List Entry - Date'), timeout)

'Verify that the entries have a Locaton'
Mobile.verifyElementVisible(Finder.findLabel('Discover/Serving/List Entry - Location'), timeout)

' need driver to get lists and close app'
AppiumDriver<MobileElement> driver = MobileDriverFactory.getDriver()

'Tap on the Sort and Filter button'
Button.tap("Discover/Serving/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Serving/SortFilter/Sort By"), timeout)

'Tap on the Sort By button'
Button.tap("Discover/Serving/SortFilter/Sort By", timeout)

'Tap on the Sort A-Z button'
if (deviceIsiOS) {
	Mobile.sendKeys(Finder.findTextField('Discover/Serving/SortFilter/Sort By Picker Wheel'), "A to Z", FailureHandling.STOP_ON_FAILURE)    
	Button.tap("Discover/Serving/SortFilter/Sort Done", timeout)
}
else {
	Button.tap("Discover/Serving/SortFilter/Sort A-Z", timeout)
}

'Tap on the Apply button'
Button.tap("Discover/Serving/SortFilter/Apply", timeout)

'Verify that Serving browse page visible'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Serving/List Entry - Name"), timeout)

'Verify that sort order has been applied'
String firstServingOppName = ''
String lastServingOppName = ''

Boolean SortOrderIsValid = true
int compareResult

List<MobileElement> servingOppNames = MobileTestObjectHelper.getElementList(Finder.findLabel("Discover/Serving/List Entry - Name"), driver)

int listLength = servingOppNames.size()

firstServingOppName = servingOppNames[1].text
lastServingOppName = servingOppNames[listLength-1].text

if (lastServingOppName.compareToIgnoreCase(firstServingOppName) < 0)
{
	'sorting has failed'
	SortOrderIsValid = false
}

'verify that sorting is correct'
Mobile.verifyEqual(SortOrderIsValid, true)

'Tap on the Sort and Filter button'
Button.tap("Discover/Serving/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Serving/SortFilter/Clear Filters"), timeout)

'Tap on the Sort By button'
Button.tap("Discover/Serving/SortFilter/Sort By", timeout)

'Tap on the Sort Z-A button'
if (deviceIsiOS) {
	Mobile.sendKeys(Finder.findTextField('Discover/Serving/SortFilter/Sort By Picker Wheel'), "Z to A", FailureHandling.STOP_ON_FAILURE)
	Button.tap("Discover/Serving/SortFilter/Sort Done", timeout)
}
else {
	Button.tap("Discover/Serving/SortFilter/Sort Z-A", timeout)
}

'Tap on the Apply button'
Button.tap("Discover/Serving/SortFilter/Apply", timeout)

'Verify that serving opps list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Serving/List Entry - Name"), timeout)

'Verify that sort order has been applied'
firstServingOppName = ''
lastServingOppName = ''

SortOrderIsValid = true

servingOppNames = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Discover/Serving/List Entry - Name")))
 
listLength = servingOppNames.size()

firstServingOppName = servingOppNames[1].text
lastServingOppName = servingOppNames[listLength-1].text

if (lastServingOppName.compareToIgnoreCase(firstServingOppName) > 0)
{
	'sorting has failed'
	SortOrderIsValid = false
}

Mobile.verifyEqual(SortOrderIsValid, true)

'Tap on the Sort and Filter button'
Button.tap("Discover/Serving/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Serving/SortFilter/Clear Filters"), timeout)

'Tap on the Sort By button'
Button.tap("Discover/Serving/SortFilter/Sort By", timeout)

'Tap on the Sort Soonest to Latest button'
if (deviceIsiOS) {
	Mobile.sendKeys(Finder.findTextField('Discover/Serving/SortFilter/Sort By Picker Wheel'), "Soonest to Latest", FailureHandling.STOP_ON_FAILURE)
	Button.tap("Discover/Serving/SortFilter/Sort Done", timeout)
}
else {
	Button.tap("Discover/Serving/SortFilter/Sort Soonest to Latest", timeout)
}

'Tap on the Apply button'
Button.tap("Discover/Serving/SortFilter/Apply", timeout)

'Verify that events list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Serving/List Entry"), timeout)

'Verify that sort order has been applied'

SortOrderIsValid = true

List<MobileElement> servingOppDateStrings
List<MobileElement> servingOppTimeStrings

servingOppDateStrings = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Discover/Serving/List Entry - Date")))
servingOppTimeStrings = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Discover/Serving/List Entry - Time")))

listLength = servingOppDateStrings.size()

String tmpTimeString = servingOppTimeStrings[1].text

def (firstTimeValue1, firstTimeValue2) = tmpTimeString.tokenize('-')

tmpTimeString = servingOppTimeStrings[listLength-1].text

def (lastTimeValue1, lastTimeValue2) = tmpTimeString.tokenize('-')

String firstServingOppDateTime = servingOppDateStrings[1].text + " " + firstTimeValue1    
String lastServingOppDateTime = servingOppDateStrings[listLength-1].text + " " + lastTimeValue1 

def firstServingOppDate = Date.parse("MMM d, yyyy h:mma", firstServingOppDateTime)

def lastServingOppDate = Date.parse("MMM d, yyyy h:mma", lastServingOppDateTime)

if (firstServingOppDate.after(lastServingOppDate))
{
	'sorting has failed'
	SortOrderIsValid = false
}

Mobile.verifyEqual(SortOrderIsValid, true)

'Tap on the Sort and Filter button'
Button.tap("Discover/Serving/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Serving/SortFilter/Clear Filters"), timeout)
Button.tap("Discover/Events/SortFilter/Clear Filters", timeout)

'Tap on the Categories button'
Button.tap("Discover/Serving/SortFilter/Categories", timeout)

'Tap on the Descipleship entry'
Button.tap("Discover/Serving/SortFilter/Category/Adult Ministries", timeout)

'Tap on the Category page back button'
Button.tap("Discover/Serving/SortFilter/Category/Back", timeout)

'Tap on the Apply button'
Button.tap("Discover/Serving/SortFilter/Apply", timeout)

'Verify that serving opps list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Serving/List Entry - Name"), timeout)

'Verify that sort order has been applied'
String firstServingOppCategory = ''
String lastServingOppCategory = ''

Boolean CategoryFilteringIsValid = true

List<MobileElement> servingOppCategories

servingOppCategories = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Discover/Serving/Serving List Page/List Entry - Category")))

int arrayOfDatesSize = servingOppCategories.size()

firstServingOppCategory = servingOppCategories[0].text
lastServingOppCategory = servingOppCategories[arrayOfDatesSize-1].text

if (firstServingOppCategory.compareToIgnoreCase("Adult Ministries") != 0 || lastServingOppCategory.compareToIgnoreCase("Adult Ministries") != 0)
{
	'filtering has failed'
	CategoryFilteringIsValid = false
}

Mobile.verifyEqual(CategoryFilteringIsValid, true)

'Tap on the Sort and Filter button'
Button.tap("Discover/Serving/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Serving/SortFilter/Clear Filters"), timeout)
Button.tap("Discover/Serving/SortFilter/Clear Filters", timeout)

'Tap on the Where button'
Button.tap("Discover/Serving/SortFilter/Where", timeout)

' Tap on the Anaheim campus'
Button.tap("Discover/Serving/SortFilter/Where Page/Anaheim", timeout)

'Tap on the Category page back button'
Button.tap("Discover/Serving/SortFilter/Category/Back", timeout)

'Tap on the Apply button'
Button.tap("Discover/Serving/SortFilter/Apply", timeout)

'Verify that events list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Serving/List Entry - Name"), timeout)

'go through all the events in the list to make sure they are for selected campus'
CategoryFilteringIsValid = true

Mobile.verifyEqual(CategoryFilteringIsValid, true)

'Tap on the Sort and Filter button'
Button.tap("Discover/Serving/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Serving/SortFilter/Clear Filters"), timeout)

'Tap on the Sort Relevance button'
Button.tap("Discover/Serving/SortFilter/Clear Filters", timeout)

'Tap on the When button'
Button.tap("Discover/Serving/SortFilter/When", timeout)

'Select Thursday day of week'
Button.tap("Discover/Serving/SortFilter/When Page/Thursday", timeout)

'Tap on the Category page back button'
Mobile.waitForElementPresent(Finder.findButton("Discover/Serving/SortFilter/Category/Back"), timeout)
Button.tap("Discover/Serving/SortFilter/Category/Back", timeout)

'Tap on the Apply button'
Button.tap("Discover/Serving/SortFilter/Apply", timeout)

Mobile.waitForElementPresent(Finder.findLabel("Discover/Serving/List Entry - Name"), timeout)

SortOrderIsValid = true

List<MobileElement> servingOppDaysOfWeek

servingOppDates = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Discover/Serving/List Entry - Date")))

listLength = servingOppDates.size()

def currentDate
int currentDayOfWeek

for(int i = 1;i<listLength;i++) {
	currentDateString = servingOppDates[i].text
	currentDate = Date.parse("MMM d, yyyy", currentDateString)
	
	if (currentDate[Calendar.DAY_OF_WEEK] != Calendar.THURSDAY)
	{
		'sorting has failed'
		SortOrderIsValid = false
	}
}

Mobile.verifyEqual(SortOrderIsValid, true)

'Tap on the Sort and Filter button'
Button.tap("Discover/Serving/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Serving/SortFilter/Clear Filters"), timeout)

'Tap on the Sort Relevance button'
Button.tap("Discover/Serving/SortFilter/Clear Filters", timeout)

'Tap on the When button'
Button.tap("Discover/Serving/SortFilter/When", timeout)

'Select Afternoons time of day'
Button.tap("Discover/Serving/SortFilter/When Page/Afternoons", timeout)

'Tap on the Category page back button'
Mobile.waitForElementPresent(Finder.findButton("Discover/Serving/SortFilter/Category/Back"), timeout)
Button.tap("Discover/Serving/SortFilter/Category/Back", timeout)

'Tap on the Apply button'
Button.tap("Discover/Serving/SortFilter/Apply", timeout)

SortOrderIsValid = true

'Look at all items in the list'
List<MobileElement> servingOppTimeRanges

servingOppTimeRanges = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Discover/Serving/List Entry - Time")))

listLength = servingOppTimeRanges.size()

Date currentStartTime
def startTimeRange = Date.parse("hh:mmaa", "12:00pm")

def endTimeRange = Date.parse("hh:mmaa", "04:00pm")

String startTimeValue, endTimeValue, currentTimeRange

for(int i = 0;i<listLength;i++) {
	currentTimeRange = servingOppTimeRanges[i].text
	(startTimeValue, endTimeValue) = currentTimeRange.tokenize('-')
		 
	currentStartTime = CustomKeywords.'StringHelper.getTimeFromString'(startTimeValue, "h:mmaa")
	
	if ((currentStartTime.before(startTimeRange)) ||  (currentStartTime.after(endTimeRange))) {
		'sorting has failed'
		SortOrderIsValid = false
	}
}

Mobile.verifyEqual(SortOrderIsValid, true)

'Tap on the Sort and Filter button'
Button.tap("Discover/Serving/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Serving/SortFilter/Clear Filters"), timeout)

'Tap on the Sort Relevance button'
Button.tap("Discover/Serving/SortFilter/Clear Filters", timeout)

'Tap on the When button'
Button.tap("Discover/Serving/SortFilter/When", timeout)

'Select custom date range'
Button.tap("Discover/Serving/SortFilter/When Page/Days Custom Range", timeout)

'Tap on the Category page back button'
Mobile.waitForElementPresent(Finder.findButton("Discover/Serving/SortFilter/Category/Back"), timeout)
Button.tap("Discover/Serving/SortFilter/Category/Back", timeout)

'Tap on the Apply button'
Button.tap("Discover/Serving/SortFilter/Apply", timeout)

'Verify that events list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Serving/List Entry - Name"), timeout)

SortOrderIsValid = true

servingOppDateStrings = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Discover/Serving/List Entry - Date")))

listLength = servingOppDateStrings.size()

Date currentCompareDate = new Date()

for(int i = 0;i<listLength;i++) {
	tmpDateString = servingOppDateStrings[i].text
	 
	currentServingOppDate = CustomKeywords.'StringHelper.getTimeFromString'(tmpDateString, "MMM d, yyyy")
	
	if (!currentServingOppDate.compareTo(currentCompareDate))
	{
		'sorting has failed'
		SortOrderIsValid = false
	}
}

Mobile.verifyEqual(SortOrderIsValid, true)

'Tap on the Sort and Filter button'
Button.tap("Discover/Serving/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Serving/SortFilter/Clear Filters"), timeout)

'Tap on the Sort Relevance button'
Button.tap("Discover/Serving/SortFilter/Clear Filters", timeout)

'Tap on the When button'
Button.tap("Discover/Serving/SortFilter/When", timeout)

'Select custom date range'
Button.tap("Discover/Serving/SortFilter/When Page/Time Custom Range", timeout)

'tap on the from time'
Button.tap("Discover/Serving/SortFilter/When Page/From Time", timeout)

'tap on the keyboard entry icon button'
Button.tap("Discover/Serving/SortFilter/When Page/Time Keyboard Entry", timeout)

//Mobile.delay(3)
'Enter 3 into hour entry'
TextField.typeText(Finder.findTextField('Discover/Serving/SortFilter/When Page/Custom Time Hour'), "3" + Keys.ENTER, timeout)

'Enter 3 into hour entry'
TextField.typeText(Finder.findTextField('Discover/Serving/SortFilter/When Page/Custom Time Minute'), "00" + Keys.ENTER, timeout)

'Set AM/PM to PM'
Button.tap("Discover/Serving/SortFilter/When Page/Custom Time AM_PM", timeout)
Button.tap("Discover/Serving/SortFilter/When Page/Custom Time PM Selector", timeout)

'tap on OK button'
Button.tap("Discover/Serving/SortFilter/When Page/Custom Time Entry OK", timeout)

'tap on the To time'
Button.tap("Discover/Serving/SortFilter/When Page/To Time", timeout)

'tap on the keyboard entry icon button'
Button.tap("Discover/Serving/SortFilter/When Page/Time Keyboard Entry", timeout)

//Mobile.delay(3)
'Enter 7 into hour entry'
TextField.typeText(Finder.findTextField('Discover/Serving/SortFilter/When Page/Custom Time Hour'), "7" + Keys.ENTER, timeout)

'Enter 00 into minute entry'
TextField.typeText(Finder.findTextField('Discover/Serving/SortFilter/When Page/Custom Time Minute'), "00" + Keys.ENTER, timeout)

'Set AM/PM to PM'
Button.tap("Discover/Serving/SortFilter/When Page/Custom Time AM_PM", timeout)
Button.tap("Discover/Serving/SortFilter/When Page/Custom Time PM Selector", timeout)

'tap on OK button'
Button.tap("Discover/Serving/SortFilter/When Page/Custom Time Entry OK", timeout)

'Tap on the Category page back button'
Mobile.waitForElementPresent(Finder.findButton("Discover/Serving/SortFilter/Category/Back"), timeout)
Button.tap("Discover/Serving/SortFilter/Category/Back", timeout)

'Tap on the Apply button'
Button.tap("Discover/Serving/SortFilter/Apply", timeout)

'Verify that events list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Serving/List Entry - Name"), timeout)

SortOrderIsValid = true

servingOppTimeRanges = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Discover/Serving/List Entry - Time")))

listLength = servingOppTimeRanges.size()

startTimeRange = Date.parse("hh:mmaa", "03:00pm")
endTimeRange = Date.parse("hh:mmaa", "07:00pm")

for(int i = 0;i<listLength;i++) {
	currentTimeRange = servingOppTimeRanges[i].text
	(startTimeValue, endTimeValue) = currentTimeRange.tokenize('-')
		 
	currentStartTime = CustomKeywords.'StringHelper.getTimeFromString'(startTimeValue, "h:mmaa")
	
	if ((currentStartTime.before(startTimeRange)) ||  (currentStartTime.after(endTimeRange))) {
		'sorting has failed'
		SortOrderIsValid = false
	}
}

Mobile.verifyEqual(SortOrderIsValid, true)

'Verify that events list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Serving/List Entry"), timeout)

'Verify that sort order has been applied'
firstServingOppCategory = ''
lastServingOppCategory = ''

CategoryFilteringIsValid = true

Mobile.verifyEqual(CategoryFilteringIsValid, true)

'Tap on the Sort and Filter button'
Button.tap("Discover/Serving/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Serving/SortFilter/Clear Filters"), timeout)

'Tap on the Sort Relevance button'
Button.tap("Discover/Serving/SortFilter/Clear Filters", timeout)

'Tap on the Apply button'
Button.tap("Discover/Serving/SortFilter/Apply", timeout)

Mobile.waitForElementPresent(Finder.findLabel('Discover/Serving/List Entry - Name'), timeout)

'Search for a unique journey name'
Mobile.waitForElementPresent(Finder.findTextField('Discover/Events/Search'), timeout)
TextField.typeText(Finder.findTextField('Discover/Serving/Search'), UniqueServingOppName + Keys.ENTER, timeout)

Mobile.waitForElementPresent(Finder.findLabel('Discover/Serving/List Entry - Name'), timeout)

'Verify that sort order has been applied'
SortOrderIsValid = true

servingOppNames = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Discover/Serving/List Entry - Name")))
 
listLength = servingOppNames.size()

for(int i = 0;i<listLength;i++) {
	currentServingOppName = servingOppNames[i].text
	println("current serving opp name = " + currentServingOppName)
	if (!currentServingOppName.contains(UniqueServingOppName))  {
		'sorting has failed'
		SortOrderIsValid = false
	}
}

Mobile.verifyEqual(SortOrderIsValid, true)

if (CurrentlyLoggedIn) {
	WebUI.callTestCase(findTestCase('Companion App/Shared/Logout'), [:], FailureHandling.STOP_ON_FAILURE)
}

if (deviceIsiOS) {
	Mobile.closeApplication()
}
else {
	driver.terminateApp('com.healthychurch.companion.stage')
}

