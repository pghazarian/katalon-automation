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

Mobile.startApplication('C:\\Users\\paren\\AppData\\Local\\Microsoft\\Windows\\INetCache\\IE\\7GVZYD4L\\android-stage-build[1].apk', 
    true)

'Log In button '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/android.widget.FrameLayout'), 0)

'Email address\r\n'
Mobile.setText(findTestObject('Object Repository/Companion App/Android/User Profile/android.widget.EditText'), 'pareng@saddleback.com', 
    0)

'Password'
Mobile.setText(findTestObject('Object Repository/Companion App/Android/User Profile/android.widget.EditText (1)'), 'Jahlife7&', 
    0)

'Sign In button '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/android.widget.Button - Sign In'), 0)

'Profile photo/Silhouette'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/android.view.ViewGroup'), 0)

'My QR Code button'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/android.view.ViewGroup (1)'), 0)

'Settings icon '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/android.view.ViewGroup (3)'), 0)

'Open Settings modal OK button '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/android.widget.Button - OK'), 0)

'Profile photo/Silhouette'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/android.view.ViewGroup (4)'), 0)

'Giving icon '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/android.view.ViewGroup (5)'), 0)

'X icon in Giving screen '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/android.view.ViewGroup (6)'), 0)

'MY QR Code button'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/android.widget.TextView - My QR Code'), 
    0)

'My QR Code button'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/android.view.ViewGroup (1)'), 0)

'My Ministries Tile '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/android.widget.TextView - My Ministries'), 
    0)

'Browse Ministries button '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/android.widget.TextView - Browse Ministries'), 
    0)

'Browse Ministries button inside layer '
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/android.widget.Button'), 0)

'Browse Ministries button middle smallest part'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/android.view.ViewGroup (7)'), 0)

'Back button in Browse Ministries screen (top left)'
Mobile.tap(findTestObject('Object Repository/Companion App/Android/User Profile/android.view.ViewGroup (8)'), 0)

Mobile.closeApplication()

