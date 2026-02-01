package Base;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseurl {
	
	protected WebDriver driver;
	
	@BeforeClass
	public void setup() {

	    WebDriverManager.chromedriver().setup();

	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--incognito");
	    options.addArguments("--disable-save-password-bubble");
	    options.addArguments("--disable-notifications");
	    options.addArguments("--disable-infobars");

	    driver = new ChromeDriver(options);   // ✅ Only ONE driver
	    driver.manage().window().maximize();

	    driver.get("https://www.saucedemo.com/");

	    System.out.println("Url is opened");
	    System.out.println("Title: " + driver.getTitle());
	}
	@AfterClass
	public void teardown()
	{
		if(driver!=null)
		{
//			driver.close();
			System.out.println("Browser is closed");
//			driver.quit();
		}
	}
	
	
	

}
