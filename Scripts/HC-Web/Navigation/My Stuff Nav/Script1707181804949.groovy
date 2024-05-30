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

CustomKeywords.'NavigationHelper.clickTopMenuAndValidateHeader'('My Stuff', 'Home')

CustomKeywords.'NavigationHelper.clickSubmenuAndValidateHeader'('My Stuff', 'Home', 'Home')

CustomKeywords.'NavigationHelper.clickSubmenuAndValidateHeader'('My Stuff', 'My Follow Ups', 'My Follow Ups')

'Verify Categories Sub Nav'
WebUI.click(findTestObject("Object Repository/HC-Web/My Follow Ups/Subnavigation Button By Name Match", [('textToMatch') : 'Active']))
WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/My Follow Ups/Past 7 Days Heading Label'), 0)

'Verify Tags Sub Nav'
WebUI.click(findTestObject("Object Repository/HC-Web/My Follow Ups/Subnavigation Button By Name Match", [('textToMatch') : 'Escalated']))
WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/My Follow Ups/Past 7 Days Heading Label'), 0)

'Verify Tags Sub Nav'
WebUI.click(findTestObject("Object Repository/HC-Web/My Follow Ups/Subnavigation Button By Name Match", [('textToMatch') : 'Unclaimed']))
WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/My Follow Ups/Past 7 Days Heading Label'), 0)

'Verify Tags Sub Nav'
WebUI.click(findTestObject("Object Repository/HC-Web/My Follow Ups/Subnavigation Button By Name Match", [('textToMatch') : 'Completed']))
WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/My Follow Ups/Past 7 Days Heading Label'), 0)

'Verify Tags Sub Nav'
WebUI.click(findTestObject("Object Repository/HC-Web/My Follow Ups/Subnavigation Button By Name Match", [('textToMatch') : 'My Teams']))
WebUI.verifyElementPresent(findTestObject('Object Repository/HC-Web/My Follow Ups/Follow Ups Heading Label'), 0)

CustomKeywords.'NavigationHelper.clickSubmenuAndValidateHeader'('My Stuff', 'All Follow Ups', 'All Follow Ups')

// This will open the My Ministries page if the user has no ministries assigned or two or more ministries assigned
// If the user has exactly one ministry assigned, the one ministry will be automatically opened and this validation will fail
CustomKeywords.'NavigationHelper.clickSubmenuAndValidateHeader'('My Stuff', 'My Ministries', 'My Ministries')

CustomKeywords.'NavigationHelper.clickSubmenuAndValidateHeader'('My Stuff', 'Notifications', 'Notifications')

