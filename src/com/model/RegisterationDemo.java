package com.model;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class RegisterationDemo {
	
	WebDriver driver;
	
	Properties prakash=new Properties();
	Properties vikash=new Properties();
	
	
  @Test(priority=1)
  public void userOne() throws IOException {
FileInputStream fis=new FileInputStream("E:\\CJC Eclipse  Projects\\MercuryTourPropertiesDemo\\parameter.properties");	  
	  prakash.load(fis);
driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(prakash.getProperty("Firstname"));
driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(prakash.getProperty("Lastname"));
driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(prakash.getProperty("Phone"));
driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(prakash.getProperty("Email"));
driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(prakash.getProperty("Address"));
driver.findElement(By.xpath("//input[@name='city']")).sendKeys(prakash.getProperty("City"));
driver.findElement(By.xpath("//input[@name='state']")).sendKeys(prakash.getProperty("State"));
driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(prakash.getProperty("Postalcode"));
driver.findElement(By.xpath("//select[@name='country']")).sendKeys(prakash.getProperty("Country"));
driver.findElement(By.xpath("//input[@name='email']")).sendKeys(prakash.getProperty("Username"));
driver.findElement(By.xpath("//input[@name='password']")).sendKeys(prakash.getProperty("Password"));
driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(prakash.getProperty("Confirmpassword"));
driver.findElement(By.xpath("//input[@name='register']")).click();
	  
  }
  
  @Test(priority=2)
  public  void userTwo() throws IOException
  {
	  
	  FileInputStream fis1=new FileInputStream("E:\\CJC Eclipse  Projects\\MercuryTourPropertiesDemo\\parameter1.properties");
	  vikash.load(fis1);
	  driver.findElement(By.linkText("REGISTER")).click();
	  driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(vikash.getProperty("Firstname"));
	  driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(vikash.getProperty("Lastname"));
	  driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(vikash.getProperty("Phone"));
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(vikash.getProperty("Email"));
	  driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(vikash.getProperty("Address"));
	  driver.findElement(By.xpath("//input[@name='city']")).sendKeys(vikash.getProperty("City"));
	  driver.findElement(By.xpath("//input[@name='state']")).sendKeys(vikash.getProperty("State"));
	  driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(vikash.getProperty("Postalcode"));
	  driver.findElement(By.xpath("//select[@name='country']")).sendKeys(vikash.getProperty("Country"));
	  driver.findElement(By.xpath("//input[@name='email']")).sendKeys(vikash.getProperty("Username"));
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys(vikash.getProperty("Password"));
	  driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(vikash.getProperty("Confirmpassword"));
	  driver.findElement(By.xpath("//input[@name='register']")).click();
	  
	  
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void captureScreenShot() throws IOException {
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFileToDirectory(src, new File("E:\\CJC Eclipse  Projects\\MercuryTourPropertiesDemo\\ScreenShots\\"));
	  System.out.println("ScreenShot is captured successfully");
  }

  @BeforeClass
  public void maximizeBrowser() {
	  driver.manage().window().maximize();
	  driver.findElement(By.linkText("REGISTER")).click();
	  
  }

  @AfterClass
  public void deleteCookies() {
	  driver.manage().deleteAllCookies();
  }

  @BeforeTest
  public void openUrl() {
	  
	  driver.get("http://newtours.demoaut.com/mercurywelcome.php");
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void openBrowser() {
	System.setProperty("webdriver.chrome.driver", "F:\\CJC 12-9-2019\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	
	  
	  
  }

  @AfterSuite
  public void closeBrowser() {
	  driver.quit();
  }

}
