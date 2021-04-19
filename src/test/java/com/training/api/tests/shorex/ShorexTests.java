package com.training.api.tests.shorex;

import com.training.basetest.ApiBaseTest;
import com.training.utilities.RestEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShorexTests extends ApiBaseTest {

    @BeforeEach
    public void startup(){
        headerMap.put(map.get("gaAppKeyHeaderName"),map.get("gaAppKeyHeaderValue"));
        headerMap.put(map.get("gaContentTypeHeaderName"),map.get("gaContentTypeHeaderValue"));
    }

    @Test
    public void testValidateNumberOfHits(){
        response = new RestEngine().getResponse(map.get("shorexUrl"),headerMap);

        com.training.pojos.shorex.validate.Response responseElement =
                response.as( com.training.pojos.shorex.validate.Response.class);

        Assertions.assertEquals(200,responseElement.getStatus(),"REQUEST UNSUCCESSFUL");

        softAssertions.assertThat(responseElement.getPayload().getSummary().getTotalHits())
                .as("Number of hits incorrect")
                .isEqualTo(157);
    }
}