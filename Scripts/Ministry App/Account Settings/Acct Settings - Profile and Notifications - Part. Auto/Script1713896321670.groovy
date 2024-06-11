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
 * 1. Open Ministry App
 * 2. Login
 * 3. Tap on the Logged in user's profile avatar photo icon from the top right corner of the screen
 * 4. User's Account Settings profile drawer should pop open from right to the left side of the screen
 * 5. Verify that user's web avatar photo, first & last names are displayed at top of the drawer
 * 6. Verify that the text "Manage Saddleback Account" is displayed below the user's web avatar photo in blue color
 * 7. Verify that the "Profile" button is displayed in blue color with the profile icon in it
 * 8. Tap on the Profile button
 * 9. A "Coming Soon" modal should be displayed, with an "OK" button
 * 10. Tap on the "OK" button
 * 11. Coming Soon message modal should disappear & user's account settings profile drawer should be enabled
 * 12. Verify that the "Notifications" button is displayed in green color with the Bell icon in it
 * 13. Tap on the "Notifications" button
 * 14. User should navigate to the "Notifications" settings screen
 * 15. Verify that the screen title is displayed as "Notifications" with a back button icon at the top left of the screen
 * 16. Verify that the "All Notifications" toggle is displayed with "Toggle all notifications On or Off" instructions text under it
 * 17. Verify that the "All Notifications" toggle will turn on or off all push notifications, from the Ministry App
 * 18. Verify that the "Daily Batch" toggle is displayed with all of its categories checkboxes under it
 * 19. Verify that the "Daily Batch" toggle will turn on or off all push notifications for the selected category under it, from the Ministry App
 * 20. Verify that the "Immediate" toggle is displayed with all of its categories checkboxes under it
 * 21. Verify that the "Immediate" toggle will turn on or off all push notifications for the selected category under it, from the Ministry App
 * 22. Verify checkboxes under the "Daily Batch" & "Immediate" toggles are displayed, based on what's associated with the Follow Ups Task Rule in HC admin & assigned to the logged in user in the Ministry App
 * 23. Verify when new push notification is added in HC Admin/Follow Ups Task Rule, the checkbox should be selected by default in the Ministry App
 * 24. Verify when exsting push notification is changed or modified in HC Admin/Follow Ups Task Rule, the corresponding checkbox should also be updated in the Notifications screen of the Ministry App
 * 25. Verify if user has been assigned an "Urgent Prayer Request" follow up task, & that task has an "Immediate" push notification associated with it, then "Urgent Prayer Request" should appear as a checkbox under the "Immediate" toggle of the Notifications screen
 * 26. Verify if the logged in user has never been assigned a follow up task for "Request for Information", that push notification should NOT appear on the Notifications screen of the Ministry App
 * 27. Verify if user taps on the back button icon at the top left of the "Notifications" screen, they are navigated back to the their Account Settings profile drawer
 * 28. Verify that the Log Out & Account Removal buttons are displayed at the bottom of the drawer
 * 29. Verify that the Ministry application's version info is displayed at the very bottom of the drawer
 * 30. Tap on the X icon at the top right of the Account Settings profile drawer
 * 31. Verify that User's Account Settings profile drawer will close & user will navigate back to the Ministry App's home screen
 */

WebUI.callTestCase(findTestCase('Ministry App/Shared TCs/Login'), [('UserName') : 'Pareng@Saddleback.com', ('Password') : 'bGzvpoZCcaztWWDnaA3/tA=='], 
    FailureHandling.STOP_ON_FAILURE)

'To enter into user\'s profile drawer (top right) '
Mobile.tap(findTestObject('Object Repository/Ministry App/Navigation/User Profile Avatar'), 0)

'To open user\'s profile drawer '
Mobile.tap(findTestObject('Object Repository/Ministry App/Navigation/X Button'), 0)

