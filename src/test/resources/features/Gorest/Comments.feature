Feature: Request Comments to Gorest API
  @smoke
  Scenario: GET All Comments User
    Given Get all comments user with valid json file
    When Send request get comments user
    Then Status code should be 200 OK
    And Get all comments user assert json validation

@positive
  Scenario: GET Single Comments
    Given Get single comments with id 12
    When Send request get single comments
    Then Status code should be 200 OK
    And Get single comments assert json validation

  Scenario: GET Single Posts
    Given Get single posts with id 15
    When Send request get single posts
    Then Status code should be 200 OK
    And Get single post assert json validation

  @negative
  Scenario: GET Single Coments with invalid id
    Given Get single comments with id 12345
    When Send request get single comments
    Then Status code should be 404
    And Response body should contain message "Resource not found"
    And Get single comments invalid id assert json validation

  Scenario: GET Single post with invalid id
    Given Get single posts with id 5554
    When Send request get single posts
    Then Status code should be 404
    And Response body should contain message "Resource not found"
    And Get single posts invalid id assert json validation

  @negative
  Scenario: GET Single Comments with invalid id
    Given Get single comments with id 12345
    When Send request get single comments
    Then Status code should be 404
    And Response body should contain message "Resource not found"
    And Get single comments invalid id assert json validation

  Scenario: GET Single post with invalid id
    Given Get single posts with id 5554
    When Send request get single posts
    Then Status code should be 404
    And Response body should contain message "Resource not found"
    And Get single posts invalid id assert json validation















