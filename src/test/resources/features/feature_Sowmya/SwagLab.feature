Feature: To test the functionality of buying products in Swaglab application.

    Background: 
    Given I launch the "chrome" browser.
    And I Enter the URL "https://www.saucedemo.com/".
    
    Scenario: As an end user, I select product to buy in Swaglab.
    Then I enter username "standard_user" and password "secret_sauce".
    And I click on the Login button.
    Then I validate whether I have logged into the website successfully.
    And I validate the prices of the product and check if the products are sorted correctly.
    Then I select the products that I desire to buy.
    And I click on the Cart button.
    
    Scenario Outline: As an end user, I complete payment of the desired product in Swaglab.
    Then I enter username "<Username>" and password "<Password>".
    And I click on the Login button.
    Then I validate whether I have logged into the website successfully.
    And I validate the prices of the product and check if the products are sorted correctly.
    Then I select the products that I desire to buy.
    And I click on the Cart button.
    Then I validate product information and the product quantity "<Quantity>".
    And I click on the Checkout button.
    And I enter the personal information 
    Then I complete the checkout process by clicking Continue button.
    And I click on the Finish button and complete the payment process.
    Then I check whether THANK YOU FOR YOUR ORDER message is displayed which confirms that the desired products are ordered successfully.
    
    Examples: 
      | Username      | Password     | Quantity |
      | standard_user | secret_sauce | 2        |
      
    