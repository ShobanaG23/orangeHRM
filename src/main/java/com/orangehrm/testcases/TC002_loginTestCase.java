package com.orangehrm.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pageObjects.DashboardPage;
import com.orangehrm.pageObjects.LoginPage;
import com.orangehrm.testBase.BaseClass;

public class TC002_loginTestCase extends BaseClass{
	
	
	@Test
	public void loginTestCase() throws InterruptedException, IOException {
		
		LoginPage lp = new LoginPage(driver);
	

		Thread.sleep(5000);
		lp.enterUserName(prop.getProperty("username"));
		logger.info("username is entered");
		
		lp.enterPassword(prop.getProperty("password"));
		logger.info("password is entered ");
		
		lp.clickLoginbtn();
		logger.info("login button is clicked");
		
		DashboardPage dp = new DashboardPage(driver);
		
		captureScreenshot(driver, "loginTestCase");
		
		boolean val = dp.dashBoardDisplayed();
		Assert.assertEquals(val,  true,"dashboard link is not displayed");
		logger.info("dashboard link is displayed");
		
		String aTitle = driver.getTitle();
		logger.info("the title displayed after login is: "+aTitle );
		
	
	}

}
