package com.matschie.pojo.serialization;

public class CreateIncident {
private String short_description;
private String description;
private String urgency;
private String state;
private String caller_id;


public String getCallerid() {
	return caller_id;
}
public void setCallerid(String callerid) {
	this.caller_id = callerid;
}
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
public String getUrgency() {
	return urgency;
}
public void setUrgency(String urgency) {
	this.urgency = urgency;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
}
