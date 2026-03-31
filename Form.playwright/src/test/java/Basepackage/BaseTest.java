package Basepackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import Utils.ExtentManager;

public class BaseTest {
	
	Playwright playwright;
	Browser browser;
	BrowserContext context;
	protected Page page;
	protected ExtentReports extent;
	
	@BeforeClass
	public void setUp() {
		
		extent=ExtentManager.getReportInstance();
		
		playwright=Playwright.create();
		browser = playwright.chromium().launch(
			    new BrowserType.LaunchOptions().setHeadless(false)
			);
		context=browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,1080));
//		page=browser.newPage();
		 page = context.newPage();
		
		page.navigate("https://demoqa.com/automation-practice-form");
		
		System.out.println("Browser Launched Successfully");
		
		String pageTitle=page.title();
		
		System.out.println("Page Title is: " + pageTitle);
	}
	@AfterClass
	public void closeBrowser() {
		extent.flush();
		page.close();
		browser.close();
		playwright.close();
	}
	

}
