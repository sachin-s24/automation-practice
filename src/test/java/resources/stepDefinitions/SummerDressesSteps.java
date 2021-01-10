package resources.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.pageObjects.SummerDressesPage;
import static resources.utils.Constant.*;

public class SummerDressesSteps {

    SummerDressesPage summerDressesPage = new SummerDressesPage();


    @Then("^Only summer items should be displayed in the results$")
    public void only_summer_items_should_be_displayed_in_the_results() throws Throwable {
        summerDressesPage.validateSummerItemDisplayed();
    }


    @Given("^I am on the summer dresses page$")
    public void i_am_on_the_summer_dresses_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       summerDressesPage.loadUrl(urlSummerDressesPage);
    }

    @When("^I move the slider to my desired price range \"([^\"]*)\"$")
    public void i_move_the_slider_to_my_desired_price_range(String arg1) throws Throwable {
        summerDressesPage.moveRightSliderToDesiredRange(arg1);
    }

    @Then("^The price range should be changed successfully to \"([^\"]*)\"$")
    public void the_price_range_should_be_changed_successfully_to(String arg1) throws Throwable {
        summerDressesPage.validatePriceRange(arg1);
    }

    @Then("^The search results should be updated$")
    public void the_search_results_should_be_updated() throws Throwable {
        summerDressesPage.validateSearchResultUpdated();

    }

    @Then("^The items returned should be within the desired price range of \"([^\"]*)\" and \"([^\"]*)\"$")
    public void the_items_returned_should_be_within_the_desired_price_range_of_and(String arg1, String arg2) throws Throwable {
        summerDressesPage.validateResultPricesInRange(arg1 ,arg2);

    }

}
