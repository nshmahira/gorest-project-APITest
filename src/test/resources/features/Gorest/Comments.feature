Feature: Request Comments to Gorest API
  @positive @mahira
  Scenario: GET All Comments User
    Given Get all comments user with valid json file
    When Send request get comments user
    Then Status code should be 200 OK
    And Get all comments user assert json validation

  @positive @mahira
  Scenario: GET Single Comments
    Given Get single comments with id 25
    When Send request get single comments
    Then Status code should be 200 OK
    And Get single comments assert json validation
<<<<<<< HEAD

=======
>>>>>>> ab2c0547ef97049a9a49499c618496466eeba1b7

  @negative @mahira
  Scenario: GET All Comments with invalid json file
    Given Get all comments user with invalid json file
    When Send request get comments user
    Then Status code should be 400 bad

  @negative @mahira
  Scenario: GET Single Coments with invalid id
    Given Get single comments with id 12345
    When Send request get single comments
    Then Status code should be 404
    And Response body should contain message "Resource not found"
    And Get single comments invalid id assert json validation

<<<<<<< HEAD

  @negative
=======
  @negative @mahira
>>>>>>> ab2c0547ef97049a9a49499c618496466eeba1b7
  Scenario: GET Single Comments with invalid id
    Given Get single comments with id 12345
    When Send request get single comments
    Then Status code should be 404
    And Response body should contain message "Resource not found"
    And Get single comments invalid id assert json validation

<<<<<<< HEAD
  Scenario: PUT Update comments without bearer token
    When post create comments with valid json file
    When Send request put update comments
    Then Status code should be 401 unauthorized

  Scenario: POST Create a new comments without bearer token
    When post create comments with valid json file
    When Send request post create a new comments
    Then Status code should be 401 unauthorized

=======
  @negative @mahira
>>>>>>> ab2c0547ef97049a9a49499c618496466eeba1b7
  Scenario: GET Single post with invalid id
    Given Get single posts with id 5554
    When Send request get single posts
    Then Status code should be 404
    And Response body should contain message "Resource not found"
    And Get single posts invalid id assert json validation

  @negative @mahira
  Scenario: POST Create a new comments without bearer token
    When post create comments with valid json file
    When Send request post create a new comments
    Then Status code should be 401 unauthorized

  @negative @mahira
  Scenario: PUT Update comments without bearer token
    When put update comments with valid json file
    When Send request put update comments
    Then Status code should be 401 unauthorized

  @positive @mahira
  Scenario: POST Create a new comments with valid bearer token
    Given authorization bearer token
    When post create comments with valid json file
    When Send request post create a new comments
    Then Status code should be 201 created

  @negative @mahira
  Scenario: POST Create a new comments with invalid email json file
    Given authorization bearer token
    When post create comments with invalid email json file
    When Send request post create a new comments
    Then Status code should be 422 unprocessable

<<<<<<< HEAD
=======

  @positive @mahira
>>>>>>> ab2c0547ef97049a9a49499c618496466eeba1b7
  Scenario: PUT Update comments with valid json file
    Given authorization bearer token
    When put update comments with valid json file
    When Send request put update comments
    Then Status code should be 201 created

  @negative @mahira
  Scenario: PUT Update comments with invalid email json file
    Given authorization bearer token
    When put update comments with invalid email json file
    When Send request put update comments
    Then Status code should be 422 unprocessable

<<<<<<< HEAD

  Scenario: DELETE comments
    Given authorization bearer token
    And Delete comments with id 30
=======
  @positive @mahira
  Scenario: DELETE comments
    Given authorization bearer token
    And Delete comments with id 29
>>>>>>> ab2c0547ef97049a9a49499c618496466eeba1b7
    When Send request delete comments
    Then Status code should be 204 No content































