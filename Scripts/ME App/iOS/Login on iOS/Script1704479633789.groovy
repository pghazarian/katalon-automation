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

Mobile.startExistingApplication('com.saddleback.healthychurchapp')

Mobile.tap(findTestObject('Object Repository/ME App/iOS/Login/XCUIElementTypeOther - Log In or Create an Account'), 0)

Mobile.tap(findTestObject('Object Repository/ME App/iOS/Login/XCUIElementTypeButton - Continue'), 0)

Mobile.tap(findTestObject('Object Repository/ME App/iOS/Login/XCUIElementTypeTextField - Email Address'), 0)

Mobile.sendKeys(findTestObject('Object Repository/ME App/iOS/Login/XCUIElementTypeTextField - Email Address'), 'crisf@saddleback.com')

Mobile.tap(findTestObject('Object Repository/ME App/iOS/Login/XCUIElementTypeSecureTextField - Password'), 0)

Mobile.sendKeys(findTestObject('Object Repository/ME App/iOS/Login/XCUIElementTypeSecureTextField - Password'), 'Saddleback123!')

Mobile.tap(findTestObject('Object Repository/ME App/iOS/Login/XCUIElementTypeButton - Sign In'), 0)

Mobile.tap(findTestObject('Object Repository/ME App/iOS/XCUIElementTypeButton - Discover'), 0)

Mobile.tap(findTestObject('Object Repository/ME App/iOS/XCUIElementTypeButton - Worship'), 0)

Mobile.tap(findTestObject('Object Repository/ME App/iOS/XCUIElementTypeButton - Journey'), 0)

Mobile.tap(findTestObject('Object Repository/ME App/iOS/XCUIElementTypeButton - Quick Scan'), 0)

Mobile.tap(findTestObject('Object Repository/ME App/iOS/XCUIElementTypeButton - Discover'), 0)

Mobile.tap(findTestObject('Object Repository/ME App/iOS/XCUIElementTypeButton - More'), 0)

Mobile.tap(findTestObject('Object Repository/ME App/iOS/XCUIElementTypeOther - avatar-button'), 0)

Mobile.tap(findTestObject('Object Repository/ME App/iOS/XCUIElementTypeOther - avatar-button'), 0)

Mobile.closeApplication()

