package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UserExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
        response.log().all();


    }
//1. Extract the All Ids
    @Test
    public void allIds(){
       List<Integer> ids =  response.extract().path("id");
       System.out.println("------------------StartingTest---------------------------");
        System.out.println(" Extract the All Ids : "+ ids );
        System.out.println("------------------End of Test---------------------------");
    }


//2. Extract the all Names
    @Test
    public void allNames(){
        List<String> Names =  response.extract().path("name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" Extract the All Names : "+ Names );
        System.out.println("------------------End of Test---------------------------");
    }
    //3. Extract the name of 5th object
    @Test
public void nameOfObject(){
    String fifthProduct =  response.extract().path("[4].name");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("Extract the name of 5th product "+ fifthProduct );
    System.out.println("------------------End of Test---------------------------");

}
//4. Extract the names of all object whose status = inactive
    @Test
    public void objectOfStatus(){

        List<HashMap<String ,?>> status = response.extract().path("status.findAll{it.status == 'inactive'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Extract the name all product "+ status );
        System.out.println("------------------End of Test---------------------------");

    }
//5. Extract the gender of all the object whose status = active
    @Test
    public void genderOfTheGender(){
        List<HashMap<String, ?>> status = response.extract().path("status.findAll{it.status == 'active'}.gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the gender of all the object whose status = active "+ status );
        System.out.println("------------------End of Test---------------------------");

    }

//6. Print the names of the object whose gender = female
    @Test
    public void nameOfObjectGender(){
        List<HashMap<String, ?>> gender = response.extract().path("name.findAll{it.name == 'active'}.female");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the names of the object whose gender = female "+ gender );
        System.out.println("------------------End of Test---------------------------");
    }
    //7. Get all the emails of the object where status = inactive
    @Test
    public void emailOfObjectStatus(){
        List<HashMap<String, ?>> gender = response.extract().path("email.findAll{it.email == 'inactive'}.inactive");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("all the emails of the object where status = inactive "+ gender );
        System.out.println("------------------End of Test---------------------------");

    }
//8. Get the ids of the object where gender = male
    @Test
    public void idsOfObject(){
        List<HashMap<String, ?>> gender = response.extract().path("id.findAll{it.id == 'gender'}.male");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the ids of the object where gender = male "+ gender);
        System.out.println("------------------End of Test---------------------------");
    }
    //9. Get all the status
    @Test
    public void theStatus(){
        List<HashMap<String ,?>> status = response.extract().path("status");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" all the status "+ status );
        System.out.println("------------------End of Test---------------------------");
    }
//10. Get email of the object where name = Karthik Dubashi IV
    @Test
    public void emailOfObjectName(){
       // String model =  response.extract().path("email.");
        List<HashMap<String, ?>> email = response.extract().path("email.findAll{it.email ==  \"kapoor_sr_inder@stracke.example\",}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(""+ email );
        System.out.println("------------------End of Test---------------------------");
    }


//11. Get gender of id = gender
    @Test
    public void genderId(){
        String model =  response.extract().path("id.gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("gender of id = gender "+ model );
        System.out.println("------------------End of Test---------------------------");
    }


    }

