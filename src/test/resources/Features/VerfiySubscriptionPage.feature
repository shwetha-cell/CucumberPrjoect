Feature: feature to subscriptionhomepage functionality
 
 @Subscribed
  Scenario Outline: Verify that subscriptionhomepage is visible successfully
    Given User Launch chromebrowser
    When User Open URL "https://automationexercise.com"
    Then Homepage title should be "Automation Exercise"
    Then Scroll down to footer
    Then Verfiy text is visible
    And  fill the form as "<sheetName>" and <RowNumber> click arrow button
    Then Verify success message You have been successfully subscribed is visible
    
     Examples:
     
     |sheetName| RowNumber|
     | order   | 1        |