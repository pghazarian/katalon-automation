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
1.	Poll where every possible selection fits within default For You ribbon tile button size – checkbox
2.	Poll where every possible selection fits within default For You ribbon tile button size – radio button
3.	Poll where every possible selection pushes beyond what fits within default For You ribbon tile button size – checkbox
4.	Poll where every possible selection pushes beyond what fits within default For You ribbon tile button size – radio button
5.	Poll stats are properly displayed when setup
6.	Poll stats are NOT displayed when not setup
7.	Default image is displayed when none is setup
8.	Image is properly displayed when setup
9.	There should not be a default image if Studio C User does not enter an Image
10.	Polls Response Text is added
11.	Polls Response Text is not added (nothing should show up)
12.	Days After Submission (should show for the number of days after a user submitted a poll)

*/