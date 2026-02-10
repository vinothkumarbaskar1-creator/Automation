package com.testscript;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.pages.Checkoutinfo;
import com.pages.Locaters;
import com.pages.Overview;
import com.pages.Products;

import Base.Baseurl;
import Reports.Extentreportmanager;

public class OverviewTest extends Baseurl{
	
	Overview over;
	Locaters l2;
	Products pro;
	Checkoutinfo info1;
//	ExtentReports extent;
	
	
	@BeforeMethod
	public void init()
	{
		over=new Overview(driver);
		l2=new Locaters(driver);
		pro=new Products(driver);
		info1=new Checkoutinfo(driver);
	}
	
	
	@Test(priority=1)
	public void clickonFinishBtn()
	{
		l2.enterValidCredentials("standard_user", "secret_sauce");
		ExtentTest test=extent.createTest("Login Test");
		 test.pass("Login successful with valid credentials");
		
	}
	
	@Test(priority=2)
	public void addProductstocart()
	{
		pro.addproducttoCart();
		ExtentTest test=extent.createTest("Add to cart Test");
		test.pass("Product added to cart successfully");
		pro.addproduct1tocart();
		test.pass("2nd Product added to cart successfully");
	}
	
	@Test(priority=3)
	public void clickToCarticonandcheckout()
	{
		pro.clickonCartIcon();
		try {
			pro.clickonCheckoutButton();
			ExtentTest test=extent.createTest("Checkout button Test");
			test.pass("Checkout button clicked successfully");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test(priority=4)
	public void customerInfo()
	{
		info1.validInfo("saindhu", "kutty", "630001");
		ExtentTest test=extent.createTest("Customer Info Test");
		test.pass("Customer information entered successfully");
		
	}
	
	@Test(priority=5)
	public void finish()
	{
	
		over.clickfinishbtn();
		ExtentTest test=extent.createTest("Customer Info Test");
		test.pass("Finish button clicked successfully");
		
	}
	
	@Test(priority=6)
	public void clickOnBackbtn()
	{
		over.clickBackbtn();
		ExtentTest test=extent.createTest("Back button Test");
		test.pass("Back button clicked successfully");
	}
	@Test(priority=7)
	public void clickOnLogoutButton()
	{
		over.clickLogout();
		ExtentTest test=extent.createTest("Logout buton Test");
		test.pass("Logout button clicked successfully");
	}

}
