Feature: Request Todos to Gorest API
  @aufa
  Scenario: Get List Todos
    Given Get all todos with valid json file
    When Send request get todos
    Then Status code should be 200 OK
    And Get all todos assert json validation

  Scenario: Get Invalid List Todos
    Given Get all todos with invalid json file
    When Send request get invalid todos
    Then Status code should be 404


  Scenario: Get Single Todos
    Given Get single todos with id 16
    When Send request get single todos
    Then Status code should be 200 OK
    And Get single todos assert json validation

  Scenario: Get Invalid Single Todos
    Given Get single todos with id 100000000
    When Send request get single todos
    Then Status code should be 404


  Scenario: Create New Todos
    Given Create new todos with valid json file
    When Send request get todos
    Then Status code should be 200 OK

  Scenario: Create New Todos Copy
    Given Create new todos with valid json file
    When Send request get todos
    Then Status code should be 200 OK

  Scenario: Create New Todos With Invalid Parameter
    Given Create new todos with invalid json file
    When Send request get invalid todos
    Then Status code should be 404

  Scenario: Update Valid Todos
    Given  authorization bearer token
    And Put update user with id 1650 and with valid json file
    When Send request put update todos
    Then Status code should be 200 OK
    And Get single todos assert json validation

  Scenario: Update Invalid Todos
    Given authorization bearer token
    And Put update user with id 12 and with valid json file
    When Send request put update todos
    Then Status code should be 404

  Scenario: Update Valid Todos With Invalid Parameter
    Given authorization bearer token
    And Put update user with id 1200000000 and with valid json file
    When Send request put update todos
    Then Status code should be 404

  Scenario: Delete Todos
    Given authorization bearer token
    And Delete todos with id 18
    When Send request delete todos
    Then Status code should be 204 No content

  Scenario: Delete Invalid User
    Given authorization bearer token
    And Delete todos with id 1200000
    When Send request delete todos
    Then Status code should be 404














