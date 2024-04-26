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

Mobile.startApplication(GlobalVariable.ME_App_Path, false)

Mobile.tap(findTestObject('Object Repository/ME App/Android/Campus Selector/Continue As Guest Button'), 0)

Mobile.tap(findTestObject('ME App/Android/Campus Selector/Campus Selector Anaheim Option'), 0)

Mobile.tap(findTestObject('Object Repository/ME App/Android/Campus Selector/Campus Selector Continue Button'), 0)

Mobile.tap(findTestObject('ME App/Android/Navigation Items/Profile Icon'), 0)

Mobile.tap(findTestObject('ME App/Android/User Drawer/Navigation Items/My Prayers Tile'), 0)

Mobile.sendKeys(findTestObject('ME App/Android/User Drawer/My Prayers/Prayer Request Text Field'), 'Test Prayer')

Mobile.sendKeys(findTestObject('Object Repository/ME App/Android/User Drawer/My Prayers/First Name Text Field'), 'Test')

Mobile.sendKeys(findTestObject('Object Repository/ME App/Android/User Drawer/My Prayers/Last Name Text Field'), 'User')

Mobile.sendKeys(findTestObject('Object Repository/ME App/Android/User Drawer/My Prayers/Email Text Field'), 'sbchcqa@saddleback.com')

Mobile.scrollToText('Submit', FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/ME App/Android/User Drawer/My Prayers/Submit Button'), 0)

Mobile.verifyElementText(findTestObject('Object Repository/ME App/Android/User Drawer/My Prayers/Prayer Request Sent Header'), 
    'Prayer request sent.')

Mobile.tap(findTestObject('ME App/Android/User Drawer/My Prayers/Done Button'), 0)

Mobile.closeApplication()

