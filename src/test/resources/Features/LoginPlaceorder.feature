 
 Feature: feature to Login before checkout functionality
 
 @LogoutBefore
  Scenario Outline: Verify that login before checkout visible successfully
    Given User Launch chromebrowser
    When User Open URL "https://automationexercise.com"
    Then Homepage title should be "Automation Exercise"
    And Click on signup button
    When User enters the details  "<sheetName>" and  <RowNumber> and click on login button
    Then Verify Logged in as username at top
    Then Add to product to cart
    And Click on cart button
    Then Verify that cart page is displayed
    Then Click Proceed To Checkout
    Then Verify Address Detaials "<Adress>" and "<phonNumber>" and Review Your Order
    Then Enter description in "<sheetName>" and <RowNumber>  and click Place Order
    Then  Enter all card details as per the sheet "<sheetName>" and <RowNumber>
    And  Click Pay and Confirm Order button
    Then  Verify success message Your order has been placed successfully!
    Then Click Delete Account button
    Then Verify "Automation Exercise" and click Continue button
    
   Examples:
    |sheetName| RowNumber |
    |Logout   | 0         |