package com.training.basetest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.training.utilities.JsonReaderUtility;
import com.training.utilities.RefreshPageUtility;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WebBaseTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public RefreshPageUtility refreshPageUtility = new RefreshPageUtility();
    public SoftAssertions softAssertions;
    private RemoteWebDriver driver;
    private String execution;
    protected Map<String, String> map = new JsonReaderUtility().getMap();
    protected Map<String, Object> headerMap;
    protected io.restassured.response.Response response;

    @BeforeEach
    public void setup(TestInfo testInfo) throws MalformedURLException, NullPointerException {
        headerMap = new HashMap();
        String displayName = testInfo.getDisplayName();
        String methodName = testInfo.getTestMethod().orElseThrow().getName();
        String uuid = UUID.randomUUID().toString();

        softAssertions = new SoftAssertions();
        Configuration.timeout = Integer.parseInt(map.get("timeout"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments(map.get("browserMode"));
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.startMaximized = true;

        execution = System.getProperty("execution", map.get("executionDefault"));

        if (execution.equalsIgnoreCase("remote")) {

            DesiredCapabilities dc = new DesiredCapabilities();
            String urlToRemoteWD = map.get("remoteURL");

            dc.setCapability("testName", displayName + "-" + methodName + "-" + uuid);
            dc.setCapability("accessKey", map.get("accessKey"));
            dc.setCapability(CapabilityType.BROWSER_NAME, map.get("browserName"));
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
        }
        WebDriverRunner.closeWebDriver();
        softAssertions.assertAll();
    }
}
