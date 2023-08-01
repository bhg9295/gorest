package com.gorest.model;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

public class PostsPojo {


    private static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in";
        // RestAssured.port = 3030;
        response = given()
                .when()
                .get("/public/v2/users?page=1&per_page=25")
                .then().statusCode(200);
        response.log().all();

    }
}
