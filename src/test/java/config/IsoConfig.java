package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

public class  IsoConfig {

  @BeforeClass
  public static void setup() {

    RestAssured.baseURI = "http://localhost";
    RestAssured.basePath = "/iso/api/";
    RestAssured.port = 8080;

    RequestSpecification requestSpecification = new RequestSpecBuilder()
      .addHeader("Content-Type", "application/json")
      .addHeader("Accept", "application/json")
      .addFilter(new RequestLoggingFilter())
      .addFilter(new ResponseLoggingFilter())
      .build();

    ResponseSpecification responseSpecification = new ResponseSpecBuilder()
      .build();

    RestAssured.requestSpecification = requestSpecification;
    RestAssured.responseSpecification = responseSpecification;
  }
}
