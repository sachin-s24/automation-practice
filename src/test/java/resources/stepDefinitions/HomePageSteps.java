package resources.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.pageObjects.HomePage;
import static resources.utils.Constant.*;


public class HomePageSteps {

    HomePage homePage = new HomePage();

    @Given("^I am on the home page$")
    public void i_am_on_the_home_page() throws Throwable {
        homePage.loadUrl(urlHomePage);
    }

    @When("^I add an item to the cart$")
    public void i_add_an_item_to_the_cart() throws Throwable {
        homePage.addItemToCart();
    }

    @When("^I navigate to cart page$")
    public void i_navigate_to_cart_page() throws Throwable {
        homePage.navigateToCartPage();
    }

    @And("^There is an item in the cart dropdown window$")
    public void there_is_an_item_in_the_cart_dropdown_window() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homePage.validateItemInCartDropdown();
    }

    @When("^I hover over the women button$")
    public void i_hover_over_the_women_button() throws Throwable {
        homePage.hoverOverWomenButton();

    }

    @Then("^The summer dresses navigation option should appear$")
    public void the_summer_dresses_navigation_option_should_appear() throws Throwable {
        homePage.validateSummerDressesOption();
    }

    @When("^I click on the summer dresses navigation option$")
    public void i_click_on_the_summer_dresses_navigation_option() throws Throwable {
        homePage.linkSummerDresses.click();
    }
}
