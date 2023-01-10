Feature: Gorest Application
  As a user i want to test gorest Application

  Scenario Outline: CRUD Test
    Given Gorest application is running
    When I create a new user by providing the information name "<id>" username "<username>" firstname "<firstname>" lastname"<lastname>"email"<email>" password"<password>"userstatus"<userstatus>"
    Then I verify that user "<username>" is created
    And I update a newly created user and verify user created successfully id "<id>" username "<username>" firstname "<firstname>" lastname"<lastname>"email"<email>" password"<password>"userstatus"<userstatus>"
    And I delete a newly created user and verify it deleted successfully username "<username>"

    Examples:
      | id   | username | firstname | lastname | email           | password | userstatus |
      | 1034 | mohan12  | smith     | john     | bcd21@gmail.com | abc123   | 1234       |
