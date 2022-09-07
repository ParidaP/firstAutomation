package com.jqueryui.test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestingJquery {

	private String url = "https://jqueryui.com/";
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\parid\\Week1\\MyFirstAutomation\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			Thread.sleep(5 * 1000);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
			driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(60));
			driver.manage().window().maximize();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void cleanUp() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}
	@Test
	public void JqueryhomePageTest() {

		
try {

	         driver.get("https://jqueryui.com/");
			// step1 : locating draggable element
			WebElement draggbleLink = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[1]/a"));
			draggbleLink.click();
			
			System.out.println("open url : jqueryui....");

			// step2: locating the Drang me Around element
			
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
			WebElement draggmeAround = driver.findElement(By.xpath("//p[normalize-space()='Drag me around']"));
			//click and hold  Action
			Actions act = new Actions(driver);
			act.clickAndHold(draggmeAround).perform();

	        //Thread.sleep(5 * 1000);	
			System.out.println("Drag me around clicked and hold ...");
			
	   }catch (Exception e) {
		  e.printStackTrace();
	}
}
				 @Test
			    public void clickDroppable () {     // Mouehover to Droppabale link and click 
					 try {
		  driver.get("https://jqueryui.com/");
          WebElement droppableLink = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[2]/a"));
          Actions act = new Actions(driver);
          act.moveToElement(droppableLink).perform();
          System.out.println("done mouse hover on droppable link");
       
          droppableLink.click();
          
          driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
          WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggable']"));
          WebElement dropHere = driver.findElement(By.xpath("//div[@id='droppable']"));
         
          // Mouse hover over to Drag me to targer and perform drag and drop action 
          act.moveToElement(dragMe).dragAndDrop(dragMe, dropHere).perform();
           System.out.println("item draged and dropped!!! ");
           
					 }catch (Exception e) {
							e.printStackTrace();}
				 }
    
				
			

}
