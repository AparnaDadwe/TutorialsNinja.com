package NinjaTestCases;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import NinjaPages.NinjaAccountPage;
import NinjaPages.NinjaHomePage;
import NinjaPages.NinjaLoginPage;
import utilityComponents.BaseNinja;

public class NinjaLoginTest extends BaseNinja {
	Logger log;
	WebDriver driver;
	NinjaHomePage homePage;
	NinjaLoginPage loginPage;
	NinjaAccountPage acPage;
	
	@BeforeMethod
	public void setUp() {
		log= LogManager.getLogger(NinjaLoginTest.class.getName());
		driver=initilizeWebDriver();
	log.debug("Browser was launched");
		homePage=new NinjaHomePage(driver);
		loginPage=new NinjaLoginPage(driver);
		acPage=new NinjaAccountPage(driver);
	}
	
	@Test(dataProvider = "getLoginData")
 public void verifyLoginCredential(String email, String password, String expectedResult) {
	 
	 homePage.myAccountDropdown().click();
	 log.debug("Clicked on My Account dropdown");
	 homePage.loginOption().click();
	 log.debug("Clicked on login option");
	 
	// loginPage.emailAddressField().sendKeys(props.getProperty("email"));  // this will take from properties file email amd password
	// loginPage.passwordField().sendKeys(props.getProperty("password"));
	 
	 // this email and password take from datprovider
	 loginPage.emailAddressField().sendKeys(email);
	log.debug("Email addressed got entered");
	 loginPage.passwordField().sendKeys(password);
	 log.debug("Password got entered");
	 loginPage.loginButton().click();
	 log.debug("Clicked on Login Button");
	 //after click there is four scenario
	 
	 if(expectedResult.equals("Successful"))
	 {
		//after login check pagetitle
		 
		 acPage.getTitle();
//		 System.out.println(acPage.getTitle());
		 String expextedTitle="My Account";
		log.debug("User got logged in");
		 assertEquals(acPage.getTitle(), expextedTitle);
		 log.info("Login Test got passed");
		 
	 }
	 else if(expectedResult.equals("Failure")) {
		 log.debug("User didn't log in");
			String actualerrorMsg=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
			assertEquals(actualerrorMsg, "Warning: No match for E-Mail Address and/or Password.");
//			log.error("Login Test got failed");
		}
	 
	 
	 
 }
	//here we using dataprovider by taking valid and invalid credential without taking credential from property file
	@DataProvider
	public Object[][] getLoginData() {
		
		Object[][] multipleUserLoginCredential= {{"shraddhadadwe123@gmail.com","Shraddha@1234","Successful"},{"appu88262@gmail.com","Aparna@1234","Failure"}};
	    return multipleUserLoginCredential;
	
	}
	
	
//	@AfterMethod
 public void tearDown()
	{
	 driver.quit();
	log.debug("Browser got closed");
 }
	

}
