package resources.stepDefinitions;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import resources.pageObjects.BasePage;


public class MasterHooks extends BasePage {

    @Before("@Start")
    public void setup()  {
        driver = initializeDriver();
        driver.manage().window().maximize();
    }

    @After("@End")

    public void tearDownAndScreenshotOnFailure(Scenario scenario) {
        try {
            if (driver != null && scenario.isFailed()) {
                scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
                BasePage.captureScreenshot();
                driver.manage().deleteAllCookies();
                driver.quit();
                driver = null;
            }
            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
                driver = null;
            }
        } catch (Exception e) {
            System.out.println("Methods failed: tearDownAndScreenshotOnFailure, Exception: " + e.getMessage());
        }



/*        driver.manage().deleteAllCookies();
        driver.close();
        driver = null;*/
    }
}
