package com.cucumber.setpdefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.pageobject.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Steps{
	
	
	public WebDriver driver;
	public LoginPage lp;

	final static Logger logger = Logger.getLogger(Steps.class);
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
		logger.info("starting 'Chrome' browser.");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		logger.info("Maximizing the browser.");
		driver.manage().window().maximize();
		
		lp = new LoginPage(driver );
		logger.info("User Launch Chrome browser .");
		
		
	}

	

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		logger.info("User opens URL 'https://www.amazon.com' .");
		lp.gotoAmazonWebsite(url);
		lp.checkHavinTlogin();
		
		
	}


	@And("User mouse move to Element {string}")
	public void user_mouse_move_to_element(String string) {
		logger.info("User mouse interactions.");
		lp.moveMouseToElement();  
	}

	

	@And("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String Email, String Password) throws InterruptedException{
		logger.info("User enters Email as 'masihuti.hamiti@menusifu.com' and Password as 'Menusifu@67886788'");
		lp.entersEmailAndPassword(Email, Password);
		
		
	   
	}

	
	@When("Click on Login")
	public void click_on_login() {
		logger.info("click on login");
		lp.checklogin();  
	}
	
	

	
	@When("User click on Log out Link")
	public void user_click_on_log_out_link() throws InterruptedException {
		logger.info("click on log out link.");
		lp.clickLogOut();   
	}

	
	@Then("Page Title should be {string}")
	public void page_title_should_be(String string) {
		logger.info("Page Title should be 'Amazon Sign-In'.");
		lp.checkLouOutWebTitle();
	    
	}
	

	@Then("close browser")
	public void close_browser() {
		logger.info("User clean Up After All Test Methods.");
		lp.cleanUpAfterAllTestMethods();
	   
	}

	


}
