package SubhamFramework.TestComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import SeleniumFrameworks.pageobjects.LandingPage;
import SubhamFramework.Stepdefinations.GlobalHooks;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	
	public static WebDriver driver;
	 public WebDriver initializeDriver() throws IOException
	 {
		 Properties prop = new Properties();
		 FileInputStream isd = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\SubhamFramework\\resources\\GlobalData.properties");
		 prop.load(isd);
		 String browsername = prop.getProperty("browser");
		 if(browsername.equalsIgnoreCase("Chrome"))
		 {
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		 }
		 else if(browsername.equalsIgnoreCase("edge"))
		 {
			 WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
		 }
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		 driver.manage().window().maximize();
		 return driver;
	 }
	 
	 public LandingPage launchApplication() throws IOException
	 {
		 driver = initializeDriver();
		 LandingPage obj = new LandingPage(driver);
		 obj.goTo();
		 GlobalHooks.node.log(Status.PASS, MarkupHelper.createLabel("user launched app url successfully", ExtentColor.GREEN)).pass(MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(),"Screenshot").build());
		 return obj;
	 }
	 
	 public String getScreenshot() throws IOException
	 {
		 SimpleDateFormat formatter = new SimpleDateFormat("ddMMMyyyy HHmmssSSS");
		 Date date = new Date();
		 String formattedDate = formatter.format(date);
		 TakesScreenshot ts = (TakesScreenshot)driver;
		 byte[] source = ts.getScreenshotAs(OutputType.BYTES);
		 FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\reports\\"+formattedDate+".png");
		 file.write(source);
		 file.close();
		 return System.getProperty("user.dir")+"\\reports"+formattedDate+".png";
		 
	 }
	 
	 public void teardown()
	 {
		 driver.close();
	 }
	 

}
