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
* 1- User must have a valid account on ME app to use on the Companion App to login
* 2- Verify lift-&-shift effort has been completed (PBI 110607) from ME App to CA to support following functionality in My Prayers area:
*   Display prayer requests submitted by the user, which were not made anonymously
*   Pull the following data to display for each prayer request listed:
* 	Prayer icon
* 	Prayer Request text (truncated with ... after 3 lines) 
*   Date Submitted
*   Time Submitted 
*  	Verify when user taps on a prayer request, they should navigate to the correct location (Prayer Request details screen)
*
*
* 1. Download and Open the Companion App (CA) from the home screen of the device
* 2. Login
* 3. Tap on user profile web avatar icon in the bottom of the main landing page of CA
* 4. User should navigate to the main Landing page of their Profile
* 5. Tap on the the "My Prayers" tile
* 6. User should navigate to the main "My Prayer Requests" page, with the following elements displayed
* 7. < Profile back button, which will navigate the user back to the profile home screen
* 8. Page title: My Prayer Requests
* 9. + icon, which will open a "New Prayer Request" form, when tapped on 
* 10. Count: x Requests (how many prayer requests listed below, or "1 Request" if only 1 is showing)
* 11. Prayer request(s) - requests made by the user NOT anonymous requests (most recent attop), with the following elements:
* 12. Prayer icon
* 13. Prayer Request text (truncated with ... after 3 lines)
* 14. Date Submitted
* 15. Time Submitted
* 16. Verify If there are no prayer requests to display, the screen should show the following:
* 17. Prayer icon
* 18. Text: "You haven't submitted any prayer requests yet. Your words hold great meaning for us, and we're here to support you."
* 19. The "New Prayer Request" button, which will navigate the user to "New Prayer Request" form page, when tapped on
* 20. Tap on any prayer request, from the main "My Prayer Requests" page
* 21. User should navigate to the "Prayer Details" drawer of the selected Prayer Request
* 22. Verify that the following components are displayed in the "Prayer Details" drawer
* 23. Prayer icon
* 24. Prayer Details title
* 25. X button - Closes the drawer and returns the user to the My Prayer Requests screen, when tapped on 
* 26. Prayer Request's text
* 27. Date & Time Submitted
*/