package Reqres;

import java.io.File;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDef {
    @Steps
    ReqresAPI reqresAPI;
    @Given("Get list user with parameter {string}")
    public void getListUserWithParameter(String page) {
        reqresAPI.getListUser(page);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USER);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body should contain first name {string} and last name {string}")
    public void responseBodyShouldContainFirstNameAndLastName(String firstName, String lastName) {
        SerenityRest.then()
                    .body(ReqresResponses.FIRST_NAME,equalTo(firstName))
                    .body(ReqresResponses.LAST_NAME,equalTo(lastName))
        ;
    }

    @Given("Post create new user with valid json file")
    public void postCreateNewUserWithValidJsonFile() {
        File jsonFiles = new File( ReqresAPI.JSON_FILE+"/CreateUser.json");
        reqresAPI.postCreateUser(jsonFiles);
    }
    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body should contain name {string} and job {string}")
    public void responseBodyShouldContainNameAndJob(String name, String job) {
        SerenityRest.then()
                    .body(ReqresResponses.NAME,equalTo(name))
                    .body(ReqresResponses.JOB,equalTo(job))
        ;
    }

    @Given("Put update user with id {int} and with valid json file")
    public void putUpdateUserWithIdAndWithValidJsonFile(int id) {
        File jsonFiles = new File(ReqresAPI.JSON_FILE+"/UpdateUser.json");
        reqresAPI.putUpdateUser(jsonFiles,id);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @Given("Delete user with id {int}")
    public void deleteUserWithId(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No content")
    public void statusCodeShouldBeNoContent(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Get list user assert json validation")
    public void getListUserAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE +"/GetListUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }

    @And("Post create user assert json validation")
    public void postCreateUserAssertJsonValidation() {
        File jsonFile = new File(ReqresAPI.JSON_FILE+"/PostCreateUserJsonValidation.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonFile));
    }
}