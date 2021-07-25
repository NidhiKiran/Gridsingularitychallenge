Feature: Create Simulation functionality of d3a.io
  Background: There is a user who can login in to d3a.io
    Given User is on login page of d3a.io
    When he tries to login to d3a.io using preexisting user
      | Email        | sharmanidhi075@gmail.com  |
      | Password     | gridsingularity           |
    Then he is successfully logged in to d3a.io
    And User is on project page of d3a.io
    When he tries to create a project in d3a.io using following parameters
      | Name         | project                   |
      | Description  | project_description       |
    Then the project should be successfully created

  Scenario: Existing user is able to create a simulation in an existing project on d3a.io
    Given User is on project page of d3a.io
    When he tries to create a simulation in d3a.io using following parameters
      | Description       | simulation_description  |
    Then the simulation should be successfully created