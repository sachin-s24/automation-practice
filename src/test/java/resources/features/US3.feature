Feature: User Can Change Price Range

  @Start @End
  Scenario: Validate Price Range Slider Updates Search Results Successfully
    Given I am on the summer dresses page
    When I move the slider to my desired price range "$16.00 - $20.00"
    Then The price range should be changed successfully to "$16.00 - $20.00"
    And The search results should be updated
    And The items returned should be within the desired price range of "16" and "20"

