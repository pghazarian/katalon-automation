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
Prerequiste:  Make sure a Journey is setup with multiple sections and at least one video step type
1. Launch the Companion App
2. Log into the Companion App
3. Tap on the Browse Journey tab
4. Select a Journey that has not been started and fulfills the above prerequisites
5. Start the Journey
6. Select the Video step
7. Verify that video start playing automatically
8. Tap on the pause button.
9. Tap on the play button.
10. Scrub the video backward 
11. Scrub the video forward
12. Use the 15 second forward button.
13. Use the 15 second backward button.
14. Minimize the CA app
15. Verify that video stops playing
16. Bring the CA app back to the foreground 
17. Restart the Video playback.
18. Let video playback fully to the end.
19. Verify that the up next mode come up automatically
*/