@sanity
Feature: Verify Cookbooks Screen

  Scenario: Reopen app
    Given App is reopened
    When App is opened
    Then Main screen is displayed

  Scenario: Open Cookbooks Screen
    Given Main screen is displayed properly
    When User opens Cookbooks screen
    Then Cookbooks screen is displayed
