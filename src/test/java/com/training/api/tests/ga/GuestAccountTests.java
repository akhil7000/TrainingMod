package com.training.api.tests.ga;

import com.google.gson.Gson;
import com.training.pojos.ga.validation.Request;
import com.training.utilities.JsonReaderUtility;
import com.training.utilities.RestEngine;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

public class GuestAccountTests {
    protected Map<String, String> map = new JsonReaderUtility().getMap();
    private Map<String, Object> headerMap;
    private static final String REQUEST_UNSUCCESSFUL = "Request Unsuccessful";
    private io.restassured.response.Response response;

    @BeforeEach
    public void setup(){
        RestAssured.baseURI = map.get("gaBaseUrl");
        headerMap = new HashMap();
        headerMap.put("AppKey","qP2wzibM0y9rLeRc3jAZQEoBMGgtVGj7");
        headerMap.put("Content-Type","application/json");
    }

    @Test
    public void test(){

        com.training.pojos.ga.validation.Request request = new Request();
        request.setPassword("password1");
        request.setUid("email@email.com");

        response = new RestEngine().getResponse("/royal/web/v3/guestAccounts/authentication/login",headerMap,
                new Gson().toJson(request));

        com.training.pojos.ga.validation.Response responseElement = response.as(com.training.pojos.ga.validation.Response.class);

        Assertions.assertEquals(200,responseElement.getStatus(),REQUEST_UNSUCCESSFUL);
        Assertions.assertTrue(responseElement.getErrors().size()==0,"Error present in response");
        Assertions.assertTrue(responseElement.getPayload().getAccessToken().length()>0,"Access Token Empty");
        Assertions.assertEquals("email@email.com",responseElement.getPayload().getUid(), "Uid not same as body");
    }
}
