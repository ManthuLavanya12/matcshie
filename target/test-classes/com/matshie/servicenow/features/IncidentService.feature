
Feature:Office customer able to use incident service api to raise their query
Background: 
Given Set Base URI and Base Path
And Set authentication

@smoke
Scenario: Validate user able to create new incident using incident service
When user hit post method with payload
Then new incident record should be created
@regression
Scenario Outline: Validate user able to create new incident using incident service
When user hit post method with following different request payload <short_description>, <description>,<caller_id>
Then new incident record should be created based on the given payload <short_description>, <description>,<caller_id>

   Examples: 
      | short_description  | description | caller_id  |
      | cucumber |     created | 413a4d35eb32010045e1a5115206fe6b |
      | cuccumber2 |     created2 | 413a4d35eb32010045e1a5115206fe6b    |
