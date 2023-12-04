package regressionTestCase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import NoEcommercePage.IndexPage;
import utilityComponents.BaseClass;

public class IndexPageTestCase extends BaseClass {
	
	IndexPage indexPage;
	@BeforeMethod
	public void setUp() {
		
		launchApp();
		indexPage=new IndexPage();
		
	}
	
	@Test
	public void verifyLogo() {
		
		boolean result=indexPage.validateLogo();
		assertTrue(result);
	}
	@Test
	public void  verifyTitle() {
	String actualTite=	indexPage.getTitle();
//System.out.println(actualTite);
	String expectedTitle="nopCommerce demo store";
	assertEquals(actualTite, expectedTitle);
		
		
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
