Feature: feature to subscriptionhomepage functionality
 
 @Subscribed
  Scenario: Verify that subscriptionhomepage is visible successfully
    Given User Launch chromebrowser
    When User Open URL "https://automationexercise.com"
    Then Homepage title should be "Automation Exercise"
    Then Scroll down to footer
    Then Verfiy text is visible
    And  Enter email address as "shettyShwetha53@gmail.com" in input and click arrow button
    Then Verify success message You have been successfully subscribed is visible