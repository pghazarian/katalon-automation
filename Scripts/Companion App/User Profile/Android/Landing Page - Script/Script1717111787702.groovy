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