package PageLocaters;

import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Page;

public class Yoplocaters {
	
	private Page page;
	
	public Yoplocaters(Page page) {
		this.page=page;
	}
	
	private String emailfield="#login";
	private String loginbutton="//i[@class='material-icons-outlined f36']";
	
	private String mailFrame = "iframe[name='ifmail']";
	private String activationLink = "text=Activate your Account";
	
	//Form
private  String name = "#idnName";
	
	public void YopValidLogin(String emailid) {
		try {
			page.waitForSelector(emailfield);
			page.setDefaultTimeout(60000);
			page.fill(emailfield, emailid);
			page.setDefaultTimeout(60000);
			page.click(loginbutton);
			page.setDefaultTimeout(60000);
		}
		catch(Exception e)
		{
			System.out.println("Email log in is error:"+e.getMessage());
		}
		finally {
			System.out.println("Email is logged in");
		}
		
	}
	
	  public void clickLink() {
//	        Frame frame = page.frameByUrl("ifmail");
//
//	        Page popup = page.waitForPopup(() -> {
//	            frame.click(activationLink);
//	        });
//
//	        return popup;
		  page.waitForSelector(mailFrame);
//		  Frame frame=page.frame(mailFrame);
//		  frame.waitForSelector(activationLink);
//		  frame.click(activationLink);
		  page.waitForLoadState();
		  page.frameLocator("iframe[name='ifmail']")
		    .locator("text=Activate your Account")
		    .click();
		  
		  page.waitForLoadState();
		  page.waitForSelector(name);
		  page.waitForLoadState();
		  page.fill(name, "dhanush");
//		  page.navigate("https://evisa.gov.sz/Login/Validate?returnUrlMail=8b5f4538-536d-43e4-99d3-b36394a0f150");
	    }
	

}
