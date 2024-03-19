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

def envPrefix = GlobalVariable.EnvironmentPrefix

'Go to the HC About page'
WebUI.openBrowser(CustomKeywords.'NavigationHelper.getHCUrl'('/about'))

'Get the Core Version and we will verify the rest of the versions based on this value'
def to = CustomKeywords.'TestObjectHelper.getTestObjectById'("$envPrefix-core-version")

def fullVersion = CustomKeywords.'TestObjectHelper.getWebElementText'(to)

def targetHcVersion = CustomKeywords.'StringHelper.parseMajorMinorVersion'(fullVersion)

CustomKeywords.'TestObjectHelper.verifyObjectValueContains'(to, targetHcVersion)

'Verify Events Version'
to = CustomKeywords.'TestObjectHelper.getTestObjectById'("$envPrefix-events-version")

CustomKeywords.'TestObjectHelper.verifyObjectValueContains'(to, targetHcVersion)

'Verify Giving Version'
to = CustomKeywords.'TestObjectHelper.getTestObjectById'("$envPrefix-giving-version")

CustomKeywords.'TestObjectHelper.verifyObjectValueContains'(to, targetHcVersion)

'Verify Journey Version'
to = CustomKeywords.'TestObjectHelper.getTestObjectById'("$envPrefix-journey-version")

CustomKeywords.'TestObjectHelper.verifyObjectValueContains'(to, targetHcVersion)

'Verify Notifications Version'
to = CustomKeywords.'TestObjectHelper.getTestObjectById'("$envPrefix-notifications-version")

CustomKeywords.'TestObjectHelper.verifyObjectValueContains'(to, targetHcVersion)

'Verify Small Groups Version'
to = CustomKeywords.'TestObjectHelper.getTestObjectById'("$envPrefix-smallgroups-version")

CustomKeywords.'TestObjectHelper.verifyObjectValueContains'(to, targetHcVersion)

'Verify Workflow Version'
to = CustomKeywords.'TestObjectHelper.getTestObjectById'("$envPrefix-workflows-version")

CustomKeywords.'TestObjectHelper.verifyObjectValueContains'(to, targetHcVersion)

'Verify UI Version'
to = CustomKeywords.'TestObjectHelper.getTestObjectById'("$envPrefix-ui-version")

CustomKeywords.'TestObjectHelper.verifyObjectValueContains'(to, targetHcVersion)

WebUI.closeBrowser()

