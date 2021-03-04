package com.training.basetest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class WebBaseTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public SoftAssertions softAssertions;
    private RemoteWebDriver driver;
    String execution;

    @BeforeEach
    public void setup() throws MalformedURLException, NullPointerException {
        softAssertions = new SoftAssertions();
        Configuration.timeout = 6000;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.startMaximized = true;

        execution = System.getProperty("execution", "local");

        if (execution.equalsIgnoreCase("remote")) {
            final String ACCESS_KEY = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51IjoyMTE3OTE0LCJ4cC5wIjoxLCJ4cC5tIjoxNjE0N" +
                    "jA0MzMzMjgyLCJleHAiOjE5Mjk5NjQzMzQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.wRLdRalhaKKVbzPJ5UtACgny340jIfcUvF2NlUYQKwU";

            DesiredCapabilities dc = new DesiredCapabilities();
            String urlToRemoteWD = "https://rccl.experitest.com/wd/hub";

            dc.setCapability("Experitest Trial", "Quick Start Chrome Browser Demo");
            dc.setCapability("accessKey", ACCESS_KEY);
            dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");
            driver = new RemoteWebDriver(new URL(urlToRemoteWD), dc);
            WebDriverRunner.setWebDriver(driver);
        } else {
            logger.info("Running in local");
        }
    }

    @AfterEach
    public void tearDown() throws NullPointerException {

        if (execution.equalsIgnoreCase("remote")) {
            logger.info("Report URL: " + driver.getCapabilities().getCapability("reportUrl"));
            WebDriverRunner.driver().close();
        }
        softAssertions.assertAll();
    }
}