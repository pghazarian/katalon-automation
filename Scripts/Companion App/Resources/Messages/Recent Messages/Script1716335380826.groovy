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
1. Launch the Companion App
2. Log into the app
3. Tap on the Resource Navigation button at bottom
4. Tap on the Messages tab on Resources page
5. Swipe left to right on the Series carosel 
6. Tap on the See All link under Series section
7. Tap on the back arrow button in upper right portion of series list page
8. Swip bottom upward in the Latest Messages section
9. Tap on the Seel All link under the Latest Messages section
10. Tap on the back arrow button in the upper right portion of the Messages & Notes page.
11. Enter a unique message name on Messages landing page
12. Enter a unique series name on Messages landing page
13. Enter a unique message name on Messages & Notes page
14. Enter a unique series name on Series list page





*/