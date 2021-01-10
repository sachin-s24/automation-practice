Feature: User Can View Items From Summer Collection

  @Start
  Scenario: Validate Women Sub-Navigation Options Appear
    Given I am on the home page
    When I hover over the women button
    Then The summer dresses navigation option should appear

  @End
  Scenario: Validate Only Summer Items Displayed In Results
    Given I am on the home page
    When I hover over the women button
    And I click on the summer dresses navigation option
    Then Only summer items should be displayed in the results
