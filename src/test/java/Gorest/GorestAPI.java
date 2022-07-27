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
    public static String GET_SINGLE_COMMENTS = URL+"/comments/{id}";
    public static String GET_SINGLE_POSTS = URL+"/posts/{id}";


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

}
