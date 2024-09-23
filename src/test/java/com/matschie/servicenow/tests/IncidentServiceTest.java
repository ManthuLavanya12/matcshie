package com.matschie.servicenow.tests;


import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.Test;

import com.matschie.general.utils.PropertiesHandler;
import com.matschie.pojo.deserialization.ResultModal;
import com.matschie.pojo.serialization.CreateIncident;
import com.matschie.servicenow.services.IncidentServices;
import com.servicenow.testng.hooks.Retry;
import com.servicenow.testng.hooks.TestNGHooks;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class IncidentServiceTest extends TestNGHooks {
	String sys_id;
@Test(priority=0)
public void usershouldAbleToCreateIncident() {
	/*String payload="{\r\n"
			+ "    \"short_description\" : \"Hi Team\",\r\n"
			+ "    \"description\" : \"joker\",\r\n"
			+ "    \"urgency\" : \"1\",\r\n"
			+ "    \"state\" : \"1\"\r\n"
			+ "}";*/
	CreateIncident payload=new CreateIncident();
	payload.setDescription("Done");
	payload.setShort_description("Successful");
	payload.setState("1");
	payload.setUrgency("2");
	IncidentServices service=new IncidentServices();
	//Response response =service.createincident(new File("src/test/resources/resources/create-incident.json"));
	//Response response =service.createincident(payload);
    //assertThat(response.getStatusCode(),equalTo(201));
    //assertThat(response.getStatusLine(),containsString("Created"));
    //assertThat(response.getContentType(),containsString("application/json"));
	service.create(payload);
	service.validatecontentType("application/json");
	service.validateStatusCode(201);
	service.validateStatusLine("Created");


	//System.out.println(response.asPrettyString());
	sys_id= service.GetSysId("result.sys_id");
System.out.println(sys_id);

	
	
	
}
@Test(priority=1)
public void usershouldAbleToCreateIncidentandFetchall() {
	CreateIncident payload=new CreateIncident();
	payload.setCallerid("413a4d35eb32010045e1a5115206fe6b");
	payload.setShort_description("Successful");
	payload.setDescription("Done");
	IncidentServices service=new IncidentServices();
    service.createcall(payload);
    service.validateShortdescription("Successful");
    service.validatedescription("Done");
    service.validatecalleridvalue("413a4d35eb32010045e1a5115206fe6b");

	
}

@Test(priority=2)
public void ShouldGetSingleIncident() {
	IncidentServices service=new IncidentServices();
service.getincident(sys_id);
service.validateStatusCode(200);
service.validatecontentType("application/json");
service.validateStatusLine("OK");
}
@Test(priority=3)
public void ShouldGetIncidentByQueryparam() {
	IncidentServices service=new IncidentServices();
	Map<String,String> result= new HashMap<String,String>();
	String[] keys= {"sysparm_limit","sysparm_query"};
	result=PropertiesHandler.queryparamsmap(keys);
	service.getincidentByquery(result);
	System.out.println(service.getresponse());
}

@Test
public void GetHardwarelist() {
	Map<String,String> result= new HashMap<String,String>();
	String[] keys= {"sysparm_query"};
	result=PropertiesHandler.queryparamsmap(keys);
	new IncidentServices()
       .getincidentByquery(result)
       .validateStatusCode(200)
       .validateStatusLine("OK")
       .validatecontentType("application/json")
       .validateIncidentcategoryisHardware("result.findAll{it.category == 'hardware'}.category", "hardware")
       .validatecategorycount("result.findAll{it.category == 'hardware'}.category", 9);
	   
	
}
}
