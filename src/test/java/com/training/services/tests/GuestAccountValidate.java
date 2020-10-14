package com.training.services.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

public class GuestAccountValidate {
    @Test
    public void  guestAuthenticate(){

        RestAssured.baseURI="https://aws-stg1.api.rccl.com";
        RequestSpecification request=RestAssured.given();
        request.header("AppKey", "qP2wzibM0y9rLeRc3jAZQEoBMGgtVGj7");
        request.header("Content-Type", "application/json"); //If value is getting capture from other variable

        JSONObject requestParams = new JSONObject();
        requestParams.put("uid", "testShrikant@api.com");
        requestParams.put("password", "password");

        request.body(requestParams.toString());
        Response response = request.post("/authentication"); //last word of URL
        int StatusCode = response.getStatusCode(); //Get Status Code
        System.out.println("Status code : " + StatusCode);
        System.out.println("Response body: " + response.body().asString()); //Get Response Body
    }

}
