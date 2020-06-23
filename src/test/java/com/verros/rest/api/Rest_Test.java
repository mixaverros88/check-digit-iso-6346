package com.verros.rest.api;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import org.json.JSONObject;
import org.junit.Test;

public class Rest_Test {

  @Test
  public void successRest() {
    // use org.json JSONObject to define your json
    JSONObject jsonObj = new JSONObject()
      .put("text","CSQU3054383");

    given()
      .port(8080) // port number
      .contentType("application/json")  //another way to specify content type
      .body(jsonObj.toString())   // use jsonObj toString method
      .when()
      .post("http://localhost:8080/iso/api/rest")
      .then()
      .assertThat()
      .body(equalTo("true"));
  }


  @Test
  public void falseRest() {
    // use org.json JSONObject to define your json
    JSONObject jsonObj = new JSONObject()
      .put("text","CSQU30543831");

    given()
      .port(8080) // port number
      .contentType("application/json")  //another way to specify content type
      .body(jsonObj.toString())   // use jsonObj toString method
      .when()
      .post("http://localhost:8080/iso/api/rest")
      .then()
      .assertThat()
      .body(equalTo("false"));
  }

}
