package NoEcommercePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import utilityComponents.BaseClass;

public class SearchResultPage extends BaseClass {
	
	@FindBy(xpath="//img[@alt='Picture of Apple MacBook Pro 13-inch' and @src='https://demo.nopcommerce.com/images/thumbs/0000024_apple-macbook-pro-13-inch_64.jpeg']")
	WebElement productResult;
	@FindBy(id = "add-to-cart-button-4")
	WebElement addToCart;
	
	public SearchResultPage() {
		   PageFactory.initElements(driver, this);
	   }
	
	public boolean isProductAvailable() {
		return Action.isDisplayed(driver, productResult);
	}
	public AddToCartPage clickOnProduct() {
		productResult.click();
		return new AddToCartPage();
		
	}

}
