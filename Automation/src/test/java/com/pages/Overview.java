package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Overview {
	
	private WebDriver driver;
	
	By Finishbtn=By.id("finish");
	By Cancelbtn=By.id("cancel");
	
	By Backbtn=By.id("back-to-products");
	
	By Menu=By.id("react-burger-menu-btn");
	By logout=By.id("logout_sidebar_link");
	
	public Overview(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickfinishbtn()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.urlContains("checkout-step-two"));
		WebElement finishbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(Finishbtn));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("arguments[0].scrollIntoView({block:'end'});", finishbtn);
		   js.executeScript("arguments[0].click();", finishbtn);
		
	}
	
	public void clickCancelbtn()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
		WebElement cancelbtnn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Cancelbtn")));
		cancelbtnn.click();
	}
	
	public void clickBackbtn()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlContains("checkout-complete"));
		WebElement backtobtn = wait.until(ExpectedConditions.visibilityOfElementLocated(Backbtn));
		backtobtn.click();
	}
	
	public void clickLogout()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlContains("inventory"));
		WebElement menubtn = wait.until(ExpectedConditions.visibilityOfElementLocated(Menu));
		menubtn.click();
		
		WebElement logutbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(logout));
		logutbtn.click();
		
	}
	
	

}
