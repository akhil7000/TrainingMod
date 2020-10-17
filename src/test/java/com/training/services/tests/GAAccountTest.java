package com.training.services.tests;

import com.training.base.BaseTest;
import com.training.services.ga.authenticate.Response;
import com.training.utilities.RestEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GAAccountTest extends BaseTest {
    Map<String, Object> headerMap = new HashMap();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * testGuestAuthenticate():post requested with body to get the +ve response and parameters passed through Json
     */
    @Test
    public void  testGuestAuthenticate(){
        String uid="testShrikant@api.com";
        Map<String, Object> headerMap = new HashMap();
        headerMap.put(map.get("AppKeyHeader"), map.get("AppKeyValue"));
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));
        Response authenticationResponse =
                new RestEngine().getResponsePost(map.get("URI") + "/authentication/login"
                        , headerMap
                        , "{\n" +
                                " \"uid\": \""+uid+"\",\n" +
                                " \"password\": \"Password1\"\n" +
                                "}")
                        .as(Response.class);
        logger.info("status"+authenticationResponse.getStatus());
        logger.info("uid"+authenticationResponse.getPayload().getAccountId());
        logger.info("error"+authenticationResponse.getErrors());
        Assertions.assertEquals(authenticationResponse.getStatus(),"200");
        softAssert.assertThat(authenticationResponse.getErrors().size()).isEqualTo(0);
        softAssert.assertThat(authenticationResponse.getPayload().getAccountId()).
                isEqualTo("54d7543e-45f1-4b7b-b83c-fa107f44809b");
        softAssert.assertThat(authenticationResponse.getPayload().getLoginStatus()).isEqualTo("AUTHENTICATED");
        softAssert.assertThat(authenticationResponse.getPayload().getUid()).isEqualTo(uid);
    }

    /**
     * testAuthenticateWrongAppKey():post requested with wrong appkey and checked the negative response,
     * parameters values passed through Json
     */
    @Test
    public void testAuthenticateWrongAppKey() {
        Map<String, Object> headerMap = new HashMap();
        headerMap.put(map.get("AppKeyHeader"), map.get("AppKeyWrongValue"));
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));
        Response authenticationResponse =
                new RestEngine().getResponsePost(map.get("URI") + "/authentication/login"
                        , headerMap
                        , "{\n" +
                                " \"uid\": \"testShrikant@api.com\",\n" +
                                " \"password\": \"Password1\"\n" +
                                "}")
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
        Map<String, Object> headerMap = new HashMap();
        headerMap.put(map.get("AppKeyHeader"), map.get("AppKeyValue"));
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));
        Response authenticationResponse =
                new RestEngine().getResponsePost(map.get("URI") + "/authentication/login"
                        , headerMap
                        , "{\n" +
                                " \"uid\": \"testShri@api.com\",\n" +
                                " \"password\": \"Password1\"\n" +
                                "}")
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

    /**
     * Putting headers AppKey wrong and validating response
     */
    @Test
    public void testGuestAccountWrongAppKey() {
        headerMap.put(map.get("AppKeyHeader"), map.get("WrongAppKeyValue"));
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));

        com.training.services.ga.validate.Response gaValidationNegativeResponse =
                new RestEngine().getResponsePost(map.get("base_url") + "/validation"
                        , headerMap
                        , "{\"email\": \"testPranav@api.com\"}")
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
        headerMap.put(map.get("AppKeyHeader"), map.get("AppKeyValue"));
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));

        com.training.services.ga.validate.Response gaValidationResponse =
                new RestEngine().getResponsePost(map.get("base_url") + "/validation"
                        , headerMap
                        , "{\"email\": \"assignment70test@api.com\"}")
                        .as(com.training.services.ga.validate.Response.class);

        Assertions.assertEquals(gaValidationResponse.getStatus(), 200, "Json response is not 200");

        softAssert.assertThat(gaValidationResponse.getPayload().getAccountStatus())
                .as("Inside payload JSON, account status is not equals to DOES_NOT_EXIST")
                .isEqualTo("DOES_NOT_EXIST");

        softAssert.assertThat(gaValidationResponse.getPayload().getIsUid())
                .as("Inside payload JSON, is uid should be false")
                .isFalse();
    }

    /**
     * Putting wrong email in wrong format (testPranav@@api.com) and checking the response
     */
    @Test
    public void testGuestAccountInvalidEmail() {
        headerMap.put(map.get("AppKeyHeader"), map.get("AppKeyValue"));
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));

        com.training.services.ga.validate.Response gaValidationNegativeResponse =
                new RestEngine().getResponsePost(map.get("base_url") + "/validation"
                        , headerMap
                        , "{\"email\": \"testPranav@@api.com\"}")
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