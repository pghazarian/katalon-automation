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
 * 1. Open Ministry App 
 * 2. Login 
 * 3. Tap on Metrics icon
 * 4. Tap on Trending tab
 * 5. Tap on Service Check-Ins tile 
 * 6. Tap on 8 Week Trend button 
 * 7. Tap on any one of the weeks chart 
 * 8. Verify that the Average Service Check-Ins and CTA Sign Ups counts are diplayed, in the Popup of the selected week
 * 9. Close the popup 
 * 10. Tap on the Month button
 * 11. Tap on any one of the Months chart 
 * 12. Verify that the Average Service Check-Ins and CTA Sign Ups counts are diplayed, in the Popup of the selected month
 * 13. Close the popup 
 * 14. Tap on the Quarter button
 * 15. Tap on any one of the Quarters chart 
 * 16. Verify that the Average Service Check-Ins and CTA Sign Ups counts are diplayed, in the Popup of the selected Quarter
 * 17. Close the popup 
 * 18. Tap on the Year button
 * 19. Tap on any one of the Years chart 
 * 20. Verify that the Average Service Check-Ins and CTA Sign Ups counts are diplayed, in the Popup of the selected Year
 */