Feature: Get Calendar Table Data
  @test1
  Scenario:
    Given user is navigated to HRMS application
    When user enters valid admin credentials
    And user clicks on login button
    And the user clicks on Leave button
    Then user should see calendar info