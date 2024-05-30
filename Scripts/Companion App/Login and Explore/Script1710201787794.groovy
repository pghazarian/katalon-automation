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

'Open existing app by the app bundle id'
Mobile.startExistingApplication(GlobalVariable.CompanionApp_BundleId)

'Click Login Button'
Mobile.tap(findTestObject('Object Repository/Companion App/Splash/Log In or Create an Account Button'), 0)

'Click the Continue Button (from the OS to approve going to an external domain)'
Mobile.tap(findTestObject('Object Repository/Companion App/Login/Continue Button'), 0)

'Put focus in the Email Address field'
Mobile.tap(findTestObject('Object Repository/Companion App/Login/Email Address Text Field'), 0)

'Put focus in the Password field'
Mobile.tap(findTestObject('Object Repository/Companion App/Login/Password Text Field'), 0)

'Fill in the Email Address'
Mobile.setText(findTestObject('Object Repository/Companion App/Login/Email Address Text Field'), GlobalVariable.Admin_UserName, 
    0)

'Fill in the Password field (using Encypt method)'
Mobile.setEncryptedText(findTestObject('Object Repository/Companion App/Login/Password Text Field'), GlobalVariable.Admin_Password, 
    0)

'Click Sign In Button'
Mobile.tap(findTestObject('Object Repository/Companion App/Login/Sign In Button'), 0)

'Navigate to Home'
Mobile.tap(findTestObject('Companion App/Nav/Home Button'), 0)

'Navigate to Journey'
Mobile.tap(findTestObject('Object Repository/Companion App/Nav/Journey Button'), 0)

'Verify the Journey title'
Mobile.verifyElementText(findTestObject('Object Repository/Companion App/Misc/Journey Heading'), 'Journey')

'Navigate to Discover'
Mobile.tap(findTestObject('Object Repository/Companion App/Nav/Discover Button'), 0)

'Navigate to Groups'
Mobile.tap(findTestObject('Object Repository/Companion App/Nav/Groups Button'), 0)

'Navigate to Ministries'
Mobile.tap(findTestObject('Object Repository/Companion App/Nav/Ministries Button'), 0)

'Navigate to Events'
Mobile.tap(findTestObject('Object Repository/Companion App/Nav/Events Button'), 0)

'Verify the text on the page'
Mobile.verifyElementText(findTestObject('Object Repository/Companion App/Misc/Event Heading'), 'This is a dynamic screen.')

'Navigate to Profile'
Mobile.tap(findTestObject('Object Repository/Companion App/Nav/Profile Button'), 0)

'Type into the Search Text field'
Mobile.tap(findTestObject('Object Repository/Companion App/Misc/Search Text Field'), 0)

Mobile.setText(findTestObject('Object Repository/Companion App/Misc/Search Text Field'), 'Profile Search Text', 0)

'Log out'
Mobile.tap(findTestObject('Object Repository/Companion App/Misc/Logout Button'), 0)

'Verify that the account is logged out'
Mobile.verifyElementExist(findTestObject('Object Repository/Companion App/Splash/Splash Page Heading'), 0)

'Verify that the text is present on the Welcome screen'
Mobile.verifyElementText(findTestObject('Object Repository/Companion App/Splash/Splash Page Heading'), 'Welcome!')

'Close the app'
Mobile.closeApplication()

