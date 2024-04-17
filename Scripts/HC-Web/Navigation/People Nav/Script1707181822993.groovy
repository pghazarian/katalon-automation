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

'Verify People Top Menu Navigation'
CustomKeywords.'NavigationHelper.clickTopMenuAndValidateHeader'('People', 'Search or Add')
'Verify People | Search or Add Navigation'
CustomKeywords.'NavigationHelper.clickSubmenuAndValidateHeader'('People', 'Search or Add', 'Search or Add')
'Verify People | Record Management Navigation'
CustomKeywords.'NavigationHelper.clickSubmenuAndValidateHeader'('People', 'Record Management', 'Record Management')
'Verify People | Settings and Preferences Navigation'
CustomKeywords.'NavigationHelper.clickSubmenuAndValidateHeader'('People', 'Settings and Preferences', 'Settings and Preferences')

'Verify the Sectional Navigation for Settings and Preferences'

'Verify Milestone Sub Nav'
WebUI.click(CustomKeywords.'TestObjectHelper.getTestObjectWithXpath'("//div[contains(@class, 'navigation_sectional_tabs--container')]//button[.='Milestones']"))
'Verify Milestones Header is present'
WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Person/Settings and Preferences/Milestones/Milestones Header'), 0)

'Verify Note Categories Sub Nav'
WebUI.click(CustomKeywords.'TestObjectHelper.getTestObjectWithXpath'("//div[contains(@class, 'navigation_sectional_tabs--container')]//button[.='Note Categories']"))
'Verify Add Note Category button is present'
WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Person/Settings and Preferences/Note Categories/Add Note Category Button'), 0)

'Verify Child & Student Sub Nav'
WebUI.click(CustomKeywords.'TestObjectHelper.getTestObjectWithXpath'("//div[contains(@class, 'navigation_sectional_tabs--container')]//button[.='Child & Student']"))
'Verify Grade Advancement header is present'
WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Person/Settings and Preferences/Child and Student/Grade Advancement Header'), 0)

