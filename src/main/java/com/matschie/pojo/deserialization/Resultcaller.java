package com.matschie.pojo.deserialization;

public class Resultcaller {
private callerID caller_id;
private String short_description;
public String getShort_description() {
	return short_description;
}

public void setShort_description(String short_description) {
	this.short_description = short_description;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

private String description;


public callerID getCaller_id() {
	return caller_id;
}

public void setCaller_id(callerID caller_id) {
	this.caller_id = caller_id;
}

}
