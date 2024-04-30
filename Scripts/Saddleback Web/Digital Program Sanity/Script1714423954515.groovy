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
import org.openqa.selenium.WebElement

//https://saddleback.com/connect/digital-program
/*
 * 1. Open URL https://saddleback.com/connect/digital-program
 * 2. Select Campus
 * 3. Look at every button
 * 4. Tap each button
 * 5. Verify Event Button
 * 6. Verify Connection Form Button
 * 7. Verify What's Happening Button
 * 8. Click every link
 * 9. Verify the App Download link
*/
// Open the URL https://saddleback.com/connect/digital-program
WebUI.openBrowser('')

WebUI.navigateToUrl("$GlobalVariable.Saddleback_URL/connect/digital-program")

WebUI.click(findTestObject('Saddleback Legacy/Digital Program/Campus Selector By Name Match', [('textToMatch') : 'Lake Forest']))

WebUI.click(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Continue Button'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Digital Buttons'), 2)

// Click everyone of those buttons
List<WebElement> elements = WebUI.findWebElements(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Digital Buttons'), 0)

//for (int i = 0;  i < elements.size(); ++i) {
//	KeywordUtil.logInfo(i.toString())
//	KeywordUtil.logInfo(elements.get(i).toString())
//}

for (element in elements) {
	KeywordUtil.logInfo("Text: " + element.getText())
	KeywordUtil.logInfo("Href: " + element.getAttribute('href'))
}

List<String> hrefs =
elements.stream()
	.filter { we -> we.getAttribute('href') != null }
	.map { we -> we.getAttribute('href') }
	.collect()
	
// for the urls that are valid, check that the urls are valid and come back with a status 200
for (url in hrefs) {
	if (url != null && url.startsWith('http')) {
		KeywordUtil.logInfo("checking for status code on: ${url}")
		def statusCode = LinkTestUtils.getResponseStatus(url)
	
		WebUI.verifyEqual(statusCode, 200)
	}
}


//def statusCode = LinkTestUtils.getResponseStatus("$GlobalVariable.Saddleback_URL/connect/digital-program")
//
//WebUI.verifyEqual(statusCode, 200)
//
//statusCode = LinkTestUtils.getResponseStatus("$GlobalVariable.Saddleback_URL/connect/digital-program1")
//
//WebUI.verifyNotEqual(statusCode, 200)


