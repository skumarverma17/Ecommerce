@tag
Feature: Purchase order from Ecommerce Website
  I want to use this template for my feature file
  
Background: #prerequisite step,Background keyword is common for all scenarios
    Given user landed on the Ecommerce page
  

  @regression
  Scenario Outline: Positive test for submitting the order
    Given User login with username <username> and password <password>
    When User added the product <product> to the cart
    And user checks the product in the cart page <product> and submit the order with <country> country
    Then "THANKYOU FOR THE ORDER." message got displayed in the confirmation page

    Examples: 
      | username  		 | password          | product  			| country   |
      | subh@gmail.com | Snapdragon1702@   | IPHONE 13 PRO  | india     |
    
