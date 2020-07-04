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
      .log().all()
      .body(jsonObj.toString())   // use jsonObj toString method
    .when()
      .post(IsoEndpoints.ISO)
    .then()
      .assertThat()
      .body(equalTo("true"));
  }


  @Test
  public void falseRest() {
    // use org.json JSONObject to define your json
    JSONObject jsonObj = new JSONObject()
      .put("text", "CSQU30543831");

    given()
      .log().all()
      .body(jsonObj.toString())   // use jsonObj toString method
      .when()
      .post(IsoEndpoints.ISO)
      .then()
      .assertThat()
      .body(equalTo("false"));
  }

}
