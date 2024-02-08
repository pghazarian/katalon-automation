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

/* Write me a test case that:
* 1. Open a browser to a URL
* 2. Log in to the website
* 3. Click the login button
* 4. Input username and password
* 5. Clock the browser
*/
/*
 *  This test case opens a browser to a specified URL, logs in to the website, clicks the login button,
 *  inputs the username and password, and then closes the browser.
 *
 *  @param url The URL of the website to be opened
 *  @param username The username to be inputted
 *  @param password The password to be inputted
 */

// Open browser to URL
WebUI.openBrowser('https://www.example.com')

// Log in to the website
WebUI.click(findTestObject('Page_Login/button_Login'))

// Click the login button
WebUI.click(findTestObject('Page_Login/button_Login'))

// Input username and password
WebUI.setText(findTestObject('Page_Login/input_Username'), 'username')
WebUI.setText(findTestObject('Page_Login/input_Password'), 'password')

// Close the browser
WebUI.closeBrowser()
