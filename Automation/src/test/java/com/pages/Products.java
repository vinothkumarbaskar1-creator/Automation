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
	
	By CheckoutButton=By.id("checkout");
	By continueShoppingbtn=By.xpath("//button[@id='continue-shopping']");
	By removeBtn=By.xpath("//button[@id='remove-sauce-labs-backpack']");
	
	
	
	
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement secondBtn = wait.until(
		ExpectedConditions.presenceOfElementLocated(AddtoCart1));
		try { Thread.sleep(700); } catch (Exception e) {}
		js.executeScript("arguments[0].click();", secondBtn);

	}
	
	public void clickonCartIcon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    
		Actions act = new Actions(driver);
		act.sendKeys(org.openqa.selenium.Keys.PAGE_UP).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Carticon)).click();
		driver.navigate().refresh();
	}
	
	public void clickonCheckoutButton() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement checkoutBtn = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(CheckoutButton));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", checkoutBtn);
		Thread.sleep(800);
		js.executeScript("arguments[0].click();", checkoutBtn);
	}
	
	public void clickonContinueShopping()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingbtn)).click();
	}
	
	public void clickonRemoveButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(removeBtn)).click();
	}
	

}
