package resources.stepDefinitions;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import resources.pageObjects.BasePage;
import cucumber.api.Scenario;


public class MasterHooks extends BasePage {

    @Before("@Start")
    public void setup()  {
        driver = initializeDriver();
        driver.manage().window().maximize();
    }

    @After("@End")

    public void teardown() {
        driver.manage().deleteAllCookies();
        driver.close();
        driver = null;
    }
}
