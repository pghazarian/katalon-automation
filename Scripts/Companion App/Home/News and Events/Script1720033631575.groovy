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
 * 1- On HC Admin: User must create few Event Categories with Thumbnail Images
 * 2- On HC Admin: User must set the Priorities of the Event Categories created in step 1 above
 *
 * Test Case Steps:
 * 1. On your mobile device, download and open the latest version of Companion App
 * 2. Login
 * 3. User should navigate to the Home page of the Companion App
 * 4. Scroll down to the "News & Events" section & verify the following:
 * 5. Verify that Events thumbnail images are displayed correctly with the Category Name & number of Events in each Event Category
 * 6. Verify that if no image is added to an Event Category in HC admin, pre-defined (default) thumbnail image id displayed
 * 7. Verify that the Events thumbnail images are NOT displayed on the Events Landing page in the Discover section
 * 8. Verify that the Events thumbnail images are ONLY displayed on the Home page, under the "News & Events" section
 * 9. Verify that the Events Categories Priorities are set correctly, under the "News & Events" section of the Home page
 * 10. Verify that the Events Categories Priorities are set correctly, on the Events Landing page in the Discover section
 * 11. Verify that if No priorities are set (in HC admin) for the Events Categories, the default priority is set to (A -> Z)
 * 12. Tap on the "See All" blue link button, to the right of the "News & Events" section's header of the Home page
 * 13. Verify that user can view ALL Events under each Category
 * 14. Re-Execute the TC steps above with a logged out user
 */
WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [('UserName') : '', ('Password') : ''], FailureHandling.STOP_ON_FAILURE)

Mobile.scrollToText('Worship', FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Companion App/Android/Buttons/Home/News and Events/Worship Service Category'), 
    0)

Mobile.tap(findTestObject('Object Repository/Companion App/Android/Buttons/Home/News and Events/Home Icon'), 0)

Mobile.tap(findTestObject('Object Repository/Companion App/Android/Buttons/Home/News and Events/Adult Ministries Category'), 
    0)

Mobile.tap(findTestObject('Object Repository/Companion App/Android/Buttons/Home/News and Events/Home Icon'), 0)

