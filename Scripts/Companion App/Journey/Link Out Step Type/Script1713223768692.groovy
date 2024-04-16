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
Prerequisite: Create a Journey on HC back office that includes multiple sections and has a Register for 
	Ministry where the catalog filters down to a single Ministry.


1. Log into CA App
2. Navigate to Journey Browse page
3. Select a Journey that contains a Link out Step matching prerequisite
4. Select Start Journey at the bottom of the screen
5. Select Got It at the bottom of the modal to clear it.  Select the first section from the Journey pathway.
6. Complete the required steps to reach the Link out step in the section.
7. Tap on the Readable Text step in the pathway view
8. Tap on the Link out button
9. Verify that a new web browser button is generated and linked to the proper location defined in the step
10. Close the Web Browser 
11. Exit the application

*/