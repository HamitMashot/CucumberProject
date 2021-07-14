package com.cucumber.utilities;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeleniumGlobalLibrary {

	final static Logger logger = Logger.getLogger(SeleniumGlobalLibrary.class);

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver _driver) {
		if (_driver != null) {
			this.driver = _driver;
		}
	}

	public SeleniumGlobalLibrary() {

	}

	// Custom Constructor
	public SeleniumGlobalLibrary(WebDriver _driver) {
		driver = _driver;
	}

	public void moveMouseToElement(By by) {
		try {
			Actions actin = new Actions(driver);
			WebElement element = driver.findElement(by);
			actin.moveToElement(element).build().perform();
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}
	
	public void clickButton(By by) {
		try {
			WebElement element = driver.findElement(by);
			element.click();
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}
	
	
	public void clickHiddenElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}
	
	
	public void clickText(By by) {
		try {
			WebElement element = driver.findElement(by);
			element.click();
		} catch (Exception e) {
			logger.error("Error: ", e);
			assertTrue(false);
		}
	}
	
	
	

}
