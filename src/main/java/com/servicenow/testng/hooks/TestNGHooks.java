package com.servicenow.testng.hooks;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.matschie.data.utils.DataEngine;
import com.matschie.data.utils.DataFactory;

import static com.matschie.general.utils.PropertiesHandler.*;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.basePath;


public class TestNGHooks {
@BeforeMethod
public void setUp() {
  baseURI=config("service.now.instance.uri");
  basePath=config("service.now.instance.basePath");
  authentication=basic(config("service.now.instance.username"),config("service.now.password"));
 

}
@DataProvider(name="excel")
public String[][] getdataexcel(){
	return DataFactory.engine(DataEngine.EXCEL).getData("create-incident");
}
@DataProvider(name="csv")
public String[][] getdatacsv(){
	return DataFactory.engine(DataEngine.CSV).getData("incident CSV");
}

}
