package com.training.services.tests;

import com.google.gson.Gson;
import com.training.base.BaseTest;
import com.training.services.ga.authenticate.RequestBody;
import com.training.services.ga.authenticate.Response;
import com.training.utilities.RestEngine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.HashMap;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoyalityUpdateTest extends BaseTest {
    Map<String, String> headerMap;
    RequestBody requestBodyAuthenticate;

    @BeforeAll
    public void setData() {
        headerMap = new HashMap();
        headerMap.put(map.get("AppKeyHeader"), map.get("AppKeyValue"));
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));
    }

    /**
     * Loyality test, checking the response, loyalty tier value is Diamond and relationship points is 83
     */
    @Test
    public void testLoyality() {
        /**
         * Getting access token and account ID
         */
        requestBodyAuthenticate = new RequestBody();
        requestBodyAuthenticate.setUid("testShrikant@api.com");
        requestBodyAuthenticate.setPassword("Password1");
        Response authenticationResponse =
                new RestEngine().getResponsePost(map.get("URI") + "/authentication/login"
                        , headerMap
                        , new Gson().toJson(requestBodyAuthenticate))
                        .as(Response.class);

        /**
         * puttting access token and account ID, and getting response
         */

        String loyaltyId = "137529822";
        headerMap.put(map.get("accessToken"), authenticationResponse.getPayload().getAccessToken());

        com.training.services.ga.loyalty.RequestBody requestBody = new com.training.services.ga.loyalty.RequestBody();

        requestBody.setBrand("R");
        requestBody.setChannel("web");
        requestBody.setVdsId(authenticationResponse.getPayload().getAccountId());
        requestBody.setLastName("Poole");
        requestBody.setLoyaltyId(loyaltyId);
        requestBody.setBirthdate("19620802");

        com.training.services.ga.loyalty.Response loyaltyResponse
                = new RestEngine().getResponsePut(map.get("url_base") + "/v1/guestAccounts/loyalty",
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
}