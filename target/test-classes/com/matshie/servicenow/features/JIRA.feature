Feature: Chaining process of JIRA with matschie framework

Background:    
    Given Set base path and base uri

  Scenario: Sce1 Post new issue in JIRA
    When post new issue with payload
    Then check whether new issue is posted 
    
  Scenario: Sce2 get single issue from JIRA
    When get single created issue
    Then single issue should be fetched successfully
    
  Scenario: Sce3 update single issue from JIRA using put
    When put request for updating issue in JIRA
    Then data should be updated properly

   Scenario: Sce4 delete single issue from JIRA using delete
    When delete request for deleting created issue in JIRA
    Then deleted single issue successfully
    
    Scenario: Sce5 validate issue after delete
    When get deleted issue
    Then 404 should be shown
    
    