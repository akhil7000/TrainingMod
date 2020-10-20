package com.training.services.tests;

import com.google.gson.Gson;
import com.training.base.BaseTest;
import com.training.services.ga.authenticate.RequestBody;
import com.training.services.ga.authenticate.Response;
import com.training.utilities.RestEngine;
import org.junit.jupiter.api.*;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GAAccountTest extends BaseTest {
    Map<String, Object> headerMap;
    RequestBody requestBodyAuthenticate;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeAll
    public  void setData() {
        headerMap = new HashMap();
        headerMap.put(map.get("AppKeyHeader"),map.get("AppKeyValue"));
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));
    }

    /**
     * testGuestAuthenticate():post requested with body to get the +ve response and parameters passed through Json
     */
    @Test
    public void  testGuestAuthenticate(){
        requestBodyAuthenticate=new RequestBody();
        requestBodyAuthenticate.setUid("testShrikant@api.com");
        requestBodyAuthenticate.setPassword("Password1");
        Response authenticationResponse =
                new RestEngine().getResponsePost(map.get("URI") + "/authentication/login"
                        , headerMap
                        ,new Gson().toJson(requestBodyAuthenticate))
                        .as(Response.class);
        logger.info("status"+authenticationResponse.getStatus());
        logger.info("Account id"+authenticationResponse.getPayload().getAccountId());
        logger.info("error"+authenticationResponse.getErrors());
        Assertions.assertEquals(authenticationResponse.getStatus(),"200");
        softAssert.assertThat(authenticationResponse.getErrors().size()).isEqualTo(0);
        softAssert.assertThat(authenticationResponse.getPayload().getAccountId()).
                isEqualTo("54d7543e-45f1-4b7b-b83c-fa107f44809b");
        softAssert.assertThat(authenticationResponse.getPayload().getLoginStatus()).isEqualTo("AUTHENTICATED");
    }

    /**
     * testAuthenticateWrongAppKey():post requested with wrong appkey and checked the negative response,
     * parameters values passed through Json
     */
    @Test
    public void testAuthenticateWrongAppKey() {
        requestBodyAuthenticate=new RequestBody();
        requestBodyAuthenticate.setUid("testShrikant@api.com");
        requestBodyAuthenticate.setPassword("Password1");
        headerMap.put(map.get("AppKeyHeader"),map.get("AppKeyWrongValue"));
        Response authenticationResponse =
                new RestEngine().getResponsePost(map.get("URI") + "/authentication/login"
                        , headerMap
                        ,new Gson().toJson(requestBodyAuthenticate))
                        .as(Response.class);
        logger.info("status code="+authenticationResponse.getError().getErrorCode());
        logger.info("Error code is="+authenticationResponse.getError().getMessage());
        logger.info("Time="+authenticationResponse.getError().getTime());
        Assertions.assertEquals(authenticationResponse.getStatus(), "401");
        softAssert.assertThat(authenticationResponse.getError().getErrorCode()).isEqualTo("COMMONS-0001");
        softAssert.assertThat(authenticationResponse.getError().getMessage()).
                isEqualTo("The API key header is required and the API key provided should be valid.");
    }

    /**
     * testAuthenticateWrongUsername():post requested with wrong Username and checked the negative response,
     * parameters values passed through Json
     */
    @Test
    public void testAuthenticateWrongUsername() {
        requestBodyAuthenticate=new RequestBody();
        requestBodyAuthenticate.setUid("testShri@api.com");
        requestBodyAuthenticate.setPassword("Password1");
        Response authenticationResponse =
                new RestEngine().getResponsePost(map.get("URI") + "/authentication/login"
                        , headerMap
                        ,new Gson().toJson(requestBodyAuthenticate))
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
        com.training.services.ga.validate.RequestBody requestBody = new com.training.services.ga.validate.RequestBody();
        requestBody.setEmail("testPranav@api.com");

        com.training.services.ga.validate.Response gaValidationResponse = new RestEngine()
                .getResponsePost(map.get("base_url") + "/validation"
                        , headerMap
                        , new Gson().toJson(requestBody))
                .as(com.training.services.ga.validate.Response.class);

        Assertions.assertEquals(gaValidationResponse.getStatus(), 200, "Json response is not 200");

        softAssert.assertThat(gaValidationResponse.getPayload().getAccountStatus())
                .as("Inside payload JSON, accountStatus is not equals to EXISTS")
                .isEqualTo("EXISTS");

        softAssert.assertThat(gaValidationResponse.getPayload().isUid())
                .as("Inside payload JSON, isUid should be true")
                .isEqualTo(true);
    }

    /**
     * Putting headers AppKey wrong and validating response
     */
    @Test
    public void testGuestAccountWrongAppKey() {
        headerMap.put(map.get("AppKeyHeader"), map.get("WrongAppKeyValue"));

        com.training.services.ga.validate.RequestBody requestBody = new com.training.services.ga.validate.RequestBody();
        requestBody.setEmail("testPranav@api.com");

        com.training.services.ga.validate.Response gaValidationNegativeResponse =
                new RestEngine().getResponsePost(map.get("base_url") + "/validation"
                        , headerMap
                        , new Gson().toJson(requestBody))
                        .as(com.training.services.ga.validate.Response.class);

        Assertions.assertEquals(gaValidationNegativeResponse.getStatus(), 401
                , "Json response is not 401");

        softAssert.assertThat(gaValidationNegativeResponse.getError().getErrorCode())
                .as("Inside error JSON, error code is not equals to COMMONS-0001")
                .isEqualTo("COMMONS-0001");

        softAssert.assertThat(gaValidationNegativeResponse.getError().getMessage())
                .as("Inside error JSON, message is not equals to The API key " +
                        "header is required and the API key provided should be valid.")
                .isEqualTo("The API key header is required and the API key provided should be valid.");

        softAssert.assertThat(gaValidationNegativeResponse.getErrors().get(0).getInternalMessage())
                .as("Inside errors JSON, message is not equals to" +
                        "The API key header is required and should be valid.")
                .isEqualTo("The API key header is required and should be valid.");
    }

    /**
     * Putting invalid email id (assignment70test@api.com) , and checking if user exits or not
     */
    @Test
    public void testGuestAccountWrongEmail() {
        com.training.services.ga.validate.RequestBody requestBody = new com.training.services.ga.validate.RequestBody();
        requestBody.setEmail("testPr@api.com");

        com.training.services.ga.validate.Response gaValidationResponse =
                new RestEngine().getResponsePost(map.get("base_url") + "/validation"
                        , headerMap
                        , new Gson().toJson(requestBody))
                        .as(com.training.services.ga.validate.Response.class);

        Assertions.assertEquals(gaValidationResponse.getStatus(), 200, "Json response is not 200");

        softAssert.assertThat(gaValidationResponse.getPayload().getAccountStatus())
                .as("Inside payload JSON, account status is not equals to DOES_NOT_EXIST")
                .isEqualTo("DOES_NOT_EXIST");

        softAssert.assertThat(gaValidationResponse.getPayload().isUid())
                .as("Inside payload JSON, is uid should be false")
                .isFalse();
    }

    /**
     * Putting wrong email in wrong format (testPranav@@api.com) and checking the response
     */
    @Test
    public void testGuestAccountInvalidEmail() {
        com.training.services.ga.validate.RequestBody requestBody = new com.training.services.ga.validate.RequestBody();
        requestBody.setEmail("testPranav@@api.com");

        com.training.services.ga.validate.Response gaValidationNegativeResponse =
                new RestEngine().getResponsePost(map.get("base_url") + "/validation"
                        , headerMap
                        , new Gson().toJson(requestBody))
                        .as(com.training.services.ga.validate.Response.class);

        Assertions.assertEquals(gaValidationNegativeResponse.getStatus(), 422
                , "Json response is not 422");

        softAssert.assertThat(gaValidationNegativeResponse.getErrors().get(0).getInternalMessage())
                .as("Inside errors JSON, developer message is not equal to," +
                        " The request body did not pass input validation.")
                .isEqualTo("The request body did not pass input validation.");

        softAssert.assertThat(gaValidationNegativeResponse.getErrors().get(0).getErrorCode())
                .as("Inside error JSON, error code is not equals to GA-0103")
                .isEqualTo("GA-0103");
    }
}