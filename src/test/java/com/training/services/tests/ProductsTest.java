package com.training.services.tests;

import com.training.base.BaseTest;
import com.training.services.products.Response;
import com.training.utilities.RestEngine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductsTest extends BaseTest {
    Map<String, Object> headerMap;
    Map<String, Object> queryParam;
    String baseURL;
    Response response;

    @BeforeEach
    public void setData() {
        baseURL = map.get("url_base") + "/en/royal/mobile/v3/products";

        headerMap = new HashMap();
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));
        headerMap.put(map.get("AppKeyHeader"), map.get("AppKeyValue"));

        queryParam = new HashMap();
        queryParam.put(map.get("shipIdParam"), map.get("sailingIdParamValue"));
        queryParam.put(map.get("categoryParam"), map.get("categoryParamValue"));
    }

    /**
     * Shorex test, checking the response, checking total hits is 52 or not.
     */
    @Test
    public void testShorexTotalHitsValidate() {
        response = new RestEngine().getResponseGet(baseURL, headerMap, queryParam)
                .as(Response.class);

        Assertions.assertThat(response.getStatus()).isEqualTo(200)
                .as("Json response status is not 200");

        softAssert.assertThat(response.getPayload().getSummary().getTotalHits())
                .isEqualTo("52")
                .as("Inside Summary, Total hit is not 52");
    }

    /**
     * Checking if total number of shorex is 52 or not.
     */
    @Test
    public void testShorexProductTypeValidate() {
        response = new RestEngine().getResponseGet(baseURL, headerMap, queryParam)
                .as(Response.class);

        int counter = 0;

        for (int i = 0; i < response.getPayload().getProducts().size(); i++) {
            if (response.getPayload().getProducts().get(i).getProductType().getProductType()
                    .equalsIgnoreCase("SHOREX")) {
                counter = counter + 1;
            }
        }

        Assertions.assertThat(response.getStatus()).isEqualTo(200)
                .as("Json response status is not 200");

        softAssert.assertThat(counter == 52)
                .as("Total number of SHOREX is not 52")
                .isTrue();
    }
}