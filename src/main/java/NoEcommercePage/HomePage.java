package NoEcommercePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import utilityComponents.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//h2[normalize-space()='My Orders']")
	WebElement myOrder;
	
	 public HomePage() {
		   PageFactory.initElements(driver, this);
	   }
	 
	 public boolean validateOrderHistory() {
		 
		 return Action.isDisplayed(driver, myOrder);
		 
	 }
	 
	 public boolean validateMyAccount() {
		 return Action.isDisplayed(driver, myAccount);
	 }
	 
	 public String getCurrentUrl() {
	String homePageUrl=	driver.getCurrentUrl();
	return homePageUrl;
	 }
	

}
