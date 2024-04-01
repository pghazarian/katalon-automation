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
 * 1. Open HC Admin
 * 2. Login
 * 3. Go to Data Capture > Connection Form
 * 4. Search for an Active Connection Form
 * 5. Open the Active Connection Form
 * 6. Go to the Follow Ups tab of the Connection Form
 * 7. Create a follow up Templete Rule
 * 8. Add a Task Rule
 * 9. Go to Notifications section of the Rule Builder part of the Task Rule
 * 10. Select one of each types of following push notifications using the Radio button next to them: None, Daily Batch, Immediate (Must run the TC 3 times, one for each type)
 * 11  Select the appropriate Notification Templete to be sent for the Notification type selected, from the "Select Notification" drop down menu 	
 * 12. Enter and Select all other required fields and sections of the Task Rule
 * 13. Click on the Done button to save the Task Rule
 * 14. Click on the Save button to save the Rule
 * 15. Open the Ministry App and Login
 * 16. Verify that if "None" type is selected NO push notification is received, in your mobile device's Notification Center
 * 17. Verify that if "Immediate" type is selected a push notification is received instantly, in your mobile device's Notification Center
 * 18. Verify that if "Daily Batch" type is selected a push notification is received, in your mobile device's Notification Center	
 * 19. Verify that the "Daily Batch" and "Immediate" types of Notifications are displayed, based on the Notification Templete selected in HC Admin, from the "Select Notification" drop down menu 	
 */