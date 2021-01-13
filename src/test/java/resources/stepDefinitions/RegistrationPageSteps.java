package resources.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.pageObjects.RegistrationPage;

import static resources.utils.Constant.urlOurStore;

public class RegistrationPageSteps {

    RegistrationPage registrationPage = new RegistrationPage();

    @Then("^I should be redirected to the registration page$")
    public void i_should_be_redirected_to_the_registration_page() throws Throwable {
        registrationPage.validateOnRegistrationPage();
    }

    @Given("^I am on the registration page$")
    public void i_am_on_the_registration_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        registrationPage.validateOnRegistrationPage();
    }

    @When("^I input invalid data into a field$")
    public void i_input_invalid_data_into_a_field() throws Throwable {
        registrationPage.inputInvalidFirstName();

    }

    @When("^I complete the required registration fields with valid data$")
    public void i_complete_the_required_registration_fields_with_valid_data() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        registrationPage.inputFirstName();
        registrationPage.inputLastName();
        registrationPage.inputPassword();
        registrationPage.inputAddress();
        registrationPage.inputCity();
        registrationPage.selectState();
        registrationPage.inputPostalCode();
        registrationPage.selectCountry();
        registrationPage.inputMobileNumber();
    }

    @When("^I click on the register button$")
    public void i_click_on_the_register_button() throws Throwable {
        registrationPage.btnRegister.click();
    }

    @Then("^An error message banner should be displayed$")
    public void an_error_message_banner_should_be_displayed() throws Throwable {
        registrationPage.validateErrorMessageBannerDisplayed();
    }

    @Then("^The incorrect field should display an error$")
    public void the_incorrect_field_should_display_an_error() throws Throwable {
        registrationPage.validateInputFieldErrorDisplayed();
    }


}
