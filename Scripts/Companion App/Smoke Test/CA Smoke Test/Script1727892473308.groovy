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

def timeout = 7

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

if (ShouldLogin.toBoolean()) {
    Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/My QR code'), 0)

    Mobile.tap(findTestObject('Object Repository/Companion App/Android/Buttons/Home Page/My QR code X button'), 0)
}

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Giving/Gift Icon'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Giving/Minimize Browser'), 0)

Mobile.delay(7, FailureHandling.STOP_ON_FAILURE)

if (ShouldLogin.toBoolean()) {
    Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Giving/Close SB Logged In Browser'), 0)
} else {
    Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Giving/Close Tithe.ly page'), 0)
}

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Engagement Pathway/Badges/Decision'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Engagement Pathway/Buttons/Decision - Learn More'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Engagement Pathway/Buttons/Back'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Engagement Pathway/Badges/Baptism'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Engagement Pathway/Buttons/Baptism - Learn More'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Engagement Pathway/Buttons/Back'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Engagement Pathway/Badges/Worship'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Engagement Pathway/Buttons/Find a Service'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Engagement Pathway/Buttons/Back'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Engagement Pathway/Badges/Small Groups'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Engagement Pathway/Buttons/Find A Group'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Engagement Pathway/Buttons/Back'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Engagement Pathway/Badges/Activate'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Engagement Pathway/Buttons/Register Today'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Engagement Pathway/Buttons/Back'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Engagement Pathway/Badges/Serving'), 5)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Engagement Pathway/Badges/Sharing'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Engagement Pathway/Buttons/Submit Your One Life'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Engagement Pathway/Buttons/X'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Engagement Pathway/Badges/Giving'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Engagement Pathway/Buttons/Give Now'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Giving/Minimize Browser'), 0)

Mobile.delay(7, FailureHandling.STOP_ON_FAILURE)

if (ShouldLogin.toBoolean()) {
    Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Giving/Close SB Browser'), 0)
} else {
    Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Giving/Close SB Logged Out Browser'), 0)
}

'tap on the left most For You tile'
not_run: Button.tap('Home Page/For You/First For You Item')

not_run: Mobile.delay(7)

'tap on the back button from For You details page'
not_run: Button.tap('Home Page/For You/For You Detail/Back')

not_run: Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/For You/First For You Item'), 0)

not_run: Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/For You/For You Detail/Back Button'), 0)

