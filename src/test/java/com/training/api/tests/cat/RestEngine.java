package com.training.api.tests.cat;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;


import java.util.Map;

public class RestEngine {
    public Response getResponse(String baseUri) {
        return  given()
                .when()

                .get(baseUri)
                .then()
                .extract()
                .response();

    }
    public Response getResponse2(String baseUri, Map headerMap) {
        return  given()
                .when()
                .headers(headerMap)
                .get(baseUri)
                .then()
                .extract()
                .response();

    }

    public Response postResponse(String url, Map headerMap, String vote) {
        return  given()
                .when()
                .contentType("application/json")
                .headers(headerMap)
                .body(vote)
                .post(url)
                .then()
                .extract().response();
    }
}
