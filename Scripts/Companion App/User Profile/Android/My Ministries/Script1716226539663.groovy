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
 * 5. My Ministries tile, with its icon in it, should be displayed in the tiles section below
 * 6. Tap on the "My Ministries" tile and verify the following are displayed:
 * 7. < Profile chevron button
 * 8.  My Ministries title text   
 * 9. [X] Ministries count 
 * 10. List of tiles of all Ministries that the user belongs to (siged up as a memeber) with the following on each:
 * 11. Ministry icon & image if applicable 
 * 12. Ministry category
 * 13. Ministry title
 * 14. Ministry campus
 * 15. Test Note: If there are "No" Ministries to be displayed, the screen should show the following:
 * 16. Leaf icon
 * 17. Text: "You aren't currently a member of any ministries. Explore opportunities to get involved today."
 * 18. Browse Ministries (blue) button 
 * 19. Verify the following:
 * 20. Tapping on the "< Profile" link should navigate the user back to the profile home screen
 * 21. Tapping on one of the Ministries listed should navigate the user to the details screen for that selected ministry (TBD)
 * 22. Tapping on the "Browse Ministries" button (for empty list) should navigate the user to the Ministries home screen (TBD)
 * 23. Global navigation at the bottom of the screen should work, and take the user to the correct destinations
 */