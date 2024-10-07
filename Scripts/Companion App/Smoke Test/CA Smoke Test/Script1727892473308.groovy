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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.detroitlabs.katalonmobileutil.device.Device as Device
import com.detroitlabs.katalonmobileutil.testobject.Button as Button

def timeout = 10

if (ShouldLogin.toBoolean()) {
    'Open existing app by logging into the app bundle id'
    WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [:], FailureHandling.STOP_ON_FAILURE)
} else {
    'Open existing app while logged out by the app bundle id'
    WebUI.callTestCase(findTestCase('Companion App/Shared/Guest Startup'), [:], FailureHandling.STOP_ON_FAILURE)
}

Boolean deviceIsiOS = Device.isIOS()

' need driver to get lists and close app'
AppiumDriver<MobileElement> driver = MobileDriverFactory.getDriver()

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/My QR code'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/My QR code X button'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Giving/Gift Icon'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Giving/Give Tithe Button'), 0)

not_run: Mobile.checkElement(findTestObject(null), 0)

not_run: Mobile.checkElement(findTestObject(null), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Badges/Accepted Christ'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/Tell Us Your Story'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/X'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Badges/Baptism'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/Baptism - Learn More'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/Back'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Badges/Worship'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/Service Times'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Nav/Home Navigation Button'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Badges/Groups'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/Find A Group'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/Back'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Badges/Activate'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/Activate'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/Back'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Badges/Serving'), 5)

// Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/Serving - Learn More'), 5)
Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Badges/Sharing'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/Share Your Story'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/X'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Badges/Give'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/Give Now'), 0)

'tap on the left most For You tile'
Button.tap('Home/Home Page/First For You Item')

Mobile.delay(5)

'tap on the CTA button'
Button.tap('Home/Home Page/For You Detail/CTA')

'tap on the back button from For You details page'
Button.tap('Home/Home Page/For You Detail/Back')

