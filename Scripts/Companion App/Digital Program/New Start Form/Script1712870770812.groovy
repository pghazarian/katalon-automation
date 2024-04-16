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

import groovy.swing.factory.ButtonGroupFactory
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import com.detroitlabs.katalonmobileutil.device.App
import com.detroitlabs.katalonmobileutil.device.Device
import com.detroitlabs.katalonmobileutil.testobject.Finder
import com.detroitlabs.katalonmobileutil.testobject.Button
import com.detroitlabs.katalonmobileutil.testobject.TextField
import com.detroitlabs.katalonmobileutil.touch.Scroll

def timeout = 3
def FirstName = 'Cris'
def LastName = 'Francisco'
def Email = 'crisf@saddleback.com'
def Phone = '9495258002'

'Open existing app by the app bundle id'
Mobile.callTestCase(findTestCase('Companion App/Shared/Login'), [:], FailureHandling.STOP_ON_FAILURE)

Button.tap('Digital Program/Go to Digital Program')

Mobile.delay(timeout)

Button.tap('Digital Program/New Start')
	
Button.tap('Digital Program/New Start Form/Select Location')

Button.tap('Digital Program/New Start Form/Campus Lake Forest')

//findTestObject('Object Repository/Companion App/iOS/Buttons/Digital Program/New Start Form/Campus By Name Match')

'Find the First Name field'
TestObject firstName = Finder.findTextField('Digital Program/New Start Form/First Name')

Mobile.tap(firstName, timeout)

'Enter value in the First Name field'
TextField.typeText(firstName, FirstName, timeout)

'Find the Last Name field'
TestObject lastName = Finder.findTextField('Digital Program/New Start Form/Last Name')

Mobile.tap(lastName, timeout)

'Enter value in the Last Name field'
TextField.typeText(lastName, FirstName, timeout)

'Find the Email field'
TestObject email = Finder.findTextField('Digital Program/New Start Form/Email')

Mobile.tap(email, timeout)

'Enter value in the Email field'
TextField.typeText(email, Email, timeout)

Scroll.scrollListToElementWithText('Phone', timeout)

'Find the Phone field'
TestObject phone = Finder.findTextField('Digital Program/New Start Form/Phone')

Mobile.tap(phone, timeout)

'Enter value in the Email field'
TextField.typeText(phone, Phone, timeout)

Button.tap('Digital Program/New Start Form/Phone Type Mobile')

Button.tap('Digital Program/New Start Form/Today Im deciding to follow Jesus')

Button.tap('Digital Program/New Start Form/Cancel')

Button.tap('Digital Program/Go Back')