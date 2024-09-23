package com.matschie.test.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class ChangerequestTestCucumber {
	@CucumberOptions (
			
			 features= {"src/test/java/com/matshie/servicenow/features/Servicenow.feature"},

			 glue={"com.matshie.servicenow.stepdefinition"},
					 dryRun=false,
					 plugin= {
			        		  "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
			        		  
			        		  }
		)
		            
		public class IncidentServiceTestCucumber extends AbstractTestNGCucumberTests {
			
		}

}
