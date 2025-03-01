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

def timeout = 10

def UserName = 'crisf@saddleback.com'

def Password = 'L7Agencl+b/SneXPYUjt0g=='

def emailsToRevoke = EmailToRevoke.toString().split(',')
def emailsToAssign = EmailToAssign.toString().split(',')

WebUI.openBrowser('https://my.katalon.com/')

/*
 * 1. Open Browser to https://my.katalon.com/
 * 2. Navigate to https://my.katalon.com/
 * 3. Click Login Link
 * 4. Fill in UserName
 * 5. Fill in Password
 * 6. Submit Credentials
 * 7. Navigate to the License page at https://my.katalon.com/organization-management?accountId=996304&orgId=1131606
 * 8. CLick License Link
 * 9. Verify "
 * 8. Revoke Access for Old User By Email Address, pareng@saddleback.com
 * 9. Add Access for New User By Email Address, crisf@saddleback.com
 */
WebUI.waitForElementPresent(findTestObject('Object Repository/Katalon Web/Login/Continue with email Link'), timeout) 

WebUI.click(findTestObject('Object Repository/Katalon Web/Login/Continue with email Link'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Katalon Web/Login/Log in Header'), timeout)

WebUI.setText(findTestObject('Object Repository/Katalon Web/Login/UserName Text Field'), UserName)

WebUI.setEncryptedText(findTestObject('Object Repository/Katalon Web/Login/Password Text Field'), Password)

WebUI.click(findTestObject('Object Repository/Katalon Web/Login/Log in Button'))

WebUI.navigateToUrl('https://my.katalon.com/organization-management?accountId=996304&orgId=1131606')

WebUI.click(findTestObject('Object Repository/Katalon Web/License Link'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Katalon Web/License Management/Header'), timeout)

def revokingIsSuccessful = false

'Attempt to revoke the first email that is visible on the page from our list'
for (emailToRevoke in emailsToRevoke) {
	try {
		
		if (WebUI.waitForElementPresent(findTestObject('Katalon Web/License Management/Person Row Checkbox By Email Match', [('textToMatch') : emailToRevoke]), timeout, FailureHandling.OPTIONAL)) {
			
			WebUI.click(findTestObject('Katalon Web/License Management/Person Row Checkbox By Email Match', [('textToMatch') : emailToRevoke]))
			
			WebUI.click(findTestObject('Object Repository/Katalon Web/License Management/Revoke Button'))
			
			WebUI.click(findTestObject('Object Repository/Katalon Web/License Management/Revoke Remove Confirm Button'))
			
			WebUI.verifyElementPresent(findTestObject('Object Repository/Katalon Web/License Management/Loading Spinner'), timeout)
			
			WebUI.waitForElementNotVisible(findTestObject('Object Repository/Katalon Web/License Management/Loading Spinner'), timeout)
			
			revokingIsSuccessful = true
			
			break
		}
	}
	catch (Exception ex) {
		
		println("Could not revoke, $emailToRevoke")
		
	}
}

WebUI.verifyEqual(revokingIsSuccessful, true)

def assigningIsSuccessful = false
def assignedEmail = ''

WebUI.click(findTestObject('Object Repository/Katalon Web/License Management/Assign Button'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Katalon Web/Assign License/Assign License Button'), timeout)

'Attempt to assign the first email that can been assigned'
for (emailToAssign in emailsToAssign) {
	try {

		if (WebUI.waitForElementPresent(findTestObject('Object Repository/Katalon Web/Assign License/Person Row Checkbox By Email Match', [('textToMatch') : emailToAssign]), timeout, FailureHandling.OPTIONAL)) {
			
			WebUI.click(findTestObject('Object Repository/Katalon Web/Assign License/Person Row Checkbox By Email Match', [('textToMatch') : emailToAssign]))
			
			WebUI.click(findTestObject('Object Repository/Katalon Web/Assign License/Assign License Button'))
			
			WebUI.waitForElementPresent(findTestObject('Object Repository/Katalon Web/Assign License/Assign Success Banner'), timeout)
			
			assigningIsSuccessful = true
			assignedEmail = emailToAssign
			
			break
			
		}
	}
	catch (Exception ex) {
		
		println("Could not assign, $emailToAssign")
		
	}
}

WebUI.verifyEqual(assigningIsSuccessful, true)

WebUI.click(findTestObject('Object Repository/Katalon Web/Assign License/Close Button'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Katalon Web/License Management/Header'), timeout)

WebUI.verifyElementPresent(findTestObject('Katalon Web/License Management/Person Row Checkbox By Email Match', [('textToMatch') : assignedEmail]), timeout)


