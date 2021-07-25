Feature: Login functionality of d3a.io
  Scenario: Existing user is able to login to d3a.io
    Given User is on login page of d3a.io
    When he tries to login to d3a.io using preexisting user
     | Email        | sharmanidhi075@gmail.com  |
     | Password     | gridsingularity           |
    Then he is successfully logged in to d3a.io