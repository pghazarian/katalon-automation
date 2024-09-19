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

import com.detroitlabs.katalonmobileutil.device.App
import com.detroitlabs.katalonmobileutil.device.Device
import com.detroitlabs.katalonmobileutil.testobject.Finder
import com.detroitlabs.katalonmobileutil.testobject.Button
import com.detroitlabs.katalonmobileutil.testobject.TextField
import com.detroitlabs.katalonmobileutil.touch.Swipe as Swipe
import com.detroitlabs.katalonmobileutil.touch.Swipe.SwipeDirection as SwipeDirection
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver as AppiumDriver
import io.appium.java_client.MobileElement as MobileElement
import com.kms.katalon.core.testobject.TestObjectXpath
import org.openqa.selenium.WebElement
import io.appium.java_client.ios.IOSDriver

def timeout = 10

def OriginalPrefix = 'Mr.'
def OriginalFirstName = GlobalVariable.Admin_FirstName
def OriginalMiddleName = ' '
def OriginalLastName = GlobalVariable.Admin_LastName
def OriginalNickname = GlobalVariable.Admin_Nickname
def OriginalSuffix = ' '


def NewPrefix = GlobalVariable.Profile_AboutMe_NewPrefix 
def NewFirstName = GlobalVariable.Profile_AboutMe_NewFirstName 
def NewMiddleName = GlobalVariable.Profile_AboutMe_NewMiddleName
def NewLastName = GlobalVariable.Profile_AboutMe_NewLastName
def NewNickname = GlobalVariable.Profile_AboutMe_NewNickname
def NewSuffix = GlobalVariable.Profile_AboutMe_NewSuffix


'Open existing app by logging into the app bundle id'
WebUI.callTestCase(findTestCase('Companion App/Shared/Login QA Admin'), [:], FailureHandling.STOP_ON_FAILURE)

Boolean deviceIsiOS = false

if (Device.isIOS()) {
	deviceIsiOS = true
}

' need driver to get lists and close app'
AppiumDriver<MobileElement> driver = MobileDriverFactory.getDriver()

// Tap on Profile navigation button
if (Mobile.verifyElementVisible(Finder.findButton('Nav/Profile Avatar Navigation Button'), timeout, FailureHandling.OPTIONAL)) {
	'Tap on the profile avatar in the navigation'
	Button.tap('Nav/Profile Avatar Navigation Button')
}
else { 	// if no avatar then different nav button
	'Tap on the generic profile avatar in the navigation'
	Button.tap('Nav/Profile No Avatar Navigation Button')
}

// go to user setting page
Button.tap('Profile/Settings Gear')

// Tap on the About Me tile button
Mobile.waitForElementPresent(Finder.findButton('Profile/Settings/About Me'), timeout)
Button.tap('Profile/Settings/About Me')

try {
	Mobile.waitForElementPresent(Finder.findTextField('Profile/Settings/About Me/Prefix'), timeout)
	Mobile.clearText(Finder.findTextField('Profile/Settings/About Me/Prefix'), timeout)
	TextField.typeText(Finder.findTextField('Profile/Settings/About Me/Prefix'), NewPrefix + Keys.ENTER, timeout)
	
	// Update the First name text entry
	Mobile.clearText(Finder.findTextField('Profile/Settings/About Me/First Name'), timeout)
	TextField.typeText(Finder.findTextField('Profile/Settings/About Me/First Name'), NewFirstName + Keys.ENTER, timeout)
	
	// Update the Middle name text entry
	Mobile.clearText(Finder.findTextField('Profile/Settings/About Me/Middle Name'), timeout)
	TextField.typeText(Finder.findTextField('Profile/Settings/About Me/Middle Name'), NewMiddleName + Keys.ENTER, timeout)
	
	// Update the Last name text entry
	Mobile.clearText(Finder.findTextField('Profile/Settings/About Me/Last Name'), timeout)
	TextField.typeText(Finder.findTextField('Profile/Settings/About Me/Last Name'), NewLastName + Keys.ENTER, timeout)
	
	// Update the Nickname text entry
	Mobile.clearText(Finder.findTextField('Profile/Settings/About Me/Nickname'), timeout)
	TextField.typeText(Finder.findTextField('Profile/Settings/About Me/Nickname'), NewNickname + Keys.ENTER, timeout)
	
	// Update the suffix text entry
	Mobile.clearText(Finder.findTextField('Profile/Settings/About Me/Suffix'), timeout)
	TextField.typeText(Finder.findTextField('Profile/Settings/About Me/Suffix'), NewSuffix + Keys.ENTER, timeout)
	
	Mobile.scrollToText('Gender')

	// Update the Gender drop down
	Mobile.waitForElementPresent(Finder.findButton('Profile/Settings/About Me Page/Gender'), timeout)
	Button.tap('Profile/Settings/About Me Page/Gender')
	Button.tap('Profile/Settings/About Me Page/Female')
	
	Mobile.scrollToText('Save')

	// Update the Marital Status drop down
	Mobile.waitForElementPresent(Finder.findButton('Profile/Settings/About Me Page/Marital Status'), timeout)
	Button.tap('Profile/Settings/About Me Page/Marital Status')
	Button.tap('Profile/Settings/About Me Page/Single')
	
	// Update the Birthdate date picker
	Button.tap('Profile/Settings/About Me Page/Birthdate')
	Mobile.waitForElementPresent(Finder.findButton('Profile/Settings/About Me Page/Calendar September 15 1980'), timeout)
	Button.tap('Profile/Settings/About Me Page/Calendar September 15 1980')
	Button.tap('Profile/Settings/About Me Page/Calendar OK')
	
	// Update the Home Campus from drop down
	Button.tap('Profile/Settings/About Me Page/Campus')
	Mobile.scrollToText('Anaheim')
	Button.tap('Profile/Settings/About Me Page/Anaheim')
	
	// Update the Preferred Service from drop down
	Button.tap('Profile/Settings/About Me Page/Preferred Service')
	Button.tap('Profile/Settings/About Me Page/First Preferred Service')
	
	// Tap on the Save button
	Button.tap('Profile/Settings/About Me Page/Save')
	
	// Tap on the About Me tile button
	Mobile.waitForElementPresent(Finder.findButton('Profile/Settings/About Me'), timeout)
	Button.tap('Profile/Settings/About Me')
	
	// Verify change to the Prefix change
	Mobile.waitForElementPresent(Finder.findTextField('Profile/Settings/About Me/Prefix'), timeout)
	Mobile.verifyElementText(Finder.findTextField('Profile/Settings/About Me/Prefix'), NewPrefix)
	
	// Verify change to the first name change
	Mobile.verifyElementText(Finder.findTextField('Profile/Settings/About Me/First Name'), NewFirstName)
	
	// Verify change to the middle name change
	Mobile.verifyElementText(Finder.findTextField('Profile/Settings/About Me/Middle Name'), NewMiddleName)
	
	// Verify change to the last name change
	Mobile.verifyElementText(Finder.findTextField('Profile/Settings/About Me/Last Name'), NewLastName)
	
	// Verify change to the nickname change
	Mobile.verifyElementText(Finder.findTextField('Profile/Settings/About Me/Nickname'), NewNickname)
	
	// Verify change to the suffix change
	Mobile.verifyElementText(Finder.findTextField('Profile/Settings/About Me/Suffix'), NewSuffix)
	
	Mobile.scrollToText('Gender')

	// Verify change to the gender change
	Mobile.waitForElementPresent(Finder.findLabel('Profile/Settings/About Me/Gender'), timeout)
	Mobile.verifyElementText(Finder.findLabel('Profile/Settings/About Me/Gender'), 'Female')
	
	Mobile.scrollToText('Save')

	// Verify change to the Marital Status change
	Mobile.waitForElementPresent(Finder.findLabel('Profile/Settings/About Me/Marital Status'), timeout)
	Mobile.verifyElementText(Finder.findLabel('Profile/Settings/About Me/Marital Status'), 'Single')
	
	// Verify change to the Birthdate change
	Mobile.verifyElementText(Finder.findLabel('Profile/Settings/About Me/Birthdate'), '09/15/1980')
	
	// Verify change to the Home Campus change
	Mobile.verifyElementText(Finder.findLabel('Profile/Settings/About Me/Campus'), 'Anaheim')
}
finally {
	// Return all changes back to the original entries/selections
	Mobile.scrollToText('Prefix')
	
	// Restore the Prefix text entry
	Mobile.waitForElementPresent(Finder.findTextField('Profile/Settings/About Me/Prefix'), timeout)
	Mobile.clearText(Finder.findTextField('Profile/Settings/About Me/Prefix'), timeout)
	TextField.typeText(Finder.findTextField('Profile/Settings/About Me/Prefix'), OriginalPrefix + Keys.ENTER, timeout)
	
	// Update the First name text entry
	Mobile.clearText(Finder.findTextField('Profile/Settings/About Me/First Name'), timeout)
	TextField.typeText(Finder.findTextField('Profile/Settings/About Me/First Name'), OriginalFirstName + Keys.ENTER, timeout)
	
	// Update the Middle name text entry
	Mobile.clearText(Finder.findTextField('Profile/Settings/About Me/Middle Name'), timeout)
	
	// Update the Last name text entry
	Mobile.clearText(Finder.findTextField('Profile/Settings/About Me/Last Name'), timeout)
	TextField.typeText(Finder.findTextField('Profile/Settings/About Me/Last Name'), OriginalLastName + Keys.ENTER, timeout)
	
	// Update the Nickname text entry
	Mobile.clearText(Finder.findTextField('Profile/Settings/About Me/Nickname'), timeout)
	TextField.typeText(Finder.findTextField('Profile/Settings/About Me/Nickname'), OriginalNickname + Keys.ENTER, timeout)
	
	// Update the suffix text entry
	Mobile.clearText(Finder.findTextField('Profile/Settings/About Me/Suffix'), timeout)
	
	Mobile.scrollToText('Gender')

	// Update the Gender drop down
	Mobile.waitForElementPresent(Finder.findButton('Profile/Settings/About Me Page/Gender'), timeout)
	Button.tap('Profile/Settings/About Me Page/Gender')
	Button.tap('Profile/Settings/About Me Page/Male')
	
	Mobile.scrollToText('Save')

	// Update the Marital Status drop down
	Mobile.waitForElementPresent(Finder.findButton('Profile/Settings/About Me Page/Marital Status'), timeout)
	Button.tap('Profile/Settings/About Me Page/Marital Status')
	Button.tap('Profile/Settings/About Me Page/Married')
	
	// Update the Birthdate date picker
	Button.tap('Profile/Settings/About Me Page/Birthdate')
	Mobile.waitForElementPresent(Finder.findButton('Profile/Settings/About Me Page/Calendar September 30 1980'), timeout)
	Button.tap('Profile/Settings/About Me Page/Calendar September 30 1980')
	Button.tap('Profile/Settings/About Me Page/Calendar OK')
	
	// Update the Home Campus from drop down
	Button.tap('Profile/Settings/About Me Page/Campus')
	Mobile.scrollToText('Lake Forest')
	Button.tap('Profile/Settings/About Me Page/Lake Forest')
	
	// Update the Preferred Service from drop down
	Button.tap('Profile/Settings/About Me Page/Preferred Service')
	Button.tap('Profile/Settings/About Me Page/First Preferred Service')
	
	// Tap on the first preferred service
	Button.tap('Profile/Settings/About Me Page/First Preferred Service')
	
	// Tap on the Save button
	Button.tap('Profile/Settings/About Me Page/Save')
}

// Tap on the Contact Info tile button
Mobile.waitForElementPresent(Finder.findButton('Profile/Settings/Contact Info'), timeout)
Button.tap('Profile/Settings/Contact Info')

// Add a new phone number and save
String addedPhoneNumber = GlobalVariable.Profile_ContactInfo_AddPhoneNumber
Mobile.waitForElementPresent(Finder.findButton('Profile/Settings/Contact Info Page/Add Phone'), timeout)
Button.tap('Profile/Settings/Contact Info Page/Add Phone')
TextField.typeText(Finder.findTextField('Profile/Settings/Contact Info/Add Phone Page/Phone Number'), addedPhoneNumber + Keys.ENTER, timeout)
Mobile.waitForElementPresent(Finder.findButton('Profile/Settings/Contact Info Page/Add Phone Page/Save'), timeout)
Button.tap('Profile/Settings/Contact Info Page/Add Phone Page/Save')

// Verify new phone number added
Mobile.waitForElementPresent(Finder.findLabel('Profile/Settings/Contact Info/First Phone Number'), timeout)
Mobile.verifyElementText(Finder.findLabel('Profile/Settings/Contact Info/First Phone Number'), addedPhoneNumber)

// delete the newly added phone number
Button.tap('Profile/Settings/Contact Info Page/First Phone Number')
Mobile.waitForElementPresent(Finder.findButton('Profile/Settings/Contact Info Page/Edit Phone Page/Delete Phone'), timeout)
Button.tap('Profile/Settings/Contact Info Page/Edit Phone Page/Delete Phone')
Button.tap('Profile/Settings/Contact Info Page/Edit Phone Page/Confirm Phone Edit - Yes')

// Add a new email address and save
String addedEmailAddress = GlobalVariable.Profile_ContactInfo_AddEmailAddress
Mobile.waitForElementPresent(Finder.findButton('Profile/Settings/Contact Info Page/Add Email'), timeout)
Button.tap('Profile/Settings/Contact Info Page/Add Email')
TextField.typeText(Finder.findTextField('Profile/Settings/Contact Info/Add Email Page/Email'), addedEmailAddress + Keys.ENTER, timeout)
Mobile.waitForElementPresent(Finder.findButton('Profile/Settings/Contact Info Page/Add Email Page/Save'), timeout)
Button.tap('Profile/Settings/Contact Info Page/Add Email Page/Save')

// Verify new email address added
Mobile.waitForElementPresent(Finder.findLabel('Profile/Settings/Contact Info/Second Email Address'), timeout)
Mobile.verifyElementText(Finder.findLabel('Profile/Settings/Contact Info/Second Email Address'), addedEmailAddress)

// delete the newly added email address
Button.tap('Profile/Settings/Contact Info Page/Second Email Address')
Mobile.waitForElementPresent(Finder.findButton('Profile/Settings/Contact Info Page/Edit Email Page/Delete Email'), timeout)
Button.tap('Profile/Settings/Contact Info Page/Edit Email Page/Delete Email')
Button.tap('Profile/Settings/Contact Info Page/Edit Email Page/Confirm Email Edit - Yes')

// Add a new address and save
String addedAddress1 = GlobalVariable.Profile_ContactInfo_AddAddress1
String addedCity = GlobalVariable.Profile_ContactInfo_AddCity
String addedZip = GlobalVariable.Profile_ContactInfo_AddZipCode

Mobile.waitForElementPresent(Finder.findButton('Profile/Settings/Contact Info Page/Add Address'), timeout)
Button.tap('Profile/Settings/Contact Info Page/Add Address')

// add Address 1 field
Mobile.waitForElementPresent(Finder.findTextField('Profile/Settings/Contact Info/Add Address Page/Address1'), timeout)
TextField.typeText(Finder.findTextField('Profile/Settings/Contact Info/Add Address Page/Address1'), addedAddress1 + Keys.ENTER, timeout)

// add City field
TextField.typeText(Finder.findTextField('Profile/Settings/Contact Info/Add Address Page/City'), addedCity + Keys.ENTER, timeout)

// select State field
'Tap on the Sort By button'
Button.tap('Profile/Settings/Contact Info Page/Add Address Page/State')
Button.tap('Profile/Settings/Contact Info Page/Add Address Page/California')

Mobile.scrollToText('Zip')

// add Zip code field
TextField.typeText(Finder.findTextField('Profile/Settings/Contact Info/Add Address Page/Zip Code'), addedZip + Keys.ENTER, timeout)

// save the changes
Mobile.waitForElementPresent(Finder.findButton('Profile/Settings/Contact Info Page/Add Address Page/Save'), timeout)
Button.tap('Profile/Settings/Contact Info Page/Add Address Page/Save')

// Verify new address added
Mobile.waitForElementPresent(Finder.findLabel('Profile/Settings/Contact Info/Second Address'), timeout)
Boolean secondAddressVerified = Mobile.getText(Finder.findLabel('Profile/Settings/Contact Info/Second Address'), timeout).contains(addedAddress1)
Mobile.verifyEqual(secondAddressVerified, true)

// delete the newly added email address
Button.tap('Profile/Settings/Contact Info Page/Second Address')

Mobile.waitForElementPresent(Finder.findButton('Profile/Settings/Contact Info Page/Add Address Page/State'), timeout)
Mobile.scrollToText('Delete Address')

Button.tap('Profile/Settings/Contact Info Page/Edit Address Page/Delete Address')
Button.tap('Profile/Settings/Contact Info Page/Edit Address Page/Delete Address Confirmation - Yes')

Mobile.waitForElementPresent(Finder.findButton('Profile/Settings/Contact Info Page/Add Address'), timeout)
Mobile.scrollToText('Do Not Contact Me Via')

// Edit contact preferences
Button.tap('Profile/Settings/Contact Info Page/Edit Contact Preferences')

// Update the Preferred Contact Method from drop down and save
Mobile.waitForElementPresent(Finder.findButton('Profile/Settings/Contact Info Page/Edit Preferences Page/Contact Method - Email'), timeout)
Button.tap('Profile/Settings/Contact Info Page/Edit Preferences Page/Contact Method - Email')

// Update the Do Not Contact me via from drop down and save
Button.tap('Profile/Settings/Contact Info Page/Edit Preferences Page/Do Not Contact Me - Phone')

// save the changes
Button.tap('Profile/Settings/Contact Info Page/Edit Preferences Page/Save')

// Verify Updated Preferred Contact Method change
Mobile.verifyElementText(Finder.findLabel('Profile/Settings/Contact Info/Preferred Contact Method Selection'), 'Email')

// Verify Updated Do Not Contact me via change
Mobile.verifyElementText(Finder.findLabel('Profile/Settings/Contact Info/Do Not Contact Me Via Selection'), 'Phone')

// reset the preferences back to none
Button.tap('Profile/Settings/Contact Info Page/Edit Contact Preferences')

// Update the Preferred Contact Method from drop down and save
Mobile.waitForElementPresent(Finder.findButton('Profile/Settings/Contact Info Page/Edit Preferences Page/Contact Method - Email'), timeout)

// Reset the Do Not Contact me via from drop down and save
Button.tap('Profile/Settings/Contact Info Page/Edit Preferences Page/Do Not Contact Me - Email')
Button.tap('Profile/Settings/Contact Info Page/Edit Preferences Page/Do Not Contact Me - Phone')
Button.tap('Profile/Settings/Contact Info Page/Edit Preferences Page/Do Not Contact Me - Email')

// save the changes
Button.tap('Profile/Settings/Contact Info Page/Edit Preferences Page/Save')

'Navigate to Home'
Button.tap('Nav/Home Navigation Button', timeout)

'Log out'
Button.tap('Logout Button', timeout)

if (deviceIsiOS) {
	Mobile.closeApplication()
}
else {
	driver.terminateApp('com.healthychurch.companion.stage')
}
