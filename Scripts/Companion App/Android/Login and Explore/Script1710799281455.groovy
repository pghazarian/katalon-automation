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

'Launch the CA app'
Mobile.startExistingApplication('com.healthychurch.companion.development')

'tap button to log in.'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/Create Account or Login Button'), 0)

'Enter user credentials email address.'
Mobile.setText(findTestObject('Object Repository/Companion App/Android/User Email Text Entry'), 'sbchcqa@gmail.com', 0)

'Enter user credentials password'
Mobile.setText(findTestObject('Object Repository/Companion App/Android/Password Edit Text'), 'QA@dm1n*3', 0)

'tap the sign in button'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/Login Sign In Button'), 0)

'tap on the Journey navigation button.'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/Journey Navigation Button'), 0)
Mobile.verifyElementExist(findTestObject('Object Repository/Companion App/Android/Journey Heading'), 0)

'tap on the Profile navigation button.'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/Profile Navigation Button'), 0)
Mobile.verifyElementExist(findTestObject('Object Repository/Companion App/Android/Profile Heading'), 0)

'tap on the Discover navigation button.'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/Discover Navigation Button'), 0)
Mobile.verifyElementExist(findTestObject('Object Repository/Companion App/Android/Discover Heading'), 0)

'tap on the Groups navigation button.'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/Groups Navigation Button'), 0)
Mobile.verifyElementExist(findTestObject('Object Repository/Companion App/Android/Groups Heading'), 0)

'tap on the Ministries navigation button.'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/Ministries Navigation Button'), 0)
Mobile.verifyElementExist(findTestObject('Object Repository/Companion App/Android/Ministries Heading'), 0)

'tap on the Events navigation button.'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/Events Navigation Button'), 0)
Mobile.verifyElementExist(findTestObject('Object Repository/Companion App/Android/Events Heading'), 0)

'tap on the Home navigation button.'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/Home Navigation Button'), 0)
Mobile.verifyElementExist(findTestObject('Object Repository/Companion App/Android/Home Heading'), 0)

'tap on the Home page log out button.'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/Home Log Out Button'), 0)

Mobile.closeApplication()

