package com.learning.week3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LearningSeleniumMethod2 {
	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		try {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
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
	public void seleniumMethodTests() {
		try {
			String url1 = "https://www.amazon.com/";
			String url2 = "https://www.walmart.com";

			driver.get(url1); // go to url-1
			Thread.sleep(2 * 1000);

			driver.navigate().to(url2); // re-navigate to the url2
			Thread.sleep(2 * 1000);

			driver.navigate().back(); // going back to the previous site
			Thread.sleep(2 * 1000);

			driver.navigate().forward(); // going forward to the new page
			Thread.sleep(2 * 1000);

			driver.navigate().refresh(); // refreshing the current web page
			Thread.sleep(2 * 1000);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test
	public void seleniumHoverOver() {

		try {
			String url = " https://www.usps.com/";
			driver.get(url);

			WebElement quickTelem = driver.findElement(By.linkText("Quick Tools"));
			highLightWebElement(quickTelem);
			Actions action = new Actions(driver);
			action.moveToElement(quickTelem).build().perform();

			Thread.sleep(5 * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    // knowledge : Method Overloading, Method Overriding
	/// helper method 
	// create a method to highlight the WebElement on the page that Selenium is interacting with
	
	public void highLightWebElement(WebElement element) {
		
		 WrapsDriver  wrappedElement = (WrapsDriver) element;
		 JavascriptExecutor js = (JavascriptExecutor) wrappedElement.getWrappedDriver();
		 js.executeScript("arguments[0].setAttribute('style', arguments[1];", element, "color : red; border: 2px solid yellow"); 
		 		
	}
	
	
	
}
