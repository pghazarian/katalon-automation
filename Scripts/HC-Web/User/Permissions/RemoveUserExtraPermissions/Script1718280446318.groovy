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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/system/users'], FailureHandling.STOP_ON_FAILURE)

WebUI.clearText(findTestObject('HC-Web/User/Search/SearchInput'))

WebUI.setText(findTestObject('HC-Web/User/Search/SearchInput'), UserEmail)

WebUI.waitForElementAttributeValue(findTestObject('HC-Web/User/Search/SearchInput'), 'value', UserEmail, 0)

'Initiate Search'
WebUI.sendKeys(findTestObject('HC-Web/User/Search/SearchInput'), Keys.chord(Keys.ENTER))

SearchTableCellObject = findTestObject('HC-Web/User/Search/SearchResultsPersonNameMatch', [('textToMatch') : UserEmail])

WebUI.waitForElementClickable(SearchTableCellObject, 0)

'Open the person record from the search results'
WebUI.click(SearchTableCellObject)

profileEditButton = findTestObject('HC-Web/User/Permission/User_Profile_Page/EditButton')

WebUI.waitForElementClickable(profileEditButton, 5)

WebUI.click(profileEditButton)

'Wait for page load'
WebUI.delay(4)

WebUI.waitForElementPresent(findTestObject('HC-Web/User/Permission/User_Profile_Page/ApplicationAdmin_Link'), 0)

WebUI.scrollToElement(findTestObject('HC-Web/User/Permission/User_Profile_Page/ApplicationAdmin_Link'), 0)

'Click Application Link'
WebUI.click(findTestObject('HC-Web/User/Permission/User_Profile_Page/ApplicationAdmin_Link'))

WebUI.delay(4)

WebUI.scrollToElement(findTestObject('HC-Web/User/Permission/User_Profile_Page/ApplicationAdmin_Link'), 0)

//Split the Extra Permissions into an array
String[] permissionsToRemove = PermissionsToRemove.split(',')

UserExtraPermissionInputBox = findTestObject('HC-Web/User/Permission/User_Profile_Page/User_ExtraPermissions_InputBox')

for (int i = 0; i < permissionsToRemove.length; i++) {
    permissionRemoveObject = findTestObject('HC-Web/User/Permission/User_Profile_Page/User_ExistingPermission_Remove', [
            ('textToMatch') : permissionsToRemove[i]])		
	
	if (permissionRemoveObject != null) {
		// Click the element if it is clickable
        WebUI.click(permissionRemoveObject)
	}
}

SaveButton = findTestObject('HC-Web/User/Permission/User_Profile_Page/SaveButton')

WebUI.waitForElementClickable(SaveButton, 1)

WebUI.click(SaveButton)

WebUI.waitForElementPresent(profileEditButton, 0)

WebUI.closeBrowser()

