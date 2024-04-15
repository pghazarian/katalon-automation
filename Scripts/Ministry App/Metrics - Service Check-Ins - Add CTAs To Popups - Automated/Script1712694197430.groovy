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

WebUI.callTestCase(findTestCase('Ministry App/Login'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Ministry App/Navigation/Metrics icon'), 0)

'To open Trending page'
Mobile.tap(findTestObject('Object Repository/Ministry App/Metrics/Trending tab'), 0)

'To open  Service Check-Ins Trending Reports'
Mobile.tap(findTestObject('Object Repository/Ministry App/Metrics/Service Check-Ins tile'), 0)

'To open 8 Weeks trends for Service Check-Ins'
Mobile.tap(findTestObject('Object Repository/Ministry App/Metrics/8 Week Trend button'), 0)

'This will open the actual weekly trend chart\'s pop up modal for Service Check-Ins & CTAs for the Latest Week'
Mobile.tap(findTestObject('Object Repository/Ministry App/Metrics/Chart for the latest week'), 0)

'To close the pop up '
Mobile.tap(findTestObject('Object Repository/Ministry App/Metrics/X button'), 0)

Mobile.scrollToText('Month')

Mobile.tap(findTestObject('Object Repository/Ministry App/Metrics/Month button'), 0)

