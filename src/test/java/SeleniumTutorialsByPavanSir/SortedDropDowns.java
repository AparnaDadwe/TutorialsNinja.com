package SeleniumTutorialsByPavanSir;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//Verify the sorted dropdown means we have to comapre original list to after sorting expected list to sorted list
//here dropdown is under select class so we use getOption method to take all list 
//We will make Select class object 
//how to sort the dropdown options 

public class SortedDropDowns {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Live Posting']")).click();
		
		//here we get dropdown element first 
		
	WebElement	dropDownElement=driver.findElement(By.xpath("//select[@name='category_id']"));
	
	//we have to pass dropDownElement in Select class so make object of select class
	 Select drpSelect =new Select(dropDownElement);
	 //after that passing the dropDownElement we get all dropdown option by getOptions method that return list Of WebElemnt
	List<WebElement> optionsList=drpSelect.getOptions();
	//In optionsList we get all option from dropdown
	//Once we get the list then we have to prepare original list and temporary list so for this we use ArrayList and then we
	//add those list to our original list and expected list
	
	ArrayList originalOptionList=new ArrayList();
	ArrayList temporayOptionList=new ArrayList();
	
	//for each loop to get all optionList
	for(WebElement option:optionsList) 
	{
		originalOptionList.add(option.getText()); //here we add whatever list we get from dropdownoption we add in originalOptionList
		temporayOptionList.add(option.getText()); //here we add whatever list we get from dropdownoption we add in expectedOptionList 
	}
	//once the loop is completed both the originalOptionList and expectedOptionList have the same element
	
	System.out.println("Original List" +originalOptionList);
	System.out.println("Temporary List" +temporayOptionList);
	//we have to keep original list as it is 
	//we have to sort temporayOptionList so for sorting we have to use Collections is predefined class which comtain sort option 
	//which will sort the collection object
	
	Collections.sort(temporayOptionList);// after it will give sorted list
	
	System.out.println("Original List" +originalOptionList);
	System.out.println("Temporary List After Sorting" +temporayOptionList);
	
	//We have to compare our OriginalOption list to the SortedOptionlist 
	//if our OriginalOptionList is equal to SortedOptionlist then we can say that our dropdown option in sorted order
	//if both are not same then our dropdown option in unsorted order
	
	if(originalOptionList.equals(temporayOptionList)) 
	{
		System.out.println("dropDown Sorted");
		
	}
	else {
		System.out.println("dropDown unsorted");
	}
	
	
	
	
	
	
	}

}
