package com.testscript;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
		
		
	}
	
	@Test(priority=2)
	public void invalidLoginTest() {
		driver.navigate().back();
		driver.navigate().refresh();
		login.loginWithInvalidCredentials("gjhjh", "hvhbnb");
	}
	
	@Test(priority=3)
	public void emptyLoginTest() {
		login.loginwithemptyCredentials();
	}
	
	@Test(priority=4)
	public void emptyUsernameTest()
	{
		driver.navigate().refresh();
		login.loginWithEmptyUsername("secret_sauce");
	}
	
	@Test(priority=5)
	public void emptypassowordTest() throws InterruptedException
	{
		driver.navigate().refresh();
		login.loginWithEmptyPassword("standard_user");
	}
		
	
	
//	

}
