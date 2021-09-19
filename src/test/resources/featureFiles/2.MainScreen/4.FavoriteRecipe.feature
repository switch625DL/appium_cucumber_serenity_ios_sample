@sanity
  Feature: Favorite a recipe on main screen

    Scenario: Reopen app
      Given App is reopened
      When App is opened
      Then Main screen is displayed

    Scenario: Favorite a recipe (main screen)
      Given Main screen is displayed properly
      When User favorites "teriyaki steak" recipe
      Then Recipe is favorited

#    Scenario: Verification of "Favourite" mark
#      Given Recipe is favorited
#      When User opens "teriyaki steak" recipe
#      Then Recipe is favorited