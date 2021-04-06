package com.training.api.tests.cat;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;


import java.util.Map;

public class RestEngine {
    public Response getResponsePost(String baseUri, Map header) {
        return  given()
                .headers(header)
                .when()
                .post(baseUri)
                .then()
                .extract()
                .response();
    }
}
