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
import io.appium.java_client.android.AndroidDriver as AndroidDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.android.AndroidKeyCode as AndroidKeyCode

WebUI.callTestCase(findTestCase('Ministry App/Login'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Ministry App/Looking for Someone and set text field'), 0)

Mobile.setText(findTestObject('Object Repository/Ministry App/Looking for Someone and set text field'), 'Sarkis', 
    0)

//Mobile.sendKeys(findTestObject('Ministry App/Looking for Someone and set text field'), '\n')
AndroidDriver<?> driver = MobileDriverFactory.getDriver()

driver.pressKeyCode(AndroidKeyCode.ENTER)

Mobile.tap(findTestObject('Object Repository/Ministry App/Sarkis Sanger'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Ministry App/Sarkis Sanger name text exists'), 
    0)

Mobile.verifyElementText(findTestObject('Object Repository/Ministry App/Sarkis Sanger name text exists'), 'Sarkis Sanger')

Mobile.tap(findTestObject('Object Repository/Ministry App/android.view.ViewGroup (2)'), 0)

Mobile.tap(findTestObject('Object Repository/Ministry App/android.view.ViewGroup (3)'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Ministry App/android.widget.TextView - Hey Paren,'), 0)

Mobile.tap(findTestObject('Object Repository/Ministry App/android.view.ViewGroup'), 0)

Mobile.tap(findTestObject('Object Repository/Ministry App/android.view.ViewGroup (1)'), 0)

Mobile.tap(findTestObject('Object Repository/Ministry App/android.view.ViewGroup (1)'), 0)

