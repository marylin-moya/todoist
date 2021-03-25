Feature: Projects
  CRUD

  Background:
    Given I navigate to Todoist Login page
    When I login to Todoist as "marylinmoya@hotmail.com" with password "Password123"

  @deleteProject
  Scenario: Create a project
    When I select create Project option
    And I type "my project" in Project Name field
    And I click on Add button
    Then the Project should be created

  @createProject
  Scenario: Delete a project
    When I select delete option of project
    And I click on Delete button
    Then the Project should be deleted

    @createProject @deleteProject
    Scenario: Update a project
      When I select edit option of project
      And I change project type to Board
      Then the project type is Board
