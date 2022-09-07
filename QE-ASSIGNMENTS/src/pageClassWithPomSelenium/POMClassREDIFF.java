package pageClassWithPomSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class POMClassREDIFF {
	
	WebDriver driver;

	public POMClassREDIFF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input")
	WebElement fullName;

//	"//input[starts-with[@name, 'name')]" 				3 methods: start with / ends with / contains
//	"//input[ends-with[@name, 'name')]" 
//	"//input[contains[@name, 'name')]" 
	
//using xpath axes: 		"//td[text()='Full Name']/following-sibling::td[2]/input"
												//[2] means its 2 down from the parent, you can traverse up too using preceding sibling 
	//w3schools tells you all the ways you can do it 
	
	
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]")
	WebElement rediffEmail;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"newpasswd\"]")
	WebElement password;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"newpasswd1\"]")
	WebElement retypePass;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"div_altemail\"]/table/tbody/tr[1]/td[3]/input")
	WebElement altEmail;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"mobno\"]")
	WebElement mobile;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[1]")
	WebElement day;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[2]")
	WebElement month;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"tblcrtac\"]/tbody/tr[22]/td[3]/select[3]")
	WebElement year;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"div_city\"]/table/tbody/tr[1]/td[3]/select")
	WebElement city;
	
	@FindBy(how = How.ID, using = "Register")
	WebElement register;
	
	public void fillContInfo(String fullName, String rediffEmail, String password, String retypePass, String altEmail, String mobile, String day, String month, String year, String city) {
		this.fullName.sendKeys(fullName);
		this.rediffEmail.sendKeys(rediffEmail);
		this.password.sendKeys(password);
		this.retypePass.sendKeys(retypePass);
		this.altEmail.sendKeys(altEmail);
		this.mobile.sendKeys(mobile);
		this.day.sendKeys(day);
		this.month.sendKeys(month);
		this.year.sendKeys(year);
		this.city.sendKeys(city);
		this.register.click();
}
	
}