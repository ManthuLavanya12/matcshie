package com.matschie.servicenow.services;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.util.Map;

import io.restassured.response.Response;

public class ChainedRequestsforJIRA {
	private static Response response;
    private static String issueid;
	public Response createnewIssue(File file) {
		return given()
		.header("Content-Type","application/json")
		.log()
		.all()
	    .when()
	    .body(file)
	    .post("/issue");

	}
	public Response updateIssue(File file, String issueid, Map<String,String> map) {
		return given()
		.queryParams(map)
		.log()
		.all()
		.header("Content-Type","application/json")
	    .when()
	    .body(file)
	    .put("/issue/"+issueid);

	}
	public Response DeleteIssue(String issueid) {
		return given()
	    .when()
	    .delete("/issue/"+issueid);

	}
	public ChainedRequestsforJIRA deletesingleIssueId() {
		response = DeleteIssue(issueid);
		return this;
	}
	
	public Response getDeletedIssue(String issueid) {
		return given()
	    .when()
	    .get("/issue/"+issueid);

	}
	public ChainedRequestsforJIRA getdeletedIssueId() {
		response = getDeletedIssue(issueid);
		return this;
	}
  

	public ChainedRequestsforJIRA updateingleIssueId(File file, Map<String,String> map) {
		response = updateIssue(file,issueid,map);
		return this;
	}
	public ChainedRequestsforJIRA validatesummary(String jsonpath,String desc) {
	
	    assertThat(response.body().jsonPath().getString(jsonpath),equalTo(desc));
		
	    return this ;
		
	}


	public Response GetsingleIssueid(String issueid) {
		return given()
	    .when()
	    .get("/issue/"+issueid);

	}
	public ChainedRequestsforJIRA getsingleIssueId() {
		response = GetsingleIssueid(issueid);
		return this;
	}
   
	
	public ChainedRequestsforJIRA create(File file, String jsonpath) {
		response = createnewIssue(file);
		issueid = response.body().jsonPath().getString(jsonpath);
		return this;
	}
	public ChainedRequestsforJIRA validateStatusCode(int statuscode) {
		System.out.println(response.getStatusCode());
	    assertThat(response.getStatusCode(),equalTo(statuscode));
	    return this ;
		
	}
	public ChainedRequestsforJIRA validateStatusLine(String statusline) {
	    assertThat(response.getStatusLine(),containsString(statusline));
	    return this ;
		
	}
	public ChainedRequestsforJIRA validatecontentType(String content) {
	    assertThat(response.getContentType(),containsString(content));
	    return this ;
		
	}

	public String getresponse() {
		   return response.body().asPrettyString();
		
	}

}
