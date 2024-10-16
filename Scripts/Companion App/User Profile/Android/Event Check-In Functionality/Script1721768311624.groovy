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
 * Prerequisites:
 * - User must have a valid account on ME app to use on the Companion App to login
 * - Make sure that the user is Registered on few events on the HC Admin environment testing on
 *
 * 1. Download and Open the Companion App (CA) from the home screen of the device
 * 2. Login
 * 3. Tap on user profile web avatar icon in the bottom of the main landing page of CA
 * 4. User should navigate to the main Landing Page of their Profile
 * 5. Verify that the "Check-In" button is displayed below the user's profile web photo avatar, in the main Landing Page of the user's profile
 * 6. Tap on the "Check-In" button on the Profile home screen
 * 7. User should navigate to the "Check-In" screen, with all their registered Events displayed
 * 8. Verify If the user taps on an upcoming Event, from the main "Check-In" screen, the Event check-in process should be initiated
 * 9. The check-in process should have the following steps:
 * 10. User should navigate to the "Event Check-In" screen for the selected event, which should have the following elements:
 * 11. Event icon, in blue color
 * 12. Screen Title: Event Check-In
 * 13. X icon, which will close the screen when tapped (top right)
 * 14. Event Category or Categories
 * 16  Event Title, in black bold text with larger fonts
 * 17. Event Details link, with The "i" letter in small blue circle icon (link out TBD)
 * 18. Check-In Details, with the following information:
 * 19. User's name
 * 20. Event's Date & Time
 * 21. Event's Venue
 * 22. Event's Campus
 * 23. Cancel button (closes screen when tapped)
 * 24. Check In button, which will initiate the following process when tapped on:
 * 25. Initiates check-in and shows "Checking In" activity indicator snack bar
 * 26. Navigates the user back to the Check In screen
 * 27. Shows "Successfully Checked In" snack bar with a check mark, when check-in is completed successfully
 * 28. Check-in status for the event on the main "Check-In" screen will be updated to "Checked In" in green font, & a green check mark in a small green circle
 * 29. Tap on the same Event again (after being checked in), from the main "Check-In" screen
 * 31. The "Check in" button text, should be changed to "Checked In" & it will be disabled, in the "Check-In Details" screen
 * 30. Verify that once the Event is completed, it will no longer appear on the main "Check-In" screen
 */
/*
 * Prerequisites:
 * - User must have a valid account on ME app to use on the Companion App to login
 * - Verify a lift-and-shift effort has been completed (PBI 110614) from the ME App to the Companion App to support the following functionality:
 *   Identify child(ren) of user
 *   Collect & show details of the event(s) where the user's child(ren) may be currently checked in
 *   Collect child(ren)'s QR code
 *   Display all of the above information
 * - Make sure that there is a Child Checked in, for the Event testing on (on HC admin) before running the TC
 *
 *
 * 1. Download and Open the Companion App (CA) from the home screen of the device
 * 2. Login
 * 3. Tap on user profile web avatar icon in the bottom of the main landing page of CA
 * 4. User should navigate to the main Landing Page of their Profile
 * 5. Verify that the "Check-In" button is displayed below the user's profile web avatar photo, in the main Landing Page of the user's profile
 * 6. Tap on the "Check-In" button
 * 7. User should navigate to the "Check-In" screen, with all their registered Events displayed
 * 8. If user taps on an Event where their child is currently checked in, the Child Check-Out Screen should be displayed with the following elements:
 * 9. Child Check Out icon
 * 10. Screen Title: "Child Check Out"
 * 11. X button - Closes the screen when tapped
 * 12. Child's QR Code
 * 13. Event Category or Categories
 * 14. Event Title
 * 15. Event Details link with the I icon in a small circle in blue font color (link out TBD)
 * 16. Check-In Details with the following information:
 * 17. Child's name
 * 18. Event Date | Event Time
 * 19. Event Venue
 * 20. Event Campus
 * 21. Verify once the child is checked out, event should no longer appear on the main "Check-In" screen
 */
/*
*  This script navigates through the Companion App to check out a child from an event.
*
*  @param username The username for logging into the Companion App
*  @param password The password for logging into the Companion App
*/
// Download and Open the Companion App
// Login
WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [('UserName') : '', ('Password') : ''], FailureHandling.STOP_ON_FAILURE)

Mobile.verifyElementExist(findTestObject('Companion App/Android/Buttons/Home Page/Profile Web Avatar - Element'), 1)

Mobile.tap(findTestObject('Companion App/Android/Buttons/Home Page/Profile Web Avatar - Icon'), 0)

Mobile.tap(findTestObject('Companion App/Android/User Profile/Check-In/Check-In - Button'), 0)

'Quick Check-In'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/Check-In/Quick Check-In Button'), 0)

'X button in QR code modal'
Mobile.tap(findTestObject('Companion App/Android/User Profile/Check-In/X button in My QR Code modal'), 0)

'Child Check-Out '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/Check-In/Event Child Checkout Button'), 0)

'X button in QR code modal'
Mobile.tap(findTestObject('Companion App/Android/User Profile/Check-In/X button in My QR Code modal'), 0)

