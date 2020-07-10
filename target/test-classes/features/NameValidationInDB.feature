Feature: Name validation against DB

  Scenario: First Name validation against DB
    Given user is logged with valid admin credentials
    And user navigate to employee list page
    When user enters valid employee id "14688"
    And click on search button
    Then verify table is displayed
    And get first name from table
    When get data from db 
    Then verify first name from ui against db
    
