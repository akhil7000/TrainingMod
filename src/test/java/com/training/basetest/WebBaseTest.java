package com.training.basetest;

import com.codeborne.selenide.Configuration;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebBaseTest {

    public SoftAssertions softAssertions;

    @BeforeEach
    public void setup() {
        softAssertions = new SoftAssertions();
        Configuration.timeout = 6000;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.startMaximized=true;
    }

    @AfterEach
    public void tearDown() {
        softAssertions.assertAll();
    }

}
