package SeleniumTutorialsByPavanSir;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownUnderSelectTag {
	
	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.tadobasafaribooking.in/online-safari-booking-tadoba.php");
		driver.manage().window().maximize();
	WebElement dropDownVehicle=	driver.findElement(By.xpath("//select[@id='vehicle']"));
	selectOptionsDropDown(dropDownVehicle, "Full Jeep (6 seats Adult + 2 Child)");
	
	WebElement dropDownZone=	driver.findElement(By.xpath("//select[@id='zone']"));
	selectOptionsDropDown(dropDownZone, "Navegaon/Ramdegi/Nimdela");
	
	WebElement dropDownTime=	driver.findElement(By.xpath("//select[@id='timing']"));
	selectOptionsDropDown(dropDownTime, "06:00 AM to 10:00 AM");
	
//	Select drpDown=new Select(dropDownVehicle);
//	List<WebElement> alldropDownVehiclOption=drpDown.getOptions();
//	for(WebElement vehicle:alldropDownVehiclOption) {
//		if(vehicle.getText().equals("Full Jeep (6 seats Adult + 2 Child)")) {
//			vehicle.click();
//		}
	}
		
	public static void selectOptionsDropDown(WebElement ele, String value) {
		Select drpDown=new Select(ele);
		List<WebElement> alldropDownVehiclOption=drpDown.getOptions();
		for(WebElement vehicle:alldropDownVehiclOption) {
			if(vehicle.getText().equals(value)) {
				vehicle.click();
			}
		}
	}	

	

	}


