@Login
  Feature: Login
    Test successfully and unsuccessfully and logout
    Background:
      Given I navigate to login page of Trello.com
    @SmokeTest
    Scenario: Users should be able to Login using valid credentials
      When I login in Trello.com as "miguel.terceros@fundacion-jala.org" with password "morfeo3730"
      Then I should login to Trello.com successfully

    @SmokeTest
    Scenario Outline: Users should be able to Login using valid credentials
      When I login in Trello.com as "<User Name>" with password "<Password>"
      Then I should login to Trello.com successfully

    Examples
      |           User Name              | Password |
      |miguel.terceros@fundacion-jala.org|morfeo3730|
      |ivan.morales@fundacion-jala.org   |Control123|

    @SmokeTest
    Scenario: Users should be able to Login using wrong credentials
      When I login in Trello.com as "miguel.terceros@fundacion-jala.org" with wrong password "Control123"
      Then I not should login to Trello.com