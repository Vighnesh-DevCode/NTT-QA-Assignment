Feature: Match Details Display
  As a cricket fan
  I want to see match details on the website
  So that I can stay updated with ongoing matches

  Scenario: Verify Match Details
    Given I am on the homepage
    When I go to the live scores section
    Then I should see all ongoing matches
