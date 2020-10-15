package com.training.services.tests;

import com.training.base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.GA.AuthenticationResponse;
import static io.restassured.RestAssured.given;

public class GuestAccountAuthenticate extends BaseTest{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void  guestAuthenticate(){
        RestAssured.baseURI="https://aws-stg1.api.rccl.com/en/royal/web/v3/guestAccounts";
        RequestSpecification request= given();
        request.header(map.get("Headerkey1"),(map.get("HeaderValue1")));
        request.header(map.get("Headerkey2"),(map.get("HeaderValue2")));
        JSONObject requestParams = new JSONObject();
        requestParams.put("uid", "testShrikant@api.com");
        requestParams.put("password", "Password1");
        request.body(requestParams.toString());
        Response response = request.post("/authentication/login");
        AuthenticationResponse authenticationResponse =response.as(AuthenticationResponse.class);
        authenticationResponse.getStatus();
        authenticationResponse.getErrors();
        authenticationResponse.getPayload().getAccessToken();
        authenticationResponse.getPayload().getAccountId();
        authenticationResponse.getPayload().getFirstName();
        authenticationResponse.getPayload().getUid();
        logger.info("status"+authenticationResponse.getStatus());
        logger.info("errors"+authenticationResponse.getErrors());
        logger.info("uid"+authenticationResponse.getPayload().getUid());
        logger.info("AccessToken"+authenticationResponse.getPayload().getAccessToken());
    }
}
