package com.testscript;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.Locaters;
import com.pages.Products;

import Base.Baseurl;

public class ProductsTest extends Baseurl {
	
	Products product;
	Locaters login;
	
	@BeforeMethod
	public void init() {
		product=new Products(driver);
		login=new Locaters(driver);
	}
	
	@Test(priority=1)
	public void addtoCartTest() {
		login.enterValidCredentials("standard_user", "secret_sauce");
		product.addproducttoCart();
		
	}
	
	@Test(priority=2)
	public void addtoCartTest1()
	{
		product.addproduct1tocart();
	}
	
	
	
	@Test(priority=3)
	public void clickCartIconnTest()
	{
//		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
		product.clickonCartIcon();
		
		
	}
	
	@Test(priority=4)
	public void clickCheckoutbtn() throws InterruptedException
	{
		product.clickonCheckoutButton();
	}
	
//	@Test(priority=5)
//	public void clickonContinueshoppingtn()
//	{
//		product.clickonContinueShopping();
//	}
	
//	@Test(priority=6)
//	public void clickOnRemovebtn()
//	{
//		product.clickonRemoveButton();
//	}

}
