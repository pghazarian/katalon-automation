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

/*
1. Launch the Companion App
2. Log into the app
3. Tap on the Resource Navigation button at bottom
4. Tap on the Messages tab on Resources page
5. Swipe left to right on the Series carosel 
6. Tap on the See All link under Series section
7. Tap on the back arrow button in upper right portion of series list page
8. Swip bottom upward in the Latest Messages section
9. Tap on the Seel All link under the Latest Messages section
10. Tap on the back arrow button in the upper right portion of the Messages & Notes page.
11. Enter a unique message name on Messages landing page
12. Enter a unique series name on Messages landing page
13. Enter a unique speaker name on Messages & Notes page
*/


def timeout = 10
def UniqueMessageName = 'Love is Jesus'
def UniqueMessageSeries = '62'
def UniqueMessageSpeaker = 'Andy Wood'

'Open existing app by the app bundle id'
WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [:], FailureHandling.STOP_ON_FAILURE)

Boolean deviceIsiOS = false

if (Device.isIOS()) {
	deviceIsiOS = true
}
	
'Navigate to Resource'
Button.tap('Nav/Resources Navigation Button', timeout)

'Wait for Messages landing page to display'
//Mobile.waitForElementPresent(Finder.findButton("Resources/Messages Tab"), timeout)
Button.tap('Resources/Messages Tab', timeout)


'Verify that journey entries exist'
Mobile.waitForElementPresent(Finder.findLabel("Resources/Messages/List Entry"), timeout)

'Verify that the list has entries'
Mobile.verifyElementVisible(Finder.findLabel('Resources/Messages/List Entry'), timeout)
///*
'Verify that the entries have a public name'
Mobile.verifyElementVisible(Finder.findLabel('Resources/Messages/List Entry - Name'), timeout)

'Verify that the entries have an image'
Mobile.verifyElementVisible(Finder.findLabel('Resources/Messages/List Entry - Speaker'), timeout)

'Verify that the entries have an image'
Mobile.verifyElementVisible(Finder.findLabel('Resources/Messages/List Entry - Image'), timeout)

// need driver to get lists and close app
AppiumDriver<MobileElement> driver = MobileDriverFactory.getDriver()

'Tap on See all Series'
Button.tap("Resources/Messages/Series See All", timeout)
Mobile.delay(1)
Mobile.waitForElementPresent(Finder.findLabel("Resources/Messages/Series List Page/Series Title"), timeout)

Mobile.verifyElementExist(Finder.findLabel("Resources/Messages/Series List Page/Series Title"), timeout)
Mobile.verifyElementExist(Finder.findLabel("Resources/Messages/Series List Page/Series Image"), timeout)

'Tap on Back button'
Button.tap("Resources/Messages/Series List Page/Back", timeout)

'Tap on See all Messages'
Button.tap("Resources/Messages/Messages See All", timeout)
Mobile.delay(1)
Mobile.waitForElementPresent(Finder.findLabel("Resources/Messages/Messages List Page/Message Item Image"), timeout)

Mobile.verifyElementExist(Finder.findLabel("Resources/Messages/Messages List Page/Message Item Image"), timeout)
Mobile.verifyElementExist(Finder.findLabel("Resources/Messages/Messages List Page/Message Item Title"), timeout)
Mobile.verifyElementExist(Finder.findLabel("Resources/Messages/Messages List Page/Message Item Dates"), timeout)
Mobile.verifyElementExist(Finder.findLabel("Resources/Messages/Messages List Page/Message Item Speaker"), timeout)

'Tap on Back button'
Button.tap("Resources/Messages/Series List Page/Back", timeout)

'Tap on the Sort and Filter button'
Button.tap("Resources/Messages/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Resources/Messages/SortFilter/Sort By"), timeout)

'Tap on the Sort By button'
Button.tap("Resources/Messages/SortFilter/Sort By", timeout)

'Tap on the Sort A-Z button'
if (deviceIsiOS) {
	Mobile.sendKeys(Finder.findTextField('Discover/Events/SortFilter/Sort By Picker Wheel'), "Series Name (A to Z)", FailureHandling.STOP_ON_FAILURE)
	Button.tap("Discover/Events/SortFilter/Sort Done", timeout)
}
else {
	Button.tap("Resources/Messages/SortFilter/Series Name (A to Z)", timeout)
}

'Tap on the Apply button'
Button.tap("Resources/Messages/SortFilter/Apply", timeout)

'Verify that journey browse page visible'
Mobile.waitForElementPresent(Finder.findLabel("Resources/Messages/Sorted List Entry - Name"), timeout)

'Tap on the Sort and Filter button'
Button.tap("Resources/Messages/Sort And Filter", timeout)

'Tap on the Sort By button'
Button.tap("Resources/Messages/SortFilter/Sort By", timeout)

'Tap on the Sort Z-A button'
if (deviceIsiOS) {
	Mobile.sendKeys(Finder.findTextField('Resources/Messages/SortFilter/Sort By Picker Wheel'), "Series Name (Z to A)", FailureHandling.STOP_ON_FAILURE)
	Button.tap("Resources/Messages/SortFilter/Sort Done", timeout)
}
else {
	Button.tap("Resources/Messages/SortFilter/Series Name (Z to A)", timeout)
}

'Tap on the Apply button'
Button.tap("Resources/Messages/SortFilter/Apply", timeout)

'Verify that events list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Resources/Messages/Sorted List Entry - Name"), timeout)

'Tap on the Sort and Filter button'
Button.tap("Resources/Messages/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Resources/Messages/SortFilter/Sort By"), timeout)

'Tap on the Sort By button'
Button.tap("Resources/Messages/SortFilter/Sort By", timeout)

'Tap on the Sort Soonest to Latest button'
if (deviceIsiOS) {
	Mobile.sendKeys(Finder.findTextField('Resources/Messages/SortFilter/Sort By Picker Wheel'), "Date of Sermon (Newest First)", FailureHandling.STOP_ON_FAILURE)
	Button.tap("Resources/Messages/SortFilter/Sort Done", timeout)
}
else {
	Button.tap("Resources/Messages/SortFilter/Date of Sermon (Newest First)", timeout)
}

'Tap on the Apply button'
Button.tap("Resources/Messages/SortFilter/Apply", timeout)

'Verify that events list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Resources/Messages/Sorted List Entry - Name"), timeout)

SortOrderIsValid = true

/*
'verify that messages are dated newest to oldest'
List<MobileElement> messageDateStrings
List<MobileElement> messageTimeStrings

messageDateStrings = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Discover/Events/List Entry - Date")))

listLength = messageDateStrings.size()

String firstMessageDate = messageDateStrings[1].text 
String lastMessageDate = messageDateStrings[listLength-1].text
def firstMessageDate = Date.parse(" M d, yyyy", firstMessageDateTime)

def lastMessageDate = Date.parse(" M d, yyyy", lastMessageDateTime)

if (firstMessageDate.after(lastMessageDate))
{
	'sorting has failed'
	SortOrderIsValid = false
}
*/

Mobile.verifyEqual(SortOrderIsValid, true)

'Tap on the Sort and Filter button'
Button.tap("Resources/Messages/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Resources/Messages/SortFilter/Sort By"), timeout)

'Tap on the Sort By button'
Button.tap("Resources/Messages/SortFilter/Sort By", timeout)

'Tap on the Sort Soonest to Latest button'
if (deviceIsiOS) {
	Mobile.sendKeys(Finder.findTextField('Resources/Messages/SortFilter/Sort By Picker Wheel'), "Date of Sermon (Oldest First)", FailureHandling.STOP_ON_FAILURE)
	Button.tap("Resources/Messages/SortFilter/Sort Done", timeout)
}
else {
	Button.tap("Resources/Messages/SortFilter/Date of Sermon (Oldest First)", timeout)
}

'Tap on the Apply button'
Button.tap("Resources/Messages/SortFilter/Apply", timeout)

'Verify that events list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Resources/Messages/Sorted List Entry - Name"), timeout)


/*
'verify that messages are dated oldest to newest'
List<MobileElement> messageDateStrings
List<MobileElement> messageTimeStrings

messageDateStrings = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Resources/Messages/Messages List Page/Message Item Dates")))

listLength = messageDateStrings.size()

String stringFirstMessageDate = messageDateStrings[1].text
String stringLastMessageDate = messageDateStrings[listLength-1].text
def firstMessageDate = Date.parse(" M d, yyyy", stringFirstMessageDate)

def lastMessageDate = Date.parse(" M d, yyyy", stringLastMessageDate)

if (firstMessageDate.after(lastMessageDate))
{
	'sorting has failed'
	SortOrderIsValid = false
}
*/

'Tap on the Sort and Filter button'
Button.tap("Resources/Messages/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Resources/Messages/SortFilter/Sort By"), timeout)

'Tap on the Sort Relevance button'
Button.tap("Resources/Messages/SortFilter/Clear Filters", timeout)

'Tap on the Campus button'
Button.tap("Resources/Messages/SortFilter/Campus", timeout)

' Tap on the Anaheim campus'
Button.tap("Resources/Messages/SortFilter/Campus Page/Anaheim", timeout)

'Tap on the Campus page back button'
Button.tap("Resources/Messages/SortFilter/Campus Page/Back", timeout)

'Tap on the Apply button'
Button.tap("Resources/Messages/SortFilter/Apply", timeout)

'Verify that events list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Resources/Messages/Sorted List Entry - Name"), timeout)

'Tap on the Sort and Filter button'
Button.tap("Resources/Messages/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Resources/Messages/SortFilter/Sort By"), timeout)

'Tap on the Sort Relevance button'
Button.tap("Resources/Messages/SortFilter/Clear Filters", timeout)

'Tap on the Speaker button'
Button.tap("Resources/Messages/SortFilter/Speaker", timeout)

' Tap on the Anaheim campus'
Button.tap("Resources/Messages/SortFilter/Speaker Page/First Speaker", timeout)

'get the text of the first speaker name'
String selectedSpeakerName = Mobile.getText(Finder.findButton("Resources/Messages/SortFilter/Speaker Page/First Speaker Name"), timeout)

'Tap on the Campus page back button'
Button.tap("Resources/Messages/SortFilter/Speaker Page/Back", timeout)

'Tap on the Apply button'
Button.tap("Resources/Messages/SortFilter/Apply", timeout)

'Verify that events list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Resources/Messages/Sorted List Entry - Name"), timeout)

'make sure entries in list have matching speaker name'
 SortOrderIsValid = true
 List<MobileElement> messageSpeakerStrings
 
 messageSpeakerStrings = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Resources/Messages/Messages List Page/Message Item Speaker")))
  
 listLength = messageSpeakerStrings.size()
 
 String currentMessageSpeaker = ""
  
 for(int i = 0;i<listLength;i++) {
	 
	 currentMessageSpeaker = messageSpeakerStrings[i].text
	 
	 if (!currentMessageSpeaker.equalsIgnoreCase(selectedSpeakerName))
	 {
		 'sorting has failed'
		 SortOrderIsValid = false
	 }
 }
 
 'Verify that all entries matched expected results'
 Mobile.verifyEqual(SortOrderIsValid, true)
 
'Tap on the Sort and Filter button'
Button.tap("Resources/Messages/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Resources/Messages/SortFilter/Sort By"), timeout)

'Tap on the Sort Relevance button'
Button.tap("Resources/Messages/SortFilter/Clear Filters", timeout)

'Tap on the Series button'
Button.tap("Resources/Messages/SortFilter/Series", timeout)

' Tap on the Anaheim campus'
Button.tap("Resources/Messages/SortFilter/Series Page/First Series", timeout)

'Tap on the Campus page back button'
Button.tap("Resources/Messages/SortFilter/Series Page/Back", timeout)

'Tap on the Apply button'
Button.tap("Resources/Messages/SortFilter/Apply", timeout)

'Verify that events list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Resources/Messages/Sorted List Entry - Name"), timeout)

'Tap on the Sort and Filter button'
Button.tap("Resources/Messages/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Resources/Messages/SortFilter/Sort By"), timeout)

'Tap on the Sort Relevance button'
Button.tap("Resources/Messages/SortFilter/Clear Filters", timeout)

Mobile.delay(3)

'Tap on the Sermons With Saved Notes checkbox'
Button.tap("Resources/Messages/SortFilter/Sermons with Saved Notes", timeout)

'Tap on the Apply button'
Button.tap("Resources/Messages/SortFilter/Apply", timeout)

'Verify that events list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Resources/Messages/Sorted List Entry - Name"), timeout)


'make sure entries in list all have the with notes icon'
SortOrderIsValid = true
List<MobileElement> messagesWithNotes
List<MobileElement> messageItemsTotal

messagesWithNotes = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Resources/Messages/Messages List Page/Message Item With Notes")))
messageItemsTotal = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Resources/Messages/Sorted List Entry - Name")))
 
int listWithNotesLength = messagesWithNotes.size()
int listTotalDisplayedMessagesLength = messageItemsTotal.size()

	
if (listWithNotesLength != listTotalDisplayedMessagesLength)
{
	'sorting has failed'
	SortOrderIsValid = false
}


'Verify that all entries matched expected results'
Mobile.verifyEqual(SortOrderIsValid, true)


'Tap on the Sort and Filter button'
Button.tap("Resources/Messages/Sort And Filter", timeout)

'wait for Sort and Filter page to fully displayed'
Mobile.waitForElementPresent(Finder.findButton("Resources/Messages/SortFilter/Sort By"), timeout)

'Tap on the Sort Relevance button'
Button.tap("Resources/Messages/SortFilter/Clear Filters", timeout)
Mobile.delay(1)
'Tap on the Apply button'
Button.tap("Resources/Messages/SortFilter/Apply", timeout)

'Verify that events list page visible'
Mobile.waitForElementPresent(Finder.findLabel("Resources/Messages/Messages List Page/Message Item Title"), timeout)

Mobile.delay(1)

'Search for a unique message name'
TextField.typeText(Finder.findTextField('Resources/Messages/Search'), UniqueMessageName + Keys.ENTER, timeout)
Mobile.delay(1)

'Search for a unique message series'
TextField.typeText(Finder.findTextField('Resources/Messages/Search'), UniqueMessageSeries + Keys.ENTER, timeout)

Mobile.delay(3)

'Search for a unique message speaker'
TextField.typeText(Finder.findTextField('Resources/Messages/Search'), UniqueMessageSpeaker + Keys.ENTER, timeout)

'make sure entries in list have matching speaker name'
SortOrderIsValid = true

messageSpeakerStrings = driver.findElementsByXPath(MobileTestObjectHelper.getXPath(Finder.findLabel("Resources/Messages/Messages List Page/Message Item Speaker")))
 
listLength = messageSpeakerStrings.size()

currentMessageSpeaker = ""
 
for(int i = 0;i<listLength;i++) {
	
	currentMessageSpeaker = messageSpeakerStrings[i].text
	
	if (!currentMessageSpeaker.equalsIgnoreCase(UniqueMessageSpeaker))
	{
		'sorting has failed'
		SortOrderIsValid = false
	}
}

'Verify that all entries matched expected results'
Mobile.verifyEqual(SortOrderIsValid, true)

Mobile.delay(3)

'Navigate to Home'
Button.tap('Nav/Home Navigation Button', timeout)

'Log out'
if (Device.isIOS()) {
	Swipe.swipe(SwipeDirection.BOTTOM_TO_TOP)
}
else {
	Mobile.scrollToText('LOGOUT!', FailureHandling.STOP_ON_FAILURE)
}
Button.tap('Logout Button', timeout)

if (deviceIsiOS) {
	Mobile.closeApplication()
}
else {
	driver.closeApp()
}


