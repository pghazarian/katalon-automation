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
 * Prerequisites: Push Notifications Templates (3 PBIs) must be implemented in HC admin before I can run this TC 
 * 1. Open HC Admin 
 * 2. Login
 * 3. Go to Data Capture > Connection Form
 * 4. Search for an Active Connection Form
 * 5. Open the Active Connection Form 
 * 6. Go to the Follow Ups tab of the Connection Form
 * 7. Create a follow up Templete Rule
 * 8. Add a Task Rule
 * 9. Go to Notifications section of the Rule Builder part of the Task Rule
 * 10. Select "Immediate" type of push notification
 * 11. Enter and Select all other required fields and sections of the Task Rule
 * 12. Click on the Done button to save the Task Rule
 * 13. Click on the Save button to save the Rule 
 * 13. Open the Ministry App and Login
 * 14. Verify that the Immediate (Instant) push notification is received, in your mobile device's Notification Center
 * Post-Conditions: Ensure that all daily batch push notifications are not effected by immediate push notifications, when they become available
 */