package SeleniumTutorialsByPavanSir;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JqueryDropDownHandle {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().window().maximize();
		

		driver.findElement(By.xpath("//input[@id='justAnInputBox']")).click();
//        selectChoiceValues(driver, "choice 1");
	//	selectChoiceValues(driver, "choice 2","choice 2 3");
		selectChoiceValues(driver, "all"); 
		
		//here we create one generic method that will select single value , multiple value and all values in dropdownlist
		
		//selectChoiceValues(driver, "choice 1")
		//selectChoiceValues(driver, "choice 2", "choice 22", "choice 23")
		//selectChoiceValues(driver, "all")//it will select all list //here we pass the driver instance
		//String...value it is special syntax in java value is variable which can hold multiple value (if we pass single parameter
		// it can hold , if we can pass the multipple parameter it csn hold , if we pass all parameter it can hold)
		//value variable receivee single , multiple and all choices according to the logic
		//After that we get all choices from the dropdown
		//in if condition we check the value will not contains "all"  means we may select the multiple choices
		//after we write one foreach  loop we read all choicelist from the dropdownItem and capturing the text byt getText()
		//and we compare that our getItem with our value item (whatever item will get from list is compare with expected choice )
		//whenever it is equal we select value whatever we select then its break
	}
	
	public static void selectChoiceValues(WebDriver driver, String...value) {
		
		//first we have to get all the choices from dropdown and then we have to compare the expected choices to actula one
		//that we have to choose then click
		List<WebElement> choiceList=driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		//if(!value[0].equalsIgnoreCase("all")) if thi scondition is false then we execute if block
		if(!value[0].equalsIgnoreCase("all")) {
			for(WebElement items:choiceList) {
				String textItem=items.getText();
				for(String var:value) {
					if(textItem.equals(var)) {
						items.click();
						break;
					}
				}
			}
		   
		}
		//if(!value[0].equalsIgnoreCase("all")) if this condition get true then we execute else statement
		else {
			
			 try {
				 for(WebElement items:choiceList)
					{       
						items.click(); // in that line we get exception so we have to put in exception in try catch block
					}
			 }
			 catch(Exception ElementNotInteractableException) {
				 
			 }
			
		}
	}

}
