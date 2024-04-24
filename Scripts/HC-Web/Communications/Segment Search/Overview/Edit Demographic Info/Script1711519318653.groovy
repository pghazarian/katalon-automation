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

WebUI.callTestCase(findTestCase('HC-Web/Communications/Segment Search/Shared/Create Segment'), [:], FailureHandling.STOP_ON_FAILURE)

'Click on the Edit button next to Demographic Info'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Demographic Info Edit Button'))

'Scroll to top of the Demographic Info section'
WebUI.scrollToPosition(0, 0)

'Select campus from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'campus-selector\']/descendant::div[@class=\'Select-control\']', 
    'Anaheim')

'Select Male using the checkbox'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Add Demographic Info/Gender Checkbox', 
        [('index') : 1]))

'Select Female using the checkbox'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Add Demographic Info/Gender Checkbox', 
        [('index') : 2]))

'Click on Include Students under Student?'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Add Demographic Info/Student Checkbox', 
        [('index') : 2]))

'Enter minimum age'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Demographic Info/Add Demographic Info/Minimum Age Input Field'), 
    '13')

'Enter maximum age'
WebUI.setText(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Demographic Info/Add Demographic Info/Maximum Age Input Field'), 
    '99')

'Click All under Marital Status'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Add Demographic Info/Marital Status Checkbox', 
        [('index') : 1]))

'Click on Yes under Has Children'
WebUI.click(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Add Demographic Info/Has Children Radio Button', 
        [('index') : 2]))

'Select grade from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'grade-selector\']/descendant::div[@class=\'Select-control\']', 
    'Grade 1')

'Click button to save demographic info'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segment Search/Overview/Demographic Info/Add Demographic Info/Demographic Info Save Button'))

'Verify demographic info updated toast is displayed'
WebUI.verifyElementVisible(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info Updated Toast'), 
    FailureHandling.STOP_ON_FAILURE)

'Verify the text in the toast message'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info Updated Toast Text'), 
    'Demographic info updated successfully')

'Scroll to top of the Demographic Info section'
WebUI.scrollToPosition(0, 0)

'Verify the updated Target Campus value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Target Campus Value', 
        [('TargetCampus') : 'Anaheim']), 'Anaheim')

'Verify the updated Gender value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Gender Value', [('Gender') : 'Male, Female']), 
    'Male, Female')

'Verify the updated Student? value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Student Value', [
            ('Student') : 'Include Students']), 'Include Students')

'Verify the updated Age value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Age Value', [('Age') : '13 - 99']), 
    '13 - 99')

'Verify the updated Marital Status value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Marital Status Value', 
        [('MaritalStatus') : 'Divorced, Married, Single, Widowed']), 'Divorced, Married, Single, Widowed')

'Verify the updated Children value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segment Search/Overview/Demographic Info/Children Value', 
        [('Children') : 'First']), 'First')

WebUI.closeBrowser()

