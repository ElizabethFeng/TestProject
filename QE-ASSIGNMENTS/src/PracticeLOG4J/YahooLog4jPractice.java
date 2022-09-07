package PracticeLOG4J;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;

public class YahooLog4jPractice {

	private static Logger log = Logger.getLogger(YahooLog4jPractice.class);

	public static void main(String[] args) throws Exception{ 

		System.setProperty("webdriver.chrome.driver", "/Users/elizabeth/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();			
		log.info("Maximize window size");

		driver.get("https://login.yahoo.com/account/create");
		log.info("Open Yahoo");


		driver.findElement(By.id("usernamereg-firstName")).click();
		driver.findElement(By.id("usernamereg-firstName")).sendKeys("Barbie");
		log.info("enter first name");


		driver.findElement(By.id("usernamereg-lastName")).click();
		driver.findElement(By.id("usernamereg-lastName")).sendKeys("Lancaster");
		log.info("enter last name");


		driver.findElement(By.id("usernamereg-userId")).click();
		driver.findElement(By.id("usernamereg-userId")).sendKeys("barbiesbops95000");
		log.info("enter yahoo email");


		driver.findElement(By.id("usernamereg-password")).click();
		driver.findElement(By.id("usernamereg-password")).sendKeys("123Welcome456789");
		log.info("enter password");


		driver.findElement(By.id("usernamereg-birthYear")).click();
		driver.findElement(By.id("usernamereg-birthYear")).sendKeys("1945");
		log.info("enter birth year");


		driver.findElement(By.id("reg-submit-button")).click();
		log.info("click continue");

		driver.close();

		driver.quit();

		Thread.sleep(1000);

	}
}
