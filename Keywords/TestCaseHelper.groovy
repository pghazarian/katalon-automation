
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory


class TestCaseHelper {
	final PRODUCTION_PROFILE = "HC-Production";
	final PRODUCTION_TAG = "Production";

	@Keyword
	def Boolean isBrowserOpen() {
		try {
			def x = DriverFactory.getCurrentWindowIndex()
			if ( x != null && x >= 0 ) {
				// “Browser is open…”
				KeywordUtil.logInfo("Browser is open")
				return true
			}

			KeywordUtil.logInfo("Browser is not open from try block")
			return false
		}
		catch ( Exception e ) {
			KeywordUtil.logInfo("Browser is not open (from catch block)")
			return false
			// “Browser is NOT open…”
		}

		KeywordUtil.logInfo("Browser is not open (end of function(")
		return false;
	}

	def TestCase getTestCaseObject() {

		def testCaseId = getCurrentlyRunningTestCaseId()

		return getTestCase(testCaseId)
	}

	@Keyword
	def Boolean isCurrentTestCaseEnvironmentValid() {

		final PRODUCTION_PROFILE = "HC-Production";
		final PRODUCTION_TAG = "Production";

		def executionProfile = RunConfiguration.getExecutionProfile()

		KeywordUtil.logInfo("Currently running profile: $executionProfile")

		if (executionProfile != PRODUCTION_PROFILE) {
			KeywordUtil.markPassed("Executing Profile is not HC-Production ($executionProfile). Test Case may proceed.")
			assert true
			return true
		}

		if (isTestSuite()) {
			KeywordUtil.markPassed("This is a test suite file. Proceed.")
			return true
		}

		def testCase = getTestCaseObject()

		def tags = testCase.tag.split(",")

		def hasProductionTag = tags.contains(PRODUCTION_TAG)

		KeywordUtil.logInfo("hasProductionTag: $hasProductionTag")

		if (hasProductionTag) {
			KeywordUtil.markPassed("Executing Profile is $executionProfile and the $PRODUCTION_TAG tag is present in the test case properties tab. Test Case may proceed.")
			assert true
			return true
		}
		else {
			KeywordUtil.markFailed("Executing Profile is $executionProfile and the $PRODUCTION_TAG tag is not present in the test case properties tab. Test Case may NOT proceed.")
			assert false
			return false
		}
	}

	def TestCase getTestCase(id) {

		def testCaseInfo = (new TestCaseFactory()).findTestCase(id)

		println("$testCaseInfo.name")
		println("$testCaseInfo.description")
		println("$testCaseInfo.tag")

		return testCaseInfo
	}

	def getCurrentlyRunningTestCaseId() {

		def source = RunConfiguration.getExecutionSource()

		KeywordUtil.logInfo("RunConfiguration.getExecutionSource(): ${source}")

		// parse out the full path into the test case id

		// For Example:
		// from
		//		/Users/crisfrancisco/Documents/GitHub/katalon-automation/Test Cases/HC-Web/Shared/Is Environment Valid.tc
		// to
		//		Test Cases/HC-Web/Shared/Is Environment Valid

		def startPos = 0
		def parsed = ""

		// test cases
		if (source.indexOf("Test Cases/") > 0) {

			startPos = source.indexOf("Test Cases/")

			parsed = source.substring(startPos, source.size() - '.tc'.size())

			KeywordUtil.logInfo("parsed test case id: ${parsed}")
		}

		return parsed;
	}

	def Boolean isTestSuite() {

		def source = RunConfiguration.getExecutionSource()

		KeywordUtil.logInfo("RunConfiguration.getExecutionSource(): ${source}")

		return source.indexOf("Test Suites/") > 0
	}
}