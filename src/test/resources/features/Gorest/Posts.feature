<<<<<<< HEAD
Feature: Request Post to Gorest API
@positive
Scenario: GET Single Posts
Given Get single posts with id 15
When Send request get single posts
Then Status code should be 200 OK
And Get single post assert json validation

=======
Feature: Request Posts to Gorest API
  @positive @mahira
  Scenario: GET Single Posts
    Given Get single posts with id 15
    When Send request get single posts
    Then Status code should be 200 OK
    And Get single post assert json validation

  @negative @mahira
>>>>>>> ab2c0547ef97049a9a49499c618496466eeba1b7
  Scenario: GET Single post with invalid id
    Given Get single posts with id 5554
    When Send request get single posts
    Then Status code should be 404
    And Response body should contain message "Resource not found"
<<<<<<< HEAD
    And Get single posts invalid id assert json validation
=======
    And Get single posts invalid id assert json validation


>>>>>>> ab2c0547ef97049a9a49499c618496466eeba1b7
