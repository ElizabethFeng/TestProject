package seleniumYahooTelerikRediffSauce;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class seleniumRediff {

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
	public void testRediffExcel() throws IOException, Exception {
		
		File file = new File("/Users/elizabeth/Desktop/seleniumYahooTelerikRediffSauce.xlsx");
		
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		
		XSSFSheet sheet = wb.getSheet("Rediff");
		
		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");
		Thread.sleep(3000);
		
		//full name
				driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input")).sendKeys(sheet.getRow(1).getCell(0).toString());
				Thread.sleep(1000);
				
		//rediffmail ID
				driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")).sendKeys(sheet.getRow(1).getCell(1).toString());
				Thread.sleep(1000);

		//password
			    
				driver.findElement(By.xpath("//*[@id=\"newpasswd\"]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"newpasswd\"]")).sendKeys(sheet.getRow(1).getCell(2).toString());
				Thread.sleep(1000);
				
		//retype password
				driver.findElement(By.xpath("//*[@id=\"newpasswd1\"]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"newpasswd1\"]")).sendKeys(sheet.getRow(1).getCell(3).toString());
				Thread.sleep(1000);
				
		//alternate email 
				driver.findElement(By.xpath("//*[@id=\"div_altemail\"]/table/tbody/tr[1]/td[3]/input")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"div_altemail\"]/table/tbody/tr[1]/td[3]/input")).sendKeys(sheet.getRow(1).getCell(4).toString());
				Thread.sleep(1000);

		//mobile	
				driver.findElement(By.xpath("//*[@id=\"mobno\"]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"mobno\"]")).sendKeys(sheet.getRow(1).getCell(5).toString());
				Thread.sleep(1000);
				
		//select date of birth		
				//day 
				Select dropDownDay = new Select(driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[1]")));
				dropDownDay.selectByVisibleText("15");
			//	Thread.sleep(1000);


				//month
				Select dropDownMonth = new Select(driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[2]")));
				dropDownMonth.selectByVisibleText("JAN");
			//	Thread.sleep(1000);

				//year
				Select dropDownYear = new Select(driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[3]")));
				dropDownYear.selectByVisibleText("2000");
			//	Thread.sleep(1000);

			
		//i live in 
				//city
					Select dropDownCity = new Select(driver.findElement(By.xpath("//*[@id=\"div_city\"]/table/tbody/tr[1]/td[3]/select")));
					dropDownCity.selectByVisibleText(sheet.getRow(1).getCell(10).toString());
					Thread.sleep(1000);	
		//quit
				driver.findElement(By.id("Register")).click();
				Thread.sleep(2000);				
			
				

		//set expected value 
				String titleExpected = driver.switchTo().alert().getText();
				
				XSSFCell expectedCell = sheet.getRow(1).getCell(11); 

				expectedCell.setCellType(CellType.STRING);
				
				System.out.println(titleExpected);

				
		//set actual value

				String titleActual = driver.switchTo().alert().getText();
				
				XSSFCell actualCell = sheet.getRow(1).getCell(12); 
				
				actualCell.setCellType(CellType.STRING);
				
				actualCell.setCellValue(titleActual);
				
		//set result cell
				
				XSSFCell resultCell = sheet.getRow(1).getCell(13);
				
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
