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
	 * Get U.S. formatted date string for given Date object
	 */
	@Keyword
	def String getUSFormatDateForControl(Date date) {

		def sdf = new SimpleDateFormat('MM/dd/yyyy')

		return sdf.format(date)
	}

	/**
	 * Get ISO formatted date string for given Date object
	 */
	@Keyword
	def String getIsoFormatDate(Date date) {

		def sdf = new SimpleDateFormat('yyyy-MM-dd HH:mm:ss')

		return sdf.format(date)
	}
	
	/*
	 * """Parses a version string like "1.80.0-dev-gccab4e1.20240312.15" and returns the major and minor versions (e.g. "1.80").

  Args:
    version_str: The version string to parse.

  Returns:
    The major and minor versions as a string (e.g. "1.80").
  """
	  
	 */
	@Keyword
	def String parseMajorMinorVersion(version_str) {
	
		// Split the version string based on "." delimiter
		def parts = version_str.split(/\./)
	  
		// Ensure at least two parts are present (major and minor version)
		if (parts.size() < 2) {
		  return null
		}
	  
		// Extract and combine major and minor versions
		return parts[0..1].join('.')
	  }
}