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

public class CommentStepsDef {
    @Steps
    GorestAPI gorestAPI;


    @When("Send request get comments user")
    public void sendRequestGetCommentsUser() {
        SerenityRest.when().get(GorestAPI.GET_INVALID_COMMENTS);
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

    @Given("authorization bearer token")
    public void authorizationBearerToken() {
     GorestAPI.TOKEN = "5a9b999e34e171cd705e77cc0dfd284652d5f85a1f1c25c3056e9991d246e55d";

    }

    @When("post create comments with valid json file")
    public void postCreateCommentstWithValidJsonFile() {
        File jsonFiles = new File( GorestAPI.JSON_FILE+"/PostCreateComments.json");
        gorestAPI.postCreateComments(jsonFiles);
    }

    @When("Send request post create a new comments")
    public void sendRequestPostCreateANewComments() {
        SerenityRest.when().post(GorestAPI.POST_CREATE_COMMENTS);

    }

    @Then("Status code should be {int} created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(201);

    }

    @Given("Get all comments user with invalid json file")
    public void getAllCommentsUserWithInvalidJsonFile() {
        File jsonFiles = new File( GorestAPI.JSON_FILE+"/GetAllCommentInvalid.json");
        gorestAPI.getAllCommentsInvalid(jsonFiles);
    }

    @Then("Status code should be {int} bad")
    public void statusCodeShouldBeBad(int bad_req) {
        SerenityRest.then().statusCode(400);
    }

    @Then("Status code should be {int} unauthorized")
    public void statusCodeShouldBeUnauthorized(int unauthorized) {
        SerenityRest.then().statusCode(401);
    }

    @When("post create comments with invalid email json file")
    public void postCreateCommentsWithInvalidEmailJsonFile() {
        File jsonFiles = new File( GorestAPI.JSON_FILE+"/PostCreateCommentsInvalid.json");
        gorestAPI.postCreateCommentsInvalid(jsonFiles);

    }

    @When("put update comments with valid json file")
    public void putUpdateCommentsWithValidJsonFile() {
        File jsonFiles = new File( GorestAPI.JSON_FILE+"/PutUpdateComments.json");
        gorestAPI.putUpdateComments(jsonFiles);
    }

    @When("Send request put update comments")
    public void sendRequestPutUpdateComments() {
        SerenityRest.when().post(GorestAPI.POST_UPDATE_COMMENTS);

    }

    @When("put update comments with invalid email json file")
    public void putUpdateCommentsWithInvalidEmailJsonFile() {
        File jsonFiles = new File( GorestAPI.JSON_FILE+"/PutUpdateCommentsInvalid.json");
        gorestAPI.postCreateCommentsInvalid(jsonFiles);

    }

    @Then("Status code should be {int} unprocessable")
    public void statusCodeShouldBeUnprocessable(int Unprocessable) {
        SerenityRest.then().statusCode(422);

    }

    @Given("Delete comments with id {int}")
    public void deleteCommentsWithId(int id) {
        gorestAPI.deleteComments(id);
    }

    @When("Send request delete comments")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(GorestAPI.DELETE_COMMENTS);

    }

    @Then("Status code should be {int} No content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(204);
    }

    @When("Send request delete comments with id {int}")
    public void sendRequestDeleteCommentsWithId(int id) {
        gorestAPI.deleteComments(id);
    }
}
