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
 * 3. Tap on user Profile (avatar) icon in the bottom of the main landing page of CA
 * 4. User should navigate to the main landing page of their profile
 * 5. My Events tile, with its icon in it, should be displayed in the tiles section below
 * 6. Tap on the "My Events" tile and verify the following are displayed:
 * 7. < Profile chevron button
 * 8.  My Events title text   
 * 9. [X] Events count 
 * 10. List of tiles of all Events that the user belongs to (siged up as a memeber) with the following on each:
 * 11. Event icon & image if applicable 
 * 12. Event category
 * 13. Event title
 * 14. Event date
 * 15. Event time
 * 16. Event campus
 * 17. Event recurrence 
 * 18. Test Note: If there are "No" Events to be displayed, the screen should show the following:
 * 19. Calendar icon
 * 20. Text: "You aren't currently signed up for any events. Explore opportunities to get involved today."
 * 21. Browse Events (blue) button 
 * 22. Verify the following:
 * 23. Tapping on the "< Profile" link should navigate the user back to the profile home screen
 * 24. Tapping on one of the Events listed should navigate the user to the details screen for that selected Event (TBD)
 * 25. Tapping on the "Browse Events" button (for empty list) should navigate the user to the Events home screen (TBD)
 * 26. Global navigation at the bottom of the screen should work, and take the user to the correct destinations
 */