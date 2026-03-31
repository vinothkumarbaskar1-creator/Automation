package Test;

import java.nio.file.Paths;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Page;

import Page.Form;

public class Formtest extends Basepackage.BaseTest {
	
	Form form;
	
	
	@Test(priority=1)
	public void fillValidForm() {
		
		ExtentTest test = extent.createTest("Valid Form Submission Test");
		form=new Form(page);
		
		HashMap<String, String> data=new HashMap<>();
		data.put("firstName", "vinoth");
		data.put("lastname", "kumar");
	    data.put("email", "vinoth@mailinator.com");
	    data.put("mobile", "9555555555");
	    data.put("dob", "27 Mar 2000");
	    data.put("subject", "English");
	    data.put("filepath", "C:\\Users\\Vinothkumar\\Downloads\\Gen AI Specialist.jpg");
	    data.put("address", "chennai");
	    data.put("state", "NCR");
	    data.put("city", "Delhi");
	    
	    form.fillForm(data);
	    
	    //Info
	     test.info("Filled the form with valid data");

		form.clickSubmit();
		//Log
		test.pass("Form submitted successfully");
		
		 page.screenshot(new Page.ScreenshotOptions()
	     		    .setPath(Paths.get("screenshot/test.png")));
		 
		 test.addScreenCaptureFromPath("screenshot/test.png");
	}
	
	@Test(priority=2)
	public void submitWithoutInput()
	{
		page.reload();
		System.out.println("page refreshed successfuly");
		
		ExtentTest test=extent.createTest("Submit Without Input");
		form=new Form(page);
		form.withoutinput();
		
		test.info("Clicked submit buttonn without filling the form");
		
		test.pass("Submit button clicked without filling the form");
		
		 page.screenshot(new Page.ScreenshotOptions()
	     		    .setPath(Paths.get("screenshot/test1.png")));
		 
		 test.addScreenCaptureFromPath("screenshot/test1.png");
	}
	
	@Test(priority=3)
	public void fillInvalidForm() {
		page.reload();
		ExtentTest test=extent.createTest("Fill the form with invalid email");
		form=new Form(page);
		HashMap<String, String> data=new HashMap<>();
		data.put("firstName", "vinoth");
		data.put("lastname", "kumar");
	    data.put("email", "vinoth@mailinator");
	    data.put("mobile", "9555555555");
	    data.put("dob", "27 Mar 2000");
	    data.put("subject", "English");
	    data.put("filepath", "C:\\Users\\Vinothkumar\\Downloads\\Gen AI Specialist.jpg");
	    data.put("address", "chennai");
	    data.put("state", "NCR");
	    data.put("city", "Delhi");
	    
	    form.fillinvalidEmail(data);
	    
	    test.info("Filled the form the form with invalid email");
		
		form.clickSubmit();
		
		test.pass("Form submited with invalid email");
		
		//screenshot
		 page.screenshot(new Page.ScreenshotOptions()
	     		    .setPath(Paths.get("screenshot/test2.png")));
		 
		 test.addScreenCaptureFromPath("screenshot/test2.png");
	}
	
	@Test(priority=4)
	public void invalidmobile()
	{
		page.reload();
		
		ExtentTest test=extent.createTest("Invalid Mobile Number Test");
		form=new Form(page);
		HashMap<String, String> data=new HashMap<>();
		data.put("firstName", "vinoth");
		data.put("lastname", "kumar");
	    data.put("email", "vinoth@mailinator.com");
	    data.put("mobile", "95555");
	    data.put("dob", "27 Mar 2000");
	    data.put("subject", "English");
	    data.put("filepath", "C:\\Users\\Vinothkumar\\Downloads\\Gen AI Specialist.jpg");
	    data.put("address", "chennai");
	    data.put("state", "NCR");
	    data.put("city", "Delhi");
	    
	    form.fillinvalidmobile(data);
	    
	    test.info("Filled the form with invalid mobile number");
		
		form.clickSubmit();
		
		test.pass("Form submited with invalid mobile number");
		
		//screenshot
		 page.screenshot(new Page.ScreenshotOptions()
	     		    .setPath(Paths.get("screenshot/test3.png")));
		 
		 test.addScreenCaptureFromPath("screenshot/test3.png");
	}
	
	@Test(priority=5)
	public void invalidDob()
	{
		page.reload();
		ExtentTest test=extent.createTest("Invalid Date of Birth");
		form=new Form(page);
		HashMap<String, String> data=new HashMap<>();
		data.put("firstName", "vinoth");
		data.put("lastname", "kumar");
	    data.put("email", "vinoth@mailinator.com");
	    data.put("mobile", "9555555555");
	    data.put("dob", "27 Mar 2050");
	    data.put("subject", "English");
	    data.put("filepath", "C:\\Users\\Vinothkumar\\Downloads\\Gen AI Specialist.jpg");
	    data.put("address", "chennai");
	    data.put("state", "NCR");
	    data.put("city", "Delhi");
	    
	    form.fillinvalidob(data);
	    
	    test.info("Form submited with invalid Date of Birth");
		
		form.clickSubmit();
		
		test.pass("Form submited with invalid ate of Birth");
		
		//screenshot
		 page.screenshot(new Page.ScreenshotOptions()
	     		    .setPath(Paths.get("screenshot/test4.png")));
		
		test.addScreenCaptureFromPath("screenshot/test4.png");
	}
	
	@Test(priority=6)
	public void invalidSubject() {
		page.reload();
		ExtentTest test=extent.createTest("Invalid Subject Test");
		form=new Form(page);
		HashMap<String, String> data=new HashMap<>();
		data.put("firstName", "vinoth");
		data.put("lastname", "kumar");
	    data.put("email", "vinoth@mailinator.com");
	    data.put("mobile", "9555555555");
	    data.put("dob", "27 Mar 2000");
	    data.put("subject", "thanglish");
	    data.put("filepath", "C:\\Users\\Vinothkumar\\Downloads\\Gen AI Specialist.jpg");
	    data.put("address", "chennai");
	    data.put("state", "NCR");
	    data.put("city", "Delhi");
	    
	    form.fillinvalidSubject(data);
	    
	    test.info("orm submited with invalid subject");
		
		form.clickSubmit();
		
		test.pass("Form submited with invalid subject");
		
		//Screenshot
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot/test5.png")));
		test.addScreenCaptureFromPath("screenshot/test5.png");
	}
	
	@Test(priority=7)
	public void invalidCity() {
		page.reload();
		ExtentTest test=extent.createTest("Invaliid City Test");
		form=new Form(page);
		HashMap<String, String> data=new HashMap<>();
		data.put("firstName", "vinoth");
		data.put("lastname", "kumar");
	    data.put("email", "vinoth@mailinator.com");
	    data.put("mobile", "9555555555");
	    data.put("dob", "27 Mar 2000");
	    data.put("subject", "English");
	    data.put("filepath", "C:\\Users\\Vinothkumar\\Downloads\\Gen AI Specialist.jpg");
	    data.put("address", "chennai");
	    data.put("state", "NCR");
	    data.put("city", "grugaon");
	    
	    form.fillinvalidCity(data);
	    
	    test.info("Filled the form with invalid city");
		
		form.clickSubmit();
		
		test.pass("Form submited with invalid city");
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot/test6.png")));
		
		test.addScreenCaptureFromPath("screenshot/test6.png");
		
	}

}
