package SeleniumFrameworks.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SubhamFramework.AbstractComponents.AbstractComponents;

public class productCataloguePage extends AbstractComponents {

	WebDriver driver;
	public productCataloguePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".card-body h5")
	List<WebElement> products;
	
	By productsBy = By.cssSelector(".mb-3");
	By tostContainer = By.cssSelector("#toast-container");
	By InvisibleElement = By.cssSelector(".ng-animating");

	
	public List<WebElement> getproductList()
	{
		waitForElementsToAppear(productsBy);
		return products;
	}
	
	public void addProductToCart(String product)
	{
		    getproductList();
			for(WebElement wb: products)
			{
				if(wb.getText().equalsIgnoreCase(product))
				{
					driver.findElement(By.xpath("//b[text()='IPHONE 13 PRO']/../..//button[text()=' Add To Cart']")).click();
					
					//div[3]//div[1]//div[1]//button[2]
				}
				
			}
			waitForElementsToAppear(tostContainer);
			waitForElementsToInVisible(InvisibleElement);
	}
}

