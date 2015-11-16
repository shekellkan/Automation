@Login
Feature: Login
  Test successfully and unsuccessfully and logout

  Background:
    Given I navigate to login page of Trello.com

  @SmokeTest
  Scenario 1: Users should be able to Login using valid credentials
    When I login in Trello.com as "miguel.terceros@fundacion-jala.org" with password "morfeo3730"
    Then I should login to Trello.com successfully

  @SmokeTest
  Scenario Outline: Users should be able to Login using valid credentials
    When I login in Trello.com as "<User_Name>" with password "<Password>"
    Then I should login to Trello.com successfully

  Examples:
    |           User_Name              | Password |
    |miguel.terceros@fundacion-jala.org|morfeo3730|
    |ivan.morales@fundacion-jala.org   |Control123|

  @SmokeTest
  Scenario 2: Users should be able to Login using wrong credentials
    When I login in Trello.com as "miguel.terceros@fundacion-jala.org" with wrong password "Control123"
    Then I not should login to Trello.com

  @SmokeTest
  Scenario 3: Users should be able to Login using wrong credentials
    When I login in Trello.com with a wrong email "miguel.terceros@fundacion-jala.org"
    Then I not should login to Trello.com

  @SmokeTest
  Scenario 4: Users should be able to Login using wrong credentials
    When I login in Trello.com with fields empty
    Then I not should login to Trello.com