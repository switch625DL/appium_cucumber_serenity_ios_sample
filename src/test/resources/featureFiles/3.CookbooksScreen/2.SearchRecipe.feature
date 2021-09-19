@sanity1

  Feature: Search for a recipe on Cookbook Screen

    Scenario: Reopen app
      Given App is reopened
      When App is opened
      Then Main screen is displayed

    Scenario: Open Cookbooks Screen
      Given Main screen is displayed properly
      When User opens Cookbooks screen
      Then Cookbooks screen is displayed

    Scenario: Search for a recipe
      Given Cookbooks screen is displayed properly
      When User inputs "ginger" into the search bar
      Then Recipes containing "ginger" are presented

    Scenario: Open a recipe from Cookbooks Screen
      Given Recipes containing "ginger" are presented
      When User opens "ginger baked alaska" recipe
      Then A "ginger baked alaska" recipe is opened
#      And Recipe is displayed correctly