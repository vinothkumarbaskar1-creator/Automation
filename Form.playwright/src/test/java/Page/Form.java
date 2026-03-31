package Page;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import com.microsoft.playwright.Page;

public class Form {
	
	private Page page;
	
	public Form(Page page) {
		this.page=page;
	}
	
	//Locaters
	String firstName = "#firstName";
    String lastName = "#lastName";
    String email = "#userEmail";
    String genderMale = "label[for='gender-radio-1']";
    String mobile = "#userNumber";
    String dob = "#dateOfBirthInput";
    String subject = "#subjectsInput";
    String hobbySports = "label[for='hobbies-checkbox-1']";
    String upload = "#uploadPicture";
    String address = "#currentAddress";
    String state = "#state";
    String city = "#city";
    String submit = "#submit";
    
    //Actions
    public void enterFirstName(String fname) {
    	page.fill(firstName, fname);
    }
    
    public void enterLastName(String lname) {
    	page.fill(lastName, lname);
    }
    
    public void enterEmail(String emailId)
    {
    	page.fill(email, emailId);
    }
    
    public void selectGender() {
    	page.click(genderMale);
    }
    
    public void enterMobile(String mobileNumber) {
    	page.fill(mobile, mobileNumber);
    }
    
    public void enterDOB(String dateofBirth) {
    	page.fill(dob, dateofBirth);
    	page.keyboard().press("Enter");
    }
    
    public void enterSubject(String subjectName) {
    	page.click(subject);
    	page.fill(subject, subjectName);
    	page.keyboard().press("Enter");
    }
    
    public void selectHobby() {
    	page.click(hobbySports);
    }
    
    public void uploadPicture(String filePath)
    {
    	page.setInputFiles(upload, Paths.get(filePath));
    }
    
    public void enterAddress(String currentAddress)
    {
    	page.fill(address, currentAddress);
    }
    
    public void selectState(String stateName) {
    	page.click(state);
    	page.keyboard().type(stateName);
    	page.keyboard().press("Enter");
    }
    
    public void selectCity(String cityName)
    {
    	page.click(city);
    	page.keyboard().type(cityName);
    	page.keyboard().press("Enter");
    }
    
    public void clickSubmit()
    {
    	page.click(submit);
    }
    
    //Commen method to fill the form
   public void fillForm(HashMap<String, String> data) {
	   enterFirstName(data.get("firstName"));
	   enterLastName(data.get("lastname"));
	   enterEmail(data.get("email"));
	   selectGender();
	   enterMobile(data.get("mobile"));
	   enterDOB(data.get("dob"));
	   enterSubject(data.get("subject"));
	   selectHobby();
	   uploadPicture(data.get("filepath"));
	   enterAddress(data.get("address"));
	   selectState(data.get("state"));
	   selectCity(data.get("city"));
	   
   }
    
  
   
   //Negative scenario 
    public void withoutinput() {
    	page.click(submit);
    	System.out.println("Submit button clicking without filling the form");
    }
    
    public void fillinvalidEmail(HashMap<String, String> data)
    {
    	enterFirstName(data.get("firstName"));
 	   enterLastName(data.get("lastname"));
 	   enterEmail(data.get("email"));
 	   selectGender();
 	   enterMobile(data.get("mobile"));
 	   enterDOB(data.get("dob"));
 	   enterSubject(data.get("subject"));
 	   selectHobby();
 	   uploadPicture(data.get("filepath"));
 	   enterAddress(data.get("address"));
 	   selectState(data.get("state"));
 	   selectCity(data.get("city"));
    	 
    }
    
    public void fillinvalidmobile(HashMap<String, String> data)
    {
    	enterFirstName(data.get("firstName"));
  	   enterLastName(data.get("lastname"));
  	   enterEmail(data.get("email"));
  	   selectGender();
  	   enterMobile(data.get("mobile"));
  	   enterDOB(data.get("dob"));
  	   enterSubject(data.get("subject"));
  	   selectHobby();
  	   uploadPicture(data.get("filepath"));
  	   enterAddress(data.get("address"));
  	   selectState(data.get("state"));
  	   selectCity(data.get("city"));
    	
     }
    
    public void fillinvalidob(HashMap<String, String> data)
    {
    	enterFirstName(data.get("firstName"));
  	   enterLastName(data.get("lastname"));
  	   enterEmail(data.get("email"));
  	   selectGender();
  	   enterMobile(data.get("mobile"));
  	   enterDOB(data.get("dob"));
  	   enterSubject(data.get("subject"));
  	   selectHobby();
  	   uploadPicture(data.get("filepath"));
  	   enterAddress(data.get("address"));
  	   selectState(data.get("state"));
  	   selectCity(data.get("city"));
    
    }
    
    
    public void fillinvalidSubject(HashMap<String, String> data)
    {
    	enterFirstName(data.get("firstName"));
  	   enterLastName(data.get("lastname"));
  	   enterEmail(data.get("email"));
  	   selectGender();
  	   enterMobile(data.get("mobile"));
  	   enterDOB(data.get("dob"));
  	   enterSubject(data.get("subject"));
  	   selectHobby();
  	   uploadPicture(data.get("filepath"));
  	   enterAddress(data.get("address"));
  	   selectState(data.get("state"));
  	   selectCity(data.get("city"));
    
    }
    
    public void fillinvalidCity(HashMap<String, String> data)
    {
    	enterFirstName(data.get("firstName"));
  	   enterLastName(data.get("lastname"));
  	   enterEmail(data.get("email"));
  	   selectGender();
  	   enterMobile(data.get("mobile"));
  	   enterDOB(data.get("dob"));
  	   enterSubject(data.get("subject"));
  	   selectHobby();
  	   uploadPicture(data.get("filepath"));
  	   enterAddress(data.get("address"));
  	   selectState(data.get("state"));
  	   selectCity(data.get("city"));
    
    }

}
