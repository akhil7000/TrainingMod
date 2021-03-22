package com.training.web.tests.flipkart;

import com.codeborne.selenide.WebDriverRunner;
import com.training.basetest.WebBaseTest;
import com.training.web.pages.flipkart.FlipkartHomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Selenide.open;

public class SocialMediaTest extends WebBaseTest {
    FlipkartHomePage flipkartHomePage;

    @BeforeEach
    public void setup() {
        open("https://www.flipkart.com/");
        flipkartHomePage = new FlipkartHomePage().closePopup();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testSocialMediaPage.csv")
    public void testSocialMediaPage(String media,String expectedMediaUrl) {

        flipkartHomePage.clickSocialMediaPage(media);
        String mediaURL =WebDriverRunner.url();
        Assertions.assertEquals(mediaURL,expectedMediaUrl,String.format("Test did not navigate to %s page",media));
    }
}