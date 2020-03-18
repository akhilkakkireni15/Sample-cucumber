Feature: Login

  Scenario: Checking login
    Given Launching browser
    When Opening URL "https://google.com"
    Then Pagetitle "<google>" should be verified
    And close browser
    
    

  