package NinjaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NinjaHomePage {
WebDriver driver;
	
	public NinjaHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myAccountDropdown;
	
	@FindBy(partialLinkText = "Login")
	WebElement loginOption;
	
	@FindBy(partialLinkText = "Register")
	WebElement RegisterOption;
	
	public WebElement myAccountDropdown() {
		return myAccountDropdown;
	}
	public WebElement loginOption() {
		return loginOption;
	}
	
	public WebElement RegisterOption() {
		return RegisterOption;
	}
}
