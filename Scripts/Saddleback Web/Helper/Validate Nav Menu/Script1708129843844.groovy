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
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebDriver driver = DriverFactory.getWebDriver();    // here is **driver** defined

initial_size = driver.manage().window().getSize();
height = initial_size.getHeight();
width = initial_size.getWidth();

KeywordUtil.logInfo("Width & height: ${width.toString()}x${height.toString()}")

final WIDTH_BREAKPOINT = 1024

// if the Width is greater than or equal to the break point, 
// verify that the navigation header is present
if (width >= WIDTH_BREAKPOINT) {

	'Verify the text for Locations link'
	WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Nav/Location Header Link'), 'Locations')
	
	'Verify the text for Watch link'
	WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Nav/Watch Header Link'), 'Watch')
	
	'Verify the text for About link'
	WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Nav/About Header Link'), 'About')
	
	'Verify the text for Care link'
	WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Nav/Care Header Link'), 'Care')
	
	'Verify the text for Give link'
	WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Nav/Give Header Link'), 'Give')
	
	'Verify the text for Language'
	WebUI.verifyElementPresent(findTestObject('Object Repository/Saddleback Web/Home/Language Label'), 0)
	
	WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Language Label'), 'Language')

}

else {
	
	// if the Width is less than the break point,
	// 1) verify that the navigation header is not present
	
	'Verify the text for Locations link'
	WebUI.verifyElementNotVisible(findTestObject('Object Repository/Saddleback Web/Home/Nav/Location Header Link'))
	
	'Verify the text for Watch link'
	WebUI.verifyElementNotVisible(findTestObject('Object Repository/Saddleback Web/Home/Nav/Watch Header Link'))
	
	'Verify the text for About link'
	WebUI.verifyElementNotVisible(findTestObject('Object Repository/Saddleback Web/Home/Nav/About Header Link'))
	
	'Verify the text for Care link'
	WebUI.verifyElementNotVisible(findTestObject('Object Repository/Saddleback Web/Home/Nav/Care Header Link'))
	
	'Verify the text for Give link'
	WebUI.verifyElementNotVisible(findTestObject('Object Repository/Saddleback Web/Home/Nav/Give Header Link'))
	
	'Verify the text for Language'
	WebUI.verifyElementNotVisible(findTestObject('Object Repository/Saddleback Web/Home/Language Label'))
	
	
	'Click Menu button'
	WebUI.click(findTestObject('Object Repository/Saddleback Web/Home/Nav/Menu Button'))
	
	// 2) verify that the navigation footer is present
	
	'Verify the text for Locations link'
	WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Footer Nav/Location Footer link'), 'Locations')
	
	'Verify the text for Watch link'
	WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Footer Nav/Watch Footer Link'), 'Watch')
	
	'Verify the text for About link'
	WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Footer Nav/About Footer Link'), 'About')
	
	'Verify the text for Care link'
	WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Footer Nav/Care Footer Link'), 'Care')
	
	'Verify the text for Give link'
	WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Footer Nav/Give Footer Link'), 'Give')
	
	'Verify the text for Language'
	WebUI.verifyElementText(findTestObject('Object Repository/Saddleback Web/Home/Footer Nav/Language Label'), 'Language')

}