package com.petstore.cucumber.steps;

import com.petstore.petinfo.UsersSteps;
import com.petstore.utils.TestUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class UserCRUDDefs {
    @Steps
    UsersSteps usersSteps;
    @Given("^Gorest application is running$")
    public void gorestApplicationIsRunning() {
    }

    @When("^I create a new user by providing the information name \"([^\"]*)\" username \"([^\"]*)\" firstname \"([^\"]*)\" lastname\"([^\"]*)\"email\"([^\"]*)\" password\"([^\"]*)\"userstatus\"([^\"]*)\"$")
    public void iCreateANewUserByProvidingTheInformationNameUsernameFirstnameLastnameEmailPasswordUserstatus(int id,String username,String firstname, String lastname, String email, String password, int userstatus){
        ValidatableResponse response =usersSteps.createUser(id, username, firstname, lastname, email, password, userstatus);
        response.log().all().statusCode(200);

    }



@Then("^I verify that user \"([^\"]*)\" is created$")
public void iVerifyThatUserIsCreated(String username)  {

    usersSteps.getUserInfo(username);

}
    @And("^I update a newly created user and verify user created successfully id \"([^\"]*)\" username \"([^\"]*)\" firstname \"([^\"]*)\" lastname\"([^\"]*)\"email\"([^\"]*)\" password\"([^\"]*)\"userstatus\"([^\"]*)\"$")
    public void iUpdateANewlyCreatedUserAndVerifyUserCreatedSuccessfullyIdUsernameFirstnameLastnameEmailPasswordUserstatus(int id,String username,String firstname, String lastname, String email, String password, int userstatus)  {
        firstname = "Mrs" + TestUtils.getRandomString();
        lastname = TestUtils.getRandomString();
        email = TestUtils.getRandomString() + "@gmail.com";
        ValidatableResponse response = usersSteps.updateUser(id, username, firstname, lastname, email, password, userstatus);
        response.log().all().statusCode(200);
    }

    @And("^I delete a newly created user and verify it deleted successfully username \"([^\"]*)\"$")
    public void iDeleteANewlyCreatedUserAndVerifyItDeletedSuccessfullyUsername(String username) {
        ValidatableResponse response=usersSteps.deleteUser(username);
        response.log().all().statusCode(200);
    }
}

