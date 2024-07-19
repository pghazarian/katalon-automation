<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Get Sender Emails</name>
   <tag></tag>
   <elementGuidId>0177641a-a7c7-45d5-875c-a7b986d2e188</elementGuidId>
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
      <webElementGuid>ab56f97b-5a0e-4c49-b2da-4b946c0fbdde</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>6c5dcdc8-d841-4573-83f4-c9d3dc9cffcf</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjRCNDc1Q0I5RUQ5QTAzNThFMzExRjNBMjEwOERCNERDOUJGMDQ0MTIiLCJ0eXAiOiJKV1QiLCJ4NXQiOiJTMGRjdWUyYUExampFZk9pRUkyMDNKdndSQkkifQ.eyJuYmYiOjE3MTc5OTgyMDYsImV4cCI6MTc0OTUzNDIwNiwiaXNzIjoiaHR0cHM6Ly9pZGVudGl0eS1kZXYuc2FkZGxlYmFjay5jb20iLCJhdWQiOlsiaHR0cHM6Ly9pZGVudGl0eS1kZXYuc2FkZGxlYmFjay5jb20vcmVzb3VyY2VzIiwiY20tYXBpIiwibXlzYi1hcGkiLCJ2aXNpb24tMiIsImZhY2Vib29rIl0sImNsaWVudF9pZCI6ImNtIiwic3ViIjoiNTAzMDMyOSIsImF1dGhfdGltZSI6MTcxNzk5ODIwNiwiaWRwIjoibG9jYWwiLCJ1cm46c2FkZGxlYmFjazp1c2VyX2lkIjpbIjFiZTBmMGQzLWQ4ZmUtNDJlZi05MGYwLTEyMDlkZmYwOWM5ZCIsIjFiZTBmMGQzLWQ4ZmUtNDJlZi05MGYwLTEyMDlkZmYwOWM5ZCJdLCJpZCI6IjUwMzAzMjkiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwidXJuOnNhZGRsZWJhY2s6cGVyc29uX2xpbmsiOiJVTktOT1dOIiwic2NvcGUiOlsib3BlbmlkIiwicHJvZmlsZSIsImNtLWFwaS5kZWZhdWx0IiwibXlzYi1hcGkuZGVmYXVsdCIsInZpc2lvbi0yLmFjY2Vzcy10b2tlbiIsImZhY2Vib29rLmFjY2Vzcy10b2tlbiJdLCJhbXIiOlsicHdkIl19.WPr2MuyOmsXKptQ40MDHZN9mbg_2z9xCZDskpcFkPrPejpfnVCVsojsCjGsvvACOi1He7yfdfSCzCibE8cCJxAnaMDM0yMaInl8ZN8xvsMJjmRW7Q4POurUGiXnBC4gl5-aX5OkIbxHOi5JHLzwU4YIVP1_IywVo2LdMtkWuZMbIFSghYQLnLRDbxfDCTtAuzXxBLxuPDlmmpB32CaxDMeN8HxjI2c7YGg39BdxZQnnSrzx-CjitBI0SzD_RvRrjhiVhBLo6qK8GndspJbCSCkQVB5omzmqblj6QYAq56AqogJAmgWUwPs_-aEsSDYr0-wNrwrF7Oxbb1yOYEiZ4fw</value>
      <webElementGuid>0d88365f-4e9c-41f9-8588-c0049fbf3d91</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.4.0</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>${GlobalVariable.HC_HostUrl}/api/internal/promotional-communication-jobs/sender-emails?query=Test</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'Test'</defaultValue>
      <description></description>
      <id>9af73043-bd1a-44be-93cb-59781095dd81</id>
      <masked>false</masked>
      <name>query</name>
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

WS.verifyElementPropertyValue(response, '[0].emailName', 'Triston Test')</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
