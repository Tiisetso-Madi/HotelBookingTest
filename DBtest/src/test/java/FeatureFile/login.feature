Feature: BookingTest


  @DataProviderClass(DatabaseUtils.class)
  @loginActing
  Scenario: Successful Register
    Given User is on Home Page
    When User adds login credentials
    Then User clicks login button
    And Users searches for a hotel
    And User clicks search button
    Then Select hotel page should open and select hotel details
    And User clicks Continue
    When User enter remaining booking details
    And user clicks book now
    Then User logs out