package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".\\src\\test\\java\\features\\Create_Integrity_NewAccount_FirstResponder_Interior_InteriorFree_Cash.feature", glue = {
 "steps" },
 dryRun = true,
 monochrome = true,
 plugin = {"pretty", "html:test-output"}
 )
public class Create_Integrity_NewAccount_FirstResponder_Interior_InteriorFree_Cash_Runners {

}
