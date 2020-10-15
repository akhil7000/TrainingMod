package services.tests;

import com.training.base.BaseTest;
import com.training.services.ga.GAValidationResponse;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GuestAccountValidateTest extends BaseTest {
    @Test
    public void testGuestAccountValidation() {
        RestAssured.baseURI = map.get("base_url");

        GAValidationResponse gaValidationResponse =
                         given()
                        .header(map.get("AppKeyHeader"), map.get("AppKeyValue"))
                        .header(map.get("ContentTypeHeader"), map.get("ContentTypeValue"))
                        .body("{\"email\": \"testPranav@api.com\"}")
                        .when()
                        .post("/validation")
                        .then()
                        .extract()
                        .response()
                        .as(GAValidationResponse.class);

        Assertions.assertEquals(gaValidationResponse.getStatus(), 200, "Json response is not 200");

        softAssert.assertThat(gaValidationResponse.getError())
                .as("Errors array is not null")
                .isEqualTo(null);

        softAssert.assertThat(gaValidationResponse.getPayload().getAccountStatus())
                .as("Inside payload JSON, accountStatus is not equals to EXISTS")
                .isEqualTo("EXISTS");

        softAssert.assertThat(gaValidationResponse.getPayload().getIsUid())
                .as("Inside payload JSON, isUid should be true")
                .isEqualTo(true);
    }

    @Test
    public void testGuestAccountWrongAppKey() {
        RestAssured.baseURI = map.get("base_url");

        GAValidationResponseNegative gaValidationNegativeResponse =
                         given()
                        .header(map.get("AppKeyHeader"), map.get("WrongAppKeyValue"))
                        .header(map.get("ContentTypeHeader"), map.get("ContentTypeValue"))
                        .body("{\"email\": \"testPranav@api.com\"}")
                        .when()
                        .post("/validation")
                        .then()
                        .extract()
                        .response()
                        .as(GAValidationResponseNegative.class);

        Assertions.assertEquals(gaValidationNegativeResponse.getStatus(), 401
                , "Json response is not 401");

        softAssert.assertThat(gaValidationNegativeResponse.getError().getErrorCode())
                .as("Inside error JSON, error code is not equals to COMMONS-0001")
                .isEqualTo("COMMONS-0001");

        softAssert.assertThat(gaValidationNegativeResponse.getError().getMessage())
                .as("Inside error JSON, message is not equals to The API key " +
                        "header is required and the API key provided should be valid.")
                .isEqualTo("The API key header is required and the API key provided should be valid.");
    }

    @Test
    public void testGuestAccountWrongEmail() {
        RestAssured.baseURI = map.get("base_url");

        GAValidationResponse gaValidationResponse =
                given()
                .header(map.get("AppKeyHeader"), map.get("AppKeyValue"))
                .header(map.get("ContentTypeHeader"), map.get("ContentTypeValue"))
                .body("{\"email\": \"assignment70test@api.com\"}")
                .when()
                .post("/validation")
                .then()
                .extract()
                .response()
                .as(GAValidationResponse.class);

        Assertions.assertEquals(gaValidationResponse.getStatus(), 200, "Json response is not 200");

        softAssert.assertThat(gaValidationResponse.getPayload().getAccountStatus())
                .as("Inside payload JSON, account status is not equals to DOES_NOT_EXIST")
                .isEqualTo("DOES_NOT_EXIST");

        softAssert.assertThat(gaValidationResponse.getPayload().getIsUid())
                .as("Inside payload JSON, is uid should be false")
                .isEqualTo(false);
    }

    @Test
    public void testGuestAccountInvalidEmail() {
        RestAssured.baseURI = map.get("base_url");

        GAValidationResponseNegative gaValidationNegativeResponse =
                         given()
                        .header(map.get("AppKeyHeader"), map.get("AppKeyValue"))
                        .header(map.get("ContentTypeHeader"), map.get("ContentTypeValue"))
                        .body("{\"email\": \"testPranav@@api.com\"}")
                        .when()
                        .post("/validation")
                        .then()
                        .extract()
                        .response()
                        .as(GAValidationResponseNegative.class);

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