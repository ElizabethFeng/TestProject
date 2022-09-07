package PracticeLOG4J;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class practiceLog4jClass {
	public static WebDriver driver;
	public static Logger log = LogManager.getLogger();

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/elizabeth/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
			log.info("Maximize window size");

	}

	@AfterSuite
	public void tearDown() throws Exception {
		driver.quit();
		Thread.sleep(1000);
	}
}

