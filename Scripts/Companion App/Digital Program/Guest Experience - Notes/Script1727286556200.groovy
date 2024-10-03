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
 * Prerequisites: Create a new Digital Program with notes & a Service in HC Admin & publish it 
 *
 * TC:
 * 1- Open CA app & stay logged out 
 * 2- Tap open the published Digital Program
 * 3- Tap on the Notes CTA button & verify the following: 
 * 4- A Guest user can use all the same functionality as logged in user such as: 
 * 5- Taking Notes
 * 6- Filling in the Blanks for the notes outline (autofill)
 * 7- Using all formating options such as: bolding, italicizing, underlining, & highlighting the text 
 * 8- Verify that a Guest user has the ability to try the feature before saving their notes
 * 9- Verify that the Guest user's notes in the same logged out session are retained until the user logs in to save their notes 
 * 11- Verify that after logging in, the user's notes will be retained from their Guest experience 
 * 12- Verify that user will land on the Messages & Notes Page they were interacting with after logging in (where they started)
 * 13- Repeat the TC from CA home page > Messages section for a past & current Service 
 * 14- Repeat the TC from the Resources > Latest Messages section for a past & current Service 
*/