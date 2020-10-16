package com.training.services.tests;

import com.training.base.BaseTest;
import com.training.utilities.RestEngine;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.ga.authenticate.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GAAccountTest extends BaseTest{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void  testGuestAuthenticate(){
        String uid="testShrikant@api.com";
        RestAssured.baseURI = map.get("URI");
        Response authenticationResponse = given().
                header(map.get("AppKeyHeader"), (map.get("AppKeyValue"))).
                header(map.get("ContentTypeHeader"), (map.get("ContentTypeValue")))
                .body("{\n" +
                        " \"uid\": \""+uid+"\",\n" +
                        " \"password\": \"Password1\"\n" +
                        "}").post("/authentication/login")
                .then()
                .extract()
                .response()
                .as(Response.class);
        logger.info("status"+authenticationResponse.getStatus());
        logger.info("uid"+authenticationResponse.getPayload().getAccountId());
        logger.info("error"+authenticationResponse.getErrors());
        Assertions.assertEquals(authenticationResponse.getStatus(),"200");
        softAssert.assertThat(authenticationResponse.getErrors().size()).isEqualTo(0);
        softAssert.assertThat(authenticationResponse.getPayload().getAccountId()).isEqualTo("54d7543e-45f1-4b7b-b83c-fa107f44809b");
        softAssert.assertThat(authenticationResponse.getPayload().getLoginStatus()).isEqualTo("AUTHENTICATED");
        softAssert.assertThat(authenticationResponse.getPayload().getUid()).isEqualTo(uid);
    }

    @Test
    public void testAuthenticateWrongAppKey() {
        RestAssured.baseURI = map.get("URI");
        Response authenticationResponse= given().
                header(map.get("AppKeyHeader"), (map.get("AppKeyWrongValue"))).
                header(map.get("ContentTypeHeader"), (map.get("ContentTypeValue")))
                .body("{\n" +
                        " \"uid\": \"testShrikant@api.com\",\n" +
                        " \"password\": \"Password1\"\n" +
                        "}").post("/authentication/login")
                .then()
                .extract()
                .response()
                .as(Response.class);
        logger.info("status code="+authenticationResponse.getError().getErrorCode());
        logger.info("Error code is="+authenticationResponse.getError().getMessage());
        logger.info("Time="+authenticationResponse.getError().getTime());
        Assertions.assertEquals(authenticationResponse.getStatus(), "401");
        softAssert.assertThat(authenticationResponse.getError().getErrorCode()).isEqualTo("COMMONS-0001");
        softAssert.assertThat(authenticationResponse.getError().getMessage()).
                isEqualTo("The API key header is required and the API key provided should be valid.");
    }

    @Test
    public void testAuthenticateWrongUsername() {
        RestAssured.baseURI = map.get("URI");
        Response authenticationResponse = given().
                header(map.get("AppKeyHeader"), (map.get("AppKeyValue"))).
                header(map.get("ContentTypeHeader"), (map.get("ContentTypeValue")))
                .body("{\n" +
                        " \"uid\": \"testShri@api.com\",\n" +
                        " \"password\": \"Password1\"\n" +
                        "}").post("/authentication/login")
                .then()
                .extract()
                .response()
                .as(Response.class);
        logger.info("status="+authenticationResponse.getStatus());
        logger.info("InternalMessage="+authenticationResponse.getErrors().get(0).getInternalMessage());
        logger.info("Id="+authenticationResponse.getErrors().get(0).getId());
        Assertions.assertEquals(authenticationResponse.getStatus(), "401");
        softAssert.assertThat(authenticationResponse.getErrors().get(0).getErrorCode()).isEqualTo("GA-0201");
        softAssert.assertThat(authenticationResponse.getErrors().get(0).getInternalMessage())
                .isEqualTo("The credentials provided are not able to be authenticated.");
    }

    /**
     * Positive validation, putting all valid details and checking response
     */
    @Test
    public void testGuestAccountValidation() {
        Map<String, Object> headerMap = new HashMap();
        headerMap.put(map.get("AppKeyHeader"), map.get("AppKeyValue"));
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));

        com.training.services.ga.validate.Response gaValidationResponse = new RestEngine()
                .getResponsePost(map.get("base_url") + "/validation"
                        , headerMap
                        , "{\"email\": \"testPranav@api.com\"}")
                .as(com.training.services.ga.validate.Response.class);

        Assertions.assertEquals(gaValidationResponse.getStatus(), 200, "Json response is not 200");

        softAssert.assertThat(gaValidationResponse.getPayload().getAccountStatus())
                .as("Inside payload JSON, accountStatus is not equals to EXISTS")
                .isEqualTo("EXISTS");

        softAssert.assertThat(gaValidationResponse.getPayload().getIsUid())
                .as("Inside payload JSON, isUid should be true")
                .isEqualTo(true);
    }
}