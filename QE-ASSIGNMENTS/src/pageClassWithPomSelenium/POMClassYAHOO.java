package pageClassWithPomSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class POMClassYAHOO {

	WebDriver driver;
	
	public POMClassYAHOO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "usernamereg-firstName")
	WebElement firstName;
	
	@FindBy(how = How.ID, using = "usernamereg-lastName")
	WebElement lastName;
	
	@FindBy(how = How.ID, using = "usernamereg-userId")
	WebElement yahooEmail;
	
	@FindBy(how = How.ID, using = "usernamereg-password")
	WebElement password;
	
	@FindBy(how = How.ID, using = "usernamereg-birthYear")
	WebElement birthYear;
	
	@FindBy(how = How.ID, using = "reg-submit-button")
	WebElement submit;
	
		
	public void fillContInfo(String yahooEmail, String firstName, String lastName, String password, String birthYear) {
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.yahooEmail.sendKeys(yahooEmail);
		this.password.sendKeys(password);
		this.birthYear.sendKeys(birthYear);
		this.submit.click();
		
	}

}
