package com.training.api.tests.shorex;

import com.training.basetest.ApiBaseTest;
import com.training.utilities.RestEngine;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShorexTests extends ApiBaseTest {

    @BeforeEach
    public void startup(){
        RestAssured.baseURI= map.get("rcclBaseUrl");
        headerMap.put(map.get("rcclAppKeyHeaderName"),map.get("rcclAppKeyHeaderValue"));
        headerMap.put(map.get("rcclContentTypeHeaderName"),map.get("rcclContentTypeHeaderValue"));
    }

    @Test
    public void testValidateNumberOfHits(){
        response = new RestEngine().getResponse(map.get("shorexUrl"),headerMap);

        com.training.pojos.shorex.validate.Response responseElement =
                response.as( com.training.pojos.shorex.validate.Response.class);

        Assertions.assertEquals(200,responseElement.getStatus(),"REQUEST UNSUCCESSFUL");

        softAssertions.assertThat(responseElement.getPayload().getSummary().getTotalHits())
                .as("Number of hits incorrect")
                .isEqualTo(Integer.parseInt(map.get("numberOfShorexHits")));
    }
}