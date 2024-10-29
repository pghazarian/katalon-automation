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

WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [('UserName') : '', ('Password') : ''], FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Companion App/Android/Buttons/Home Page/Profile Web Avatar - Element'), 1)

'Profile photo icon - on lower navigation menu '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/Buttons/Home Page/Profile Web Avatar - Icon'), 0)

'My Prayers - Element '
Mobile.verifyElementExist(findTestObject('Companion App/Android/User Profile/My Tiles/Elements/My Prayers Header'), 1)

'My Prayer Tile '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/My Tiles/Buttons/My Prayers Tile'), 0)

Mobile.tap(findTestObject('Companion App/Android/User Profile/My Tiles/Buttons/Plus Button - New Prayer Request'), 0)

Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/My Tiles/Buttons/Anonymous Tab'), 
    0)

Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/My Tiles/Buttons/Request field'), 0)

Mobile.setText(findTestObject('Object Repository/Companion App/Android/User Profile/My Tiles/Buttons/Input Text value'), 
    'New Anonymous Prayer Request test', 0)

Mobile.hideKeyboard()

'Submit Button'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/My Tiles/Buttons/Submit Button'), 0)

'Done Button '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/My Tiles/Buttons/Done Button'), 0)

Mobile.tap(findTestObject('Companion App/Android/User Profile/My Tiles/Buttons/Profile Back Button'), 0)

