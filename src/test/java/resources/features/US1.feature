Feature: User Can Delete The Item From Basket Page

  @Start
  Scenario: Add Item To Cart
    Given I am on the home page
    When I add an item to the cart
    And I navigate to cart page
    Then The item should be visible in the cart

  Scenario: Validate Delete Button Exists
    Given I am on the home page
    And There is an item in the cart dropdown window
    When I navigate to cart page
    Then The delete button should be visible

  @End
  Scenario: Remove Item From Cart & Check Banner
    Given I am on the cart page
    And There is an item in the cart
    When I click on the delete button
    Then The item should successfully be removed from the cart
    And The banner must display "Your shopping cart is empty."