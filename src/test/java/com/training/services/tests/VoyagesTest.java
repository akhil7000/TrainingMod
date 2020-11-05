package com.training.services.tests;

import com.training.base.BaseTest;
import com.training.services.voyage.Response;
import com.training.services.voyage.Voyages;
import com.training.utilities.RestEngine;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

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

        List<Voyages> voyages = voyageResponse.getPayload().getVoyages();

        IntStream.range(0, voyages.size()).forEach(index -> {
            int duration = Integer.parseInt(voyages.get(index).getDuration());

            softAssert.assertThat(duration).isLessThan(10).as(voyages.get(index).getDuration() +
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

        List<Voyages> voyages = voyageResponse.getPayload().getVoyages();

        IntStream.range(0, voyages.size()).forEach(index -> {
            softAssert.assertThat(voyages.get(index).getShipCode()).isEqualTo("AL");
        });
    }

    /**
     * testVoyageMasterSailDateValidate:comparing sailDate with both master1sailDate and master2SailDate.
     */
    @Test
    public void testVoyageMasterSailDateValidate() {
        Response voyageResponse = getResponse();

        List<Voyages> voyages = voyageResponse.getPayload().getVoyages();

        Assertions.assertThat(voyageResponse.getStatus()).isEqualTo("200")
                .as(" status is not 200");

        IntStream.range(0, voyages.size()).forEach(index -> {
            String sailDate = voyages.get(index).getSailDate();

            softAssert.assertThat(sailDate.equals(voyages.get(index).getMasterSailDate()
                    .getMaster1SailDate())).isTrue()
                    .as("sailDate and master1SailDate of voyages" + index + "are not equal");

            softAssert.assertThat(sailDate.equals(voyages.get(index).getMasterSailDate()
                    .getMaster2SailDate())).isTrue()
                    .as("sailDate and master2SailDate of voyages" + index + "are not equal");
        });
    }
}