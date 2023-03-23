 
 Feature: feature to Logout functionality
 
 @Logout
  Scenario Outline: Verify that home page is visible successfully
    Given User Launch chromebrowser
    When User Open URL "https://automationexercise.com"
    Then Homepage title should be "Automation Exercise"
    And Click on signup button
    Then Verify Login to your account is displayed
    When User enters email as "<sheetName>" and password as <RowNumber>
    And cilck on Login Button
    Then Verify that Logged in as username is displayed
    And Click on Logout button
    Then Verify that user is navigated to login page
    Examples:
    |sheetName| RowNumber |
    |Logout   | 0          |