package Test;

import static org.testng.Assert.assertEquals;

import java.nio.file.Paths;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Page;

import Pages.Loginpage;

public class Logintest extends Saucebase.Basetest{
	
	Loginpage loginobj;
	
	@Test(priority=1)
	public void validLogin() {
		ExtentTest test=extent.createTest("Valid Login Test");
		loginobj=new Loginpage(page);
		HashMap<String, String>data=new HashMap<>();
		data.put("userinput", "standard_user");
		data.put("passinput", "secret_sauce");
		loginobj.validLogin(data);
		test.info("Entered valid credentials and logged in successfully");
		
		test.pass("Login test passed");
		//Assertions
		String actualTitle=page.title();
		Assert.assertEquals(actualTitle, "Swag Labs");
		
		 String path = "screenshot/login_" + System.currentTimeMillis() + ".png";
		 page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
		 test.addScreenCaptureFromPath(path);
		
	}
	
	@Test(priority=2)
	public void loggedout()
	{
		ExtentTest test=extent.createTest("Valid Login Test");
		loginobj=new Loginpage(page);
		loginobj.logout();
		test.info("Logged out successfully");
		
		test.pass("logout tes passsed");
		String path = "screenshot/logot_" + System.currentTimeMillis() + ".png";
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
		test.addScreenCaptureFromPath(path);
		
		 
	}
	
	@Test(priority=3)
	public void invalidLogin()
	{
		ExtentTest test=extent.createTest("Valid Login Test");
		loginobj=new Loginpage(page);
		HashMap<String, String>data=new HashMap<>();
		data.put("userinput", "invalid_user");
		data.put("passinput", "invalid_pass");
		loginobj.invalidLogin(data);
		test.info("Entered invalid credentials and login failed");
		test.pass("Invalid login test passed");
		String path = "screenshot/logot_" + System.currentTimeMillis() + ".png";
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
		test.addScreenCaptureFromPath(path);
	}
	
	@Test(priority=4)
	public void loginwithUsernameonly() {
		ExtentTest test=extent.createTest("Login with username only Test");
		loginobj=new Loginpage(page);
		HashMap<String, String>data=new HashMap<>();
		data.put("userinput", "standard_user");
		data.put("passinput", "");
		loginobj.loginwithusernameonly(data);
		test.info("Entered username only and login failed");
		test.pass("Login with username only test passed");
		String path = "screenshot/login1" + System.currentTimeMillis() + ".png";
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
		test.addScreenCaptureFromPath(path);
	}
	
	@Test(priority=5)
	
	public void loginwithpasswordonly()
	{
		ExtentTest test=extent.createTest("Login with password only Test");
		loginobj=new Loginpage(page);
		HashMap<String, String>data=new HashMap<>();
		data.put("userinput", "");
		data.put("passinput", "secret_sauce");
		loginobj.loginwithusernameonly(data);
		test.info("Entered password only and login failed");
		test.pass("Login with password only test passed");
		String path = "screenshot/login1" + System.currentTimeMillis() + ".png";
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
		test.addScreenCaptureFromPath(path);
	}

}
