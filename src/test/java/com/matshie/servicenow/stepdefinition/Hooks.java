package com.matshie.servicenow.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {
@Before
public void beforescenario(Scenario scenario) {
	System.out.println("Before running the scenario"+scenario.getName());
}
@After
public void afterscenario(Scenario scenario) {
	System.out.println("After running the scenario"+scenario.getName());

}
@BeforeStep
public void beforestep() {
	System.out.println("Before each step in scenario");

}
@AfterStep
public void afterstep() {
	System.out.println("After each step in scenario");

}
}
