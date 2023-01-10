Feature: Petstore Application
  Testing user functinality by performing end to end testing using CRUD operations

  Scenario Outline: CRUD Test
    Given Petstore application is running
    When I create a new pet by providing the information id "<id>" name "<name>" catID "<cid>" cname "<cname>" photourl "<photourl>" tid "<tid>" tname "<tname>" status "<status>"
    Then I verify by id that pet has been created "<id>"
    And I update a newly created pet and verify user created successfully with id "<id>" name "<name>" catID "<cid>" cname "<cname>" photourl "<photourl>" tid "<tid>" tname "<tname>" status "<status>"
    And I delete a newly created pet and verify it deleted successfully with id "<id>"
    Examples:
    |id    |name   |cid   |cname             |photourl         |tid   |tname   |status|
    |101  |aaa3    | 912  |      puppy       |photobs1H0KQycom  |9569  |  doggy |    sold |
