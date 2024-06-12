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
 * - Verify a lift-and-shift effort has been completed (PBI 110598) from the ME App to the Companion App 
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