package com.tests;

import org.testng.annotations.Test;

import com.fileHandle.PropertyReader;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AUT {
	
	String baseUrl=null;
	String expectedTitle= null;
	String browserType=null;
	WebDriver driver=null;
	String currentUrl;
	Admin admin_object;
	
  @Test
  public void f() throws InterruptedException {
	  admin_object=new Admin(driver);
	  admin_object.loginAdmin();
	  String loginUserName=admin_object.getLoginUserName();
	  Assert.assertTrue(loginUserName.contains("Admin"));
	  admin_object.add_doctorSpecification();
	  admin_object.add_doctor();
  }
  
  
  
  
  @BeforeMethod
  public void beforeMethod() {
	  	
	  	String browserType=PropertyReader.getProperty("browser");
		String DriverPath=PropertyReader.getProperty("chromeDriverPath");
		System.setProperty("webdriver.chrome.driver", DriverPath);
		driver=new ChromeDriver();
		driver.get(PropertyReader.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
