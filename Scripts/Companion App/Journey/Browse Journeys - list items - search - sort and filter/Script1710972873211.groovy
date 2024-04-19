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
 1. Launch Companion App
 2. Log into Companion App with a user who has journeys not started, in progress and completed statuses 
 		and authored some unpublished journeys under HC Back Office.
 3. Tap on Journey Navigation button
 4. Tap on the Browse Journeys tab 
 5. Verify a list of all published journeys is listed and item content is correct
 6. Tap on Journey that has not been started
 7. Verify that the Journey Details are as defined and Start Journey button is displayed
 8. Tap on Back button to get back to the Journey List
 9. Tap on a Journey that is in progress
 10. Verify that the Journey Details are as defined with In Progress status text and View Pathway and Stop Journey Buttons are displayed.
 11. Tap on Back button to get back to the Journey List
 12. Tap on a Journey that has been completed
 13. Verify that the Journey Details are as defined with Completed status text and only View Pathway Button is displayed
 14. Tap on Back button to get back to the Journey List
 15. Verify that there are unpublished journeys that the logged in user has authored
 16. Tap on one of the unpublished journeys.
 17. Verify that the Journey Details are as defined proper content.
 14. close the app
 */