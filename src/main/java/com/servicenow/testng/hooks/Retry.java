package com.servicenow.testng.hooks;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.matschie.general.utils.PropertiesHandler;

public class Retry implements IRetryAnalyzer {
	int counter=0;
	public boolean retry(ITestResult result) {
		if(counter<Integer.parseInt(PropertiesHandler.config("matchie.retry.max.limit")));{
		counter++;
		return true;
	
	}

}
}
