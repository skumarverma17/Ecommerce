package SeleniumFrameworks.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement UserEmail;
	
	@FindBy(id="userPassword")
	WebElement UserPassword;
	
	@FindBy(id="login")
	WebElement Login;
	
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	public productCataloguePage loginPage(String Email, String Password)
	{
		UserEmail.sendKeys(Email);
		UserPassword.sendKeys(Password);
		Login.click();
		productCataloguePage pcat = new productCataloguePage(driver);
		return pcat;
	}
	
	

}
