package com.training.api.tests.ga;

import com.google.gson.Gson;
import com.training.basetest.ApiBaseTest;
import com.training.pojos.ga.validation.Request;
import com.training.utilities.RestEngine;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GuestAccountTests extends ApiBaseTest {
    private final String EMAIL = "email@email.com";
    private final String PASSWORD = "password1";
    private final String EMAIL_VALIDATION_URL = "/en/al/web/v3/guestAccounts/validation";
    private static final String REQUEST_UNSUCCESSFUL = "Request Unsuccessful";
    private static final String ERROR_PRESENT = "Error present in response";
    private static final String RESPONSE_ERROR = "Response not as expected";
    private static final String ERROR_CODE = "Wrong Error Code";
    private static final String ERRORS_MESSAGE="Wrong Error Message";
    private static final String DEVELOPERS_MESSAGE = "Wrong Developer Message";
    private static final String INTERNAL_MESSAGE = "Wrong Internal Message";
    com.training.pojos.ga.validation.Request request = new Request(EMAIL);

    @BeforeEach
    public void startup(){
        RestAssured.baseURI = map.get("gaBaseUrl");
        headerMap.put(map.get("gaValidationAppKeyHeaderName"),map.get("gaValidationAppKeyHeaderValue"));
        headerMap.put(map.get("gaValidationContentTypeHeaderName") ,map.get("gaValidationContentTypeHeaderValue"));
    }

    @Test
    public void testLoginValidation(){

        response = new RestEngine().getResponse(EMAIL_VALIDATION_URL,headerMap,
                new Gson().toJson(request));

        com.training.pojos.ga.validation.Response responseElement =
                response.as(com.training.pojos.ga.validation.Response.class);

        Assertions.assertEquals(200,responseElement.getStatus(),REQUEST_UNSUCCESSFUL);
        softAssertions.assertThat(responseElement.getErrors().size()).as(ERROR_PRESENT)
                .isEqualTo(0);
        softAssertions.assertThat(responseElement.getPayload().getAccountStatus()).as("Account Doesn't Exist")
                .isEqualTo("EXISTS");
        softAssertions.assertThat(responseElement.getPayload().isUid()).as("Uid not same")
                .isTrue();
    }

    @Test
    public void testLoginAuthentication(){

        com.training.pojos.ga.authentication.Request request =
                new com.training.pojos.ga.authentication.Request(EMAIL,PASSWORD);

        response = new RestEngine().getResponse(    "/en/royal/web/v3/guestAccounts/authentication/login",headerMap,
                new Gson().toJson(request));

        com.training.pojos.ga.authentication.Response responseElement =
                response.as(com.training.pojos.ga.authentication.Response.class);

        Assertions.assertEquals(200,responseElement.getStatus(),REQUEST_UNSUCCESSFUL);


        softAssertions.assertThat(responseElement.getErrors().size()).as(ERROR_PRESENT)
                .isEqualTo(0);

        softAssertions.assertThat(responseElement.getPayload().getLoginStatus()).as("Login Status mismatch")
                .isEqualTo("AUTHENTICATED");

        softAssertions.assertThat(responseElement.getPayload().getUid()).as("Email id does not match")
                .isEqualTo(EMAIL);
    }

    @Test
    public void testNegativeLoginValidationWrongAppKey() {
        String errorCode = "COMMONS-0001";
        headerMap.put(map.get("gaValidationAppKeyHeaderName"),
                RandomStringUtils.randomAlphanumeric(map.get("gaValidationAppKeyHeaderValue").length()));

        response = new RestEngine().getResponse(EMAIL_VALIDATION_URL, headerMap,
                new Gson().toJson(request));

        com.training.pojos.ga.validation.Response responseElement =
                response.as(com.training.pojos.ga.validation.Response.class);

        Assertions.assertEquals(401, responseElement.getStatus(), RESPONSE_ERROR);

        softAssertions.assertThat(responseElement.getErrors().get(0).getErrorCode()).as(ERROR_CODE)
                .isEqualTo(errorCode);

        softAssertions.assertThat(responseElement.getError().getErrorCode()).as(ERROR_CODE)
                .isEqualTo(errorCode);

        softAssertions.assertThat(responseElement.getError().getMessage()).as(ERRORS_MESSAGE)
                .isNotEmpty();

        softAssertions.assertThat(responseElement.getErrors().get(0).getInternalMessage()).as(ERRORS_MESSAGE)
                .isNotEmpty();
    }

    @Test
    public void testNegativeLoginValidationWrongEmail(){
        request = new Request("mail@email.com");

        response = new RestEngine().getResponse(EMAIL_VALIDATION_URL,headerMap,
                new Gson().toJson(request));

        com.training.pojos.ga.validation.Response responseElement =
                response.as(com.training.pojos.ga.validation.Response.class);

        Assertions.assertEquals(200, responseElement.getStatus(), RESPONSE_ERROR);

        softAssertions.assertThat(responseElement.getErrors().size()).as(ERROR_PRESENT)
                .isEqualTo(0);

        softAssertions.assertThat(responseElement.getPayload().getAccountStatus()).as("Account Exists")
                .isEqualTo("DOES_NOT_EXIST");

        softAssertions.assertThat(responseElement.getPayload().isUid()).as("Uid is True")
                .isFalse();
    }

    @Test
    public void testNegativeLoginValidationInvalidEmail(){
        request = new Request("email@@email.com");
        response = new RestEngine().getResponse(EMAIL_VALIDATION_URL,headerMap,
                new Gson().toJson(request));

        com.training.pojos.ga.validation.Response responseElement =
                response.as(com.training.pojos.ga.validation.Response.class);

        Assertions.assertEquals(422, responseElement.getStatus(), RESPONSE_ERROR);

        softAssertions.assertThat(responseElement.getErrors().get(0).getErrorCode()).as(ERROR_CODE)
                .isEqualTo("GA-0103");

        softAssertions.assertThat(responseElement.getErrors().get(0).getDeveloperMessage()).as(DEVELOPERS_MESSAGE)
                .isNotEmpty();

        softAssertions.assertThat(responseElement.getErrors().get(0).getInternalMessage()).as(INTERNAL_MESSAGE)
                .isNotEmpty();

        softAssertions.assertThat(responseElement.getErrors().get(0).getValidationErrors().get(0)
                                    .getError()).as("Email id Validated")
                                    .isEqualTo("The email is in an invalid format.");
    }
}