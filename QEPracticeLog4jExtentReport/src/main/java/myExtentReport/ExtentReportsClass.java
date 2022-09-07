package myExtentReport;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsClass {
	public WebDriver driver;
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest logger;

	@BeforeTest
	public void startReport() {

		extent = new ExtentReports();

		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/YahooExtentReport.html");

		extent.attachReporter(spark);

		extent.setSystemInfo("User Name", "Elizabeth");

		extent.setSystemInfo("Track", "QE");

		extent.setSystemInfo("Environment", "Automation Testing");

		extent.setSystemInfo("OS", "Mac");

		spark.config().setDocumentTitle("Yahoo");

		spark.config().setReportName("Yahoo Automation Test Extent Report");

		spark.config().setTheme(Theme.STANDARD);
	}

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","/Users/elizabeth/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.yahoo.com/account/create");
	}
		
		@Test
		public void verifyURL() {
		
		logger = extent.createTest("To verify Yahoo URL");
		Assert.assertEquals(driver.getCurrentUrl(),"https://login.yahoo.com/account/create");	
		System.out.println(driver.getCurrentUrl());
		logger.pass("URL retrieved");
		driver.close();

		}
		
		
		@Test
		public void verifyTitle() {

		logger = extent.createTest("To verify Yahoo Title");
		Assert.assertEquals(driver.getTitle(),"Yahoo");		
		logger.pass("Title retrieved");
		System.out.println(driver.getTitle());
		driver.close();

		}
		
		
		@Test
		public void verifyAccountSubmission() {
		logger = extent.createTest("To verify Yahoo");
		
		driver.findElement(By.id("usernamereg-firstName")).click();
		driver.findElement(By.id("usernamereg-firstName")).sendKeys("Barbie");
		logger.info("first name entered");
	
		driver.findElement(By.id("usernamereg-lastName")).click();
		driver.findElement(By.id("usernamereg-lastName")).sendKeys("Lancaster");
		logger.info("last name entered");

	
		driver.findElement(By.id("usernamereg-userId")).click();
		driver.findElement(By.id("usernamereg-userId")).sendKeys("barbiesbops95000");
		logger.info("yahoo email name entered");

	
		driver.findElement(By.id("usernamereg-password")).click();
		driver.findElement(By.id("usernamereg-password")).sendKeys("123Welcome456789");
		logger.info("password entered");

	
		driver.findElement(By.id("usernamereg-birthYear")).click();
		driver.findElement(By.id("usernamereg-birthYear")).sendKeys("1945");
		logger.info("year entered");

	
		driver.findElement(By.id("reg-submit-button")).click();
		
		logger.pass("Information submitted successfully");
	
		driver.close();
		
		}
	

	@AfterTest
	public void endReport() throws Exception {
		driver.quit();
		Thread.sleep(1000);

		extent.flush();
	}


}

