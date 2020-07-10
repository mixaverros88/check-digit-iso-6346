package com.verros.rest.api;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import config.IsoEndpoints;
import config.IsoConfig;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

public class Rest_Test extends IsoConfig {

  @Test
  public void successRest() {
    JSONObject jsonObj = new JSONObject()
      .put("text", "CSQU3054383");

    given()
      .body(jsonObj.toString())   // use jsonObj toString method
      .when()
      .post(IsoEndpoints.ISO)
      .then()
      .assertThat()
      .statusCode(201);
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
      .assertThat()
      .statusCode(201)
      .body("validateStatus",equalTo(false));
  }

  @Test
  public void getAll() {

    given()
      .when()
      .get(IsoEndpoints.ISO)
      .then()
      .assertThat()
      .statusCode(200);

  }

  @Test
  public void delete(){
    given()
      .pathParam("isoId", 1)
      .when()
      .delete(IsoEndpoints.ISO_PARAM )
      .then()
      .assertThat()
      .statusCode(204);
  }

  @Test
  public void put(){

    // use org.json JSONObject to define your json
    JSONObject jsonObj = new JSONObject()
      .put("text", "CSQU30543831");

    given()
      .pathParam("isoId", 1)
      .body(jsonObj.toString())   // use jsonObj toString method
      .when()
      .delete(IsoEndpoints.ISO_PARAM)
      .then()
      .assertThat()
      .statusCode(204);
  }
}
