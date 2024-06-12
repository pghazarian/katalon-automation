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
 * 2- Verify lift-&-shift effort has been completed (PBI 110610) from ME App to CA to support following functionality in "New Prayer Request" area:
 *   Display prayer requests submitted by the user, which were not made anonymously
 *   Display user's first name, last name and email address
 *	 Capture and store text from Request field
 *
 *
 * 1. Download and Open the Companion App (CA) from the home screen of the device
 * 2. Login
 * 3. Tap on user profile web avatar icon in the bottom of the main landing page of CA
 * 4. User should navigate to the main Landing page of their Profile
 * 5. Tap on the the "My Prayers" tile
 * 6. User should navigate to the main "My Prayer Requests" page
 * 7. Tap on the + icon on the top right corner of the screen 
 * 8. User should navigate to the main "New Prayer Requests" drawer's "From Me" tab (by deafult), with following elements displayed:
 * 9. Prayer icon
 * 10. The "New Prayer Request" title text
 * 11. X button - Closes the drawer & returns the user to the "Prayer Requests" p, when tapped on 
 * 12. The "Anonymous" tab 
 * 13. The "Request" title
 * 14. Input "Text Field" box
 * 15. Accordion with logged in user's First/Last Name, & Email address fields displayed (not editable fields & open by default)
 * 16. Cancel button - Closes the New Prayer Request screen, when tapped on 
 * 17. Submit button (Disabled until user enters text in the Input Text Field), which submits the new "From Me" prayer request when tapped on
 * 18. Learn more about our "Privacy Policy"(blue) link, which links the user out to the following link, when tapped on:
 * 19. https://welcome.saddleback.com/sections/more/privacy-policy)
 * 20. From the "New Prayer Requests" drawer, tap on the "Anonymous" tab & verify the following elements are displayed:  
 * 21. The "Request" title
 * 22. Input "Text Field" box
 * 23. The "Your Privacy Matters" text title with:
 * 24. Privacy Text Body: Anonymous prayer requests will be sent to the prayer team without name, email or other personal information attached, even if you are logged in.
 * 25. Cancel button - Closes the "New Prayer Request" screen, when tapped on 
 * 26. Submit button (Disabled until user enters text in the "Input Text" Field), which submits the new "Anonymous" prayer request when tapped on
 * 27. Learn more about our "Privacy Policy"(blue) link, which links the user out to the following link, when tapped on:
 * 28. https://welcome.saddleback.com/sections/more/privacy-policy) 
 */