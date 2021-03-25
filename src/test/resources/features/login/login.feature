@Login
Feature: Login Todoist
  Test successfully and unsuccessfully login and logout to Todoist site

  Scenario: Login Successfully to Todoist site
    Given I navigate to Todoist Login page
    When I login to Todoist as "marylinmoya@hotmail.com" with password "Password123"
    Then I should login to Todoist successfully

