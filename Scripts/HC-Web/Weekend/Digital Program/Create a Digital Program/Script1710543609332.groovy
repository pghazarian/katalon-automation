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

'Set Local Date and Time to the variable'
def randText = String.format('%tF %<tH:%<tM', java.time.LocalDateTime.now())
def uniqueTxt = new Random().with {(1..9).collect {(('a'..'z')).join()[ nextInt((('a'..'z')).join().length())]}.join()}

'Set the Digital Program Title variable with the Date time values in it'
randText = ('Dig Prog ' + randText + " " + uniqueTxt)

'Login and Navigate to Digital Programs Page'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/content-management/digital-program'], FailureHandling.STOP_ON_FAILURE)

'Verify the Digital Programs Page title is set to Digital Programs'
WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Programs Header Text'), 
    'Digital Programs')

'Verify the + New Digital Program button text'
WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/New Digital Program Button'), 
    'New Digital Program')

'Click on the "+ New Digital Program" button'
WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/New Digital Program Button'))

'Verify the new digital program modal header text is "Create New Program"'
WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Create New Program Header Text'), 
    'Create New Program')

'Verify the new digital program modal sub-header text has "Program Details" section'
WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Program Details sub Header Text'), 
    'Program Details')

'Set the Title field with Digital Program Title variable value'
WebUI.setText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Title Input'), 
    randText)

'Click on Save button to save the New Digital Program'
WebUI.click(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Save New Digital Program Button'))

'Verify Successful message is displayed when a digital program is created'
WebUI.verifyElementText(findTestObject('Object Repository/HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Created Successful Message'), 
    'Successful')

'Verify the Digital Program title displayed in the builder'
WebUI.verifyElementText(findTestObject('HC-Web/Mobile Engagement/Digital Program/Create Digital Program/DIgital Program Title in Builder'), 
    randText)

'Verify the Digital Program title displayed in Top NAV'
WebUI.verifyElementText(findTestObject('HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Title in Top NAV'), 
    randText)

'Verify the Digital Program builder is launched with Template'
WebUI.verifyElementPresent(findTestObject('HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Builder Template dropdown'), 
    0)

'Verify User is landed in the Digital Program builder'
WebUI.verifyElementPresent(findTestObject('HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Builder Header Text'), 
    0)

'Verify Digital Program builder has "Add a Button" section header displayed'
WebUI.verifyElementPresent(findTestObject('HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Builder Add a Button Header Text'), 
    0)

'Verify Digital Program builder "Edit Details" Button displayed'
WebUI.verifyElementPresent(findTestObject('HC-Web/Mobile Engagement/Digital Program/Create Digital Program/Digital Program Edit Details Button'), 
    0)

