@sanity
  Feature: App restart

    Scenario: Reopen app
      Given Quit application
      When Open application
      Then Main screen is displayed

    Scenario: Minimize app
      Given App is reopened
      When Minimize app for "10" seconds
      Then Maximize "net.ditter.FotoKochbuch" app
      And Main screen is displayed

