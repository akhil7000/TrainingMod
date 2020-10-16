package com.training.services.tests;

import com.training.base.BaseTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.ga.AuthenticationResponse;
import static io.restassured.RestAssured.given;

public class GAAccountTest extends BaseTest{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void  testGuestAuthenticate(){
        RestAssured.baseURI = map.get("URI");
        AuthenticationResponse authenticationResponse = given().
                header(map.get("AppKeyHeader"), (map.get("AppKeyValue"))).
                header(map.get("ContentTypeHeader"), (map.get("ContentTypeValue")))
                .body("{\n" +
                        " \"uid\": \"testShrikant@api.com\",\n" +
                        " \"password\": \"Password1\"\n" +
                        "}").post("/authentication/login")
                .then()
                .extract()
                .response()
                .as(AuthenticationResponse.class);
        logger.info("status"+authenticationResponse.getStatus());
        //logger.info("errors"+authenticationResponse.getErrors());//+ve errors[]
        logger.info("uid"+authenticationResponse.getPayload().getUid());
        logger.info("AccessToken"+authenticationResponse.getPayload().getAccessToken());
        Assertions.assertEquals(authenticationResponse.getStatus(),"200");
        softAssert.assertThat(authenticationResponse.getPayload().getUid()).isEqualTo("testShrikant@api.com");
    }

    @Test
    public void testAuthenticateWrongAppKey() {
        RestAssured.baseURI = map.get("URI");
        AuthenticationResponse authenticationResponse= given().
                header(map.get("AppKeyHeader"), (map.get("AppKeyWrongValue"))).
                header(map.get("ContentTypeHeader"), (map.get("ContentTypeValue")))
                .body("{\n" +
                        " \"uid\": \"testShrikant@api.com\",\n" +
                        " \"password\": \"Password1\"\n" +
                        "}").post("/authentication/login")
                .then()
                .extract()
                .response()
                .as(AuthenticationResponse.class);
        logger.info("status code="+authenticationResponse.getError().getErrorCode());
        logger.info("Error code is="+authenticationResponse.getError().getMessage());
        logger.info("Time="+authenticationResponse.getError().getTime());
        Assertions.assertEquals(authenticationResponse.getStatus(), "401");
        softAssert.assertThat(authenticationResponse.getError().getMessage()).isEqualTo("The API key header is required and the API key provided should be valid.");
    }

    @Test
    public void testAuthenticateWrongUsername() {
        RestAssured.baseURI = map.get("URI");
        AuthenticationResponse authenticationResponse = given().
                header(map.get("AppKeyHeader"), (map.get("AppKeyValue"))).
                header(map.get("ContentTypeHeader"), (map.get("ContentTypeValue")))
                .body("{\n" +
                        " \"uid\": \"testShri@api.com\",\n" +
                        " \"password\": \"Password1\"\n" +
                        "}").post("/authentication/login")
                .then()
                .extract()
                .response()
                .as(AuthenticationResponse.class);
        logger.info(authenticationResponse.getStatus());
        logger.info("status="+authenticationResponse.getStatus());
        logger.info("ERRORCode="+authenticationResponse.getErrors().getErrorCode());
        logger.info("InternalMessage="+authenticationResponse.getErrors().getInternalMessage());
        logger.info("Id="+authenticationResponse.getErrors().getId());
        Assertions.assertEquals(authenticationResponse.getStatus(), "401");
        softAssert.assertThat(authenticationResponse.getErrors().getErrorCode()).isEqualTo("GA-0201");
    }
}