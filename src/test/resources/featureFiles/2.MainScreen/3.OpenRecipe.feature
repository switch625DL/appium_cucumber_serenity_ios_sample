@sanity
  Feature: Opening a recipe from Main Screen

    Scenario: Reopen app
      Given App is reopened
      When App is opened
      Then Main screen is displayed

    Scenario: Open recipe
      Given Main screen is displayed properly
      When User opens "teriyaki steak" recipe
      Then A "teriyaki steak" recipe is opened