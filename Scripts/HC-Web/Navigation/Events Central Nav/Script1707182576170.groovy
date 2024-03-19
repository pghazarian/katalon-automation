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

'Verify Events Central Top Menu Navigation'
CustomKeywords.'NavigationHelper.clickTopMenuAndValidateHeader'('Events Central', 'All Events')

'Verify Events Central | All Events Navigation'
CustomKeywords.'NavigationHelper.clickSubmenuAndValidateHeader'('Events Central', 'All Events', 'All Events')

'Verify Events Central | Worship Service Setup Navigation'
CustomKeywords.'NavigationHelper.clickSubmenuAndValidateHeader'('Events Central', 'Worship Service Setup', 
    'Worship Service Setup')

'Verify Events Central | Event Catalogs Navigation'
CustomKeywords.'NavigationHelper.clickSubmenuAndValidateHeader'('Events Central', 'Event Catalogs', 'Event Catalogs')

'Verify Events Central | Settings & Preferences Navigation'
CustomKeywords.'NavigationHelper.clickSubmenuAndValidateHeader'('Events Central', 'Settings & Preferences',
	'Settings & Preferences')

'Verify Accommodations Sub Nav'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Settings and Preferences/Nav/Accommodations Tab Button'))
'Verify Data Header is present'
WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Event/Settings and Preferences/Accommodations/Data Header'), 0)

'Verify Event Categories Sub Nav'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Settings and Preferences/Nav/Event Categories Tab Button'))
'Verify Data Header is present'
WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Event/Settings and Preferences/Event Categories/Data Header'), 0)

'Verify Room Categories Sub Nav'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Settings and Preferences/Nav/Room Categories Tab Button'))
'Verify Data Header is present'
WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Event/Settings and Preferences/Room Categories/Data Header'), 0)

'Verify Service Categories Sub Nav'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Settings and Preferences/Nav/Service Categories Tab Button'))
'Verify Data Header is present'
WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Event/Settings and Preferences/Service Categories/Data Header'), 0)

'Verify Tags Sub Nav'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Settings and Preferences/Nav/Tags Tab Button'))
'Verify Data Header is present'
WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/Event/Settings and Preferences/Tags/Data Header'), 0)






