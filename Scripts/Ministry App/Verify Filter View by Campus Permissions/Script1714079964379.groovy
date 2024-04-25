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
 * Preprquisite: When user has Permissions on HC Admin side  for Specific Campuses locations, they should only see Data for those Campuses in the Trend Reports on MA 
 * 1. Open Ministry App
 * 2. Login
 * 3. Tap on Metrics icon
 * 4. Tap on Trending tab
 * 5. Tap on Attendence tile
 * 6. Tap on Filter icon
 * 7. Verify Filters drawer pops open from the bottom of the screen
 * 8. Verify Campus field exists with a ">" Chevron icon to the far right of it
 * 9. Select the Campus or Campuses which the user has permissions to view on HC Admin
 * 10. Tap on the Search button 
 * 11. Verify that user can only view Attendence data for Campuses that they have Permission on in HC Admin 
 */