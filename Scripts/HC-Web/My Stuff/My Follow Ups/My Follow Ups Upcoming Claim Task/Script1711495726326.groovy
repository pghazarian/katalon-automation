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

def strFollowUpTaskPersonName = (GlobalVariable.Follow_Up_Task_Person_First_Name + '  ') + GlobalVariable.Follow_Up_Task_Person_Last_Name

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/data-capture/connection-forms'], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/List/Search Text Entry'), GlobalVariable.Follow_Up_Connection_Form_Name)

WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/List/Search Text Entry'), Keys.chord(
        Keys.ENTER))

WebUI.click(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/List/QA Automation Follow Up Test List Item'))

WebUI.click(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Entries/Entries Tab Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Entries/New Entry/New Entry Button'))

WebUI.click(findTestObject('HC-Web/Data Capture/Connection Forms/Entries/New Entry/Event Association - Modal/No Event Associated Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Entries/New Entry/Entry Type Modal/Next Button'))

WebUI.waitForElementVisible(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Entries/Add Entry Drawer/First Name Field'), 
    3)

WebUI.setText(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Entries/Add Entry Drawer/First Name Field'), 
    GlobalVariable.Follow_Up_Task_Person_First_Name)

WebUI.setText(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Entries/Add Entry Drawer/Last Name Field'), 
    GlobalVariable.Follow_Up_Task_Person_Last_Name)

WebUI.click(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Entries/Add Entry Drawer/Search Button'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Entries/Add Entry Drawer/Add Entry First Search Results'))

WebUI.waitForElementVisible(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Entries/Add Entry Drawer/Select Button'), 
    2)

WebUI.click(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Entries/Add Entry Drawer/Select Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Entries/Add Entry Drawer/Yes Confirmation Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Entries/New Entry/Add Entry Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Data Capture/Connection Forms/Entries/Im Done Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/Navigation Logo Image Button'))

WebUI.refresh()

WebUI.waitForElementVisible(findTestObject('Object Repository/HC-Web/My Follow Ups/My Follow Ups Menu Item'), 2)

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/My Follow Ups Menu Item'))

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/Unclaimed Tab Button'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/My Follow Ups Unclaimed/QA Automation Follow Up Rule Task List Item'))

WebUI.delay(3)

WebUI.click(CustomKeywords.'TestObjectHelper.getTestObjectWithXpath'("//div[text()='$strFollowUpTaskPersonName']/ancestor::tr/descendant::div[contains(@class,'icon-check')]"))

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/My Follow Ups Unclaimed/Unclaimed Follow Up Task Claim Drop Down'))

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/My Follow Ups Unclaimed/Unclaimed Follow Up Task Claim Drop Down Claim Follow Up'))

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/Active Tab Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/My Follow Ups Unclaimed/QA Automation Follow Up Rule Task List Item'))

WebUI.click(CustomKeywords.'TestObjectHelper.getTestObjectWithXpath'("//div[text()='$strFollowUpTaskPersonName']/ancestor::tr/descendant::div[contains(@class,'icon-check')]"))

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/My Follow Ups Active/Follow Up Successful Button'))

WebUI.waitForElementVisible(findTestObject('Object Repository/HC-Web/My Follow Ups/My Follow Ups Active/Active Follow Up Completed Banner'), 
    2)

WebUI.verifyElementVisible(findTestObject('Object Repository/HC-Web/My Follow Ups/My Follow Ups Active/Active Follow Up Completed Banner'))

WebUI.closeBrowser()

