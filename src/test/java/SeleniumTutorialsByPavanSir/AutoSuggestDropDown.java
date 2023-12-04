package SeleniumTutorialsByPavanSir;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.get("https://www.target.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Baby");
		Thread.sleep(3000);
		List<WebElement> searchList=driver.findElements(By.xpath("//ul[@class='notranslate']//li"));
		System.out.println("Size of the searchlist is :" + searchList.size());
		//auto suggestion means it gives related option whavever we send input 
		//ex we seng Baby in search box then tehre is different autosuggestion regardin Baby wipes, Baby grils clothes etc
		//i want to select Baby grils clothes then we have to apply different logic
		//we have to get all the element from list and 
		
		for(WebElement searchItem:searchList) {
			if(searchItem.getText().contains("girl clothes")) {
				searchItem.click();
				break;
			}
		}

	}

}
