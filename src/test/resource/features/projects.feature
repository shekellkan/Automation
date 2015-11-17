@projects
Feature: Projects
  create new projects, add members, change background, delete project

  Background:
    Given I navigate to login page of Trello.com
      And I login in Trello.com as "miguel.terceros@fundacion-jala.org" with password "morfeo3730"

  Scenario: Add a new new project
    Given I have to create a new project
      And I add a new project "Test"
      Then the new project "Test" is created
