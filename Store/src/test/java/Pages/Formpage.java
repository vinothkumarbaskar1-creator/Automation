package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Formpage {
	
	private WebDriver driver=null;
	
	private By formsCard = By.xpath("//div[@class='card-body']//h5[text()='Forms']");
	 
    private By practiceFormMenu = By.xpath("//span[text()='Practice Form']");
	
	public Formpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickmenu()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
        WebElement forms = wait.until(ExpectedConditions.visibilityOfElementLocated(formsCard));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", forms);

        WebElement practiceForm = wait.until(ExpectedConditions.elementToBeClickable(practiceFormMenu));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", practiceForm);
    
	}

}
