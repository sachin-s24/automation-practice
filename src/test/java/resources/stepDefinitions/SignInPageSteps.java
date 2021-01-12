package resources.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import resources.pageObjects.SignInPage;
import static resources.utils.Constant.urlSignInPage;

public class SignInPageSteps {

    SignInPage signInPage = new SignInPage();

    @Given("^I am on the sign in page$")
    public void i_am_on_the_sign_in_page() throws Throwable {
       signInPage.loadUrl(urlSignInPage);
    }

    @When("^I enter a valid email address$")
    public void i_enter_a_valid_email_address() throws Throwable {
        signInPage.enterValidEmail();
    }

    @When("^I click on the create an account button$")
    public void i_click_on_the_create_an_account_button() throws Throwable {
        signInPage.clickCreateAccountButton();
    }

}
