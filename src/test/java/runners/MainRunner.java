
package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/java/resources/features/US1.feature"} ,
        glue = {"resources.stepDefinitions"} ,
        monochrome = true )

public class MainRunner extends AbstractTestNGCucumberTests {
}
