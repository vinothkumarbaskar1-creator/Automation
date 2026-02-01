package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Products {
	
	private WebDriver driver;
	
	By AddtoCart=By.id("add-to-cart-sauce-labs-backpack");
	By AddtoCart1=By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
	By Carticon=By.xpath("//a[@class='shopping_cart_link']");
	
	
	public Products(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void addproducttoCart()
	{
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.urlContains("inventory"));

		 wait.until(ExpectedConditions.visibilityOfElementLocated(AddtoCart)).click();
		
	}
	
	public void addproduct1tocart()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Actions acts = new Actions(driver);
		 acts.sendKeys(org.openqa.selenium.Keys.PAGE_DOWN).perform();
		 wait.until(ExpectedConditions.visibilityOfElementLocated(AddtoCart1)).click();
	}
	
	public void clickonCartIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    
		Actions act = new Actions(driver);
		act.sendKeys(org.openqa.selenium.Keys.PAGE_UP).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Carticon)).click();
	}
	

}
