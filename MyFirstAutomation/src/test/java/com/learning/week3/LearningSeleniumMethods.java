package com.learning.week3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LearningSeleniumMethods {

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

	@Test (enabled = false)
	public void learningStringTrim() {
		String a = "I love Java programming !";
		String b = "   I love Java programming !   ";
		String c = "   I   love Java   programing !   ";
		
		System.out.println("Before Trim ----------------------");
		System.out.println("a: [" + a + "]");
		System.out.println("b: [" + b + "]");
		System.out.println("c: [" + c + "]");
		System.out.println(" ");
		
		System.out.println("After Trim ----------------------");
		System.out.println("a: [" + a.trim() + "]");
		System.out.println("b: [" + b.trim() + "]");
		System.out.println("c: [" + c.trim() + "]");
	}
	
	
	
	@Test (enabled = true)
	public void findAllLinks() {
		// task1: find all the links in Amazon.com
		driver.get("https://www.amazon.com/");

		String pageTitle = driver.getTitle();
		System.out.println("Website Title is: [ " + pageTitle + " ]");

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int linkNum = allLinks.size();
		
		
		// task2: find all the links with text (links not hidden)
		
		List<WebElement> linksWithTexts = new ArrayList<WebElement>();
		Map<Integer,WebElement> myMap = new HashMap<Integer, WebElement>();
		
		
		int counter = 1;
		for(WebElement aLink : allLinks) {
			String linkText = aLink.getText().trim();
			if(linkText.length() > 0) {
				//link with no text block of code
				System.out.println(counter + ") link with Text: [" + linkText + "]");
				linksWithTexts.add(aLink);
			} else {
				// link with no text block of code
				
				  myMap.put(counter, aLink);  
			}
			
			counter ++;  // counter = counter +1; 
		}
		
		
		// task3: find all the links with no text (hidden links)
		int totalLinkNoText = myMap.size();
         for(Entry<Integer,WebElement> set : myMap.entrySet()) {
        	  System.out.println("Link Number -" + set.getKey()+ ", ["+ set.getValue().getText() + "]");
         }
		System.out.println("Total link with no text :" + totalLinkNoText);
		System.out.println("Total All Links: " + linkNum);
		System.out.println("Total link with text:" + linksWithTexts.size());
	}
	
	///Task4: verify the links that are working or not
	/*
	 * 1) Need to come up with test steps
	 *   - you need to click each link
	 *   - scenario 1: nothing happens ---- mark the link as bad / broken link
	 *                 doesn't require to go back to amazon home page
	 *   - scenario 2: same window/browser with navigate or change into another web -site page 
	 *                 - get the title of the new page
	 *                 - check if page title contains "404" than mark the link as bad/broken
	 *                 -else --- it's a good /working link
	 *                 -Need to go back to the amazon home page
	 *                 
	 *                 
	 *  - Scenario 3: new browser / window tab will open, than displays new webPages
	 *                - first switch driver window focus using "WindowHandles"
	 *                - get the title of the new page
	 *                 - check if page title contains "404" than mark the link as bad/broken
	 *                 -else --- it's a good /working link
	 *                 - Need to close the latest opened browser/window tab
	 *                 -switch back to the original browser/ window tab
	 *                 - make sure  the website displaying amazon.com home page
	 *                 
	 *   - maybe there is more possible scenario 4 or 5 (Need to confirm by writing the code for above steps and executing them)
	 *                      - Not known at this time, will need to figure it out after the code for above steps
	 * 
	 * 
	 */
	
	
}