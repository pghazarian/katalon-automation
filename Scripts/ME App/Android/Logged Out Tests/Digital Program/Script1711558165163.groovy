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

Mobile.startApplication('C:\\Users\\gclov\\Downloads\\hc-android-release (5).apk', false)

Mobile.tap(findTestObject('Object Repository/ME App Android/Campus Selector/Continue As Guest Button'), 0)

Mobile.tap(findTestObject('ME App Android/Campus Selector/Campus Selector Anaheim Option'), 0)

Mobile.tap(findTestObject('Object Repository/ME App Android/Campus Selector/Campus Selector Continue Button'), 0)

Mobile.tap(findTestObject('Object Repository/ME App Android/Worship Page/Digital Program Tile'), 0)

Mobile.tap(findTestObject('Object Repository/ME App Android/Digital Program/Check-In Button'), 0)

Mobile.sendKeys(findTestObject('Object Repository/ME App Android/Digital Program/Check In/First Name Text Field'), 'Test')

Mobile.sendKeys(findTestObject('Object Repository/ME App Android/Digital Program/Check In/Last Name Text Field'), 'User')

Mobile.scrollToText('Address 1')

Mobile.sendKeys(findTestObject('ME App Android/Digital Program/Check In/Email Address Text Field'), 'sbchcqa@saddleback.com')

Mobile.sendKeys(findTestObject('Object Repository/ME App Android/Digital Program/Check In/Phone Number Text Field'), '12345678900')

Mobile.scrollToText('Submit')

Mobile.tap(findTestObject('Object Repository/ME App Android/Digital Program/Check In/Submit Button'), 0)

Mobile.verifyElementText(findTestObject('ME App Android/Digital Program/Check In/Confirmation Message'), 'Thanks for connecting with us!')

Mobile.tap(findTestObject('Object Repository/ME App Android/Digital Program/Check In/Done Button'), 0)

Mobile.closeApplication()

