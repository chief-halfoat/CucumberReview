Feature: Employee Leave Search feature
  @test
  Scenario:
    Given user is navigated to HRMS application
    When user enters valid admin credentials
    And user clicks on login button
    Then user is successfully logged in as an admin
    When the user clicks on Leave button
    And clicks on the From Calendar
    And selects a month from the dropdown menu
    And selects a year from the dropdown menu
    And selects a day from the menu
    And clicks on the To Calendar
    And selects a month from the dropdown menu
    And selects a year from the dropdown menu
    And selects a day from the menu
    And clicks the All checkbox
    And clicks on the Subunit dropdown
    And selects a value from the Subunit dropdown
    And clicks the Past Employees checkbox
    And clicks the Search button
    Then the user should see all of the data