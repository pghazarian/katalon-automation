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
1	Pre-REQ: Have a fresh Service Template Outline from the back-office with 4+ Auto-Fills	
2	Install ME APP	
3	Click on Tile or Open from PlayStore or AppStore													Make sure ME APP launches on only one click
4	Select a Campus	Make sure "Continue" button turns Green
5	Continue																							You should see This Week's Service landing page with Full Sermon Video on top and 6 tiles below
6	Tap on the My Profile Avatar and Tap on the Settings Icon top right > and Sign In	
7	Continue to pop-up	
8	Enter login email and password; Sign in	
9	My Stuff LP should load	
10	"X" out
11	Click Play on the Video	Make sure Video plays (Leave it playing while you continue to next steps; 	Make sure you see a blue banner on top "Service Playing" that takes you back to video from anywhere in the app)
12	Click on Notes tile button																			You should see Today's Sermon with video on top and Today's Notes
13	Fill in the blank	
14	Highlight a few words	
15	Enter ad hoc notes in an empty space	
16	Click on Back arrow	Back to This Week's Service 
17	Click on Notes tile button again																	Make sure your changes are there
18	Repeat Step 12-14	
19	This time leave area with the menu button anywhere else (i.e. Discover)	
20	Now go back to Notes again																			Make sure your changes are there
21	Repeat Step 12-14
22	This time stay in the area and wait for the 60 seconds auto-save									There should be a spinner on top indicating, updates are saved
23	Exit Notes and Re-Enter																				Make sure your changes are there
24	Exit Notes and Re-Enter a Few times																	Making sure your changes and Auto-Fills are always there
25	Click on the Digital Program button																	The dynamic Digital Program page will be displayed.
26	Click on "Connect" tile																				You should see a list of check box responses
27	Select a few Responses or one																		Make sure "Submit" button turns Blue
28	Submit																								Verify confirmation screen is good
29	Click on Done																						Back to Today's Service LP
30	From "My Stuff" tap on the "My Prayers" tile and tap on the "+" sign and enter all required fields	Make sure "Submit" button turns blue after entry
31	Submit																								Verify confirmation screen is good
32	From This Week's Message page, Click on "Announcements" tile button									Announcements LP
33	Click on Back arrow																					Back to Today's Service LP
34	Click on "Music" tile button																		Today's Music LP
35	Click on Back arrow																					Back to Today's Service LP
36	Click on "Give" tile button																			Giving LP
37	Go back to APP
38	From This Week's Message page, Go to Recent Messages page 											Should take you to Recent Messages LP with results
39	Click on same sermon from Today's service															Make sure it loads without any issues and your changes are there
40	Try playing the Video with the Play icon															It should start Video
																										NOTE: Keep note of Video type (whether it's Media ID or Youtube URL)
41	Now pause video and go back with arrow																Back to RM LP
42	Choose an archived result that has the other type of Video's										NOTE: You will need service templates, one with media ID and one with Youtube URL. This might require you to set it up in the back-office 																										  Purpose of this step is to make sure both Media ID and Youtube URL Video's work
43	Tap on the Back button and tap on "All Series" 														link Should take you to a page with series results
44	Click on a result																					Make sure it loads without any issues
45	Now go back twice with back arrow																	Back to WM LP
46	Click in the Search bar																				Cursor focus should be in the search bar
47	Do a search without any entry																		Should get results
48	Click on a result																					Make sure it loads without any issues
49	Go to Discover page																					Should take you to Events LP with results
50	Click on any result and register																	After Submit; Make sure it goes through with a save animation
51	Go to Serving Tab																					Should take you to SO LP with results
52	Click on any result and register with "I'm Interested" 	After submit; 								Make sure it goes through with a save animation
53	Go to Ministries tab																				Should take you to Ministries LP with results
54	Click on any result and register with "Get Involved"	After submit; 								Make sure it goes through with a save animation
55	Go to "More" section > Service Times																Make sure you see Campuses on Map with each campus information and directions when scrolling down
56	Go to More section>Our Church																		Make sure page loads
57	Go to More section>Terms of Service																	Make sure page loads
58	Go to More section>Privacy Policy																	Make sure page loads
59	Go to My Profile Icon top right > Settings Icon	Play with the Notifications Preferences toggles and make sure they work
60	Go to My Profile icon top right > Daily Verse														Make sure it expands with today's verse
61	Go to Profile icon top right>Daily Devotional														The Daily Devotional page should open with today's and past devotionals
62	Tap on Today's and past devotionals																	Should display the details of the devotionals with text and/or audio/video.
63	From My Profile > Click on Edit Profile link > About me	Make a few updates and delete an un-required field and save; Make sure it's updated
64	Click on Contact Info
65	Add a phone																							Make sure it's added
66	Delete the same added phone																			Make sure it's deleted
67	Click on Occupation
68	Update one and Save																					Make sure it's updated
69	Click on Account Settings
70	Click on Email
71	Update Email (Make sure it's valid and you have access) 											Make sure it's updated and you can login with the new email after verifying it
72	Same location Update Password																		Make sure new password works
73	Scroll to bottom of Account Settings page and tap on the Account Removal link						User should navigate to to Account Removal Form page
																										Logged in User's Personal and Contact information should be pre-populated in all fields
74	Tap on the close "X" icon button																	The Account Removal form should close and user focus will be Account Settings page under ME app
75	Go to My Profile top right > My Notes																Should take you to My Notes with your updated sermon from step 12
76	Go to My Profile top right > My Prayers																Should take you to Prayer Requests
77	Go to My Profile top right > My Groups																Should take you to external site with small group finder
78	Go to My Profile top right > My Ministries															Should take you to "My Ministries" with all that you are involved with
79	Go to My Profile top right
80	At the bottom "My Events" 																			Should have all your registered events
81	At the bottom "My Serving" 																			Should have all your registered, I can serve serving opportunities
82	Now force close the app (not running in the background)												The app should close and should not show up in list of running apps for the device under test.
83	Relaunch the app  (repeat steps 82 and 83 numerous times)											The app should launch with the user still logged in and the home campus should be the default campus and NO campus selection page should 																										 be displayed.  Also, the current service for the home campus should be displayed by default.
*/