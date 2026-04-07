package PageLocaters;

import java.util.HashMap;
import java.util.NoSuchElementException;

import com.microsoft.playwright.Page;

public class Signup {
	
	private Page page;
	
	public Signup(Page page)
	{
		this.page=page;
	}
	
	String signupbutton="//a[@href='/Register/RegisterIndex']";
	String email="#idnEmail";
	String password="#idnPassword";
	String cpassword="#idnConfirmPassword";
	String questino1="#idnSecurityQuestionType1";
	String answer1="#idnSecurityQuestion1";
	String questino2="#idnSecurityQuestionType2";
	String answer2="#idnSecurityQuestion2";
	String questino3="#idnSecurityQuestionType3";
	String answer3="#idnSecurityQuestion3";
	String checkbox="#idnPrivacyPolicy";
	String captcha="#recaptcha-anchor";
	String submitbutton="#idnbtnSubmit";
	
	
	
	public void clickSignup() {
		try
		{
			page.waitForSelector(signupbutton);
			page.click(signupbutton);
		}
	catch(NoSuchElementException e){
		System.out.println("Element not found:"+e.getMessage());
		
	}
	
	finally {
		System.out.println("Signup method executed");
	}
	}
	
	public void validSignup(String emailid,String pwd, String cpwd,String q1,String a1,String q2, String a2, String q3, String a3)
	{
		try {
			page.setDefaultTimeout(60000);
			page.fill(email, emailid);
			page.fill(password, pwd);
			page.fill(cpassword, cpwd);
			page.selectOption(questino1, q1);
			page.fill(answer1, a1);
			page.selectOption(questino2, q2);
			page.fill(answer2, a2);
			page.selectOption(questino3, q3);
			page.fill(answer3, a3);
			page.click(checkbox);
//			page.click(captcha);
			page.click(submitbutton);
		}
		
		catch(NoSuchElementException e)
		{
			System.out.println("Credentials element not found:" +e.getMessage());
		}
		
		finally {
			System.out.println("Valid signup method executed");
		}
	}
	
	public void signupValid(HashMap<String, String>data)
	{
		try {
			page.setDefaultTimeout(60000);
			page.fill(email, data.get("emailid"));
			page.fill(password, data.get("pwd"));
			page.fill(cpassword, data.get("cpwd"));
			page.selectOption(questino1, data.get("q1"));
			page.fill(answer1, data.get("a1"));
			page.selectOption(questino2, data.get("q2"));
			page.fill(answer2, data.get("a2"));
			page.selectOption(questino3, data.get("q3"));
			page.fill(answer3, data.get("a3"));
			page.click(checkbox);
//			page.click(captcha);
			page.click(submitbutton);
		}
		
		catch(NoSuchElementException e)
		{
			System.out.println("test data element not found:" + e.getMessage());
		}
		finally {
			System.out.println("Signup with valid data executed");
		}
	}
	
	
	
	
		
	
	
	
}
