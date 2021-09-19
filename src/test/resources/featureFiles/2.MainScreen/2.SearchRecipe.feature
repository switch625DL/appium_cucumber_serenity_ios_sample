@sanity
  Feature: Search for a recipe from Main Screen

    Scenario: Reopen app
      Given App is reopened
      When App is opened
      Then Main screen is displayed

    Scenario: Search for a recipe
      Given Search bar is empty
      When User inputs "ginger" into the search bar
      Then Recipes containing "ginger" are presented

    Scenario: Open found recipe
      Given Recipes containing "ginger" are presented
      When User opens "ginger baked alaskas" recipe
      Then A "ginger baked alaskas" recipe is opened

