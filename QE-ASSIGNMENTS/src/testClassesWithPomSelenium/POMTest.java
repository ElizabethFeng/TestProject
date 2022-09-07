package testClassesWithPomSelenium;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageClassWithPomSelenium.POMClassREDIFF;
import pageClassWithPomSelenium.POMClassSAUCEDEMO;
import pageClassWithPomSelenium.POMClassTELERIK;
import pageClassWithPomSelenium.POMClassYAHOO;


public class POMTest {

	WebDriver driver;	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/elizabeth/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void testYahoo() throws Exception {
		POMClassYAHOO POMClassYAHOO;  
		
		POMClassYAHOO  = new POMClassYAHOO(driver);
		
		driver.get("https://login.yahoo.com/account/create");
		
		String titleYahoo = driver.getTitle();
		
		System.out.println("The title of the web page opened is: "+titleYahoo);
				
		Thread.sleep(2000);

		POMClassYAHOO.fillContInfo("barbiesbops95000", "Barbie", "Lancaster", "123Welcome456789","1945");
	
	}
	
	
	@Test
	public void testTelerik() throws Exception {
		
		POMClassTELERIK POMClassTELERIK;  
		
		POMClassTELERIK  = new POMClassTELERIK(driver);
		
		driver.get("https://www.telerik.com/login/v2/telerik#register");
		
		String titleTelerik = driver.getTitle();
		
		System.out.println("The title of the web page opened is: "+titleTelerik);
				
		Thread.sleep(2000);

		POMClassTELERIK.fillContInfo("barbiesbops9500@yahoo.com", "Barbie", "Lancaster", "Nisum","USA","California","123-456-7890");
	
	}
	
	
	
	@Test
	public void testRediff() throws Exception {
		POMClassREDIFF POMClassREDIFF;  
		
		POMClassREDIFF  = new POMClassREDIFF(driver);
		
		driver.get("http://register.rediff.com/register/register.php?FormName=user_details");
		
		String titleRediff = driver.getTitle();
		
		System.out.println("The title of the web page opened is: "+titleRediff);
				
		Thread.sleep(2000);

		POMClassREDIFF.fillContInfo("Barbie Lancaster", "barbiesbops95000", "123Welcome456789", "123Welcome456789","barbie.12345@gmail.com","1234567890","15","JAN","2000","Agartala");
	
	}
	


	@Test
	public void testSAUCEDEMO() throws Exception {
		POMClassSAUCEDEMO POMClassSAUCEDEMO;  
		
		POMClassSAUCEDEMO  = new POMClassSAUCEDEMO(driver);
		
		driver.get("https://www.saucedemo.com/");
		
		String titleSauceDemo = driver.getTitle();
		
		System.out.println("The title of the web page opened is: "+titleSauceDemo);
				
		Thread.sleep(2000);

		POMClassSAUCEDEMO.fillContInfo("standard_user", "secret_sauce", "RIO", "ARROWHEAD","12345");
	
	}
	


}