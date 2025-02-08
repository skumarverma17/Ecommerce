package SeleniumFrameworks.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SubhamFramework.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents{
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".form-group input")
	WebElement selectcountry;
	
	@FindBy(css=".action__submit")
	WebElement submitorder;
	
	//@FindBy(xpath="//span[.=' India']")
//WebElement submitorder;
	
	@FindBy(xpath="//section//button[2]")
	WebElement countryClick;
	
	
	//By expected = By.cssSelector("[class*=ta-results]");
	By expected = By.xpath("//span[.=' India']");
	
	
	public void selectCountry(String country) throws InterruptedException
	{
		Actions a = new Actions(driver);
		Thread.sleep(3000);
		a.sendKeys(selectcountry,country).build().perform();
		waitForElementsToAppear(expected);
		countryClick.click();
	}
	public ConfirmationPage submitOrder()
	{
		submitorder.click();
		ConfirmationPage confirmpage = new ConfirmationPage(driver);
		return confirmpage;
	}
	

}
