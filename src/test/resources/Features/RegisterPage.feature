Feature: feature to user register functionality

  @Checkurl
  Scenario Outline: Verify that home page is visible successfully
    Given User Launch chromebrowser
    When User Open URL "https://automationexercise.com"
    Then Homepage title should be "Automation Exercise"
    And Click on signup button
    Then verfiy New User Signup is displayed or not
    When User enter name as "<name>" and email as "<mail>"
    And Click signup button
    Then Verfiy Account information is  displayed or not
    And Enter All account information
    Then Select checkbox for newselter
    And Verfiy Receive special offers from our partners!
    Then Enter personal detailes
    Then Click on create button
    And Verfiy account is visible
    Then Click continue button
    And Verfiy Logged in username
    Then Click delete button
    And Verfiy account is deleted
    
    Examples:
    |name    | mail      |
    |shwetha | shety@12358|
    
