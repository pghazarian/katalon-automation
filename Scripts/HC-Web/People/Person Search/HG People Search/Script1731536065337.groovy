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

def UserName = GlobalVariable.Admin_UserName
def UserNamePW = GlobalVariable.Admin_Password
def SearchTerm = GlobalVariable.PersonSearch_Term
def HostURL = GlobalVariable.HC_HostUrl

//Open URL
//WebUI.openBrowser('https://hc-stage.saddleback.com/people/search-or-add')
WebUI.openBrowser(HostURL + '/people/search-or-add')

//Enter Login Info and submit
WebUI.sendKeys(findTestObject('Object Repository/Hagop_Testing/BackOffice - Person Search/Email field'), UserName)
WebUI.setEncryptedText(findTestObject('Object Repository/Hagop_Testing/BackOffice - Person Search/Password field'), UserNamePW)
WebUI.click(findTestObject('Object Repository/Hagop_Testing/BackOffice - Person Search/Login Button'))
WebUI.verifyTextPresent('Search or Add', true)

//Search for a Person
WebUI.sendKeys(findTestObject('Object Repository/Hagop_Testing/BackOffice - Person Search/Search Text Field'), SearchTerm)
WebUI.sendKeys(findTestObject('Object Repository/Hagop_Testing/BackOffice - Person Search/Search Text Field'), Keys.chord(Keys.ENTER))