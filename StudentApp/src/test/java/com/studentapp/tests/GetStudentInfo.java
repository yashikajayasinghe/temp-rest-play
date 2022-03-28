package com.studentapp.tests;

import Support.TestBase;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;


public class GetStudentInfo extends TestBase{

    void styles(){
        //RestAssured style 1
        RestAssured.given()
                .queryParam("","")
                .when()
                .get("/list")
                .then();

        //RestAssured style 2
        RestAssured.given()
                .expect()
                .when();

    }
    @DisplayName("Get: all students")
    @Test
    void getAllStudents(){
       /*RequestSpecification requestSpec =  RestAssured.given();
       Response response = requestSpec.get("http://localhost:8085/student/list");
       //response.prettyPrint();

       ValidatableResponse validatableResponse = response.then();
       validatableResponse.statusCode(200);*/

                given()
                .when()
                .get("/list")
                .then()
                .statusCode(200);


    }

    @DisplayName("Get: Student with filters for pragramme and limit")
    @Test
    void addfilter(){

        Map<String, Object> qmap = new HashMap<String, Object>();
        qmap.put("programme", "Computer Science");
        qmap.put("limit", 3);

        Response response = given()
                                .queryParams(qmap)
                                .when()
                                .get("/list");
        response.prettyPrint();

    }

    @DisplayName("Get: Student by Id path parameter")
    @Test
    void getStudentById(){
        Response response = given()
                .pathParam("id",1)
                .when()
                .get("/{id}");

        response.prettyPrint();

    }
}
