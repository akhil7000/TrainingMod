package com.training.services.tests;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.training.base.BaseTest;
import com.training.services.ga.authenticate.RequestBody;
import com.training.services.ga.authenticate.Response;
import com.training.services.ga.validate.Header;
import com.training.utilities.RestEngine;
import org.assertj.core.api.Assertions;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoyalityUpdateTest extends BaseTest {
    Map<String, Object> headerMap;
    RequestBody requestBodyAuthenticate;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeAll
    public  void setData() {
        headerMap = new HashMap();
        headerMap.put(map.get("AppKeyHeader"),map.get("AppKeyValue"));
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));
    }


    @Test
    public void  testLoyalityIssue() {
        /**
         * Shri code, to get access token and account ID
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
         * My code
         */
        headerMap.put(map.get("accessToken"), authenticationResponse.getPayload().getAccessToken());

        com.training.services.ga.validate.RequestBody requestBody = new com.training.services.ga.validate.RequestBody();

        Header header = new Header();
        header.setBrand("R");
        header.setChannel("web");
        
        requestBody.setHeader(header);
        requestBody.setVdsId(authenticationResponse.getPayload().getAccountId());
        requestBody.setLastName("Poole");
        requestBody.setLoyaltyId("137529822");
        requestBody.setBirthdate("19620802");

        com.training.services.ga.validate.Response authenticationResponse2 =
                new RestEngine().getResponsePutLoyality(map.get("url_loyality")
                        , headerMap
                        , new Gson().toJson(requestBody))
                        .as(com.training.services.ga.validate.Response.class);

        Assertions.assertThat(authenticationResponse2.getStatus()==200);

        softAssert.assertThat(authenticationResponse2.getPayload().getLoyaltyTier()).isEqualTo("Diamond")
               .as("Guest loyalty tier is not diamond");

        softAssert.assertThat(authenticationResponse2.getPayload().getRelationshipPoints()).isEqualTo("83")
        .as("Relationship points is not equal to 83");
    }
}