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

'Login'
WebUI.callTestCase(findTestCase('HC-Web/Shared/Login'), [('HostUrl') : GlobalVariable.HC_HostUrl, ('UserName') : GlobalVariable.Admin_UserName
        , ('Password') : GlobalVariable.Admin_Password], FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'customUtility.NavigationHelper.clickTopMenuAndValidateHeader'('My Stuff', 'Home')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('My Stuff', 'Home', 'Home')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('My Stuff', 'My Follow Ups', 'My Follow Ups')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('My Stuff', 'All Follow Ups', 'All Follow Ups')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('My Stuff', 'My Ministries', 'My Ministries')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('My Stuff', 'Notifications', 'Notifications')

CustomKeywords.'customUtility.NavigationHelper.clickTopMenuAndValidateHeader'('People', 'Search or Add')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('People', 'Search or Add', 'Search or Add')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('People', 'Record Management', 'Record Management')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('People', 'Settings and Preferences', 'Settings and Preferences')

CustomKeywords.'customUtility.NavigationHelper.clickTopMenuAndValidateHeader'('Ministries Central', 'All Ministries')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Ministries Central', 'All Ministries', 'All Ministries')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Ministries Central', 'Quick-view Insights', 'Quick-view Insights')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Ministries Central', 'Settings & Preferences', 'Settings & Preferences')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Ministries Central', 'Serving Opps Catalogs', 'Serving Opps Catalogs')

CustomKeywords.'customUtility.NavigationHelper.clickTopMenuAndValidateHeader'('Events Central', 'All Events')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Events Central', 'All Events', 'All Events')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Events Central', 'Worship Service Setup', 'Worship Service Setup')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Events Central', 'Settings & Preferences', 'Settings & Preferences')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Events Central', 'Event Catalogs', 'Event Catalogs')

CustomKeywords.'customUtility.NavigationHelper.clickTopMenuAndValidateHeader'('Communications', 'Email Templates')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Communications', 'Email Templates', 'Email Templates')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Communications', 'Segment Search', 'Segment Search')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Communications', 'Segment Builder', 'Segment Builder')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Communications', 'Settings & Preferences', 'Settings & Preferences')

CustomKeywords.'customUtility.NavigationHelper.clickTopMenuAndValidateHeader'('Mobile Engagement', 'Service Companion')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Mobile Engagement', 'Service Companion', 'Service Companion')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Mobile Engagement', 'Service Series Builder', 'Service Series Builder')

CustomKeywords.'customUtility.NavigationHelper.clickTopMenuAndValidateHeader'('Journey (beta)', 'Journeys')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Journey (beta)', 'Journeys (beta)', 'Journeys')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Journey (beta)', 'Settings & Preferences', 'Settings & Preferences')

CustomKeywords.'customUtility.NavigationHelper.clickTopMenuAndValidateHeader'('Giving Central', 'All Giving')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Giving Central', 'All Giving', 'All Giving')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Giving Central', 'Designations', 'Designations')

CustomKeywords.'customUtility.NavigationHelper.clickTopMenuAndValidateHeader'('Data Capture', 'Connection Forms')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Data Capture', 'Connection Forms', 'Connection Forms')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Data Capture', 'Connection Cards', 'Connection Cards')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Data Capture', 'Connection Questions', 'Connection Questions')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Data Capture', 'Weekend Metrics Capture', 'Weekend Metrics Capture')

CustomKeywords.'customUtility.NavigationHelper.clickTopMenuAndValidateHeader'('Insights', 'Flash Reports')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Insights', 'Flash Reports', 'Flash Reports')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Insights', 'Embedded Reports', 'Embedded Reports')

CustomKeywords.'customUtility.NavigationHelper.clickTopMenuAndValidateHeader'('System', 'System')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('System', 'Platform Settings', 'Platform Settings')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('System', 'Campus Settings', 'Campus Settings')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('System', 'Users & Teams', 'Users & Teams')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('System', 'Security & Permissions', 'Security & Permissions')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('System', 'Migration Settings', 'Migration Settings')

CustomKeywords.'customUtility.NavigationHelper.clickTopMenuAndValidateHeader'('Dev Tools', 'Elastic Search Indexing')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Dev Tools', 'Elastic Search Indexing', 'Elastic Search Indexing')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Dev Tools', 'Schedule Cache Control', 'Schedule Cache Control')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Dev Tools', 'Occurrence Tool', 'Occurrence Tool')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Dev Tools', 'QR Code Tool', 'QR Code Tool')
CustomKeywords.'customUtility.NavigationHelper.clickSubmenuAndValidateHeader'('Dev Tools', 'Unlayer Email Editor Test', 'Unlayer Email Editor Test')


