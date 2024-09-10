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
import com.detroitlabs.katalonmobileutil.device.App as App
import com.detroitlabs.katalonmobileutil.device.Device as Device
import com.detroitlabs.katalonmobileutil.testobject.Finder as Finder
import com.detroitlabs.katalonmobileutil.testobject.Button as Button
import com.detroitlabs.katalonmobileutil.testobject.TextField as TextField

def timeout = 10

'Tap on the Profile button - WAITING ON ELEMENT ID'
if (Mobile.verifyElementVisible(Finder.findButton('Nav/Home Navigation Button'), timeout, FailureHandling.OPTIONAL)) {
	
	// If the user is logged in 
	if (Mobile.verifyElementVisible(Finder.findButton('Nav/Profile Avatar Navigation Button'), timeout, FailureHandling.OPTIONAL)) {
		'Tap on the profile avatar in the navigation'
		Button.tap('Nav/Profile Avatar Navigation Button')
		
		'Tap on the settings gear button'
		//Mobile.waitForElementPresent(Finder.findButton('Profile/Settings Gear'), timeout)
		Button.tap('Profile/Settings Gear')
		
		'Tap on the Account & Notifications button'
		///Mobile.waitForElementPresent(Finder.findButton('Profile/Settings/Account Notifications'), timeout)
		Button.tap('Profile/Settings/Account Notifications')
		
		'Tap on the Logout button'
		//Mobile.waitForElementPresent(Finder.findButton('Profile/Settings/Account Notifications'), timeout)
		Button.tap('Profile/Settings/Account Notifications Page/Logout')
	}
	else {
		// if the user is not logged in 
		'Tap on the generic profile avatar in the navigation'
		Button.tap('Nav/Profile No Avatar Navigation Button')
				
		'Tap on the settings gear button'
		Button.tap('Profile/Settings Gear')
		
		'Tap on the Account & Notifications button'
		Button.tap('Profile/Settings/Account Notifications')
		
		'Tap on the Logout button'
		Button.tap('Profile/Settings/Account Notifications Page/Logout')
	}
}


