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

def campusLocation = 'Lake Forest'

WebUI.openBrowser('')

WebUI.navigateToUrl("$GlobalVariable.Saddleback_URL/connect/digital-program")

WebUI.click(findTestObject('Saddleback Legacy/Digital Program/Campus Selector By Name Match', [('textToMatch') : campusLocation]))

WebUI.click(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Continue Button'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Digital Buttons'), 2)

def digitalProgramByLocationUrl = WebUI.getUrl() 

KeywordUtil.logInfo("validating program by location at: ${digitalProgramByLocationUrl}")

// Click every button
List<WebElement> digitalButtons = WebUI.findWebElements(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Digital Buttons'), 0)

for (int index = 0; index < digitalButtons.size(); index++) {
	
	digitalButtons = WebUI.findWebElements(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Digital Buttons'), 0)
	def digitalButton = digitalButtons.get(index)
	def buttonText = digitalButton.getText().toLowerCase().trim()
	def buttonTarget = digitalButton.getAttribute('href')

	if (buttonText != null && !buttonText.empty) {
		KeywordUtil.logInfo("processing button: ${buttonText}")
		
		switch (buttonText) {
			case "check-in":
				// click on the check in button
				digitalButton.click()
				
				// verify that the Campus is displayed on the form in the header
				WebUI.waitForElementPresent(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Check In Form Header By Campus Match', [('textToMatch') : campusLocation]), 3, FailureHandling.CONTINUE_ON_FAILURE)
				
				def url = WebUI.getUrl()
				WebUI.verifyEqual(url.contains("/public/connection-form"), true)
				
				// verify that the fields are present (FirstName, LastName and Submit button)
				WebUI.verifyElementVisible(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Check In Form/First Name Text Field'))
				WebUI.verifyElementVisible(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Check In Form/Last Name Text Field'))
				WebUI.verifyElementVisible(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Check In Form/Submit Button'))
				
				// click Cancel and get back to the Digital program
				WebUI.click(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Check In Form/Cancel Button'))
				break
				
			case "notes":
			
				digitalButton.click()
				
				WebUI.waitForElementVisible(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Notes/Notes Popup'), 0)
				WebUI.verifyElementVisible(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Notes/Header'))
				
				def pdfLinkElement = WebUI.findWebElement(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Notes/PDF link'), 0)
				def pdfLink = pdfLinkElement.getAttribute("href")
				
				WebUI.verifyEqual(!pdfLink.empty, true)
		
				WebUI.click(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Notes/Close Button'))
				
				break
				
			case "give":
				
				digitalButton.click()
				
				WebUI.verifyElementPresent(findTestObject('Object Repository/Saddleback Legacy/Giving Form/Giving Container'), 5)
				
				WebUI.verifyElementPresent(findTestObject('Object Repository/Saddleback Legacy/Giving Form/First Name Textfield'), 0)
				WebUI.verifyElementPresent(findTestObject('Object Repository/Saddleback Legacy/Giving Form/Last Name Textfield'), 0)
				
				WebUI.verifyElementPresent(findTestObject('Object Repository/Saddleback Legacy/Giving Form/Submit Gift Button'), 0)
				
				WebUI.back()
				
				break
				
			case "what's happening":
				def announcementButton = digitalButton;
				
				// click Cancel and get back to the Digital program
				announcementButton.click()
				
				// look at the announcements				
				List<WebElement> announcementLinks = WebUI.findWebElements(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Announcements/Announcement Links'), 0)
				
				int announcementCount = announcementLinks.size()
				
				for (int i = 0; i < announcementCount; i++) {
					announcementLinks = WebUI.findWebElements(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Announcements/Announcement Links'), 0)
					
					announcementLink = announcementLinks.get(i)

					def linkText = announcementLink.getText().toLowerCase().trim()
					def linkTarget = announcementLink.getAttribute('href')
					
					KeywordUtil.logInfo("go to announcement: ${linkTarget}")
					
					announcementLink.click()
					WebUI.delay(2)
					def announcementUrl = WebUI.getUrl()
					WebUI.verifyTextPresent(campusLocation, false, FailureHandling.CONTINUE_ON_FAILURE)
					
					WebUI.back()
					
					if (CustomKeywords.'TestObjectHelper.isElementVisible'(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Announcements/Announcement Header'))) {
						// do nothing
					}
					else
					{
						WebUI.waitForElementVisible(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Announcement Button'), 0)
						WebUI.click(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Announcement Button'))
					}
				}
				
				WebUI.click(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Announcements/Back Button'))
				break
				
			default:
				
				// For buttons that lead to a URL external from this page
				if (buttonTarget != null && buttonTarget.startsWith('http'))
				{
					KeywordUtil.logInfo("processing button: ${buttonText} (${buttonTarget})")
					
					// click button
					digitalButton.click()
				
					def url = WebUI.getUrl()
					// inspect URL
					
					if (url.contains("/public/connection-form/")) {
						
						// verify that the fields are present (FirstName, LastName and Submit button)
						WebUI.verifyElementVisible(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Check In Form/First Name Text Field'))
						WebUI.verifyElementVisible(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Check In Form/Last Name Text Field'))
						WebUI.verifyElementVisible(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Check In Form/Submit Button'))
						
						// click Cancel and get back to the Digital program
						WebUI.click(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Check In Form/Cancel Button'))
						
					} else if (url.contains("saddleback.com/event/")) {
						
						WebUI.back()
						
					}
					
					else {
						
						WebUI.back()
						
					}
				} else {
					
					// do nothing
					KeywordUtil.logInfo("processing button: ${buttonText} which has no URL target")
					
				}
			
				break
		}
	}
}

List<String> hrefs =
digitalButtons.stream()
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
	

