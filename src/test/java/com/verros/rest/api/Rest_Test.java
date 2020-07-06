package com.verros.rest.api;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.equalTo;

import config.IsoEndpoints;
import config.TestConfig;
import org.json.JSONObject;
import org.junit.Test;

public class Rest_Test extends TestConfig {

  @Test
  public void successRest() {
    // use org.json JSONObject to define your json
    JSONObject jsonObj = new JSONObject()
      .put("text", "CSQU3054383");

    given()
      .body(jsonObj.toString())   // use jsonObj toString method
      .when()
      .post(IsoEndpoints.ISO)
      .then()
      .statusCode(202)
      .assertThat()
      .body(equalTo("true"));
  }


  @Test
  public void falseRest() {
    // use org.json JSONObject to define your json
    JSONObject jsonObj = new JSONObject()
      .put("text", "CSQU30543831");

    given()
      .body(jsonObj.toString())   // use jsonObj toString method
      .when()
      .post(IsoEndpoints.ISO)
      .then()
      .statusCode(202)
      .assertThat()
      .body(equalTo("false"));
  }

  @Test
  public void getAll() {

    given()
      .when()
      .get(IsoEndpoints.ISO)
      .then()
      .statusCode(200)
      .assertThat();

  }

  @Test
  public void delete(){
    given()
      .when()
      .delete(IsoEndpoints.ISO + "/1")
      .then()
      .statusCode(204)
      .assertThat();
  }
}
