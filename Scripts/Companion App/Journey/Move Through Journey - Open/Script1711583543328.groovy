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
Prerequiste:  Make sure an Open Nav Journey is setup with multiple sections and at least one of each type of step.  

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
11. Now move to the first step of the last section
12. Now perform the CTA for each step in the last section
13. Verify for Video steps that you can scrub forward and backward and pause it.
14. Verify for Audio steps that you can scrub forward and backward and pause it.  When completed no up next mode does 
		not automatically displays until user manually closes.
15. Verify Quiz steps display results stats page at end.
16. Verify that when a step is completed that the up next mode moving automatically to the next step.
17. Verify that when you complete a section that a confirmation page is displayed.
18. Verify that the footsteps advanced to the next step or section.
19. Repeat steps 12 - 19 till steps in the last sections are completed
20. Verify that upon completion of the last step in the last section, a journey finish/cancel modal is displayed.
21. Tap on the Finished button on the modal.
22. Verify that the Journey Finished cofirmation page will be displayed.
23. Verify that when user is returned back to the journey details page reflects Finished status tag
24. Tap on the back arrow to return back to the Browse Journeys page
25. Verify that when user is returned back to the journey list page the journey reflects Finished status tag 
26. Return back to the journey and complete all remaining steps in all uncompleted sections
27. Verify that upon completion of the last step in the last uncompleted section, a journey completion page is displayed.
*/
