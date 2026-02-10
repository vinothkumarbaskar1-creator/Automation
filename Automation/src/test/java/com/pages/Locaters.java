package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locaters {
	
	private WebDriver driver;
	
	By usernameinput=By.xpath("//input[@id='user-name']");
	By passwordinput=By.xpath("//input[@id='password']");
	By loginbutton=By.xpath("//input[@id='login-button']");
	
	public Locaters(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterValidCredentials(String username, String password) {
		driver.findElement(usernameinput).sendKeys(username);
		driver.findElement(passwordinput).sendKeys(password);
		driver.findElement(loginbutton).click();
		
		
		
		
	}
	
	public void loginWithInvalidCredentials(String username, String password)
	{
		driver.navigate().back();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    wait.until(ExpectedConditions.visibilityOfElementLocated(usernameinput))
	        .sendKeys(username);

	    wait.until(ExpectedConditions.visibilityOfElementLocated(passwordinput))
	        .sendKeys(password);

	    wait.until(ExpectedConditions.elementToBeClickable(loginbutton))
	        .click();
	}
	
	public void loginwithemptyCredentials()
	{
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameinput)).clear();

    wait.until(ExpectedConditions.visibilityOfElementLocated(passwordinput)).clear();
		wait.until(ExpectedConditions.elementToBeClickable(loginbutton)).click();
        
	}
	
	public void loginWithEmptyUsername(String password)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(passwordinput)).clear();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordinput))
        .sendKeys(password);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(usernameinput)).clear();
		
		wait.until(ExpectedConditions.elementToBeClickable(loginbutton)).click();
		
		 wait.until(ExpectedConditions.visibilityOfElementLocated(passwordinput)).clear();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(usernameinput)).clear();
		 
	}
	
	public void loginWithEmptyPassword(String username) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(25));
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		 wait.until(ExpectedConditions.visibilityOfElementLocated(usernameinput))
	        .sendKeys(username);
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(loginbutton)).click();
	}
	

}
