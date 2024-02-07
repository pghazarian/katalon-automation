package customUtility
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable as GlobalVariable


class TestCaseHelper {
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

		def isProductionApproved = tags.contains(PRODUCTION_TAG) || testCase.name.indexOf("Production")

		KeywordUtil.logInfo("isProductionApproved: $isProductionApproved")

		if (isProductionApproved) {
			KeywordUtil.markPassed("Executing Profile is $executionProfile and this test case/suite case is approved for Production. Test Case may proceed.")
			assert true
			return true
		}
		else {
			KeywordUtil.markFailed("Executing Profile is $executionProfile and this test case/suite case is approved for Production. Test Case may NOT proceed.")
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