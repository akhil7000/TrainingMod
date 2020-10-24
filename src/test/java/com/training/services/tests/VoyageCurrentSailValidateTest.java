package com.training.services.tests;

import com.training.base.BaseTest;
import com.training.services.voyage.Response;
import com.training.utilities.RestEngine;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
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

    /**
     *  testVoyageCurrentSailDateValidate:validating currentSailDate is in year 2020
     */
    @Test
    public void testVoyageCurrentSailDateValidate(){
        Response voyageResponse =
                new RestEngine().getResponseGet(map.get("url_base")
                                +"/en/royal/mobile/v3/ships/al/voyages"
                        ,headerMap)
                        .as(Response.class);
        logger.info("status->"+voyageResponse.getStatus());
        logger.info("currentsailDate->"+(voyageResponse.getPayload().getCurrentSailDate())
                .matches("2020[0,1][0-2][0-3][0-9]"));
        Assertions.assertThat(voyageResponse.getStatus()).isEqualTo("200")
                .as(" status is not 200");
        softAssert.assertThat(voyageResponse.getPayload().getCurrentSailDate()
                .matches("2020[0,1][0-2][0-3][0-9]")).
                isTrue().as("is not in  the year 2020");
    }

    /**
     * testVoyageSailDurationValidate:validating sail duration should br less than 10
     */
    @Test
    public void testVoyageSailDurationValidate() {
        Response voyageResponse =
                new RestEngine().getResponseGet(map.get("url_base")
                                +"/en/royal/mobile/v3/ships/al/voyages"
                         ,headerMap)
                        .as(Response.class);
        logger.info("status->" + voyageResponse.getStatus());
        logger.info("totalVoyagesCount->"+voyageResponse.getPayload().getVoyages().size());
        Assertions.assertThat(voyageResponse.getStatus()).isEqualTo("200")
                .as(" status is not 200");
        for (int i = 0; i < voyageResponse.getPayload().getVoyages().size(); i++) {
            int duration = Integer.parseInt(voyageResponse.getPayload().getVoyages().get(i).getDuration());
            Assertions.assertThat(duration<10).as("sailDate " + i  +" "+
                    voyageResponse.getPayload().getVoyages().get(i).getDuration() +" is not less than 10")
                    .isTrue();
        }
    }
}