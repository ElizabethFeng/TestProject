package seleniumYahooTelerikRediffSauce;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
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
import org.openqa.selenium.support.ui.Select;

public class seleniumTelerik {

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
		Thread.sleep(3000);
	}

	@Test
	public void testTelerikExcel() throws IOException, Exception{
		File file = new File("/Users/elizabeth/Desktop/seleniumYahooTelerikRediffSauce.xlsx");
		
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		
		XSSFSheet sheet = wb.getSheet("Telerik");
				
		driver.get("https://www.telerik.com/login/v2/telerik#register");
		Thread.sleep(3000);
		
		driver.findElement(By.id("Email-1")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Email-1")).sendKeys(sheet.getRow(1).getCell(0).toString());
		Thread.sleep(2000);
		
		driver.findElement(By.id("Textbox-1")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Textbox-1")).sendKeys(sheet.getRow(1).getCell(1).toString());
		Thread.sleep(2000);
		
		driver.findElement(By.id("Textbox-2")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Textbox-2")).sendKeys(sheet.getRow(1).getCell(2).toString());
		Thread.sleep(2000);

		driver.findElement(By.id("Textbox-3")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Textbox-3")).sendKeys(sheet.getRow(1).getCell(3).toString());
		Thread.sleep(2000);
		
		//country
		Select dropDownCountry = new Select(driver.findElement(By.id("Country-1")));
		Thread.sleep(3000);		
		dropDownCountry.selectByVisibleText(sheet.getRow(1).getCell(4).toString());
		Thread.sleep(3000);		
	
		//state
		Select dropDownState = new Select(driver.findElement(By.id("State-1")));
		Thread.sleep(3000);		
		dropDownState.selectByVisibleText(sheet.getRow(1).getCell(5).toString());
		Thread.sleep(3000);	
			
		driver.findElement(By.id("Textbox-4")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("Textbox-4")).sendKeys(sheet.getRow(1).getCell(6).toString());
		Thread.sleep(3000);
		
//create account		
		driver.findElement(By.xpath("//*[@id=\"form--1\"]/div[3]/div[10]/button")).click();
		Thread.sleep(2000);			
		
		
//set expected value 
		String titleExpected = driver.findElement(By.tagName("p")).getText();
		
		XSSFCell expectedCell = sheet.getRow(1).getCell(7); 

		expectedCell.setCellType(CellType.STRING);

		
//set actual value

		String titleActual = driver.findElement(By.tagName("p")).getText();
		
		XSSFCell actualCell = sheet.getRow(1).getCell(8); 
		
		actualCell.setCellType(CellType.STRING);
		
		actualCell.setCellValue(titleActual);
		
//set result cell
		
		XSSFCell resultCell = sheet.getRow(1).getCell(9);
		
		resultCell.setCellType(CellType.STRING);
	
		if (actualCell.toString().contains(titleExpected)) {
			
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
