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

def FollowUpTaskPersonName = "$GlobalVariable.Follow_Up_Task_Person_First_Name $GlobalVariable.Follow_Up_Task_Person_Last_Name"

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/data-capture/connection-forms'], FailureHandling.STOP_ON_FAILURE)

'Search for the Connection Form (for followup)'
WebUI.setText(findTestObject('Object Repository/HC-Web/Connection Form/List/Search Text Entry'), GlobalVariable.Follow_Up_Connection_Form_Name)

WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Connection Form/List/Search Text Entry'), Keys.chord(Keys.ENTER))

'Open Connection Form record'
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/List/List Item By Name Match', [('textToMatch') : GlobalVariable.Follow_Up_Connection_Form_Name]))

'Go to the Entries tab'
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/Entries Tab Button'))

'Click the New Entry button'
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/New Entry Button'))

'Select the "No Event Associated" button'
WebUI.waitForElementVisible(findTestObject('Object Repository/HC-Web/Connection Form/Entries/Connection Form Event Association Modal/No Event Associated Button'), 
    2)

'Select the "No Event Associated" button'
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/Connection Form Event Association Modal/No Event Associated Button'))

'Click Next button'
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/Connection Form Person Entry Type Modal/Next Button'))

WebUI.delay(3)

'Enter the Person\'s name to be assigned to the Connection Form Entry'
WebUI.setText(findTestObject('Object Repository/HC-Web/Connection Form/Entries/Add Entry Drawer/Person Search First Name Text Entry'), 
    GlobalVariable.Follow_Up_Task_Person_First_Name)

WebUI.setText(findTestObject('Object Repository/HC-Web/Connection Form/Entries/Add Entry Drawer/Person Search LastName Text Entry'), 
    GlobalVariable.Follow_Up_Task_Person_Last_Name)

'Search for the Person'
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/Add Entry Drawer/Search Button'))

WebUI.delay(3)

'Select the person summary row'
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entry/Add Entry Drawer/Person Search Results Summary Panel Name Match', 
        [('textToMatch') : FollowUpTaskPersonName]))

'After that, click the Select button button on that person summary row'
WebUI.waitForElementVisible(findTestObject('Object Repository/HC-Web/Connection Form/Entry/Add Entry Drawer/Person Search Results Details Panel Button Match', 
        [('textToMatch') : FollowUpTaskPersonName]), 2)

'After that, click the Select button button on that person summary row'
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entry/Add Entry Drawer/Person Search Results Details Panel Button Match', 
        [('textToMatch') : FollowUpTaskPersonName]))

'Confirm the Selection '
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entry/Add Entry Drawer/Person Search Results Summary Panel Yes Confirmation Button Match', 
        [('textToMatch') : FollowUpTaskPersonName]))

'Click the Add Entry Button'
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/Add Entry Button'))

'Click the "I\'m Done" button to advance to this point'
WebUI.click(findTestObject('Object Repository/HC-Web/Connection Form/Entries/Im Done Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/Navigation Logo Image Button'))

//WebUI.refresh()
'Click on the My Follow Up menu item'
WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/My Follow Ups Menu Item'))

'Click on the Unclamfiep menu item'
WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/Unclaimed Tab Button'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/My Follow Ups Unclaimed/QA Automation Follow Up Rule Task List Item'))

WebUI.delay(3)

WebUI.click(findTestObject('HC-Web/My Follow Ups/Table Row Check Input By Name Match', [('textToMatch') : FollowUpTaskPersonName]))

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/My Follow Ups Unclaimed/Unclaimed Follow Up Task Claim Drop Down'))

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/My Follow Ups Unclaimed/Unclaimed Follow Up Task Claim Drop Down Claim Follow Up'))

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/Active Tab Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/My Follow Ups Unclaimed/QA Automation Follow Up Rule Task List Item'))

WebUI.delay(5)

WebUI.waitForElementVisible(findTestObject('Object Repository/HC-Web/My Follow Ups/Table Row Person Name By Name Match', 
        [('textToMatch') : FollowUpTaskPersonName]), 5)

'Select follow ups record by person name to open drawer'
WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/Table Row Person Name By Name Match', [('textToMatch') : FollowUpTaskPersonName]))

'Click More Actions... button'
WebUI.click(findTestObject('Object Repository/HC-Web/Shared Component/Person Record Drawer/Actions/More Actions Button'))

'Click Reassign button'
WebUI.click(findTestObject('Object Repository/HC-Web/Shared Component/Person Record Drawer/Actions/Reassign Button'))

WebUI.waitForElementVisible(findTestObject('Object Repository/HC-Web/My Follow Ups/Reassign Drawer/All Pill Button'), 2)

'Click "All" Pill Button'
WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/Reassign Drawer/All Pill Button'))

WebUI.setText(findTestObject('Object Repository/HC-Web/My Follow Ups/Reassign Drawer/Assignee Name Text Field'), GlobalVariable.Admin2_FullName)

WebUI.delay(1)

WebUI.waitForElementVisible(findTestObject('Object Repository/HC-Web/My Follow Ups/Reassign Drawer/Person Suggestion Name Match', 
        [('textToMatch') : GlobalVariable.Admin2_FullName]), 2)

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/Reassign Drawer/Person Suggestion Name Match', [('textToMatch') : GlobalVariable.Admin2_FullName]))

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/Reassign Drawer/Reassign Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/Reassign Drawer/Reassign Yes Confirmation Button'))

'Log out by click on the User Avatar Button'
WebUI.click(findTestObject('Object Repository/HC-Web/Shared Component/User Menu/Avatar Button'))

'Select Log Out Option'
WebUI.click(findTestObject('Object Repository/HC-Web/Shared Component/User Menu/Log Out Menu Option'))

'Login as the other Admin'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin2_UserName
        , ('Password') : GlobalVariable.Admin2_Password, ('TargetPath') : '/my-dashboard/follow-ups/in-progress', ('ForceLogin') : true], 
    FailureHandling.STOP_ON_FAILURE)

'Open the Upcoming Follow Ups'
WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/Upcoming Follow Up Name Match', [('textToMatch') : GlobalVariable.Follow_Up_Name]))

'Select follow ups record by person name to open drawer'
WebUI.click(findTestObject('Object Repository/HC-Web/My Follow Ups/Table Row Person Name By Name Match', [('textToMatch') : FollowUpTaskPersonName]))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Shared Component/Person Record Drawer/Person Full Name'), 
    FollowUpTaskPersonName)

WebUI.click(findTestObject('Object Repository/HC-Web/Shared Component/Person Record Drawer/Actions/Successful Button'))

WebUI.waitForElementVisible(findTestObject('Object Repository/HC-Web/My Follow Ups/My Follow Ups Active/Status Updated Success Banner'), 
    2)

WebUI.verifyElementVisible(findTestObject('Object Repository/HC-Web/My Follow Ups/My Follow Ups Active/Status Updated Success Banner'))

WebUI.closeBrowser()

