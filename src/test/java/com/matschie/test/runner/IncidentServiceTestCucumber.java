package com.matschie.test.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
	
	 features= {"src/test/java/com/matshie/servicenow/features/IncidentService.feature"},
			// features= {"@src/test/resources/failedtest.txt"},

	 glue={"com.matshie.servicenow.stepdefinition"},
			 dryRun=false,
			 tags="@regression or @smoke",
			 plugin= {"pretty", "html:report/result.html",
	        		  "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
	        		  "rerun:src/test/resources/failedtest.txt"
	        		  }
)
            
public class IncidentServiceTestCucumber extends AbstractTestNGCucumberTests {
	
/*@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}*/
}

