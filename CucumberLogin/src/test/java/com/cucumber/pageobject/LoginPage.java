package com.cucumber.pageobject;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	WebDriver ldriver;
	final static Logger logger = Logger.getLogger(LoginPage.class);
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}

	public LoginPage gotoAmazonWebsite(String url) {
		ldriver.get(url);
		String websiteTitle = ldriver.getTitle();
		logger.info("website title is: " + websiteTitle);

		// Validating that we are on the right Website page
		String expectedTitle = "Amazon.com. Spend less. Smile more.";
		assertEquals(websiteTitle, expectedTitle);
		return this;
	}

    // mouse interactions ，Pop up login Window
	public LoginPage moveMouseToElement() {
		Actions actin = new Actions(ldriver);
		WebElement element = ldriver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		actin.moveToElement(element).build().perform();
		ldriver.findElement(By.cssSelector("#nav-flyout-ya-signin > a > span")).click();
		return this;
	}
	
	
	public LoginPage checkHavinTlogin() {
		WebElement loginSignText = ldriver.findElement(By.cssSelector("#nav-link-accountList-nav-line-1"));
		logger.info("no Login Sign Text :" + loginSignText.getAttribute("innerHTML"));
		String noLoginSignText = loginSignText.getAttribute("innerHTML");
		String expectedSignText = "Hello, Sign in";		
		assertEquals(noLoginSignText, expectedSignText);		
		return this;
	}
	
	
	public LoginPage entersEmailAndPassword(String Email, String Password) throws InterruptedException {
		WebElement inputEmail = ldriver.findElement(By.cssSelector("input[id='ap_email']"));
		inputEmail.sendKeys(Email);
		ldriver.findElement(By.xpath("//*[@id='continue']")).click();
		
		WebElement inputPassword = ldriver.findElement(By.cssSelector("input[id='ap_password']"));
		inputPassword.sendKeys(Password);
		ldriver.findElement(By.cssSelector("span[id='auth-signin-button']")).click();
		Thread.sleep(3000);
		return this;
	}
	
	
	public LoginPage checklogin() {
		WebElement loginSignText = ldriver.findElement(By.cssSelector("span[id='nav-link-accountList-nav-line-1']"));
		logger.info("check Login Sign Text :" + loginSignText.getAttribute("innerHTML"));
		String noLoginSignText = loginSignText.getAttribute("innerHTML");
		String expectedSignText = "Hello, Menusifu";		
		assertEquals(noLoginSignText, expectedSignText);		
		return this;
	}
		
	public LoginPage clickLogOut() throws InterruptedException {
		Actions actin = new Actions(ldriver);
		WebElement element = ldriver.findElement(By.cssSelector("#nav-link-accountList"));
		actin.moveToElement(element).build().perform();
		Thread.sleep(3000);
		ldriver.findElement(By.cssSelector("#nav-item-signout > span")).click();
		Thread.sleep(3000);
		return this;	
	}
		
	public LoginPage checkLouOutWebTitle() {
		
		String logOutwebsiteTitle = ldriver.getTitle();
		logger.info("website title is: " + logOutwebsiteTitle);

		//Validating that we are on the right website page
		String logOutexpectedTitle = "Amazon Sign-In";
		assertEquals(logOutwebsiteTitle, logOutexpectedTitle);
		return this;	
	}
	
	public LoginPage cleanUpAfterAllTestMethods() {
		logger.info("After Class ...");
		if (ldriver != null) {
			ldriver.close();
			ldriver.quit();	
		}
		return this;
	}

}
