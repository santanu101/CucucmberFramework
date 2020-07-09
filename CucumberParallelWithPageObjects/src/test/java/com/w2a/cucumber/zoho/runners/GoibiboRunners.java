package com.w2a.cucumber.zoho.runners;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		features="src/test/resources/features/goibibo.feature",
		glue="com.w2a.cucumber.zoho.steps"
		
		)



public class GoibiboRunners {
	
	
	@Test
	public void runCukes() {
		
		new TestNGCucumberRunner(getClass()).runCukes();
		
	}

}
