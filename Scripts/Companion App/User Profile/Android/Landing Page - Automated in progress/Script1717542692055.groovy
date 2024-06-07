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

WebUI.callTestCase(findTestCase('Companion App/Shared/Login'), [('UserName') : '', ('Password') : ''], FailureHandling.STOP_ON_FAILURE)

Mobile.startApplication('C:\\Users\\paren\\AppData\\Local\\Microsoft\\Windows\\INetCache\\IE\\BSWM63L1\\Latest_Stage_CA_custom[1].apk', 
    true)

'Profile photo icon - on lower navigation menu '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/android.widget.ImageView'), 0)

'Settings icon '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/android.view.ViewGroup'), 0)

'Profile photo icon - on lower navigation menu '
not_run: Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/android.widget.ImageView'), 0)

'My QR Code '
not_run: Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/android.view.ViewGroup (1)'), 0)

Mobile.closeApplication()

