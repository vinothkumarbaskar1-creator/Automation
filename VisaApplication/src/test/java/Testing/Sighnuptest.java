package Testing;

import java.nio.file.Paths;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.options.LoadState;

import BaseUrl.Visaurl;
import PageLocaters.Signup;
import PageLocaters.Yoplocaters;

public class Sighnuptest extends Visaurl {
	
	Signup signobj;
	Yoplocaters yopobj;
	
	@Test(priority=1)
	public void signup()
	{
		try {
		ExtentTest test=extent.createTest("Signup Test");
		signobj=new Signup(page);
		signobj.clickSignup();
		test.info("Clicked on the signup link");
		test.pass("Signup test passed");
		
		page.waitForLoadState(LoadState.NETWORKIDLE);
		String path = System.getProperty("user.dir") + "/screenshot/signup_" + System.currentTimeMillis() + ".png";
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
		test.addScreenCaptureFromPath(path);
		}
		catch(Exception e)
		{
			System.out.println("Signup test failed:" + e.getMessage());
		}
		finally {
			System.out.println("Signup test executed");
		}
	}
	@Test(priority=2)
	public void validdSignupTest()
	{
		try {
			ExtentTest test=extent.createTest("Valid Signup Test");
			signobj=new Signup(page);
			HashMap<String, String>data=new HashMap<>();
			data.put("emailid", "dhanush7@yopmail.com");
			data.put("pwd", "12345");
			data.put("cpwd", "12345");
			data.put("q1", "6");
			data.put("a1", "test");
			data.put("q2", "7");
			data.put("a2", "test");
			data.put("q3", "8");
			data.put("a3", "test");
			signobj.signupValid(data);
			test.info("Entered valid signup details");
			test.pass("valid signup test passed");
			page.waitForLoadState(LoadState.NETWORKIDLE);
			
			String path= System.getProperty("user.dir")+"/screenshot/validsignup_"+System.currentTimeMillis()+".png";
			page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
			test.addScreenCaptureFromPath(path);
		}
		catch(Exception e)
		{
			System.out.println("Valid signup test failed:"+e.getMessage());
		}
		finally {
			System.out.println("Valid signup test executed");
		}
	
	}
	
	@Test(priority=3)
	public void navigatetoYopmain()
	{
		ExtentTest test=extent.createTest("Yopmail url navigation test");
		page=context.newPage();
		page.setViewportSize(1280, 720);
		page.navigate("https://yopmail.com");
		page.waitForSelector("#login");
		test.info("Navigated to yopmail website");
		test.pass("Yopmail url navigation test passed");
		page.waitForLoadState(LoadState.DOMCONTENTLOADED);
		String path = System.getProperty("user.dir") + "/screenshot/yopmailurl_" + System.currentTimeMillis() + ".png";
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
		test.addScreenCaptureFromPath(path);
	}
	
	
	@Test(priority=4)
	public void yopEmaillogin()
	{
//		try {
			
			ExtentTest test=extent.createTest("Yopmail login test");
			yopobj=new Yoplocaters(page);
			yopobj.YopValidLogin("dhanush7@yopmail.com");
			test.info("Email logged in successfully");
			test.pass("Yopmail login test passed");
			page.waitForLoadState(LoadState.NETWORKIDLE);
			String path = System.getProperty("user.dir") + "/screenshot/yopmailinbox_" + System.currentTimeMillis() + ".png";
			page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
			test.addScreenCaptureFromPath(path);
		}
		
//		catch(Exception e)
//		{
//			System.out.println("Yopmail login test failed" + e.getMessage());
//		}
//		finally {
//			System.out.println("Yopmail login test executed");
//		}
	
	@Test(priority=5)
	public void clickActivationLink()
	{
		ExtentTest test=extent.createTest("Yopmail login test");
		yopobj=new Yoplocaters(page);
		yopobj.clickLink();
		test.info("Email inbox open successfully");
		test.pass("Yopmail inbox open test passed");
		page.waitForLoadState(LoadState.NETWORKIDLE);
		String path = System.getProperty("user.dir") + "/screenshot/yopmailinbox2_" + System.currentTimeMillis() + ".png";
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
		test.addScreenCaptureFromPath(path);
	}
	
	
	
	
	
}
