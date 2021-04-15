package com.training.api.tests.ga;

import com.google.gson.Gson;
import com.training.basetest.ApiBaseTest;
import com.training.pojos.ga.validation.Request;
import com.training.utilities.RestEngine;
import com.training.utilities.UuidValidator;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GuestAccountTests extends ApiBaseTest {
    private final String email = "email@email.com";
    private final String password = "password1";
    private static final String EMAIL_VALIDATION_URL = "/en/al/web/v3/guestAccounts/validation";
    private static final String REQUEST_UNSUCCESSFUL = "Request Unsuccessful";
    private static final String ERROR_PRESENT = "Error present in response";
    private static final String RESPONSE_ERROR = "Response not as expected";
    private static final String ERROR_CODE = "Wrong Error Code";
    private static final String ERRORS_MESSAGE="Wrong Error Message";
    private static final String DEVELOPERS_MESSAGE = "Wrong Developer Message";
    private static final String INTERNAL_MESSAGE = "Wrong Internal Message";
    private static final String EMAIL_AUTHENTICATION_URL = "/en/royal/web/v3/guestAccounts/authentication/login";

    @BeforeEach
    public void startup(){
        RestAssured.baseURI = map.get("gaBaseUrl");
        headerMap.put(map.get("gaAppKeyHeaderName"),map.get("gaAppKeyHeaderValue"));
        headerMap.put(map.get("gaContentTypeHeaderName") ,map.get("gaContentTypeHeaderValue"));
    }

    @Test
    public void testLoginValidation(){
        com.training.pojos.ga.validation.Request request = new Request(email);
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
                new com.training.pojos.ga.authentication.Request(email, password);

        response = new RestEngine().getResponse(    EMAIL_AUTHENTICATION_URL,headerMap,
                new Gson().toJson(request));

        com.training.pojos.ga.authentication.Response responseElement =
                response.as(com.training.pojos.ga.authentication.Response.class);

        Assertions.assertEquals(200,responseElement.getStatus(),REQUEST_UNSUCCESSFUL);

        softAssertions.assertThat(responseElement.getErrors().size()).as(ERROR_PRESENT)
                .isEqualTo(0);

        softAssertions.assertThat(responseElement.getPayload().getLoginStatus()).as("Login Status mismatch")
                .isEqualTo("AUTHENTICATED");

        softAssertions.assertThat(responseElement.getPayload().getUid()).as("Email id does not match")
                .isEqualTo(email);
    }

    @Test
    public void testNegativeLoginValidationWrongAppKey() {
        com.training.pojos.ga.validation.Request request = new Request(email);
        String errorCode = "COMMONS-0001";
        headerMap.put(map.get("gaAppKeyHeaderName"),
                RandomStringUtils.randomAlphanumeric(map.get("gaAppKeyHeaderValue").length()));

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
        com.training.pojos.ga.validation.Request request = new Request("mail@email.com");

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
        com.training.pojos.ga.validation.Request request = new Request("email@@email.com");
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

    @Test
    public void testNegativeLoginAuthenticationWrongAppKey(){
        com.training.pojos.ga.authentication.Request request =
                new com.training.pojos.ga.authentication.Request(email,password);
        String errorCode = "COMMONS-0001";
        headerMap.put(map.get("gaAppKeyHeaderName"),
                RandomStringUtils.randomAlphanumeric(map.get("gaAppKeyHeaderValue").length()));

        response = new RestEngine().getResponse(EMAIL_AUTHENTICATION_URL,headerMap,
                new Gson().toJson(request));

        com.training.pojos.ga.authentication.Response responseElement =
                response.as(com.training.pojos.ga.authentication.Response.class);

        Assertions.assertEquals(401,responseElement.getStatus(),ERROR_CODE);

        softAssertions.assertThat(responseElement.getErrors().get(0).getInternalMessage().length()).as(ERRORS_MESSAGE)
                .isGreaterThan(0);

        softAssertions.assertThat(responseElement.getErrors().get(0).getErrorCode()).as(ERROR_CODE)
                .isEqualTo(errorCode);
        softAssertions.assertThat(responseElement .getError().getErrorCode()).as(ERROR_CODE)
                .isEqualTo(errorCode);
        softAssertions.assertThat(responseElement.getError().getMessage().length()).as(ERRORS_MESSAGE)
                .isGreaterThan(0);
    }

    @Test
    public void testNegativeLoginAuthenticationWrongEmail(){
        com.training.pojos.ga.authentication.Request request =
                new com.training.pojos.ga.authentication.Request("mail.email.com",password);

        response = new RestEngine().getResponse(EMAIL_AUTHENTICATION_URL,headerMap,
                new Gson().toJson(request));
        com.training.pojos.ga.authentication.Response responseElement =
                response.as(com.training.pojos.ga.authentication.Response.class);

        Assertions.assertEquals(401,responseElement.getStatus(),ERROR_CODE);

        softAssertions.assertThat(responseElement.getErrors().get(0).getInternalMessage().length()).as(ERRORS_MESSAGE)
                .isGreaterThan(0);

        softAssertions.assertThat(responseElement.getErrors().get(0).getErrorCode()).as(ERROR_CODE)
                .isEqualTo("GA-0201");

        softAssertions.assertThat(responseElement.getErrors().get(0).getDeveloperMessage().length()).as(ERRORS_MESSAGE)
                .isGreaterThan(0);
    }

    @Test
    public void testCreateGuestAccount(){
        String id = RandomStringUtils.randomAlphanumeric(10);
        String firstName="Audrey";
        String lastName="Poole";
        String email= String.format("%s@email.com",id);

        com.training.pojos.ga.createGa.Request request = new com.training.pojos.ga.createGa.Request();
        request.setBirthdate("19620802");
        request.setEmail(email);
        request.setFirstName(firstName);
        request.setLastName(lastName);
        request.setMarketingCountry("USA");
        request.setPassword("Password1");
        request.setPrivacyAcceptDateTime("20190524T090712GMT");
        request.setPrivacyVersion("1.11");
        request.setTncAcceptDateTime("20190524T090712GMT");
        request.setTncVersion("1.8");
        request.setSecurityQuestion("What was the first concert you attended?");
        request.setSecurityQuestionKey("WHAT_WAS_THE_FIRST_CONCERT_YOU_ATTENDED");
        request.setSecurityAnswer("Answer1");
        request.setUidType("EMAIL");

        response = new RestEngine().getResponse("https://aws-stg1.api.rccl.com/en/royal/web/v3/guestAccounts",headerMap,
                new Gson().toJson(request));

        com.training.pojos.ga.createGa.Response responseElement =
                response.as(com.training.pojos.ga.createGa.Response.class);

        Assertions.assertEquals(200,responseElement.getStatus(),REQUEST_UNSUCCESSFUL);

        softAssertions.assertThat(responseElement.getPayload().getAccessToken().length())
                .as("No access token assigned")
                .isGreaterThan(0);

        softAssertions.assertThat(responseElement.getPayload().getLoginStatus())
                .as("Login Status is not authenticated")
                .isEqualTo("AUTHENTICATED");

        softAssertions.assertThat(responseElement.getPayload().getFirstName())
                .as("First name doesn't match")
                .isEqualTo(firstName);

        softAssertions.assertThat(responseElement.getPayload().getLastName())
                .as("Last name doesn't match")
                .isEqualTo(lastName);

        softAssertions.assertThat(responseElement.getPayload().getUid()).as("Email id mismatch")
                .isEqualTo(email);

        softAssertions.assertThat(new UuidValidator().isValidUUID(responseElement.getPayload().getAccountId()))
                .as("Account id format is invalid")
                .isTrue();
    }
}