package com.matshie.servicenow.stepdefinition;

import java.util.HashMap;
import java.util.Map;

import com.matschie.general.utils.PropertiesHandler;
import com.matschie.servicenow.services.IncidentServices;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class ServicenowSteps {
	private IncidentServices service=new IncidentServices();

	@Given("set base path and base uri")
	public void set_base_path_and_base_uri() {
		RestAssured.baseURI=PropertiesHandler.config("service.now.instance.uri");
		RestAssured.basePath=PropertiesHandler.config("service.now.instance.basePath");
	}
	@Given("set authentication")
	public void set_authentication() {
		RestAssured.authentication=RestAssured.basic(PropertiesHandler.config("service.now.instance.username"),PropertiesHandler.config("service.now.password"));
	}
	@When("hit get request to get all change requests")
	public void hit_get_request_to_get_all_change_requests() {
		Map<String,String> result= new HashMap<String,String>();
		String[] keys= {"sysparm_query"};
		result=PropertiesHandler.queryparamsmap(keys);
	       service.getchangeRequestByQuery(result);
		   
	}
	@Then("all change requests should be fetched successfully")
	public void all_change_requests_should_be_fetched_successfully() {
	       service.validateStatusCode(200)
	       .validateStatusLine("OK")
	       .validatecontentType("application/json")
	       .validateactiveChangeRequest("true","result.findAll{it.active == 'true'}.active",104);
	      System.out.println(service.getresponse());
	}

}
