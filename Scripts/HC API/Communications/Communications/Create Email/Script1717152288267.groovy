import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.assertj.core.api.Assertions as Assertions
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonSlurper as JsonSlurper

def date = new Date()

def CurrentDateTime = CustomKeywords.'StringHelper.getIsoFormatDate'(date)

def CommName = "ST Communication - $CurrentDateTime"

WebUI.callTestCase(findTestCase('HC-Web/Shared/Validate Safe Environment'), [:], FailureHandling.STOP_ON_FAILURE)

response = WS.sendRequest(findTestObject('HC API/Communications/Communications/Post Email', [('CommunicationName') : "$CommName"]))

// Validate the response was successful (HTTP Code 200 == Status)
WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, 'jobType', 0)

WS.verifyElementPropertyValue(response, 'audienceType', 'Segment')

WS.verifyElementPropertyValue(response, 'name', null)

WS.verifyElementPropertyValue(response, 'description', null)

WS.verifyElementPropertyValue(response, 'sendEmail', null)
