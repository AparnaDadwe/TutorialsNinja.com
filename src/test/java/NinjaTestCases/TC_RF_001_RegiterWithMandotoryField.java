package NinjaTestCases;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import NinjaPages.NinjaAccountSuccessPage;
import NinjaPages.NinjaHomePage;
import NinjaPages.NinjaRegisterPage;
import utilityComponents.BaseNinja;
import utilityComponents.Utility;

public class TC_RF_001_RegiterWithMandotoryField extends BaseNinja{
	
	WebDriver driver;
	NinjaHomePage homePage;
	NinjaRegisterPage registerPage;
	NinjaAccountSuccessPage accountSuccessPage;
	@BeforeMethod
	public void setUp() {
		
	  driver=initilizeWebDriver();
	  homePage= new NinjaHomePage(driver);
	  registerPage= new NinjaRegisterPage(driver);
	  accountSuccessPage=new NinjaAccountSuccessPage(driver);
		
	}
	@Test(dataProvider = "registration")
	public void verify_Registration_WithMandotoryField(String firstName,String lastName,String email,String telephone,String password,String confirmpassword)  
	{
		homePage.myAccountDropdown().click();
		homePage.RegisterOption().click();
		registerPage.firstName().sendKeys(firstName);
		registerPage.lastName().sendKeys(lastName);
		registerPage.email().sendKeys(email);
		registerPage.telephone().sendKeys(telephone);
		registerPage.password().sendKeys(password);
		registerPage.confirmPwd().sendKeys(confirmpassword);
		
		registerPage.noRadioButton().click();
		
		
		registerPage.yesRadioButton().click();
		registerPage.privacyPolichyCheckbox().click();
		registerPage.continueBtn().click();
		
		String expectedTitle="Your Account Has Been Created!";
//		System.out.print(accountSuccessPage.getTitle());
		assertEquals(accountSuccessPage.getTitle(), expectedTitle);
		
	}
	@DataProvider(name = "registration")
	public String[][] createAccountDataProvider() throws IOException {
		 //ab yeh data excel se read karna hai 
		List<String> data=Utility.readExcelFile();// excel se data yaha aagaya 
		//Now we not fill array we make array and uska object banana padega
		String[][] createAccountArray = new String[1][6];
		for(int i=0;i<data.size();i++) {
			
			createAccountArray[0][i]=data.get(i);
		
		}
		return createAccountArray;
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
      
}
