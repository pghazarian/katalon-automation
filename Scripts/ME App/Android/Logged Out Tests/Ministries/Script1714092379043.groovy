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

Mobile.tap(findTestObject('ME App/Android/Navigation Items/Discover Tab'), 0)

Mobile.tap(findTestObject('ME App/Android/Discover/Ministries Tab'), 0)

Mobile.tap(findTestObject('ME App/Android/Discover/Ministries/First Listed Ministry'), 0)

Mobile.scrollToText('Get Involved')

Mobile.tap(findTestObject('Object Repository/ME App/Android/Discover/Ministries/Get Involved Button'), 0)

Mobile.sendKeys(findTestObject('ME App/Android/Discover/Ministries/First Name Text Field'), 'Test')

Mobile.sendKeys(findTestObject('ME App/Android/Discover/Ministries/Last Name Text Field'), 'User')

Mobile.sendKeys(findTestObject('Object Repository/ME App/Android/Discover/Ministries/Email Text Field'), 'sbchcqa@saddleback.com')

Mobile.tap(findTestObject('ME App/Android/Discover/Ministries/Submit Button'), 0)

Mobile.tap(findTestObject('ME App/Android/Discover/Ministries/Done Button'), 0)

Mobile.closeApplication()

