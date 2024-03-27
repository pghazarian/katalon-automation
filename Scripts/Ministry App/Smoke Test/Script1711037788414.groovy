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

'Tap into the "Looking for Somebody" field'
Mobile.tap(findTestObject('Object Repository/Ministry App/Home Page/Person Search text field'), 0)

'Enter text into the "Looking for Somebody" field'
Mobile.setText(findTestObject('Object Repository/Ministry App/Home Page/Person Search text field'), 'Sarkis', 0)

//Mobile.sendKeys(findTestObject('Ministry App/Home Page/Person Search text field'), '\n')
AndroidDriver<?> driver = MobileDriverFactory.getDriver()

'Hit the Done or Enter key on the keyboard to initiate the search '
driver.pressKeyCode(AndroidKeyCode.ENTER)

'Tap on person name to view record '
Mobile.tap(findTestObject('Object Repository/Ministry App/Search/Results/Person Name in Results'), 0)

not_run: Mobile.verifyElementExist(findTestObject('Object Repository/Ministry App/Person Record/Person Name'), 0)

'Verify the name matches in the person record\'s drawer details \r\n'
Mobile.verifyElementText(findTestObject('Object Repository/Ministry App/Person Record/Person Name'), 'Sarkis Sanger')

'Back button on top left of Person Record'
Mobile.tap(findTestObject('Object Repository/Ministry App/Person Record/Back Button'), 0)

Mobile.tap(findTestObject('Ministry App/Navigation/Home icon'), 0)

'This is the Hey "user\'s first name" message '
Mobile.verifyElementExist(findTestObject('Object Repository/Ministry App/Home Page/Welcome Message'), 0)

'To enter into user\'s profile drawer (top right) '
Mobile.tap(findTestObject('Object Repository/Ministry App/Navigation/User Profile Avatar'), 0)

'To open user\'s profile drawer '
Mobile.tap(findTestObject('Object Repository/Ministry App/Navigation/X Button'), 0)

'To close user\'s profile drawer '
Mobile.tap(findTestObject('Ministry App/Navigation/X Button'), 0)

