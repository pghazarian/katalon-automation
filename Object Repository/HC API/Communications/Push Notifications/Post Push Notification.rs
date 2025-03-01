<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Post Push Notification</name>
   <tag></tag>
   <elementGuidId>c8f7a392-302a-45ed-baf8-123ec1ba553e</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;audienceType\&quot;: \&quot;Segment\&quot;,\n  \&quot;churchEntityId\&quot;: 10,\n  \&quot;communicationCategoryId\&quot;: 1,\n  \&quot;description\&quot;: \&quot;${PushNotificationName} Description\&quot;,\n  \&quot;name\&quot;: \&quot;${PushNotificationName}\&quot;,\n  \&quot;isActive\&quot;: true,\n  \&quot;sendEmail\&quot;: false,\n  \&quot;sendPush\&quot;: true,\n  \&quot;tagIds\&quot;: [\n    1\n  ]\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Accept</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>fe06dc42-e66c-49e4-8542-4d435facfd9c</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>166f2afd-3040-4839-b371-1f3ea94fa102</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjRCNDc1Q0I5RUQ5QTAzNThFMzExRjNBMjEwOERCNERDOUJGMDQ0MTIiLCJ0eXAiOiJKV1QiLCJ4NXQiOiJTMGRjdWUyYUExampFZk9pRUkyMDNKdndSQkkifQ.eyJuYmYiOjE3MTU1OTM3MDksImV4cCI6MTc0NzEyOTcwOSwiaXNzIjoiaHR0cHM6Ly9pZGVudGl0eS1kZXYuc2FkZGxlYmFjay5jb20iLCJhdWQiOlsiaHR0cHM6Ly9pZGVudGl0eS1kZXYuc2FkZGxlYmFjay5jb20vcmVzb3VyY2VzIiwiY20tYXBpIiwibXlzYi1hcGkiLCJ2aXNpb24tMiIsImZhY2Vib29rIl0sImNsaWVudF9pZCI6ImNtIiwic3ViIjoiNTAzMDMyOSIsImF1dGhfdGltZSI6MTcxNTU5MzcwOSwiaWRwIjoibG9jYWwiLCJ1cm46c2FkZGxlYmFjazp1c2VyX2lkIjpbIjFiZTBmMGQzLWQ4ZmUtNDJlZi05MGYwLTEyMDlkZmYwOWM5ZCIsIjFiZTBmMGQzLWQ4ZmUtNDJlZi05MGYwLTEyMDlkZmYwOWM5ZCJdLCJpZCI6IjUwMzAzMjkiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwidXJuOnNhZGRsZWJhY2s6cGVyc29uX2xpbmsiOiJVTktOT1dOIiwic2NvcGUiOlsib3BlbmlkIiwicHJvZmlsZSIsImNtLWFwaS5kZWZhdWx0IiwibXlzYi1hcGkuZGVmYXVsdCIsInZpc2lvbi0yLmFjY2Vzcy10b2tlbiIsImZhY2Vib29rLmFjY2Vzcy10b2tlbiJdLCJhbXIiOlsicHdkIl19.xI0HFUZjRD2U9ZyDpk00G0H_wzKQMwEDZibfLWPARprv2cE-Vrbu_A-ibFb1HOmfkyYvhQynQrdzwYOkajQZe80uHJcG3nXyTiZBFkghPW8Dmk79o1_uDNHTPD0N-t7vZXRxYGsdhsSLpjDJGDSDxVge3Rcaj9WRT1IkRYxAOzF-iXduot12N5Noye4La9RPqPYrx7vUjZvGZiJetUNEBgQmEwL3I1fIG7WYGkmGa-9GkhvSMV-LCh41arOxxMEjxSZuCvKl6wT4zSTmAp5qcSSMouYxPbMt04PQVLWfEO2V9A4oiE7AfG_WqMTysktdfztFAn0Y3Aiz9h4LQflXtA</value>
      <webElementGuid>6c85f734-b90a-40aa-bfc6-d477a160d4e4</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.4.0</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.HC_HostUrl}/api/internal/promotional-communication-jobs</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'ST Push Notification Test'</defaultValue>
      <description></description>
      <id>a0ace17e-fa56-4c1e-b362-2e559e9400ed</id>
      <masked>false</masked>
      <name>PushNotificationName</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

WS.verifyResponseStatusCode(response, 200)

assertThat(response.getStatusCode()).isEqualTo(200)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
