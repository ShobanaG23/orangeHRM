package com.orangehrm.pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

	//step 1 
	public WebDriver driver;
	public Logger logger = LogManager.getLogger(this.getClass());
	
	//step 2 constructor
	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	//step 3 locators
	@FindBy(linkText = "Admin")
	WebElement lnkAdmin;
	
	@FindBy(linkText = "Organization")
	WebElement lnkOrganization;
	
	@FindBy(linkText = "Locations")
	WebElement lnkLocations;
	
	//step 4
	public void adminLink() {
		Actions actions = new Actions(driver);
		
		actions.moveToElement(lnkAdmin).build().perform();
		logger.info("moved to Admin link");
		
		actions.moveToElement(lnkOrganization).build().perform();
		logger.info("moved to organization link");
		
		actions.click(lnkLocations).build().perform();
		logger.info("clicked on locations link");
		
		
	}
	//getting value from locations table
	/*get values from table
	1.get number of rows
	2.get value from each row
	3.compare the value
	*/
	/*@FindBy(xpath = "//table[@id = 'resultTable']/tbody/tr/td[3]")
	WebElement lnktable;*/
	
	public void tableValues(String ExpVal) {
		
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id = 'resultTable']/tbody/tr/td[3]"));
		
		int rowSize = rows.size();
		
		logger.info("rows in the table is : " +rowSize);
		
		for(int i=0;i<rowSize;i++) {
			
		String val = rows.get(i).getText();
		logger.info("value in row is : "+val);
		
	
		if(val.equalsIgnoreCase(ExpVal)) {
			logger.info(ExpVal+ " exists");
			
		}else {
			logger.info(ExpVal+ " doesnot exists");
		}
		
		
		
	}
	
}
	
	
	
	
	
	
}
