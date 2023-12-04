package NoEcommercePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import utilityComponents.BaseClass;

public class MyAccountHomePage extends BaseClass {
	@FindBy(xpath="//*[@id=\"center_column\"]/div/div/ul/li[2]/a/span")
	WebElement orderHistory;
	
	 public MyAccountHomePage() {
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
