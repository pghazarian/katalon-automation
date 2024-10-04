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
1	Prerequisites: 
    - On HC Admin, publish a Service on a published Digital Program
	- Make sure the Digital Program has all types of CTAs we support, before publishing it 
	- Including Notes Outline with at least 4 auto fill questions
2	Install the latest CA 	
3	Tap on the CA icon from your mobile device’s home screen  
4	Make sure CA launches on only one click							
5	Select a Campus  
6 	Make sure the "Continue" button enables & turns Green
7	Tap on the "Continue" button	
8	User should navigate to the CA home page 
9	Verify that the following sections’ Ribbons, Details & Buttons are displayed with all CTAs involved in each section & its sub section is functional & working according with their requirements:
    - Campus Selection button 
    - My QR Code (Logged in)
	- Gift Icon 
	- Hi There! with the log in or create an account (logged out)
	- Engagement Pathway
	- For You 
	- Events
	- Messages 
	- Lower navigation menu with: Home, Resources, Profile, Journey, & Discover buttons (icons)
10	Tap on the Profile Avatar & Log In button 	
11 	Enter login email & password & tap on Sign in
12	My Stuff LP should load with the following  buttons & tiles:
	- Language selector 
	- Settings icon 
	- Gift Icon 
	- User’s profile avatar with their name
	- Check- In button (blue)
	- My Notes tile 
	- My Prayers tile
	- My Groups tile 	
	- My Ministries tile 
	- My Serving Activity tile
    - My Events tile
    - My Giving 
    Make sure each buttons and tiles are working according with their requirements
13	Navigate to the CA home page 		
14	Tap on the Open button, in the minimized Digital Program banner 
15	In the expanded Digital Program page, verify all sections are displayed & the CTAs are operable based on the way it is setup on HC Admin, including the Notes outline
16	Minimize the Digital Program
17	Make sure to test all areas both with logged out & logged in users 					
*/


