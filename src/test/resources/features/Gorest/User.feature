Feature: Request User to Gorest API

  Scenario: Get List User
    Given Get all user with valid json file
    When Send request get user
    Then Status code should be 200 OK
    And Get all user assert json validation

  Scenario: Get Invalid List User
    Given Get all user with invalid json file
    When Send request get invalid user
    Then Status code should be 404


  Scenario: Get Single User
    Given Get single user with id 12
    When Send request get single user
    Then Status code should be 200 OK
    And Get single user assert json validation

  Scenario: Get Invalid Single User
    Given Get single user with id 12000
    When Send request get single user
    Then Status code should be 404


  Scenario: Create New User
    Given Create new user with valid json file
    When Send request get user
    Then Status code should be 200 OK

  Scenario: Create New User Copy
    Given Create new user with valid json file
    When Send request get user
    Then Status code should be 200 OK

  Scenario: Create New User With Invalid Parameter
    Given Create new user with invalid json file
    When Send request get invalid user
    Then Status code should be 404

  Scenario: Update Valid User
    Given Put update user with id 12 and with valid json file
    And authorization bearer token
    When Send request put update user
    Then Status code should be 200 OK
    And Get single user assert json validation

  Scenario: Update Invalid User
    Given Put update user with id 12 and with valid json file
    And authorization bearer token
    When Send request put update user
    Then Status code should be 200 OK
    And Get single user assert json validation

  Scenario: Update Valid User With Invalid Parameter
    Given Put update user with id 12000 and with valid json file
    And authorization bearer token
    When Send request put update user
    Then Status code should be 404

  Scenario: Delete User
    Given Delete user with id 12
    And authorization bearer token
    When Send request delete user
    Then Status code should be 204 No content

  Scenario: Delete Invalid User
    Given Delete user with id 1200000
    And authorization bearer token
    When Send request delete user
    Then Status code should be 404














