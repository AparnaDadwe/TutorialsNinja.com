package utilityComponents;


	
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeTest;

	public class BaseClass {
		
		public static WebDriver driver;
		public static Properties properties;
		
		@BeforeTest
		
		public void loadConfig() {
			try {
				
				
				
				properties=new Properties();
				FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"//config//config.properties");
				properties.load(fileInputStream);
				
				
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(IOException e) 
			{
				e.printStackTrace();
			}
			
			
		}
		

		public void launchApp(){
			String browserName=properties.getProperty("browser");
//			String browserName="chrome";
			if(browserName.equalsIgnoreCase("Chrome")) {
	    		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
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
	    	
	    	driver.get(properties.getProperty("url"));
//			driver.get("https://www.target.com/");
	    	driver.manage().window().maximize();
		}

	}



