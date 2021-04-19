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

public class GuestAccountTests extends ApiBaseTest{
    private static final String EMAIL = "email@email.com";
    private static final String PASSWORD = "password1";
    private static final String EMAIL_VALIDATION_URL = "/en/al/web/v3/guestAccounts/validation";
    private static final String REQUEST_UNSUCCESSFUL = "Request Unsuccessful";
    private static final String ERROR_PRESENT = "Error present in response";
    private static final String RESPONSE_ERROR = "Response not as expected";
    private static final String ERROR_CODE = "Wrong Error Code";
    private static final String ERRORS_MESSAGE="Wrong Error Message";
    private static final String DEVELOPERS_MESSAGE = "Wrong Developer Message";
    private static final String INTERNAL_MESSAGE = "Wrong Internal Message";
    private static final String EMAIL_AUTHENTICATION_URL = "/en/royal/web/v3/guestAccounts/authentication/login";
    private String email="";
    private String errorMessage = "";

    @BeforeEach
    public void startup(){
        RestAssured.baseURI = map.get("BaseUrl");
        headerMap.put(map.get("rcclAppKeyHeaderName"),map.get("rcclAppKeyHeaderValue"));
        headerMap.put(map.get("rcclContentTypeHeaderName") ,map.get("rcclContentTypeHeaderValue"));
    }

    @Test
    public void testLoginValidation(){
        com.training.pojos.ga.validation.Request request = new Request(EMAIL);
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
                new com.training.pojos.ga.authentication.Request(EMAIL, PASSWORD);

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
                .isEqualTo(EMAIL);
    }

    @Test
    public void testNegativeLoginValidationWrongAppKey() {
        com.training.pojos.ga.validation.Request request = new Request(EMAIL);
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
                new com.training.pojos.ga.authentication.Request(EMAIL, PASSWORD);

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
                new com.training.pojos.ga.authentication.Request("mail.email.com", PASSWORD);

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

        String firstName="Audrey";
        String lastName="Poole";

        email= String.format("%s%s@email.com",
                RandomStringUtils.randomAlphabetic(5),
                System.currentTimeMillis());

        com.training.pojos.ga.creation.Request request = com.training.pojos.ga.creation.Request.builder()
                .email(email)
                .build();

        response = new RestEngine().getResponse(map.get("gaCreateUrl"),headerMap,
                new Gson().toJson(request));

        com.training.pojos.ga.creation.Response responseElement =
                response.as(com.training.pojos.ga.creation.Response.class);

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

        softAssertions.assertThat(responseElement.getPayload().getAccountId())
                .as("Account id pattern doesn't match")
                .matches("^[{]?[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}[}]?$");
    }


    @Test
    public void testNegativeGaCreationWrongAppKey() {
        String errorCode = "COMMONS-0001";

        headerMap.put(map.get("gaAppKeyHeaderName"),
                RandomStringUtils.randomAlphanumeric(map.get("gaAppKeyHeaderValue").length()));

        String email = String.format("%s%s@email.com",
                RandomStringUtils.randomAlphabetic(5),
                System.currentTimeMillis());

        com.training.pojos.ga.creation.Request request = com.training.pojos.ga.creation.Request.builder()
                .email(email)
                .build();

        response = new RestEngine().getResponse(map.get("gaCreateUrl"), headerMap,
                new Gson().toJson(request));

        com.training.pojos.ga.creation.Response responseElement =
                response.as(com.training.pojos.ga.creation.Response.class);

        Assertions.assertEquals(401,responseElement.getStatus(),REQUEST_UNSUCCESSFUL);

        softAssertions.assertThat(responseElement.getErrors().get(0).getInternalMessage()).as(ERRORS_MESSAGE)
                .isEqualTo("The API key header is required and should be valid.");

        softAssertions.assertThat(responseElement.getErrors().get(0).getErrorCode()).as(ERROR_CODE)
                .isEqualTo(errorCode);

        softAssertions.assertThat(responseElement.getError().getErrorCode()).as(ERROR_CODE)
                .isEqualTo(errorCode);

        softAssertions.assertThat(responseElement.getError().getMessage()).as(ERRORS_MESSAGE)
                .isEqualTo("The API key header is required and the API key provided should be valid.");
    }

    @Test
    public void testNegativeGaCreationInvalidEmail(){

        email= "testemail@@email.com";
        errorMessage= "The request body did not pass input validation.";

        com.training.pojos.ga.creation.Request request = com.training.pojos.ga.creation.Request.builder()
                .email(email)
                .build();

        response = new RestEngine().getResponse(map.get("gaCreateUrl"), headerMap,
                new Gson().toJson(request));

        response.getBody().print();

        com.training.pojos.ga.creation.Response responseElement =
                response.as(com.training.pojos.ga.creation.Response.class);

        Assertions.assertEquals(422, responseElement.getStatus(), RESPONSE_ERROR);

        softAssertions.assertThat(responseElement.getErrors().get(0).getErrorCode()).as(ERROR_CODE)
                .isEqualTo("GA-0103");

        softAssertions.assertThat(responseElement.getErrors().get(0).getDeveloperMessage()).as(DEVELOPERS_MESSAGE)
                .isEqualTo(errorMessage);

        softAssertions.assertThat(responseElement.getErrors().get(0).getInternalMessage()).as(INTERNAL_MESSAGE)
                .isEqualTo(errorMessage);

        softAssertions.assertThat(responseElement.getErrors().get(0).getValidationErrors().get(0).getError())
                .as("Email id Validated")
                .isEqualTo("The email is invalidly formatted.");

        softAssertions.assertThat(responseElement.getErrors().get(0).getValidationErrors().get(0).getInvalidValue())
                .as("Incorrect Email Id tested")
                .isEqualTo(email);
    }

    @Test
    public void testNegativeGaCreationExistingEmail(){

        email= "testemail@email.com";
        errorMessage = "An existing account was found with the given details.";

        com.training.pojos.ga.creation.Request request = com.training.pojos.ga.creation.Request.builder()
                .email(email)
                .build();

        response = new RestEngine().getResponse(map.get("gaCreateUrl"),headerMap,
                new Gson().toJson(request));

        com.training.pojos.ga.creation.Response responseElement =
                response.as(com.training.pojos.ga.creation.Response.class);

        Assertions.assertEquals(400,responseElement.getStatus(),ERROR_CODE);

        softAssertions.assertThat(responseElement.getErrors().get(0).getInternalMessage()).as(INTERNAL_MESSAGE)
                .isEqualTo(errorMessage);

        softAssertions.assertThat(responseElement.getErrors().get(0).getErrorCode()).as(ERROR_CODE)
                .isEqualTo("GA-0101");

        softAssertions.assertThat(responseElement.getErrors().get(0).getDeveloperMessage()).as(DEVELOPERS_MESSAGE)
                .isEqualTo(errorMessage);

        softAssertions.assertThat(responseElement.getErrors().get(0).getUserMessage()).as(ERRORS_MESSAGE)
                .isEqualTo(errorMessage);
    }

    @Test
    public void testNegativeGaCreationInvalidPassword(){

        email= "testemail@email.com";
        errorMessage = "The request body did not pass input validation.";

        com.training.pojos.ga.creation.Request request = com.training.pojos.ga.creation.Request.builder()
                .email(email)
                .password("passwor")
                .build();

        response = new RestEngine().getResponse(map.get("gaCreateUrl"),headerMap,
                new Gson().toJson(request));

        com.training.pojos.ga.creation.Response responseElement =
                response.as(com.training.pojos.ga.creation.Response.class);


        Assertions.assertEquals(422,responseElement.getStatus(),ERROR_CODE);

        softAssertions.assertThat(responseElement.getErrors().get(0).getInternalMessage()).as(ERRORS_MESSAGE)
                .isEqualTo(errorMessage);

        softAssertions.assertThat(responseElement.getErrors().get(0).getErrorCode()).as(ERROR_CODE)
                .isEqualTo("GA-0103");

        softAssertions.assertThat(responseElement.getErrors().get(0).getDeveloperMessage()).as(ERRORS_MESSAGE)
                .isEqualTo(errorMessage);

        softAssertions.assertThat(responseElement.getErrors().get(0).getUserMessage()).as(ERRORS_MESSAGE)
                .isEqualTo("Your request is invalid.");

        softAssertions.assertThat(responseElement.getErrors().get(0).getValidationErrors().get(0).getError())
                .as("Error Message mismatch")
                .isEqualTo("The password must be between [8] and [32] characters, inclusive, " +
                                "with at least [1] letters and [1] numbers.");

        softAssertions.assertThat(responseElement.getErrors().get(0).getValidationErrors().get(0).getElement())
                .as("Incorrect element tested")
                .isEqualTo("password");
    }
}