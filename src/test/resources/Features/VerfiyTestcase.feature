Feature: feature to Testcase functionality
 
 @Tescases1
  Scenario: Verify that testcasepage is visible successfully
    Given User Launch chromebrowser
    When User Open URL "https://automationexercise.com"
    Then Homepage title should be "Automation Exercise"
    And Click on testcases button
    Then Verify user is navigated to test cases page successfully
    
   