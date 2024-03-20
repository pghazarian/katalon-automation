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

MinistryLocationName = "$MinistryName / $LocationName"

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/ministries-central'], FailureHandling.STOP_ON_FAILURE)

'Search for Ministry'
WebUI.setText(findTestObject('HC-Web/Ministry/Search/SearchInput'), SearchTerm)

'Initiate search'
WebUI.sendKeys(findTestObject('HC-Web/Ministry/Search/SearchInput'), Keys.chord(Keys.ENTER))

'Hit Enter again for some odd reason'
WebUI.sendKeys(findTestObject('HC-Web/Ministry/Search/SearchInput'), Keys.chord(Keys.ENTER))

'Validate results'

'Open Ministry'
WebUI.click(findTestObject('Object Repository/HC-Web/Ministry/Search/Search Results Ministry Name Match', [('textToMatch') : MinistryName]))

WebUI.verifyElementText(findTestObject('HC-Web/Ministry/Location/DrawerHeader'), MinistryName)

'Open the Location'
WebUI.click(findTestObject('Object Repository/HC-Web/Ministry/Location/Location List Name Match', [('textToMatch') : LocationName]))

WebUI.delay(1)

WebUI.verifyElementText(findTestObject('HC-Web/Ministry/Location/Drawer2Header'), MinistryLocationName)

WebUI.delay(1)

WebUI.click(findTestObject('HC-Web/Page_Healthy Church/button_MinistryLocation_ViewDashboard'))

WebUI.verifyElementText(findTestObject('HC-Web/Ministry/Details/BreadCrumbMinistryName'), MinistryName)

PersonTableCellObject = CustomKeywords.'TestObjectHelper.getTestObjectWithXpathTextMatch'('//div[contains(@class, \'dashboard-activity-list\')]/div/div/div/table/tbody/tr/td/span/div/div', 
    MemberName, 1)

PersonName = WebUI.getAttribute(PersonTableCellObject, 'innerText')

'Verify the member person\'s name in the table'
WebUI.verifyEqual(PersonName, MemberName)

WebUI.click(PersonTableCellObject)

WebUI.click(findTestObject('HC-Web/Ministry/Members/CloseButton'))

CustomKeywords.'NavigationHelper.clickPrimaryOrSecondary'(
	findTestObject('HC-Web/Ministry/Details/Subnav_Interested'),
	findTestObject('HC-Web/Ministry/Details/Subnav_MoreEllipsis'),
	CustomKeywords.'TestObjectHelper.getTestObjectWithXpath'("//div[contains(@class, 'navigation_sectional_tabs--panel')]/button[contains(@class, 'button_dropdown')]/descendant::div[text() = 'Interested']"))

PersonTableCellObject = CustomKeywords.'TestObjectHelper.getTestObjectWithXpathTextMatch'('//div[contains(@class, \'dashboard-activity-list\')]/div/div/div/table/tbody/tr/td/span/div/div', 
    InterestedName, 1)

PersonName = WebUI.getAttribute(PersonTableCellObject, 'innerText')

'Verify the interested person\'s name in the table'
WebUI.verifyEqual(PersonName, InterestedName)

WebUI.click(PersonTableCellObject)

WebUI.click(findTestObject('HC-Web/Ministry/Members/CloseButton'))

CustomKeywords.'NavigationHelper.clickPrimaryOrSecondary'(
	findTestObject('HC-Web/Ministry/Details/Subnav_ServingOpps'),
	findTestObject('HC-Web/Ministry/Details/Subnav_MoreEllipsis'),
	CustomKeywords.'TestObjectHelper.getTestObjectWithXpath'("//div[contains(@class, 'navigation_sectional_tabs--panel')]/button[contains(@class, 'button_dropdown')]/descendant::div[text() = 'Serving Opps']"))

CustomKeywords.'NavigationHelper.clickPrimaryOrSecondary'(
	findTestObject('HC-Web/Ministry/Details/Subnav_Communications'),
	findTestObject('HC-Web/Ministry/Details/Subnav_MoreEllipsis'),
	CustomKeywords.'TestObjectHelper.getTestObjectWithXpath'("//div[contains(@class, 'navigation_sectional_tabs--panel')]/button[contains(@class, 'button_dropdown')]/descendant::div[text() = 'Communications']"))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/h3_Email Statistics'), 'Email Statistics')

CustomKeywords.'NavigationHelper.clickPrimaryOrSecondary'(
	findTestObject('HC-Web/Ministry/Details/Subnav_Settings'),
	findTestObject('HC-Web/Ministry/Details/Subnav_MoreEllipsis'),
	CustomKeywords.'TestObjectHelper.getTestObjectWithXpath'("//div[contains(@class, 'navigation_sectional_tabs--panel')]/button[contains(@class, 'button_dropdown')]/descendant::div[text() = 'Settings']"))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/h2_Description'), 'Description')

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Ministry Settings'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/h2_Status'), 'Status')

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Membership Settings'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/h2_Accepting New Members'), 'Accepting New Members')

WebUI.closeBrowser()

