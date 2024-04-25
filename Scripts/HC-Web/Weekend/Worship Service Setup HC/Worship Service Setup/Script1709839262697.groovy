import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.googlecode.javacv.cpp.videoInputLib.GUID as GUID
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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/events-central/worship-service-setup'], FailureHandling.STOP_ON_FAILURE)

def WorshipServiceName = 'QA Automation Worship Service ' + UUID.randomUUID()

'Verify that the sub navigation buttons are available.'

'Click button to filter for One-time services'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Worship Service Setup/One-Time Tab Button'))

'Click button to filter for Closed services'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Worship Service Setup/Closed Tab Button'))

'Click button to filter for Recurring services'
WebUI.click(findTestObject('Object Repository/HC-Web/Event/Worship Service Setup/Recurring Tab Button'))

'Click button to create new worship service'
WebUI.click(findTestObject('HC-Web/Event/Worship Service Setup/New Service Button'))

'Set a name for the service'
WebUI.setText(findTestObject('HC-Web/Event/Worship Service Setup/Name Text Field'), WorshipServiceName)

WebUI.scrollToElement(findTestObject('HC-Web/Event/Worship Service Setup/Name Text Field'), 0)

'Select a campus'
CustomKeywords.'TestObjectHelper.setDropDownValueWithClick'('new_serving_opportunity_where_saddleback--campus', campus)

'Save worship service'
WebUI.click(findTestObject('HC-Web/Event/Worship Service Setup/Save Button'))

WebUI.click(findTestObject('HC-Web/Event/Worship Service Setup/Save Service Confirmation Yes Button'))

'Search for newly created service'
WebUI.setText(findTestObject('HC-Web/Event/Worship Service Setup/Search Bar'), WorshipServiceName + Keys.ENTER)

WebUI.delay(3)

'Verify service appears in list'
WebUI.verifyTextPresent(WorshipServiceName, false)

'Click actions dropdown for first service in list'
WebUI.click(findTestObject('HC-Web/Event/Worship Service Setup/Actions Dropdown'))

'Close service'
WebUI.click(findTestObject('HC-Web/Event/Worship Service Setup/Close Service Dropdown Option'))

WebUI.click(findTestObject('HC-Web/Event/Worship Service Setup/Close Service Confirmation Yes Button'))

WebUI.delay(3)

'Verify service was removed from list'
WebUI.verifyTextNotPresent(WorshipServiceName, false)

WebUI.closeBrowser()

