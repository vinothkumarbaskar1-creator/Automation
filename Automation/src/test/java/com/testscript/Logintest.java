package com.testscript;


import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.pages.Locaters;

import Base.Baseurl;

public class Logintest extends Baseurl {
	
	
	Locaters login;
	
	@BeforeMethod
	public void init() {
		login=new Locaters(driver);
	}
	
		@Test(priority=1)
		public void validLoginTest() {
			login.enterValidCredentials("standard_user", "secret_sauce");
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
		    wait.until(ExpectedConditions.urlContains("inventory"));
		    
		    ExtentTest test = extent.createTest("Valid Login Test");
		    test.pass("Login successful with valid credentials");
		
		
	}
	
	@Test(priority=2)
	public void invalidLoginTest() {
		
		driver.navigate().refresh();
		login.loginWithInvalidCredentials("gjhjh", "hvhbnb");
		 ExtentTest test = extent.createTest("Invalid Login Test");
		 test.pass("Login failed with invalid credentials");

	}
	
	@Test(priority=3)
	public void emptyLoginTest() {
		login.loginwithemptyCredentials();
		ExtentTest test = extent.createTest("Empty Login Test");
		test.pass("Login failed with empty credentials");
	
	}
	
	@Test(priority=4)
	public void emptyUsernameTest()
	{
		driver.navigate().refresh();
		login.loginWithEmptyUsername("secret_sauce");
		ExtentTest test = extent.createTest("Empty Username Test");
		test.pass("Login failed with empty username");
	
	}
	
	@Test(priority=5)
	public void emptypassowordTest() throws InterruptedException
	{
		driver.navigate().refresh();
		login.loginWithEmptyPassword("standard_user");
		ExtentTest test = extent.createTest("Empty Passoword Test");
		test.pass("Login failed with empty passoword");
	}
	
//	@AfterClass
//	public void reportflush() {
//		extent.flush();
//	}
		
	
	
//	

}
