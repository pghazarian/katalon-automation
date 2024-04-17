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

TargetLanguageTranslated = 'Español'
LocationTranslated = 'Ubicaciones'
WatchTranslated = 'Ver'
AboutTranslated = 'Acerca de'
CareTranslated = 'Acompañamiento'
GiveTranslated = 'Dar'
NewToSaddlebackTranslated = '¿Recién llegado a Saddleback?'
FollowJesusTranslated = 'Quiero seguir a Jesús.'
GetBaptizedTranslated = 'Quiero ser bautizado.'
FindCommunityTranslated = 'Quiero encontrar comunidad.'
StartVolunteeringTranslated = 'Quiero empezar a ser voluntario.'
MessageHeadingTranslated = 'ÚLTIMO MENSAJE'
WatchNowTranslated = 'Ver ahora'

'If the Menu button is NOT displayed, use the Header navigation'
if (!CustomKeywords.'TestObjectHelper.isElementVisible'(findTestObject('Object Repository/Saddleback Web/Home/Nav/Menu Button'))) {

	WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Language/Language Selected'), 'English')
	
	// This logic is inconsistent in Safari (sometimes it works and sometimes it doesn't)
	WebUI.click(findTestObject('Saddleback Web/Home/Language/Language Selector'))
	
	WebUI.click(CustomKeywords.'TestObjectHelper.getTestObjectWithXpath'("//div[contains(@class, 'desktop-center')]/div[@class='header-lang-select']//descendant::ul/li[text()='$TargetLanguageTranslated']"))
	
	WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Language/Language Selected'), TargetLanguageTranslated)
	
	'Verify the header nav link text'
	WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Nav/Location Header Link'), LocationTranslated)
	WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Nav/Watch Header Link'), WatchTranslated)
	WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Nav/About Header Link'), AboutTranslated)
	WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Nav/Care Header Link'), CareTranslated)
	WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Nav/Give Header Link'), GiveTranslated)

} else {
	
	'Click Menu button'
	WebUI.click(findTestObject('Object Repository/Saddleback Web/Home/Nav/Menu Button'))
	
	WebUI.click(findTestObject('Object Repository/Saddleback Web/Home/Footer Nav/Language Selector'))
	
	WebUI.click(CustomKeywords.'TestObjectHelper.getTestObjectWithXpath'("//div[contains(@class, 'footer-language')]/div[@class='header-lang-select']//descendant::ul/li[text()='$TargetLanguageTranslated']"))
	
	WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Footer Nav/Language Selected'), TargetLanguageTranslated)
	
	'Verify the footer nav link text'
	WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Footer Nav/Location Footer Link'), LocationTranslated)
	WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Footer Nav/Watch Footer Link'), WatchTranslated)
	WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Footer Nav/About Footer Link'), AboutTranslated)
	WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Footer Nav/Care Footer Link'), CareTranslated)
	WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Footer Nav/Give Footer Link'), GiveTranslated)
}

WebUI.delay(3)

WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Actions/span_New to Saddleback'), NewToSaddlebackTranslated)

WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Actions/span_I want to follow Jesus'), FollowJesusTranslated)

WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Actions/span_I want to get baptized'), GetBaptizedTranslated)

WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Actions/span_I want to find community'), FindCommunityTranslated)

WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Actions/span_I want to start volunteering'), StartVolunteeringTranslated)

// This comparison works fine in all browsers except Safari. 
// Need to provide a case insensitive comparison to get this working.
WebUI.verifyElementText(findTestObject('Saddleback Web/Home/Latest Message Heading'), MessageHeadingTranslated)

'Verify the Watch Now button is present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Saddleback Web/Home/Watch Now Button'), 0)

'Verify the Watch Now button text'
WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Watch Now Button Text'), WatchNowTranslated)

'Switch back to English '
//If the Menu button is NOT displayed, use the Header navigation'
if (!CustomKeywords.'TestObjectHelper.isElementVisible'(findTestObject('Object Repository/Saddleback Web/Home/Nav/Menu Button'))) {
	
	// This logic is inconsistent in Safari (sometimes it works and sometimes it doesn't)
	WebUI.click(findTestObject('Saddleback Web/Home/Language/Language Selector'))
	
	WebUI.click(findTestObject('Saddleback Web/Home/Language/English Option'))
		
	WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Language/Language Selected'), 'English')

} else {
	
	'Click Menu button'
	WebUI.click(findTestObject('Object Repository/Saddleback Web/Home/Nav/Menu Button'))
	
	WebUI.click(findTestObject('Object Repository/Saddleback Web/Home/Footer Nav/Language Selector'))
	
	WebUI.click(findTestObject('Object Repository/Saddleback Web/Home/Footer Nav/English Option'))
	
	WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Footer Nav/Language Selected'), 'English')
}


WebUI.closeBrowser()


