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

    @Test
    public void testVoyageCurrentSailDateValidate(){
        Response voyageResponse =
                new RestEngine().getResponseGet(map.get("url_base")+"/en/royal/mobile/v3/ships/al/voyages"
                        ,headerMap)
                        .as(Response.class);
        logger.info("status->"+voyageResponse.getStatus());
        logger.info("currentsailDate->"+voyageResponse.getPayload().getCurrentSailDate());
        logger.info("size of voyages"+voyageResponse.getPayload().getVoyages().size());
        Assertions.assertThat(voyageResponse.getStatus()).isEqualTo("200")
                .as(" status is not 200");
        for (int i = 0; i < voyageResponse.getPayload().getVoyages().size(); i++) {
            String Year2020 = voyageResponse.getPayload().getVoyages().get(i).getSailDate().substring(0,4);
            logger.info(Year2020+"***"+i);
            softAssert.assertThat(
                    Year2020.equals("2020"))
                    .as("sailDate " + i  +" "+ voyageResponse.getPayload().getCurrentSailDate() +" is not 2020").isTrue();
        }
    }
    @Test
    public void testVoyageDurationValidate() {
        Response voyageResponse =
                new RestEngine().getResponseGet(map.get("url_base")+"/en/royal/mobile/v3/ships/al/voyages"
                         ,headerMap)
                        .as(Response.class);
        logger.info("status->" + voyageResponse.getStatus());
        logger.info("duration->"+voyageResponse.getPayload().getVoyages().size());
        Assertions.assertThat(voyageResponse.getStatus()).isEqualTo("200")
                .as(" status is not 200");
        for (int i = 0; i < voyageResponse.getPayload().getVoyages().size(); i++) {
            int duration = Integer.parseInt(voyageResponse.getPayload().getVoyages().get(i).getDuration());
            System.out.println(duration +  " "+i);
            Assertions.assertThat(duration<10).as("sailDate " + i  +" "+ voyageResponse.getPayload().getVoyages().get(i).getDuration() +" is not less than 10").isTrue();
        }

    }
}