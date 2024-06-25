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
 * - Verify a lift-and-shift effort has been completed (PBI 110598) from the ME App to the Companion App to support the following functionality:
 *   Display link that generates users QR code in a full-sized drawer open from the bottom
 *   Display upcoming events for the user that can be checked into
 * 	 Display events where the user's child(ren) are currently checked in
 * 	 Display the user's QR Code when that item is tapped
 * 
 *  
 * 1. Download and Open the Companion App (CA) from the home screen of the device
 * 2. Login
 * 3. Tap on user profile web avatar icon in the bottom of the main landing page of CA
 * 4. User should navigate to the main Landing Page of their Profile
 * 5. Verify that the "Check-In" button is displayed below the user's profile web avatar, in the main Landing Page of the user's profile 
 * 6. Verify when user taps on the "Check-In" button on the Profile home screen, one of two results should occur: 
 * 7. 1a-If the user has events to check into within the next [TBD] days, the user will be taken to the Event Check In screen
 * 8. 1b-If the user has one or more children currently checked into an event, the user will be taken to the Event Check In screen, so they can check out their child
 * 9. 2- If neither of these are true, tapping this button will generate the full-length drawer with the user's QR code showing, so they can use it to Check In Events & SOs 
 * 10. Additional Verification in the Check In Screen:
 * 11. If the user taps on the "Check-In" button & has upcoming events or children currently checked into an event, the following elements should be displayed:
 * 12. < Back button (user will go back to their profile home screen, when tapped on)
 * 13. Title: Check-In
 * 14. Gift Icon: Tapping on it will link out the user to the Giving page (placeholder for now)
 * 15. Following Text should be displayed below the Check In Title: "Check in and out of weekend services, events, childcare, serving opps and more with ease."
 * 16. Following Check-In Objects should also be displayed:
 * 17. Quick Check In with:
 * 18. Check in icon (always shown)
 * 19. Text "Quick Check in"
 * 20. Generates drawer with user's QR code when tapped on
 * 21. Event Check In (if applicable)
 * 22. Event icon
 * 23. "Event Check In" category text, When tapped on the event check-in process initiates
 * 24. Event title
 * 25. "Checked-In" Status with green check mark circle icon (if checked in)
 * 26. Child Check Out (if applicable)
 * 27. "Child Check Out" category text, When tapped on the child check-out process initiates
 * 28. Child name
 */

 
