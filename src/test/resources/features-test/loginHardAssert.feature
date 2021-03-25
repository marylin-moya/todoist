Feature: Login Todoist
  Test successfully and unsuccessfully login and logout to Todoist site

  Scenario: Login Successfully to Todist site
    Given I navigate to Todoist Login page
    When I login to Todoist as "marylinmoya@hotmail.com" with password "Password123"
    Then I should login to Todoist successfully
    And I make this step fail the first time
    And I make this step pass the first time
    And I make this step fail the second time

  Scenario: Login Successfully to Todist site1
    Given I navigate to Todoist Login page
    When I login to Todoist as "marylinmoya@hotmail.com" with password "Password123"
    Then I should login to Todoist successfully

  Scenario: Login Successfully to Todist site2
    Given I navigate to Todoist Login page
    When I login to Todoist as "marylinmoya@hotmail.com" with password "Password123"
    Then I should login to Todoist successfully