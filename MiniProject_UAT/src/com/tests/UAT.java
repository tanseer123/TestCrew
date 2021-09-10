 package com.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import com.fileHandle.PropertyReader;


public class UAT {
	     
	String baseUrl=null;
	String expectedTitle= null;
	String browserType=null;
	WebDriver driver=null;
	String currentUrl;
  void add_doctor_specialization() throws InterruptedException {
	  driver.findElement(By.xpath("//*[@id='sidebar']/div/nav/ul/li[2]/a/div/div[2]/span")).click();
	  driver.findElement(By.xpath("//*[@id='sidebar']/div/nav/ul/li[2]/ul/li[1]/a")).click();
	  driver.findElement(By.cssSelector("input[name='doctorspecilization']")).sendKeys("Cardiology");;
	  driver.findElement(By.cssSelector("button[name='submit']")).click();
	  String added =driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div[1]/div/div/div/div[2]/p")).getText(); 
	  Assert.assertEquals(added, "Doctor Specialization added successfully !!");
	  
  }
  
  void add_doctor() throws InterruptedException {
	  //driver.findElement(By.xpath("//*[@id='sidebar']/div/nav/ul/li[2]/a/div/div[2]")).click();
	  driver.findElement(By.xpath("//*[@id='sidebar']/div/nav/ul/li[2]/ul/li[2]/a")).click();
	  Select drpSpecial = new Select(driver.findElement(By.cssSelector("select[name='Doctorspecialization']")));
	  drpSpecial.selectByVisibleText("Cardiology");
	  driver.findElement(By.name("docname")).sendKeys("Santhosh");
	  driver.findElement(By.name("clinicaddress")).sendKeys("Karnataka India");
	  driver.findElement(By.name("docfees")).sendKeys("100");
	  driver.findElement(By.name("doccontact")).sendKeys("985674231");
	  driver.findElement(By.name("docemail")).sendKeys("santosh@gmail.com");
	  driver.findElement(By.name("npass")).sendKeys("Santosh123");
	  driver.findElement(By.name("cfpass")).sendKeys("Santosh123");
	  driver.findElement(By.id("submit")).click();
	  Alert alert = driver.switchTo().alert();
	  alert.accept();
  }
  
  void delete_doctor() {
	  driver.get(currentUrl);
	  driver.findElement(By.xpath("//*[@id='sidebar']/div/nav/ul/li[2]/a/div/div[2]/span")).click();
	  driver.findElement(By.xpath("//*[@id='sidebar']/div/nav/ul/li[2]/ul/li[3]/a")).click();
	  List<WebElement>  rows = driver.findElements(By.xpath("//*[@id='sample-table-1']/tbody/tr/td[3]"));
	  System.out.println(rows.size());
	  int count =0;
	  for(WebElement row:rows) {
		  count++;
		 String name=row.getText();
		  System.out.println(row.getText()); 
		 if(name.equals("Santhosh")) {
			 driver.findElement(By.xpath("//*[@id=\"sample-table-1\"]/tbody/tr["+count+"]/td[5]/div[1]/a[2]/i")).click();
			 Alert alert = driver.switchTo().alert();// Switching to alert popup		 
		        //String alertMessage= driver.switchTo().alert().getText();	// getting text present in alert dailogue box	
		        String alertMessage= alert.getText();	
		        System.out.println(alertMessage);	     
		        alert.dismiss();
		 }
		  
	  }
	  
	  
  }
  
  @Test
  public void Test() throws InterruptedException  {
//	  driver.get(PropertyReader.getProperty("url"));
//	  driver.findElement(By.cssSelector("a[href='hms/admin']")).click();
//	  driver.findElement(By.name("username")).sendKeys("admin");
//	  driver.findElement(By.name("password")).sendKeys("Test@12345");
//	  driver.findElement(By.xpath("//button[@name='submit']")).click();
//	  currentUrl=driver.getCurrentUrl();
//	 add_doctor_specialization();
//	 add_doctor();
//	 delete_doctor();
	 
	 /*
		 * Thread.sleep(1000); int count=0; List<String> l=new ArrayList();
		 * for(WebElement a:list) { l.add(a.getText()); } System.out.println(l);
		 * 
		 * for(WebElement each :list) { count++; String name =each.getText();
		 * if(name.equals("Doctors")) { WebElement temp=each; each.click();
		 * List<WebElement>
		 * sub_menu=temp.findElements(By.xpath("//*[@id='sidebar']/div/nav/ul/li["+count
		 * +"]/ul/li")); System.out.println(sub_menu.size()); int sub_count=0;
		 * for(WebElement a:sub_menu) { sub_count++; System.out.println(a.getText());
		 * a.click(); each.click(); } }
		 * 
		 * }
		 */
	  
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  	
	  	String browserType=PropertyReader.getProperty("browser");
		String DriverPath=PropertyReader.getProperty("chromeDriverPath");
		System.setProperty("webdriver.chrome.driver", DriverPath);
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
