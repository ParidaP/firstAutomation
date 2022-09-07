package com.learning.week3;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutomationTests {
	@BeforeMethod
 public void setUp() {
		//prepare up test environment before each test, like open browser
	 System.out.println(" Setting up Test Environment ... ");
 }
	
	@AfterMethod
	public void tearDown() {
		//clean up test environment after each test, like close browser
		System.out.println("Cleaning up Test Environment ... ");
		
	}
   @Test (priority =1, groups = {"SmokeTests","RegressionTest"})
	public void myTest1() {
		System.out.println("Running TestMethod 1 ...");
		
	}
@Test (priority = 2, enabled= false, groups = {"RegressionTest"})
	public void myTest3() {
		System.out.println("Running TestMethod 3 ...");
		
	}
	@Test (priority = 3,groups = {"SmokeTests","RegressionTest"})
	public void myTest4() {
		System.out.println("Running TestMethod 4 ...");
		
		
	}
	@Test(priority = 4, groups = {"RegressionTest"})
	
	public void myTest2() {
		System.out.println("Running TestMethod 2 ...");
		
	}
}
