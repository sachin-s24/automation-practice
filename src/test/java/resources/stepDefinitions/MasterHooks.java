package resources.stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import resources.BasePage;


public class MasterHooks extends BasePage {

    @Before
    public void setup() {
        driver = initializeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        driver.manage().deleteAllCookies();
        driver.quit();
        driver = null;
    }
}
