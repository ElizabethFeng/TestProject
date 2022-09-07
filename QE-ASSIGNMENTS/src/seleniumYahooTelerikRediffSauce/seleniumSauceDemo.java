package seleniumYahooTelerikRediffSauce;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
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

public class seleniumSauceDemo {

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
	public void testSauceDemoExcel() throws IOException, Exception   {
		
		File file = new File("/Users/elizabeth/Desktop/seleniumYahooTelerikRediffSauce.xlsx");
		
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		
		XSSFSheet sheet = wb.getSheet("SauceDemo");
		
		driver.get("https://www.saucedemo.com/");
		String title = driver.getTitle();
		System.out.println("The title of the web page opened is: "+title);		
		Thread.sleep(2000);
		
	//username	
		driver.findElement(By.id("user-name")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("user-name")).sendKeys(sheet.getRow(1).getCell(0).toString());
		Thread.sleep(1000);
		
	//password
		
		driver.findElement(By.id("password")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys(sheet.getRow(1).getCell(1).toString());
		Thread.sleep(1000);
	
	//login
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(1000);

	//add product
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(1000);
		
	//go to cart
		driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
		Thread.sleep(1000);
		
	//checkout
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(1000);
		
	//firstname
		driver.findElement(By.id("first-name")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("first-name")).sendKeys(sheet.getRow(1).getCell(2).toString());
		Thread.sleep(1000);
		
	//lastname
		driver.findElement(By.id("last-name")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("last-name")).sendKeys(sheet.getRow(1).getCell(3).toString());
		Thread.sleep(1000);
		
	//zip code
		driver.findElement(By.id("postal-code")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("postal-code")).sendKeys(sheet.getRow(1).getCell(4).toString());
		Thread.sleep(1000);
		
	//continue
		driver.findElement(By.id("continue")).click();
		Thread.sleep(1000);
		
	//finish
		driver.findElement(By.id("finish")).click();
		Thread.sleep(1000);
	
		
//set expected value 
		String titleExpected = driver.findElement(By.tagName("h2")).getText();
		
		XSSFCell expectedCell = sheet.getRow(1).getCell(5); 

		expectedCell.setCellType(CellType.STRING);

		
//set actual value

		String titleActual = driver.findElement(By.tagName("h2")).getText();
		
		XSSFCell actualCell = sheet.getRow(1).getCell(6); 
		
		actualCell.setCellType(CellType.STRING);
		
		actualCell.setCellValue(titleActual);
		
//set result cell
		
		XSSFCell resultCell = sheet.getRow(1).getCell(7);
		
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
