package com.training.web.tests.flipkart;

import com.codeborne.selenide.WebDriverRunner;
import com.training.basetest.WebBaseTest;
import com.training.web.pages.flipkart.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Selenide.open;

public class SocialMediaTest extends WebBaseTest {
    HomePage flipkartHomePage;

    @BeforeEach
    public void setup() {
        open("https://www.flipkart.com/");
        flipkartHomePage = new HomePage().closePopup();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testSocialMediaPage.csv")
    public void testSocialMediaPage(String media,String expectedMediaUrl) {

        flipkartHomePage.clickSocialMediaPage(media);
        Assertions.assertEquals(WebDriverRunner.url(),expectedMediaUrl,
                String.format("Test did not navigate to %s page",media));
    }
}