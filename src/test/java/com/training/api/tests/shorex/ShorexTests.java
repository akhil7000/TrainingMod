package com.training.api.tests.shorex;

import com.training.basetest.ApiBaseTest;
import com.training.pojos.shorex.validate.Products;
import com.training.utilities.RestEngine;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ShorexTests extends ApiBaseTest {

    @BeforeEach
    public void startup() {
        RestAssured.baseURI = map.get("rcclBaseUrl");
        headerMap.put(map.get("rcclAppKeyHeaderName"), map.get("rcclAppKeyHeaderValue"));
        headerMap.put(map.get("rcclContentTypeHeaderName"), map.get("rcclContentTypeHeaderValue"));
    }

    @Test
    public void testValidateNumberOfHits() {
        response = new RestEngine().getResponse(map.get("shorexUrl"), headerMap);

        com.training.pojos.shorex.validate.Response responseElement =
                response.as(com.training.pojos.shorex.validate.Response.class);

        Assertions.assertEquals(200, responseElement.getStatus(), "REQUEST UNSUCCESSFUL");

        softAssertions.assertThat(responseElement.getPayload().getSummary().getTotalHits())
                .as("Number of hits incorrect")
                .isEqualTo(Integer.parseInt(map.get("numberOfShorexHits")));
    }

    @Test
    public void testValidateProductType() {
        response = new RestEngine().getResponse(map.get("shorexUrl"), headerMap);
        com.training.pojos.shorex.validate.Response responseElement =
                response.as(com.training.pojos.shorex.validate.Response.class);

        Assertions.assertEquals(200, responseElement.getStatus(), "REQUEST UNSUCCESSFUL");

        for (int index = 0; index < responseElement.getPayload().getProducts().size(); index++) {
            softAssertions.assertThat(responseElement.getPayload().getProducts().get(index)
                    .getProductType().getProductType())
                    .as("Product Type incorrect")
                    .isEqualTo("SHOREX");
        }
    }

    @Test
    public void testValidateProductTypeName() {
        response = new RestEngine().getResponse(map.get("shorexUrl"), headerMap);
        com.training.pojos.shorex.validate.Response responseElement =
                response.as(com.training.pojos.shorex.validate.Response.class);

        Assertions.assertEquals(200, responseElement.getStatus(), "REQUEST UNSUCCESSFUL");

        for (int index = 0; index < responseElement.getPayload().getProducts().size(); index++) {
            softAssertions.assertThat(responseElement.getPayload().getProducts().get(index)
                    .getProductType().getProductTypeName())
                    .as("Product Type Name incorrect at index: "
                            + index
                            + responseElement.getPayload().getProducts().get(index)
                            .getProductID())
                    .isEqualTo("Shore Excursion");
        }
    }

    @Test
    public void testValidateOfferingDate() throws ParseException {

        String pattern = "yyyyMMdd";
        String offeringDate = "";
        Date searchDate = new SimpleDateFormat(pattern)
                .parse(map.get("shorexUrl").substring(map.get("shorexUrl").indexOf("?"))
                        .replaceAll("\\D+", ""));

        com.training.pojos.shorex.validate.Response responseElement =
                new RestEngine().getResponse(map.get("shorexUrl"), headerMap).as(com.training.pojos.shorex.validate.Response.class);

        Assertions.assertEquals(200, responseElement.getStatus(), "REQUEST UNSUCCESSFUL");

        List<Products> products = responseElement.getPayload().getProducts();

        for (Products product : products) {
            for (int offeringIndex = 0; offeringIndex < product.getOffering().size(); offeringIndex++) {
                offeringDate = product.getOffering().get(offeringIndex).getOfferingDate();

                softAssertions.assertThat(new SimpleDateFormat(pattern).parse(offeringDate))
                        .as("Sail date is before Search Date")
                        .isAfterOrEqualsTo(searchDate);
            }
        }
    }
}