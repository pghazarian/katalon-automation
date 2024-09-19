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
def UniqueMinistryName = GlobalVariable.MinistrySearch_SearchTerm

boolean LoggedInIteration = LoggedIn.toBoolean()

if (LoggedInIteration) {
	'Open existing app by logging into the app bundle id'
	WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [:], FailureHandling.STOP_ON_FAILURE)
} else {
	return
	'Open existing app while logged out by the app bundle id'
	WebUI.callTestCase(findTestCase('Companion App/Shared/Guest Startup'), [:], FailureHandling.STOP_ON_FAILURE)
}

Boolean deviceIsiOS = false

if (Device.isIOS()) {
	deviceIsiOS = true
}
	
'Navigate to Discover'
Mobile.waitForElementPresent(Finder.findButton('Nav/Discover Navigation Button'), timeout)
Button.tap('Nav/Discover Navigation Button', timeout)

'tap on the Ministries tab'
Mobile.delay(2)
Mobile.waitForElementPresent(Finder.findButton('Discover/Ministries Tab'), timeout)
Button.tap('Discover/Ministries Tab', timeout)

'Verify that Ministries entries exist'
Mobile.waitForElementPresent(Finder.findLabel('Discover/Ministries/List Entry - Name'), timeout)

'Verify that the entries have a public name'
Mobile.verifyElementVisible(Finder.findLabel('Discover/Ministries/List Entry - Name'), timeout)

'Verify that the entries have a category'
Mobile.verifyElementVisible(Finder.findLabel('Discover/Ministries/List Entry - Category'), timeout)

'Verify that the entries have an image'
Mobile.verifyElementVisible(Finder.findLabel('Discover/Ministries/List Entry - Image'), timeout)

'Verify that the entries have a Locaton'
Mobile.verifyElementVisible(Finder.findLabel('Discover/Ministries/List Entry - Location'), timeout)

' need driver to get lists and close app'
AppiumDriver<MobileElement> driver = MobileDriverFactory.getDriver()

'Tap on the Sort and Filter button'
Button.tap("Discover/Ministries/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Ministries/SortFilter/Sort By"), timeout)

'Tap on the Sort By button'
Button.tap("Discover/Ministries/SortFilter/Sort By", timeout)

'Tap on the Sort A-Z button'
if (deviceIsiOS) {
	Mobile.sendKeys(Finder.findTextField('Discover/Ministries/SortFilter/Sort By Picker Wheel'), "A to Z", FailureHandling.STOP_ON_FAILURE)    
	Button.tap("Discover/Ministries/SortFilter/Sort Done", timeout)
}
else {
	Button.tap("Discover/Ministries/SortFilter/Sort A-Z", timeout)
}

'Tap on the Apply button'
Button.tap("Discover/Ministries/SortFilter/Apply", timeout)

'Verify that Ministries browse page visible'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Ministries/List Entry - Name"), timeout)
Mobile.delay(3)
'Verify that sort order has been applied'
String firstMinistryName = ''
String lastMinistryName = ''

Boolean SortOrderIsValid = true
int compareResult

List<MobileElement> ministryNames = MobileTestObjectHelper.getElementList(Finder.findLabel("Discover/Ministries/List Entry - Name"), driver)

int listLength = ministryNames.size()
String allNumbers = "1234567890"
Boolean NumberFound = true
int listIndex = 0

while (NumberFound) {
	String currentNameString = ministryNames[listIndex].text
	
	currentNameString = currentNameString.substring(0, 1)
	if (!allNumbers.contains(currentNameString)) {
		NumberFound = false
	}
	else {
		listIndex++
	}
}

firstMinistryName = ministryNames[listIndex].text
lastMinistryName = ministryNames[listLength-1].text

if (lastMinistryName.compareToIgnoreCase(firstMinistryName) < 0)
{
	'sorting has failed'
	SortOrderIsValid = false
}

'verify that sorting is correct'
Mobile.verifyEqual(SortOrderIsValid, true)
//Mobile.delay(3)
'Tap on the Sort and Filter button'
Button.tap("Discover/Ministries/Sort And Filter", timeout)
//Mobile.delay(3)
'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Ministries/SortFilter/Clear Filters"), timeout)
//Mobile.delay(3)
'Tap on the Sort By button'
Button.tap("Discover/Ministries/SortFilter/Sort By", timeout)

'Tap on the Sort Z-A button'
if (deviceIsiOS) {
	Mobile.sendKeys(Finder.findTextField('Discover/Ministries/SortFilter/Sort By Picker Wheel'), "Z to A", FailureHandling.STOP_ON_FAILURE)
	Button.tap("Discover/Ministries/SortFilter/Sort Done", timeout)
}
else {
	Button.tap("Discover/Ministries/SortFilter/Sort Z-A", timeout)
}
//Mobile.delay(3)
'Tap on the Apply button'
Button.tap("Discover/Ministries/SortFilter/Apply", timeout)
//Mobile.delay(3)
'Verify that serving opps list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Ministries/List Entry - Name"), timeout)
Mobile.delay(3)

'Verify that sort order has been applied'
firstMinistryName = ''
lastMinistryName = ''

SortOrderIsValid = true

ministryNames = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Discover/Ministries/List Entry - Name")))
 
//Mobile.delay(3)
listLength = ministryNames.size()

firstMinistryName = ministryNames[0].text
lastMinistryName = ministryNames[listLength-1].text

if (lastMinistryName.compareToIgnoreCase(firstMinistryName) > 0)
{
	'sorting has failed'
	SortOrderIsValid = false
}
//Mobile.delay(3)
Mobile.verifyEqual(SortOrderIsValid, true)

'Tap on the Sort and Filter button'
Button.tap("Discover/Ministries/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Ministries/SortFilter/Clear Filters"), timeout)
Button.tap("Discover/Ministries/SortFilter/Clear Filters", timeout)
Mobile.delay(3)

'Tap on the Categories button'
Button.tap("Discover/Ministries/SortFilter/Categories", timeout)

'Tap on the Adult Ministries entry'
Mobile.waitForElementPresent(Finder.findButton("Discover/Ministries/SortFilter/Category/Adult Ministries"), timeout)
Button.tap("Discover/Ministries/SortFilter/Category/Adult Ministries", timeout)

'Tap on the Category page back button'
Button.tap("Discover/Ministries/SortFilter/Category/Back", timeout)

'Tap on the Apply button'
Button.tap("Discover/Ministries/SortFilter/Apply", timeout)

'Verify that ministries list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Ministries/List Entry - Name"), timeout)
Mobile.delay(3)

'Verify that sort order has been applied'
String firstMinistryCategory = ''
String lastMinistryCategory = ''

Boolean CategoryFilteringIsValid = true

List<MobileElement> ministryCategories

ministryCategories = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Discover/Ministries/List Entry - Category")))

int arrayOfDatesSize = ministryCategories.size()

firstMinistryCategory = ministryCategories[0].text
lastMinistryCategory = ministryCategories[arrayOfDatesSize-1].text

if (firstMinistryCategory.compareToIgnoreCase("Adult Ministries") != 0 || lastMinistryCategory.compareToIgnoreCase("Adult Ministries") != 0)
{
	'filtering has failed'
	CategoryFilteringIsValid = false
}

Mobile.verifyEqual(CategoryFilteringIsValid, true)

'Tap on the Sort and Filter button'
Button.tap("Discover/Ministries/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Ministries/SortFilter/Clear Filters"), timeout)
Button.tap("Discover/Ministries/SortFilter/Clear Filters", timeout)

'Tap on the Where button'
Button.tap("Discover/Ministries/SortFilter/Where", timeout)

' Tap on the Anaheim campus'
Mobile.waitForElementPresent(Finder.findButton("Discover/Ministries/SortFilter/Where Page/Anaheim"), timeout)
Button.tap("Discover/Ministries/SortFilter/Where Page/Anaheim", timeout)

'Tap on the Category page back button'
Button.tap("Discover/Ministries/SortFilter/Category/Back", timeout)

'Tap on the Apply button'
Mobile.waitForElementPresent(Finder.findButton("Discover/Ministries/SortFilter/Apply"), timeout)
Button.tap("Discover/Ministries/SortFilter/Apply", timeout)
//Mobile.delay(3)
'Verify that ministries list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Ministries/List Entry - Name"), timeout)
//Mobile.delay(3)
'go through all the ministries in the list to make sure they are for selected campus'
Boolean CampusFilteringIsValid = true

List<MobileElement> servingOppCampuses

servingOppCampuses = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Discover/Serving/List Entry - Date")))

listLength = servingOppCampuses.size()

String currentCampusString

for(int i = 0;i<listLength;i++) {
	currentCampusString = servingOppCampuses[i].text

	if (currentCampusString.compareToIgnoreCase("Anaheim"))
	{
		'sorting has failed'
		CampusFilteringIsValid = false
	}
}

//Mobile.verifyEqual(CampusFilteringIsValid, true)

'Verify that ministries list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Discover/Ministries/List Entry - Name"), timeout)

'Tap on the Sort and Filter button'
Button.tap("Discover/Ministries/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Discover/Ministries/SortFilter/Clear Filters"), timeout)
Mobile.delay(3)

'Tap on the Sort Relevance button'
Button.tap("Discover/Ministries/SortFilter/Clear Filters", timeout)

'Tap on the Apply button'
Button.tap("Discover/Ministries/SortFilter/Apply", timeout)
Mobile.delay(3)
Mobile.waitForElementPresent(Finder.findLabel('Discover/Ministries/List Entry - Name'), timeout)

'Search for a unique Ministry name'
Mobile.waitForElementPresent(Finder.findTextField('Discover/Ministries/Search'), timeout)
TextField.typeText(Finder.findTextField('Discover/Ministries/Search'), UniqueMinistryName + Keys.ENTER, timeout)

Mobile.waitForElementPresent(Finder.findLabel('Discover/Ministries/List Entry - Name'), timeout)

'Verify that sort order has been applied'
SortOrderIsValid = true

ministryNames = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Discover/Ministries/List Entry - Name")))
 
listLength = ministryNames.size()

for(int i = 0;i<listLength;i++) {
	currentMinistryName = ministryNames[i].text
	println("current Ministry name = " + currentMinistryName)
	if (!currentMinistryName.contains(UniqueMinistryName))  {
		'sorting has failed'
		SortOrderIsValid = false
	}
}

Mobile.verifyEqual(SortOrderIsValid, true)

'Navigate to Home'
Button.tap('Nav/Home Navigation Button', timeout)

'Log out'
WebUI.callTestCase(findTestCase('Companion App/Shared/Logout'), [:], FailureHandling.STOP_ON_FAILURE)

if (deviceIsiOS) {
	Mobile.closeApplication()
}
else {
	driver.terminateApp('com.healthychurch.companion.stage')
}

