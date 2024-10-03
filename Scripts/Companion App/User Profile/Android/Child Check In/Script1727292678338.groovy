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
 * Business Case:
 * As a parent/guardian user wants to check one or more children (child records) into a kid's room at a Weekend Service  (kid's rooms)
 * User will either Scan their QR code or have a Volunteer who opened a kid's room check a child into a room
 * This will generate a physical Bar Code that I can check a child out of the room after the Weekend Service is over
 * This will ALSO generate a QR code on the Companion App for each child that I check into a room for the Weekend Service
 * 
 * Prerequisites:
 * - A parent/guardian has a relationship to the child record
 * - A parent/guardian does not have any child records checked into a Weekend Service
 * - A Child Record QR Code will not exist
 * 
 * Test Case:
 * 1. Download and Open the Companion App (CA) from the home screen of the device
 * 2. Login
 * 3. Tap on user profile web avatar icon in the bottom of the main landing page of CA
 * 4. User should navigate to the main Landing Page of their Profile
 * 5. Verify that the "Check-In" button is displayed below the user's profile web avatar photo, in the main Landing Page of the user's profile
 * 6. Tap on the "Check-In" button
 * 7. User (Parent/Guardian) should navigate to their personal QR code to check a Child into a Weekend Service
 * 8. Once a parent has checked a child into a room, a QR code will be generated for each child record
 * 9. The Check In Page will display Quick Check In QR Code
 * 10. A unique Row for each Child that has been Checked in
 * 11. Each Row will display the following: 
 * 12. Text: "Child Check Out"
 * 13. Image & Icon (default if no image is added to the event)
 * 14. Room Name
 * 15. Child's First & Name
 * 16. Child First & Name
 * 17. Green checkmark icon/text "Checked In" 
 * 
 * 
 * Additonal verification in the Header: 
 * - IF there is ONLY the Quick Check In QR Code on the Check In Page, do not display a QR Code in the Global Header
 * - Display QR code Icon in the Global Header IF there is a Parent has one or more Child Records currently checked in
 * - IF there is more than one child checked into a Weekend Service, display number of Child Check In Codes on the QR Code Icon in the Global Header (Refer to Comps)
 * - Future Consideration: We plan to have different check in QR codes in the future for entities like: other events, serving opps.. 
 * - So, the number on the QR code in the global header will count these other qr codes types. 
 *
 *
 * Here are the steps to verify the "Checking Out a Child" from a Weekend Service: 
 * - Tap on the Unique Row for a Child on the Check In Page
 * - This will trigger a bottom sheet with the following info on the page:
 * - Icon
 * - Text: Child Check Out
 * - QR Code
 * - Category
 * - Event Title
 * - Event Details (clickable, takes user to Event Details Page)
 * - Check-In Details:
 * - Child Nick Name (First Name if no Nick Name)
 * - Child Last Name
 * - Date of Event | Start Time of Event - End Time of Event
 * - Room Name, Venue, Address
 * - Campus
*/
