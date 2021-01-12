package resources.stepDefinitions;

import cucumber.api.java.en.Then;
import resources.pageObjects.MyAccountPage;

public class MyAccountPageSteps {
    MyAccountPage myAccountPage = new MyAccountPage();

    @Then("^I should be redirected to the my account page$")
    public void i_should_be_redirected_to_the_my_account_page() throws Throwable {
        myAccountPage.validateOnMyAccountPage();
    }

    @Then("^My account name should be visible in the top right corner$")
    public void my_account_name_should_be_visible_in_the_top_right_corner() throws Throwable {
        myAccountPage.validateAccountName();
    }
}
