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
WebUI.callTestCase(findTestCase('HC-Web/Login'), [('HostUrl') : HostUrl, ('UserName') : UserName, ('Password') : Password], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/p_Ministries Central'))

'Search for Ministry'
WebUI.setText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/input_text'), SearchTerm)

'Initiate search'
WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Page_Healthy Church/input_text'), Keys.chord(Keys.ENTER))

'Click Enter twice because of bug in the page'
WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Page_Healthy Church/input_text'), Keys.chord(Keys.ENTER))

WebUI.verifyElementText(findTestObject('HC-Web/Ministry/Search/MinistryRow1_MinistryName'), MinistryName)

'Open Ministry'
WebUI.click(findTestObject('HC-Web/Ministry/Search/MinistryRow1_MinistryName'))

WebUI.verifyElementText(findTestObject('HC-Web/Ministry/Location/DrawerHeader'), MinistryName)

LocationRowObject = CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpath'(((('//div[@class=\'drawer-children\']/table/tbody/tr/td[(text() = \'' + 
    LocationName) + '\' or . = \'') + LocationName) + '\')]')

LocationValue = WebUI.getAttribute(LocationRowObject, 'innerText')

'Verify the location value'
WebUI.verifyEqual(LocationValue, LocationName)

'Open the Location'
WebUI.click(LocationRowObject)

MinistryLocationName = ((MinistryName + ' / ') + LocationName)

WebUI.verifyElementText(findTestObject('HC-Web/Ministry/Location/Drawer2Header'), MinistryLocationName)

WebUI.click(findTestObject('HC-Web/Page_Healthy Church/button_MinistryLocation_ViewDashboard'))

WebUI.verifyElementText(findTestObject('HC-Web/Ministry/Details/BreadCrumbMinistryName'), MinistryName)

WebUI.click(findTestObject('HC-Web/Ministry/Members/MemberTableRow1'))

WebUI.verifyElementText(findTestObject('HC-Web/Ministry/Members/MemberTableRow1FullName'), MemberName1)

WebUI.click(findTestObject('HC-Web/Page_Healthy Church People - Person Record _615a46/CloseButton'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Interested'))

WebUI.click(findTestObject('HC-Web/Ministry/Members/MemberTableRow1'))

WebUI.verifyElementText(findTestObject('HC-Web/Ministry/Members/MemberTableRow1FullName'), InterestedName1)

WebUI.click(findTestObject('HC-Web/Page_Healthy Church People - Person Record _99d737/CloseButton'))

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Serving Opps'))

WebUI.click(findTestObject('HC-Web/Ministry/Details/Subnav_Communications'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/h3_Email Statistics'), 'Email Statistics')

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Settings'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/h2_Description'), 'Description')

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Ministry Settings'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/h2_Status'), 'Status')

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/span_Membership Settings'))

WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Page_Healthy Church/h2_Accepting New Members'), 'Accepting New Members')

WebUI.closeBrowser()

