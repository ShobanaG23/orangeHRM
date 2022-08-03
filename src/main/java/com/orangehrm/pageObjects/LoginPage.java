package com.orangehrm.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//step 1
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(this.getClass());
	
	//step 2 create constructor
	public LoginPage(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//step 3 locators
	
	@FindBy(xpath = "//input[@id ='txtUsername']")
	WebElement ValUsername;
	
	@FindBy(xpath = "//input[@id ='txtPassword']")
	WebElement Valpassword;
	
	@FindBy (xpath = "//input[@id ='btnLogin']")
	WebElement btnLogin;
	
	//step 4 method for entering values
	public void enterUserName(String uname) {
		
		ValUsername.clear();
		ValUsername.sendKeys(uname);
		String expUsername = ValUsername.getAttribute("value");
		
		logger.info("value entered in username field is "+expUsername);
		
	}

	
	public void enterPassword(String pwd) {
		
		Valpassword.clear();
		Valpassword.sendKeys(pwd);
		String expPassword = Valpassword.getAttribute("value");
		
		logger.info("value entered in password field is :"+expPassword );
		
	}
	
	public void clickLoginbtn() {
		
		boolean status = btnLogin.isEnabled();
		if(status == true) {
			
		btnLogin.click();
		logger.info("login button is enabled and so it is clicked");
		} else {
		logger.info("login button is disabled and so its not clicked");
		}
	}



}

