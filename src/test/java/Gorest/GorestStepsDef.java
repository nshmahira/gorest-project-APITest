package Gorest;

import Gorest.GoresResponses;
import Gorest.GorestAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GorestStepsDef {
    @Steps
    GorestAPI gorestAPI;


    @When("Send request get comments user")
    public void sendRequestGetCommentsUser() {
        SerenityRest.when().get(GorestAPI.GET_ALL_COMMENTS);
    }


    @And("Get all comments user assert json validation")
    public void getAllCommentsUserAssertJsonValidation() {
        File jsonFile = new File(GorestAPI.JSON_FILE +"/GetAllComentJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Get all comments user with valid json file")
    public void getAllCommentsUserWithValidJsonFile() {
        File jsonFiles = new File( GorestAPI.JSON_FILE+"/GetAllComment.json");
        gorestAPI.getAllComments(jsonFiles);
    }

    @And("Response body should contain name {string} and email {string}")
    public void responseBodyShouldContainNameAndEmail(String name, String email) {
        SerenityRest.then().body(GoresResponses.NAME,equalTo(name));
        SerenityRest.then().body(GoresResponses.EMAIL,equalTo(email));
    }

    @When("Send request get single comments")
    public void sendRequestGetSingleComments() {
        SerenityRest.when().get(GorestAPI.GET_SINGLE_COMMENTS);

    }
    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(200);
    }

    @Given("Get single comments with id {int}")
    public void getSingleCommentsWithId(int id) {
        gorestAPI.getSingleComments(id);

    }


    @And("Get single comments assert json validation")
    public void getSingleCommentsAssertJsonValidation() {
        File jsonFiles = new File( GorestAPI.JSON_FILE+"/GetSingleCommentsJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFiles));
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int not_found) {
        SerenityRest.then().statusCode(404);
    }

    @And("Response body should contain message {string}")
    public void responseBodyShouldContainMessage(String arg0) {

    }

    @And("Get single comments invalid id assert json validation")
    public void getSingleCommentsInvalidIdAssertJsonValidation() {
        File jsonFiles = new File( GorestAPI.JSON_FILE+"/GetSingleCommentsInvalidID.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFiles));
    }

    @Given("Get single posts with id {int}")
    public void getSinglePostsWithId(int id) {
        gorestAPI.getSinglePosts(id);
    }
    @When("Send request get single posts")
    public void sendRequestGetSinglePosts() {
        SerenityRest.when().get(GorestAPI.GET_SINGLE_POSTS);

    }

    @And("Get single post assert json validation")
    public void getSinglePostAssertJsonValidation() {
        File jsonFiles = new File( GorestAPI.JSON_FILE+"/GetSinglePostsJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFiles));
    }



    @And("Get single posts invalid id assert json validation")
    public void getSinglePostsInvalidIdAssertJsonValidation() {
        File jsonFiles = new File( GorestAPI.JSON_FILE+"/GetSinglePostsInvalidIDJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFiles));
    }
}
