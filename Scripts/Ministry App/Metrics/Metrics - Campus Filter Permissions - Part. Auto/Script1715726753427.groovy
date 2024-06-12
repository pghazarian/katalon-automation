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
 * Preprquisite: When user has Permissions on HC Admin side for Specific Campuses locations, they should only see Data for those Campuses in the Trend Reports on MA
 * 1. Open Ministry App
 * 2. Login
 * 3. Tap on Metrics icon
 * 4. Tap on Trending tab
 * 5. Tap on "Attendence" tile
 * 6. Select the "Attendance Trend Report" menu option
 * 7. Tap on Filter icon (top right)
 * 8. Verify Filters drawer pops open from the bottom of the screen
 * 9. Verify Campus field exists with a ">" Chevron icon to the far right
 * 10. Tap on the Chevron icon
 * 11. Verify that user can only view the Campuses that they have Permissions to view in HC Admin
 * 12. Select the Campus or Campuses you wish to see the "Attendance" data count
 * 13. Tap on the Back button (top left)
 * 14. Tap on the Search button
 * 15. Verify that user can only see "Attendance" data counts for the selected Campuses
 * 16. Parameterization: Repeat step 5 thru 15, for each one of the following trend reports (tiles): Baptisms, Decisons, Service Check-Ins, & CTAs
 * 17. Verify that user can only view the data counts for "Baptisms, Decisons, Service Check-Ins, & CTAs" for the campuses that they have permissons to view on HC admin
 * 18. Parameterization: Verify the data counts for all 5 trend reports from the "Weekly Flash" tab's drop down menu
 * 19. Verify that user can only view the data counts for the campuses they have permissons to view on HC admin, for all 5 trend reports
 */

WebUI.callTestCase(findTestCase('Ministry App/Shared TCs/Login'), [('UserName') : 'Pareng@Saddleback.com', ('Password') : 'bGzvpoZCcaztWWDnaA3/tA=='
        , ('ForceLogin') : false], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Ministry App/Navigation/Metrics icon'), 0)

'To open Trending page'
Mobile.tap(findTestObject('Object Repository/Ministry App/Metrics/Trending tab'), 0)

'To open Attendance menu options of Trending Reports '
Mobile.tap(findTestObject('Object Repository/Ministry App/Metrics/Attendance tile'), 0)

Mobile.tap(findTestObject('Object Repository/Ministry App/Metrics/Attendance Trend Report - menu option'), 0)

'To open the Filtering page for the Attendance trend reports  '
Mobile.tap(findTestObject('Object Repository/Ministry App/Metrics/Filter icon'), 0)

'To see all available Campus(es) - based on the logged in user\'s Permissions in HC admin '
Mobile.tap(findTestObject('Object Repository/Ministry App/Metrics/Campus - chevron icon'), 0)

'To select Anaheim campus '
Mobile.tap(findTestObject('Object Repository/Ministry App/Metrics/Anaheim Campus'), 0)

'To go back to the main Filters screen '
Mobile.tap(findTestObject('Object Repository/Ministry App/Metrics/Back button'), 0)

Mobile.tap(findTestObject('Ministry App/Metrics/Campus selections screen - Back button'), 0)

'To return Search results\r\n\t\t'
Mobile.tap(findTestObject('Object Repository/Ministry App/Metrics/Search button'), 0)

Mobile.tap(findTestObject('Object Repository/Ministry App/Metrics/8 Week Trend button'), 0)

