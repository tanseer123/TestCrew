package com.HMS.Tests;
import org.testng.annotations.Test;

import com.HMS.pages.Admin;
import com.HMS.pages.Doctors;
import com.fileHandle.PropertyReader;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class NewTest {
	
	String baseUrl=null;
	String expectedTitle= null;
	String browserType=null;
	WebDriver driver=null;
	String currentUrl;
	Admin admin_object;
	Doctors doctor_obj;
  @Test
  public void f() throws InterruptedException {
	  admin_object=new Admin(driver);
	  admin_object.loginAdmin();
	  String loginUserName=admin_object.getLoginUserName();
	  Assert.assertTrue(loginUserName.contains("Admin"));
	  doctor_obj=new Doctors(driver);
	  doctor_obj.add_doctorSpecification();
	  Assert.assertTrue(loginUserName.contains("ADMIN | ADD DOCTOR SPECIALIZATION"));
	  doctor_obj.add_doctor();
	  Assert.assertTrue(loginUserName.contains("ADMIN | ADD DOCTOR"));
	  doctor_obj.delete_doctor();
	  Assert.assertTrue(loginUserName.contains("ADMIN | MANAGE DOCTORS"));
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
