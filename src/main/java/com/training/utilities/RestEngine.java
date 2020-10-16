package com.training.utilities;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestEngine {

    public Response getResponsePost(String base_url, Map headerMap, String jsonBody) {
        return given()
                .headers(headerMap)
                .body(jsonBody)
                .when()
                .post(base_url)
                .then()
                .extract()
                .response();
    }
}