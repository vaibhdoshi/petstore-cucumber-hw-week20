Feature: Testing different operation on the petstore application
  As a user i want to test all operation

  Scenario: Create a new user and verify if user is added
    When I create a new user by providing all the information
    Then I verfiy that the new user is created

   Scenario: Update a new user and verify user has been updated
      When I update new user by providing information
      Then I verify user has been updated


      Scenario: Delete a newely created user and verify user has been deleted succesfully
        When I delete new user by username
        Then I verify user has been deleted successfully



