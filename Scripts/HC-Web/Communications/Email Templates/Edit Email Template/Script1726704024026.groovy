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
 * Prerequisite:
 * User must have a "Communication" created, with an email templete attached to it, on HC admin for environment testing on
 * 
 * 1. From your PC's browser go to HC admin for environment testing on
 * 2. Login with your admin user credentials 
 * 3. From the left navigation pane, click on the Communications > Communications sub menu
 * 4. Find the "Communication" created in Prerequisite (above) & Open to view the Details
 * 5. From under the "Communication Layout" section, click on the Edit button below the Email Template name 
 * 6. Verify the user can perform the following functions:
 * 7. User can click the edit button
 * 8. Unlayer screen opens with the content from the record
 * 9. User can make changes
 * 10. User clicks save, and changes save and overlay closes 
 * 11. After clsoing, user is not in an edit state in the email communication record
*/

 
