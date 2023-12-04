package NoEcommercePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import utilityComponents.BaseClass;

public class AddToCartPage extends BaseClass {
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(id="group_1")
	WebElement size;
	
	@FindBy(id="add_to_cart")
	WebElement addToCartBtn;
	
	@FindBy(id="add_to_cart")
	WebElement addToCartMsg;
	
	public AddToCartPage() {
		   PageFactory.initElements(driver, this);
	   }
	
	public void enterQuantity() {
		quantity.sendKeys("2");
	}
	
	public void selectSize() {
		Action.selectByIndex(size, 2);
	}
	public void addToCartBtn() {
		addToCartBtn.click();
	}
	public void validateAddToCart() {
		Action.isDisplayed(driver, addToCartBtn);
	}

}
