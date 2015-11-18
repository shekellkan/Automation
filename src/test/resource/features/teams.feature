@teams
Feature: Teams
  create a team, delete team, edit perfil, add members

  Background:
    Given I navigate to login page of Trello.com
    And I login in Trello.com as "miguel.terceros@fundacion-jala.org" with password "morfeo3730"

  Scenario: create a new team
    Given I need a new team
    And I have to create a new team "newTeam"
    Then The new team "newTeam" is created.

  Scenario: create a new team with description
    Given I need a new team
    And I have to create a new team "Team_With_Description" with description "This is a new Team"
    Then The new team "Team_With_Description" is created.

  Scenario: delete a team existent "Teams_Deleted"
    Given I deleted a team "Teams_Deleted" that is disolved
    And I deleted the team
    Then The team "Teams_Deleted" is deleted

  Scenario: add members existent in a team
    Given I need add new members in team "Team_Members"
      And I navigate until to menu Members
      And I add to member "Ivan Morales" with the email "ivan.morales@fundacion-jala.org"
      Then The  member "Ivan Morales" is added in the team

#  Scenario: add new members in a team
#    Given I need add new members in team "Team_New_Members"
#    And I navigate until to menu Members
#    And I sent a invitation for the new member "Miguel Terceros" with the email "shekellkan@gmail.com"
#    Then The member "Miguel Terceros" is added in the team


