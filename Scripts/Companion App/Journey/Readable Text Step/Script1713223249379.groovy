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
Prerequisite:  *Create a Journey in the HC Back Office that contains a required Readable Text step with multiple pages*.  
Make sure every type of formatting and content is implemented in the test step.


1. Log into CA App
2. Navigate to Journey Browse page
3. Select a Journey that contains a Readable Text Step matching prerequisite
4. Select Start Journey at the bottom of the screen
5. Select Got It at the bottom of the modal to clear it.  Select the first section from the Journey pathway.
6. Complete the required steps to reach the Readable Text step in the section.
7. Tap on the Readable Text step in the pathway view
8. Verify that all the formatting of the text on the page is proper
9. Move the second page of text via buttons and swiping.
10. Verify that all the formatting of the text on the page is proper
11. Exit out of the readable text step
12. return back to the readable text step
13. Exit out of the Journey
14. Return back the same journey and tap on the readable text step
15. Complete the required steps to reach the Readable Text step in the section.
16. Click Finished button
17. Exit the application

*/