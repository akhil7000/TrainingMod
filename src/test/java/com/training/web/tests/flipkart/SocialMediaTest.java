package com.training.web.tests.flipkart;

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
    public void testSocialMediaPage(String media) throws InterruptedException {

        String mediaURL = flipkartHomePage.clickSocialMediaPage(media);
        switch (media) {
            case "Facebook":
                Assertions.assertEquals(mediaURL, "https://www.facebook.com/flipkart",
                        "Test did not navigate to Facebook Page");
                break;
            case "Twitter":
                Assertions.assertEquals(mediaURL, "https://twitter.com/flipkart",
                        "Test did not navigate to Twitter Page");
                break;
            case "YouTube":
                Assertions.assertEquals(mediaURL, "https://www.youtube.com/flipkart",
                        "Test did not navigate to YouTube Page");
                break;
        }
    }
}