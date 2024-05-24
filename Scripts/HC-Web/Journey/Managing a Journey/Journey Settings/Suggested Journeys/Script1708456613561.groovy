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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/journeys/suggested'], FailureHandling.STOP_ON_FAILURE)

'Edit suggested journeys'
WebUI.click(findTestObject('HC-Web/Journey/Settings and Preferences/Edit Button'))

'Attempt to remove journey to be added in case it is already suggested'
if (WebUI.waitForElementPresent(findTestObject('HC-Web/Journey/Settings and Preferences/Edit Suggested Journeys Drawer/Journey Checkbox', 
        [('JourneyName') : JourneyName]), 2)) {
    WebUI.click(findTestObject('HC-Web/Journey/Settings and Preferences/Edit Suggested Journeys Drawer/Journey Checkbox', 
            [('JourneyName') : JourneyName]))

    WebUI.click(findTestObject('Object Repository/HC-Web/Journey/Settings and Preferences/Edit Suggested Journeys Drawer/Delete Suggested Journey Button'))

    WebUI.click(findTestObject('Object Repository/HC-Web/Journey/Settings and Preferences/Edit Suggested Journeys Drawer/Delete Suggested Journey Confirmation Yes Button'))

    WebUI.click(findTestObject('HC-Web/Journey/Settings and Preferences/Edit Button'))

    WebUI.waitForElementNotPresent(findTestObject('HC-Web/Journey/Settings and Preferences/Edit Suggested Journeys Drawer/Journey Checkbox', 
            [('JourneyName') : JourneyName]), 3)
}

'Add new suggested journey'
WebUI.waitForElementVisible(findTestObject('HC-Web/Journey/Settings and Preferences/Edit Suggested Journeys Drawer/Add Journey Button'), 
    0)

'Add new suggested journey'
WebUI.click(findTestObject('HC-Web/Journey/Settings and Preferences/Edit Suggested Journeys Drawer/Add Journey Button'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Journey/Settings and Preferences/Edit Suggested Journeys Drawer/Add Journey Search Bar'), 
    2)

'Search for desired journey by name'
WebUI.setText(findTestObject('HC-Web/Journey/Settings and Preferences/Edit Suggested Journeys Drawer/Add Journey Search Bar'), 
    JourneyName + Keys.chord(Keys.ENTER))

'Click checkbox to select desired search result'
WebUI.click(findTestObject('HC-Web/Journey/Settings and Preferences/Edit Suggested Journeys Drawer/Journey Search Result', 
        [('JourneyName') : JourneyName]))

'Click button to add selected journey'
WebUI.click(findTestObject('HC-Web/Journey/Settings and Preferences/Edit Suggested Journeys Drawer/Add Selected Journeys'))

'Close edit suggested journeys drawer'
WebUI.click(findTestObject('HC-Web/Journey/Settings and Preferences/Edit Suggested Journeys Drawer/Close Journey Search Drawer Button'))

'Verify selected journey appears in suggested journeys'
WebUI.waitForElementPresent(findTestObject('HC-Web/Journey/Settings and Preferences/Suggested Journey Row', [('JourneyName') : JourneyName]), 
    3, FailureHandling.STOP_ON_FAILURE)

'Reopen drawer to edit suggested journeys'
WebUI.click(findTestObject('HC-Web/Journey/Settings and Preferences/Edit Button'))

'Select previously added journey'
WebUI.waitForElementVisible(findTestObject('HC-Web/Journey/Settings and Preferences/Edit Suggested Journeys Drawer/Journey Checkbox', 
        [('JourneyName') : JourneyName]), 2)

'Select previously added journey'
WebUI.click(findTestObject('HC-Web/Journey/Settings and Preferences/Edit Suggested Journeys Drawer/Journey Checkbox', [('JourneyName') : JourneyName]))

'Delete added journey from suggested journeys'
WebUI.click(findTestObject('HC-Web/Journey/Settings and Preferences/Edit Suggested Journeys Drawer/Delete Suggested Journey Button'))

WebUI.click(findTestObject('HC-Web/Journey/Settings and Preferences/Edit Suggested Journeys Drawer/Delete Suggested Journey Confirmation Yes Button'))

'Verify journey is no longer in list'
WebUI.waitForElementNotPresent(findTestObject('HC-Web/Journey/Settings and Preferences/Edit Suggested Journeys Drawer/Journey Checkbox', 
        [('JourneyName') : JourneyName]), 3, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

