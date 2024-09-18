package com.matschie.servicenow.services;

import java.io.File;
import java.util.Map;

import com.matschie.pojo.deserialization.ResultModal;
import com.matschie.pojo.deserialization.Root;
import com.matschie.pojo.deserialization.Rootcaller;
import com.matschie.pojo.serialization.CreateIncident;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class IncidentServices {
	private Response response;
	public Root root;
	public Rootcaller rootcaller;
public Response createincident(File file) {
	return given()
	.header("Content-Type","application/json")
    .when()
    .body(file)
    .post("/incident");

}
public Response createincident(String payload) {
	return given()
	.header("Content-Type","application/json")
    .when()
    .body(payload)
    .post("/incident");

}
public Response createincident(CreateIncident payload) {
	return given()
	.header("Content-Type","application/json")
	.log()
	.all()
    .when()
    .body(payload)
    .post("/incident");

}
public Response GetSingleIncident(String sysid) {
	return given()
	 .log()
	 .all()
    .when()
    .get("/incident/"+sysid);

}

public Response GetIncidentByquery(Map<String,String> map) {
	return given()
	 .queryParams(map)
	 .log()
	 .all()
    .when()
    .get("/incident");

}

public IncidentServices getincidentByquery(Map<String,String> map) {
	response=GetIncidentByquery(map);
	return this;
}
public String getresponse() {
	   return response.body().asPrettyString();
	
}



public IncidentServices getincident(String sys_id) {
	response=GetSingleIncident(sys_id);
	return this;
}

public IncidentServices create(CreateIncident payload) {
	response = createincident(payload);
	root=response.as(Root.class);
	return this;
}
public IncidentServices createcall(CreateIncident payload) {
	response = createincident(payload);
	rootcaller=response.as(Rootcaller.class);
	return this;
}


public IncidentServices create(String payload) {
	response = createincident(payload);
	return this;
}
public IncidentServices create(File file) {
	response = createincident(file);
	return this;
}
public IncidentServices validateStatusCode(int statuscode) {
    assertThat(response.getStatusCode(),equalTo(statuscode));
    return this ;
	
}
public IncidentServices validateShortdescription(String shrtdesc) {
	if(root!=null) {
    assertThat(root.getResult().getShort_description(),equalTo(shrtdesc));
	}else{
	    assertThat(rootcaller.getResult().getShort_description(),equalTo(shrtdesc));

	}
    return this ;
	
}
public IncidentServices validatedescription(String desc) {
	if(root!=null) {
    assertThat(root.getResult().getDescription(),equalTo(desc));
	}else {
	    assertThat(rootcaller.getResult().getDescription(),equalTo(desc));

	}
    return this ;
	
}
	

public IncidentServices validatecalleridvalue(String value) {
    assertThat(rootcaller.getResult().getCaller_id().getValue(),equalTo(value));
    return this ;
	
}



public IncidentServices validateStatusLine(String statusline) {
    assertThat(response.getStatusLine(),containsString(statusline));
    return this ;
	
}
public IncidentServices validatecontentType(String content) {
    assertThat(response.getContentType(),containsString(content));
    return this ;
	
}
public  String GetSysId(String sysid) {
   return response.body().jsonPath().getString(sysid);
	
}






}
