package Pages;

import java.util.HashMap;

import com.microsoft.playwright.Page;

public class Checkoutinfo {
	
	protected Page page;
	
	public Checkoutinfo(Page page) {
		this.page=page;
	}
	
	String name1="#first-name";
	String name2="#last-name";
	String postalcode="#postal-code";
	String continuebutton="#continue";
	String Finishbutton="#finish";
	String backbutton="#back-to-products";
	
	
	public void enterCheckoutinfo(String fname, String lname, String zipcode)
	{
		page.fill(name1, fname);
		page.fill(name2, lname);
		page.fill(postalcode, zipcode);
	}
	
	public void clickonContinuebutton()
	{
		page.click(continuebutton);
	}
	
	public void clickonFinishbutton()
	{
		page.click(Finishbutton);
	}
	
	public void backButton()
	{
		page.click(backbutton);
	}
	
	//common method for entering checkout info
	public void enterCheckoutvalidinfo(HashMap<String, String>data)
	{
		page.fill(name1, data.get("firstname"));
		page.fill(name2, data.get("lastname"));
		page.fill(postalcode, data.get("zipcodee"));
		page.click(continuebutton);
	}

}
