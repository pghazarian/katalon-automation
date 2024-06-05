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
 * 4. User should navigate to the main landing page of their Profile
 * 5. My Notes tile, with its icon in it, should be displayed in the tiles section below
 * 6. Tap on the "My Notes" tile and verify the following are displayed:
 * 7. < Profile chevron button, will take user back to their Profile 
 * 8.  My Notes title text
 * 9. [X] Number of user's Notes count
 * 10. List of Sermons on which user has taken any notes, should be displayed with the following Data:
 * 11. Sermon cover photo
 * 12. Sermon category
 * 13. Sermon title
 * 14. Sermon speaker
 * 15. Sermon date
 * 16. Verify when user taps on one of the sermons listed, they should navigate to the Notes screen for that sermon
 * 17. If the user does NOT have any Notes on any Sermons, verify the following are displayed:
 * 18. Note icon
 * 19. Text: "Your updated notes from the services you attended will be made available here."
 * 20. The "Browse Recent Messages" blue button is visable in the middle of the My Notes page 
 * 21. If the user taps on the "Browse Recent Messages" blue button, they will navigate to the Recent Messages area with all recent available sermons displayed 
 * 22. Global navigation at the bottom of the screen should work, and take the user to the correct destinations
 */