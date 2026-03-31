package Test;

import java.nio.file.Paths;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Page;

import Pages.Checkoutinfo;
import Pages.Loginpage;
import Pages.Products;
import Saucebase.Basetest;

public class Checkouttest extends Basetest {
	
	Checkoutinfo checkoutobj;
	Loginpage loginobj2;
	Products productobj1;
	
	@Test(priority=1)
	public void validcheckoutForm()
	{
		ExtentTest test=extent.createTest("valid checkout form test");
		loginobj2=new Loginpage(page);
		HashMap<String, String>data=new HashMap<>();
		data.put("userinput", "standard_user");
		data.put("passinput", "secret_sauce");
		loginobj2.validLogin(data);
		test.info("Logged in successfully");
		test.pass("Login test passed");
		
		String path = "screenshot/login" + System.currentTimeMillis() + ".png";
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
		test.addScreenCaptureFromPath("../" + path);
		
	}
	
	@Test(priority=2)
	public void addproductToCart()
	{
		ExtentTest test=extent.createTest("Add product to cart test");
		productobj1=new Products(page);
		productobj1.addproducttoCart();
		test.info("Added product to cart successfully");
		test.pass("Add to cart test passed");
		
		String path = "screenshot/addproduct" + System.currentTimeMillis() + ".png";
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
		test.addScreenCaptureFromPath("../" + path);
	}
	
	@Test(priority=3)
	public void cartIcon()
	{
		ExtentTest test=extent.createTest("Cart icon test");
		productobj1=new Products(page);
		productobj1.clickonCarticon();
		test.info("Cliicked on cart icon successfully");
		test.pass("Cart icon test passed");
		
		String path = "screenshot/cart" + System.currentTimeMillis() + ".png";
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
		test.addScreenCaptureFromPath("../" + path);
		
	}
	
	@Test(priority=4)
	public void checkOutButton()
	{
		ExtentTest test=extent.createTest("Checkout button test");
		productobj1=new Products(page);
		productobj1.clickonCheckoutButton();
		test.info("Clicked on checkout button successfully");
		test.pass("Checkout button test passed");
		
		String path = "screenshot/checkout_" + System.currentTimeMillis() + ".png";
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
		test.addScreenCaptureFromPath("../" + path);
	}
	
	@Test(priority=5)
	public void checkoutvalidfom()
	{
		ExtentTest test=extent.createTest("Checkout form test");
		checkoutobj=new Checkoutinfo(page);
		HashMap<String, String>data=new HashMap<>();
		data.put("firstname", "Jhon");
		data.put("lastname", "Smith");
		data.put("zipcodee", "123456");
		checkoutobj.enterCheckoutvalidinfo(data);
		test.info("Entered valid checkout innformation successfully");
		test.pass("Checkout form test passed");
		
		String path = "screenshot/checkoutform" + System.currentTimeMillis() + ".png";
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
		test.addScreenCaptureFromPath("../" + path);
	}
	
	@Test(priority=6)
	public void finishbutton()
	{
		ExtentTest test=extent.createTest("Finish button test");
		checkoutobj=new Checkoutinfo(page);
		checkoutobj.clickonFinishbutton();
		
		test.info("Clicked on finish button successfully");
		test.pass("Finish button test passed");
		
		String path = "screenshot/finish" + System.currentTimeMillis() + ".png";
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
		test.addScreenCaptureFromPath("../" + path);
	}
	
	@Test(priority=7)
	public void backbutton()
	{
		ExtentTest test=extent.createTest("Back button test");
		checkoutobj=new Checkoutinfo(page);
		checkoutobj.backButton();
		
		test.info("Clicked on back button successfully");
		test.pass("back button test passed");
		
		String path = "screenshot/backbtn" + System.currentTimeMillis() + ".png";
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
		test.addScreenCaptureFromPath("../" + path);
	}

}
