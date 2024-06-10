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

WebUI.callTestCase(findTestCase('Ministry App/Shared TCs/Login'), [('UserName') : 'Pareng@Saddleback.com', ('Password') : 'bGzvpoZCcaztWWDnaA3/tA=='
        , ('ForceLogin') : false], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Ministry App/Navigation/Metrics icon'), 0)

'To open Trending page'
Mobile.tap(findTestObject('Object Repository/Ministry App/Metrics/Trending tab'), 0)

'To open Attendance menu options of Trending Reports '
Mobile.tap(findTestObject('Object Repository/Ministry App/Metrics/Attendance tile'), 0)

Mobile.tap(findTestObject('Object Repository/Ministry App/Metrics/Attendance Trend Report - menu option'), 0)

'To open the Filtering page for the Attendance trend reports  '
Mobile.tap(findTestObject('Object Repository/Ministry App/Metrics/Filter icon'), 0)

'To see all available Campus(es) - based on the logged in user\'s Permissions in HC admin '
Mobile.tap(findTestObject('Object Repository/Ministry App/Metrics/Campus - chevron icon'), 0)

'To select Anaheim campus '
Mobile.tap(findTestObject('Object Repository/Ministry App/Metrics/Anaheim Campus'), 0)

Mobile.tap(findTestObject('Ministry App/Metrics/Campus selections screen - Back button'), 0)

'To return Search results\r\n\t\t'
Mobile.tap(findTestObject('Object Repository/Ministry App/Metrics/Search button'), 0)

Mobile.tap(findTestObject('Object Repository/Ministry App/Metrics/8 Week Trend button'), 0)

