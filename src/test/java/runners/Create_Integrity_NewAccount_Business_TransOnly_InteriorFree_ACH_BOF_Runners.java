package runners;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@RunWith(Cucumber.class)
@CucumberOptions(features = ".\\src\\test\\java\\features\\Create_Integrity_NewAccount_Business_TransOnly_InteriorFree_ACH_BOF.feature", glue = {
 "steps" },
 dryRun = false,
 monochrome = true,
 tags= {},
 plugin = {"pretty", "html:target/cucumber","json:target/cucumber.json","com.cucumber.listener.ExtentCucumberFormatter: target/report.html"}
 )
public class Create_Integrity_NewAccount_Business_TransOnly_InteriorFree_ACH_BOF_Runners extends AbstractTestNGCucumberTests {

}
