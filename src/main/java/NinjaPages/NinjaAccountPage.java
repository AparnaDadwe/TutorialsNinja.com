package NinjaPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NinjaAccountPage {
	
WebDriver driver;
	
	public NinjaAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
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
