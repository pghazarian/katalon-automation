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

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('HC-Web/Navigation/Mobile Engagement Navigation Button'))

ServiceCompanionName = ('Katalon Test Service Companion ' + UUID.randomUUID())

WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/New Service Companion Button'))

WebUI.setText(findTestObject('HC-Web/Mobile Engagement/Service Companion/Name Text Field'), ServiceCompanionName)

WebUI.setText(findTestObject('HC-Web/Mobile Engagement/Service Companion/Description Text Field'), 'Service Companion Created by Katalon Test')

CustomKeywords.'customUtility.TestObjectHelper.setDropDownValue'('react-select-3--value', Speaker)

CustomKeywords.'customUtility.TestObjectHelper.setDropDownValue'('react-select-4--value', Series)

WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/Add Connection Form Button'))

WebUI.setText(findTestObject('HC-Web/Mobile Engagement/Service Companion/Add Connection Form Search Bar'), ConnectionForm)

WebUI.sendKeys(findTestObject('HC-Web/Mobile Engagement/Service Companion/Add Connection Form Search Bar'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/First Connection Form Search Result'))

WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/Add Selected Connection Form'))

WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/Add Announcement Button'))

WebUI.setText(findTestObject('HC-Web/Mobile Engagement/Service Companion/Add Announcement Search Bar'), Announcement)

WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/First Announcement Search Result'))

WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/Add Selected Announcement Button'))

WebUI.click(findTestObject('HC-Web/Mobile Engagement/Service Companion/Save Service Companion Button'))

WebUI.waitForElementNotPresent(findTestObject('HC-Web/Mobile Engagement/Service Companion/New Service Companion Drawer Container'), 
    10)

WebUI.setText(findTestObject('HC-Web/Mobile Engagement/Service Companion/Search Bar'), ServiceCompanionName)

WebUI.sendKeys(findTestObject('HC-Web/Mobile Engagement/Service Companion/Search Bar'), Keys.chord(Keys.ENTER))

CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpathTextMatch'('//td[@id=\'data_grid--table_page_cell_base-2_0\']', 
    ServiceCompanionName, 1)

WebUI.closeBrowser()

