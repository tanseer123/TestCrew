package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fileHandle.PropertyReader;

public class Admin {

	WebDriver driver;
	private By adminClick=By.cssSelector("a[href='hms/admin']");
	private By userField = By.name("username");
	private By passwordField = By.name("password");
	private By titleText =By.className("barone");
	private By login = By.xpath("//button[@name='submit']");
	private By loggedInAs=By.cssSelector(".username");
	private String userName=PropertyReader.getProperty("adminUserName");
	private String pass=PropertyReader.getProperty("adminPass");
	private Doctors doctor;
	
   
    public Admin(WebDriver driver){
        this.driver = driver;
        driver.findElement(adminClick).click();
        
    }

   
    public void setUserName(String strUserName){

    	driver.findElement(userField).sendKeys(userName);
    }

    public void setPassword(String strPassword){

    	driver.findElement(passwordField).sendKeys(pass);

    }

    public void clickLogin(){

    	driver.findElement(login).click();

    }

	public void loginAdmin() {
		this.setUserName(userName);
        this.setPassword(pass);
        this.clickLogin();    
	}
	public String getLoginUserName() {
		
		return driver.findElement(loggedInAs).getText();
		
	}
	
	
	public void add_doctorSpecification() {		
		doctor=new Doctors(driver);
		doctor.doctorSpecification();
	}
	
	public void add_doctor() {
		doctor =new Doctors(driver);
		doctor.add_doctor();
	}
	
	
}
