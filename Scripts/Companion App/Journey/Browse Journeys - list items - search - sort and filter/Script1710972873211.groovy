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
def UniqueJourneyName = '21 DAYS OF PRAYER & FASTING'

'Open existing app by the app bundle id'
WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), ['UserName':'markh@saddleback.com', 'Password':(CryptoUtil.encode(CryptoUtil.getDefault('P@$$w0rd!')))], FailureHandling.STOP_ON_FAILURE)
//WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate to Journey'
Button.tap('Nav/Journey Navigation Button', timeout)

Mobile.delay(3)
'Wait for Journey landing page to display'
Mobile.waitForElementPresent(Finder.findButton("Journey/Browse Tab"), timeout)

'Tap on the Browse Journeys tab'
Button.tap('Journey/Browse Tab', timeout)

'Verify that journey entries exist'
Mobile.waitForElementPresent(Finder.findLabel("Journey/Browse/List Entry"), timeout)


//TextField.typeText(Finder.findTextField('Journey/Browse/Search'), UniqueJourneyName + Keys.ENTER, timeout)

Mobile.delay(3)
Button.tap('Journey/Browse Tab', timeout)

Mobile.delay(3)

String elementText = Mobile.getAttribute(Finder.findLabel('Journey/Browse/List Entry - Public Name'), 'text', timeout)
//String elementText = Mobile.getText(Finder.findLabel('Journey/Browse/List Entry - Public Name'), timeout)
println('Journey Public Name:')
println(elementText)

Mobile.delay(1)


TestObject testTempObject = Finder.findLabel('Journey/Browse/List Entry - Public Name')
String myXPath = testTempObject.findPropertyValue('xpath')      //.xpaths
//List<String> myXPaths = testTempObject.findPropertyValue('xpath')      //.xpaths
println(myXPath)
println(testTempObject.findPropertyValue('xpath'))
println(testTempObject.findPropertyValue('XPATH'))
println(testTempObject.findXpathValue('xpath'))


List<TestObjectXpath> xpathList = testTempObject.getXpaths()
//println(xpathList[0].getValue())
println(xpathList[1].getValue())



/*
println(strXPath)

TestObject testObj = findTestObject('icon_Social_networking')
List<WebElement> elements = WebUI.findWebElements(testObj, 10)
for (int i = 0;  i < elements.size(); ++i) {
	KeywordUtil.logInfo(elements.get(i).toString())
}
*/

//*

AppiumDriver<MobileElement> driver = MobileDriverFactory.getDriver()

List<MobileElement> journeyPublicNames = driver.findElementsByXPath('//android.view.ViewGroup[@content-desc="card-journey_undefined-title"]/android.widget.TextView')      //''.findElementsById(Finder.findLabel('Journey/Browse/List Entry - Public Name'))
for (journeyPublicNameElement in journeyPublicNames) {
	println(journeyPublicNameElement.getText())
}


//*/


//Mobile.verifyElementText(Finder.findLabel('Journey/Browse/List Entry - Public Name'), UniqueJourneyName)
//Mobile.tap(Finder.findLabel('Journey/Browse/List Entry'), timeout)
//String JourneyNameText = Mobile.getText(Finder.findLabel('Journey/Details/Heading'), timeout)
//String JourneyNameText = Mobile.getAttribute(Finder.findLabel('Journey/Details/Heading'), 'text', timeout)
//println(JourneyNameText)

//Mobile.verifyElementExist(Finder.findLabel('Journey/Details/Heading'), timeout)

//Mobile.delay(10)

/*
Mobile.verifyElementVisible(Finder.findLabel('Journey/Browse/List Entry'), timeout)

Mobile.verifyElementVisible(Finder.findLabel('Journey/Browse/List Entry - Public Name'), timeout)

Mobile.verifyElementVisible(Finder.findLabel('Journey/Browse/List Entry - Image'), timeout)

Mobile.verifyElementVisible(Finder.findLabel('Journey/Browse/List Entry - Subtitle'), timeout)

Mobile.verifyElementVisible(Finder.findLabel('Journey/Browse/List Entry - Category'), timeout)
*/

//TextField.typeText(Finder.findTextField('Journey/Browse/Search'), UniqueJourneyName, timeout)
//Mobile.sendKeys(searchJourney, Keys.RETURN)

//TextField.clearText(Finder.findTextField('Journey/Browse/Search'), timeout)

Mobile.delay(3)

/* ===============================================

'tap on the found journey to show details page'
Mobile.tap(Finder.findLabel('Journey/Browse/List Entry'), timeout)
//Mobile.tap(Finder.findTextField('Journey/Browse/Search'), timeout)

Mobile.delay(3)

'wait for details page to fully displayed'
Mobile.waitForElementPresent(Finder.findLabel("Journey/Details/Heading"), timeout)

'Verify Journey Details header'
Mobile.verifyElementExist(Finder.findLabel('Journey/Details/Heading'), timeout)

if (Device.isIOS())
	Swipe.swipe(SwipeDirection.BOTTOM_TO_TOP)
	
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
//Mobile.verifyElementExist(Finder.findLabel('Journey/Browse/Journey In Progress Status'), timeout)

'tap on the started journey to show details page'
Mobile.tap(Finder.findLabel('Journey/Browse/List Entry'), timeout)

'wait for details page to fully displayed'
Mobile.waitForElementPresent(Finder.findLabel("Journey/Details/Heading"), timeout)

'swipe up to make stop journey button visible and accessible'
//if (!(Mobile.verifyElementVisible(Finder.findButton("Journey/Details/Stop Journey"), timeout)))
if (Device.isIOS())
	Swipe.swipe(SwipeDirection.BOTTOM_TO_TOP)
	
'tap on Stop Journey button'
Button.tap("Journey/Details/Stop Journey", timeout)

'tap on Stop Journey Yes confirmation button'
Button.tap("Journey/Details/Prompt Stop Journey Yes", timeout)

'tap on Journey Opted Out confirmation close button'
Button.tap("Journey/Details/Successfully Opted Out Close", timeout)

'Tap on Back button to get back to the Journey List'
Button.tap("Journey/Details/Back", timeout)

'Verify that journey in list has been updated to not In-Progress (status not displayed'
//Mobile.verifyElementNotExist(Finder.findLabel('Journey/Browse/Journey In Progress Status'), timeout)


/*
'Tap on a Journey that has been completed'

'Verify that the Journey Details are as defined with Completed status text and only View Pathway Button is displayed'

'Tap on Back button to get back to the Journey List'
*/

'Verify that there are unpublished journeys that the logged in user has authored'

'Tap on one of the unpublished journeys.'


'Navigate to Home'
Button.tap('Nav/Home Navigation Button', timeout)

'Log out'
Button.tap('Logout Button', timeout)

Mobile.closeApplication()


