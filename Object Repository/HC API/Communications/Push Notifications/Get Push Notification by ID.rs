<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Get Push Notification by ID</name>
   <tag></tag>
   <elementGuidId>22ef0a10-6445-41f5-9927-1540c473436d</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>true</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Accept</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>f839eec4-a604-400a-92cf-7057cd2dd65c</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>a363e398-c5af-4743-8549-f309c9d85816</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjRCNDc1Q0I5RUQ5QTAzNThFMzExRjNBMjEwOERCNERDOUJGMDQ0MTIiLCJ0eXAiOiJKV1QiLCJ4NXQiOiJTMGRjdWUyYUExampFZk9pRUkyMDNKdndSQkkifQ.eyJuYmYiOjE3MTU1OTM3MDksImV4cCI6MTc0NzEyOTcwOSwiaXNzIjoiaHR0cHM6Ly9pZGVudGl0eS1kZXYuc2FkZGxlYmFjay5jb20iLCJhdWQiOlsiaHR0cHM6Ly9pZGVudGl0eS1kZXYuc2FkZGxlYmFjay5jb20vcmVzb3VyY2VzIiwiY20tYXBpIiwibXlzYi1hcGkiLCJ2aXNpb24tMiIsImZhY2Vib29rIl0sImNsaWVudF9pZCI6ImNtIiwic3ViIjoiNTAzMDMyOSIsImF1dGhfdGltZSI6MTcxNTU5MzcwOSwiaWRwIjoibG9jYWwiLCJ1cm46c2FkZGxlYmFjazp1c2VyX2lkIjpbIjFiZTBmMGQzLWQ4ZmUtNDJlZi05MGYwLTEyMDlkZmYwOWM5ZCIsIjFiZTBmMGQzLWQ4ZmUtNDJlZi05MGYwLTEyMDlkZmYwOWM5ZCJdLCJpZCI6IjUwMzAzMjkiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwidXJuOnNhZGRsZWJhY2s6cGVyc29uX2xpbmsiOiJVTktOT1dOIiwic2NvcGUiOlsib3BlbmlkIiwicHJvZmlsZSIsImNtLWFwaS5kZWZhdWx0IiwibXlzYi1hcGkuZGVmYXVsdCIsInZpc2lvbi0yLmFjY2Vzcy10b2tlbiIsImZhY2Vib29rLmFjY2Vzcy10b2tlbiJdLCJhbXIiOlsicHdkIl19.xI0HFUZjRD2U9ZyDpk00G0H_wzKQMwEDZibfLWPARprv2cE-Vrbu_A-ibFb1HOmfkyYvhQynQrdzwYOkajQZe80uHJcG3nXyTiZBFkghPW8Dmk79o1_uDNHTPD0N-t7vZXRxYGsdhsSLpjDJGDSDxVge3Rcaj9WRT1IkRYxAOzF-iXduot12N5Noye4La9RPqPYrx7vUjZvGZiJetUNEBgQmEwL3I1fIG7WYGkmGa-9GkhvSMV-LCh41arOxxMEjxSZuCvKl6wT4zSTmAp5qcSSMouYxPbMt04PQVLWfEO2V9A4oiE7AfG_WqMTysktdfztFAn0Y3Aiz9h4LQflXtA</value>
      <webElementGuid>fcf4348c-b6ce-4c32-aa81-001f6d0893ca</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.4.0</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${GlobalVariable.HC_HostUrl}/api/internal/promotional-communication-jobs/${JobId}?JobType=Push</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'78'</defaultValue>
      <description></description>
      <id>9ba27f06-c6fe-41b1-9b89-f912a8160270</id>
      <masked>false</masked>
      <name>JobId</name>
   </variables>
   <variables>
      <defaultValue>'Push'</defaultValue>
      <description></description>
      <id>eb6264be-10a2-4c79-80c0-0a291ec210b6</id>
      <masked>false</masked>
      <name>JobType</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

WS.verifyResponseStatusCode(response, 200)

assertThat(response.getStatusCode()).isEqualTo(200)

WS.verifyElementPropertyValue(response, 'name', 'ST Push Notification - 2024-05-20 19:01:29 Edited')

WS.verifyElementPropertyValue(response, 'id', '78')</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
