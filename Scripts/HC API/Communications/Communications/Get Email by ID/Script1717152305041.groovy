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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def date = new Date()

def CurrentDateTime = CustomKeywords.'StringHelper.getIsoFormatDate'(date)

def CommName = "ST Communication - $CurrentDateTime"

WebUI.callTestCase(findTestCase('HC-Web/Shared/Validate Safe Environment'), [:], FailureHandling.STOP_ON_FAILURE)

postResponse = WS.sendRequest(findTestObject('HC API/Communications/Communications/Post Email', [('CommunicationName') : "$CommName"]))

def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(postResponse.getResponseBodyContent())

def value = result.id

println(value)

GlobalVariable.CommunicationID = value

println(GlobalVariable.CommunicationID)

getResponse = WS.sendRequestAndVerify(findTestObject('HC API/Communications/Communications/Get Email by ID', [('CommunicationID') : GlobalVariable.CommunicationID
            , ('JobType') : 'Email']))

WS.verifyElementPropertyValue(getResponse, 'id', value)

