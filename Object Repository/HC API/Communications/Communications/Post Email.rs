<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Post Email</name>
   <tag></tag>
   <elementGuidId>8974a32f-406a-41b1-ae08-16987cba2982</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;audienceType\&quot;: \&quot;Segment\&quot;,\n  \&quot;churchEntityId\&quot;: 10,\n  \&quot;communicationCategoryId\&quot;: 1,\n  \&quot;description\&quot;: \&quot;${CommunicationName} Description\&quot;,\n  \&quot;name\&quot;: \&quot;${CommunicationName}\&quot;,\n  \&quot;isActive\&quot;: true,\n  \&quot;sendEmail\&quot;: true,\n  \&quot;sendPush\&quot;: false,\n  \&quot;tagIds\&quot;: [\n    1\n  ]\n}&quot;,
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
      <webElementGuid>c5d8b7e5-6b70-4c71-8c68-5dc0c337ba4b</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>dba748ee-3398-4ebd-a999-bba0a6eb669c</webElementGuid>
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
      <defaultValue>'ST Communication Test'</defaultValue>
      <description></description>
      <id>d32571cc-72ee-455b-931e-2ac2ec0d7262</id>
      <masked>false</masked>
      <name>CommunicationName</name>
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
