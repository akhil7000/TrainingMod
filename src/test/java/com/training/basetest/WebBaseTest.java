package com.training.basetest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.training.utilities.JsonReaderUtility;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WebBaseTest extends JsonReaderUtility {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public SoftAssertions softAssertions;
    private RemoteWebDriver driver;
    String execution;
    //public JsonObject jsonObject;

    @BeforeEach
    public void setup() throws MalformedURLException, NullPointerException {

        softAssertions = new SoftAssertions();
        Configuration.timeout = Integer.parseInt(getJson("timeout"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments(getJson("browserMode"));
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.startMaximized = true;

        execution = System.getProperty("execution", getJson("executionDefault"));
        if (execution.equalsIgnoreCase("remote")) {
            final String ACCESS_KEY = getJson("accessKey");

            DesiredCapabilities dc = new DesiredCapabilities();
            String urlToRemoteWD = getJson("remoteURL");

            dc.setCapability(getJson("testName"), getJson("testDescription"));
            dc.setCapability("accessKey", ACCESS_KEY);
            dc.setCapability(CapabilityType.BROWSER_NAME, getJson("browserName"));
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