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

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : "/events-central/event/$EventId/overview"], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Occurrence Schedule/Occurrence Schedule Tab'))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Occurrence Schedule/Check In Button'))

WebUI.click(findTestObject('HC-Web/Event/Check In/Filter Button'))

CustomKeywords.'TestObjectHelper.setDropDownValue'('check_in_page--filter_panel_drawer_sort_dropdown', 'Name (Ascending)')

WebUI.verifyElementText(findTestObject('HC-Web/Event/Check In/First Room Name'), 'Anaheim Main Worship Center')

CustomKeywords.'TestObjectHelper.setDropDownValue'('check_in_page--filter_panel_drawer_sort_dropdown', 'Name (Descending)')

WebUI.verifyElementText(findTestObject('HC-Web/Event/Check In/First Room Name'), 'Children\'s Room 4')

CustomKeywords.'TestObjectHelper.setDropDownValue'('check_in_page--filter_panel_drawer_sort_dropdown', 'Capacity (Lowest > Highest)')

WebUI.verifyElementText(findTestObject('HC-Web/Event/Check In/First Room Name'), 'Children\'s Room 1')

CustomKeywords.'TestObjectHelper.setDropDownValue'('check_in_page--filter_panel_drawer_sort_dropdown', 'Capacity (Highest > Lowest)')

WebUI.verifyElementText(findTestObject('HC-Web/Event/Check In/First Room Name'), 'Anaheim Main Worship Center')

CustomKeywords.'TestObjectHelper.setDropDownValue'('check_in_page--filter_panel_drawer_category_dropdown', 'Infants')

WebUI.verifyElementText(findTestObject('HC-Web/Event/Check In/First Room Name'), 'Children\'s Room 1')

CustomKeywords.'TestObjectHelper.setDropDownValue'('check_in_page--filter_panel_drawer_category_dropdown', 'Crawlers')

WebUI.verifyElementText(findTestObject('HC-Web/Event/Check In/First Room Name'), 'Children\'s Room 2')

CustomKeywords.'TestObjectHelper.setDropDownValue'('check_in_page--filter_panel_drawer_category_dropdown', 'New Walkers')

WebUI.verifyElementText(findTestObject('HC-Web/Event/Check In/First Room Name'), 'Children\'s Room 3')

CustomKeywords.'TestObjectHelper.setDropDownValue'('check_in_page--filter_panel_drawer_category_dropdown', '1st Grade')

WebUI.verifyElementText(findTestObject('HC-Web/Event/Check In/First Room Name'), 'Children\'s Room 4')

WebUI.closeBrowser()

