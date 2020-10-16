package services.tests;

import com.training.base.BaseTest;
import com.training.services.ga.validate.Response;
import com.training.utilities.RestEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class GAAccountTest extends BaseTest {

    /**
     * Positive validation, putting all valid details and checking response
     */
    @Test
    public void testGuestAccountValidation() {
        Map<String, Object> headerMap = new HashMap();
        headerMap.put(map.get("AppKeyHeader"), map.get("AppKeyValue"));
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));

        Response gaValidationResponse = new RestEngine()
                        .getResponsePost(map.get("base_url") + "/validation"
                        , headerMap
                        , "{\"email\": \"testPranav@api.com\"}")
                        .as(Response.class);

        Assertions.assertEquals(gaValidationResponse.getStatus(), 200, "Json response is not 200");

        softAssert.assertThat(gaValidationResponse.getPayload().getAccountStatus())
                .as("Inside payload JSON, accountStatus is not equals to EXISTS")
                .isEqualTo("EXISTS");

        softAssert.assertThat(gaValidationResponse.getPayload().getIsUid())
                .as("Inside payload JSON, isUid should be true")
                .isEqualTo(true);
    }
}