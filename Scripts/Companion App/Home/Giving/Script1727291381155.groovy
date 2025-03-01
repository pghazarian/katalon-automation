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

/*
 * 1- Open CA app & stay Logged out or Log in
 * 2- Tap on the Gift icon (from the top right corener of the CA homepage)
 * 3- User should link out to Giving page on SB.com
 * 4- Verify If logged Out user links out: Verify that they are NOT singly signed on with their CA credentials on SB.com
 * 5- Verify If logged In user links out: Verify that they are singly signed on with their CA credentials on SB.com
 * 6- Tap on the Give Tithe button
 * 7- User Should navigate to the Tithe.ly page to give
 * 8- Repeat the TC from everywhere there is a Gift/Giving icon in CA
*/
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

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Giving/Gift Icon'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Giving/Give Tithe Button'), 0)

