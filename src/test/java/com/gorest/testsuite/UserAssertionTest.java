package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class UserAssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in";
       // RestAssured.port = 3030;
        response = given()
                .when()
                .get("/public/v2/users?page=1&per_page=20")
                .then().statusCode(200);
        response.log().all();


    }
    //curl --location --request GET
    //'https://gorest.co.in/public/v2/users?page=1&per_page=20'
    @Test
    //1. Verify the if the total record is 20
    public void totalRecords() {

        response.body("id.size()", equalTo(20));
    }
    //2. Verify the if the name of id = 4040701 is equal to "Advaya Achari"
    @Test
    public void theNameOfId(){
        response.body("name[3]", equalTo(" Advaya Achari"));

    }
    //3. Check the single ‘Name’ in the Array list (Eekalabya Pillai)
    @Test
    public void  theSingleName(){

        response.body("name[5]", equalTo(" Eekalabya Pillai "));
    }
    //4. Check the multiple ‘Names’ in the ArrayList (Mrs. Menaka Bharadwaj, Msgr. Bodhan
    //Guha, Karthik Dubashi IV)
    @Test
    public void multipleName(){
        response.body("name", hasItems(" Tarun Rana,Advaya Achari"));
    }
    //5. Verify the email of userid = 4040702 is equal  "tarun_rana@lynch-oconner.example"
@Test    public void emailOfUserId(){
        response.body("email", hasItem("tarun_rana@lynch-oconner.example"));
    }
    //6. Verify the status is “Active” of user name is “Shanti Bhat V”
    @Test
    public void verifyTheStatus(){

        response.body("status[0]", equalTo(" Inder Kapoor Sr."));
    }
    //7. Verify the Gender = male of user name is “Niro Prajapat”
    @Test
    public void verifyTheGender(){
        response.body("gender", equalTo(" Niro Prajapat"));
    }
}
