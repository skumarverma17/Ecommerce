package SubhamFramework.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumFrameworks.pageobjects.ProductCheckoutPage;

public class AbstractComponents {

	WebDriver driver;
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="[routerlink*='cart']")
	WebElement clickcart;
	
	public void waitForElementsToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(6));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementsToInVisible(By invisibleElement)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(invisibleElement));
	}
	
	public ProductCheckoutPage clickToCart() throws InterruptedException
	{
		Thread.sleep(1000);
		clickcart.click();
		ProductCheckoutPage prodcheck = new ProductCheckoutPage(driver);
		return prodcheck;
	}
	
	
	 
	
	
}
