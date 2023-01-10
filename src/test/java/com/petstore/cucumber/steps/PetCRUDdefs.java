package com.petstore.cucumber.steps;

import com.petstore.petinfo.PetSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class PetCRUDdefs {
    static ValidatableResponse response;
    @Steps
    PetSteps petSteps;
    @Given("^Petstore application is running$")
    public void petstoreApplicationIsRunning() {
    }


    @When("^I create a new pet by providing the information id \"([^\"]*)\" name \"([^\"]*)\" catID \"([^\"]*)\" cname \"([^\"]*)\" photourl \"([^\"]*)\" tid \"([^\"]*)\" tname \"([^\"]*)\" status \"([^\"]*)\"$")
    public void iCreateANewPetByProvidingTheInformationIdNameCatIDCnamePhotourlTidTnameStatus(int id, String name, int cid, String cname, String photourl, int tid, String tname, String status)  {
        ValidatableResponse response = petSteps.createPet(id,name,cid,cname,photourl,tid,tname,status);
        response.log().all().statusCode(200);
    }
    @Then("^I verify by id that pet has been created \"([^\"]*)\"$")
    public void iVerifyByIdThatPetHasBeenCreated(int id) {
        ValidatableResponse response = petSteps.getPetById(id);
        response.log().all().statusCode(200);
    }

    @And("^I update a newly created pet and verify user created successfully with id \"([^\"]*)\" name \"([^\"]*)\" catID \"([^\"]*)\" cname \"([^\"]*)\" photourl \"([^\"]*)\" tid \"([^\"]*)\" tname \"([^\"]*)\" status \"([^\"]*)\"$")
    public void iUpdateANewlyCreatedPetAndVerifyUserCreatedSuccessfullyWithIdNameCatIDCnamePhotourlTidTnameStatus(int id, String name, int cid, String cname, String photourl, int tid, String tname, String status) {
        ValidatableResponse response = petSteps.updatePet(id,name,cid,cname,photourl,tid,tname,status);
        response.log().all().statusCode(200);

    }
    @And("^I delete a newly created pet and verify it deleted successfully with id \"([^\"]*)\"$")
    public void iDeleteANewlyCreatedPetAndVerifyItDeletedSuccessfullyWithId(int id) {
        ValidatableResponse response = petSteps.deletePet(id);
        response.log().all().statusCode(200);
        }
}


