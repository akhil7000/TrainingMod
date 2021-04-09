package com.training.utilities;


import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class RestEngine {
    /**
     * Method for 'get' http Method
     *
     * @param url : url to get the response from
     * @param headerMap : header with api-key
     * @return
     */
    public Response getResponse(String url, Map headerMap) {
        return  RestAssured.given()
                .when()
                .headers(headerMap)
                .get(url)
                .then()
                .extract()
                .response();
    }

    /**
     * Method to retrieve json key-value pairs post it to the url
     *
     * @param url : url to post the response
     * @param headerMap : header with api-key
     * @param jsonString : Json Body with key-value pairs
     * @return
     */
    public Response getPostResponse(String url, Map headerMap, String jsonString) {
        return  RestAssured.given()
                .when()
                .contentType("application/json")
                .headers(headerMap)
                .body(jsonString)
                .post(url)
                .then()
                .extract()
                .response();
    }
}