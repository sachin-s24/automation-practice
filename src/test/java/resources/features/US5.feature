Feature: User Can View Our Stores On Google Maps Widget

  @Start @End
  Scenario: View Visible Stores On Map And Take Screenshot
    Given I am on the our stores page
    When I drag the map downwards and zoom out
    And I take a screenshot
    Then A screenshot displaying stores and West Palm Beach should be saved