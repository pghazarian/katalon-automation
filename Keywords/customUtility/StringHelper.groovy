package customUtility
import java.text.SimpleDateFormat

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil



class StringHelper {
	@Keyword
	def List<String> parseItems(String values) {

		// This is hardcoded. If you want another delimiter,
		// call the other method: parseItemsWithDelimiter
		def delimiter = " ,;-"

		return parseItemsWithDelimiter(values, delimiter)
	}

	@Keyword
	def List<String> parseItemsWithDelimiter(String values, String delimiter) {

		KeywordUtil.logInfo("parsing string: ${values}")

		def list = values.tokenize(delimiter)

		KeywordUtil.logInfo("list size is ${list.size()}")

		for (item in list) {
			KeywordUtil.logInfo(item)
		}

		return list
	}

	/**
	 * Get formatted date string for given Date object
	 */
	@Keyword
	def String getUSFormatDateForControl(Date date) {

		def sdf = new SimpleDateFormat('MM/dd/yyyy')

		return sdf.format(date)
	}
}