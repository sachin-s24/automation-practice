package resources.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.pageObjects.CartPage;
import static resources.utils.Constant.*;

public class CartPageSteps  {
    CartPage cartPage = new CartPage();

    @Given("^I am on the cart page$")
    public void i_am_on_the_cart_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        cartPage.loadUrl(urlCartPage);
    }

    @Then("^The item should be visible in the cart$")
    public void the_item_should_be_visible_in_the_cart() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        cartPage.validateItemInCart();
    }

    @And("^There is an item in the cart$")
    public void there_is_an_item_in_the_cart() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        cartPage.validateItemInCart();
    }

    @Then("^The delete button should be visible$")
    public void the_delete_button_should_be_visible() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        cartPage.validateCartDeleteBtn();
    }

    @When("^I click on the delete button$")
    public void i_click_on_the_delete_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        cartPage.btnDeleteCart.click();
    }

    @Then("^The item should successfully be removed from the cart$")
    public void the_item_should_successfully_be_removed_from_the_cart() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        cartPage.validateNoItemInCart();
    }


    @Then("^The banner must display \"([^\"]*)\"$")
    public void the_banner_must_display(String arg1) throws Throwable {
        cartPage.validateBannerMessage(arg1);

    }


}
