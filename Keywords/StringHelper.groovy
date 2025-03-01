
import java.text.SimpleDateFormat

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.Keys as Keys



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
	
	@Keyword
	def String getOperatingSystem() {
		def os = System.getProperty('os.name')
		
		println("os: $os")
		
		return os
	}
	
	@Keyword
	def String selectAllText() {
		return Keys.chord(getOsCommandControlKey() + 'a')
	}
	
	@Keyword
	def String getOsCommandControlKey() {
		switch (getOperatingSystem()) {
			case "Mac OS X":
				return Keys.COMMAND
				
			default:
				return Keys.CONTROL
		}
	}

	/**
	 * convert date string to Date value
	 * Args:
	 * 	argDateString - string containing date
	 * 	argDateFormatString - string containing format of date string
	 */
	@Keyword
	def Date getDateFromString(String argDateString, String argDateFormatString) {

		String tmpDateString = (argDateString).replaceAll(/(\d+)(st|nd|rd|th)/, '$1')

		tmpDateString = tmpDateString.trim()

		def firstMessageDate = Date.parse(argDateFormatString, tmpDateString)

		return firstMessageDate
	}
	
		
	/*
	 * convert time string to DateTime value
	 * Args:
	 * 	argTimeString - string containing time
	 * 	argTimeFormatString - string containing format of time string
	 */
	@Keyword
	def Date getTimeFromString(String argTimeString, String argTimeFormatString) {

		String tmpTimeString = argTimeString.trim()

		def messageTime = Date.parse(argTimeFormatString, tmpTimeString)

		return messageTime
	}
}