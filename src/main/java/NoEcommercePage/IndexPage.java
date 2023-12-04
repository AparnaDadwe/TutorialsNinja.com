package NoEcommercePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import utilityComponents.BaseClass;

public class IndexPage extends BaseClass{
   public IndexPage() {
	   PageFactory.initElements(driver, this);
   }
   
   @FindBy(xpath ="//a[text()='Log in']")
   WebElement logInLink;
   
   
   
   @FindBy(xpath = "//img[@alt='nopCommerce demo store']")
   WebElement noEcommerceLogo;
   
   @FindBy(xpath = "//input[@id='small-searchterms']")
   WebElement searchBox;
   
   @FindBy(xpath = "//button[@type='submit']")
   WebElement searchBtn;
   
  
   
   public LoginPage clickOnMyLoginLink() {
	  
	   logInLink.click();
	   return new LoginPage();
   }
   
   public boolean validateLogo() {
	   return Action.isDisplayed(driver, noEcommerceLogo);
   }
   
   
   public SearchResultPage searchResult(String ProductName) {
	   Action.click(driver, searchBtn);
	   return new SearchResultPage();
	   
   }
   
   public String getTitle() {
	   String title=driver.getTitle();
	   return title;
   }
   
   public String getCurrentUrl() {
		String indexPageUrl=	driver.getCurrentUrl();
		return indexPageUrl;
		 }
}
