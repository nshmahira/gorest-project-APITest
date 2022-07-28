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

    @And("authorization bearer token")
    public void authorizationBearerToken() {
        GorestAPI.TOKEN = "5a9b999e34e171cd705e77cc0dfd284652d5f85a1f1c25c3056e9991d246e55d";

    }

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

    @Given("Get all user with valid json file")
    public void getAllUserWithValidJsonFile() {
        File jsonFiles = new File( GorestAPI.JSON_FILE+"/GetAllUser.json");
        gorestAPI.getAllComments(jsonFiles);
    }

    @When("Send request get user")
    public void sendRequestGetUser() {
        SerenityRest.when().get(GorestAPI.GET_ALL_USERS);
    }

    @And("Get all user assert json validation")
    public void getAllUserAssertJsonValidation() {
        File jsonFile = new File(GorestAPI.JSON_FILE +"/GetAllUsersJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }
    @Given("Get all user with invalid json file")
    public void getAllUserWithInvalidJsonFile() {
        File jsonFiles = new File( GorestAPI.JSON_FILE+"/GetAllInvalidUser.json");
        gorestAPI.getAllComments(jsonFiles);
    }

    @When("Send request get invalid user")
    public void sendRequestGetInvalidUser() {
        SerenityRest.when().get(GorestAPI.GET_INVALID);
    }

    @Given("Get single user with id {int}")
    public void getSingleUserWithId(int id) {
        gorestAPI.getSingleComments(id);

    }
    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(GorestAPI.GET_SINGLE_USER);

    }
    @And("Get single user assert json validation")
    public void getSingleUserAssertJsonValidation() {
        File jsonFiles = new File( GorestAPI.JSON_FILE+"/GetSingleUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFiles));
    }

    @Given("Create new user with valid json file")
    public void createNewUserWithValidJsonFile() {
        File jsonFiles = new File( GorestAPI.JSON_FILE+"/CreateAllUser.json");
        gorestAPI.getAllComments(jsonFiles);
    }

    @Given("Create new user with invalid json file")
    public void createNewUserWithInvalidJsonFile() {
        File jsonFiles = new File( GorestAPI.JSON_FILE+"/CreateAllInvalidUser.json");
        gorestAPI.getAllComments(jsonFiles);
    }

    @Given("Put update user with id {int} and with valid json file")
    public void putUpdateUserWithIdAndWithValidJsonFile(int id) {
        File jsonFiles = new File( GorestAPI.JSON_FILE+"/CreateAllUser.json");
        gorestAPI.putUpdateUser(jsonFiles,id);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(GorestAPI.PUT_UPDATE_USER);
    }
    @Given("Delete user with id {int}")
    public void deleteUserWithId(int id) {
       gorestAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(GorestAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No content")
    public void statusCodeShouldBeNoItem(int nocontent) {
        SerenityRest.then().statusCode(204);
    }

    @Given("Get all todos with valid json file")
    public void getAllTodosWithValidJsonFile() {
        File jsonFiles = new File( GorestAPI.JSON_FILE+"/GetAllTodos.json");
        gorestAPI.getAllComments(jsonFiles);
    }

    @When("Send request get todos")
    public void sendRequestGetTodos() {
        SerenityRest.when().get(GorestAPI.GET_ALL_TODOS);
    }

    @And("Get all todos assert json validation")
    public void getAllTodosAssertJsonValidation() {
        File jsonFile = new File(GorestAPI.JSON_FILE +"/GetAllComentJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @Given("Get all todos with invalid json file")
    public void getAllTodosWithInvalidJsonFile() {
        File jsonFiles = new File( GorestAPI.JSON_FILE+"/GetAllInvalidUser.json");
        gorestAPI.getAllComments(jsonFiles);
    }

    @When("Send request get invalid todos")
    public void sendRequestGetInvalidTodos() {
        SerenityRest.when().get(GorestAPI.GET_INVALID);
    }

    @Given("Get single todos with id {int}")
    public void getSingleTodosWithId(int id) {
        gorestAPI.getSingleTodos(id);
    }

    @And("Get single todos assert json validation")
    public void getSingleTodosAssertJsonValidation() {
        File jsonFiles = new File( GorestAPI.JSON_FILE+"/GetSingleTodosJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFiles));
    }

    @When("Send request get single todos")
    public void sendRequestGetSingleTodos() {
        SerenityRest.when().get(GorestAPI.GET_SINGLE_TODOS);
    }

    @Given("Create new todos with valid json file")
    public void createNewTodosWithValidJsonFile() {
        File jsonFiles = new File( GorestAPI.JSON_FILE+"/CreateAllTodos.json");
        gorestAPI.getAllComments(jsonFiles);
    }

    @Given("Create new todos with invalid json file")
    public void createNewTodosWithInvalidJsonFile() {
        File jsonFiles = new File( GorestAPI.JSON_FILE+"/CreateAllInvalidTodos.json");
        gorestAPI.getAllComments(jsonFiles);
    }

    @Given("Put update todos with id {int} and with valid json file")
    public void putUpdateTodosWithIdAndWithValidJsonFile(int id) {
        File jsonFiles = new File( GorestAPI.JSON_FILE+"/CreateAllTodos.json");
        gorestAPI.putUpdateTodos(jsonFiles,id);
    }

    @When("Send request put update todos")
    public void sendRequestPutUpdateTodos() {
        SerenityRest.when().put(GorestAPI.PUT_UPDATE_TODOS);
    }

    @Given("Delete todos with id {int}")
    public void deleteTodosWithId(int id) {
        gorestAPI.deleteTodos(id);
    }

    @When("Send request delete todos")
    public void sendRequestDeleteTodos() {
        SerenityRest.when().delete(GorestAPI.DELETE_TODOS);
    }


}
