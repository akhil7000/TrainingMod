package com.training.web.tests.rccl;

import com.codeborne.selenide.Selenide;
import com.google.gson.Gson;
import com.training.base.BaseTest;
import com.training.services.ga.authenticate.RequestBody;
import com.training.services.ga.authenticate.Response;
import com.training.utilities.RestEngine;
import com.training.web.pages.rccl.SigInPage;
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
    private com.training.services.ga.loyalty.RequestBody requestBody;
    private String userPassword = "M212adasdasjdklj!";
    private String userEmail = getUniqueMailId();
    private String dateOfYear = "1962";
    private String answer = "NewYork";

    @Test
    public void testUserLoyality(){
       Selenide.open(map.get("rccl_url") + "/account/");

        /**
         * Creating User account through UI.
         */
        UserAccountPage userAccountPage = new SigInPage().clickLink().isPrivacyPolicyVisible()
                .setFirstName("Audrey").setLastName("Poole").clickDateOfMonthDropDown()
                .setDateOfBirthMonth().clickDateOfDayDropDown().setDateOfBirthDay()
                .setDateOfYear(dateOfYear).clickCountryDropDown().selectCountry()
                .setEmail(userEmail).setPassword(userPassword).clickQuestionDropDown()
                .setQuestion().setAnswer(answer).clickCheckBox().clickDoneButton();

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
         * Giving loyality, putting access token and account ID, and getting response
         */
        headerMap.put(map.get("accessToken"), authenticationResponse.getPayload().getAccessToken());

        requestBody = new com.training.services.ga.loyalty.RequestBody();
        requestBody.setBrand("R");
        requestBody.setChannel("web");
        requestBody.setVdsId(authenticationResponse.getPayload().getAccountId());
        requestBody.setLastName("Poole");
        requestBody.setLoyaltyId("137529822");
        requestBody.setBirthdate("19620802");

        com.training.services.ga.loyalty.Response loyaltyResponse
                = new RestEngine().getResponsePut(map.get("url_base") + "/v1/guestAccounts/loyalty",
                headerMap, new Gson().toJson(requestBody)).as(com.training.services.ga.loyalty.Response.class);

        Assertions.assertThat(loyaltyResponse.getStatus()).isEqualTo(200)
                .as("Json response is not 200");

        /**
         * Now comparing the API response and UI data
         */
        String getLoyalityIdFromUI = userAccountPage.isUserPageLastElementDisplyed()
                .refreshPage()
                .isUserPageLastElementDisplyed()
                .getLoyalityIdFromUI();

        String getLoyalityTierFromUI = userAccountPage.getLoyalityTierFromUI();
        String getRelationshipPointsFromUI = userAccountPage.getRelationshipPointsFromUI();

        softAssert.assertThat(loyaltyResponse.getPayload().getLoyaltyId()).isEqualTo(getLoyalityIdFromUI)
                .as("Loyalty id is not matching with API response and UI");

        softAssert.assertThat(loyaltyResponse.getPayload().getLoyaltyTier()).isEqualTo(getLoyalityTierFromUI)
                .as("Guest loyalty tier is not matching with API response and UI");

        softAssert.assertThat(loyaltyResponse.getPayload().getIndividualPoints()).isEqualTo(getRelationshipPointsFromUI)
                .as("Individual points is not matching with API response and UI");
    }
}