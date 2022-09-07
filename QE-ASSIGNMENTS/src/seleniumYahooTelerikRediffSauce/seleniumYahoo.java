package seleniumYahooTelerikRediffSauce;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.collect.Table.Cell;

public class seleniumYahoo {
	
	WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/elizabeth/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		Thread.sleep(1000);
	}

	@Test
	public void testYahooExcel() throws IOException, Exception {
		
		File file = new File("/Users/elizabeth/Desktop/seleniumYahooTelerikRediffSauce.xlsx");
		
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		
		XSSFSheet sheet = wb.getSheet("Yahoo");
				
		driver.get("https://login.yahoo.com/account/create");
		Thread.sleep(3000);
		
		driver.findElement(By.id("usernamereg-firstName")).click();
		Thread.sleep(100);		
		driver.findElement(By.id("usernamereg-firstName")).sendKeys(sheet.getRow(1).getCell(0).toString());
		Thread.sleep(100);

		driver.findElement(By.id("usernamereg-lastName")).click();
		Thread.sleep(100);
		driver.findElement(By.id("usernamereg-lastName")).sendKeys(sheet.getRow(1).getCell(1).toString());
		Thread.sleep(100);


		driver.findElement(By.id("usernamereg-userId")).click();
		Thread.sleep(100);
		driver.findElement(By.id("usernamereg-userId")).sendKeys(sheet.getRow(1).getCell(2).toString());
		Thread.sleep(100);

		driver.findElement(By.id("usernamereg-password")).click();
		Thread.sleep(100);
		driver.findElement(By.id("usernamereg-password")).sendKeys(sheet.getRow(1).getCell(3).toString());
		Thread.sleep(100);


		driver.findElement(By.id("usernamereg-birthYear")).click();
		Thread.sleep(100);
		driver.findElement(By.id("usernamereg-birthYear")).sendKeys(sheet.getRow(1).getCell(4).toString());
		Thread.sleep(100);
		
//quit
		driver.findElement(By.id("reg-submit-button")).click();
		Thread.sleep(1000);	
		
		
//set expected value 
		String titleAccount = driver.findElement(By.tagName("h2")).getText();
		
		XSSFCell expectedCell = sheet.getRow(1).getCell(5); 

		expectedCell.setCellType(CellType.STRING);

		
//set actual value

		String title = driver.findElement(By.tagName("h2")).getText();
		
		XSSFCell actualCell = sheet.getRow(1).getCell(6); 
		
		actualCell.setCellType(CellType.STRING);
		
		actualCell.setCellValue(title);
		
//set result cell
		
		XSSFCell resultCell = sheet.getRow(1).getCell(7);
		
		resultCell.setCellType(CellType.STRING);
	
		if (actualCell.toString().contains(title)) {
			
			resultCell.setCellValue("PASS");
			
		}
		
		else { 
			
			resultCell.setCellValue("FAIL");

		}
		
		
		FileOutputStream outputStream = new FileOutputStream("/Users/elizabeth/Desktop/seleniumYahooTelerikRediffSauce.xlsx");
		wb.write(outputStream);
		outputStream.close();
		wb.close();

		
	}

}
