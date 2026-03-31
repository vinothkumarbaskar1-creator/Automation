package Pages;

import java.util.HashMap;

import com.microsoft.playwright.Page;

public class Loginpage {
	private Page page;
	
	public Loginpage(Page page) {
		this.page=page;
	}
	
	String usernamel="#user-name";
	String passwordl="#password";
	String loginbutton="#login-button";
	String menuicon="#react-burger-menu-btn";
	String logoutbutton="#logout_sidebar_link";
	
	//Actions
	public void enterCredentials(String user, String pass)
	{
		page.fill(usernamel, user);
		page.fill(passwordl, pass);
		page.click(loginbutton);
	}
	
	public void logout() {
		page.click(menuicon);
		page.click(logoutbutton);
	}
	
	//commonmethod for valid login
	
	public void validLogin(HashMap<String, String>data)
	{
		page.fill(usernamel, data.get("userinput"));
		page.fill(passwordl, data.get("passinput"));
		page.click(loginbutton);
	}
	
	public void invalidLogin(HashMap<String, String>data)
	{
		page.fill(usernamel, data.get("userinput"));
		page.fill(passwordl, data.get("passinput"));
		page.click(loginbutton);
	}
	
	public void loginwithusernameonly(HashMap<String, String>data)
	{
		page.fill(usernamel, data.get("userinput"));
		page.click(loginbutton);
	}
	
	public void loginwithPasswordonly(HashMap<String, String>data)
	{
		page.fill(usernamel, data.get("userinput"));
		page.fill(passwordl, data.get("passinput"));
		page.click(loginbutton);
	}
	

}


