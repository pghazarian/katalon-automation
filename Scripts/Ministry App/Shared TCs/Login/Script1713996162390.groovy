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
import io.appium.java_client.TouchAction as TouchAction
import io.appium.java_client.touch.offset.PointOption as PointOption
import io.appium.java_client.touch.WaitOptions as WaitOptions
import java.time.Duration as Duration
import io.appium.java_client.android.AndroidDriver as AndroidDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MultiTouchAction as MultiTouchAction

if (ForceLogin) {
    'Open the App'
    Mobile.startApplication(GlobalVariable.Ministry_App_Path, true)

    'Tap Login button '
    Mobile.tap(findTestObject('Ministry App/Login/Login button'), 0)

    Mobile.setText(findTestObject('Object Repository/Ministry App/Login/Email Address text field'), UserName, 5)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Ministry App/Login/Password Text Field'), 0)

    Mobile.setEncryptedText(findTestObject('Ministry App/Login/Password Text Field'), Password, 0)

    Mobile.tap(findTestObject('Object Repository/Ministry App/Login/Sign In Button'), 0)

    Mobile.tap(findTestObject('Object Repository/Ministry App/Login/Continue Button'), 0)

    Mobile.tap(findTestObject('Object Repository/Ministry App/Login/Got It Button'), 0)
} else {
    Mobile.startExistingApplication(GlobalVariable.Ministry_App_ID, FailureHandling.STOP_ON_FAILURE)
}

not_run: AppiumDriver<?> driver = MobileDriverFactory.getDriver()

not_run: MultiTouchAction multiTouch = new MultiTouchAction(driver)

not_run: TouchAction action1 = new TouchAction(driver)

not_run: int startX = 30

not_run: int startY = 30

not_run: action1.tap(PointOption.point(startX, startY))

not_run: action1.perform()

