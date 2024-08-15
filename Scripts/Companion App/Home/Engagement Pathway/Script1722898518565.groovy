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

WebUI.callTestCase(findTestCase('Companion App/Shared/Guest Startup'), [('UserName') : '', ('Password') : ''], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Badges/Accepted Christ'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/Tell Us Your Story'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/X'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Badges/Baptism'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/Baptism - Learn More'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/Back'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Badges/Worship'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/Service Times'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Nav/Home Navigation Button'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Badges/Groups'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/Find A Group'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/Back'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Badges/Activate'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/Activate'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/Back'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Badges/Serving'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/Serving - Learn More'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Nav/Home Navigation Button'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Badges/Sharing'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/Share Your Story'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/X'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Badges/Give'), 0)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home/Engagement Pathway/Buttons/Give Now'), 0)

