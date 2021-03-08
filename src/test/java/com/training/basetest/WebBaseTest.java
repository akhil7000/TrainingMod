package com.training.basetest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
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

public class WebBaseTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public SoftAssertions softAssertions;
    private RemoteWebDriver driver;
    String execution;
    public JsonObject jsonObject;

    @BeforeEach
    public void setup() throws MalformedURLException, NullPointerException {

        File jsonFile = new File("src/test/java/resources/testData.json");
        try {
            JsonElement fileElement = JsonParser.parseReader(new FileReader(jsonFile));
            jsonObject = fileElement.getAsJsonObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        softAssertions = new SoftAssertions();
        Configuration.timeout = Integer.parseInt(jsonObject.get("timeout").getAsString());
        ChromeOptions options = new ChromeOptions();
        options.addArguments(jsonObject.get("browserMode").getAsString());
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.startMaximized = true;

        execution = System.getProperty("execution", jsonObject.get("execution default").getAsString());
        if (execution.equalsIgnoreCase("remote")) {
            final String ACCESS_KEY = jsonObject.get("accessKey").getAsString();

            DesiredCapabilities dc = new DesiredCapabilities();
            String urlToRemoteWD = jsonObject.get("remoteURL").getAsString();

            dc.setCapability(jsonObject.get("testName").getAsString(), jsonObject.get("testDescription").getAsString());
            dc.setCapability("accessKey", ACCESS_KEY);
            dc.setCapability(CapabilityType.BROWSER_NAME, jsonObject.get("BROWSER_NAME").getAsString());
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