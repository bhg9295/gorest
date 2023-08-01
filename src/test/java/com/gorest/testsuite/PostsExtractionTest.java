package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PostsExtractionTest {
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
    //1. Extract the title
    @Test
    public void title(){
        List<String> ids =  response.extract().path("title");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" Extract the title: "+ ids );
        System.out.println("------------------End of Test---------------------------");
    }
    //2. Extract the total number of record
    @Test
    public void totalNumber(){
        List<String> ids =  response.extract().path("record");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" Extract the title: "+ ids );
        System.out.println("------------------End of Test---------------------------");
    }
    //3. Extract the body of 15th record
    @Test
   public void theBody(){
       String fifthProduct =  response.extract().path("[14].body");
       System.out.println("------------------StartingTest---------------------------");
       System.out.println("Extract the name of 5th product "+ fifthProduct );
       System.out.println("------------------End of Test---------------------------");

   }
    //4. Extract the user_id of all the records
    @Test
    public void theUserId(){
        String fifthProduct =  response.extract().path("user_id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the user_id of all the records "+ fifthProduct );
        System.out.println("------------------End of Test---------------------------");
    }
    //5. Extract the title of all the records
    @Test
    public void titleOfRecords(){
        String fifthProduct =  response.extract().path("record");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the title of all the records"+ fifthProduct );
        System.out.println("------------------End of Test---------------------------");
    }
    //6. Extract the title of all records whose user_id = 5456
    @Test
    public void theTitleOfAllRecords(){
        List<HashMap<String, ?>> allrecords = response.extract().path("record.findAll{it.record == 'inactive'}.user_id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the title of all records whose user_id = 5456 "+ allrecords );
        System.out.println("------------------End of Test---------------------------");
    }
    //7. Extract the body of all records whose id = 2671
    @Test
    public void recordsId(){
        List<HashMap<String, ?>> records = response.extract().path("id.findAll{it.id == 'inactive'}.user_id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the body of all records whose id = 2671 "+ records );
        System.out.println("------------------End of Test---------------------------");

    }
}
