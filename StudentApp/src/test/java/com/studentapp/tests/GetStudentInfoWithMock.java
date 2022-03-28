package com.studentapp.tests;


import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

import static io.restassured.RestAssured.*;


import com.github.tomakehurst.wiremock.core.Options;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.tomakehurst.wiremock.*;

import java.net.URI;
import java.net.URISyntaxException;


public class GetStudentInfoWithMock{

    /*
    ---WireMock Server details---
    PORT - 9010
    HOST - http://localhost
     */
    private static final int PORT = 8080;
    private static final String HOST = "127.0.0.1";
    private static WireMockServer server = new WireMockServer(options()
            .bindAddress("127.0.0.1")
    );
//private static WireMockConfiguration wconf;
    /**
     * Create wiremock server
     */
@BeforeAll
 public static void setUp(){

    //read:: https://www.petrikainulainen.net/programming/testing/wiremock-tutorial-configuration/

   // wconf =  new WireMockConfiguration();
     server.start();
     ResponseDefinitionBuilder mockResponse = new ResponseDefinitionBuilder();
     mockResponse.withStatus(200);
     WireMock.configureFor(HOST, PORT);
    WireMock.stubFor(
             WireMock.get("/student/list")
            .willReturn(mockResponse));

//    RestAssured.baseURI = "http://localhost";
//    RestAssured.port = 8085;
//    RestAssured.basePath = "/student";
//.get( new URI("http://localhost:8085/student/{id}"))
 }



    @Test
    public void getStudentById() throws URISyntaxException {
        given()
                .when()
                .log().all()
                .get(new URI("http://localhost:8080/student/list"))
                .then()
                .statusCode(200);




    }

    @AfterAll
    public static void tearDown(){

        if(server != null && server.isRunning()){
            server.shutdownServer();
        }
    }

}
