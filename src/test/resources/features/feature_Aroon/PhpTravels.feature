Feature: To test the flightbooking for PhpTravels application.

  Background: 
    Given I launch the chrome browser.
    And I Enter the URL "https://phptravels.net/".

  Scenario: As an end-user, I search flight for "<trip>" in PhpTravels.
    Then I click on the Flights tab.
    And I enter the "Chennai" and "McCarran" cities.
    Then I select the  "1" and "25".
    And I select the number of "2,2,1".
    Then I click the search button.

  Scenario Outline: As an end-user, I create a international booking for "<trip>" in PhpTravels.
    Then I click on the Flights tab.
    And I enter the "<Departure>" and "<Destination>" cities.
    Then I select the  "<departuredate>" and "<returndate>".
    And I select the number of "<passengers>".
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
      | Chennai   | McCarran    |             1 | round trip |         25 |      2,2,1 |
