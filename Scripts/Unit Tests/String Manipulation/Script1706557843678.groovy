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

//def values = "1, 2, 3"

values = 'a, b - c; d,  e,f'

def list = CustomKeywords.'StringHelper.parseItems'(values)

assert list.size() == 6
assert list.get(0) == 'a'
assert list.get(1) == 'b'
assert list.get(2) == 'c'
assert list.get(3) == 'd'
assert list.get(4) == 'e'
assert list.get(5) == 'f'

values = 'Cris Francisco,Mark Hamilton,Garrett Clover'

list = CustomKeywords.'StringHelper.parseItemsWithDelimiter'(values, ',')

assert list.size() == 3
assert list.get(0) == 'Cris Francisco'
assert list.get(1) == 'Mark Hamilton'
assert list.get(2) == 'Garrett Clover'
