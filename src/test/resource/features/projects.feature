@projects
Feature: Projects
  create new projects, add members, change background, delete project

  Background:
    Given I navigate to login page of Trello.com
      And I login in Trello.com as "miguel.terceros@fundacion-jala.org" with password "morfeo3730"

  Scenario 1: Add a new new project
    Given I have to create a new project
      And I add a new project "Test"

  Scenario 2: Add members into of a project existent
    Given I have a project existent
      Then I have to select the members
      And I add members at project
      Then the new members are added at to project

  Scenario 3: Personalize a project
    Given I have a project existent
      And I selected a color for the background of the project
      And I change the background of the project

  Scenario 4: Delete a project
    Given I have a project existent
      And I deleted the project

