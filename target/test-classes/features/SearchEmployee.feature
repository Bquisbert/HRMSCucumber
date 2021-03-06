Feature: Employee Search

   Scenario: Search employee by id
    
    And user is logged with valid admin credentials
    And user navigate to employee list page
    When user enters valid employee id "10024"
    And click on search button
    Then user see employee information is displayed
    
   Scenario: Search employee by name
    
    And user is logged with valid admin credentials
    And user navigate to employee list page
    When user enters valid employee name and last name
    And click on search button
    Then user see employee information is displayed