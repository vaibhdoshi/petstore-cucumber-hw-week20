package com.petstore.cucumber.steps;

import com.petstore.petinfo.UsersSteps;
import com.petstore.utils.TestUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class UserStepsDef {
    static ValidatableResponse response;
    static int id = TestUtils.getRandomNumber();
    static String username = "vir" + TestUtils.getRandomString();
    static String firstname = "Dev" + TestUtils.getRandomString();
    static String lastname = "VD" + TestUtils.getRandomString();
    static String email = "vird" + TestUtils.getRandomNumber() + "@gmail.com";
    static String password = TestUtils.getRandomString();
    static int userstatus = TestUtils.getRandomNumber();

    @Steps
    UsersSteps usersSteps;
    @When("^I create a new user by providing all the information$")
    public void iCreateANewUserByProvidingAllTheInformation() {
        ValidatableResponse response =usersSteps.createUser(id, username, firstname, lastname, email, password, userstatus);
        response.log().all().statusCode(200);

    }

    @Then("^I verfiy that the new user is created$")
    public void iVerfiyThatTheNewUserIsCreated() {
        usersSteps.getUserInfo(username);
    }

    @When("^I update new user by providing information$")
    public void iUpdateNewUserByProvidingInformation() {
        firstname = "Mrs" + TestUtils.getRandomString();
        lastname = TestUtils.getRandomString();
        email = TestUtils.getRandomString() + "@gmail.com";
        ValidatableResponse response = usersSteps.updateUser(id, username, firstname, lastname, email, password, userstatus);
        response.log().all().statusCode(200);
        }

    @Then("^I verify user has been updated$")
    public void iVerifyUserHasBeenUpdated() {
        ValidatableResponse response = usersSteps.getUserInfo(username);
        response.log().all().statusCode(200);
    }


   @When("^I delete new user by username$")
    public void iDeleteNewUserByUsername() {
       ValidatableResponse response=usersSteps.deleteUser(username);
       response.log().all().statusCode(200);
    }

    @Then("^I verify user has been deleted successfully$")
    public void iVerifyUserHasBeenDeletedSuccessfully() {
usersSteps.getUserInfo(username).statusCode(404);
    }



}
