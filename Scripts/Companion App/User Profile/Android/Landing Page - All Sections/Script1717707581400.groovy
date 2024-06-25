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
 * Preprquisite: User must have a valid account on ME app to use on the Compainion App to login
 * 1. Download and Open the Companinion App (CA) from the home screen of the device
 * 2. Login
 * 3. Tap on user Profile icon in the main landing page of CA
 * 4. User should navigate to the main landing page of their profile
 * 5. Verify the following are dipslayed:
 * 6. User's photo is displayed (if applicable)
 * 7. Hey, [user first name]! greeting
 * 8. Gear icon: Tapping will link the user to the Settings area inside the profile
 * 9. Gift icon: Tapping will link the user to the Giving area outside the profile
 * 10. My QR Code button: Tapping will bring up the user's QR code in a drawer
 * 11. My Notes tile, with its icon in it
 * 12. My Prayers tile, with its icon in it
 * 13. My Groups tile, with its icon in it
 * 14. My Ministries tile, with its icon in it
 * 15. My Serving Activity tile, with its icon in it
 * 16. My Serving Opportunities tile, with its icon in it
 * 17. My Events tile, with its icon in it
 * 18. My Giving tile, with its icon in it
 * 19. Global navigation bar should appear at the bottom of the screen should work, and take the user to the correct destinations
 * 20. FYI Notes: tapping on all the tiles above will link to a place holder for now with the exception of My Ministries and My Events
 * 21. Tapping on the "My Ministries" button should navigate the user to the My Ministries screen
 * 22. Tapping on the "My Events" button should navigate the user to the My Events Screen
 */
WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [('UserName') : '', ('Password') : ''], FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Companion App/Android/Buttons/Home/Profile Web Avatar - Element'), 1)

'Profile photo icon - on lower navigation menu '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/Buttons/Home/Profile Web Avatar - Icon'), 0)

Mobile.verifyElementExist(findTestObject('Companion App/Android/User Profile/Settings Icon/Settings - Element'), 1)

'Settings icon, top right of User Profile page'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/Settings Icon/Settings Button'), 0)

'Back chevron "<" Icon, to the left of the Profile text top left '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/My Tiles/Profile chevron'), 0)

Mobile.verifyElementExist(findTestObject('Companion App/Android/User Profile/Gift Icon/Gift - Element'), 1)

'Gift Icon, TO Inside  the circle '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/Gift Icon/Gift Button'), 0)

'X icon on top right of Gift- Giving page '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/Gift Icon/X icon'), 0)

Mobile.verifyElementExist(findTestObject('Companion App/Android/User Profile/QR Code - Check-In/QR Code - Element'), 1)

Mobile.tap(findTestObject('Companion App/Android/User Profile/QR Code - Check-In/Check-In - Button'), 0)

'X button in QR code modal'
Mobile.tap(findTestObject('Companion App/Android/User Profile/QR Code - Check-In/X button in QR code modal'), 0)

Mobile.verifyElementExist(findTestObject('Companion App/Android/User Profile/My Tiles/Elements/Notes - Element'), 1)

'My Notes Tile '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/My Tiles/Buttons/My Notes Tile'), 0)

'Back chevron "<" Icon, to the left of the Profile text top left '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/My Tiles/Profile chevron'), 0)

'My Prayers - Element '
Mobile.verifyElementExist(findTestObject('Companion App/Android/User Profile/My Tiles/Elements/My Prayers - Element'), 1)

'My Prayer Tile '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/My Tiles/Buttons/My Prayers Tile'), 0)

Mobile.scrollToText('Please ')

Mobile.tap(findTestObject('Companion App/Android/User Profile/My Tiles/Buttons/Profile back button'), 0)

Mobile.verifyElementExist(findTestObject('Companion App/Android/User Profile/My Tiles/Elements/My Ministries - Element'), 
    1)

Mobile.tap(findTestObject('Companion App/Android/User Profile/My Tiles/Buttons/My Ministries Tile'), 0)

Mobile.tap(findTestObject('Companion App/Android/User Profile/My Tiles/My Ministries/Back button'), 0)

Mobile.verifyElementExist(findTestObject('Companion App/Android/User Profile/My Tiles/Elements/Events - Element'), 1)

Mobile.tap(findTestObject('Companion App/Android/User Profile/My Tiles/Buttons/My Events Tile'), 0)

Mobile.closeApplication()

