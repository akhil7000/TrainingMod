package com.training.web.tests.rccl;

import com.google.gson.Gson;
import com.training.basetest.WebBaseTest;
import com.training.utilities.RestEngine;
import com.training.web.pages.rccl.HomePage;
import com.training.web.pages.rccl.LoginPage;
import io.restassured.RestAssured;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class GuestAccountTest extends WebBaseTest {


    private LoginPage loginPage;
    private HomePage homePage;
    private static final String REQUEST_UNSUCCESSFUL = "Request Unsuccessful";
    private static final String ERROR_MESSAGE = "Error message is not correct";
    private static final String EMAIL_AUTHENTICATION_URL = "/en/royal/web/v3/guestAccounts/authentication/login";
    private String firstName = "Audrey";
    private String password = "password1";
    private String incorrectPassword = "password";
    private String email = String.format("%s%s@email.com", RandomStringUtils.randomAlphabetic(5), System.currentTimeMillis());
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @BeforeEach
    public void startup() {
        RestAssured.baseURI = map.get("rcclBaseUrl");
        headerMap.put(map.get("rcclAppKeyHeaderName"), map.get("rcclAppKeyHeaderValue"));
        headerMap.put(map.get("rcclContentTypeHeaderName"), map.get("rcclContentTypeHeaderValue"));
        open(map.get("guestAccountUrl"));
    }

    @Test
    public void testCreateGuestAccountAndValidatePageElements() throws NullPointerException, IllegalArgumentException {

        com.training.pojos.ga.creation.Request request = com.training.pojos.ga.creation.Request.builder()
                .firstName(firstName)
                .email(email)
                .password(password)
                .build();

        response = new RestEngine().getResponse(map.get("rcclCreateUrl"), headerMap,
                new Gson().toJson(request));

        com.training.pojos.ga.creation.Response responseElement =
                response.as(com.training.pojos.ga.creation.Response.class);

        Assertions.assertEquals(200, responseElement.getStatus(), REQUEST_UNSUCCESSFUL);

        loginPage = new LoginPage().enterEmail(email);

        for (int iteration = 1; iteration <= 9; iteration++) {
            homePage = loginPage.enterPassword(incorrectPassword).clickSignIn();
            switch (iteration) {

                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    softAssertions.assertThat(loginPage.getErrorText())
                            .as(ERROR_MESSAGE)
                            .isEqualTo(String.format("The email or password is not correct. " +
                                            "You have %s tries remaining before you'll need to reset your password.",
                                    10 - iteration));
                    break;
                case 8:
                    softAssertions.assertThat(loginPage.getErrorText())
                            .as(ERROR_MESSAGE)
                            .isEqualTo("Two tries remain before you'll need to reset your password.");
                    break;
                case 9:
                    softAssertions.assertThat(loginPage.getErrorText())
                            .as(ERROR_MESSAGE)
                            .isEqualTo("This is your final try before you must reset your password.");
                    break;
            }
        }

        homePage = loginPage.enterPassword(password).clickSignIn();

        softAssertions.assertThat(homePage.getUserName()).as("User name is not correct")
                .isEqualTo(firstName);

        softAssertions.assertThat(homePage.isUpcomingCruisesVisible()).as("Upcoming cruises tab not visible")
                .isTrue();

        softAssertions.assertThat(homePage.isPastCruisesVisible()).as("Past cruises tab not visible")
                .isTrue();

        softAssertions.assertThat(homePage.isAddCruiseVisible()).as("Add cruises button not visible")
                .isTrue();

        softAssertions.assertThat(homePage.isPlanNewCruiseVisible()).as("Plan new cruises button not visible")
                .isTrue();
    }

    @Test
    public void testAccountCreationGuiLoyaltyAddition() throws ParseException {

        String countryName="United States";
        String securityAnswer ="Abcdefg";
        String securityQuestion = "What elementary school did you go to?";

        homePage = new LoginPage().createAccount()
                .enterName(firstName, "Poole")
                .enterDateOfBirth("August","2","1962")
                .selectCountry(countryName)
                .enterSecurityQuestion(securityQuestion,securityAnswer)
                .enterIdAndPassword(email, password)
                .acceptTerms()
                .clickDone();

        com.training.pojos.ga.authentication.Response responseElement =
                new RestEngine().
                        getResponse(EMAIL_AUTHENTICATION_URL, headerMap,
                                new Gson().toJson(new com.training.pojos.ga.authentication.Request(email, password)))
                        .as(com.training.pojos.ga.authentication.Response.class);

        headerMap.put(map.get("rcclAccessTokenHeaderName"), responseElement.getPayload().getAccessToken());

        response = new RestEngine().getPutResponse("/v1/guestAccounts/loyalty", headerMap,
                new Gson().toJson(com.training.pojos.ga.loyalty_update.Request.builder()
                        .vdsId(responseElement.getPayload().getAccountId())
                        .build()));

        Assertions.assertEquals("200",
                response.as(com.training.pojos.ga.loyalty_update.Response.class).getStatus(),
                "Request unsuccessful");

        getWebDriver().navigate().refresh();

        Assertions.assertEquals(homePage.getLoyaltyId(),map.get("rcclLoyaltyId") , "Loyalty id is different");
    }
}