package com.matshie.servicenow.stepdefinition;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.matschie.general.utils.PropertiesHandler;
import com.matschie.servicenow.services.ChainedRequestsforJIRA;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class JIRAchainingsteps {
	private ChainedRequestsforJIRA jira=new ChainedRequestsforJIRA();

	@Given("Set base path and base uri")
	public void set_base_path_and_base_uri1() {
		RestAssured.baseURI=PropertiesHandler.configjira("jira.now.instance.uri");
		RestAssured.basePath=PropertiesHandler.configjira("jira.now.instance.basePath");
		RestAssured.authentication=RestAssured.preemptive().basic(PropertiesHandler.configjira("jira.now.instance.username"), PropertiesHandler.configjira("jira.now.apitoken"));

	}
	@When("post new issue with payload")
	public void post_new_issue_with_payload() {
	jira.create(new File("src/test/resources/resources/create-issue.json"), "id");
	
	}
	@Then("check whether new issue is posted")
	public void check_whether_new_issue_is_posted() {
		jira.validateStatusCode(201);
		jira.validatecontentType("application/json");
		jira.validateStatusLine("Created");
		System.out.println(jira.getresponse());
	}
	@When("get single created issue")

	public void get_single_created_issue() {
		jira.getsingleIssueId();
	}
	@Then("single issue should be fetched successfully")
	public void single_issue_should_be_fetched_successfully() {
		jira.validateStatusCode(200);
		jira.validatecontentType("application/json");
		jira.validateStatusLine("OK");
	}
	@When("put request for updating issue in JIRA")

	public void put_request_for_updating_issue_in_jira() {
		Map<String,String> result= new HashMap<String,String>();
		String[] keys= {"returnIssue"};
		result=PropertiesHandler.queryparamsmap(keys);
		jira.updateingleIssueId(new File("src/test/resources/resources/update-issue.json"),result);
		
	}
	@Then("data should be updated properly")

	public void data_should_be_updated_properly() {
		jira.validateStatusCode(200);
		jira.validatecontentType("application/json");
		jira.validateStatusLine("OK");
		System.out.println(jira.getresponse());
		jira.validatesummary("fields.summary", "Updated Issue from REST API");
		
	}


	@When("delete request for deleting created issue in JIRA")

	public void delete_request_for_deleting_created_issue_in_jira() {
		jira.deletesingleIssueId();
		
	}
	@Then("deleted single issue successfully")

	public void deleted_single_issue_successfully() {
		jira.validateStatusCode(204);
		jira.validateStatusLine("No Content");
	}

	@When("get deleted issue")
	public void get_deleted_issue() {
		jira.getdeletedIssueId();
	}
	@Then("{int} should be shown")

	public void should_be_shown(Integer int1) {
		jira.validateStatusCode(404);
     	jira.validateStatusLine("Not Found");
	}



}
