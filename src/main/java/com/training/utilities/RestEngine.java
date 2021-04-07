package com.training.utilities;


import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class RestEngine {

    public Response getResponse(String url, Map headerMap) {
        return  RestAssured.given()
                .when()
                .headers(headerMap)
                .get(url)
                .then()
                .extract()
                .response();

    }

    public Response postResponse(String url, Map headerMap, String vote) {
        return  RestAssured.given()
                .when()
                .contentType("application/json")
                .headers(headerMap)
                .body(vote)
                .post(url)
                .then()
                .extract().response();
    }
}