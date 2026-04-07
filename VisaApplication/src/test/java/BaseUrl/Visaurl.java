package BaseUrl;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Visaurl {
	
	protected Playwright playwright;
	protected Browser browser;
	protected Page page;
	protected BrowserContext context;
	public static ExtentReports extent;
	
	
	@BeforeSuite
	public void extentSetup()
	{
		extent=Visautils.ExtentManager.getInstance();
	}
	
	@BeforeClass
	public void setup()
	{
		playwright=Playwright.create();
		browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		context=browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,1080));
		page=context.newPage();
		page.navigate("https://evisa.gov.sz/");
		
		System.out.println("Browser lanunched  and navigated to the visa application website");
		System.out.println("The page title is:" + page.title());
		System.out.println("The page url is :" + page.url());
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		if(browser!=null)
		{
			browser.close();
			playwright.close();
		}
	}
	
	@AfterSuite
	public void flushReport()
	{
		if(extent!=null)
		{
			extent.flush();
			System.out.println("Extent report flushed successfully");
		}
	}
	
	
	

}
