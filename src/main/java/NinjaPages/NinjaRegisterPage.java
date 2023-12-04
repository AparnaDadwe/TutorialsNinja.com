package NinjaPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NinjaRegisterPage {
	
	WebDriver driver;
	
	public NinjaRegisterPage(WebDriver driver){
		this.driver=driver;
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath ="//input[@id='input-firstname']")
	WebElement firstName;
	
	@FindBy(xpath ="//input[@id='input-lastname']")
	WebElement lastName;

	@FindBy(xpath ="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath ="//input[@id='input-telephone']")
	WebElement telephone;
	
	@FindBy(xpath ="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath ="//input[@id='input-confirm']")
	WebElement confirmPwd;
	
	@FindBy(xpath ="//input[@name='newsletter' and @value='1']")
	WebElement yesRadioButton;
	
	@FindBy(xpath ="//input[@name='newsletter' and @value='1']")
	WebElement noRadioButton;
	
	@FindBy(xpath = "//input[@type='checkbox' and @name='agree']")
	WebElement privacyPolichyCheckbox;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Continue']")
	WebElement continueBtn;
	
	public WebElement firstName() {
		return firstName;
	}
	public WebElement lastName() {
		return lastName;
	}
	public WebElement email() {
		return email;
	}
	public WebElement telephone() {
		return telephone;
	}
	public WebElement password() {
		return password;
	}
	public WebElement confirmPwd() {
		return confirmPwd;
	}
	public WebElement privacyPolichyCheckbox() {
		return privacyPolichyCheckbox;
	}
	
	public WebElement continueBtn() {
		return continueBtn;
	}
	public WebElement yesRadioButton() {
		return yesRadioButton;
	}
	public WebElement noRadioButton() {
//		boolean sele=noRadioButton().isSelected();
//		System.out.print(sele);
//		if(sele==false) {
//			noRadioButton().click();
//		}
		return noRadioButton;
	}
	
//	 public List<WebElement> getAllRadioButton() {
//		    List<WebElement>allRadioButton=driver.findElements(By.xpath("//div[@class='form-group']"));
//		    for(WebElement oneByOneRadioButton:allRadioButton) 
//		    {
//		    	if(!(oneByOneRadioButton.isSelected()))
//		    	{
//		    		oneByOneRadioButton.click();
//		    	}
//		    }
//		    return allRadioButton;
//		    }

}
