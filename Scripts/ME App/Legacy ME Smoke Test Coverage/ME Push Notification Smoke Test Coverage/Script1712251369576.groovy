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
1	"NOTE: This TEST CASE will take 30 minutes to 2 hours depending on how smooth it goes.
Also it will require for a backend developer to push notification through each step.
DD = Daily Devotional; DV = Daily Verse; MP = Manual Push (Journey for now)"									All permutations to PASS
2	Let's cover Logged in first
3	DV Logged in; App Forced Shut Push DV notifications																Notification should open App and take user to Daily Verse, Today at the top followed by previous days with a Dates on them
4	DV Logged in; App running in the background on TWM Push DV notification											Notification should open App and take user to Daily Verse, Today at the top followed by previous days with a Dates on them
5	DV Logged in; App running and open on This Week's Message  Push DV notification;
DO NOT Select Push notification instead follow red indicator on profile notifications							Pop-up notification guiding user to Daily Verse * red indicator on Android and Push notification on iOS, Today at the top followed by previous days with a Dates on them
6	Multiple DV with ME Minimized logged in (TWM page)
iOS - You will receive 3 different notifications - Choose the middle one
Android - You will get updated notification upon multiple attempts												Notification should open App and take user to Daily Verse
7	DD Logged in; App Forced Shut; Push DD notifications															Notification should open App and take user to the latest Daily Devotional Details
8	DD Logged in; App running in the background on TWM (minimized); Push DD notification 							Notification should open App and take user to the latest Daily Devotional Details
9	DD Logged in; App running and open on This Week's Message page: Push DD notification
DO NOT Select Push notification instead follow red indicator on profile notifications							Pop-up notification guiding user to the latest Daily Devotional Details
10	Multiple DD with ME Minimized logged in (TWM page)
iOS - You will receive 3 different notifications - Choose the middle one
Android - You will get updated notification upon multiple attempts												Notification should open App and take user to  the latest Daily Devotional List
11	MP Logged in; App Forced Shut; Push MP notifications															Notification should open App and take user to Journey Today's page
12	MP Logged in; App running in the background on TWM (minimized); Push MP notification 							Notification should open App and take user to Journey Today's page
13	"Multiple MP with ME Minimized logged in (TWM page)
iOS - You will receive 3 different notifications - Choose the middle one
Android - You will get updated notification upon multiple attempts												Notification should open App and take user to  Journey Today's page
14	Logged in turn all notifications OFF (Main)
DV Push
DD Push
MP Push																											Device should NOT get any notification for all 3 push notifications
15	Turn All notification back on
16	Logged in turn off all 3 toggles
Verse of the Day OFF
Daily Devotional OFF
Mobile Announcement OFF
THEN
DV Push
DD Push
MP Push																											Device should NOT get any notification for all 3 push notifications
17	Turn All 3 toggles back on from previous step and SAVE at the bottom
18	Now Let's move to LOGGED OUT
19	DV Logged out; App Forced Shut; Push DV notifications															Notification should open App and take user to Daily Verse, after user select continue as guest and selects campus to continue
20	DV Logged out; App running in the background (ME Minimized); Push DV notification 								Notification should open App and take user to Daily Verse
21	DV Logged out; App running and open on This Week's Message
Push DV notification; DO NOT Select Push notification instead follow red indicator on profile notifications		Pop-up notification guiding user to Daily Verse, red dot on Profile Icon
22	Multiple DV with ME Minimized logged out (TWM page)
iOS - You will receive 3 different notifications - Choose the middle one
Android - You will get updated notification upon multiple attempts												Notification should open App and take user to Daily Verse,
23	MP Logged out; App Forced Shut; Push MP notifications															Should open App and take user to Journey Today's Page, after user select continue as guest and selects campus to continue
24	MP Logged out; App running in the background (ME Minimized) ; Push MP notification 								Notification should open App and take user to Journey Today's page
25	Multiple MP with ME Minimized logged in (TWM page)
iOS - You will receive 3 different notifications - Choose the middle one
Android - You will get updated notification upon multiple attempts												Notification should open App and take user to Journey Today's page
*/