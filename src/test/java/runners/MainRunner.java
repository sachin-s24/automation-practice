
package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/java/resources/features/"} ,
        glue = {"resources.stepDefinitions"} ,
        monochrome = true ,
        plugin = { "pretty"})

public class MainRunner extends AbstractTestNGCucumberTests {
}
