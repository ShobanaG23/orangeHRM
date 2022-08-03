package com.orangehrm.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public Logger logger = LogManager.getLogger(this.getClass());
	public Properties prop;
	
	@BeforeClass
	@Parameters("browserName")
	public void setup(String Br) throws IOException, InterruptedException {
		
				
		if (Br.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			logger.info(Br+" browser is launched succesfully");
			
		} else if (Br.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			logger.info(Br+" browser is launched succesfully");

		} else if (Br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			logger.info(Br+" browser is launched succesfully");
		} else {
			logger.info("please specify browser name as edge or chrome or firefox");
		}
		
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\rarav\\eclipse-workspace\\orangehrm\\resources\\config.properties");
		prop.load(fis);
		
		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);
		logger.info("the url is entered and opening" );
		
		
	}
	
	
	@AfterClass
	public void teardown() {
		driver.quit();
		logger.info("successfuly closed the browser");
	}
	
	
	
	public void captureScreenshot(WebDriver driver, String testName) throws IOException {
		
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("use.dir")+"\\screenshots\\"+testName+".png");
		
	FileUtils.copyFile(source , target);
	logger.info("screenshots captured successfully");
	
	}
	
}
