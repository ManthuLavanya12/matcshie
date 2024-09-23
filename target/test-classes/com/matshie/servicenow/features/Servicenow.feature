Feature: Get all change requests

  Scenario: Retrieve active change requests
    Given set base path and base uri
    And set authentication
    When hit get request to get all change requests
    Then all change requests should be fetched successfully

  
