package services.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GuestAccountValidate {

    @Test
    public void testGuestAccountValidation(){
        RestAssured.baseURI = "https://aws-stg1.api.rccl.com/en/al/web/v3/guestAccounts";
                 given()
                .header("AppKey","qP2wzibM0y9rLeRc3jAZQEoBMGgtVGj7")
                .header("Content-Type","application/json")
                .body("{\"email\": \"email@email.com\"}").when().post("/validation").then()
                .log().all().assertThat().statusCode(200);
    }
}