package Test;

import java.nio.file.Paths;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Page;

import Pages.Loginpage;
import Pages.Products;
import Saucebase.Basetest;

public class ProductTest extends Basetest {
	
	Loginpage loginobj1;
	Products productobj;
	
	@Test(priority=1)
	public void addproducttocart()
	{
		ExtentTest test=extent.createTest("Add product to cart test");
		loginobj1=new Loginpage(page);
		productobj=new Products(page);
		HashMap<String, String>data=new HashMap<>();
		data.put("userinput", "standard_user");
		data.put("passinput", "secret_sauce");
		loginobj1.validLogin(data);
		productobj.addproducttoCart();
//		productobj.addproduct1tocart();
		test.info("Added product to cart successfully");
		test.pass("Add to cart test passed");
		String path = "screenshot/Addproduct" + System.currentTimeMillis() + ".png";
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
		test.addScreenCaptureFromPath(path);
	}
	
	@Test(priority=2)
	public void clickonCarticon()
	{
		ExtentTest test=extent.createTest("Add product to cart test");
		productobj=new Products(page);
		productobj.clickonCarticon();
		test.info("Cliicked on cart icon successfully");
		test.pass("Cart icon test passed");
		String path = "screenshot/cart" + System.currentTimeMillis() + ".png";
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
		test.addScreenCaptureFromPath(path);
	}
	
	@Test(priority=3)
	public void clickonCheckoutButton()
	{
		ExtentTest test=extent.createTest("Checkout button test");
		productobj=new Products(page);
		productobj.clickonCheckoutButton();
		test.info("Clicked on checkout button successfully");
		test.pass("Checkout button test passed");
		String path = "screenshot/checkout" + System.currentTimeMillis() + ".png";
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
		test.addScreenCaptureFromPath(path);
	}

}
