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
1. Launch CA App logged in as Administrative User
2. Tap on the Tile button for the currently active service
3. On the Message page play the video of the current message
4. Enter Fill-in on notes
5. Highlight text on notes
6. Enter Ad-hoc note on notes
7. Return back to the home page
8. Now return back to the same message notes and see notes were saved
9. Repeat steps 4 to 8 with leaving via a different navigation
10. Repeat steps 4 to 8 with leaving via waiting 60 seconds
11. Tap on the See All button under Messages section
12. Tap on back home button from  the Resource/Messages page
11. Tap on one of the What's Happening tiles
12. swipe the message tiles to the right and select an older message
13. Play the video of the older video
14. Navigate to the Home page
15. Tap on the Program button (digital program)
16. Close the digital program page.
17. Tap on any one What's happening tile button.
18. Close the what's happening page 
19. Tap on See All under What's Happening section on homw page
20. Tap on back home button from  the What's Happening page
*/
