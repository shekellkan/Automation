@Login
  Feature: Login
    Test successfully and unsuccessfully and logout
    @SmokeTest
    Scenario: Users should be able to Login using valid credentials
      Given I navigate to login page of Trello.com
      When I login in Trello.com as "miguel.terceros@fundacion-jala.org" with password "morfeo3730"
      Then I should login to Trello.com successfully



