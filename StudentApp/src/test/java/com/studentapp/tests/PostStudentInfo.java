package com.studentapp.tests;

import RequestBuilder.PostStudentInfoRequest;
import Support.TestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;


public class PostStudentInfo extends TestBase {

@Test
@DisplayName("Post request to student end point adds a new student to the system")
void addStudent(){
    PostStudentInfoRequest req = new PostStudentInfoRequest();
    given()
            .contentType(ContentType.JSON)
            .when()
            .body(req.buildRequestBody())
            .log().body()
            .post()
            .then()
            .statusCode(201);
            }
}
