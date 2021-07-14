package com.cucumber.testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
      (
    	features="src/test/resources/features/Login.feature",
    	glue="com.cucumber.setpdefinitions",
    	dryRun=false,
    	monochrome=true
    	//plugin= {"pretty","html:test-output"}
      )

public class TestRun {

}
