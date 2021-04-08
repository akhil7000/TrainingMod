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
     * Method to post 'vote'
     *
     * @param url : url to post the response
     * @param headerMap : header with api-key
     * @param vote : Json Body with vote details
     * @return
     */
    public Response setResponse(String url, Map headerMap, String vote) {
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