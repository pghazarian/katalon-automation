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

def strFollowUpTaskPersonName = GlobalVariable.Follow_Up_Task_Person_First_Name + "  " + GlobalVariable.Follow_Up_Task_Person_Last_Name

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Data Capture Navigation Item'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Connection Form/List/Search Text Entry'), GlobalVariable.Follow_Up_Connection_Form_Name)

WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Connection Form/List/Search Text Entry'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/List/QA Automation Follow Up Test List Item'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/Entries Tab Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/New Entry Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/Connection Form Event Association Modal/No Event Associated Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/Connection Form Person Entry Type Modal/Next Button'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Connection Form/Entries/Add Entry Drawer/Person Search First Name Text Entry'), 
    GlobalVariable.Follow_Up_Task_Person_First_Name)

WebUI.setText(findTestObject('Object Repository/HC-Web/Connection Form/Entries/Add Entry Drawer/Person Search LastName Text Entry'), 
    GlobalVariable.Follow_Up_Task_Person_Last_Name)

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/Add Entry Drawer/Search Button'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entry/Add Entry Drawer/Add Entry First Search Results'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/Add Entry Drawer/Select Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/Add Entry Drawer/Yes Confirmation Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/Add Entry Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/Im Done Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Navigation Logo Image Button'))

WebUI.refresh()

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/My Follow Ups Menu Item'))

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/Unclaimed Tab Button'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/My Follow Ups Unclaimed/QA Automation Follow Up Rule Task List Item'))

WebUI.delay(3)

WebUI.click(CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'("//div[text()='$strFollowUpTaskPersonName']/ancestor::tr/descendant::div[contains(@class,'icon-check')]"))

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/My Follow Ups Unclaimed/Unclaimed Follow Up Task Claim Drop Down'))

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/My Follow Ups Unclaimed/Unclaimed Follow Up Task Claim Drop Down Claim Follow Up'))

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/Active Tab Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/My Follow Ups Unclaimed/QA Automation Follow Up Rule Task List Item'))

WebUI.click(CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'("//div[text()='$strFollowUpTaskPersonName']/ancestor::tr/descendant::div[contains(@class,'icon-check')]"))

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/My Follow Ups Active/Follow Up Successful Button'))

WebUI.verifyElementVisible(findTestObject('Object Repository/HC-Web/My Follow Ups/My Follow Ups Active/Active Follow Up Completed Banner'))

WebUI.closeBrowser()

