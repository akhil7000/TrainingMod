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
public class VoyagesTest extends BaseTest {
    private Map<String, Object> headerMap;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @BeforeAll
    public void setData() {
        headerMap = new HashMap();
        headerMap.put(map.get("AppKeyHeader"), map.get("AppKeyValue"));
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));
    }

    public Response getResponse() {
        return new RestEngine().getResponseGet(map.get("url_base")
                        + "/en/royal/mobile/v3/ships/al/voyages"
                , headerMap)
                .as(Response.class);
    }

    /**
     * testVoyageCurrentSailDateValidate:validating currentSailDate is in year 2020
     */
    @Test
    public void testVoyageCurrentSailDateValidate() {
        Response voyageResponse = getResponse();
        logger.info("status->" + voyageResponse.getStatus());
        logger.info("currentsailDate->" + (voyageResponse.getPayload().getCurrentSailDate())
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
        Response voyageResponse = getResponse();

        Assertions.assertThat(voyageResponse.getStatus()).isEqualTo("200")
                .as(" status is not 200");

        voyageResponse.getPayload().getVoyages().forEach(voyage -> {
            int duration = Integer.parseInt(voyage.getDuration());

            softAssert.assertThat(duration).isLessThan(10).as(voyage.getDuration() +
                    "is not less than 10");
        });
    }

    /**
     * testVoyageShipCodeValidate:validating sail duration should br less than 10
     */
    @Test
    public void testVoyageShipCodeValidate() {
        Response voyageResponse = getResponse();

        Assertions.assertThat(voyageResponse.getStatus()).isEqualTo("200")
                .as(" status is not 200");

        voyageResponse.getPayload().getVoyages().forEach(voyage -> {
            softAssert.assertThat(voyage.getShipCode()).isEqualTo("AL");
        });
    }

    /**
     * testVoyageMasterSailDateValidate:comparing sailDate with both master1sailDate and master2SailDate.
     */
    @Test
    public void testVoyageMasterSailDateValidate() {
        Response voyageResponse = getResponse();

        Assertions.assertThat(voyageResponse.getStatus()).isEqualTo("200")
                .as(" status is not 200");

        voyageResponse.getPayload().getVoyages().forEach(voyage -> {
            String sailDate = voyage.getSailDate();

            softAssert.assertThat(sailDate.equals(voyage.getMasterSailDate()
                    .getMaster1SailDate())).isTrue()
                    .as("sailDate and master1SailDate of voyages" + voyage.getSailDate() + "are not equal");

            softAssert.assertThat(sailDate.equals(voyage.getMasterSailDate()
                    .getMaster2SailDate())).isTrue()
                    .as("sailDate and master2SailDate of voyages" + voyage.getSailDate() + "are not equal");
        });
    }
}