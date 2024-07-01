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

/*
*  Prerequisite: User must have a valid account on ME app to use on the Companion App to login
*  
* 1. Download and Open the Companion App (CA) from the home screen of the device
* 2. Login
* 3. Tap on user Profile (avatar) icon in the bottom of the main landing page of CA
* 4. User should navigate to the main Landing Page of their Profile
* 5. Verify that the language selection button is visible on the top left corner of the page Englih
* 6. Verify that the default language is English
* 7. Tap on the language selection button and verify that the language selection drawer is dispayed
* 8. Verify that the following elements are displayed in the language selection drawer:
* 9. Globe icon
* 10. Title: App Language
* 11. x to close the drawer when tapped
* 12. List of available languages (currently used language should have checkmark next to it)
* 13. Cancel button (closes drawer when tapped)
* 14. Apply button (Disabled until new language is selected)
* 15. Verify after selecting a language the Apply button will enable
* 16. Verify tapping on the Apply button will change the language of the user profile page to the newly selected language
* 17. Verify that the newly selected language will be displayed in the language selection button in its native presentation (i.e. show "Español" not "Spanish")
* 18. Verify that the text on the "My QR Code" button, is changed to "Check-In", In the main Landing Page of the user's profile
*/
WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [('UserName') : '', ('Password') : ''], FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Companion App/Android/Buttons/Home/Profile Web Avatar - Element'), 1)

'Profile photo icon - on lower navigation menu '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/Buttons/Home/Profile Web Avatar - Icon'), 0)

Mobile.verifyElementExist(findTestObject('Companion App/Android/User Profile/Language selection/Language - Element'), 1)

'Language button Object - Global icon'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/Language selection/Laguage Button'), 0)

'Espanol | Spanish - selection object '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/Language selection/Spanish language selection'), 
    0)

Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/Language selection/Apply Button'), 0)

Mobile.tap(findTestObject('Object Repository/Companion App/Android/Buttons/Home/Profile Web Avatar - Icon'), 0)

Mobile.verifyElementExist(findTestObject('Companion App/Android/User Profile/Settings/Settings - Element'), 1)

Mobile.tap(findTestObject('Companion App/Android/User Profile/Settings/Settings Button'), 0)

Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/Spanish/Perfil - Spanish Back button'), 
    0)

Mobile.tap(findTestObject('Companion App/Android/User Profile/Gift Icon/Gift Button'), 0)

Mobile.tap(findTestObject('Companion App/Android/User Profile/Gift Icon/X icon'), 0)

'Check In button in Spanish '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/Spanish/Registrarse Button - Check In button in Spanish'), 
    0)

'X button in Spanish QR code modal '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/Spanish/X Button - Spanish Check In QR Code modal'), 
    0)

Mobile.tap(findTestObject('Companion App/Android/User Profile/My Tiles/Buttons/My Notes Tile'), 0)

Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/Spanish/Perfil - Spanish Back button'), 
    0)

'My Prayers tile - Spanish '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/Spanish/Mis Oraciones'), 0)

Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/Spanish/Perfil - Spanish Back button'), 
    0)

Mobile.tap(findTestObject('Companion App/Android/User Profile/Spanish/Mis Ministerios'), 0)

Mobile.tap(findTestObject('Companion App/Android/User Profile/Spanish/Perfil - Spanish Back button'), 0)

Mobile.scrollToText('Mis Eventos', FailureHandling.STOP_ON_FAILURE)

'My Events Tile - Spanish '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/Spanish/Mis Eventos'), 0)

Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/Spanish/Perfil - Spanish Back button'), 
    0)

'Language button Object - Global icon'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/Language selection/Laguage Button'), 0)

'English language selection '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/Language selection/English language selection'), 
    0)

'Apply button - App Language drawer'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/Language selection/Apply Button'), 0)

'Settings icon, top right of User Profile page'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/Buttons/Home/Profile Web Avatar - Icon'), 0)

Mobile.closeApplication()

