package Pages;

import com.microsoft.playwright.Page;

public class Products {
	
	private Page page;
	
	public Products(Page page) {
		this.page=page;
	}
	
	String addtocartbutton="#add-to-cart-sauce-labs-backpack";
	String addtocartbutton1="#add-to-cart-test.allthethings()-t-shirt-(red)";
	String carticon="//a[@class='shopping_cart_link']";
	String checkoutbutton="#checkout";
	String continueshoppingbtn="#continue-shopping";
	String removebutton="#remove-sauce-labs-bike-light";
	public void addproducttoCart()
	{
		page.click(addtocartbutton);
		
	}
	
//	public void addproduct1tocart()
//	{
//		page.click(addtocartbutton1);
//	}
	
	public void clickonCarticon() {
		page.click(carticon);
	}
	
	public void clickonCheckoutButton()
	{
		page.click(checkoutbutton);
	}
	
	public void clickonContinueshoppingbutton()
	{
		page.click(continueshoppingbtn);
	}
	
	public void clickonRemovebutton()
	{
		page.click(removebutton);
	}

}
