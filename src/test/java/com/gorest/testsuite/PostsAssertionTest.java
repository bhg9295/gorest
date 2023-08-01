package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class PostsAssertionTest {
    static ValidatableResponse response;

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
    //curl --location --request GET
    //'https://gorest.co.in/public/v2/posts?page=1&per_page=25'

    //1. Verify the if the total record is 25
    @Test
    public void verifytotalRecord(){
        response.body("id.record()", equalTo(25));
    }
    //2. Verify the if the title of id = 2730 is equal to ”Ad ipsa coruscus ipsam eos demitto
    //centum.
    @Test
    public void verifyTitleOfId(){
        response.body("name[3]", equalTo(" Advaya Achari"));

    }

    //3. Check the single user_id in the Array list (4040719)
    @Test
    public void checkUserId(){
        response.body("name[1]", equalTo("4040719 "));
    }
    //4. Check the multiple ids in the ArrayList
    @Test
    public void multipleIds(){
        response.body("id", hasItems(" Tarun Rana,Advaya Achari"));

    }
    //5. Verify the body of userid = 2678 is equal “Carus eaque voluptatem. Calcar
    //spectaculum coniuratio. Abstergo consequatur deleo. Amiculum advenio dolorem.
    //Sollers conservo adiuvo. Concedo campana capitulus. Adfectus tibi truculenter.
    //Canto temptatio adimpleo. Ter degenero animus. Adeo optio crapula. Abduco et
    //antiquus. Chirographum baiulus spoliatio. Suscipit fuga deleo. Comburo aequus
    //cuppedia. Crur cuppedia voluptates. Argentum adduco vindico. Denique undique
    //adflicto. Assentator umquam pel."






}
