package services.tests;

import com.training.base.BaseTest;
import com.training.services.ga.GAValidationResponse;
import com.training.utilities.RestEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class GuestAccountValidateTest extends BaseTest {

    Map<String, Object> headerMap = new HashMap();

    /**
     * Positive validation, putting all valid details and checking response
     */
    @Test
    public void testGuestAccountValidation() {
        headerMap.put(map.get("AppKeyHeader"), map.get("AppKeyValue"));
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));

        RestEngine restEngine = new RestEngine();

        GAValidationResponse gaValidationResponse =
                restEngine.getResponsePost(map.get("base_url") + "/validation"
                        , headerMap
                        , "{\"email\": \"testPranav@api.com\"}")
                        .as(GAValidationResponse.class);

        Assertions.assertEquals(gaValidationResponse.getStatus(), 200, "Json response is not 200");

        softAssert.assertThat(gaValidationResponse.getErrors().toString().length() == 0)
                .as("Errors array is not null");

        softAssert.assertThat(gaValidationResponse.getPayload().getAccountStatus())
                .as("Inside payload JSON, accountStatus is not equals to EXISTS")
                .isEqualTo("EXISTS");

        softAssert.assertThat(gaValidationResponse.getPayload().getIsUid())
                .as("Inside payload JSON, isUid should be true")
                .isEqualTo(true);
    }

    /**
     * Putting headers AppKey wrong and validating response
     */
    @Test
    public void testGuestAccountWrongAppKey() {
        headerMap.put(map.get("AppKeyHeader"), map.get("WrongAppKeyValue"));
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));

        RestEngine restEngine = new RestEngine();

        GAValidationResponse gaValidationNegativeResponse =
                restEngine.getResponsePost(map.get("base_url") + "/validation"
                        , headerMap
                        , "{\"email\": \"testPranav@api.com\"}")
                        .as(GAValidationResponse.class);

        Assertions.assertEquals(gaValidationNegativeResponse.getStatus(), 401
                , "Json response is not 401");

        softAssert.assertThat(gaValidationNegativeResponse.getError().getErrorCode())
                .as("Inside error JSON, error code is not equals to COMMONS-0001")
                .isEqualTo("COMMONS-0001");

        softAssert.assertThat(gaValidationNegativeResponse.getError().getMessage())
                .as("Inside error JSON, message is not equals to The API key " +
                        "header is required and the API key provided should be valid.")
                .isEqualTo("The API key header is required and the API key provided should be valid.");


        softAssert.assertThat(gaValidationNegativeResponse.getErrors().getInternalMessage())
                .as("Inside errors JSON, message is not equals to" +
                        "The API key header is required and should be valid.")
                .isEqualTo("The API key header is required and should be valid.");
    }

    /**
     * Putting invalid email id (assignment70test@api.com) , and checking if user exits or not
     */
    @Test
    public void testGuestAccountWrongEmail() {
        headerMap.put(map.get("AppKeyHeader"), map.get("AppKeyValue"));
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));

        RestEngine restEngine = new RestEngine();

        GAValidationResponse gaValidationResponse =
                restEngine.getResponsePost(map.get("base_url") + "/validation"
                        , headerMap
                        , "{\"email\": \"assignment70test@api.com\"}")
                        .as(GAValidationResponse.class);

        Assertions.assertEquals(gaValidationResponse.getStatus(), 200, "Json response is not 200");

        softAssert.assertThat(gaValidationResponse.getPayload().getAccountStatus())
                .as("Inside payload JSON, account status is not equals to DOES_NOT_EXIST")
                .isEqualTo("DOES_NOT_EXIST");

        softAssert.assertThat(gaValidationResponse.getPayload().getIsUid())
                .as("Inside payload JSON, is uid should be false")
                .isEqualTo(false);
    }

    /**
     * Putting wrong email in wrong format (testPranav@@api.com) and checking the response
     */
    @Test
    public void testGuestAccountInvalidEmail() {
        headerMap.put(map.get("AppKeyHeader"), map.get("AppKeyValue"));
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));

        RestEngine restEngine = new RestEngine();

        GAValidationResponse gaValidationNegativeResponse =
                restEngine.getResponsePost(map.get("base_url") + "/validation"
                        , headerMap
                        , "{\"email\": \"testPranav@@api.com\"}")
                        .as(GAValidationResponse.class);

        Assertions.assertEquals(gaValidationNegativeResponse.getStatus(), 422
                , "Json response is not 422");

        softAssert.assertThat(gaValidationNegativeResponse.getErrors().getDeveloperMessage())
                .as("Inside errors JSON, developer message is not equal to," +
                        " The request body did not pass input validation.")
                .isEqualTo("The request body did not pass input validation.");

        softAssert.assertThat(gaValidationNegativeResponse.getErrors().getErrorCode())
                .as("Inside error JSON, error code is not equals to GA-0103")
                .isEqualTo("GA-0103");
    }
}