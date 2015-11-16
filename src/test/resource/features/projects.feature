@projects
Feature: Projects
  create new projects, add members, change background, delete project

  Background:
    Given I navigate to login page of Trello.com
      And I login in Trello.com as "miguel.terceros@fundacion-jala.org" with password "morfeo3730"

  Scenario 1: Add a new new project
    Given I have to create a new project
      And I add a new project "Test"
      Then the new project "Test" is created

  Scenario 2: Add members into of a project existent
    Given I have a project "Project_Members" existent
      Then I have to select the members
      And I add members at project
      Then the new members are added at to project

  Scenario 3: Personalize a project
    Given I have a project "Project_Personalize" existent
      Then I entered in the project
      And I navigate until to menu Change Background
      And I change the background of the project

  Scenario 4: Delete a project
    Given I have a project "Project_Deleted" existent
    Then I entered in the project
    And I navigate until to menu close board
    And I delete the project

