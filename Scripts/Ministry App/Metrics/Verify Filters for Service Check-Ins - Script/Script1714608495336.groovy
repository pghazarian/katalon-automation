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
 * 6. Tap on Filter icon 
 * 7. Verify Filters drawer pops open from the bottom of the screen 
 * 8. Verify Filters header is displayed on top left corner of drawer 
 * 9. Verify Campus field exists with a ">" Chevron icon to the far right of it 
 * 10. Verify Service field exists with a ">" Chevron icon to the far right of it 
 * 11. Verify when tapping on the Chevron icon next to the Campus field, all Campuses in HC admin will be displayed 
 * 12. Verify when tapping on the Chevron icon next to the Service field, all Services in HC admin will be displayed 
 * 13. Verify when filtering on a specific Campus, all Service Check-Ins for selected Campus are displayed  
 * 14. Verify when filtering on a specific Service, all Service Check-Ins for selected Service are displayed  
 * 15. Verify when filtering on both Services for a specific Campus, all available services for the selected campus are displayed   
 * 16. Verify when filtering on Services which have no data gathered yet will show a Pending link  
 */