package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkoutinfo {
	
	WebDriver driver;
	
	By Firstname=By.id("first-name");
	By Lastname=By.id("last-name");
	By pincode=By.id("postal-code");
	By continuebtn=By.id("continue");
	By cancelbtn=By.id("cancel");
	
	public Checkoutinfo(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void validInfo(String fname, String lname, String pinnum)
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.urlContains("checkout-step-one"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Firstname)).sendKeys(fname);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Lastname)).sendKeys(lname);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(pincode)).sendKeys(pinnum);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(continuebtn)).click();
	}
	
	public void withoutfname(String lname,String pinnum)
	{
		driver.navigate().back();
		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Firstname)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Lastname)).sendKeys(lname);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pincode)).sendKeys(pinnum);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(continuebtn)).click();
		
	}
	
	public void withoutlname(String fname,String pinnum)
	{
		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Firstname)).sendKeys(fname);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Lastname)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(pincode)).sendKeys(pinnum);
		wait.until(ExpectedConditions.visibilityOfElementLocated(continuebtn));
	}
	
	public void withoutpincode(String fname, String lname)
	{
		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Firstname)).sendKeys(fname);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Lastname)).sendKeys(lname);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(continuebtn));
		
	}
	
	

}
