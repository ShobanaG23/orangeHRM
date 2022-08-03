package com.orangehrm.pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	//step 1
	public WebDriver driver;
	public Logger logger =  LogManager.getLogger(this.getClass());
	
	//step 2 constructor
	public DashboardPage(WebDriver driver){
	this.driver = driver;
	PageFactory.initElements(driver, this);
		
	}
	//step 3 locators
	@FindBy (partialLinkText = "Dashboard")
	WebElement lnkDashBoard;
	
	//step 4 method
	public boolean dashBoardDisplayed() {
		boolean status = lnkDashBoard.isDisplayed();
		logger.info("status of dashboard: " +status);
		if (status == true) {
			logger.info("Dashboard link is displayed");
		}else {
			logger.info("Dashboard link is not present");
		}
		
	return status;
	}
	
	
}
