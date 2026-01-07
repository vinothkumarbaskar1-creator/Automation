package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practiseform {
	
	private WebDriver driver;
	WebDriverWait wait;
	
	
	private By fname=By.xpath("//input[@id='firstName']");
	private By lname=By.xpath("//input[@id='lastName']");
	private By gender=By.xpath("//label[normalize-space()='Male']");
	private By mobile=By.xpath("//input[@id='userNumber']");
	private By dob=By.xpath("//input[@id='dateOfBirthInput']");
	private By sub=By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']");
	private By Hobbies=By.xpath("//label[normalize-space()='Sports']");
	private By picture=By.xpath("//input[@id='uploadPicture']");
	private By address=By.xpath("//textarea[@id='currentAddress']");
	private By state=By.xpath("//div[@id='state']//div[contains(@class,'css-1hwfws3')]");
	private By city=By.xpath("//div[@id='city']//div[contains(@class,'css-1hwfws3')]");
	private By btn_submit=By.xpath("//button[@id='submit']");
    


	
	public Practiseform(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void enter_fname_lname()
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement name1=wait.until(ExpectedConditions.visibilityOfElementLocated(fname));
		name1.sendKeys("vinoth");
		WebElement name2=wait.until(ExpectedConditions.visibilityOfElementLocated(lname));
		name2.sendKeys("kumar");
	}

}
