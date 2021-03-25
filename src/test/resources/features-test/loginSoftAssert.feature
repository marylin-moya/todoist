Feature: Login Todoist
  Test successfully and unsuccessfully login and logout to Todoist site

  Scenario: Login Successfully to Todist site
    Given SA-I navigate to Todoist Login page
    When SA-I login to Todoist as "marylinmoya@hotmail.com" with password "Password123"
    Then SA-I should login to Todoist successfully
    And SA-I make this step fail the first time
    And SA-I make this step pass the first time
    And SA-I make this step fail the second time
    And SA-Verify all assertions

  Scenario: Login Successfully to Todist site1
    Given SA-I navigate to Todoist Login page
    When SA-I login to Todoist as "marylinmoya@hotmail.com" with password "Password123"
    Then SA-I should login to Todoist successfully

  Scenario: Login Successfully to Todist site2
    Given SA-I navigate to Todoist Login page
    When SA-I login to Todoist as "marylinmoya@hotmail.com" with password "Password123"
    Then SA-I should login to Todoist successfully