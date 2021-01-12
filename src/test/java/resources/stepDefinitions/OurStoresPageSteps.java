package resources.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.pageObjects.OurStoresPage;

import static resources.utils.Constant.urlOurStore;

public class OurStoresPageSteps {

    OurStoresPage ourStoresPage = new OurStoresPage();

    @Given("^I am on the our stores page$")
    public void i_am_on_the_our_stores_page() throws Throwable {
        ourStoresPage.loadUrl(urlOurStore);
    }

    @When("^I drag the map downwards and zoom out$")
    public void i_drag_the_map_downwards_and_zoom_out() throws Throwable {
        ourStoresPage.dragAndZoomOut();
    }

    @When("^I take a screenshot$")
    public void i_take_a_screenshot() throws Throwable {
        ourStoresPage.captureScreenshot();
    }

    @Then("^A screenshot displaying stores and West Palm Beach should be saved$")
    public void a_screenshot_displaying_stores_and_West_Palm_Beach_should_be_saved() throws Throwable {
        ourStoresPage.verifyScreenshotCaptured();
    }


}
