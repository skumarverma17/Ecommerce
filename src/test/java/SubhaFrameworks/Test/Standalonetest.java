package SubhaFrameworks.Test;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Standalonetest {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		String product = "IPHONE 13 PRO";
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get("https://rahulshettyacademy.com/client/");
		 driver.manage().window().maximize();
		 driver.findElement(By.id("userEmail")).sendKeys("subh@gmail.com");
		 driver.findElement(By.id("userPassword")).sendKeys("Snapdragon1702@");
		 driver.findElement(By.id("login")).click();
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		 
		 List<WebElement> products =  driver.findElements(By.cssSelector(".card-body h5"));
		for(WebElement wb: products)
		{
			if(wb.getText().equalsIgnoreCase(product))
			{
				driver.findElement(By.xpath("//div[3]//div[1]//div[1]//button[2]")).click();
			}
			
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List <WebElement> cartlist= driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean expects = cartlist.stream().anyMatch(gproduct->gproduct.getText().equalsIgnoreCase(product));
		Assert.assertTrue(expects);
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ng-star-inserted")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		js.executeScript("arguments[0].click();",driver.findElement(By.cssSelector(".totalRow button")));
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector(".form-group input")),"india").build().perform();
	//	driver.findElement(By.cssSelector(".form-group input")).sendKeys("india");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class*=ta-results]")));
		driver.findElement(By.xpath("//section//button[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*=hero-primary]")));
		String message = (driver.findElement(By.cssSelector("[class*=hero-primary]")).getText());
		Assert.assertEquals(message,"THANKYOU FOR THE ORDER.");
		driver.close();
	}
}
