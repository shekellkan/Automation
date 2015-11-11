@teams
  Feature: Teams
    create a team, delete team, edit perfil, add members

  Scenario 1: create a new team with 3 members
    Given I need a new team "team_test"
      And I have to create a new team "team_test"
      Then I add members at new team.

  Scenario 2: delete a team existent
    Given I new deleted a team that is disolved
    When I have a team existent with 