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
Prerequiste:  Make sure a linear Journey is setup with multiple sections and at least one of each type of step.  
Make some steps required and some not.
1. Launch the Companion App
2. Log into the Companion App
3. Tap on the Browse Journey tab
4. Select a Journey that has not been started and fulfills the above prerequisites
5. Start the Journey
6. Verify that the status in the journey details displays In-progress tag
7. Tap on the back arrow to return back to the Browse Journeys page
8. Tap on the Today tab
9. Verify that Next Steps page is displayed and the newly started journey first step is listed
10. Tap on the journey next steps
11. Now perform the CTA for each step in each section
12. Verify that when you attempt to skip a required step, the user is returned back to the pathway view on same step
13. Verify that when you attempt to skip a non-required step, the user can skip via the Got it button
14. Verify for Video steps that you can scrub forward and backward and pause it.
15. Verify for Audio steps that you can scrub forward and backward and pause it.  When completed no up next mode does 
		not automatically displays until user manually closes.
16. Verify Quiz steps display results stats page at end.
17. Verify that when a step is completed that the up next mode moving automatically to the next step.
18. Verify that when you complete a section that a confirmation page is displayed.
19. Verify that the footsteps advanced to the next step or section.
20. Repeat steps 11 - 19 till all steps and sections are completed
21. Verify that a journey completion confirmation page is displayed.
22. Verify that when user is returned back to the journey details page reflects completed status tag
23. Tap on the back arrow to return back to the Browse Journeys page
24. Verify that when user is returned back to the journey list page the journey reflects completed status tag 
 */
