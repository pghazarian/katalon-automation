<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Journey Delete</name>
   <tag></tag>
   <elementGuidId>89bdfff4-3471-41ea-83c9-c2ac183e1304</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <authorizationRequest>
      <authorizationInfo>
         <entry>
            <key>bearerToken</key>
            <value>eyJhbGciOiJSUzI1NiIsImtpZCI6IjRCNDc1Q0I5RUQ5QTAzNThFMzExRjNBMjEwOERCNERDOUJGMDQ0MTIiLCJ0eXAiOiJKV1QiLCJ4NXQiOiJTMGRjdWUyYUExampFZk9pRUkyMDNKdndSQkkifQ.eyJuYmYiOjE3MDg3MjQ2NTgsImV4cCI6MTc0MDI2MDY1OCwiaXNzIjoiaHR0cHM6Ly9pZGVudGl0eS1kZXYuc2FkZGxlYmFjay5jb20iLCJhdWQiOlsiaHR0cHM6Ly9pZGVudGl0eS1kZXYuc2FkZGxlYmFjay5jb20vcmVzb3VyY2VzIiwiY20tYXBpIiwibXlzYi1hcGkiLCJ2aXNpb24tMiIsImZhY2Vib29rIl0sImNsaWVudF9pZCI6ImNtIiwic3ViIjoiMTQ5MjMyMSIsImF1dGhfdGltZSI6MTcwODU0NDQ5MSwiaWRwIjoibG9jYWwiLCJ1cm46c2FkZGxlYmFjazp1c2VyX2lkIjpbIjRlZGRjNDhlLTYyNzMtNDIzMS1iYTYwLTgwZTFlNzlhYTNmOCIsIjRlZGRjNDhlLTYyNzMtNDIzMS1iYTYwLTgwZTFlNzlhYTNmOCJdLCJpZCI6IjE0OTIzMjEiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwidXJuOnNhZGRsZWJhY2s6cGVyc29uX2xpbmsiOiJVTktOT1dOIiwic2NvcGUiOlsib3BlbmlkIiwicHJvZmlsZSIsImNtLWFwaS5kZWZhdWx0IiwibXlzYi1hcGkuZGVmYXVsdCIsInZpc2lvbi0yLmFjY2Vzcy10b2tlbiIsImZhY2Vib29rLmFjY2Vzcy10b2tlbiJdLCJhbXIiOlsicHdkIl19.I-27U8Vrtw2upxnEU4ZGBTp6YQzmI_qWDgkPYwHqG8hU-LShTy31LPQ4vcp_qbiERriCbEO4xCzVmhcQj_LfwGpZjc6k_Q8l-m-nJUD7FbuFa-ejkKghrMyFIJklGoXjvgP5LqJjyVr8TsIzyioPfMa154C4O4pThA6Ck9E78aCJHGk4yH3v7cQUNFDn3AzZ4kkGYV-h41EYWQbZKGrxC9ybElXf_RvjdhYUX7_L3_JDaTE05Lg8NlL-bMNDlsmIiD6J3wCrdoMf0sGUX7s9QgHCzrzISFbd_lfdlueBiL8szUQIP3LCgN8czlkizOt4x_fLGVqAmBhevOfRDqCwog</value>
         </entry>
      </authorizationInfo>
      <authorizationType>Bearer</authorizationType>
   </authorizationRequest>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;Model\&quot;: \&quot;Journey\&quot;,\n    \&quot;Operation\&quot;: \&quot;delete\&quot;,\n    \&quot;Id\&quot;: ${JourneyID}\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>9998aebd-5671-4e58-a74b-63c4816410dc</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjRCNDc1Q0I5RUQ5QTAzNThFMzExRjNBMjEwOERCNERDOUJGMDQ0MTIiLCJ0eXAiOiJKV1QiLCJ4NXQiOiJTMGRjdWUyYUExampFZk9pRUkyMDNKdndSQkkifQ.eyJuYmYiOjE3MDg3MjQ2NTgsImV4cCI6MTc0MDI2MDY1OCwiaXNzIjoiaHR0cHM6Ly9pZGVudGl0eS1kZXYuc2FkZGxlYmFjay5jb20iLCJhdWQiOlsiaHR0cHM6Ly9pZGVudGl0eS1kZXYuc2FkZGxlYmFjay5jb20vcmVzb3VyY2VzIiwiY20tYXBpIiwibXlzYi1hcGkiLCJ2aXNpb24tMiIsImZhY2Vib29rIl0sImNsaWVudF9pZCI6ImNtIiwic3ViIjoiMTQ5MjMyMSIsImF1dGhfdGltZSI6MTcwODU0NDQ5MSwiaWRwIjoibG9jYWwiLCJ1cm46c2FkZGxlYmFjazp1c2VyX2lkIjpbIjRlZGRjNDhlLTYyNzMtNDIzMS1iYTYwLTgwZTFlNzlhYTNmOCIsIjRlZGRjNDhlLTYyNzMtNDIzMS1iYTYwLTgwZTFlNzlhYTNmOCJdLCJpZCI6IjE0OTIzMjEiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwidXJuOnNhZGRsZWJhY2s6cGVyc29uX2xpbmsiOiJVTktOT1dOIiwic2NvcGUiOlsib3BlbmlkIiwicHJvZmlsZSIsImNtLWFwaS5kZWZhdWx0IiwibXlzYi1hcGkuZGVmYXVsdCIsInZpc2lvbi0yLmFjY2Vzcy10b2tlbiIsImZhY2Vib29rLmFjY2Vzcy10b2tlbiJdLCJhbXIiOlsicHdkIl19.I-27U8Vrtw2upxnEU4ZGBTp6YQzmI_qWDgkPYwHqG8hU-LShTy31LPQ4vcp_qbiERriCbEO4xCzVmhcQj_LfwGpZjc6k_Q8l-m-nJUD7FbuFa-ejkKghrMyFIJklGoXjvgP5LqJjyVr8TsIzyioPfMa154C4O4pThA6Ck9E78aCJHGk4yH3v7cQUNFDn3AzZ4kkGYV-h41EYWQbZKGrxC9ybElXf_RvjdhYUX7_L3_JDaTE05Lg8NlL-bMNDlsmIiD6J3wCrdoMf0sGUX7s9QgHCzrzISFbd_lfdlueBiL8szUQIP3LCgN8czlkizOt4x_fLGVqAmBhevOfRDqCwog</value>
      <webElementGuid>d82a1a6c-ce83-4bf3-ae4d-e5b24a64ea58</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.2.0</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.HC_API_URL}/api/search-index</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'580'</defaultValue>
      <description></description>
      <id>0f746e6d-e4b5-41f7-8ebb-aa087cc248e5</id>
      <masked>false</masked>
      <name>JourneyID</name>
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
