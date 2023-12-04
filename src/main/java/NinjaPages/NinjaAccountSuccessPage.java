package NinjaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NinjaAccountSuccessPage {
	WebDriver driver;
	
	public NinjaAccountSuccessPage(WebDriver driver)
	{
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		String actualTitle=driver.getTitle();
		return actualTitle;
	}
	
	
}
