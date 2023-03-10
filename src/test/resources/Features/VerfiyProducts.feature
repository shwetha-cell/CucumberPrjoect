Feature: feature to quantity of products functionality

  @Products
  Scenario: Verify that testcasepage is visible successfully
    Given User Launch chromebrowser
    When User Open URL "https://automationexercise.com"
    Then Homepage title should be "Automation Exercise"
    And Click View Product for any product on home page
    Then Verify product detail is opened
    Then Increase quantity to "4"
    And Click Add to cart button
    And Click View Cart button
    Then Verify that product is displayed in cart page with exact quantity
