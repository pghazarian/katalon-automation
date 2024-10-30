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

/*
 1  Prerequisites:
	 - On HC Admin, publish a Service on a published Digital Program
	 - Make sure that there is an External Link setup for the Digital Program, before publishing it
	 - Make sure that there is an Connection Form setup for the Digital Program, before publishing it
	 - Which both can be done from the Builder tab of the Digital Program
 2	Goto HC Admin ME > Digital Program
 3	Select any DP and navigate to its Builder tab
 4	From the Builder tab, Make sure that the DP has an External Link & Connection Form setup on it
 5	From the Action bar Select a Campus
 6 	From the Action click on the View Page button to the left of the Edit Details button
 7	User should navigate to the DP SC widget page, to test the "browser" and the "widget" versions of the widget
 8	For now test only the browser, until (TBD) the widget is embedded in SB.com
 9	Verify that the widget can be tested from various channels
 10 Verify that user can complete a "Connection Form" from the Service Companion widget
 11 Verify that user can follow a "External Link" from the Service Companion widget
 */
WebUI.openBrowser('')

WebUI.navigateToUrl('https://hc-stage.saddleback.com/')

WebUI.setText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Service Companion Widget/Enter Email Address'), 
    'Pareng@saddleback.com')

WebUI.setEncryptedText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Service Companion Widget/Enter Password'), 
    'bGzvpoZCcaztWWDnaA3/tA==')

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Service Companion Widget/Sign In Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Service Companion Widget/Mobile Engagement'))

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Service Companion Widget/Digital Programs (beta)'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Service Companion Widget/Digital Program Name'), 
    'Paren DP')

WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Service Companion Widget/Digital Program Name'), 
    Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Service Companion Widget/First Row'))

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Service Companion Widget/Builder Tab'))

WebUI.delay(3)

WebUI.waitForElementVisible(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Service Companion Widget/Template Drop Menu'), 
    0)

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Service Companion Widget/Template Drop Menu'))

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Service Companion Widget/Brea Campus'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Service Companion Widget/View Page Button'))

WebUI.delay(5)

WebUI.switchToWindowTitle('Healthy Church')

WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Service Companion Widget/External link Button'))

