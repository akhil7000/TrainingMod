package services.tests;

import com.training.base.BaseTest;
import com.training.services.ga.GAValidationResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

public class GuestAccountValidate extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testGuestAccountValidation() {
        RestAssured.baseURI = "https://aws-stg1.api.rccl.com/en/al/web/v3/guestAccounts";
        Response response = given()
                .header("AppKey", "qP2wzibM0y9rLeRc3jAZQEoBMGgtVGj7")
                .header("Content-Type", "application/json")
                .body("{\"email\": \"testPranav@api.com\"}").when().post("/validation")
                .then().extract().response();

        GAValidationResponse gaValidationResponse = response.as(GAValidationResponse.class);

        softAssert.assertThat(gaValidationResponse.getStatus())
                .as("Json response is not 200")
                .isEqualTo(200);

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
}