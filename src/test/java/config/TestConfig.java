package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

public class TestConfig {

    @BeforeClass
    public static void setup(){

        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "/iso/api/";
        RestAssured.port = 8080;

      RequestSpecification requestSpecification = new RequestSpecBuilder()
        .addHeader("Content-Type", "application/json")
        .addHeader("Accept", "application/json")
        .build();

      ResponseSpecification responseSpecification = new ResponseSpecBuilder()
        .expectStatusCode(200)
        .build();

      RestAssured.requestSpecification = requestSpecification;
      RestAssured.responseSpecification = responseSpecification;
    }
}
