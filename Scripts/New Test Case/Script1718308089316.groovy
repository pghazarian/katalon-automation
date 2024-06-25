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
 * Create a function named login which receives 2 parameters: username and password
 * Enter username in Email Address Textfield on Login
 * Enter password in input_Password_Password textbox
 * Click Sign In Button
 */
/*
* Login to the application with the provided username and password.
*
* @param username The username to login with.
* @param password The password to login with.
/*
*  Login to the application with the provided username and password.
*
*  1. Use the provided username and password to log in.
*  2. The username parameter represents the username to login with.
*  3. The password parameter represents the password to login with.
*
*/
// Enter username in Email Address Textfield on Login
WebUI.setText(findTestObject('Page_Login/input_Email Address'), username)

// Enter password in input_Password_Password textbox
WebUI.setText(findTestObject('Page_Login/input_Password'), password)

// Click Sign In Button
WebUI.click(findTestObject('Page_Login/button_Sign In'))



/*
* Open browser, go to https://hc-stage.saddleback.com/
* Call a predefined function'login' with username="shcqa1@gmail.com", password="P@$$w0rd!"
* Click on Sign In Button 
* Verify if the current page URL is "https://hc-stage.saddleback.com"
* Click p_People button on Page_Healthy Church
*/
// Open browser and navigate to the specified URL
WebUI.openBrowser('https://hc-stage.saddleback.com/')

// Call the predefined function 'login' with username and password
CustomKeywords.'yourPackageName.yourClassName.login'('shcqa1@gmail.com', 'P@$$w0rd!')

// Click on Sign In Button
WebUI.click(findTestObject('Login/Sign In Button'))

// Verify if the current page URL is "https://hc-stage.saddleback.com"
WebUI.verifyMatch(WebUI.getUrl(), 'https://hc-stage.saddleback.com', true)
/*
 *  Verify if the current page URL matches a specific URL.
 *
 *  1. Get the current page URL.
 *  2. Check if the current page URL matches the specified URL.
 *  3. Return true if the URLs match, false otherwise.
 *
 */

// Click on p_People button on Page_Healthy Church
WebUI.click(findTestObject('Person/Search/Page_Healthy Church/Person Search Bar'))
