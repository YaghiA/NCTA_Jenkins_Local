package runners;
import java.io.File;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import util.Internal_Common;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"Integrity\\features"}, 

glue= {"steps"},
 dryRun = false,
 monochrome = false,
 plugin = {"pretty", "html:target/cucumber","json:target/cucumber.json","com.cucumber.listener.ExtentCucumberFormatter: target/report.html"},
		
		tags = {"@sm"}
		)
public class Runner1 extends AbstractTestNGCucumberTests{
//	@AfterClass
//	public static void writeExtentReport() throws IOException {
//		Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "\\src\\main\\java\\util\\ReportsConfig.xml"));
//		//Internal_Common.copyLatestExtentReport();
	
}
