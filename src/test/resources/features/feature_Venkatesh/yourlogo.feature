@YourLogo
Feature: As an user,Iam trying to automate yourlogo application as end to end

  Background: 
    Given I Launch the chrome browser
    And user enter url "http://automationpractice.com/index.php"

  Scenario: As an user,Iam trying to login into yourlogo application
    And click on the sigin button
    Then user enter the valid email address
    And click on the create an account button
    Then Click the gender button
    And user enter the first name "venkatesh"
    And user enter the last name "baskar"
    And click the email checkbox
    And user enter the valid password "1234567"
    And select the date of birth "22/5/1999"
    And click the first name
    And click the last name
    And user enter the company name "it trident"
    And user enter the valid address "5.IT trident ,northusman road ,3rd floor,tnagar,chennai"
    And user enter the city name "chennai"
    And select the state name "1"
    And user enter the valid zip postal code "61291"
    And click the country name
    And user enter the valid phone number "9585153985"
    Then click the register button

  Scenario Outline: As an logged user,Iam trying to order a clothes in yourlogo ecommerce website
    And click on the sigin button
    Then user enter the valid email address "<Email>"
    And user enter the valid password "<Password>"
    Then Click the signin button
    And click the dresstype
    And validate the product name
    And click the first product
    And click the add to card button
    Then click the continue shopping
    And validate the product2 name
    And click the second product
    And click the add to card button1
    Then click the continue shopping button
    And select the sort product button "Product Name: A to Z"
    And click the card button
    And validate the total product name
    And validate the total price
    And validate the adress
    And click the summary proceed to checkout button
    And validate the billing address
    And click the address proceed to checkout button
    And click the agree shipping checkout
    And click the shipping proceed to checkout button
    And validate the total price of product
    And click the pay by bankwire
    And click the I confrom my order button
    Then validate the complete order screen is displayed

    Examples: 
      | Email                       | Password |
      | venkatesh22+17571@gmail.com |  1234567 |
      | venkatesh22+40642@gmail.com |  1234567 |
