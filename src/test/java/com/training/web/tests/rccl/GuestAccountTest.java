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

import static com.codeborne.selenide.Selenide.open;

public class GuestAccountTest extends WebBaseTest {
    private LoginPage loginPage;
    private HomePage homePage;
    private static final String REQUEST_UNSUCCESSFUL = "Request Unsuccessful";
    private static final String ERROR_MESSAGE = "Error message is not correct";

    @BeforeEach
    public void startup() {
        RestAssured.baseURI = map.get("rcclBaseUrl");
        headerMap.put(map.get("rcclAppKeyHeaderName"), map.get("rcclAppKeyHeaderValue"));
        headerMap.put(map.get("rcclContentTypeHeaderName"), map.get("rcclContentTypeHeaderValue"));
    }

    @Test
    public void testCreateGuestAccountAndValidatePageElements() throws NullPointerException, IllegalArgumentException {
        String firstName = "Audrey";
        String password = "password1";
        String incorrectPassword = "password";

        String email = String.format("%s%s@email.com",
                RandomStringUtils.randomAlphabetic(5),
                System.currentTimeMillis());

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

        open(map.get("guestAccountUrl"));

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
}