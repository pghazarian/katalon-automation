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

'Load the Welcome home page'
WebUI.openBrowser(GlobalVariable.Saddleback_Welcome_URL)

def width = 1024

width += 50

WebUI.setViewPortSize(width, 768)

WebUI.waitForPageLoad(10)

'If the Menu button is NOT displayed, use the Header navigation'
if (!CustomKeywords.'customUtility.TestObjectHelper.isElementVisible'(findTestObject('Object Repository/Saddleback Web/Home/Nav/Menu Button'))) {

WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Language/Language Selected'), 'English')
	
// This logic is inconsistent in Safari (sometimes it works and sometimes it doesn't)
WebUI.click(findTestObject('Saddleback Web/Home/Language/Language Selector'))

WebUI.click(findTestObject('Saddleback Web/Home/Language/Spanish Option'))

} else {
	
	WebUI.click(findTestObject('Object Repository/Saddleback Web/Home/Footer Nav/Language Selector'))
	
	WebUI.selectOptionByLabel(findTestObject('Object Repository/Saddleback Web/Home/Footer Nav/Language Selector'), 'Spanish', false)
	
}

WebUI.delay(3)

WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Actions/span_New to Saddleback'), '¿Recién llegado a Saddleback?')

WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Actions/span_I want to follow Jesus'), 'Quiero seguir a Jesús.')

WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Actions/span_I want to get baptized'), 'Quiero ser bautizado.')

WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Actions/span_I want to find community'), 'Quiero encontrar comunidad.')

WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Actions/span_I want to start volunteering'), 'Quiero empezar a ser voluntario.')

// This comparison works fine in all browsers except Safari. 
// Need to provide a case insensitive comparison to get this working.
WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Latest Message Heading'), 'ÚLTIMO MENSAJE')

'Verify the Watch Now button is present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Saddleback Web/Home/Watch Now Button'), 0)

'Verify the header nav link text'
WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Nav/Location Header Link'), 'Ubicaciones')
WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Nav/Watch Header Link'), 'Ver')
WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Nav/About Header Link'), 'Acerca de')
WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Nav/Care Header Link'), 'Acompañamiento')
WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Nav/Give Header Link'), 'Dar')

WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Language/Language Selected'), 'Español')

WebUI.click(findTestObject('Saddleback Web/Home/Language/Language Selector'))

WebUI.closeBrowser()


