package com.testscript;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.Checkoutinfo;
import com.pages.Locaters;
import com.pages.Products;

import Base.Baseurl;

public class Checoutinfotest extends Baseurl {
	
	Checkoutinfo info;
	Products p1;
	Locaters l1;
	
	@BeforeMethod
	public void init()
	{
		l1=new Locaters(driver);
		info=new Checkoutinfo(driver);
		p1=new Products(driver);
	}
	
	@Test(priority=1)
	public void validinfocredentials()
	{
		l1.enterValidCredentials("standard_user", "secret_sauce");
		p1.addproducttoCart();
		p1.addproduct1tocart();
		p1.clickonCartIcon();
		try {
			p1.clickonCheckoutButton();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		info.validInfo("wick", "lname", "630001");
	}
}
