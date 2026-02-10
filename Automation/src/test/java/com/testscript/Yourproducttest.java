package com.testscript;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.Yourproduct;

public class Yourproducttest extends ProductsTest {
	
	Yourproduct yourproduct;
	ProductsTest producttest;
	
	@BeforeMethod
	public void init1() {
		yourproduct=new Yourproduct(driver);
		producttest=new ProductsTest();
	}
	
	@Test
	public void checkoutButtonTest() {
		try {
			yourproduct.clickonCheckoutButton();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
