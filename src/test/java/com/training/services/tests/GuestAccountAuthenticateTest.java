package com.training.services.tests;

import com.training.base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.ga.AuthenticateAppKey;
import services.ga.AuthenticationResponse;
import static io.restassured.RestAssured.given;

public class GuestAccountAuthenticateTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testGuestAuthenticate() {
        RestAssured.baseURI = "https://aws-stg1.api.rccl.com/en/royal/web/v3/guestAccounts";
        RequestSpecification request = given();
        request.header(map.get("AppKeyHeader"), (map.get("AppKeyValue")));
        request.header(map.get("ContentTypeHeader"), (map.get("ContentTypeValue")));
        JSONObject requestParams = new JSONObject();
        requestParams.put("uid", "testShrikant@api.com");
        requestParams.put("password", "Password1");
        request.body(requestParams.toString());
        Response response = request.post("/authentication/login");
        AuthenticationResponse authenticationResponse = response.as(AuthenticationResponse.class);
        authenticationResponse.getStatus();
        authenticationResponse.getErrors();
        authenticationResponse.getPayload().getAccessToken();
        authenticationResponse.getPayload().getAccountId();
        authenticationResponse.getPayload().getFirstName();
        authenticationResponse.getPayload().getUid();
        logger.info("status" + authenticationResponse.getStatus());
        logger.info("errors" + authenticationResponse.getErrors());
        logger.info("uid" + authenticationResponse.getPayload().getUid());
        logger.info("AccessToken" + authenticationResponse.getPayload().getAccessToken());
        Assertions.assertEquals(authenticationResponse.getStatus(), "200");
        softAssert.assertThat(authenticationResponse.getPayload().getUid()).isEqualTo("testShrikant@api.com");
    }

    @Test
    public void testAuthenticateWrongAppKey() {
        RestAssured.baseURI = map.get("URI");
        Response response = given().
                header(map.get("AppKeyHeader"), (map.get("AppKeyWrongValue"))).
                header(map.get("ContentTypeHeader"), (map.get("ContentTypeValue")))
                .body("{\n" +
                        " \"uid\": \"testShrikant@api.com\",\n" +
                        " \"password\": \"Password1\"\n" +
                        "}").post("/authentication/login").then().extract().response();
        AuthenticateAppKey authenticateAppKey = response.as(AuthenticateAppKey.class);
        logger.info("status code="+authenticateAppKey.getStatus());
        logger.info("Error code is="+authenticateAppKey.getError().getErrorCode());
        logger.info("Message="+authenticateAppKey.getError().getMessage());
        logger.info("Time="+authenticateAppKey.getError().getTime());
        Assertions.assertEquals(authenticateAppKey.getStatus(), "401");
        softAssert.assertThat(authenticateAppKey.getError().getMessage()).isEqualTo("The API key header is required and the API key provided should be valid.");
    }

    @Test
    public void testAuthenticateWrongUsername() {
        RestAssured.baseURI = map.get("URI");
        Response response = given().
                header(map.get("AppKeyHeader"), (map.get("AppKeyValue"))).
                header(map.get("ContentTypeHeader"), (map.get("ContentTypeValue")))
                .body("{\n" +
                        " \"uid\": \"testShri@api.com\",\n" +
                        " \"password\": \"Password1\"\n" +
                        "}").post("/authentication/login").then().extract().response();
        AuthenticateAppKey authenticateAppKey = response.as(AuthenticateAppKey.class);
        logger.info(authenticateAppKey.getStatus());
        logger.info("ID="+authenticateAppKey.getErrors().getId());
        logger.info("ERRORCode="+authenticateAppKey.getErrors().getErrorCode());
        Assertions.assertEquals(authenticateAppKey.getStatus(), "401");
        softAssert.assertThat(authenticateAppKey.getErrors().getErrorCode()).isEqualTo("GA-0201");
    }
}
