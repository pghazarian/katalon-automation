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
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.User_NoViewDOBPermissions_UserName
        , ('Password') : GlobalVariable.User_NoViewDOBPermissions_Password], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/HC-Web/Page_Healthy Church/p_People'))

WebUI.clearText(findTestObject('HC-Web/Person/Search/SearchInput'))

'Type Search term'
WebUI.setText(findTestObject('HC-Web/Person/Search/SearchInput'), SearchTerm)

'Initiate Search'
WebUI.sendKeys(findTestObject('HC-Web/Person/Search/SearchInput'), Keys.chord(Keys.ENTER))

WebUI.verifyElementPresent(findTestObject('HC-Web/Person/Search/TableRowOne'), 0)

SearchTableCellObject = CustomKeywords.'customUtility.TestObjectHelper.getTestObjectWithXpathTextMatch'('//div[@data-testid=\'person-personal-info\']/div', 
    VerificationName, 1)

PersonName = WebUI.getAttribute(SearchTableCellObject, 'innerText')

'Verify a row contains the expected name'
WebUI.verifyElementText(SearchTableCellObject, VerificationName)

'Verify that the Personal Details Column is visible'
WebUI.verifyElementVisible(findTestObject('HC-Web/Person/Search/TableColumn_PersonalDetails'))

'Verify that the Email Column is visible'
WebUI.verifyElementVisible(findTestObject('HC-Web/Person/Search/TableColumn_Email'))

'Verify that the DOB Column is not visible'
WebUI.verifyElementNotVisible(findTestObject('HC-Web/Person/Search/TableColumn_DOB'))

'Open the person record from the search results'
WebUI.click(SearchTableCellObject)

WebUI.verifyElementPresent(findTestObject('HC-Web/Person/Details/PersonName'), 0)

'Verify the name in the details page'
WebUI.verifyElementText(findTestObject('HC-Web/Person/Details/PersonName'), VerificationName)

'Open the Person Edit page'
WebUI.click(findTestObject('HC-Web/Person/Details/EditButton'))

//inputValue = WebUI.getAttribute(findTestObject('HC-Web/Person/Edit/FirstNameInput'), 'value')
//
//'Verify the first name field value'
//WebUI.verifyEqual(inputValue, FirstName)
//
//inputValue = WebUI.getAttribute(findTestObject('HC-Web/Person/Edit/LastNameInput'), 'value')
//
//'Verify the last name field value'
//WebUI.verifyEqual(inputValue, LastName)

'Verify the first name field value'
CustomKeywords.'customUtility.TestObjectHelper.verifyTextFieldValueEqual'(findTestObject('HC-Web/Person/Edit/FirstNameInput'), FirstName)

'Verify the last name field value'
CustomKeywords.'customUtility.TestObjectHelper.verifyTextFieldValueEqual'(findTestObject('HC-Web/Person/Edit/LastNameInput'), LastName)

'Verify the birthdate label is not present'
WebUI.verifyElementNotPresent(findTestObject('HC-Web/Person/Details/Birthdate_Label'), 0)

'Verify the birthdate text field is not present'
WebUI.verifyElementNotPresent(findTestObject('HC-Web/Person/Details/Birthdate_TextField'), 0)

WebUI.closeBrowser()

