package customUtility

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.Keys as Keys

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import java.text.SimpleDateFormat
import java.util.Date

class TestObjectHelper {
	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Get a TestObject given a xpath
	 */
	@Keyword
	def TestObject getTestObjectWithXpath(String xpath) {
		KeywordUtil.logInfo("searching for xpath: " + xpath)
		return new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Get a TestObject given a xpath, text string to match, and the index for which one to get
	 */
	@Keyword
	def TestObject getTestObjectWithXpathTextMatch(String xpath, String textToMatch, int index = 1) {
		xpath = "($xpath[text() = \"$textToMatch\" or normalize-space(.) = \"$textToMatch\"])[$index]"
		KeywordUtil.logInfo("searching for xpath: " + xpath)
		return new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
	}

	/**
	 * Get a TestObject input element by ID
	 */
	@Keyword
	def TestObject getInputById(String id) {
		def xpath = "//input[@id='${id}']"
		KeywordUtil.logInfo("searching for xpath: " + xpath)
		return new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
	}

	@Keyword
	def TestObject getTextInputByLabel(String label) {
		def xpath = "//h3[text()='${label}' or . = '${label}']/following-sibling::div/descendant::input[@type='text']"
		KeywordUtil.logInfo("searching for xpath: " + xpath)
		return new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
	}

	//h3[text()='Multiple Choice' or . = 'Multiple Choice']/following-sibling::div/descendant::input/parent::div[contains(@class, 'radio-is-checked')]/descendant::label/span

	@Keyword
	def TestObject getRadioInputSelectionByLabel(String label) {
		def xpath = "//h3[text()='${label}' or . = '${label}']/following-sibling::div/descendant::input[@type='text']"
		KeywordUtil.logInfo("searching for xpath: " + xpath)
		def input = new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
		return input.properties["innerText"]
	}

	/**
	 * Get a TestObject textarea element by ID
	 */
	@Keyword
	def TestObject getTextAreaById(String id) {
		def xpath = "//textarea[@id='${id}']"
		KeywordUtil.logInfo("searching for xpath: " + xpath)
		return new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
	}

	@Keyword
	def TestObject getTextAreaByLabel(String label) {
		def xpath = "//h3[text()='${label}' or . = '${label}']/following-sibling::div/descendant::textarea]"
		KeywordUtil.logInfo("searching for xpath: " + xpath)
		return new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
	}

	/**
	 * Set value for Text field (single line) (e.g. input type="text" element)
	 */
	@Keyword
	def TestObject setTextfieldValue(String id, String value) {

		def field = getInputById(id)
		WebUI.setText(field, value)
	}

	/**
	 * Set value for Text field (multi-line) (e.g. textarea element)
	 */
	@Keyword
	def TestObject setMultilineTextfieldValue(String id, String value) {

		def field = getTextAreaById(id)
		WebUI.setText(field, value)
	}

	/**
	 * Set value for Drop Down component
	 */
	@Keyword
	def TestObject setDropDownValue(String id, String value) {

		def xpath = "//div[@id='${id}']"

		def dropdown = getTestObjectWithXpath(xpath)

		WebUI.click(dropdown)

		xpath = xpath + "/descendant::input"

		def dropdownInput = getTestObjectWithXpath(xpath)

		// Type Dropdown value
		WebUI.sendKeys(dropdownInput, value)

		// Press <Enter> to select the value
		WebUI.sendKeys(dropdownInput, Keys.chord(Keys.ENTER))
	}

	/**
	 * Set value for Drop Down component
	 */
	@Keyword
	def TestObject setDropDownValueByXPath(String xpath, String value) {

		def dropdown = getTestObjectWithXpath(xpath)

		WebUI.click(dropdown)

		xpath = xpath + "/descendant::input"

		def dropdownInput = getTestObjectWithXpath(xpath)

		// Type Dropdown value
		WebUI.sendKeys(dropdownInput, value)

		// Press <Enter> to select the value
		WebUI.sendKeys(dropdownInput, Keys.chord(Keys.ENTER))
	}

	/**
	 * Set Radio button control (a.k.a multiple choice control)
	 */
	@Keyword
	def TestObject setMultipleChoiceControlValue(String controlLabel, String value) {

		def xpath = "//h3[text()='$controlLabel']/following-sibling::div/descendant::span[text() = '$value']/parent::label"

		def label = getTestObjectWithXpath(xpath)

		WebUI.click(label)
	}

	/**
	 * Check item(s) in the group checkbox list
	 */
	@Keyword
	def TestObject setGroupCheckboxValue(String controlLabel, String values) {

		def valueList = (new StringHelper()).parseItems(values)

		for (value in valueList) {
			def xpath = "//h3[text()='$controlLabel']/following-sibling::div/descendant::span[text() = '$value']/parent::label"

			def label = getTestObjectWithXpath(xpath)

			WebUI.click(label)
		}
	}

	/**
	 * Set Date Field Value
	 */
	@Keyword
	def TestObject setDateFieldValue(String id, Date value) {

		def xpath = "//div[@id='${id}']/descendant::input"

		def dateField = getTestObjectWithXpath(xpath)

		def dateToSelect = (new StringHelper()).getUSFormatDateForControl(value)

		WebUI.setText(dateField, dateToSelect)

		WebUI.sendKeys(dateField, Keys.chord(Keys.ENTER))
	}

	@Keyword
	def verifyTextFieldValueEqual(TestObject object, String valueToCompare) {

		// get the value attribute from the text field
		def value = WebUI.getAttribute(object, 'value')

		// verify the field value'
		WebUI.verifyEqual(value, valueToCompare)
	}

	@Keyword
	def verifyLabelValueEqual(TestObject object, String valueToCompare) {

		// get the value attribute from the text field
		def webElement = WebUI.findWebElement(object, 1)

		// verify the field value'
		WebUI.verifyEqual(webElement.text, valueToCompare)
	}

	@Keyword
	def String getWebElementText(TestObject object, String valueToCompare) {

		// get the text attribute from the label / span field
		def webElement = WebUI.findWebElement(object, 1)

		if (webElement)
			return webElement.text

		return null
	}

	@Keyword
	def verifyTextAreaValueEqual(TestObject object, String valueToCompare) {

		// get the value attribute from the textarea
		def value = WebUI.getAttribute(object, 'value')

		// verify the field value'
		WebUI.verifyEqual(value, valueToCompare)
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUI.findWebElement(to, 0);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUI.findWebElement(table, 0)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}

	/**
	 * Check if element present in timeout
	 * @param to Katalon test object
	 * @param timeout time to wait for element to show up
	 * @return true if element present, otherwise false
	 */
	@Keyword
	def isElementPresent_Mobile(TestObject to, int timeout){
		try {
			KeywordUtil.logInfo("Finding element with id:" + to.getObjectId())

			WebElement element = MobileElementCommonHelper.findElement(to, timeout)
			if (element != null) {
				KeywordUtil.markPassed("Object " + to.getObjectId() + " is present")
			}
			return true
		} catch (Exception e) {
			KeywordUtil.markFailed("Object " + to.getObjectId() + " is not present")
		}
		return false;
	}

	@Keyword
	def isElementPresent(TestObject to, int timeout) {

		try {
			KeywordUtil.logInfo("Finding element with id:" + to.getObjectId())

			WebElement element = WebUI.findWebElement(to, timeout)
			if (element != null) {
				KeywordUtil.markPassed("Object " + to.getObjectId() + " is present")
			}
			return true
		} catch (Exception e) {
		}
		return false;
	}

	@Keyword
	def isElementVisible(TestObject to) {

		try {
			KeywordUtil.logInfo("Finding element with id:" + to.getObjectId())

			if (WebUI.verifyElementVisible(to, FailureHandling.OPTIONAL)) {
				return true
			}
			else {
				return false
			}
		} catch (Exception e) {
			KeywordUtil.logInfo("Error thrown when trying to determine visibility")
		}
		return false;
	}
}