package runners;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/java/features/Create_Web_NewAccount_Personal_ExteriorFree_CC.feature", glue = {
 "steps" },
 dryRun = true,
 monochrome = true,
 plugin = {"pretty", "html:test-output"}
 )
public class Create_Web_NewAccount_Personal_ExteriorFree_CC {

}
