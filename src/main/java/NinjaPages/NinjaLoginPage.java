package NinjaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NinjaLoginPage {
	
	WebDriver driver;
	
	public NinjaLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="email")
	WebElement emailAddressField;
	
	@FindBy(name="password")
	WebElement passwordField;
	
//	@FindBy(xpath="//input[@value='Login']")
//	WebElement loginButton;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
	WebElement loginButton;
	
	
	
	public WebElement emailAddressField() {
		return emailAddressField;
	}
	public WebElement passwordField() {
		return passwordField;
	}
	
	public WebElement loginButton() {
		return loginButton;
	}

}
