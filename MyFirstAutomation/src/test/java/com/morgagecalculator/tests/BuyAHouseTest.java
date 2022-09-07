package com.morgagecalculator.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BuyAHouseTest {
	
	private String url = "https://www.mortgagecalculator.net/";
    private WebDriver driver;
	@Test
	public void buyASingleHouseTest() {
    
		try {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		// start a Chrome browser
		 driver = new ChromeDriver();

		
		//Thread.sleep(10* 1000);
		// Maximize the browser window
		driver.manage().window().maximize();

		// Go to the website
		driver.get(url);

		

			// hard coded wait / pause
			Thread.sleep(7* 1000);

		
			
			
			// step1 : location mortgage amount text field
			WebElement amountTextElement = driver.findElement(By.id("amount"));
			
			amountTextElement.clear();
			amountTextElement.sendKeys("450000");
			
			Thread.sleep(7* 1000);
			//step2: locating amortization years
			WebElement amortYear = driver.findElement(By.cssSelector("#amortizationYears"));
			amortYear.clear();
			amortYear.sendKeys("29");
			
			Thread.sleep(3* 1000);
			//step2.1 locating amortization months
			WebElement amortMonth = driver.findElement(By.xpath("//*[@id='amortizationMonths']"));
			amortMonth.clear();
			amortMonth.sendKeys("12");
			Thread.sleep(3* 1000);
			//3. locating interest term years
			  WebElement interTerYear = driver.findElement(By.cssSelector("#interestTermYears"));
			  interTerYear.clear();
			  interTerYear.sendKeys("2");
			  Thread.sleep(3* 1000);
			//3. 1 locating interest term Months
			  WebElement interTerMonth = driver.findElement(By.id("interestTermMonths"));
			  interTerMonth.clear();
			  interTerMonth.sendKeys("5");
			  Thread.sleep(3* 1000);
			// step4. locating interest type drop-down
				WebElement inteTypeDropDown = driver.findElement(By.cssSelector("#interestType"));
				Select dropdown1 = new Select(inteTypeDropDown);
			    dropdown1.selectByVisibleText("Fixed");
			
			    Thread.sleep(3* 1000);
			    // step5. locating interest rate
			   WebElement intRateElem = driver.findElement(By.cssSelector(("#rate")));
			   intRateElem.clear();
			   intRateElem.sendKeys("3.0");
			   
			   // step 6: locating start month
			   WebElement startMo =driver.findElement(By.id("startMonth"));
			   Select dropdownMo =new Select(startMo);
			   dropdownMo.selectByIndex(1);
			   
			   Thread.sleep(3* 1000);
			// Step6.1: locating start year
				WebElement startYear = driver.findElement(By.id("startYear"));
				Select dropdownYear = new Select(startYear);
				dropdownYear.selectByValue("2023");
				
				Thread.sleep(3* 1000);
				// Step7: locating payment period
				WebElement paymentMode = driver.findElement(By.cssSelector("#paymentMode"));
				Select dropdownSemiMonthly = new Select(paymentMode);
				dropdownSemiMonthly.selectByVisibleText("Semi-Monthly");
				
				Thread.sleep(3* 1000);
				// Step8: locating calculate now button
				WebElement buttonElem = driver.findElement(By.id("button"));
				buttonElem.click();

				Thread.sleep(3 * 1000);
				// ExplicitWait
				//WebDriverWait wait = new WebDriverWait(driver, 30);
				//WebElement monthlyPaymentElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("summaryMonthly")));
System.out.println("step 9 begin");
				// Step9: locating the monthly payment and extract the amount text
				WebElement monthlyPaymentElem = driver.findElement(By.id("summaryMonthly"));
				String resultText = monthlyPaymentElem.getAttribute("value");
System.out.println("step9 finished");
				// String resultText = monthlyPaymentElem.getText();
				// System.out.println("Default monthly payment is: $1,073.64 ");
				System.out.println("Actual result monthly payment is: " + resultText);

				assertEquals(resultText, "$1,897.22");

				Thread.sleep(5 * 1000);

				// close the browser
				driver.close();
				driver.quit();

			} catch (Exception e) {
				e.printStackTrace();
				// we need to close the browser even if there is test step fails
				if (driver != null) {
					driver.close(); /// driver object is not null here and just close the browser only.
					driver.quit(); /// close the browser than program will terminate/kill the driver object than
									/// driver become "null"
				}
				assertEquals(true, false);
			}
		}

	}