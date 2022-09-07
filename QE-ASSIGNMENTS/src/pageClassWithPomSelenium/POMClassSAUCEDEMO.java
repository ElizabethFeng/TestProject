package pageClassWithPomSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class POMClassSAUCEDEMO {

	WebDriver driver;
	
	public POMClassSAUCEDEMO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "user-name")
	WebElement userName;
	
	@FindBy(how = How.ID, using = "password")
	WebElement password;
	
	@FindBy(how = How.ID, using = "login-button")
	WebElement login;
	
	@FindBy(how = How.ID, using = "add-to-cart-sauce-labs-backpack")
	WebElement addCart;
	
	@FindBy(how = How.CLASS_NAME, using = "shopping_cart_badge")
	WebElement goCart;
	
	@FindBy(how = How.ID, using = "checkout")
	WebElement checkout;
	
	@FindBy(how = How.ID, using = "first-name")
	WebElement firstName;
	
	@FindBy(how = How.ID, using = "last-name")
	WebElement lastName;
	
	@FindBy(how = How.ID, using = "postal-code")
	WebElement zip;
	
	@FindBy(how = How.ID, using = "continue")
	WebElement Continue;
	
	@FindBy(how = How.ID, using = "finish")
	WebElement finish;
			
	public void fillContInfo(String userName, String password, String firstName, String lastName, String zip) throws Exception {
		this.userName.sendKeys(userName);
		this.password.sendKeys(password);
		this.login.click();
		this.addCart.click();
		this.goCart.click();
		this.checkout.click();
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.zip.sendKeys(zip);
		this.Continue.click();
		this.finish.click();
		
	}	
	
}

