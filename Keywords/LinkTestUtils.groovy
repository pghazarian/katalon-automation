import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject

public class LinkTestUtils {
	
		static int findBrokenLinks(List<String> urls, Appendable messageBuffer) {
			Objects.requireNonNull(urls)
			Objects.requireNonNull(messageBuffer)
			int count = 0
			for (url in urls) {
				//WS.comment("${url}")
				String statusCode = LinkTestUtils.getResponseStatus(url)
				messageBuffer.append("${statusCode} <a href=${url}>${System.lineSeparator}")
				// check if this link is broken
				switch(statusCode) {
					case '200':
					case '301':
					case '302':
						break
					case '???':
						++count   // should regard this as broken? up to you.
					default:
						++count
				}
			}
			messageBuffer.append("Broken/All: ${count}/${urls.size()}${System.lineSeparator}")
			return count
		}
	
		/**
		 * try to make HTTP GET for this url and return the HTTP Status Code of the response
		 * @param url
		 * @return
		 */
		static String getResponseStatus(String url) {
			String status = '???'
			if (url != null && url.startsWith('http')) {
				RequestObject req = new RequestObject('check if this url is reachable')
				req.setServiceType('REST')
				req.setRestUrl(url)
				req.setRestRequestMethod('GET')
				// Send the request and get the response
				ResponseObject res = WS.sendRequest(req)
				status = res.getStatusCode()  // '200' OK, '302' redirected, '403' etc
			}
			return status
		}
	}