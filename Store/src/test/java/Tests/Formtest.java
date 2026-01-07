package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.Formpage;
import Pages.Practiseform;

public class Formtest extends BaseTest {
	
//	WebDriver driver;
	Formpage form;
	Practiseform pf;
	
	@BeforeMethod
	public void setupurl()
	{
		
		driver.get("https://demoqa.com/");
		form=new Formpage(driver);
		pf=new Practiseform(driver);
	
	}
	@Test
	public void testclickmenu()
	{
		form.clickmenu();
	}
	@AfterTest
	@Test
	public void click_pfmenu()
	{
		pf.enter_fname_lname();
	}

}
