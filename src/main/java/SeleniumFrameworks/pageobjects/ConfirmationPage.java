package SeleniumFrameworks.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SubhamFramework.AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents{
	
	WebDriver driver;
	JavascriptExecutor js;
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[class*=hero-primary]")
	WebElement confirmMessage;
	
	By waitConfirmMessage = By.cssSelector("[class*=hero-primary]");
	
	public String getConfirmationMessage()
	{
		waitForElementsToAppear(waitConfirmMessage);
		String message = confirmMessage.getText();
		return message;
	}

}
