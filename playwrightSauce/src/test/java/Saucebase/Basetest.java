package Saucebase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;

import com.aventstack.extentreports.ExtentReports;
import org.testng.annotations.Parameters;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import Utills.ExtentManager;

public class Basetest {
	
	protected Playwright playwright;
	protected Browser browser;
	protected BrowserContext context;
	protected Page page;
	public static ExtentReports extent;
	
	@BeforeSuite
	public void extentSetup()
	{
		extent=ExtentManager.getInstance();
	}
	
	@BeforeClass
	@Parameters("browser")
	public void setup(@Optional("chrome") String browsername) {

	    System.out.println("Launching browser: " + browsername);

	    playwright = Playwright.create();

	    if(browsername.equalsIgnoreCase("chrome")) {
	        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	    }
	    else if(browsername.equalsIgnoreCase("firefox")) {
	        browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
	    }
	    else if(browsername.equalsIgnoreCase("webkit")) {
	        browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
	    }
	    else {
	        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	    }

	    context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,1080));
	    page = context.newPage();

	    page.navigate("https://www.saucedemo.com/");
	}
	
//	@AfterClass
//	public void close() {
//		page.close();
//		browser.close();
//		playwright.close();
//	}
	
	@AfterSuite
	public void flushReport()
	{
		extent.flush();
	}

}
