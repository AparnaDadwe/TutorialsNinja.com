package regressionTestCase;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import NoEcommercePage.HomePage;
import NoEcommercePage.IndexPage;
import NoEcommercePage.LoginPage;
import utilityComponents.BaseClass;

public class LoginPageTestCase extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	@BeforeMethod
	public void setUp() {
		launchApp();
		indexPage=new IndexPage();
		loginPage=new LoginPage();
		homePage=new HomePage();
			}
	@Test
	public void loginWithValisUsernameAndPassword() throws InterruptedException{
		
		
		loginPage=indexPage.clickOnMyLoginLink();
		
		//homePage= loginPage.login("appu88262@gmail.com", "Aparna@1234");
		indexPage=	loginPage.login(properties.getProperty("userName"),properties.getProperty("password"));
		
		Thread.sleep(2000);
	    String actualIndexPageUrl=indexPage.getCurrentUrl();
         // System.out.println(actualIndexPageUrl);
        String expectedIndexPageUrl="https://demo.nopcommerce.com/";
         assertEquals(actualIndexPageUrl, expectedIndexPageUrl);
		
	}
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}


}
