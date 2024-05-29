<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Post Push Notification</name>
   <tag></tag>
   <elementGuidId>c8f7a392-302a-45ed-baf8-123ec1ba553e</elementGuidId>
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
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>cf2fc854-4688-4d85-94ca-e144941c28ea</webElementGuid>
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
   <restUrl>${GlobalVariable.HC_HostUrl}/api/internal/promotional-communication-jobs?JobType=${JobType}&amp;AudienceType=${AudienceType}&amp;ChurchEntityId=${ChurchEntityId}&amp;CommunicationCategoryId=${CommunicationCategoryId}&amp;Description=${Description}&amp;Name=${Name}&amp;SendPush=${SendPush}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'Push'</defaultValue>
      <description></description>
      <id>59d3499c-0a3e-416d-931f-df16ea1a752d</id>
      <masked>false</masked>
      <name>JobType</name>
   </variables>
   <variables>
      <defaultValue>'AllDevices'</defaultValue>
      <description></description>
      <id>451c03f1-647b-43d1-9d61-2c542a6284d0</id>
      <masked>false</masked>
      <name>AudienceType</name>
   </variables>
   <variables>
      <defaultValue>'10'</defaultValue>
      <description></description>
      <id>eb2ab66f-08a1-40d5-9439-cdd338232bd6</id>
      <masked>false</masked>
      <name>ChurchEntityId</name>
   </variables>
   <variables>
      <defaultValue>'1'</defaultValue>
      <description></description>
      <id>6ac6e7e1-6c05-4c3c-ba73-47f9f7552cb2</id>
      <masked>false</masked>
      <name>CommunicationCategoryId</name>
   </variables>
   <variables>
      <defaultValue>'New Push Notification 3 Description'</defaultValue>
      <description></description>
      <id>2ef0c2f9-d55d-4b58-a8e3-461271106e54</id>
      <masked>false</masked>
      <name>Description</name>
   </variables>
   <variables>
      <defaultValue>'New Push Notification 3 '</defaultValue>
      <description></description>
      <id>96edda75-e2a0-458a-bdbb-aec5f3a96fcc</id>
      <masked>false</masked>
      <name>Name</name>
   </variables>
   <variables>
      <defaultValue>true</defaultValue>
      <description></description>
      <id>ef4941fe-9603-4e84-8e6e-46b51e2df65e</id>
      <masked>false</masked>
      <name>SendPush</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
