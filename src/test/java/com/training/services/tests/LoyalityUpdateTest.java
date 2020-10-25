package com.training.services.tests;

import com.google.gson.Gson;
import com.training.base.BaseTest;
import com.training.services.ga.authenticate.RequestBody;
import com.training.services.ga.authenticate.Response;
import com.training.utilities.RestEngine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.HashMap;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoyalityUpdateTest extends BaseTest {
    private Map<String, String> headerMap;
    private RequestBody requestBodyAuthenticate;
    private Response authenticationResponse;
    private String loyaltyId;
    private com.training.services.ga.loyalty.RequestBody requestBody;
    private String globalUrl;

    @BeforeEach
    public void setData() {
        loyaltyId = "137529822";
        globalUrl = map.get("url_base")+"/v1/guestAccounts/loyalty";
        headerMap = new HashMap();
        headerMap.put(map.get("AppKeyHeader"), map.get("AppKeyValue"));
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));

        /**
         * Getting access token and account ID
         */
        requestBodyAuthenticate = new RequestBody();
        requestBodyAuthenticate.setUid("testShrikant@api.com");
        requestBodyAuthenticate.setPassword("Password1");
        authenticationResponse =
                new RestEngine().getResponsePost(map.get("URI") + "/authentication/login"
                        , headerMap
                        , new Gson().toJson(requestBodyAuthenticate))
                        .as(Response.class);

        /**
         * putting access token and account ID, and getting response
         */
        headerMap.put(map.get("accessToken"), authenticationResponse.getPayload().getAccessToken());

        requestBody = new com.training.services.ga.loyalty.RequestBody();
        requestBody.setBrand("R");
        requestBody.setChannel("web");
        requestBody.setVdsId(authenticationResponse.getPayload().getAccountId());
        requestBody.setLastName("Poole");
        requestBody.setLoyaltyId(loyaltyId);
        requestBody.setBirthdate("19620802");
    }

    /**
     * Loyality test, checking the response, loyalty tier value is Diamond and relationship points is 83
     */
    @Test
    public void testLoyality() {
        com.training.services.ga.loyalty.Response loyaltyResponse
                = new RestEngine().getResponsePut(globalUrl,
                headerMap, new Gson().toJson(requestBody)).as(com.training.services.ga.loyalty.Response.class);

        Assertions.assertThat(loyaltyResponse.getStatus()).isEqualTo(200)
                .as("Json response is not 200");

        softAssert.assertThat(loyaltyResponse.getPayload().getLoyaltyId()).isEqualTo(loyaltyId)
                .as("Loyalty id is not matching");

        softAssert.assertThat(loyaltyResponse.getPayload().getLoyaltyTier()).isEqualTo("Diamond")
                .as("Guest loyalty tier is not diamond");

        softAssert.assertThat(loyaltyResponse.getPayload().getRelationshipPoints()).isEqualTo("83")
                .as("Relationship points is not equal to 83");
    }

    /**
     * Putting wrong app key, In loyality API, and checking if we are getting correct response from sever
     */
    @Test
    public void testLoyalityGANegativeWrongAppKey() {
        headerMap.put(map.get("AppKeyHeader"), map.get("AppKeyWrongValue"));

        com.training.services.ga.loyalty.Response loyaltyNegativeResponse
                = new RestEngine().getResponsePut(globalUrl,
                headerMap, new Gson().toJson(requestBody))
                .as(com.training.services.ga.loyalty.Response.class);

        Assertions.assertThat(loyaltyNegativeResponse.getStatus()).isEqualTo(401)
                .as("Json response status is not 401");

        softAssert.assertThat(loyaltyNegativeResponse.getError().getErrorCode()).isEqualTo("COMMONS-0001")
                .as("Json response error, errorcode is not COMMONS-0001");

        softAssert.assertThat(loyaltyNegativeResponse.getErrors().get(0).getInternalMessage())
                .isEqualTo("The API key header is required and should be valid.")
                .as("The internal message is not equal to, The API key header is required and should be valid.");
    }

    /**
     * Putting wrong vds id, In loyality API, and checking if we are getting correct response from sever
     */
    @Test
    public void testLoyalityGANegativeWrongVdsId() {
        requestBody.setVdsId(map.get("AppKeyWrongValue"));

        com.training.services.ga.loyalty.Response loyaltyNegativeResponse
                = new RestEngine().getResponsePut(globalUrl,
                headerMap, new Gson().toJson(requestBody))
                .as(com.training.services.ga.loyalty.Response.class);

        Assertions.assertThat(loyaltyNegativeResponse.getStatus()).isEqualTo(401)
                .as("Json response status is not 401");

        softAssert.assertThat(loyaltyNegativeResponse.getErrors().get(0).getInternalMessage())
                .isEqualTo("The access token or account ID specified in the request appears to be invalid or expired.")
                .as("The internal message is not equal to, The access token or account ID specified in the request appears to be invalid or expired.");

        softAssert.assertThat(loyaltyNegativeResponse.getErrors().get(0).getUserMessage())
                .isEqualTo("The user session appears to be invalid or has expired.")
                .as("The internal message is not equal to, The user session appears to be invalid or has expired.");
    }

    /**
     * Putting wrong access key, In loyality API, and checking if we are getting correct response from sever
     */
    @Test
    public void testLoyalityGANegativeWrongAccessKey() {
        headerMap.put(map.get("accessToken"), map.get("AppKeyWrongValue"));

        com.training.services.ga.loyalty.Response loyaltyNegativeResponse
                = new RestEngine().getResponsePut(globalUrl,
                headerMap, new Gson().toJson(requestBody))
                .as(com.training.services.ga.loyalty.Response.class);

        Assertions.assertThat(loyaltyNegativeResponse.getStatus()).isEqualTo(401)
                .as("Json response status is not 401");

        softAssert.assertThat(loyaltyNegativeResponse.getErrors().get(0).getInternalMessage())
                .isEqualTo("The access token or account ID specified in the request appears to be invalid or expired.")
                .as("The internal message is not equal to, The access token or account ID specified in the request appears to be invalid or expired.");

        softAssert.assertThat(loyaltyNegativeResponse.getErrors().get(0).getUserMessage())
                .isEqualTo("The user session appears to be invalid or has expired.")
                .as("The internal message is not equal to, The user session appears to be invalid or has expired.");
    }

    /**
     * Putting loyalty id, In loyality API (13752982299), and checking if we are getting correct response from sever
     */
    @Test
    public void testLoyalityGANegativeWrongLoyaltyId() {
        requestBody.setLoyaltyId("13752982299");

        com.training.services.ga.loyalty.Response loyaltyNegativeResponse
                = new RestEngine().getResponsePut(globalUrl,
                headerMap, new Gson().toJson(requestBody))
                .as(com.training.services.ga.loyalty.Response.class);

        Assertions.assertThat(loyaltyNegativeResponse.getStatus()).isEqualTo(404)
                .as("Json response status is not 404");

        softAssert.assertThat(loyaltyNegativeResponse.getErrors().get(0).getUserMessage())
                .isEqualTo("User with details provided was not found.")
                .as("The internal message is not equal to, User with details provided was not found.");

        softAssert.assertThat(loyaltyNegativeResponse.getErrors().get(0).getErrorCode())
                .isEqualTo("GA-1004")
                .as("Inside errors, error code is not equal to, GA-1004.");
    }
}