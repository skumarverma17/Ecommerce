package SubhamFramework.Stepdefinations;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import SubhamFramework.TestComponents.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class GlobalHooks extends BaseTest{

	ExtentReports report;
	public static ExtentTest test;
	public static ExtentTest node;
	
	
	@Before
	public void beforeScenario(Scenario scenario)
	{
		report = new ExtentReports();
		String file = System.getProperty("user.dir") + "//Reports//index.html";
		ExtentSparkReporter reports = new ExtentSparkReporter(file);
		report.attachReporter(reports);
		//reports.config().setTheme(Theme.DARK);
		reports.config().setDocumentTitle("Ecommerce");
		reports.config().setReportName("Order placing");
		report.setSystemInfo("OS",System.getProperty("os.name"));
		report.setSystemInfo("Java Version", System.getProperty("java.version"));
		test = report.createTest(scenario.getName());
		
		
	}
	
	@AfterStep
	public void afterStep(Scenario scenario) throws IOException
	{
		if(scenario.getStatus().toString().equals("PASSED")) {
			node.log(Status.PASS, "This step has been passed")
			.pass(MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(),"Screenshot").build());
		}
		if(scenario.getStatus().toString().equals("FAILED")) {
			node.log(Status.FAIL, "This step has been failed")
			.fail(MediaEntityBuilder.createScreenCaptureFromPath(getScreenshot(),"Screenshot").build());
		}
	}
	
	@After
	public void afterScenario() {
		report.flush();
		
	}

	}


