import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword
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

import com.detroitlabs.katalonmobileutil.device.App
import com.detroitlabs.katalonmobileutil.device.Device
import com.detroitlabs.katalonmobileutil.testobject.Finder
import com.detroitlabs.katalonmobileutil.testobject.Button
import com.detroitlabs.katalonmobileutil.testobject.TextField

/*
 * Documentation for the DetroitLabs library: https://github.com/detroit-labs/katalon-mobile-util?tab=readme-ov-file#textfield
 * 
 */

int timeout = 3
Button.initialize(timeout, FailureHandling.OPTIONAL)

// OS checks
if (Device.isIOS()) {
  println("This is an iOS device.")
}
if (Device.isAndroid()) {
  println("This is an Android device.")
}

println(Device.getDeviceOS())

// setup configuration for the apps

// Android
String androidFile = "app.apk"
String androidAppId = GlobalVariable.CompanionApp_BundleId
App androidApp = new App(androidFile, androidAppId)

// iOS
String iosFile = "App Files/Companion App/ios/ios-stage-build.ipa"
String iosAppId = GlobalVariable.CompanionApp_BundleId
App iosApp = new App(iosFile, iosAppId)

// Setup the Object Repository base paths for each OS
Finder.setIOSRepository('Object Repository/Companion App/iOS')
Finder.setAndroidRepository('Object Repository/Companion App/Android')

// Start App based on 
boolean removeAppBeforeTest = false // change this to false to keep the app state between tests
Device.startApp([iosApp, androidApp], removeAppBeforeTest)

'Click Login Button'
Button.tap("Create Account or Login")

//TestObject loginButton = Finder.findButton('blahblah')
//Mobile.tap(loginButton, 0)

//
///*
// * Object Repository/Companion App/iOS/Buttons/Create Account or Login Button
// * Object Repository/Companion App/iOS/Create Account or Login Button
// * Object Repository/Companion App/iOS/Buttons/Create Account or Login
// * Object Repository/Companion App/iOS/Buttons/Create Account or Login
// */
//
//'Click the Continue Button (from the OS to approve going to an external domain)'
//Button.tap("Login/Continue")
//
//'Put focus in the Email Address field'
//TestObject emailAddress = Finder.findTextField('Login/Email Address Text Field')
//TextField.clearText(emailAddress, timeout)
//TextField.typeText(emailAddress, GlobalVariable.Admin_UserName, timeout)
//
//'Put focus in the Password field'
//TestObject password = Finder.findTextField('Login/Password Text Field')
//TextField.clearText(password, timeout)
//TextField.typeText(password, GlobalVariable.Admin_Password, timeout)
//
//'Click Sign In Button'
//Button.tap('Login/Sign In Button')
//
//'Click Later Button'
//Button.tap("Later")
//
