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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement
import com.detroitlabs.katalonmobileutil.device.Device as Device
import com.detroitlabs.katalonmobileutil.testobject.Button as Button
import com.kms.katalon.util.CryptoUtil as CryptoUtil

def timeout = 10

if (ShouldLogin.toBoolean()) {
    'Open existing app by logging into the app bundle id'

    // WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [:], FailureHandling.STOP_ON_FAILURE)
    'Open existing app by the app bundle id'
    WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [('UserName') : GlobalVariable.CA_UserName, ('Password') : GlobalVariable.CA_Password], 
        FailureHandling.STOP_ON_FAILURE // WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [:], FailureHandling.STOP_ON_FAILURE)
        )
} else {
    'Open existing app while logged out by the app bundle id'
    WebUI.callTestCase(findTestCase('Companion App/Shared/Guest Startup'), [:], FailureHandling.STOP_ON_FAILURE)
}

Boolean deviceIsiOS = Device.isIOS()

' need driver to get lists and close app'
AppiumDriver<MobileElement> driver = MobileDriverFactory.getDriver()

Mobile.scrollToText('Messages', FailureHandling.STOP_ON_FAILURE)

'tap on the left most Message tile'
Button.tap('Home/Home Page/First Message Item')

Mobile.delay(5)

'Service Companion Button, in Messages (Notes) page '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/Buttons/Home/Digital Program/Past Digital Program/Service Companion'), 
    0)

Mobile.delay(5)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Digital Program/Arrow Down Minimize Button'), 0, FailureHandling.STOP_ON_FAILURE)

'Back Button in Messages (Notes) page '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/Buttons/Home/Digital Program/Past Digital Program/Back Button'), 
    0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Nav/Home Navigation Button'), 0)

