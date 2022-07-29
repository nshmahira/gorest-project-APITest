package Gorest;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class GorestAPI {
    public static final String URL = "https://gorest.co.in/public/v2/";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"/src/test/resources/Json";
    public static String TOKEN;

    public static String GET_ALL_COMMENTS = URL+"/comments";
    public static String GET_SINGLE_COMMENTS = URL+"/comments/{id}";
    public static String GET_SINGLE_POSTS = URL+"/posts/{id}";
    public static String GET_ALL_USERS = URL+"/users";
    public static String GET_SINGLE_USER = URL+"/users/{id}";
    public static String GET_INVALID = URL+"";
    public static String PUT_UPDATE_USER = URL+"/users/{id}";
    public static String DELETE_USER = URL+"/users/{id}";
    public static String GET_ALL_TODOS = URL+"/todos";
    public static String GET_SINGLE_TODOS = URL+"/todos/{id}";
    public static String PUT_UPDATE_TODOS = URL+"/todos/{id}";
    public static String DELETE_TODOS = URL+"/todos/{id}";

    @Step("Get all comments")
    public void getAllComments(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get single comments")
    public void getSingleComments(int id){
        SerenityRest.given()
                .pathParam ("id",id);
    }

    @Step("Get single posts")
    public void getSinglePosts(int id){
        SerenityRest.given()
                .pathParam ("id",id);
    }

    @Step("Put update user")
    public void putUpdateUser(File json, int id){
        SerenityRest.given()
                .pathParam("id",id)
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given()
                .pathParam("id",id)
                .header("Authorization", "Bearer " + TOKEN);
    }

    @Step("Get single todos")
    public void getSingleTodos(int id){
        SerenityRest.given()
                .pathParam ("id",id);
    }

    @Step("Post create comments")
    public static void postCreateComments(File json) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update todos")
    public void putUpdateTodos(File json, int id){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete todos")
    public void deleteTodos(int id){
        SerenityRest.given()
                .pathParam("id",id)
                .header("Authorization", "Bearer " + TOKEN);
    }
}
