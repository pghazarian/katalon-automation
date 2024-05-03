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
 * Prerequisite: Test Data for all following 3 types of reports: Attendence, Baptism, Decisons - has to be available for all campuses and the "Online Community" campus, from HC admin environment testing on, in order for tester to get the correct results in the Trend Reports 
 * 1. Open Ministry App
 * 2. Login
 * 3. Tap on Metrics icon
 * 4. Tap on Trending tab  
 * 5. Tap on Attendence tile
 * 6. Tap on 8 Week Trend button
 * 7. Check the "Include online community in combined totals" checkbox   
 * 8. Verify that the actual "Online Community" campus' data count will be included in the chart and all the weeks pop ups and the table view for the "8 Week Trend's", inclduing the latest week
 * 9. Close the popup
 * 10. Parameterization: Tap on each one of the "Month, Quarter, & Year's" charts and table views for the Attendence
 * 11. Verify that the Average "Online Community" campus' data count will be included in the chart and the table views for each one  of the periods (Month, Quarter, & Year)  
 * 12. Parameterization: Repeate the same steps above by selecting the "Baptisms" & "Decisons" tiles in step 5
 * 13. User should be able to see the "Online community combined totals" for "Baptisms" & "Decisons" counts, for the Monthly, Quarterly & Yearly periods, in the chart's pop-ups & the table views
 * 14. Repeate the same steps above for the same reports from the "Weekly Flash" screen 
 * 15. User should be able to see the "Online community combined totals" data counts included, for the "Attendance", "Baptisms" & "Decisons" reports. 
 */