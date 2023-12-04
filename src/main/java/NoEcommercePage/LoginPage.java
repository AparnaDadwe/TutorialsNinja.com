package NoEcommercePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import utilityComponents.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement customerName;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement customerPassWord;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement logInBtn;
	
	@FindBy(xpath="//button[text()='Register']")
	WebElement registrationBtn;
	
	
	 public LoginPage() {
		   PageFactory.initElements(driver, this);
	   }
	 
	 public IndexPage login(String uname, String pwd) {
		 customerName.sendKeys(uname); 
		 customerPassWord.sendKeys(pwd);
//		 Action.click(driver, logInBtn);
		 logInBtn.click();
		 return new IndexPage();
	 }
	 //without login when we search product directly after adding to the product it say s u have to login  so we need add login here 
	 public AddressPage loginAfterProductSearch(String uname, String pwd) {
		 customerName.sendKeys(uname); 
		 customerPassWord.sendKeys(pwd);
		 Action.click(driver, logInBtn);
		 return new AddressPage();
	 }
	 
	 public AccountCreationPage createAccount() {
		
		 Action.click(driver, registrationBtn);
		 return new AccountCreationPage();
	 }
//	 

}
