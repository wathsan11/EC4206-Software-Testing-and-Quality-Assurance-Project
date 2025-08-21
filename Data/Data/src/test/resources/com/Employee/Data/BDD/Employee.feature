Feature: Employee management
  As an HR manager
  I want to manage employees
  So that I can add, retrieve, and delete employees

  Scenario:Add a new employee
    Given an employee with id 1 and name "John" and gmail "john@gmail.com"
    When I add the employee
    Then the employee with id 1 should exist

  Scenario: Get an employee by id
    Given an employee with id 2 and name "Alice" and gmail "aloce@gmail.com"
    When I search employee with id 2
    Then I should get employee with name "Alice"

  Scenario: Delete an employee
    Given an employee with id 3 and name "Bob" and gmail "bob@gmail.com"
    When I delete employee with id 3
    Then searching for employee with id 3 should return null


