package utilityComponents;

import java.beans.PropertyChangeSupport;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseNinja {
	
	WebDriver driver;
	public Properties props;
	public WebDriver initilizeWebDriver() {
		
		
		try {
			 props=new Properties();
			FileInputStream fileInputStream;
			fileInputStream = new FileInputStream(System.getProperty("user.dir")+"//config//config.properties");
			props.load(fileInputStream);
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String browserName=props.getProperty("browser");
//		String browserName="chrome";
		if(browserName.equalsIgnoreCase("Chrome")) {
//    		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
    		driver=new ChromeDriver();
    	}
    	else if(browserName.equalsIgnoreCase("Edge")){
    		System.setProperty("webdriver.edge.driver", "driver/msedgedriver.exe");
   		 driver =new EdgeDriver(); 
    	}
    	else if(browserName.equalsIgnoreCase("FireFox")) {
    		System.setProperty("webdriver.firefox.driver", "driver/geckodriver.exe");
    		driver=new FirefoxDriver();
    	}
    	else {
    		System.out.print("No Supported browser found");
    	}
    	
    	driver.get(props.getProperty("url"));
//		driver.get("https://www.target.com/");
    	driver.manage().window().maximize();
    	
    	return driver;
	}

}
