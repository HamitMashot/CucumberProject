package com.cucumber.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;


public class Base {
	
	
final static Logger logger = Logger.getLogger(Base.class);
	
	public static SeleniumGlobalLibrary selLib;
	public static WebDriver driver;
	

	@BeforeClass	
	public void beforeAllTestMethods() {
		logger.info("Automated Test Started ...");
		
	}
	
	@BeforeMethod
	public void setUp(ITestResult result) {
		logger.info("Test Libraries Method.");
		selLib = new SeleniumGlobalLibrary();
	}

}
