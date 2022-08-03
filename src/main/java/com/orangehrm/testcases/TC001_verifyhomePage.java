package com.orangehrm.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.pageObjects.homePage;
import com.orangehrm.testBase.BaseClass;

public class TC001_verifyhomePage extends BaseClass {

	@Test
	public void verifyHomePageTitleTestCase() throws IOException {
		
		homePage hp = new homePage(driver);
		
		
		logger.info("the displayed url is : " + driver.getCurrentUrl());
		String actTitle = driver.getTitle();
		logger.info("title of the page is :"+actTitle);
		
				
		if (actTitle.equalsIgnoreCase("orangeHRM")) {
				
			logger.info("orange hrm  application is opened");
		}
		else
		{
			logger.info("orange hrm application is not opened");
		}
		captureScreenshot(driver, "verifyHomePageTitleTestCase");
	}
}
