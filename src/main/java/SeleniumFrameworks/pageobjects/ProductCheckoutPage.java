package SeleniumFrameworks.pageobjects;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SubhamFramework.AbstractComponents.AbstractComponents;

public class ProductCheckoutPage extends AbstractComponents {
	
	WebDriver driver;
	JavascriptExecutor js;
	public ProductCheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartList;
	
	@FindBy(css=".totalRow button")
	WebElement checkOut;
	
	public Boolean getMatchingProduct(String product)
	{
		Boolean expects = cartList.stream().anyMatch(gproduct->gproduct.getText().equalsIgnoreCase(product));
		return expects;
	}
	
	public CheckOutPage scrollPage() throws InterruptedException
	{
		js.executeScript("window.scrollBy(0,300)");
		js.executeScript("arguments[0].click();",checkOut);
		CheckOutPage checkout = new CheckOutPage(driver);
		return checkout;
	}
}
