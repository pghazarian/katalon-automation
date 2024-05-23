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
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/communications-central/segment-search'], FailureHandling.STOP_ON_FAILURE)

'Click on Filters icon to open filters rail'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Filter Icon'))

'Click on icon to expand Demographic'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Filters/Demographic Expand Collapse Icon'))

'Select campus from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@id=\'campuses\']/descendant::div[@class=\'Select-multi-value-wrapper\']', 
    'Anaheim')

'Check Male under Gender'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Add Demographic Info/Gender Checkbox', 
        [('index') : 1]))

'Check Female under Gender'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Add Demographic Info/Gender Checkbox', 
        [('index') : 2]))

'Select the text'
WebUI.sendKeys(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Add Demographic Info/Minimum Age Input Field'), 
    Keys.chord(Keys.CONTROL, 'a'))

'Clear the text'
WebUI.sendKeys(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Add Demographic Info/Minimum Age Input Field'), 
    Keys.chord(Keys.BACK_SPACE))

'Enter minimum age'
WebUI.setText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Add Demographic Info/Minimum Age Input Field'), 
    '13')

'Select the text'
WebUI.sendKeys(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Add Demographic Info/Maximum Age Input Field'), 
    Keys.chord(Keys.CONTROL, 'a'))

'Clear the text'
WebUI.sendKeys(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Add Demographic Info/Maximum Age Input Field'), 
    Keys.chord(Keys.BACK_SPACE))

'Enter maximum age'
WebUI.setText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Add Demographic Info/Maximum Age Input Field'), 
    '99')

'Click All under Marital Status'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Add Demographic Info/Marital Status Checkbox', 
        [('index') : 1]))

'Click on Yes under Has Children'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Add Demographic Info/Has Children Radio Button', 
        [('index') : 2]))

'Select grade from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@data-testid=\'filters-grade-selector\']/descendant::div[@class=\'Select-control\']', 
    'None')

'Click on icon to collapse Demographic'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Filters/Demographic Expand Collapse Icon'))

'Click on icon to expand Milestones'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Filters/Milestones Expand Collapse Icon'))

'Select milestone from dropdown'
CustomKeywords.'TestObjectHelper.setDropDownValueByXPath'('//div[@id=\'milestone-selector\']/descendant::div[@class=\'Select-multi-value-wrapper\']', 
    'Accepted Christ')

'Click on Complete under Select Milestone Status'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Milestones/Add Milestone/Milestone Status Radio Button', 
        [('index') : 1, ('index1') : 1]))

'Click on icon to collapse Milestones'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Filters/Milestones Expand Collapse Icon'))

'Click on icon to expand Additional Engagement'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Filters/Additional Engagement Expand Collapse Icon'))

'Click on Yes under In Ministry'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/Add Additional Engagements/In Ministry Radio Button', 
        [('index') : 2]))

'Click on Yes under In Small Group'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/Add Additional Engagements/In Small Group Radio Button', 
        [('index') : 2]))

'Click Member under Member Status to select'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/Add Additional Engagements/Member Status Checkbox', 
        [('index') : 3]))

'Click on icon to collapse Additional Engagement'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Filters/Additional Engagement Expand Collapse Icon'))

'Click button to apply filters'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Filters/Apply Filters Button'))

'Verify segments are filtered per given filter criteria'
WebUI.verifyElementPresent(findTestObject('HC-Web/Communications/Segments/Filtered Segment'), 0)

'Open the segment record from the search results'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Filtered Segment'))

'Verify the updated Target Campus value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Target Campus Value', 
        [('TargetCampus') : 'Anaheim']), 'Anaheim')

'Verify the updated Gender value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Gender Value', [('Gender') : 'Male, Female']), 
    'Male, Female')

'Verify the updated Age value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Age Value', [('Age') : '13 - 99']), 
    '13 - 99')

'Verify the updated Marital Status value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Marital Status Value', 
        [('MaritalStatus') : 'Divorced, Married, Single, Widowed']), 'Divorced, Married, Single, Widowed')

'Verify the updated Children value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Demographic Info/Children Value', 
        [('Children') : 'None']), 'None')

'Verify Milestone/Status label is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Milestones/Milestone Label', [('Milestone') : 'Accepted Christ']), 
    'Accepted Christ')

'Verify default value of Milestone/Status is displayed'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Milestones/Milestone Status', [('MilestoneStatus') : 'Complete']), 
    'Complete')

'Verify the updated In Ministry value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/In Ministry Value', 
        [('InMinistry') : 'Yes']), 'Yes')

'Verify the updated In Small Group value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/In Small Group Value', 
        [('InSmallGroup') : 'Yes']), 'Yes')

'Verify the updated Member Status value'
WebUI.verifyElementText(findTestObject('HC-Web/Communications/Segments/Overview/Additional Engagements/Member Status Value', 
        [('MemberStatus') : 'Member']), 'Member')

'Return to segment search'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Overview/Return To Segment Search Button'))

'Click on Filters icon to open filters rail'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Filter Icon'))

'Click button to clear filters'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Filters/Clear All Button'))

'Click on Filters icon to close filters rail'
WebUI.click(findTestObject('Object Repository/HC-Web/Communications/Segments/Filter Icon'))

'Open the segment record from the search results'
WebUI.click(findTestObject('HC-Web/Communications/Segments/Filtered Segment'))

WebUI.closeBrowser()

