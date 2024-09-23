package com.matshie.servicenow.stepdefinition;

import com.matschie.general.utils.PropertiesHandler;
import com.matschie.pojo.serialization.CreateIncident;
import com.matschie.servicenow.services.IncidentServices;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class CreateNewincidentusingCucumber {
	private IncidentServices service=new IncidentServices();
	@Given("Set Base URI and Base Path")
	public void set_base_uri_and_base_path() {
		RestAssured.baseURI=PropertiesHandler.config("service.now.instance.uri");
		RestAssured.basePath=PropertiesHandler.config("service.now.instance.basePath");
				
	}
	@Given("Set authentication")
	public void set_authentication() {
		RestAssured.authentication=RestAssured.basic(PropertiesHandler.config("service.now.instance.username"),PropertiesHandler.config("service.now.password"));
	}
	@When("user hit post method with payload")
	public void user_hit_post_method_with_payload() {
		CreateIncident payload=new CreateIncident();
		payload.setDescription("created record");
		payload.setShort_description("Cucumber");
		service.create(payload);
	}
	@When("user hit post method with following different request payload (.*), (.*),(.*)$")
	public void user_hit_post_method_with_following_different_request_payload_cucumber_created_413a4d35eb32010045e1a5115206fe6b(String shortdesc, String desc, String caller) {
		CreateIncident payload=new CreateIncident();
		payload.setDescription(desc);
		payload.setShort_description(shortdesc);
		payload.setCallerid(caller);
		service.createcall(payload);

	}
	@Then("new incident record should be created based on the given payload (.*), (.*),(.*)$")
	public void new_incident_record_should_be_created_based_on_the_given_payload(String shortdesc, String desc, String caller) {
		service.validateStatusCode(201)
        .validateShortdescription(shortdesc)
        .validatecalleridvalue(caller)
        .validatedescription(desc)
        .validatecontentType("application/json")
        .validateStatusLine("Created");
	}

	@Then("new incident record should be created")
	public void new_incident_record_should_be_created() {
		service.validateStatusCode(201)
            .validateShortdescription("Cucumber")
            .validatedescription("created record")
            .validatecontentType("application/json")
            .validateStatusLine("Created");

	}


}
