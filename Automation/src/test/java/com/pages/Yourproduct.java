package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Yourproduct {
	
	private WebDriver driver;
	
	By CheckoutButton=By.id("checkout");
	By continueShoppingbtn=By.xpath("//button[@id='continue-shopping']");
	By removeBtn=By.xpath("//button[@id='remove-sauce-labs-backpack']");
	
	public Yourproduct(WebDriver driver)
	{
		this.driver=driver;
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
