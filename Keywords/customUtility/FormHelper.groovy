package customUtility

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


public class FormHelper {
	@Keyword
	def TestObject getTextInputByLabel(String label) {
		def xpath = "//label[text()='$label']/following-sibling::input[@type='text']"
		KeywordUtil.logInfo("searching for xpath: " + xpath)
		return new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
	}

	/**
	 * Set value for Text field (single line) (e.g. input type="text" element)
	 */
	@Keyword
	def TestObject setTextfieldValue(String label, String value) {

		def field = getTextInputByLabel(label)
		WebUI.setText(field, value)
	}

	/**
	 * Set Date Field Value
	 */
	@Keyword
	def TestObject setDateFieldValue(String label, Date value) {

		def dateField = getTextInputByLabel(label)

		def dateToSelect = (new StringHelper()).getUSFormatDateForControl(value)

		WebUI.setText(dateField, dateToSelect)

		WebUI.sendKeys(dateField, Keys.chord(Keys.ENTER))
	}

	@Keyword
	def TestObject getTextAreaByLabel(String label) {
		def xpath = "//label[text()='$label']/following-sibling::div/textarea"
		KeywordUtil.logInfo("searching for xpath: " + xpath)
		return new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)
	}

	/**
	 * Set value for Text field (multi-line) (e.g. textarea element)
	 */
	@Keyword
	def TestObject setTextAreaValue(String id, String value) {

		def field = getTextAreaByLabel(id)
		WebUI.setText(field, value)
	}

	/**
	 * Set Radio button control (a.k.a multiple choice control)
	 */
	@Keyword
	def TestObject setMultipleChoiceControlValue(String controlLabel, String value) {

		def xpath = "//div[text()='$controlLabel' or . = '$controlLabel']/following-sibling::div/descendant::span[text() = '$value']/parent::label"

		def label = (new TestObjectHelper()).getTestObjectWithXpath(xpath)

		WebUI.click(label)
	}

	/**
	 * Set Radio button control (a.k.a multiple choice control)
	 */
	@Keyword
	def TestObject setMultipleChoiceControlValueByXPath(String xpathToRadioPill, String value) {

		def xpath = "$xpathToRadioPill/descendant::*[contains(text(),'$value')]"

		def label = (new TestObjectHelper()).getTestObjectWithXpath(xpath)

		WebUI.click(label)
	}

	/**
	 * Check item(s) in the group checkbox list
	 */
	@Keyword
	def TestObject setGroupCheckboxValue(String controlLabel, String values) {

		def valueList = (new StringHelper()).parseItemsWithDelimiter(values, ',')

		for (value in valueList) {
			def xpath = "//div[text()='$controlLabel' or . = '$controlLabel']/following-sibling::div/descendant::span[text() = '$value']/parent::label"

			def label =  (new TestObjectHelper()).getTestObjectWithXpath(xpath)

			WebUI.click(label)
		}
	}

	/**
	 * Set value for Drop Down component
	 */
	@Keyword
	def TestObject setDropDownValue(String label, String value) {

		def helper = new TestObjectHelper();

		def xpath = "//label[text() = '$label']/parent::div"

		def dropdown = helper.getTestObjectWithXpath(xpath)

		WebUI.click(dropdown)

		xpath = "//label[text() = '$label']/following-sibling::div/descendant::input"

		def dropdownInput = helper.getTestObjectWithXpath(xpath)

		// Type Dropdown value
		WebUI.sendKeys(dropdownInput, value)

		// Press <Enter> to select the value
		WebUI.sendKeys(dropdownInput, Keys.chord(Keys.ENTER))
	}

	/**
	 * Get value for Drop Down component
	 */
	@Keyword
	def String getDropDownSelectionByLabel(String label) {

		def helper = new TestObjectHelper()

		def xpath = "//label[text() = '$label']/parent::div/descendant::span[@class='Select-value-label']"

		def dropdownValueObject = helper.getTestObjectWithXpath(xpath)

		def dropDownValueSpan = WebUI.findWebElement(dropdownValueObject, 0)

		if (dropDownValueSpan) {
			return dropDownValueSpan.text
		}

		return null
	}

	@Keyword
	def String getRadioInputSelectionByLabel(String label) {
		def xpath = "//div[text()='$label' or . = '$label']/following-sibling::div[contains(@class, 'radio-is-checked')]/label/span"
		KeywordUtil.logInfo("searching for xpath: " + xpath)
		def input = new TestObject().addProperty('xpath', ConditionType.EQUALS, xpath)

		return WebUI.getAttribute(input, 'textContent')
	}

	@Keyword
	def String getCheckBoxSelectionByLabel(String label) {
		def xpath = "//div[text()='$label' or . = '$label']/following-sibling::div[contains(@class, 'checkbox-is-checked')]/label/span"

		def helper = new TestObjectHelper()

		// get a TestObject for the selected items
		def checkboxContainer = helper.getTestObjectWithXpath(xpath)

		// get web elements based on the TestObject
		List<WebElement> selectedItems = WebUI.findWebElements(checkboxContainer, 0)

		def selection = ""

		// get comma-separated list of text values from the options
		for (item in selectedItems) {
			if (selection.length() > 0)
				selection = selection + ","

			selection = selection + item.text
		}

		KeywordUtil.logInfo(selection)

		return selection
	}
}
