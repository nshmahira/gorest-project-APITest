package Gorest;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class GorestAPI {
    public static final String URL = "https://gorest.co.in/public/v2/";
    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"/src/test/resources/Json";

    public static String GET_ALL_COMMENTS = URL+"/comments";
    public static String GET_INVALID_COMMENTS = URL+"/comments/";
    public static String GET_SINGLE_COMMENTS = URL+"/comments/{id}";
    public static String GET_SINGLE_POSTS = URL+"/posts/{id}";
    public static String POST_CREATE_COMMENTS = URL+"/posts/24/comments";
    public static String TOKEN;
    public static String POST_UPDATE_COMMENTS = URL+"/comments/";
    public static String DELETE_COMMENTS = URL+"/comments/{id}";


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
    @Step("Post create comments")
    public static void postCreateComments(File json) {
        SerenityRest.given()
                .header("Authorization","Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .body(json);

    }
    @Step("Get all comments invalid")
    public void getAllCommentsInvalid(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post create comments invalid")
    public void postCreateCommentsInvalid(File json) {
        SerenityRest.given()
                .header("Authorization","Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put update comments")
    public void putUpdateComments(File json) {
        SerenityRest.given()
                .header("Authorization","Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete comments")
    public void deleteComments(int id){
        SerenityRest.given()
                .header("Authorization","Bearer "+TOKEN)
                .pathParam ("id",id);
    }

}
