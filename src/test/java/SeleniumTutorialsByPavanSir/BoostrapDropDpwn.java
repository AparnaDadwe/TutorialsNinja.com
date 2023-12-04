package SeleniumTutorialsByPavanSir;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//BoostrapDown means which is not under select tag it is in anchor tag then we called as boostrap drodown
public class BoostrapDropDpwn {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();
		
		
		List<WebElement> producTypeList=driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']//li"));
		
		System.out.println(producTypeList.size());
		
		selectOptionFromDropDown(producTypeList, "Account");
		
		//logic for product type this -- we have to get all list by using for loop and we have to compare with expected option if both
		// are equal then click 
		
//		for(WebElement productType:producTypeList) {
//			if(productType.getText().equals("Accounts")) {
//				productType.click();
//				break;
//			}
//		}
		
		//logic for product
		driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']")).click();
		
		List<WebElement> producList=driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']//li"));
		
		System.out.println(producList.size());
		
		selectOptionFromDropDown(producList, "Salary Accounts");
		
//		for(WebElement product:producList) {
//			if(product.getText().equals("Salary Accounts")) {
//				product.click();
//				break;
//			}
//		}
		
		//If there is multidropdown which is boostrap then every time we have write that code so we can make one generic method 
		//for boostrap doropdown
		
		

	}
	//this method will take 2 argument list<webelement> ,options String value (options means what we )
	
	public static void selectOptionFromDropDown(List<WebElement> options,String value) {
		for(WebElement option:options) {
			if(option.getText().equals("Accounts")) {
				option.click();
				break;
			}
		}
	}

}
