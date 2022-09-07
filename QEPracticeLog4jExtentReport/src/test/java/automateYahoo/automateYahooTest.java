package automateYahoo;


import PracticeLOG4J.practiceLog4jClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class automateYahooTest extends practiceLog4jClass {

    @Test
    public void test() throws Exception {
		
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

    }
}
