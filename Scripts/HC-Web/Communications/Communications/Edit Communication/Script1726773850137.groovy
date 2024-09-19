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

not_run: WebUI.callTestCase(findTestCase('HC-Web/Communications/Communications/Shared/Create Communication'), [:], FailureHandling.STOP_ON_FAILURE)

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/communications-central/communication'], FailureHandling.STOP_ON_FAILURE)

'Type Search term'
WebUI.setText(findTestObject('HC-Web/Communications/Communications/Search Text Field'), SearchTerm)

'Initiate Search'
WebUI.sendKeys(findTestObject('HC-Web/Communications/Communications/Search Text Field'), Keys.chord(Keys.ENTER))

'Open the communication record from the search results'
WebUI.click(findTestObject('HC-Web/Communications/Communications/Table Row', [('CommunicationName') : SearchTerm]))

'Click button to edit communication details'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Communications/Overview/Communication Details/Edit Communication Details Button'))

'Select from email from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'communication_edit--from_email_selector\']/descendant::div[@class=\'Select-control\']', 
    FromEmail)

'Select recipients from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'communication_edit--recipients_selector\']/descendant::div[@class=\'Select-control\']', 
    Recipients)

'Select reply to email from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'communication_edit--reply_to_selector\']/descendant::div[@class=\'Select-control\']', 
    ReplyToEmail)

'Select the text'
WebUI.sendKeys(findTestObject('HC-Web/Communications/Communications/Overview/Communication Details/Edit Communication Details/Email Subject Text Area'), 
    Keys.chord(Keys.CONTROL, 'a'))

'Clear the text'
WebUI.sendKeys(findTestObject('HC-Web/Communications/Communications/Overview/Communication Details/Edit Communication Details/Email Subject Text Area'), 
    Keys.chord(Keys.BACK_SPACE))

'Update email subject'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Communications/Overview/Communication Details/Edit Communication Details/Email Subject Text Area'), 
    EmailSubject)

'Click button to save communication details'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Communications/Overview/Communication Details/Edit Communication Details/Communication Details Save Button'))

'Verify segment record updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Communications/Overview/Communication Record Toast'), FailureHandling.STOP_ON_FAILURE)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Overview/Communication Details Updated Toast Header'), 
    'Communication details updated')

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Overview/Communication Details Updated Toast Text'), 
    'You’ve successfully updated the communication details')

'Verify the updated From Email value is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Overview/Communication Details/From Email Value', 
        [('FromEmail') : FromEmail]), FromEmail)

'Verify the updated Recipients value is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Overview/Communication Details/Recipients Value', 
        [('Recipients') : Recipients]), Recipients)

'Verify the updated Reply To Email value is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Overview/Communication Details/Reply To Value', 
        [('ReplyTo') : ReplyToEmail]), ReplyToEmail)

'Verify the updated Email Subject value is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Communications/Overview/Communication Details/Email Subject Value', 
        [('EmailSubject') : EmailSubject]), EmailSubject)

WebUI.closeBrowser()

