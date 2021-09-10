package com.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Doctors {
	WebDriver driver;
	private By doctors_click   = By.xpath("//*[@id='sidebar']/div/nav/ul/li[2]/a/div/div[2]");
	private By docSpecif       = By.xpath("//*[@id='sidebar']/div/nav/ul/li[2]/ul/li[1]/a");
	private By specName        = By.cssSelector("input[name='doctorspecilization']");
	private By submit_btn      = By.cssSelector("button[name='submit']");
	private By confirm_add     = By.xpath("//*[@id='container']/div/div[1]/div[1]/div/div/div/div[2]/p");
	private By click_addDoctor = By.xpath("//*[@id='sidebar']/div/nav/ul/li[2]/ul/li[2]/a");
	private By drpdown         = By.cssSelector("select[name='Doctorspecialization']");
	private By doc_name        = By.name("docname");
	private By doc_address     = By.name("clinicaddress");
	private By doc_fees        = By.name("docfees");
	private By doc_contact     = By.name("doccontact");
	private By doc_email       = By.name("docemail");
	private By doc_pass        = By.name("npass");
	private By doc_confirmPass = By.name("cfpass");
	private By doc_submitBtn   = By.id("submit");
	
	Doctors(WebDriver driver){
		this.driver=driver; 
		driver.findElement(doctors_click).click();
	}
	
	public void doctorSpecification() {
		driver.findElement(docSpecif).click();	
		driver.findElement(specName).sendKeys("Cardiology");
		driver.findElement(submit_btn).click();
		String added =driver.findElement(confirm_add).getText(); 
		Assert.assertEquals(added, "Doctor Specialization added successfully !!");
		
	}
	
	void add_doctor() {
		  driver.findElement(click_addDoctor).click();
		  Select drpSpecial = new Select(driver.findElement(drpdown));
		  drpSpecial.selectByVisibleText("Cardiology");
		  driver.findElement(doc_name).sendKeys("Santhosh");
		  driver.findElement(doc_address).sendKeys("Karnataka India");
		  driver.findElement(doc_fees).sendKeys("100");
		  driver.findElement(doc_contact).sendKeys("985674231");
		  driver.findElement(doc_email).sendKeys("santosh@gmail.com");
		  driver.findElement(doc_pass).sendKeys("Santosh123");
		  driver.findElement(doc_confirmPass).sendKeys("Santosh123");
		  driver.findElement(doc_submitBtn).click();
		  Alert alert = driver.switchTo().alert();
		  alert.accept();
	  }
	
	 void delete_doctor
	

}
