package pageClassWithPomSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class POMClassTELERIK {

	WebDriver driver;
	
	public POMClassTELERIK(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "Email-1")
	WebElement emailTelerik;
	
	@FindBy(how = How.ID, using = "Textbox-1")
	WebElement firstNames;
	
	@FindBy(how = How.ID, using = "Textbox-2")
	WebElement lastNames;
	
	@FindBy(how = How.ID, using = "Textbox-3")
	WebElement company;
	
	@FindBy(how = How.ID, using = "Country-1")
	WebElement country;
	
	@FindBy(how = How.ID, using = "State-1")
	WebElement state;
	
	@FindBy(how = How.ID, using = "Textbox-4")
	WebElement phoneNumber;
	
	@FindBy(how = How.TAG_NAME, using = "button")
	WebElement submitAccount;
		
	public void fillContInfo(String emailTelerik, String firstNames, String lastNames, String company, String country, String state, String phoneNumber) {
		this.emailTelerik.sendKeys(emailTelerik);
		this.firstNames.sendKeys(firstNames);
		this.lastNames.sendKeys(lastNames);
		this.company.sendKeys(company);
		this.country.sendKeys(country);
		this.state.sendKeys(state);
		this.phoneNumber.sendKeys(phoneNumber);
		this.submitAccount.click();;
	}
}
