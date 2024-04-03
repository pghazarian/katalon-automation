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

import com.detroitlabs.katalonmobileutil.device.App
import com.detroitlabs.katalonmobileutil.device.Device
import com.detroitlabs.katalonmobileutil.testobject.Finder
import com.detroitlabs.katalonmobileutil.testobject.Button
import com.detroitlabs.katalonmobileutil.testobject.TextField

def timeout = 3

'Open existing app by the app bundle id'
WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate to Resources'
Button.tap('Nav/Resources Navigation Button', timeout)

'Navigate to Profile'
Button.tap('Nav/Profile Navigation Button', timeout)

'Navigate to Journey'
Button.tap('Nav/Journey Navigation Button', timeout)

'Navigate to Discover'
Button.tap('Nav/Discover Navigation Button', timeout)

'Navigate to Settings'
Button.tap('Nav/Settings Navigation Button', timeout)

'Navigate to Home'
Button.tap('Nav/Home Navigation Button', timeout)

// add test for that
'Log out'
Button.tap('Logout Button', timeout)

//'Verify that the account is logged out'
//Mobile.verifyElementExist(findTestObject('Object Repository/Companion App/Splash/Splash Page Heading'), 0)
//
//'Verify that the text is present on the Welcome screen'
//Mobile.verifyElementText(findTestObject('Object Repository/Companion App/Splash/Splash Page Heading'), 'Welcome!')

'Close the app'
Mobile.closeApplication()



