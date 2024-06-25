import internal.GlobalVariable as GlobalVariable
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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.configuration.RunConfiguration

WebUI.verifyEqual("HC-Production", RunConfiguration.getExecutionProfile())

def timeout = 10
	
WebUI.callTestCase(findTestCase('Saddleback Web/Login'), [('HostUrl') : GlobalVariable.Saddleback_URL, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password, ('TargetPath') : '/connect/digital-program'], FailureHandling.STOP_ON_FAILURE)

// This campus list is hardcoded since the pulling of the Campus Names from the UI does not work
// (Tech details: the pulling of the Campus Name strings results in an ALL CAPs version of the string,
//  which I cannot use for matching on the UI)	
List<String> locations = [
    57 //'Saddleback en Español',
    , 10 //'Anaheim',
    , 59 //'Brea',
    , 20 //'Buenos Aires',
    , 3 //'Eastvale',
    , 22 //'Hong Kong',
    , 30 //'Irvine North',
    , 4 //'Irvine South',
    , 6 //'Laguna Woods',
    , 1 //'Lake Forest'
    , 29 //'Los Angeles',
    , 9 //'Newport Mesa',
    , 5 //'Online Community',
    , 8 //'Rancho Capistrano',
    , 2 //'San Clemente',
    , 56 //'San Diego',
    , 25 //'Santa Rosa',
    , 31 //'South Bay',
    , 63 //'Vancouver',
    , 62 //'Whittier'
]

WebUI.delay(2)

for (def campusLocation : locations) {
    KeywordUtil.logInfo('processing location: ' + campusLocation)

    WebUI.navigateToUrl("$GlobalVariable.Saddleback_URL/connect/digital-program?campusid=$campusLocation")

    WebUI.waitForElementPresent(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Digital Buttons'), 2)

    def digitalProgramByLocationUrl = WebUI.getUrl()

    KeywordUtil.logInfo("validating program by location at: $digitalProgramByLocationUrl")

    // Click every button
    List<String> digitalButtons = WebUI.findWebElements(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Digital Buttons'), 
        timeout)

    for (int index = 0; index < digitalButtons.size(); index++) {
        digitalButtons = WebUI.findWebElements(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Digital Buttons'), 
            10)

        def digitalButton = digitalButtons.get(index)

        def buttonText = digitalButton.getText().toLowerCase().trim()

        def buttonTarget = digitalButton.getAttribute('href')

        if ((buttonText != null) && !(buttonText.empty)) {
            KeywordUtil.logInfo("processing button: $buttonText")

            switch (buttonText) {
                case 'check-in':
                    // click on the check in button
                    digitalButton.click()

                    // verify that the Campus is displayed on the form in the header
                    def url = WebUI.getUrl()

                    WebUI.verifyEqual(url.contains('/public/connection-form'), true)

                    // Look for the ?t= append for the connection-form links so that the authenticated user token is passed around
                    WebUI.verifyEqual(url.contains('?t=ey'), true)
					
                    WebUI.delay(2)

                    // verify that the fields are present (FirstName, LastName and Submit button)					
                    CustomKeywords.'TestObjectHelper.verifyTextFieldHasValue'(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Check In Form/First Name Text Field'))

                    CustomKeywords.'TestObjectHelper.verifyTextFieldHasValue'(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Check In Form/Last Name Text Field'))

                    WebUI.verifyElementVisible(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Check In Form/Submit Button'))

                    // click Cancel and get back to the Digital program
                    WebUI.scrollToElement(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Check In Form/Cancel Button'), 
                        0)

                    WebUI.click(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Check In Form/Cancel Button'))

                    break
                case 'notes':
                    digitalButton.click()

                    WebUI.waitForElementVisible(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Notes/Notes Popup'), 
                        timeout)

                    WebUI.verifyElementVisible(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Notes/Header'))

                    def pdfLinkElement = WebUI.findWebElement(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Notes/PDF link'), 
                        timeout)

                    def pdfLink = pdfLinkElement.getAttribute('href')

                    WebUI.verifyEqual(!(pdfLink.empty), true)

                    WebUI.click(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Notes/Close Button'))

                    break
                case 'give':
                    digitalButton.click()

                    WebUI.verifyElementPresent(findTestObject('Object Repository/Saddleback Legacy/Giving Form/Giving Container'), 
                        5)

                    CustomKeywords.'TestObjectHelper.verifyTextFieldHasValue'(findTestObject('Object Repository/Saddleback Legacy/Giving Form/First Name Textfield'))

                    CustomKeywords.'TestObjectHelper.verifyTextFieldHasValue'(findTestObject('Object Repository/Saddleback Legacy/Giving Form/Last Name Textfield'))

                    WebUI.verifyElementPresent(findTestObject('Object Repository/Saddleback Legacy/Giving Form/Submit Gift Button'), 
                        timeout)

                    WebUI.back()

                    break
                case 'what\'s happening':
                    def announcementButton = digitalButton

                    // click Cancel and get back to the Digital program
                    announcementButton.click()

                    // look at the announcements				
                    List<String> announcementLinks = WebUI.findWebElements(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Announcements/Announcement Links'), 
                        timeout)

                    int announcementCount = announcementLinks.size()

                    for (int i = 0; i < announcementCount; i++) {
                        announcementLinks = WebUI.findWebElements(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Announcements/Announcement Links'), 
                            timeout)

                        announcementLink = announcementLinks.get(i)

                        def linkText = announcementLink.getText().toLowerCase().trim()

                        def linkTarget = announcementLink.getAttribute('href')

                        KeywordUtil.logInfo("go to announcement: $linkTarget")

                        if (!(linkTarget.contains('zoom')) && !(linkTarget.contains('instagram'))) {
                            announcementLink.click()

                            //WebUI.verifyTextPresent(campusLocation, false, FailureHandling.CONTINUE_ON_FAILURE)
                            WebUI.back()
                        }
                        
                        if ((linkTarget != null) && linkTarget.startsWith('http')) {
                            KeywordUtil.logInfo("checking for status code on: $linkTarget")

                            def statusCode = LinkTestUtils.getResponseStatus(linkTarget)

                            if (statusCode == '200') {
                                KeywordUtil.logInfo("Http Status $statusCode: $linkTarget for campus, $campusLocation, button: $linkText")
                            } else if ((statusCode == '301') || (statusCode == '302')) {
                                KeywordUtil.logInfo("Warning: Http Status $statusCode: $linkTarget for campus, $campusLocation, button: $linkText")
                            } else {
                                KeywordUtil.markError("Error: Http Status $statusCode: $linkTarget for campus, $campusLocation, button: $linkText")
                            }
                        }
                        
                        if (CustomKeywords.'TestObjectHelper.isElementVisible'(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Announcements/Announcement Header'))) {
                            // do nothing
                        } else {
                            WebUI.waitForElementVisible(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Announcement Button'), 
                                timeout)

                            WebUI.click(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Announcement Button'))
                        }
                    }
                    
                    WebUI.click(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Announcements/Back Button'))

                    break
                // For buttons that lead to a URL external from this page
                default:
                    if ((buttonTarget != null) && buttonTarget.startsWith('http')) {
                        KeywordUtil.logInfo("processing button: $buttonText ($buttonTarget)")

                        // click button
                        digitalButton.click()

                        def url = WebUI.getUrl()

                        // inspect URL
                        if (url.contains('/public/connection-form/')) {
                            // Look for the ?t= append for the connection-form links so that the authenticated user token is passed around
                            WebUI.verifyEqual(url.contains('?t=ey'), true)
							
                            WebUI.delay(2)

                            // verify that the fields are present (FirstName, LastName and Submit button)
                            CustomKeywords.'TestObjectHelper.verifyTextFieldHasValue'(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Check In Form/First Name Text Field'))

                            CustomKeywords.'TestObjectHelper.verifyTextFieldHasValue'(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Check In Form/Last Name Text Field'))

                            WebUI.verifyElementVisible(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Check In Form/Submit Button'))

                            WebUI.scrollToElement(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Check In Form/Cancel Button'), 
                                0)

                            // click Cancel and get back to the Digital program
                            WebUI.click(findTestObject('Object Repository/Saddleback Legacy/Digital Program/Check In Form/Cancel Button'))
                        } else if (url.contains('saddleback.com/event/')) {
                            digitalButton.click()

                            WebUI.back()
                        } else {
                            digitalButton.click()

                            WebUI.back()
                        }
                        // do nothing
                    } else {
                        KeywordUtil.logInfo("processing button: $buttonText which has no URL target")
                    }
                    
                    break
            }
        }
    }
    
    WebUI.navigateToUrl("$GlobalVariable.Saddleback_URL/connect/digital-program")
}