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
Prerequisite:  *Create a Journey in the HC Back Office that contains a required Quiz step.  
Make sure every type of question types are implemented in the test step. 
There should be at least three quiz questions in the step.


1. Log into CA App
2. Navigate to Journey Browse page
3. Select a Journey that contains a Quiz Step matching prerequisite
4. Select Start Journey at the bottom of the screen
5. Select the first section from the Journey pathway.
6. Complete the required steps to reach the Quiz step in the section.
7. Tap on the Quiz step in the pathway view
8. Verify that first quiz question is displayed
9. Answer the quiz step correctly
10. Verify that a correct status is returned after question response
11. Exit the quiz step and return back to the pathway view.
12. Tap on the Quiz step again in the pathway view
13. Verify that first quiz question is displayed and NOT the second.
14. Answer the quiz step correctly
15. Verify that a correct status is returned after question response
16. Answer the second quiz question incorrectly.
17. Verify that a incorrect status is returned after question response.
18. Answer all remaining quiz questions
19. Verify that all answer statuses are returned after question response.
20. Verify that the Quiz review page is displayed with all proper information (statistics)
21. When returned back to the pathway page tap on the same Quiz step
22. Verify that user can retake the quiz again with proper information for the quiz retaken.
23. Exit out of the journey pathway view page.
24. Exit out of the Journey
25. Exit the application

*/