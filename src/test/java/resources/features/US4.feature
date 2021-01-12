Feature: Use can Create New Personal Account


  @Start
  Scenario: Navigate Through Sign In Page
    Given I am on the sign in page
    When I enter a valid email address
    And I click on the create an account button
    Then I should be redirected to the registration page


  Scenario: Enter Invalid Data Into Input Box
    Given I am on the registration page
    When I input invalid data into a field
    Then The incorrect field should display an error


  Scenario: Attempt Account Creation With Invalid Data
    Given I am on the registration page
    When I complete the required registration fields with valid data
    And I input invalid data into a field
    And I click on the register button
    Then An error message banner should be displayed


  Scenario: Navigate Through Sign In Page
    Given I am on the sign in page
    When I enter a valid email address
    And I click on the create an account button
    Then I should be redirected to the registration page

  @End
  Scenario: Attempt Account Creation With Valid Data
    Given I am on the registration page
    When I complete the required registration fields with valid data
    And I click on the register button
    Then I should be redirected to the my account page
    And My account name should be visible in the top right corner
