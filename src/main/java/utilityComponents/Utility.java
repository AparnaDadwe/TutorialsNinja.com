package utilityComponents;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Utility {
	
	public static WebDriver getDriver() {
		// yeh method webdriver ko initialize karake uska instance return karega
		WebDriver driver = new ChromeDriver();
		return driver;

	}
	
	public static String getProperty(String key) throws IOException {
		
		File file = new File("src/test/resources/data.properties");
		FileInputStream fileInputStream = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(fileInputStream);
		return properties.getProperty(key); // ya hai key ka properties milenga

	}
	
	public static List<String> readExcelFile() throws IOException {

		File file = new File("config/registration.xls");

		FileInputStream fileInputStream = new FileInputStream(file);

		List<String> userRegistrationDetails = new ArrayList<String>();

		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
	

		HSSFSheet sheet = hssfWorkbook.getSheetAt(0);

		int lastRowNumber = sheet.getLastRowNum();

		int lastCellNumber = 0;

		for (int i = 1; i <= lastRowNumber; i++) {
			HSSFRow row = sheet.getRow(i);// ek ek row iterate hoga
			lastCellNumber = row.getLastCellNum(); // row ke andar cell hote hai isliye getLastCellNum() method
			for (int j = 0; j < lastCellNumber; j++) // it will iterate all cell inside the row
			{

				userRegistrationDetails.add(row.getCell(j).getStringCellValue());
				
//				switch(cell.getCellType()) {
//		  		  case
//		  		  STRING:System.out.print(cell.getStringCellValue()+"   ");
//		  		  break; 
//		  		  case
//		  		  NUMERIC:System.out.print(cell.getNumericCellValue()+"  ");
//		  		  break; 
//		  		  case
//		  		  BOOLEAN:System.out.print(cell.getBooleanCellValue()+" "); 
//		  		  }

			}
		}
		return userRegistrationDetails;
	}

	

}
