@PhpTravels
Feature: To test the flightbooking for PhpTravels application.

  Background: 
    Given I launch the "Chrome" browser.
    And I Enter the URL "https://phptravels.net/".

  Scenario: As an end-user, I search flight for "<trip>" in PhpTravels.
    Then I click on the Flights tab.
    And I enter the departure city "Chennai" and destination city "Mc Carran".
    And i choose trip type "round trip".
    Then I select the departure date "1" and return date "25".
    And I select the number of passengers "2,2,1".
    Then I click the search button.

  Scenario Outline: As an end-user, I create a international booking for "<trip>" in PhpTravels.
    Then I click on the Flights tab.
    And I enter the departure city "<Departure>" and destination city "<Destination>".
    And i choose trip type "<trip>".
    Then I select the departure date "<departuredate>" and return date "<returndate>".
    And I select the number of passengers "<passengers>".
    Then I click the search button.
    Then I Validate the Search outcomes.
    And I click on the book button.
    Then I fill the passengerdetails.
    And I Validate the price.
    And I click on the Terms and conditions checkBox.
    Then I click on the Confirm booking button.
    And I validate the Total Price.
    Then I click on Proceed button.

    Examples: 
      | Departure | Destination | departuredate | trip       | returndate | passengers |
      | Chennai   | Mc Carran   |             1 | round trip |         25 |      2,2,1 |
