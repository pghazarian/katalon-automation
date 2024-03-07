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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/events-central/event/27471/overview'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Occurrence Schedule/Occurrence Schedule Tab'))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Occurrence Schedule/Check In Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/First Room'))

if (!WebUI.findWebElements(findTestObject('Object Repository/HC-Web/Event/Check In/Open Room Early Yes Button'), 5, FailureHandling.CONTINUE_ON_FAILURE).isEmpty()) {
    WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/Open Room Early Yes Button'))
}

if (!WebUI.findWebElements(findTestObject('Object Repository/HC-Web/Event/Check In/General Room Button'), 5, FailureHandling.CONTINUE_ON_FAILURE).isEmpty()) {
    WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/General Room Button'))
}

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/Search or Add Button'))

WebUI.setText(findTestObject('Object Repository/HC-Web/Event/Check In/Attendee Search Bar'), 'QA Automation Admin')

WebUI.sendKeys(findTestObject('Object Repository/HC-Web/Event/Check In/Attendee Search Bar'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/Attendee Search Results'))

WebUI.verifyElementText(findTestObject('HC-Web/Event/Check In/Attendee Names'), 'QA Automation Admin')

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/Attendee Checkboxes'))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/Checkout Button'))

WebUI.click(findTestObject('Object Repository/HC-Web/Event/Check In/Checkout Confirmation Yes Button'))

WebUI.verifyElementNotPresent(findTestObject('HC-Web/Event/Check In/Attendee Names'), 5)

WebUI.click(findTestObject('HC-Web/Event/Check In/Close Space Button'))

WebUI.click(findTestObject('HC-Web/Event/Check In/Close Space Confirmation Yes Button'))

WebUI.closeBrowser()

