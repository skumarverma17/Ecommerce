package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber/OrderSubmission.feature",
				 glue ="SubhamFramework.Stepdefinations",
				 monochrome = true,
				 tags="@regression")
				// plugin= "{\"html:target/cucumber.html\"}")
public class TESTNGtestrunner extends AbstractTestNGCucumberTests {

}
