package NoEcommercePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import utilityComponents.BaseClass;

public class MyAccountPage extends BaseClass{
	
	@FindBy(xpath="//h2[text()='Order history']")
	WebElement orderHistory;
	
	 public MyAccountPage() {
		   PageFactory.initElements(driver, this);
	   }
	 
	 public boolean validateOrderHistory() {
		 
		 return Action.isDisplayed(driver, orderHistory);
		 
	 }
	 public String getCurrentUrl() {
	String homePageUrl=	driver.getCurrentUrl();
	return homePageUrl;
	 }

}
