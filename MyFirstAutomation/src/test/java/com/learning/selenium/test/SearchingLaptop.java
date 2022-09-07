package com.learning.selenium.test;
// auto import or remove library  Ctrl+shift+o 
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchingLaptop {

	// class level variables or class instance variables
	public class SearchingLaptopTestCase {
		  private WebDriver driver;
		  private String baseUrl;
		  private boolean acceptNextAlert = true;
		  private StringBuffer verificationErrors = new StringBuffer();
		  private JavascriptExecutor js;

		  
		  //method don't return data 
		  public void myfirstMethod() {
			  
		  }
		  //method returns data in String type 
		  public String mySecondMethod() {
			  
			  String myString = null;
			  return myString;
		  }
		  
		  
		  @BeforeClass(alwaysRun = true)
		  public void setUp() throws Exception {
		   // System.setProperty("webdriver.chrome.driver", "");
		   // driver = new ChromeDriver();
		    
		    //Start Edge Chromium Browser 
		    System.setProperty("webdriver.edge.driver", "C:\\Users\\parid\\Week1\\MyFirstAutomation\\src\\test\\resources\\drivers");
		    driver = new EdgeDriver();
		    //pausing the code execution for 5 second
		    
		    Thread.sleep(5*1000);
		    
		    
		    baseUrl = "https://www.google.com/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    js = (JavascriptExecutor) driver;
		  }

		  @Test
		  public void testSearchingLaptopTestCase() throws Exception {
		    driver.get("https://www.google.com/");
		    driver.findElement(By.name("q")).clear();
		    driver.findElement(By.name("q")).sendKeys("laptop");
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='×'])[1]/following::span[11]")).click();
		    driver.findElement(By.xpath("//div[@id='rso']/div/div/div/div/div/a/h3")).click();
		    assertEquals(driver.getTitle(), "Laptops & Notebook Computers - Best Buy");
		    driver.findElement(By.xpath("//div[@id='pm-panel-59fcb3ee-057c-4800-b928-e79ed55be576']/div/div[2]")).click();
		    assertEquals(driver.getTitle(), "Laptops & Notebook Computers - Best Buy");
		  }

		  @AfterClass(alwaysRun = true)
		  public void tearDown() throws Exception {
		    driver.quit();
		    String verificationErrorString = verificationErrors.toString();
		    if (!"".equals(verificationErrorString)) {
		      fail(verificationErrorString);
		    }
		  }

		  private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }

		  private boolean isAlertPresent() {
		    try {
		      driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
		  }

		  private String closeAlertAndGetItsText() {
		    try {
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      if (acceptNextAlert) {
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alertText;
		    } finally {
		      acceptNextAlert = true;
		    }
		  }
	
} }
