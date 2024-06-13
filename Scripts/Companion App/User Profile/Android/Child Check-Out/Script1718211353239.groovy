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
 * - Verify a lift-and-shift effort has been completed (PBI 110614) from the ME App to the Companion App to support the following functionality:
 *   Identify child(ren) of user
 *   Collect & show details of the event(s) where the user's child(ren) may be currently checked in
 *   Collect child(ren)'s QR code
 *   Display all of the above information
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
s */