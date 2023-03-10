Feature: feature to Login before checkout functionality
 
 @ViewProducts
  Scenario: Verify that login before checkout visible successfully
    Given User Launch chromebrowser
    When User Open URL "https://automationexercise.com"
    Then Homepage title should be "Automation Exercise"
    And Click on Products button
    Then  Verify that Brands are visible on left side bar
    And  Click on any brand name
    Then Verify that user is navigated to brand page and brand products are displayed
    When  On left side bar, click on any other brand link
    Then Verify that user is navigated to that brand page and can see products
    