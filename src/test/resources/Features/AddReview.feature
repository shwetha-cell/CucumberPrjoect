Feature: feature to Addreview functionality

  @Review
  Scenario Outline: Verify that add review page is visible successfully
    Given User Launch chromebrowser
    When User Open URL "https://automationexercise.com"
    Then Homepage title should be "Automation Exercise"
    When  Click on Products button in home page
    Then  Verify user is navigated to ALL PRODUCTS page successfully
    Then Click on viewproduct button on home page
    And  Verify Write Your Review is visible
    Then User fill the form using given form "<sheetNumber>" and <RowNumber>
    And Click Submit button
    Then Verify success message Thank you for your review
    
    Examples:
    |sheetNumber| RowNumber|
    |AddReview  |   1      |
