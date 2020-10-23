package com.training.utilities;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestEngine {

    /**
     * We are using rest assured method multiple times, so defining rest assured method in one method call getResponsePost
     * , and calling this method in test method
     *
     * @param base_url  = Is the complete URL of the server
     * @param headerMap = In this we are passing AppKey, Content-Type key and there respective value
     * @param jsonBody  =  Json body is we are passing.
     * @return = we are returning the response which is coming from server
     */
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

    /**
     * We are writing rest assured method inside below class to decrease the loc in testcases,
     * and calling this method getResponsePut in test method
     *
     * @param base_url  = Is the complete URL of the server
     * @param headerMap = In this we are passing AppKey, Content-Type key, Access-Token and there respective value
     * @param jsonBody  =  Json body is we are passing.
     * @return =  we are returning the response which is coming from server
     */
    public Response getResponsePut(String base_url, Map headerMap, String jsonBody) {
        return given()
                .headers(headerMap)
                .body(jsonBody)
                .when()
                .put(base_url)
                .then()
                .extract()
                .response();
    }

    /**
     *
     * @param base_url:complete url
     * @param headerMap:passing Appkey and content type:json
     * @return: response
     */
    public Response getResponseGet(String base_url, Map headerMap) {
        return given()
              .headers(headerMap)
                .when()
                .get(base_url)
                .then()
                .extract()
                .response();
    }

    /**
     * We are writing rest assured method inside below class to decrease the loc in testcases,
     * and calling this method getResponseGet in test method
     *
     * @param base_url      = Is the complete URL of the server
     * @param headerMap     = In this we are passing AppKey, Content-Type key and there respective value
     * @param queryParamMap = In this query parameter we are passing sailing id, category id key and there respective value
     * @return =  we are returning the response which is coming from server
     */
    public Response getResponseGet(String base_url, Map headerMap, Map queryParamMap) {
        return given()
                .queryParams(queryParamMap)
                .headers(headerMap)
                .when()
                .get(base_url)
                .then()
                .extract()
                .response();
    }
}