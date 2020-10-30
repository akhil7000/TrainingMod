package com.training.web.tests.rccl;

import com.codeborne.selenide.Selenide;
import com.google.gson.Gson;
import com.training.base.BaseTest;
import com.training.services.ga.authenticate.RequestBody;
import com.training.services.ga.authenticate.Response;
import com.training.utilities.RestEngine;
import com.training.web.pages.rccl.SignInPage;
import com.training.web.pages.rccl.UserAccountPage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.training.utilities.UniqueMailId.getUniqueMailId;

public class RCCLTest extends BaseTest {
    private Map<String, String> headerMap;
    private RequestBody requestBodyAuthenticate;
    private Response authenticationResponse;
    private com.training.services.ga.loyalty.RequestBody requestBodyLoyalty;
    private String userPassword = "M212adasdasjdklj!";
    private String userEmail = getUniqueMailId();
    private String dateOfBirth = "19620802";
    private String lastName = "Poole";

    /**
     * Creating user from UI, and giving loyalty credit from API, and checking in UI if
     * user gets the loyalty credit
     */
    @Test
    public void testUserLoyality() {
        Selenide.open(map.get("rccl_url"));

        /**
         * Creating User account through UI.
         */
        UserAccountPage userAccountPage = new SignInPage()
                .clickCreateAccountLink()
                .setFirstName("Audrey").setLastName(lastName)
                .setDateofBirth(dateOfBirth).selectCountry()
                .setEmail(userEmail).setPassword(userPassword)
                .setQuestion().setAnswer("NewYork").clickCheckBox()
                .clickDoneButton();

        /**
         * Now we are checking if the user we created from UI is present in Database or not, through api and,
         * Getting access token and account ID, through api
         */
        headerMap = new HashMap();
        headerMap.put(map.get("AppKeyHeader"), map.get("AppKeyValue"));
        headerMap.put(map.get("ContentTypeHeader"), map.get("ContentTypeValue"));

        requestBodyAuthenticate = new RequestBody();
        requestBodyAuthenticate.setUid(userEmail);
        requestBodyAuthenticate.setPassword(userPassword);
        authenticationResponse =
                new RestEngine().getResponsePost(map.get("URI") + "/authentication/login"
                        , headerMap
                        , new Gson().toJson(requestBodyAuthenticate))
                        .as(Response.class);

        /**
         * Giving loyalty, putting access token and account ID, and getting response
         */
        headerMap.put(map.get("accessToken"), authenticationResponse.getPayload().getAccessToken());

        requestBodyLoyalty = new com.training.services.ga.loyalty.RequestBody();
        requestBodyLoyalty.setBrand("R");
        requestBodyLoyalty.setChannel("web");
        requestBodyLoyalty.setVdsId(authenticationResponse.getPayload().getAccountId());
        requestBodyLoyalty.setLastName(lastName);
        requestBodyLoyalty.setLoyaltyId("137529822");
        requestBodyLoyalty.setBirthdate(dateOfBirth);

        com.training.services.ga.loyalty.Response loyaltyResponse
                = new RestEngine().getResponsePut(map.get("url_base") + "/v1/guestAccounts/loyalty",
                headerMap, new Gson().toJson(requestBodyLoyalty)).as(com.training.services.ga.loyalty.Response.class);

        Assertions.assertThat(loyaltyResponse.getStatus()).isEqualTo(200)
                .as("Json response is not 200");

        /**
         * Now comparing the API response and UI data
         */
        refreshPage();

        softAssert.assertThat(loyaltyResponse.getPayload().getLoyaltyId())
                .isEqualTo(userAccountPage.getLoyaltyId())
                .as("Loyalty id is not matching with API response and UI");

        softAssert.assertThat(loyaltyResponse.getPayload().getLoyaltyTier())
                .isEqualTo(userAccountPage.getLoyaltyTier())
                .as("Guest loyalty tier is not matching with API response and UI");

        softAssert.assertThat(loyaltyResponse.getPayload().getIndividualPoints())
                .isEqualTo(userAccountPage.getRelationshipPoints())
                .as("Individual points is not matching with API response and UI");
    }
}