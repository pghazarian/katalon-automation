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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : "/my-ministry/volunteers/interested/$MinistryId/$CampusId"], 
    FailureHandling.STOP_ON_FAILURE)

'Click button to add a person as interested to ministry'
WebUI.click(findTestObject('HC-Web/Ministry/Interested/Add Interested Button'))

WebUI.waitForElementVisible(findTestObject('HC-Web/Ministry/Interested/Add Person Drawer/Person Search Bar'), 2)

'Search for a person to add'
WebUI.setText(findTestObject('HC-Web/Ministry/Interested/Add Person Drawer/Person Search Bar'), PersonSearchName + Keys.ENTER)

'Click on person in search results'
WebUI.click(findTestObject('HC-Web/Ministry/Interested/Add Person Drawer/Person Search Result', [('SearchName') : PersonSearchName]))

WebUI.waitForElementVisible(findTestObject('HC-Web/Ministry/Interested/Add Person Drawer/Expanded Person Record Select Button'), 
    2)

WebUI.scrollToPosition(0, 1300)

'Click button to add selected person as interested'
WebUI.click(findTestObject('HC-Web/Ministry/Interested/Add Person Drawer/Expanded Person Record Select Button'))

'Confirm selection'
WebUI.click(findTestObject('HC-Web/Ministry/Interested/Add Person Drawer/Add Person Prompt Yes Button'))

'Select an option for how person was introduced to ministry'
CustomKeywords.'FormHelper.setDropDownValue'('Source*', 'Email')

'Select an option for the person\'s status'
CustomKeywords.'FormHelper.setDropDownValue'('Status*', 'Pending')

'Click button to save responses'
WebUI.click(findTestObject('HC-Web/Ministry/Interested/Add Person Drawer/Save Button'))

'Confirm save'
WebUI.click(findTestObject('HC-Web/Ministry/Interested/Add Person Drawer/Save Person Prompt Yes Button'))

'Verify person appears in the interested list'
WebUI.verifyElementPresent(findTestObject('HC-Web/Ministry/Interested/Person In List Table Row', [('PersonName') : PersonSearchName]), 
    0)

'Click on the added person'
WebUI.click(findTestObject('HC-Web/Ministry/Interested/Person In List Table Row', [('PersonName') : PersonSearchName]), 
    FailureHandling.STOP_ON_FAILURE)

'Select the actions dropdown'
WebUI.click(findTestObject('HC-Web/Ministry/Interested/Selected Person Drawer/Actions Button'))

'Select the option to remove the person as interested'
WebUI.click(findTestObject('HC-Web/Ministry/Interested/Selected Person Drawer/Remove As Interested Option'))

'Confirm selection'
WebUI.click(findTestObject('HC-Web/Ministry/Interested/Selected Person Drawer/Remove From Ministry Yes Button'))

'Verify the person is no longer in the interested list'
WebUI.verifyElementNotPresent(findTestObject('HC-Web/Ministry/Interested/Person In List Table Row', [('PersonName') : PersonSearchName]), 
    0)

WebUI.closeBrowser(FailureHandling.STOP_ON_FAILURE)

