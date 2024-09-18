package com.servicenow.testng.hooks;

import org.testng.annotations.BeforeMethod;


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


}
