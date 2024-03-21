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

Mobile.startApplication('C:\\Users\\paren\\Desktop\\MA 1.18.0 DEV build 98994.apk', true)

'Tap Login button '
Mobile.tap(findTestObject('Ministry App/Login button'), 0)

Mobile.setText(findTestObject('Object Repository/Ministry App/Email Address text field'), 'pareng@saddleback.com', 5)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Ministry App/Password Text Field'), 0)

Mobile.setEncryptedText(findTestObject('Ministry App/Password Text Field'), 'bGzvpoZCcaztWWDnaA3/tA==', 0)

Mobile.tap(findTestObject('Object Repository/Ministry App/Sign In Button'), 0)

Mobile.tap(findTestObject('Object Repository/Ministry App/Continue Button'), 0)

Mobile.tap(findTestObject('Object Repository/Ministry App/Got It Button'), 0)

Mobile.tap(findTestObject('Object Repository/Ministry App/android.view.ViewGroup'), 0)

Mobile.switchToNative()

Mobile.tap(findTestObject('Object Repository/Ministry App/android.view.ViewGroup'), 0)

Mobile.tap(findTestObject('Object Repository/Ministry App/android.widget.EditText - Looking for Someone'), 0)

Mobile.switchToNative()

Mobile.setText(findTestObject('Object Repository/Ministry App/android.widget.EditText - Looking for Someone'), 'Sarkis', 
    0)

Mobile.switchToNative()

Mobile.tap(findTestObject('Object Repository/Ministry App/android.view.ViewGroup (1)'), 0)

Mobile.switchToNative()

Mobile.switchToNative()

Mobile.switchToNative()

Mobile.verifyElementExist(findTestObject('Object Repository/Ministry App/android.widget.TextView - Results'), 0)

Mobile.tap(findTestObject('Object Repository/Ministry App/android.widget.TextView - Sarkis Sanger'), 0)

Mobile.switchToNative()

Mobile.verifyElementExist(findTestObject('Object Repository/Ministry App/android.widget.TextView - Sarkis Sanger (1)'), 
    0)

Mobile.verifyElementText(findTestObject('Object Repository/Ministry App/android.widget.TextView - Sarkis Sanger (1)'), 'Sarkis Sanger')

Mobile.tap(findTestObject('Object Repository/Ministry App/android.view.ViewGroup (2)'), 0)

Mobile.switchToNative()

Mobile.tap(findTestObject('Object Repository/Ministry App/android.view.ViewGroup (3)'), 0)

Mobile.verifyElementExist(findTestObject('Object Repository/Ministry App/android.widget.TextView - Hey Paren,'), 0)

Mobile.closeApplication()

