package com.training.api.tests.ga;

import com.google.gson.Gson;
import com.training.basetest.ApiBaseTest;
import com.training.pojos.ga.authentication.Payload;
import com.training.pojos.ga.validation.Request;
import com.training.utilities.RestEngine;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GuestAccountTests extends ApiBaseTest {
    private final String email = "email@email.com";
    private static final String REQUEST_UNSUCCESSFUL = "Request Unsuccessful";
    private static final String ERROR_PRESENT = "Error present in response";

    @BeforeEach
    public void startup(){
        RestAssured.baseURI = map.get("gaBaseUrl");
        headerMap.put(map.get("gaValidationAppKeyHeaderName"),map.get("gaValidationAppKeyHeaderValue"));
        headerMap.put(map.get("gaValidationContentTypeHeaderName") ,map.get("gaValidationContentTypeHeaderValue"));
    }

    @Test
    public void testLoginValidation(){
        com.training.pojos.ga.validation.Request request = new Request();
        request.setPassword("password1");
        request.setUid(email);

        response = new RestEngine().getResponse("/en/royal/web/v3/guestAccounts/authentication/login",headerMap,
                new Gson().toJson(request));

        com.training.pojos.ga.validation.Response responseElement = response.as(com.training.pojos.ga.validation.Response.class);

        Assertions.assertEquals(200,responseElement.getStatus(),REQUEST_UNSUCCESSFUL);
        softAssertions.assertThat(responseElement.getErrors().length).as(ERROR_PRESENT)
                .isEqualTo(0);
        softAssertions.assertThat(responseElement.getPayload().getAccessToken()).as("Access Token Empty")
                .isNotEmpty();
        softAssertions.assertThat(responseElement.getPayload().getUid()).as("Uid not same as body")
                .isEqualTo(email);
    }

    @Test
    public void testLoginAuthentication(){

        com.training.pojos.ga.authentication.Request request = new com.training.pojos.ga.authentication.Request();
        request.setEmail(email);

        response = new RestEngine().getResponse("/en/al/web/v3/guestAccounts/validation",headerMap,
                new Gson().toJson(request));

        com.training.pojos.ga.authentication.Response responseElement =
                response.as(com.training.pojos.ga.authentication.Response.class);

        Assertions.assertEquals(200,responseElement.getStatus(),REQUEST_UNSUCCESSFUL);

        softAssertions.assertThat(responseElement.getErrors().length).as(ERROR_PRESENT)
                .isEqualTo(0);

        Payload payload = responseElement.getPayload();
        softAssertions.assertThat(payload.getAccountStatus()).as("Account Status mismatch")
                .isEqualTo("EXISTS");

        softAssertions.assertThat(payload.isUid()).as("Email doesn't exists")
                .isEqualTo(true);
    }
}