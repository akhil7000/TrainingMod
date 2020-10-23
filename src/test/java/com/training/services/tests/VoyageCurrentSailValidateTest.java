package com.training.services.tests;

import com.training.base.BaseTest;
import com.training.services.voyage.Response;
import com.training.utilities.RestEngine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VoyageCurrentSailValidateTest extends BaseTest {
    Map<String, Object> headerMap;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeAll
    public  void setData() {
        headerMap = new HashMap();
        headerMap.put(map.get("AppKeyHeader"),map.get("AppKeyValue"));
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));
    }

    @Test
    public void testVoyageCurrentSailDateValidate(){
        Response voyageResponse =
                new RestEngine().getResponseGet(map.get("url_voyage"),headerMap)
                        .as(Response.class);
        logger.info("status->"+voyageResponse.getStatus());
        logger.info("currentsailDate->"+voyageResponse.getPayload().getCurrentSailDate().substring(0,4));

        Assertions.assertThat(voyageResponse.getStatus()).isEqualTo("200")
                .as(" status is not 200");
        softAssert.assertThat(voyageResponse.getPayload().getCurrentSailDate().substring(0,4)).
                isEqualTo("2020").as("is not in  the year 2020");
    }
}