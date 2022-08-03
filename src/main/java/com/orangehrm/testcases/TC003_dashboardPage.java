package com.orangehrm.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.orangehrm.pageObjects.AdminPage;
import com.orangehrm.pageObjects.DashboardPage;
import com.orangehrm.pageObjects.LoginPage;
import com.orangehrm.testBase.BaseClass;

public class TC003_dashboardPage extends BaseClass{
	
	@Test
	public void moveInDashBoardPage() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		

		Thread.sleep(5000);
		lp.enterUserName(prop.getProperty("username"));
		logger.info("username is entered");
		
		lp.enterPassword(prop.getProperty("password"));
		logger.info("password is entered ");
		
		lp.clickLoginbtn();
		logger.info("login button is clicked");
		
		
		
		AdminPage ap =  new AdminPage(driver);
		
		ap.adminLink();
		
		ap.tableValues("california");
		captureScreenshot(driver, "moveInDashBoardPage");
	}

}
